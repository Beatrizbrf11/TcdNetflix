package com.tcdNetflix.chamadoservice.service;

import java.util.List;

import org.apache.tomcat.util.net.WriteBuffer.Sink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcdNetflix.chamadoservice.entity.Chamado;
import com.tcdNetflix.chamadoservice.entity.Usuario;
import com.tcdNetflix.chamadoservice.repository.ChamadoRepository;
import com.tcdNetflix.chamadosservice.vo.ChamadoVO;

@Service
@EnableBinding(Sink.class)
public class ChamadoService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private ChamadoRepository repository;

	public Chamado CriarChamado(ChamadoVO chamadoVO) {

		try {
			ValidarUsuario(chamadoVO.getIdUsuario());

			Chamado chamado = new Chamado(chamadoVO.getIdUsuario(), chamadoVO.getTitulo(), chamadoVO.getDescricao(), 1);
			chamado.setStatus(1);// 1 Novo
			repository.save(chamado);
			return chamado;
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao incluir um chamado: " + ex.getMessage());
		}
	}

	private void ValidarUsuario(int idUsuario) {
		try {
			getUsuario(idUsuario);
		} catch (Exception ex) {

			throw new RuntimeException("Usuario não existe: " + idUsuario + " teste " + ex);
		}
	}

	private Usuario getUsuario(int id) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/usuarioservice/usuario/%s", getServiceInstanceURI("usuarioservice"), id);
		ResponseEntity<Usuario> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Usuario.class, id);
		return restExchange.getBody();
	}

	private String getServiceInstanceURI(String serviceName) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		if (instances.size() == 0) {
			throw new RuntimeException(serviceName);
		} else {
			return instances.get(0).getUri().toString();
		}
	}

	public List<Chamado> ListarChamados() {
		return repository.findAll();
	}
}
