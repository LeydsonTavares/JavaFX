package Logica;


import java.util.ArrayList;
import java.util.List;




public class GerenciadorDeUsuario {


	private static GerenciadorDeUsuario instance = new GerenciadorDeUsuario();
	protected String situacao;
	private List<Usuario> usuarios = new ArrayList<Usuario>();


	public GerenciadorDeUsuario(){
		usuarios.add(new Usuario("Leydson","153468","Leydson Ryan Silva Tavares")); 
		usuarios.add(new Usuario("Fernanda","1015","Fernanda Beatriz M. Pontes"));
		
	}


	public static GerenciadorDeUsuario getInstance(){
		return instance;
	}

	public void adicionarUsuario(Usuario usuario) throws Exception {

		if(verificaLogin(usuario.getLogin())==false){
			usuarios.add(new Usuario(usuario.getLogin(),usuario.getSenha(),usuario.getNome()));

		}

	}
	public boolean verificaLogin(String login) throws Exception {
		for (Usuario usuario : usuarios){	
			if(usuario.getLogin().equals(login)){
				return true;
			}
		}
		return false;
	}
		public boolean verificaSenha(String senha) throws Exception {
			if(usuarios.contains(senha)){
				return true;

			}return false;

		}




		public boolean loginCorreto(String login,String senha) throws Exception{	
			for (Usuario usuario : usuarios)
				if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
					Usuario.nomeTela= usuario.getNome();
					return true;
				}
			return false;

		}
	}
