<%@ page
	import="br.com.estudo.negocio.UsuarioNeg, 
	br.com.estudo.form.*, 
	br.com.estudo.entidade.BaseDados, 
	br.com.estudo.entidade.BaseDados,
	br.com.estudo.entidade.Usuario,
	br.com.estudo.exception.EstudoException,
	br.com.estudo.negocio.UsuarioNeg,
	br.com.estudo.util.UtilBaseDados,
	br.com.estudo.util.UtilComum,
	java.util.List,
	java.text.SimpleDateFormat;"%>
<%@include file="Topo.html"%>
<div class="row">
	<div class="col-md-12">
		<h1 class="page-head-line">Lista de usuários</h1>
		<h1 class="page-subhead-line">Lista contendo os usuário
			cadastrados.</h1>
	</div>
</div>
<div class="col-md-12">
	<!--    Striped Rows Table  -->
	<div class="panel panel-default">
		<div class="panel-heading">Usuários</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome Completo</th>
							<th>Data de Nascimento</th>
							<th>E-mail</th>
							<th>Sexo</th>
							<th>CPF</th>
							<th>Usuário</th>
							<th>Senha</th>
							<th>Ativo</th>
							<th>#</th>
						</tr>
					</thead>
					<tbody>
						<%
							BaseDados baseDados = UtilBaseDados.recuperaBaseDados();
							List<Usuario> lista = baseDados.getListaUsuarios();

							for (Usuario usuario : lista) {
						%>
						<tr>
							<td><%=usuario.getIdUsuario()%></td>

							<td><%=usuario.getNomeCompleto()%></td>
							<td>
								<%
									SimpleDateFormat dataBR = new SimpleDateFormat("dd/MM/yyyy");
										out.println(dataBR.format(usuario.getDataNascimento()));
								%>
							</td>
							<td><%=usuario.getEmail()%></td>
							<td>
								<%
									if (usuario.getSexo() == true) {
											out.println("Homem");
										} else {
											out.println("Mulher");
										}
								%>
							</td>
							<td><%=usuario.getCpf()%></td>
							<td><%=usuario.getUsuario()%></td>
							<td><%=usuario.getSenha()%></td>
							<td>
								<%
									if (usuario.getAtivo() == true) {
											out.println("Ativo");
										} else {
											out.println("Inativo");
										}
								%>
							</td>
							<td><a
								href="Alterar_usuario.jsp?IdUsuario=<%=usuario.getIdUsuario()%>"><button
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
														href="Resultado_excluir.jsp?IdUsuario=<%=usuario.getIdUsuario()%>">
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

