package com.ifsp.hto.carinho.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.security.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.hto.carinho.backend.model.Login;
import com.ifsp.hto.carinho.backend.model.TipoUsuario;
import com.ifsp.hto.carinho.backend.repository.LoginRepository;
import com.ifsp.hto.carinho.backend.util.MD5;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginResource {

	@Autowired(required = true)
	LoginRepository loginRepository;

	@GetMapping("login/{id}")
	public Login listaLogin(@PathVariable(value = "id") long id) {
		return loginRepository.findById(id);
	}
	/*
	@GetMapping("login/{id}/{id2}")
	public Login validar(@PathVariable(value = "id") String nome, @PathVariable(value ="id2") String senha) {
		return loginRepository.validarUsuario(nome, senha);
	}
	*/
	
	@PostMapping("/login")
	public Login autenticar(String nome, String senha) throws NoSuchAlgorithmException {
		
		 String senhaCriptografada = MD5.stringToMD5(senha);  
		 System.out.println(senhaCriptografada);
		
		Login resultLogin = loginRepository.validarUsuario(nome,  senhaCriptografada);	
		if (resultLogin!= null) {
			
						
			return resultLogin; 
		}else {
			return null;
		}
	}
	
	@PostMapping("/cadastrarPerfil")
	public Login cadastrar( String usuario, String senha, String email, TipoUsuario perfil, String nome) throws NoSuchAlgorithmException {
		
		
		 String senhaCriptografada = MD5.stringToMD5(senha);  
		 System.out.println(senhaCriptografada);
		
		Login login = new Login(nome, perfil, usuario,senhaCriptografada , email);
		
		return loginRepository.save(login);
	}
	
		

}
