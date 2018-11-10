package br.com.flf.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class pesquisaFilme
 */
@WebServlet("/pesquisaLivro")
public class pesquisaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pesquisaLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String pesquisa = request.getParameter("key");
		LivroDAO dao = new LivroDAO();
		List<Livro> result = new ArrayList<>();
		result = dao.getPesquisa(pesquisa);
		request.setAttribute("lista_req", result);
		RequestDispatcher disp = request.getRequestDispatcher("pesquisa-livro.jsp");
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
