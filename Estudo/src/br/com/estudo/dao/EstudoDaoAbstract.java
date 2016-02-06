package br.com.estudo.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import br.com.estudo.entidade.BaseDados;
import br.com.estudo.entidade.Usuario;
import br.com.estudo.util.UtilBaseDados;
import br.com.estudo.util.UtilComum;

public abstract class EstudoDaoAbstract {
	
	private BaseDados baseDados;
	
	protected void verificaBaseDados() throws IOException {

		if (this.baseDados == null) {
			if (!this.existsArquivoBaseDados()) {
				this.geraArquivoBaseDados();
			}
		}
		
		this.recuperaBaseDados();
	}
	
	private void recuperaBaseDados() throws IOException {
		UtilBaseDados.recuperaBaseDados();
	}

	private void geraArquivoBaseDados() throws IOException {
		// TODO Auto-generated method stub
		BaseDados baseDados = new BaseDados();
		baseDados.setListaUsuarios(new ArrayList<Usuario>());
		UtilBaseDados.gravaBaseDados(baseDados);
	}
	
	private boolean existsArquivoBaseDados() throws IOException {
		File f = new File(UtilComum.recuperarPropriedadeEstudoApp("pathBaseDados"));
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		}
		
		return false;
	}

	public BaseDados getBaseDados() {
		return baseDados;
	}

	public void setBaseDados(BaseDados baseDados) {
		this.baseDados = baseDados;
	}
	
}
