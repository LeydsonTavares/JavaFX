
package Logica;

public class Chave {

	private String registro;
	private String locatario;
	private String dataEmprestimo;
	private String dataDevolucao;
	private String situacao;



	public Chave(String registro,String situacao, Aluno aluno,String dataEmprestimo,String dataDevolucao){
		setRegistro(registro);
		setSituacao(situacao);
		setLocatario(aluno.getNome());
		setDataDevolucao(dataDevolucao);
		setDataEmprestimo(dataEmprestimo);

	}public Chave(){

	}public Chave(String registro){
		setRegistro(registro);


	}public Chave(String registro,String situacao,String locatario,String dataE,String dataD){
		situacao = "Disponivel";
		setRegistro(registro);
		setSituacao(situacao);
		setLocatario(locatario);
	}




	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String toString(){
		return registro;
	}
	public String getLocatario() {
		return locatario;
	}
	public void setLocatario(String locatario) {
		this.locatario = locatario;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
