<%@page
	import="br.com.estudo.entidade.Usuario,
	br.com.estudo.negocio.UsuarioNeg, 
	br.com.estudo.form.*, 
	br.com.estudo.entidade.BaseDados, 
	br.com.estudo.entidade.BaseDados,
	br.com.estudo.exception.EstudoException,
	br.com.estudo.negocio.UsuarioNeg,
	br.com.estudo.util.UtilBaseDados,
	br.com.estudo.util.UtilComum,
	java.util.List,
	java.text.SimpleDateFormat,
	java.util.Date;"%>
<%@include file="Topo.html"%>


			<%
				String idUsuarioStr = request.getParameter("IdUsuario");
				Integer idUsuario = Integer.parseInt(idUsuarioStr);

				BaseDados baseDados = UtilBaseDados.recuperaBaseDados();
				List<Usuario> lista = baseDados.getListaUsuarios();
				new UsuarioNeg().excluirUsuario(idUsuario, lista);
				UtilBaseDados.gravaBaseDados(baseDados);
				
			%>

<div class="alert alert-success">
Usuário excluído com sucesso!
</div>
<a href="Listar_usuario.jsp" class="btn btn-info">Voltar</a>
<%@include file="Fundo.html"%>