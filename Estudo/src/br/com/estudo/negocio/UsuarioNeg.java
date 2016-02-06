package br.com.estudo.negocio;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estudo.entidade.BaseDados;
import br.com.estudo.entidade.Usuario;
import br.com.estudo.exception.EstudoException;
import br.com.estudo.form.RetornoForm;
import br.com.estudo.form.UsuarioForm;
import br.com.estudo.util.UtilBaseDados;
import br.com.estudo.util.UtilComum;

public class UsuarioNeg {

	public RetornoForm inserirUsuario(UsuarioForm form) throws EstudoException,
			IOException, ParseException {

		RetornoForm resultado = new RetornoForm();
		resultado.setSucesso(false);
		resultado.setObservacoes("");

		// Valida se todos os campos foram preenchidos
		if (form.getNomeCompleto().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo Nome Completo não pode ser vazio</li>");
		}
		if (form.getDataNascimento().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo Data de Nascimento não pode ser vazio</li>");
		}
		if (form.getEmail().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo E-mail não pode ser vazio</li>");
		}
		if (form.getCpf().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo CPF não pode ser vazio</li>");
		}
		if (form.getUsuario().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo Usuário não pode ser vazio</li>");
		}
		if (form.getSenha().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo Senha não pode ser vazio</li>");
		}

		// Valida se o e-mail é válido
		boolean emailValido = false;
		emailValido = UtilComum.validarEmail(form.getEmail());
		if (emailValido == false) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O E-mail é inválido.</li>");
		}

