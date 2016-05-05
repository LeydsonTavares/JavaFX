package Logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GerenciadorEmprestimo {

	Map<Chave,String> chaves = new LinkedHashMap<Chave,String>();
	Map<String,Aluno> alunos = new HashMap<String,Aluno>();
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm:ss");
	private String dataDevolução;
	private static GerenciadorEmprestimo instance = new GerenciadorEmprestimo();


	public static GerenciadorEmprestimo getInstance(){
		return instance;
	}


	public  GerenciadorEmprestimo(){ 
		Aluno aluno1= new Aluno();
		Aluno aluno2= new Aluno();
		Aluno aluno3= new Aluno();
		Aluno aluno4= new Aluno();
		/*
		Aluno aluno5= new Aluno();
		Aluno aluno6= new Aluno();
		Aluno aluno7= new Aluno();
		Aluno aluno8= new Aluno();
		Aluno aluno9= new Aluno();
		Aluno aluno10= new Aluno();
		Aluno aluno11= new Aluno();
		Aluno aluno12= new Aluno();
		*/
		

		aluno1.setBairro("Catolé");
		aluno1.setCategoria("Aluno");
		aluno1.setCelular("8680-5891");
		aluno1.setCep("58408310");
		aluno1.setCidade("Campina Grande");
		aluno1.setCpf("000-234-123-00");
		aluno1.setEmail("fernanda_beatrizmp02@hotmail.com");
		aluno1.setEndereco("Rua Arius");
		aluno1.setGenero("Feminino");
		aluno1.setNome("Fernanda Beatriz M. Pontes");
		aluno1.setNumero("197");
		aluno1.setRg("505050");
		aluno1.setTelefone("33311852");
		aluno1.setTurno("Noite");
		aluno1.setUf("PB");
		aluno1.setUo("308 - Sistemas de Informação");
		aluno1.setEstadoCivil("Casado");

		alunos.put("1413080024",aluno1);


		aluno2.setBairro("Itararé");
		aluno2.setCategoria("Aluno");
		aluno2.setCelular("8770-8212");
		aluno2.setCep("58408310");
		aluno2.setCidade("Campina Grande");
		aluno2.setCpf("942-234-123-96");
		aluno2.setEmail("leydson_tavares@hotmail.com");
		aluno2.setEndereco("Rua Maria da Guia Costa Figueiredo");
		aluno2.setGenero("Masculino");
		aluno2.setNome("Leydson Ryan Silva Tavares");
		aluno2.setNumero("203");
		aluno2.setRg("787987879");
		aluno2.setTelefone("33311852");
		aluno2.setTurno("Noite");
		aluno2.setUf("PB");
		aluno2.setUo("308 - Sistemas de Informação");
		aluno2.setEstadoCivil("Casado");

		alunos.put("1423080014",aluno2);

		aluno3.setNome("Doglas Lima");
		aluno3.setCategoria("Aluno");
		aluno3.setTurno("Noite");
		aluno3.setUf("PB");
		aluno3.setUo("308 - Sistemas de Informação");
		
		alunos.put("1423080001", aluno3);
		
		aluno4.setNome("Emerson Cantalice");
		aluno4.setCategoria("Aluno");
		aluno4.setTurno("Noite");
		aluno4.setUf("PB");
		aluno4.setUo("308 - Sistemas de Informação");
	
		alunos.put("1423080005", aluno4);
		
		chaves.put(new Chave("01"), "");
		chaves.put(new Chave("02"), "");
		chaves.put(new Chave("03"), "");
		chaves.put(new Chave("04"), "");
		chaves.put(new Chave("05"), "");
		chaves.put(new Chave("06"), "");
		chaves.put(new Chave("07"), "");
		chaves.put(new Chave("08"), "");
		chaves.put(new Chave("09"), "");
		chaves.put(new Chave("10"), "");
		chaves.put(new Chave("11"), "");
		chaves.put(new Chave("12"), "");
		chaves.put(new Chave("13"), "");
		chaves.put(new Chave("14"), "");
		chaves.put(new Chave("15"), "");
		chaves.put(new Chave("16"), "");
		chaves.put(new Chave("17"), "");
		chaves.put(new Chave("18"), "");
		chaves.put(new Chave("19"), "");
		chaves.put(new Chave("20"), "");

		
	
		
		
    

	}



	public void adicionaAluno(String matricula,Aluno aluno) throws Exception{
		if(verificaMatricula(matricula) != true){
			Aluno novoaluno = new Aluno();

			novoaluno.setBairro(aluno.getBairro());
			novoaluno.setCategoria(aluno.getCategoria());
			novoaluno.setCelular(aluno.getCelular());
			novoaluno.setCep(aluno.getCep());
			novoaluno.setCidade(aluno.getCidade());
			novoaluno.setCpf(aluno.getCpf());
			novoaluno.setEmail(aluno.getEmail());
			novoaluno.setEndereco(aluno.getEndereco());
			novoaluno.setGenero(aluno.getGenero());
			novoaluno.setNome(aluno.getNome());
			novoaluno.setNumero(aluno.getNumero());
			novoaluno.setRg(aluno.getRg());
			novoaluno.setTelefone(aluno.getTelefone());
			novoaluno.setTurno(aluno.getTurno());
			novoaluno.setUf(aluno.getUf());
			novoaluno.setUo(aluno.getUo());
			novoaluno.setEstadoCivil(aluno.getEstadoCivil());
			alunos.put(matricula,novoaluno);
		}


	}public void remove(String matricula){
		alunos.remove(matricula);

	}	
	public void aluga(String registro,String matricula){
		Chave novachave = new Chave();
		for(Chave chave : chaves.keySet()){
			if(registro.equals(chave.getRegistro())){
				novachave = chave;
			}
		}
		
		novachave.setRegistro(registro);
		novachave.setLocatario(matricula);
		chaves.put(novachave, matricula);
		


		if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY){
			calendar.add(Calendar.DATE, 5);
			this.dataDevolução = formatador.format(calendar.getTime());
			calendar.add(Calendar.DATE, -5);	

		}else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY){
			calendar.add(Calendar.DATE, 5);
			this.dataDevolução = formatador.format(calendar.getTime());
			calendar.add(Calendar.DATE, -5);


		}else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
			calendar.add(Calendar.DATE, 5);
			this.dataDevolução = formatador.format(calendar.getTime());
			calendar.add(Calendar.DATE, -5);

		}else{
			calendar.add(Calendar.DATE, 3);
			this.dataDevolução = formatador.format(calendar.getTime());
			calendar.add(Calendar.DATE, -3);

		}


	}
	public void devolucao(String registro){
		Chave novachave = new Chave();
		for(Chave chave : chaves.keySet()){
			if(registro.equals(chave.getRegistro())){
				novachave = chave;
				
			}
		}
		novachave.setRegistro(registro);
		novachave.setLocatario("");
		chaves.put(novachave, "");

	}

	public boolean estaLivre(String registro){
		for(Chave chave : chaves.keySet()){
			if(registro.equals(chave.getRegistro())){
				if(chaves.get(chave)==""){
					return true;
				}
			}
		}return false;



	}

	public String dataefetiva(){
		String dataefetiva = formatador.format(calendar.getTime());
		return dataefetiva;
	}


	public String dataDevolucao(){
		return this.dataDevolução;
	}


	public boolean loginCorreto(String matricula) throws Exception{	
		if(verificaMatricula(matricula)==true ){
			return true;
		}
		return false;


	}
	public boolean verificaMatricula(String matricula) throws Exception{
		if(alunos.containsKey(matricula)){
			return true;
		}return false;



	}public boolean possuiChave(String registro){
		if(chaves.containsValue(registro)){
			return true;
		}else{
			return false;
		}
	}public boolean existeChave(String registro){
		for(Chave chave : chaves.keySet()){
			if(registro.equals(chave.getRegistro())){
				return true;
			}


		}
		return false;
	}




}













