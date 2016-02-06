package br.com.estudo.negocio;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.estudo.entidade.BaseDados;
import br.com.estudo.entidade.Produto;
import br.com.estudo.entidade.Usuario;
import br.com.estudo.exception.EstudoException;
import br.com.estudo.form.ProdutoForm;
import br.com.estudo.form.RetornoForm;
import br.com.estudo.util.UtilBaseDados;
import br.com.estudo.util.UtilComum;

public class ProdutoNeg {
	public RetornoForm inserirProduto(ProdutoForm form) throws IOException, ParseException, EstudoException {
		RetornoForm resultado = new RetornoForm();
		resultado.setSucesso(false);
		resultado.setObservacoes("");

		// valida se os campos obrigatórios foram preenchidos
		if (form.getNomeProduto().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes() + "<li>O campo Nome do Produto é obrigatório.</li>");
		}
		if (form.getValor().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes() + "<li>O campo Valor é obrigatório.</li>");
		}
		if (form.getQntEstoque().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes() + "<li>O campo Quantidade Estoque é obrigatório.</li>");
		}

		// valida se o valor é número
		boolean valorValido = UtilComum.validarValor(form.getValor());
		if (valorValido == false) {
			resultado.setObservacoes(
					resultado.getObservacoes() + "<li>A informação inserida no campo Valor é inválida.</li>");
		}

		// Valida se a quantidade de estoque é número
		boolean qntValido = UtilComum.validarValor(form.getQntEstoque());
		if (qntValido == false) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>A informação inserida no campo Quantidade Estoque é inválida.</li>");
		}

		// Valida se já existe um produto cadastrado
		boolean proxIdProduto = false;
		proxIdProduto = UtilBaseDados.recuperaNomeProduto(form.getNomeProduto());
		if (proxIdProduto == true) {
			resultado.setObservacoes(
					resultado.getObservacoes() + "<li>Nome do Produto já cadastrado. Favor informar outro nome.</li>");
		}

		// se o resultado está vazio, significa que ele nao tem erro.
		if (resultado.getObservacoes().equals("")) {
			// Converter Data
			Date dataHoje = new Date();

			// Joga form para a Classe Usuario
			Produto novoProduto = new Produto();
			novoProduto.setAtivo(true);
			novoProduto.setDataCadastro(dataHoje);
			novoProduto.setDescricao(form.getDescricao());
			novoProduto.setIdProduto(UtilBaseDados.recuperaProxIdProduto());
			novoProduto.setNomeProduto(form.getNomeProduto());
			novoProduto.setQntEstoque(Integer.parseInt(form.getQntEstoque()));
			novoProduto.setValor(Double.parseDouble(form.getValor()));

			BaseDados base = UtilBaseDados.recuperaBaseDados();
			base.getListaProdutos().add(novoProduto);
			UtilBaseDados.gravaBaseDados(base);
			resultado.setObservacoes("<li>Produto adicionado com sucesso.</li>");
			resultado.setSucesso(true);
		}

		resultado.setObservacoes("<ul>" + resultado.getObservacoes() + "</ul>");
		return resultado;

	}

	public RetornoForm alterarProduto(ProdutoForm form) throws IOException {
		RetornoForm resultado = new RetornoForm();
		resultado.setSucesso(false);
		resultado.setObservacoes("");

		// valida se os campos obrigatórios foram preenchidos
		if (form.getNomeProduto().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes() + "<li>O campo Nome do Produto é obrigatório.</li>");
		}
		if (form.getValor().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes() + "<li>O campo Valor é obrigatório.</li>");
		}
		if (form.getQntEstoque().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes() + "<li>O campo Quantidade Estoque é obrigatório.</li>");
		}

		// valida se o valor é número
		boolean valorValido = UtilComum.validarValor(form.getValor());
		if (valorValido == false) {
			resultado.setObservacoes(
					resultado.getObservacoes() + "<li>A informação inserida no campo Valor é inválida.</li>");
		}

		// Valida se a quantidade de estoque é número
		boolean qntValido = UtilComum.validarValor(form.getQntEstoque());
		if (qntValido == false) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>A informação inserida no campo Quantidade Estoque é inválida.</li>");
		}

		// Valida se já existe um produto cadastrado
		/*boolean proxIdProduto = false;
		proxIdProduto = UtilBaseDados.recuperaNomeProduto(form.getNomeProduto());
		if (proxIdProduto == true) {
			resultado.setObservacoes(
					resultado.getObservacoes() + "<li>Nome do Produto já cadastrado. Favor informar outro nome.</li>");
		}*/

		// se o resultado está vazio, significa que ele nao tem erro.
		if (resultado.getObservacoes().equals("")) {
			
			int idProtudo = Integer.parseInt(form.getIdProduto());
			BaseDados basedDados = UtilBaseDados.recuperaBaseDados();
			
			Produto produtoAlterado = this.recuperarProduto(idProtudo, basedDados.getListaProdutos());
			
			// Joga form para a Classe Usuario
			produtoAlterado.setAtivo(true);
			produtoAlterado.setDescricao(form.getDescricao());
			produtoAlterado.setNomeProduto(form.getNomeProduto());
			produtoAlterado.setQntEstoque(Integer.parseInt(form.getQntEstoque()));
			produtoAlterado.setValor(Double.parseDouble(form.getValor()));

			UtilBaseDados.gravaBaseDados(basedDados);
			resultado.setObservacoes("<li>Produto adicionado com sucesso.</li>");
			resultado.setSucesso(true);
		}

		return resultado;

	}
	
	public Produto recuperarProduto(int idProduto){
		Produto produto = new Produto();
		produto.setIdProduto(idProduto);
		return produto;
	}
	
	public Produto recuperarProduto(int idProduto, List<Produto> listaProdutos) {
		Produto produto = null;

		for (Produto produtoLista : listaProdutos) {
			if (produtoLista.getIdProduto().equals(idProduto)) {
				produto = produtoLista;
			}
		}

		return produto;
	}
}
