<%@page import="br.com.estudo.negocio.ProdutoNeg"%>
<%@ page import="br.com.estudo.form.*"%>
<%@include file="Topo.html"%>


<%
	ProdutoForm form = new ProdutoForm();

	form.setNomeProduto(request.getParameter("nomeProduto"));
	form.setDescricao(request.getParameter("descricao"));
	form.setValor(request.getParameter("valor"));
	form.setQntEstoque(request.getParameter("qntEstoque"));

	ProdutoNeg negocio = new ProdutoNeg();
	RetornoForm resultado = negocio.inserirProduto(form);
%>


<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Lista de usuários</h1>
		<h1 class="page-subhead-line">Lista contendo os usuário
			cadastrados.</h1>
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

<div class="alert alert-success">Produto cadastrado com sucesso!</div>
<div class="col-md-12">
	<!--    Striped Rows Table  -->
	<div class="panel panel-default">
		<div class="panel-heading">Produtos</div>
		<div class="panel-body">



			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nome do Produto</th>
							<th>Descrição</th>
							<th>Valor</th>
							<th>Quantidade em Estoque</th>
							<th>Ativo</th>
						</tr>
					</thead>
					<tbody>
						<tr>							
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
									//Ativo
										out.println("Sim");
								%>
							</td>
						</tr>
					</tbody>

				</table>

				<%
					}
				%>
				<a href="Cadastrar_produto.jsp" class="btn btn-info">Voltar</a>
			</div>
		</div>
	</div>
	<!--  End  Striped Rows Table  -->
</div>

<%@include file="Fundo.html"%>

