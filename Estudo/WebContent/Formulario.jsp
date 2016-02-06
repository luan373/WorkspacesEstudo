<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="br.com.estudo.entidade.BaseDados,
	br.com.estudo.entidade.Usuario,
	br.com.estudo.exception.EstudoException,
	br.com.estudo.negocio.UsuarioNeg,
	br.com.estudo.util.UtilBaseDados,
	br.com.estudo.util.UtilComum,
	java.util.List"%>
<%@include file="Topo.html"%>
<form action="Resultado.jsp" method="post">
	<table border="1">
		<tr>
			<td>Usuário:</td>
			<td><input type="text" name="usuario" required /></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password" name="senha" required/></td>
		</tr>
		<tr>
			<td>Nome Completo:</td>
			<td><input type="text" name="nomeCompleto" required/></td>
		</tr>
		<tr>
			<td>Sexo:</td>
			<td><input type="radio" name="sexo" value="homem" required/>Homem 
			<input type="radio" name="sexo" value="mulher" required/>Mulher</td>
		</tr>
		<tr>
			<td>Data de Nascimento:</td>
			<td><input type="date" name="dataNascimento" required/></td>
		</tr>
		<tr>
			<td>E-mail:</td>
			<td><input type="email" name="email" required/></td>
		</tr>
		<tr>
			<td>CPF:</td>
			<td><input type="text" name="cpf" required/></td>
		</tr>
		<tr>
			<td>Ativo:</td>
			<td><input type="radio" name="ativo" value="Sim" required />Sim <input
				type="radio" name="ativo" value="Nao" required />Não</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="enviar" /></td>
		</tr>
	</table>
</form>
<hr />

<table border="1">



	<tr>
		<td>Id</td>
		<td>Descricao</td>
	</tr>


	<%
		BaseDados baseDados = UtilBaseDados.recuperaBaseDados();
		List<Usuario> lista = baseDados.getListaUsuarios();

		for (Usuario usuario : lista) {
	%>
	<tr>
		<td><%=usuario.getIdUsuario()%></td>
		<td><%=usuario.getNomeCompleto()%></td>
	</tr>

	<%
		}
	%>
</table>
<%@include file="Fundo.html"%>