package br.com.estudo.principal;

import java.io.IOException;
import java.util.Date;

import br.com.estudo.entidade.BaseDados;
import br.com.estudo.entidade.Produto;
import br.com.estudo.util.UtilBaseDados;

public class PrincipalProduto {
	public static void main (String args[]) throws IOException {
		// Converter Data
					Date dataHoje = new Date();

					// Joga form para a Classe Usuario
					Produto novoProduto = new Produto();
					novoProduto.setAtivo(true);
					novoProduto.setDataCadastro(dataHoje);
					novoProduto.setDescricao("descrição");
					novoProduto.setIdProduto(5);
					novoProduto.setNomeProduto("Produto");
					novoProduto.setQntEstoque(5);
					novoProduto.setValor(5);

					BaseDados base = UtilBaseDados.recuperaBaseDados();
					base.getListaProdutos().add(novoProduto);
					//UtilBaseDados.gravaBaseDados(base);
	}
}
