
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class TelaEmprestimoController implements Initializable{


	private GerenciadorEmprestimo gerenciador;


	public TelaEmprestimoController() {
		gerenciador = GerenciadorEmprestimo.getInstance();
	}

	@FXML
	private TextField matriculaAluno;

	@FXML
	private TextField registroChave;

	@FXML
	private  TextField nomeAluno;

	@FXML
	private Button botaoConfirmaEmprestimo;

	@FXML
	private Button botaoLimparTexto;

	@FXML
	private Button botaoSair;

	@FXML
	private Button botaoVoltarTela;	

	@FXML
	private Button botaoBuscarAluno;

	@FXML
	private ImageView fotoAluno;

	@FXML
	private Label textoSejaBemvindo;

	@FXML
	private Label horaTela;

	@FXML
	private Label textoUO;

	@FXML
	private Label textoCategoria;

	@FXML
	private Label textoTipoDeEmprestimo;

	@FXML
	public void LimparTexto(ActionEvent event) {
		nomeAluno.setText("");
		textoUO.setText("");
		textoCategoria.setText("");
		textoTipoDeEmprestimo.setText("");
		matriculaAluno.setText("");


	}

	@FXML
	public void voltarTelaUsuario(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaUsuario.fxml"));
		Principal.SCENE.setRoot(parent);
		TelaBuscarAlunoController.nome = "";
		TelaBuscarAlunoController.matricula = "";



	}



	@FXML
	public void buscarAluno(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaBuscarAluno.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("");
		stage.show();


	}

	@FXML
	private void voltarTelaInicial(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Principal.SCENE.setRoot(parent);
		TelaBuscarAlunoController.nome = "";
		TelaBuscarAlunoController.matricula = "";



	}
	@FXML
	private void ConfirmaEmprestimo(ActionEvent event) throws Exception {
		if(registroChave.getText().length()!=0){
			if(gerenciador.existeChave(registroChave.getText())){
				if(gerenciador.estaLivre(registroChave.getText())){
					if(gerenciador.possuiChave(matriculaAluno.getText())==false){
						gerenciador.aluga(registroChave.getText(),(matriculaAluno.getText()));
						criaAlert(AlertType.INFORMATION, "", "Armário " + registroChave.getText() + " emprestado com sucesso! " 
								+	"Data devolução: " + gerenciador.dataDevolucao()).show();

						nomeAluno.clear();
						textoUO.setText("");
						textoCategoria.setText("");
						textoTipoDeEmprestimo.setText("");
						matriculaAluno.clear();
						registroChave.clear();
						TelaBuscarAlunoController.nome = "";
						TelaBuscarAlunoController.matricula = "";



					}
					else{
						criaAlert(AlertType.ERROR, "Empréstimo não realizado", "Aluno já possui Armario").show();
						nomeAluno.clear();
						textoUO.setText("");
						textoCategoria.setText("");
						textoTipoDeEmprestimo.setText("");
						matriculaAluno.clear();
						registroChave.clear();
					}

				}
				else{
					criaAlert(AlertType.ERROR, "Empréstimo não realizado", "Armario Emprestado").show();
					registroChave.setText("");
				}
			}else{
				criaAlert(AlertType.ERROR, "Empréstimo não realizado", "Exemplar inexistente").show();
				registroChave.setText("");

			}
		}else{
			criaAlert(AlertType.ERROR, "", "Campo LER EXEMPLAR, deve ser preenchido").show();

		}




	}private void tentaLogin(Event event) throws Exception {
		if(matriculaAluno.getText().length()!=0){
			if(gerenciador.loginCorreto(matriculaAluno.getText())== true){
				nomeAluno.setText(gerenciador.alunos.get(matriculaAluno.getText()).getNome());
				textoUO.setText("UO: " + gerenciador.alunos.get(matriculaAluno.getText()).getUo());
				textoCategoria.setText("Categoria: " + gerenciador.alunos.get(matriculaAluno.getText()).getCategoria());
				textoTipoDeEmprestimo.setText("Tipo de Empréstimo: 1 - NORMAL");

			}else{
				criaAlert(AlertType.ERROR, "Login Nâo Realizado", "Matricula inexistente").show();
				matriculaAluno.clear();
			}

		}else{
			criaAlert(AlertType.ERROR, "Login Nâo Realizado", "Campo matricula deve ser preenchido").show();

		}
	}




	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		a.setWidth(100);
		a.setHeight(100);
		return a;
	}
	@FXML 
	public void senhaDigitada(KeyEvent event) throws Exception {
		if (event.getCode() == KeyCode.TAB) {
			tentaLogin(event);
		}



	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeAluno.setText(TelaBuscarAlunoController.nome);
		matriculaAluno.setText(TelaBuscarAlunoController.matricula);


		textoSejaBemvindo.setText("Bem-vindo(a), "+ Usuario.nomeTela );

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





