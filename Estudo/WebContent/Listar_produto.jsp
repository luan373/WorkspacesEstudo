<%@page import="br.com.estudo.entidade.Produto"%>
<%@ page
	import="br.com.estudo.negocio.*, 
	br.com.estudo.form.*, 
	br.com.estudo.entidade.BaseDados, 
	br.com.estudo.entidade.BaseDados,
	br.com.estudo.entidade.Usuario,
	br.com.estudo.exception.EstudoException,
	br.com.estudo.util.UtilBaseDados,
	br.com.estudo.util.UtilComum,
	java.util.List,
	java.text.SimpleDateFormat;"%>
<%@include file="Topo.html"%>
<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Lista de Produtos</h1>
		<h1 class="page-subhead-line">Lista contendo os Produtos
			cadastrados.</h1>
	</div>
</div>
<div class="col-md-12">
	<!--    Striped Rows Table  -->
	<div class="panel panel-default">
		<div class="panel-heading">Produtos</div>
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
							<th>#</th>
						</tr>
					</thead>
					<tbody>
						<%
							BaseDados baseDados = UtilBaseDados.recuperaBaseDados();
							List<Produto> lista = baseDados.getListaProdutos();

							for (Produto produto : lista) {
						%>
						<tr>
							<td><%=produto.getIdProduto()%></td>

							<td><%=produto.getNomeProduto()%></td>
							<td><%=produto.getDescricao()%></td>
							<td><%=produto.getValor()%></td>
							<td><%=produto.getQntEstoque()%></td>
							<td>
								<%
									if (produto.getAtivo()) {
											out.println("Sim");
										} else {
											out.println("Não");
										}
								%>
							</td>
							<td>
								<%
									SimpleDateFormat dataBR = new SimpleDateFormat("dd/MM/yyyy");
										out.println(dataBR.format(produto.getDataCadastro()));
								%>
							</td>
							<td><a
								href="Alterar_produto.jsp?IdProduto=<%=produto.getIdProduto()%>"><button
										class="btn btn-primary">Alterar</button></a></td>
							<td>
								<%
									//Eita treta
								%>
								<button class="btn btn-danger" data-toggle="modal"
									data-target="#myModal">Excluir</button>
								<div class="panel-body">
									<div class="modal fade" id="myModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">×</button>
													<h4 class="modal-title" id="myModalLabel">Confirmação</h4>
												</div>
												<div class="modal-body">Tem certeza que deseja excluir
													o registro?</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Fechar</button>
													<a
														href="Resultado_excluir.jsp?IdProduto=<%=produto.getIdProduto()%>">
														<button type="button" class="btn btn-primary">Confirmar</button>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>

				</table>
				<a href="index.jsp" class="btn btn-info">Voltar</a>
			</div>
		</div>
	</div>
	<!--  End  Striped Rows Table  -->
</div>

<%@include file="Fundo.html"%>

