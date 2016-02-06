
<%@page import="br.com.estudo.negocio.ProdutoNeg"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.nio.channels.GatheringByteChannel"%>
<%@page
	import="br.com.estudo.entidade.Produto,
	br.com.estudo.negocio.UsuarioNeg, 
	br.com.estudo.form.*, 
	br.com.estudo.entidade.BaseDados,
	br.com.estudo.exception.EstudoException,
	br.com.estudo.negocio.UsuarioNeg,
	br.com.estudo.util.UtilBaseDados,
	br.com.estudo.util.UtilComum,
	java.util.List,
	java.text.SimpleDateFormat,
	java.util.Date;"%>
<%@include file="Topo.html"%>
<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Alterar Produto</h1>
		<h1 class="page-subhead-line">Tela para realizar alteração de um
			produto</h1>
	</div>
</div>
<!-- /. ROW  -->
<div class="row">
	<div class="col-md-6 col-sm-6 col-xs-12">
		<div class="panel panel-info">
			<div class="panel-heading">Preencha os campos</div>

			<%
				String idProdutoStr = request.getParameter("IdProduto");
				Integer idProduto = Integer.parseInt(idProdutoStr);

				BaseDados baseDados = UtilBaseDados.recuperaBaseDados();
				List<Produto> lista = baseDados.getListaProdutos();
				Produto produtoAlterado = new ProdutoNeg().recuperarProduto(idProduto, lista);

				SimpleDateFormat dataBR = new SimpleDateFormat("dd/MM/yyyy");
				//String dataNascimento = dataBR.format(valorDataNascimento);
			%>
			<div class="panel-body">
				<form role="form" action="Resultado_edicaoProduto.jsp" method="post">
					<input type="hidden" name="idProduto" value='<%=idProduto%>'>
					<div class="form-group">
						<label>Nome Produto</label> <input class="form-control"
							type="text" name="nomeProduto"
							value='<%=produtoAlterado.getNomeProduto()%>'>
					</div>
					<div class="form-group">
						<label>Descrição</label> <input class="form-control" type="text"
							name="descricao" value='<%=produtoAlterado.getDescricao()%>'>
					</div>
					<div class="form-group">
						<label>Valor</label> <input class="form-control" type="text"
							name="valor" value='<%=produtoAlterado.getValor()%>'>
					</div>
					<div class="form-group">
						<label>Quantidade de Estoque</label> <input class="form-control"
							type="text" name="qntEstoque"
							value='<%=produtoAlterado.getQntEstoque()%>'>
					</div>

					<button type="submit" class="btn btn-info">Salvar</button>

				</form>
				<%
					//}
				%>
			</div>
		</div>
	</div>
</div>

<!--/.ROW-->

<%@include file="Fundo.html"%>

