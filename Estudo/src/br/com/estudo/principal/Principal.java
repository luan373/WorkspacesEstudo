package br.com.estudo.principal;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import br.com.estudo.entidade.BaseDados;
import br.com.estudo.entidade.Usuario;
import br.com.estudo.util.UtilBaseDados;
import br.com.estudo.util.UtilComum;
import br.com.estudo.validador.UsuarioValidador;

public class Principal {
	public static void main(String[] args) {
		try {
			
			/* recupera dados */
			BaseDados baseDados = UtilBaseDados.recuperaBaseDados();

			// define novo usuario 
			Usuario usuarioNovo = new Usuario();

			// Adiciona idUsuario
			usuarioNovo.setIdUsuario(UtilBaseDados.recuperaProxIdUsuario());

			// Não permitir campo Nome Completo vazio
			boolean tamanhoCampoNomeCompleto = false;
			while (tamanhoCampoNomeCompleto == false) {
				String campoNomeCompleto = (JOptionPane
						.showInputDialog(UtilComum.recuperarPropriedadeEstudoApp("inputNovoNomeCompleto")));
				if (campoNomeCompleto.equals("")) {
					JOptionPane.showMessageDialog(null, "O campo não pode ser vazio");
				} else {
					tamanhoCampoNomeCompleto = true;
					usuarioNovo.setNomeCompleto(campoNomeCompleto);
				}
			}

			// Não permitir campo usuario vazio e igual
			boolean tamanhoCampoUsuario = false;
			boolean usuarioExistente = true;
			while (tamanhoCampoUsuario == false || usuarioExistente == true) {
				String campoUsuario = (JOptionPane
						.showInputDialog(UtilComum.recuperarPropriedadeEstudoApp("inputNovoUsuario")));
				if (campoUsuario.equals("")) {
					JOptionPane.showMessageDialog(null, "O campo não pode ser vazio");
				} else {
					tamanhoCampoUsuario = true;
				}

				usuarioExistente = UtilBaseDados.recuperaNomeUsuario(campoUsuario);
				if (usuarioExistente == true) {
					JOptionPane.showMessageDialog(null, "Usuário já existente");
				} else {
					usuarioNovo.setUsuario(campoUsuario);
				}
			}

			// Não permitir campo Senha vazio
			boolean tamanhoCampoSenha = false;
			while (tamanhoCampoSenha == false) {
				String campoSenha = (JOptionPane
						.showInputDialog(UtilComum.recuperarPropriedadeEstudoApp("inputNovoSenha")));
				if (campoSenha.equals("")) {
					JOptionPane.showMessageDialog(null, "O campo não pode ser vazio");
				} else {
					tamanhoCampoSenha = true;
					usuarioNovo.setSenha(campoSenha);
				}
			}

			// Validar E-mail
			boolean emailValido = false;

			while (emailValido == false) {
				String valorEmail = (JOptionPane
						.showInputDialog(UtilComum.recuperarPropriedadeEstudoApp("inputNovoEmail")));
				if (valorEmail.equals("")) {
					JOptionPane.showMessageDialog(null, "O campo não pode ser vazio");
					// valorEmail =
					// JOptionPane.showInputDialog(UtilComum.recuperarPropriedadeEstudoApp("inputNovoEmail"));
				} else {
					if (UtilComum.validarEmail(valorEmail) == false) {
						JOptionPane.showMessageDialog(null, "Email Inválido");
						// valorEmail =
						// JOptionPane.showInputDialog(UtilComum.recuperarPropriedadeEstudoApp("inputNovoEmail"));
					} else {
						emailValido = true;
						usuarioNovo.setEmail(valorEmail);
					}
				}
			}

			// Data Cadastro
			Date data = new Date();
			usuarioNovo.setDataCadastro(data);

			// Converter String para data
			// Data de Nascimento
			String valorNascimento = (JOptionPane.showInputDialog("Digite a data de Nascimento"));
			Date nascimento = UtilComum.converterTextoData(valorNascimento);
			usuarioNovo.setDataNascimento(nascimento);

			// Definir sexo
			int tipoSexo = JOptionPane.showConfirmDialog(null, "Homem?", null, JOptionPane.YES_NO_OPTION);
			Boolean sexo;
			if (tipoSexo == JOptionPane.YES_OPTION) {
				sexo = true;
			} else {
				sexo = false;
			}
			usuarioNovo.setSexo(sexo);

			// Cadastrando sempre como ativo
			usuarioNovo.setAtivo(true);

			// Tamanho CPF
			boolean tamanhoCampoCPFvalido = false;

			while (tamanhoCampoCPFvalido == false) {
				String campoCpf = (JOptionPane.showInputDialog("Digite um cpf"));
				if (campoCpf.length() == 11) {
					tamanhoCampoCPFvalido = true;
					usuarioNovo.setCpf(campoCpf);
				} else {
					JOptionPane.showMessageDialog(null, "Preencha o campo CPF corretamente");
				}
			}

			/* adicionou o novo usuario na lista */
			baseDados.getListaUsuarios().add(usuarioNovo);

			/* grava dados */
			UtilBaseDados.gravaBaseDados(baseDados);

			/* escreve a lista de usuarios */
			for (Usuario usuario : baseDados.getListaUsuarios()) {
				System.out.println(usuario.toString());
			}

			JOptionPane.showMessageDialog(null, UtilComum.recuperarPropriedadeEstudoApp("resultado"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void alert(String string) {
		// TODO Auto-generated method stub

	}

}
