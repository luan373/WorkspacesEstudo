package br.com.estudo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.entidade.BaseDados;
import br.com.estudo.entidade.Usuario;
import br.com.estudo.exception.EstudoException;
import br.com.estudo.negocio.UsuarioNeg;
import br.com.estudo.util.UtilBaseDados;
import br.com.estudo.util.UtilComum;

public class EstudoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9040412040369661168L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // escreve o texto
        out.println("<html>");
        out.println("<body>");
        out.println("Primeira servlet");
        out.println("<hr/>");
        
        out.println("<table border=1>");
        out.println("<tr>");
	        out.println("<td>");
	        out.println("ID");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("Usuário");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("Senha");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("Data de Cadastro");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("Nome Completo");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("Sexo");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("Data de Nascimento");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("E-mail");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("CPF");	
	        out.println("</td>");
	        out.println("<td>");
	        out.println("Situação");	
	        out.println("</td>");
	     out.println("</tr>");	
        BaseDados baseDados = UtilBaseDados.recuperaBaseDados();
        
        List<Usuario> listaUsuarios = baseDados.getListaUsuarios();
		if (listaUsuarios.size() > 0){
			for(Usuario usuario : listaUsuarios){				
				out.println("<tr>");
					out.println("<td>");
					out.println(usuario.getIdUsuario());
					out.println("</td>");
					out.println("<td>");
					out.println(usuario.getUsuario());	
					out.println("</td>");
					out.println("<td>");
					out.println(usuario.getSenha());
					out.println("</td>");
					out.println("<td>");
						SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
						out.println(dt.format(usuario.getDataCadastro()));
					//out.println(usuario.getDataCadastro());	
					out.println("</td>");
					out.println("<td>");
					out.println(usuario.getNomeCompleto());
					out.println("</td>");
					out.println("<td>");
					if(usuario.getSexo() == true){
						out.println("Homem");
					}
					else{
						out.println("Mulher");	
					}					
					out.println("</td>");
					out.println("<td>");
						SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
						out.println(dt1.format(usuario.getDataNascimento()));
					//out.println(usuario.getDataNascimento());
					out.println("</td>");
					out.println("<td>");
					out.println(usuario.getEmail());	
					out.println("</td>");
					out.println("<td>");
					out.println(usuario.getCpf());
					out.println("</td>");
					out.println("<td>");
					if(usuario.getAtivo() == true){
						out.println("Ativo");
					}
					else{
						out.println("Else");	
					}						
					out.println("</td>");
				out.println("</tr>");
				
				//out.println(usuario.getUsuario());		        
			}
		}
		out.println("</table>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
