package br.com.flf.models;

public class Livro {

	private long id;
	private String titulo;
	private String autores;
	private String genero;
	private int ano;
	private String editora;
	
	public Livro() {}
	public Livro(String titulo, String autores, String genero, int ano, String editora) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.genero = genero;
		this.ano = ano;
		this.editora = editora;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
}
