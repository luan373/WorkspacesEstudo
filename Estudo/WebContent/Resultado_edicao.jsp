<%@ page import="br.com.estudo.negocio.UsuarioNeg, br.com.estudo.form.*"%>
<%@include file="Topo.html"%>


<%
	UsuarioForm AlteraUsuario = new UsuarioForm();
	
	AlteraUsuario.setNomeCompleto(request.getParameter("nomeCompleto"));
	AlteraUsuario.setDataNascimento(request.getParameter("dataNascimento"));
	AlteraUsuario.setEmail(request.getParameter("email"));	
	AlteraUsuario.setSexo(request.getParameter("sexo"));
	AlteraUsuario.setCpf(request.getParameter("cpf"));
	AlteraUsuario.setUsuario(request.getParameter("usuario"));
	AlteraUsuario.setSenha(request.getParameter("senha"));
	AlteraUsuario.setAtivo(request.getParameter("ativo"));
	AlteraUsuario.setIdUsuario(request.getParameter("idUsuario"));
	
	UsuarioNeg negocio = new UsuarioNeg();
	RetornoForm resultado = negocio.alterarUsuario(AlteraUsuario);
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
            <%out.println(resultado.getObservacoes());%>
        </div>
		
		<%
	} else {
%>

<div class="alert alert-success">
Usuário alterado com sucesso!
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
							<th>Nome Completo</th>
							<th>Data de Nascimento</th>
							<th>E-mail</th>
							<th>Sexo</th>
							<th>CPF</th>
							<th>Usuário</th>
							<th>Senha</th>
							<th>Ativo</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<%
									String nomeCompleto = request.getParameter("nomeCompleto");
										out.println(nomeCompleto);
								%>
							</td>
							<td>
								<%
									String dataNascimento = request.getParameter("dataNascimento");
										out.println(dataNascimento);
								%>
							</td>
							<td>
								<%
									String email = request.getParameter("email");
										out.println(email);
								%>
							</td>
							<td>
								<%
									String sexo = request.getParameter("sexo");
										out.println(sexo);
								%>
							</td>
							<td>
								<%
									String cpf = request.getParameter("cpf");
										out.println(cpf);
								%>
							</td>
							<td>
								<%
									String usuario = request.getParameter("usuario");
										out.println(usuario);
								%>
							</td>
							<td>
								<%
									String senha = request.getParameter("senha");
										out.println(senha);
								%>
							</td>
							<td>
								<%
									String ativo = request.getParameter("ativo");
										out.println("Sim");
								%>
							</td>
						</tr>
					</tbody>

				</table>

				<%
					}
				%>
				<a href="Listar_usuario.jsp" class="btn btn-info">Voltar</a>
			</div>
		</div>
	</div>
	<!--  End  Striped Rows Table  -->
</div>

<%@include file="Fundo.html"%>

