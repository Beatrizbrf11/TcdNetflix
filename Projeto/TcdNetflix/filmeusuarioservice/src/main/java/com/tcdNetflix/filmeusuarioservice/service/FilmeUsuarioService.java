package com.tcdNetflix.filmeusuarioservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mysql.cj.MessageBuilder;
import com.tcdNetflix.filmeusuarioservice.entity.Filme;
import com.tcdNetflix.filmeusuarioservice.entity.FilmeUsuario;
import com.tcdNetflix.filmeusuarioservice.entity.Usuario;
import com.tcdNetflix.filmeusuarioservice.repository.FilmeUsuarioRepository;
import com.tcdNetflix.filmeusuarioservice.vo.FilmeUsuarioVO;

@Service
@EnableBinding(Source.class)
public class FilmeUsuarioService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private FilmeUsuarioRepository repository;

	@Autowired
	private Source source;

	private void ValidarUsuario(int idUsuario) {
		try {
			getUsuario(idUsuario);
		} catch (Exception ex) {
			throw new RuntimeException("Usuario não existe");
		}
	}

	private void ValidarFilme(int idFilme) {
		try {
			getFilme(idFilme);
		} catch (Exception ex) {
			throw new RuntimeException("Filme não existe");
		}
	}

	private Usuario getUsuario(int id) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/usuarioservice/usuario/%s", getServiceInstanceURI("usuarioservice"), id);
		ResponseEntity<Usuario> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Usuario.class, id);
		return restExchange.getBody();
	}

	private Filme getFilme(int id) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/filmeservice/%s", getServiceInstanceURI("filmeservice"), id);
		ResponseEntity<Filme> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Filme.class, id);
		return restExchange.getBody();
	}

	private Filme[] getFilmes(List<Integer> ids) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/filmeservice/filmes/", getServiceInstanceURI("filmeservice"));
		ResponseEntity<Filme[]> restExchange = restTemplate.postForEntity(uri, ids, Filme[].class);

		return restExchange.getBody();
	}

	private void setFilmeVisto(int idFilme) {
		Filme filme = getFilme(idFilme);
		source.output().send(org.springframework.integration.support.MessageBuilder.withPayload(filme).build());
	}

	private String getServiceInstanceURI(String serviceName) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		if (instances.size() == 0) {
			throw new RuntimeException(serviceName);
		} else {
			return instances.get(0).getUri().toString();
		}
	}

	public String Favoritar(FilmeUsuarioVO filmeUsuario) {

		try {
			ValidarUsuario(filmeUsuario.getIdUsuario());
			ValidarFilme(filmeUsuario.getIdFilme());

			FilmeUsuario entidade = repository.findByIdUsuarioAndIdFilme(filmeUsuario.getIdUsuario(),
					filmeUsuario.getIdFilme());

			if (entidade != null) {
				if (entidade.getFavorito() == true) {
					return "Filme já favoritado por este usuário.";
				} else {
					entidade = new FilmeUsuario(filmeUsuario.getIdUsuario(), filmeUsuario.getIdFilme(), true, false,
							false);
				}
			} else {
				entidade = new FilmeUsuario(filmeUsuario.getIdUsuario(), filmeUsuario.getIdFilme(), true, false, false);
			}

			repository.save(entidade);

			return "Favorito salvo com sucesso";

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao salvar favorito: " + ex);
		}
	}

	public List<Filme> Favoritos(int idUsuario) {

		try {

			List<FilmeUsuario> filmesUsuario = repository.findAllByIdUsuarioAndFavoritoTrue(idUsuario);
			List<Integer> idFilmes = new ArrayList<Integer>();
			filmesUsuario.forEach((n) -> {
				idFilmes.add(n.getIdFilme());
			});

			List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(getFilmes(idFilmes)));
			return filmes;

		} catch (Exception ex) {

			throw new RuntimeException("Erro ao listar favoritos:" + ex.getMessage());
		}
	}

	public String CriarJaVisto(FilmeUsuarioVO filmeUsuario) {
		try {
			ValidarUsuario(filmeUsuario.getIdUsuario());
			ValidarFilme(filmeUsuario.getIdFilme());

			FilmeUsuario entidade = repository.findByIdUsuarioAndIdFilme(filmeUsuario.getIdUsuario(),
					filmeUsuario.getIdFilme());
			if (entidade != null) {
				if (entidade.getJaVisto() == true) {
					return "Filme já foi marcado como visto";
				} else {
					entidade = new FilmeUsuario(filmeUsuario.getIdUsuario(), filmeUsuario.getIdFilme(), false, true,
							false);
				}
			} else {
				entidade = new FilmeUsuario(filmeUsuario.getIdUsuario(), filmeUsuario.getIdFilme(), false, true, false);
			}

			setFilmeVisto(filmeUsuario.getIdFilme());

			repository.save(entidade);

			return "Já visto salvo com sucesso";

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao salvar já visto: " + ex);
		}
	}

	public List<Filme> ListarJaVisto(int idUsuario) {
		try {
			List<FilmeUsuario> filmesUsuario = repository.findAllByIdUsuarioAndJaVistoTrue(idUsuario);
			List<Integer> idFilmes = new ArrayList<Integer>();
			filmesUsuario.forEach((n) -> {
				idFilmes.add(n.getIdFilme());
			});

			List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(getFilmes(idFilmes)));
			return filmes;

		} catch (Exception ex) {

			throw new RuntimeException("Erro ao listar já vistos:" + ex.getMessage());
		}
	}

	public String CriarVerDepois(FilmeUsuarioVO filmeUsuario) {
		try {
			ValidarUsuario(filmeUsuario.getIdUsuario());
			ValidarFilme(filmeUsuario.getIdFilme());

			FilmeUsuario entidade = repository.findByIdUsuarioAndIdFilme(filmeUsuario.getIdUsuario(),
					filmeUsuario.getIdFilme());

			if (entidade != null) {
				if (entidade.getVerDepois() == true) {
					return "Filme já foi marcado como ver depois";
				} else {
					entidade = new FilmeUsuario(filmeUsuario.getIdUsuario(), filmeUsuario.getIdFilme(), false, false,
							true);
				}
			} else {
				entidade = new FilmeUsuario(filmeUsuario.getIdUsuario(), filmeUsuario.getIdFilme(), false, false, true);
			}

			repository.save(entidade);

			return "Ver depois salvo com sucesso";

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao salvar ver depois: " + ex);
		}
	}

	public List<Filme> ListarVerDepois(int idUsuario) {
		try {
			List<FilmeUsuario> filmesUsuario = repository.findAllByIdUsuarioAndVerDepoisTrue(idUsuario);
			List<Integer> idFilmes = new ArrayList<Integer>();
			filmesUsuario.forEach((n) -> {
				idFilmes.add(n.getIdFilme());
			});

			List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(getFilmes(idFilmes)));
			return filmes;

		} catch (Exception ex) {

			throw new RuntimeException("Erro ao listar ver depois:" + ex.getMessage());
		}
	}
}
