
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.nio.channels.GatheringByteChannel"%>
<%@page
	import="br.com.estudo.entidade.Usuario,
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
		<h1 class="page-head-line">Alterar Usuário</h1>
		<h1 class="page-subhead-line">Tela para realizar alteração de um
			usuário</h1>
	</div>
</div>
<!-- /. ROW  -->
<div class="row">
	<div class="col-md-6 col-sm-6 col-xs-12">
		<div class="panel panel-info">
			<div class="panel-heading">Preencha os campos</div>

			<%
				String idUsuarioStr = request.getParameter("IdUsuario");
				Integer idUsuario = Integer.parseInt(idUsuarioStr);

				BaseDados baseDados = UtilBaseDados.recuperaBaseDados();
				List<Usuario> lista = baseDados.getListaUsuarios();
				Usuario usuarioAlterado = new UsuarioNeg().recuperarUsuario(
						idUsuario, lista);
				//for (Usuario usuario : lista) {

				SimpleDateFormat dataBR = new SimpleDateFormat("dd/MM/yyyy");
				//String dataNascimento = dataBR.format(valorDataNascimento);
			%>
			<div class="panel-body">
				<form role="form" action="Resultado_edicao.jsp" method="post">
					<input type="hidden" name="idUsuario" value='<%=idUsuario%>'>
					<div class="form-group">
						<label>Nome Completo</label> <input class="form-control"
							type="text" name="nomeCompleto"
							value='<%=usuarioAlterado.getNomeCompleto()%>'>
					</div>
					<div class="form-group">
						<label>Data de Nascimento</label> <input class="form-control"
							type="date" name="dataNascimento"
							value='<%=dataBR.format(usuarioAlterado.getDataNascimento())%>'>
					</div>
					<div class="form-group">
						<label>E-mail</label> <input class="form-control" type="text"
							name="email" value='<%=usuarioAlterado.getEmail()%>'>
					</div>
					<label>Sexo</label>
					<%
						if (usuarioAlterado.getSexo() == true) {
					%>
					<div class="radio">
						<label> <input type="radio" name="sexo" value='homem'
							checked>Masculino
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="sexo" value='mulher'>Femino
						</label>
					</div>
					<%
						} else {
					%>
					<div class="radio">
						<label> <input type="radio" name="sexo" value='homem'>Masculino
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="sexo" value='mulher'
							checked>Femino
						</label>
					</div>
					<%
						}
					%>

					<div class="form-group">
						<label>CPF</label> <input class="form-control" type="text"
							maxlength="11" name="cpf" value='<%=usuarioAlterado.getCpf()%>'>
					</div>
					<div class="form-group">
						<label>Usuário</label> <input class="form-control" type="text"
							name="usuario" value='<%=usuarioAlterado.getUsuario()%>'>
					</div>
					<div class="form-group">
						<label>Senha</label> <input class="form-control" type="password"
							name="senha" value='<%=usuarioAlterado.getSenha()%>'>
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

