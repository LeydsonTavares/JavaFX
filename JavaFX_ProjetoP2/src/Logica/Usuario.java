package Logica;


public class Usuario {
	
	private String senha;
	private String login;
	private String nome;
	static String nomeTela;
	

	
	public Usuario(String login , String senha,String nome){
		this.setLogin(login);
		this.setSenha(senha);
		this.setNome(nome);
		
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
}