package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDAO;
import br.com.flf.jdbc.LivroDAO;
import br.com.flf.models.Filme;
import br.com.flf.models.Livro;

/**
 * Servlet implementation class alteraFilme
 */
@WebServlet("/alteraLivro")
public class alteraLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alteraLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		long id = Long.parseLong(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String autores = request.getParameter("autores");
		int ano = Integer.parseInt(request.getParameter("ano"));
		String editora = request.getParameter("editora");
		
	    
	    Livro novo_filme = new Livro(titulo, genero, autores, ano, editora);
        
        novo_filme.setId(id);
        
        LivroDAO dao = new LivroDAO();
        try {
			dao.altera(novo_filme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        RequestDispatcher disp = request.getRequestDispatcher("listar-livro.jsp");
		disp.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
