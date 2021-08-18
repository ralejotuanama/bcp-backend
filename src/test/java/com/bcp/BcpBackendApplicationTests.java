package com.bcp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bcp.model.Usuario;
import com.bcp.repo.IUsuarioRepo;

@SpringBootTest
class BcpBackendApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	void verificarClave() {
		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setUsername("ronald152515@bcp.com");
		us.setPassword(bcrypt.encode("123"));
				
		us.setEnabled(true);
		
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
		
		
	}

}
