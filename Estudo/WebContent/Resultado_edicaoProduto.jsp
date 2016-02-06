<%@page import="br.com.estudo.negocio.ProdutoNeg"%>
<%@ page import="br.com.estudo.negocio.UsuarioNeg, br.com.estudo.form.*"%>
<%@include file="Topo.html"%>


<%
	ProdutoForm alteraProduto = new ProdutoForm();

	alteraProduto.setIdProduto(request.getParameter("idProduto"));
	alteraProduto.setNomeProduto(request.getParameter("nomeProduto"));
	alteraProduto.setDescricao(request.getParameter("descricao"));
	alteraProduto.setQntEstoque(request.getParameter("qntEstoque"));
	alteraProduto.setValor(request.getParameter("valor"));
	alteraProduto.setAtivo(request.getParameter("ativo"));
	alteraProduto.setDataCadastro(request.getParameter("dataCadastro"));

	ProdutoNeg negocio = new ProdutoNeg();
	RetornoForm resultado = negocio.alterarProduto(alteraProduto);
%>


<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Protudo</h1>
		<h1 class="page-subhead-line"></h1>
	</div>
</div>
<%
	if (resultado.getSucesso() == false) {
%>
<div class="alert alert-danger">
	<%
		out.println(resultado.getObservacoes());
	%>
</div>

<%
	} else {
%>

<div class="alert alert-success">Usuário alterado com sucesso!</div>
<div class="col-md-12">
	<!--    Striped Rows Table  -->
	<div class="panel panel-default">
		<div class="panel-heading">Usuários</div>
		<div class="panel-body">



			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID Produto</th>
							<th>Nome do Produto</th>
							<th>Descrição</th>
							<th>Valor</th>
							<th>Quantidade em Estoque</th>
							<th>Ativo</th>
							<th>Data de Cadastro</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<%
									String nomeCompleto = request.getParameter("idProduto");
										out.println(nomeCompleto);
								%>
							</td>
							<td>
								<%
									String nomeProduto = request.getParameter("nomeProduto");
										out.println(nomeProduto);
								%>
							</td>
							<td>
								<%
									String descricao = request.getParameter("descricao");
										out.println(descricao);
								%>
							</td>
							<td>
								<%
									String valor = request.getParameter("valor");
										out.println(valor);
								%>
							</td>
							<td>
								<%
									String qntEstoque = request.getParameter("qntEstoque");
										out.println(qntEstoque);
								%>
							</td>
							<td>
								<%
									String ativo = request.getParameter("ativo");
										out.println("Sim");
								%>
							</td>
							<td>
								<%
									String dataCadastro = request.getParameter("dataCadastro");
										out.println(dataCadastro);
								%>
							</td>
						</tr>
					</tbody>

				</table>

				<%
					}
				%>
				<a href="Listar_produto.jsp" class="btn btn-info">Voltar</a>
			</div>
		</div>
	</div>
	<!--  End  Striped Rows Table  -->
</div>

<%@include file="Fundo.html"%>

