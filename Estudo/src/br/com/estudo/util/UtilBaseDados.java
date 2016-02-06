package br.com.estudo.util;

import java.io.IOException;
import java.util.List;

import javax.swing.text.html.ListView;

import br.com.estudo.entidade.BaseDados;
import br.com.estudo.entidade.Produto;
import br.com.estudo.entidade.Usuario;

import com.thoughtworks.xstream.XStream;

public class UtilBaseDados {

	public static BaseDados recuperaBaseDados() throws IOException {
		String pathBaseDados = UtilComum.recuperarPropriedadeEstudoApp("pathBaseDados");
		String xmlArquivo = UtilComum.recuperarTextoArquivo(pathBaseDados);
		XStream xstream = new XStream();
		BaseDados baseDados = (BaseDados) xstream.fromXML(xmlArquivo);
		return baseDados;
	}

	public static void gravaBaseDados(BaseDados baseDados) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("br.com.estudo.entidade.BaseDados", BaseDados.class);
		String xml = xstream.toXML(baseDados);
		String pathBaseDados = UtilComum.recuperarPropriedadeEstudoApp("pathBaseDados");
		UtilComum.gravarArquivo(xml.getBytes(), pathBaseDados);
	}

	public static Integer recuperaProxIdUsuario() throws IOException {
		Integer proxIdUsuario = 0;

		List<Usuario> listaUsuarios = recuperaBaseDados().getListaUsuarios();

		if (listaUsuarios.size() > 0) {
			for (Usuario usuario : listaUsuarios) {
				if (usuario.getIdUsuario() > proxIdUsuario) {
					proxIdUsuario = usuario.getIdUsuario();
				}
			}
		}

		proxIdUsuario++;

		return proxIdUsuario;
	}
	
	public static Integer recuperaProxIdProduto() throws IOException {
		Integer proxIdProduto = 0;
		
		List<Produto> listaProdutos = recuperaBaseDados().getListaProdutos();
		
		if(listaProdutos.size() > 0) {
			for (Produto produto : listaProdutos) {
				if (produto.getIdProduto() > proxIdProduto){
				proxIdProduto = produto.getIdProduto();
				}
			}
		}
		proxIdProduto++;
		
		return proxIdProduto;
	}

	public static Boolean recuperaNomeUsuario(String NomeUsuario) throws IOException {
		boolean usuarioExistente = false;

		List<Usuario> listaUsuarios = recuperaBaseDados().getListaUsuarios();
		if (listaUsuarios.size() > 0) {
			for (Usuario usuario : listaUsuarios) {
				if (usuario.getUsuario() != null && usuario.getUsuario().equals(NomeUsuario)) {
					usuarioExistente = true;
				}
			}
		}

		return usuarioExistente;
	}

	public static Boolean recuperaNomeProduto(String nomeProduto) throws IOException {
		boolean produtoExistente = false;

		List<Produto> listaProdutos = recuperaBaseDados().getListaProdutos();
		if (listaProdutos.size() > 0) {
			for (Produto produto : listaProdutos) {
				if (produto.getNomeProduto() != null && produto.getNomeProduto().equals(nomeProduto)) {
					produtoExistente = true;
				}
			}
		}
		return produtoExistente;
	}

}
