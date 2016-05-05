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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;


public class TelaDevolucaoController implements Initializable {

	private GerenciadorEmprestimo gerenciador;

	public TelaDevolucaoController () {
		gerenciador = GerenciadorEmprestimo.getInstance();
	}



	@FXML
	private Button botaoDevolverChave;

	@FXML
	private Label nomeAluno;

	@FXML
	private Label textoregistroChave;

	@FXML
	private Label dataDevolucao;

	@FXML
	private Button voltarTelaUsuario;

	@FXML
	private Button botaoSair;

	@FXML
	private Button botaoLimparTexto;

	@FXML
	private TextField exemplar;

	@FXML
	private Label TextoSejaBemVindo;

	@FXML
	private Label horaTela;


	@FXML
	private Text textoDevolver;

	@FXML
	public void LimparTexto(ActionEvent event) {
		exemplar.clear();
		nomeAluno.setText("");
		dataDevolucao.setText("");
		textoregistroChave.setText("");

	}

	@FXML
	public void devolverChave(ActionEvent event) {
		gerenciador.devolucao(exemplar.getText());
		nomeAluno.setText("");
		textoregistroChave.setText("");
		dataDevolucao.setText("");
		exemplar.setText("");
		criaAlert(AlertType.INFORMATION, "", "Devolvido com Sucesso por: "+ Usuario.nomeTela ).show();
		botaoDevolverChave.setDisable(true);

	}

	@FXML
	public void voltarTelaLogin(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Principal.SCENE.setRoot(parent);

	}
	@FXML
	public void voltarTela(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaUsuario.fxml"));
		Principal.SCENE.setRoot(parent);

	}



	@FXML
	public void registroDigitado(KeyEvent event) throws Exception {
		if (event.getCode() == KeyCode.TAB) {
			tentaDevolver(event);
		}
	}



	private void tentaDevolver(Event event) {
		if(exemplar.getText().length()!=0 ){
			if(gerenciador.existeChave(exemplar.getText())){
				if(gerenciador.estaLivre(exemplar.getText())==false){
					for(Chave chave : gerenciador.chaves.keySet()){
						if(exemplar.getText().equals(chave.getRegistro())){

							String matricula = (gerenciador.chaves.get(chave));
							nomeAluno.setText(gerenciador.alunos.get(matricula).getNome());
							textoregistroChave.setText("Armário - " +  exemplar.getText());
							dataDevolucao.setText("Data prevista de Devolução:  " + gerenciador.dataDevolucao() + "  Data efetiva: " + gerenciador.dataefetiva());
							botaoDevolverChave.setDisable(false);
							textoDevolver.setOpacity(1);

						}
					}
				}else{
					criaAlert(AlertType.ERROR, "", " Nenhum armário emprestado com o código informado!").show();
					exemplar.setText("");
				}
			}else{
				criaAlert(AlertType.ERROR, "", "Código informado não existe!").show();
				exemplar.setText("");
			}
		}else{
			criaAlert(AlertType.ERROR, "", "O campo LER EXEMPLAR deve ser preenchido").show();
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
		botaoDevolverChave.setDisable(true);
		textoDevolver.setOpacity(0.5);
		TextoSejaBemVindo.setText("Bem-vindo(a), "+ Usuario.nomeTela );

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
