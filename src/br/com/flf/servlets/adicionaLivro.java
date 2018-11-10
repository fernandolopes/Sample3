package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
 * Servlet implementation class adicionaFilme
 */
@WebServlet("/adicionaLivro")
public class adicionaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adicionaLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		int ano = Integer.parseInt(request.getParameter("ano"));
		String autores = request.getParameter("autores");
		String editora = request.getParameter("editora");
		
	    
	    Livro novo_livro = new Livro();
	    novo_livro.setTitulo(titulo);
	    novo_livro.setGenero(genero);
	    novo_livro.setAno(ano);
	    novo_livro.setAutores(autores);
	    novo_livro.setEditora(editora);
        
        LivroDAO dao = new LivroDAO();
        try {
            dao.adiciona(novo_livro);

            out.println("<html>");
            out.println("<body>");
            out.println("Livro: \"" + novo_livro.getTitulo() + "\",adicionado!");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.print(e);
            e.printStackTrace();
        }




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