		// valida tamanho CPF
		if (form.getCpf().length() != 11) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>CPF inválido.</li>");
		}

		// Definir sexo
		String tipoSexo = form.getSexo();
		Boolean sexo = false;
		if (tipoSexo.equals("Homem")) {
			sexo = true;
		} else {
			sexo = false;
		}

		// Valida se já existe um usuário cadastrado
		boolean usuarioExistente = false;
		usuarioExistente = UtilBaseDados.recuperaNomeUsuario(form.getUsuario());
		if (usuarioExistente == true) {
			resultado
					.setObservacoes(resultado.getObservacoes()
							+ "<li>O usuário já existe na base de dados, informe outro.</li>");
		}

		// se o resultado está vazio, significa que ele nao tem erro.
		if (resultado.getObservacoes().equals("")) {
			// converter String para Data
			Date nascimento = UtilComum.converterTextoData(form
					.getDataNascimento());
			Date data = new Date();

			// joga do form para o usuario
			Usuario novoUsuario = new Usuario();
			novoUsuario.setIdUsuario(UtilBaseDados.recuperaProxIdUsuario());
			novoUsuario.setDataCadastro(data);
			novoUsuario.setNomeCompleto(form.getNomeCompleto());

			novoUsuario.setDataNascimento(nascimento);
			novoUsuario.setEmail(form.getEmail());
			novoUsuario.setSexo(sexo);
			novoUsuario.setCpf(form.getCpf());
			novoUsuario.setUsuario(form.getUsuario());
			novoUsuario.setSenha(form.getSenha());
			novoUsuario.setAtivo(true);

			BaseDados base = UtilBaseDados.recuperaBaseDados();
			base.getListaUsuarios().add(novoUsuario);
			UtilBaseDados.gravaBaseDados(base);
			resultado.setObservacoes("<li>Usuário Gravado com Sucesso</li>");
			resultado.setSucesso(true);
		}

		resultado.setObservacoes("<ul>" + resultado.getObservacoes() + "</ul>");

		return resultado;
	}

	public RetornoForm alterarUsuario(UsuarioForm usuarioForm)
			throws EstudoException, IOException, ParseException {

		RetornoForm resultado = new RetornoForm();
		resultado.setSucesso(false);
		resultado.setObservacoes("");

		// Valida se todos os campos foram preenchidos
		if (usuarioForm.getNomeCompleto().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo Nome Completo não pode ser vazio</li>");
		}
		if (usuarioForm.getDataNascimento().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo Data de Nascimento não pode ser vazio</li>");
		}
		if (usuarioForm.getEmail().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo E-mail não pode ser vazio</li>");
		}
		if (usuarioForm.getCpf().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo CPF não pode ser vazio</li>");
		}
		if (usuarioForm.getUsuario().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo Usuário não pode ser vazio</li>");
		}
		if (usuarioForm.getSenha().equals("")) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O campo Senha não pode ser vazio</li>");
		}

		// Valida se o e-mail é válido
		boolean emailValido = false;
		emailValido = UtilComum.validarEmail(usuarioForm.getEmail());
		if (emailValido == false) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>O E-mail é inválido.</li>");
		}

		// valida tamanho CPF
		if (usuarioForm.getCpf().length() != 11) {
			resultado.setObservacoes(resultado.getObservacoes()
					+ "<li>CPF inválido.</li>");
		}

		// Definir sexo
		String tipoSexo = usuarioForm.getSexo();
		Boolean sexo = false;
		if (tipoSexo.equals("Homem")) {
			sexo = true;
		} else {
			sexo = false;
		}

		// Valida se já existe um usuário cadastrado
		// boolean usuarioExistente = false;
		// usuarioExistente =
		// UtilBaseDados.recuperaNomeUsuario(usuario.getUsuario());
		// if (usuarioExistente == true) {
		// resultado
		// .setObservacoes(resultado.getObservacoes()
		// + "<li>O usuário já existe na base de dados, informe outro.</li>");
		// }

		// se o resultado está vazio, significa que ele nao tem erro.
		if (resultado.getObservacoes().equals("")) {
			// converter String para Data
			Date nascimento = UtilComum.converterTextoData(usuarioForm
					.getDataNascimento());
			Date data = new Date();

			// joga do form para o usuario
			int idUsuario = Integer.parseInt(usuarioForm.getIdUsuario());
			BaseDados baseDados = UtilBaseDados.recuperaBaseDados();

			Usuario usuarioAlterado = this.recuperarUsuario(idUsuario,
					baseDados.getListaUsuarios());

			usuarioAlterado.setDataCadastro(data);
			usuarioAlterado.setNomeCompleto(usuarioForm.getNomeCompleto());
			usuarioAlterado.setDataNascimento(nascimento);
			usuarioAlterado.setEmail(usuarioForm.getEmail());
			usuarioAlterado.setSexo(sexo);
			usuarioAlterado.setCpf(usuarioForm.getCpf());
			usuarioAlterado.setUsuario(usuarioForm.getUsuario());
			usuarioAlterado.setSenha(usuarioForm.getSenha());
			usuarioAlterado.setAtivo(true);

			UtilBaseDados.gravaBaseDados(baseDados);
			resultado.setObservacoes("<li>Usuário Gravado com Sucesso</li>");
			resultado.setSucesso(true);
		}

		resultado.setObservacoes("<ul>" + resultado.getObservacoes() + "</ul>");

		return resultado;

	}

	public List<Usuario> pesquisarUsuarios(Usuario usuario) {
		return new ArrayList<Usuario>();
	}

	public Usuario recuperarUsuario(int idUsuario) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		return usuario;
	}

	public Usuario recuperarUsuario(int idUsuario, List<Usuario> listaUsuarios) {
		Usuario usuario = null;

		for (Usuario usuarioLista : listaUsuarios) {
			if (usuarioLista.getIdUsuario().equals(idUsuario)) {
				usuario = usuarioLista;
			}
		}

		return usuario;
	}
	
	public void excluirUsuario(int idUsuario, List<Usuario> listaUsuarios) {
		Usuario usuario = null;

		for (Usuario usuarioLista : listaUsuarios) {
			if (usuarioLista.getIdUsuario().equals(idUsuario)) {
				usuario = usuarioLista;
			}
		}
		
		if (usuario != null) {
			listaUsuarios.remove(usuario);
		}
	}

}
