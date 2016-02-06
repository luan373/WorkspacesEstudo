<%@ page import="br.com.estudo.negocio.UsuarioNeg, br.com.estudo.form.*"%>
<%@include file="Topo.html"%>


<%
	UsuarioForm form = new UsuarioForm();
	
	form.setNomeCompleto(request.getParameter("nomeCompleto"));
	form.setDataNascimento(request.getParameter("dataNascimento"));
	form.setEmail(request.getParameter("email"));	
	form.setSexo(request.getParameter("sexo"));
	form.setCpf(request.getParameter("cpf"));
	form.setUsuario(request.getParameter("usuario"));
	form.setSenha(request.getParameter("senha"));
	form.setAtivo(request.getParameter("ativo"));
	
	UsuarioNeg negocio = new UsuarioNeg();
	RetornoForm resultado = negocio.inserirUsuario(form);
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
Usuário cadastrado com sucesso!
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
				<a href="Cadastrar_usuario.jsp" class="btn btn-info">Voltar</a>
			</div>
		</div>
	</div>
	<!--  End  Striped Rows Table  -->
</div>

<%@include file="Fundo.html"%>

