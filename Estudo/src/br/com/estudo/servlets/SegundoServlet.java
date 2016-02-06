package br.com.estudo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SegundoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9040412040369661168L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // servlet que escreve a hora na tela do usuario
        //Date data = new Date();
        String corpo = "Oi";
               
        	corpo = "Olá";
        	
        	out.println(corpo);
        	
        
        
        // escreve o texto        
       // String corpo = data.toString() + " oi ";
        
        
        
        //out.println(geraRetorno(corpo));
    }
	
	
	
	private String geraRetorno(String [] corpo)
	{
		String preCorpo = "<html><body>Minha Página<hr/>Resultado:<br />";
		String posCorpo = "</body></html>";
		return preCorpo + corpo + posCorpo;
	}
}
