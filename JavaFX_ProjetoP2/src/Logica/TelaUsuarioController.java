package Logica;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class TelaUsuarioController implements Initializable {

	@FXML
	private Button botaoCadastrarAluno;

	@FXML
	private Button botaoEmprestimo;

	@FXML
	private Button botaoChamaTelaDeDevolucao;

	@FXML
	private Button botaoRemoverAluno;

	@FXML
	private Button botaoSair;

	@FXML
	private Label textoSejaBemVindo;

	@FXML
	private Label horaTela;



	@FXML
	public void ChamaTelaCadastrarAluno(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaCadastrarAluno.fxml"));
		Principal.SCENE.setRoot(parent);

	}

	@FXML
	public void ChamaTelaDeDevolucao(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaDevolucao.fxml"));
		Principal.SCENE.setRoot(parent);
	}

	@FXML
	public void ChamaTelaDeEmprestimo(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaEmprestimo.fxml"));
		Principal.SCENE.setRoot(parent);
	}

	@FXML
	public void ChamaTelaInicial(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Principal.SCENE.setRoot(parent);

	}

	@FXML
	public void ChamaTelaRemoverAluno(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaConsultaArmario.fxml"));
		Principal.SCENE.setRoot(parent);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textoSejaBemVindo.setText("Bem-vindo(a), " + Usuario.nomeTela);

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
