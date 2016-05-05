package Logica;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class TelaCadastrarAlunoController  implements Initializable{

	private GerenciadorEmprestimo gerenciador;

	public TelaCadastrarAlunoController() {
		gerenciador = GerenciadorEmprestimo.getInstance();

	}

	@FXML
	private Text textoInserir;

	@FXML
	private Text textoAlterar;

	@FXML
	private Text textoExcluir;

	@FXML
	private ComboBox<String> genero;

	@FXML
	private ComboBox<String> estadoCivil;

	@FXML
	private TextField cpf;

	@FXML
	private TextField registroGeral;

	@FXML
	private TextField endereco;

	@FXML
	private TextField email;

	@FXML
	private TextField numero;
	@FXML
	private TextField bairro;

	@FXML
	private TextField telefone;

	@FXML
	private TextField celular;

	@FXML
	private TextField cep;

	@FXML
	private TextField cidade;

	@FXML
	private ComboBox<String> unidadeFederal;

	@FXML
	private ComboBox<String> unidadeOrganizacional;

	@FXML
	private ComboBox<String> categoriaUsuario;

	@FXML
	private ComboBox<String> turno;

	@FXML
	private Button botaoSair;

	@FXML
	private TextField matricula;

	@FXML
	private TextField nomeAluno;

	@FXML
	private Button botaoexcluirCadastro;

	@FXML
	private Button botaoInserirAluno;
	@FXML
	private Button botaoVoltarTela;

	@FXML
	private Button botaoAlterarCadastro;

	@FXML
	private Label mensagemNaTela;

	@FXML
	private Label horaTela;

	@FXML
	void alterarCadastro(ActionEvent event) {	
		Aluno novosDados = gerenciador.alunos.get(matricula.getText());
		novosDados.setBairro(bairro.getText());
		novosDados.setCelular(celular.getText());
		novosDados.setCep(cep.getText());
		novosDados.setCidade(cidade.getText());
		novosDados.setCpf(cpf.getText());
		novosDados.setEmail(email.getText());
		novosDados.setEndereco(endereco.getText());
		novosDados.setGenero(genero.getValue());
		novosDados.setNome(nomeAluno.getText());
		novosDados.setNumero(numero.getText());
		novosDados.setRg(registroGeral.getText());
		novosDados.setTelefone(telefone.getText());
		/*
		 * Limpando as Combobox pos alteração.
		 */
		if (turno.getValue()!= null){
			
			novosDados.setTurno(turno.getValue());
			turno.getSelectionModel().select(null);
			
		}else if(unidadeFederal.getValue()!= null){

			novosDados.setUf(unidadeFederal.getValue());
			unidadeFederal.getSelectionModel().select(null);

		}else if(unidadeOrganizacional.getValue()!= null){
			
			novosDados.setUo(unidadeOrganizacional.getValue());
			unidadeOrganizacional.getSelectionModel().select(null);

		}else if (estadoCivil.getValue()!= null){
			
			novosDados.setEstadoCivil(estadoCivil.getValue());
			estadoCivil.getSelectionModel().select(null);
		
		}else if (categoriaUsuario.getValue()!= null){
			
			novosDados.setCategoria(categoriaUsuario.getValue());
			categoriaUsuario.getSelectionModel().select(null);
			
		}else if (genero.getValue()!=null){
			
			novosDados.setGenero(genero.getValue());
			genero.getSelectionModel().select(null);
		}


		criaAlert(AlertType.INFORMATION, "Informação", "Matrícula " + matricula.getText() + " alterada com sucesso! ").show();

		/*
		 * Limpando os Textifield Combobox pos alteração.
		 */
		matricula.clear();
		bairro.clear();
		celular.clear();
		nomeAluno.clear();
		cpf.clear();
		registroGeral.clear();
		endereco.clear();
		email.clear();
		numero.clear();
		telefone.clear();
		cep.clear();
		cidade.clear();
		unidadeFederal.setPromptText(null);
		unidadeOrganizacional.setPromptText(null);
		categoriaUsuario.setPromptText(null);
		turno.setPromptText(null);
		genero.setPromptText(null);
		estadoCivil.setPromptText(null);
		
		/*Deixando os Combobox e Textifields, Disable!! 
		 */
				
		botaoAlterarCadastro.setDisable(true);
		botaoexcluirCadastro.setDisable(true);
		botaoInserirAluno.setDisable(true);
		textoInserir.setOpacity(0.5);
		textoAlterar.setOpacity(0.5);
		textoExcluir.setOpacity(0.5);
		genero.setDisable(true);
		estadoCivil.setDisable(true);
		cpf.setDisable(true);
		registroGeral.setDisable(true);
		endereco.setDisable(true);
		email.setDisable(true);
		numero.setDisable(true);
		telefone.setDisable(true);
		celular.setDisable(true);
		cep.setDisable(true);
		cidade.setDisable(true);
		unidadeFederal.setDisable(true);
		unidadeOrganizacional.setDisable(true);
		categoriaUsuario.setDisable(true);
		turno.setDisable(true);
		nomeAluno.setDisable(true);
		bairro.setDisable(true);

	}

	@FXML
	void excluirCadastro(ActionEvent event) {
		if(matricula.getText().length()!=0){
			gerenciador.remove(matricula.getText());

			criaAlert(AlertType.INFORMATION, "Informação", "Matrícula " + matricula.getText() + " excluída com sucesso! ").show();

			matricula.clear();
			bairro.clear();
			celular.clear();
			nomeAluno.clear();
			cpf.clear();
			registroGeral.clear();
			endereco.clear();
			email.clear();
			numero.clear();
			telefone.clear();
			cep.clear();
			cidade.clear();
			unidadeFederal.setPromptText(null);
			unidadeOrganizacional.setPromptText(null);
			categoriaUsuario.setPromptText(null);
			turno.setPromptText(null);
			genero.setPromptText(null);
			estadoCivil.setPromptText(null);
			
			
			botaoAlterarCadastro.setDisable(true);
			botaoexcluirCadastro.setDisable(true);
			botaoInserirAluno.setDisable(true);
			textoInserir.setOpacity(0.5);
			textoAlterar.setOpacity(0.5);
			textoExcluir.setOpacity(0.5);
			genero.setDisable(true);
			estadoCivil.setDisable(true);
			cpf.setDisable(true);
			registroGeral.setDisable(true);
			endereco.setDisable(true);
			email.setDisable(true);
			numero.setDisable(true);
			telefone.setDisable(true);
			celular.setDisable(true);
			cep.setDisable(true);
			cidade.setDisable(true);
			unidadeFederal.setDisable(true);
			unidadeOrganizacional.setDisable(true);
			categoriaUsuario.setDisable(true);
			turno.setDisable(true);
			nomeAluno.setDisable(true);
			bairro.setDisable(true);
		}else{
			criaAlert(AlertType.INFORMATION, "Informação", "Preencha o campo Matrícula para poder excluir! ").show();
		}

	}

	@FXML
	private void inserirAluno(ActionEvent event) throws Exception {
		if(nomeAluno.getText().length()==0){
			criaAlert(AlertType.INFORMATION, "Informação", "Por favor digite o NOME do aluno!.").show();
		}else if(unidadeOrganizacional.getValue()==null){
			criaAlert(AlertType.INFORMATION, "Informação", "Por favor selecione a UNIDADE ORGANIZACIONAL do aluno!.").show();
		}else if (categoriaUsuario.getValue()==null){
			criaAlert(AlertType.INFORMATION, "Informação", "Por favor selecione CATEGORIA DO USUÀRIO do aluno!.").show();
		
		}else{
			Aluno novoaluno = new Aluno();
			novoaluno.setBairro(bairro.getText());
			novoaluno.setCategoria(categoriaUsuario.getValue());
			novoaluno.setCelular(celular.getText());
			novoaluno.setCep(cep.getText());
			novoaluno.setCidade(cidade.getText());
			novoaluno.setCpf(cpf.getText());
			novoaluno.setEmail(email.getText());
			novoaluno.setEndereco(endereco.getText());
			novoaluno.setGenero(genero.getValue());
			novoaluno.setNome(nomeAluno.getText());
			novoaluno.setNumero(numero.getText());
			novoaluno.setRg(registroGeral.getText());
			novoaluno.setTelefone(telefone.getText());
			novoaluno.setTurno(turno.getValue());
			novoaluno.setUf(unidadeFederal.getValue());
			novoaluno.setUo(unidadeOrganizacional.getValue());
			novoaluno.setEstadoCivil(estadoCivil.getValue());
			gerenciador.adicionaAluno(matricula.getText(), novoaluno);
			criaAlert(AlertType.INFORMATION, "Informação", "Os dados pessoais foram cadastrados com " + "\n "
					+ "sucesso! Código gerado é : " + matricula.getText()).show();

			matricula.clear();
			bairro.clear();
			celular.clear();
			nomeAluno.clear();
			cpf.clear();
			registroGeral.clear();
			endereco.clear();
			email.clear();
			numero.clear();
			telefone.clear();
			cep.clear();
			cidade.clear();
			unidadeFederal.setPromptText(null);
			unidadeOrganizacional.setPromptText(null);
			categoriaUsuario.setPromptText(null);
			turno.setPromptText(null);
			genero.setPromptText(null);
			estadoCivil.setPromptText(null);
			turno.getSelectionModel().select(null);
			unidadeFederal.getSelectionModel().select(null);
			unidadeOrganizacional.getSelectionModel().select(null);
			estadoCivil.getSelectionModel().select(null);
			categoriaUsuario.getSelectionModel().select(null);
			genero.getSelectionModel().select(null);

			genero.setDisable(true);
			estadoCivil.setDisable(true);
			cpf.setDisable(true);
			registroGeral.setDisable(true);
			endereco.setDisable(true);
			email.setDisable(true);
			numero.setDisable(true);
			telefone.setDisable(true);
			celular.setDisable(true);
			cep.setDisable(true);
			cidade.setDisable(true);
			unidadeFederal.setDisable(true);
			unidadeOrganizacional.setDisable(true);
			categoriaUsuario.setDisable(true);
			turno.setDisable(true);
			nomeAluno.setDisable(true);
			bairro.setDisable(true);

		}



	}
	private void tentaLogin(Event event) throws Exception {
		if(matricula.getText().length()!=0){
			if(gerenciador.verificaMatricula(matricula.getText())== true){
				bairro.setText(gerenciador.alunos.get(matricula.getText()).getBairro());
				nomeAluno.setText(gerenciador.alunos.get(matricula.getText()).getNome());
				cpf.setText(gerenciador.alunos.get(matricula.getText()).getCpf());
				registroGeral.setText(gerenciador.alunos.get(matricula.getText()).getRg());
				endereco.setText(gerenciador.alunos.get(matricula.getText()).getEndereco());
				email.setText(gerenciador.alunos.get(matricula.getText()).getEmail());
				numero.setText(gerenciador.alunos.get(matricula.getText()).getNumero());
				telefone.setText(gerenciador.alunos.get(matricula.getText()).getTelefone());
				cep.setText(gerenciador.alunos.get(matricula.getText()).getCep());
				cidade.setText(gerenciador.alunos.get(matricula.getText()).getCidade());
				unidadeFederal.setPromptText(gerenciador.alunos.get(matricula.getText()).getUf());
				unidadeOrganizacional.setPromptText(gerenciador.alunos.get(matricula.getText()).getUo());
				categoriaUsuario.setPromptText(gerenciador.alunos.get(matricula.getText()).getCategoria());
				turno.setPromptText(gerenciador.alunos.get(matricula.getText()).getTurno());
				celular.setText(gerenciador.alunos.get(matricula.getText()).getCelular());
				genero.setPromptText(gerenciador.alunos.get(matricula.getText()).getGenero());
				estadoCivil.setPromptText(gerenciador.alunos.get(matricula.getText()).getEstadoCivil());

				botaoAlterarCadastro.setDisable(false);
				botaoInserirAluno.setDisable(true);
				botaoexcluirCadastro.setDisable(false);
				textoInserir.setOpacity(0.5);
				textoAlterar.setOpacity(1);
				textoExcluir.setOpacity(1);
				estadoCivil.setDisable(false);
				genero.setDisable(false);
				cpf.setDisable(false);
				registroGeral.setDisable(false);
				endereco.setDisable(false);
				email.setDisable(false);
				numero.setDisable(false);
				telefone.setDisable(false);
				cep.setDisable(false);
				cidade.setDisable(false);
				celular.setDisable(false);
				unidadeFederal.setDisable(false);		
				unidadeOrganizacional.setDisable(false);
				categoriaUsuario.setDisable(false);
				turno.setDisable(false);
				nomeAluno.setDisable(false);
				bairro.setDisable(false);

			}else {
				botaoAlterarCadastro.setDisable(true);
				botaoInserirAluno.setDisable(false);
				botaoexcluirCadastro.setDisable(true);
				textoInserir.setOpacity(1);
				textoExcluir.setOpacity(0.5);
				textoAlterar.setOpacity(0.5);
				estadoCivil.setDisable(false);
				genero.setDisable(false);
				cpf.setDisable(false);
				registroGeral.setDisable(false);
				endereco.setDisable(false);
				email.setDisable(false);
				numero.setDisable(false);
				telefone.setDisable(false);
				cep.setDisable(false);
				cidade.setDisable(false);
				celular.setDisable(false);
				unidadeFederal.setDisable(false);		
				unidadeOrganizacional.setDisable(false);
				categoriaUsuario.setDisable(false);
				turno.setDisable(false);
				nomeAluno.setDisable(false);
				bairro.setDisable(false);

				if(nomeAluno.getText().length()==0){
					criaAlert(AlertType.INFORMATION, "Informação", "Por favor, preencha os dados solicitados para inserir aluno!.").show();

				}
			}
		}else{
			criaAlert(AlertType.INFORMATION, "Informação", "Por favor, preencha o campo MATRÌCULA!.").show();
		}


	}

	@FXML
	public void voltarTelaUsuario(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaUsuario.fxml"));
		Principal.SCENE.setRoot(parent);

	}@FXML
	public void voltarTelaLogin(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Principal.SCENE.setRoot(parent);

	}



	@FXML 
	public void matriculaDigitada(KeyEvent event) throws Exception {
		if (event.getCode() == KeyCode.TAB) {
			tentaLogin(event);

		}
	}



	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		return a;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//Combobox
		unidadeFederal.getItems().addAll("AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR",
				"PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO");
		unidadeOrganizacional.getItems().addAll("201 - ENFERMAGEM","202 - FISIOTERAPIA","203 - MEDICINA","204 - MEDICINA","205 - NUTRIÇÃO",
				"206 - BIOMEDICINA","305 - DIREITO","306 - ARQUITETURA E URBANISMO","307 -  CIÊNCIAS CONTÁBEIS",
				"308 - SISTEMAS DE INFORMAÇÃO","309 - ADMINISTRAÇÃO","401 - CIÊNCIAS AERONÁUTICAS",
				"502 - JOGOS DIGITAIS","503 - CONSTRUÇÃO DE EDIFÍCIOS" );
		turno.getItems().addAll("Manhã","Tarde","Noite");
		categoriaUsuario.getItems().addAll("Aluno","Funcionário","Professor");
		genero.getItems().addAll("Masculino","Feminino");
		estadoCivil.getItems().addAll("Casado","Solteiro","Amasiado","Desquitado","Divorciado","Viúvo");



		mensagemNaTela.setText("Bem-vindo(a), "+ Usuario.nomeTela );
		botaoAlterarCadastro.setDisable(true);
		botaoexcluirCadastro.setDisable(true);
		botaoInserirAluno.setDisable(true);
		textoInserir.setOpacity(0.5);
		textoAlterar.setOpacity(0.5);
		textoExcluir.setOpacity(0.5);
		genero.setDisable(true);
		estadoCivil.setDisable(true);
		cpf.setDisable(true);
		registroGeral.setDisable(true);
		endereco.setDisable(true);
		email.setDisable(true);
		numero.setDisable(true);
		telefone.setDisable(true);
		celular.setDisable(true);
		cep.setDisable(true);
		cidade.setDisable(true);
		unidadeFederal.setDisable(true);
		unidadeOrganizacional.setDisable(true);
		categoriaUsuario.setDisable(true);
		turno.setDisable(true);
		nomeAluno.setDisable(true);
		bairro.setDisable(true);


		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		TimerTask tarefa = new TimerTask(){

			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					public void run(){
						horaTela.setText(formatar.format(new Date()));

					}
				});


			}

		};
		new Timer().scheduleAtFixedRate(tarefa, 0,1000);

	}

}


