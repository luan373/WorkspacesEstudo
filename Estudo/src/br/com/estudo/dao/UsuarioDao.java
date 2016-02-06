package br.com.estudo.dao;

import java.io.IOException;

import br.com.estudo.entidade.Usuario;

public class UsuarioDao extends EstudoDaoAbstract {
	
	public UsuarioDao() throws IOException {
		super.verificaBaseDados();
	}
	
	public void inserirUsuario(Usuario usuario) {
		
	}
	
}
