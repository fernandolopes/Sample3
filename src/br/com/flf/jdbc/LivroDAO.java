package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.flf.models.*;

public class LivroDAO {

	public void adiciona(Livro novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       

		String sql = "insert into livro " +
				"(titulo,genero,autores,ano,editora)" +
				" values (?,?,?,?,?)";
		try {

			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,novo.getTitulo());
			stmt.setString(2,novo.getGenero());
			stmt.setString(3,novo.getAutores());
			stmt.setInt(4, novo.getAno());
			stmt.setString(5,novo.getEditora());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		conx.close(conn);

	}
	
	public void altera(Livro novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       

		String sql = "update livro set titulo=?, genero=?, autores=?, ano=?,"+
				"editora=? where id=?";
		try {

			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,novo.getTitulo());
			stmt.setString(2,novo.getGenero());
			stmt.setString(3,novo.getAutores());
			stmt.setInt(4, novo.getAno());
			stmt.setString(5, novo.getEditora());
			stmt.setLong(6,novo.getId());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		conx.close(conn);

	}
	
	public void delete(long id) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       
		String sql = "delete from livro where id=?";
		try {

			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			// seta os valores
			stmt.setLong(1,id);
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		conx.close(conn);

	}
	
	public Livro getLivro(long id) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       
		Livro livro = new Livro();
		PreparedStatement stmt = conn.prepareStatement("select * from livro where id="+id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			String titulo = rs.getString("titulo");
			String genero = rs.getString("genero");
			String autores = rs.getString("autores");
			int ano = rs.getInt("ano");
			String editora = rs.getString("editora");
			livro = new Livro(titulo,genero,autores,ano,editora);
			livro.setId(id);
			
			stmt.close();
			conn.close();
			
			return livro;
		}
		
		stmt.close();
		conn.close();
		return null;
	}
	
	public List<Livro> getLivros() throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       
		List<Livro> livros = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("select * from livro");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			String titulo = rs.getString("titulo");
			String genero = rs.getString("genero");
			String autores = rs.getString("autores");
			int ano = rs.getInt("ano");
			long id = rs.getLong("id");
			String editora = rs.getString("editora");
			
			Livro row = new Livro(titulo,autores, genero, ano, editora);
			row.setId(id);
			livros.add(row);
		}
		
		stmt.close();
		conn.close();
		return livros;
	}
	
	public List<Livro> getPesquisa(String key){
		List<Livro> livros = new ArrayList<>();
		Conexao conx = new Conexao();
		Connection conn;
		try {
			conn = conx.abrir();
		       
		PreparedStatement stmt = conn.prepareStatement("select * from livro where genero like ?");
		stmt.setString(1,"%"+key+"%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			String titulo = rs.getString("titulo");
			String genero = rs.getString("genero");
			String autores = rs.getString("autores");
			int ano = rs.getInt("ano");
			String editora = rs.getString("editora");
			long id = rs.getLong("id");
			Livro row = new Livro(titulo,genero,autores,ano,editora);
			row.setId(id);
			livros.add(row);
		}
		
		stmt.close();
		conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livros;
	}
}
