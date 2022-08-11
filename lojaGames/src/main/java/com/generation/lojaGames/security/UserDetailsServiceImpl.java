package com.generation.lojaGames.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojaGames.model.Usuario;
import com.generation.lojaGames.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario(userName);

		if (usuario.isPresent())
			return new UserDetailsImpl(usuario.get());
		else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
	
//O Método loadUserByUsername(String username) recebe o usuário através da tela de login do sistema e utiliza a Query Method findByUsuario(String usuario), 
//implementada na Interface UsuarioRepository, para checar se o usuário digitado está persistido no Banco de dados.
//Caso esteja persistido (isPresent()), ele executa o construtor da Classe UserDetailsImpl,
//passando o Objeto usuario como parâmetro. Observe que foi utilizado Método get() no Objeto usuario por se tratar de um Optional.

//Caso o usuário não exista, será devolvido o HTTP Status 403 - FORBIDDEN
//(Acesso Proibido - você está tentando alcançar um endereço ou um site ao qual está proibido de acessar).
}
