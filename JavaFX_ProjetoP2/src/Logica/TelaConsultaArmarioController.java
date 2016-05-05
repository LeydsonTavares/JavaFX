package Logica;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class TelaConsultaArmarioController implements Initializable {

	private GerenciadorEmprestimo gerenciador;



	@FXML
	private TableView<Chave> tabelaArmarios;

	@FXML
	private Button butaosair;

	@FXML
	private Button botaoVoltarTela;

	@FXML
	private Label horaNaTela;

	@FXML
	private Label mensagemNaTela;

	@FXML
	void voltarTelaUsuario(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaUsuario.fxml"));
		Principal.SCENE.setRoot(parent);

	}

	@FXML
	void voltartelalogin(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Principal.SCENE.setRoot(parent);

	}


	ObservableList<Chave> obsChaves = FXCollections.observableArrayList();



	public TelaConsultaArmarioController(){
		gerenciador = GerenciadorEmprestimo.getInstance();
		for(Chave c : gerenciador.chaves.keySet()){
			if(gerenciador.alunos.get(c.getLocatario()) != null){
				obsChaves.add(new Chave(c.getRegistro(),"Indisponivel",gerenciador.alunos.get(c.getLocatario()),gerenciador.dataefetiva(),gerenciador.dataDevolucao()));
			}else{
				obsChaves.add(new Chave(c.getRegistro(),c.getSituacao(),"","",""));
			}
		}

	}


	@SuppressWarnings("unchecked")
	private void colunas(){
		TableColumn<Chave, String> registroColuna = new TableColumn<>("Armarios");
		registroColuna.setCellValueFactory(new PropertyValueFactory<>("registro"));
		TableColumn<Chave, String> situacaoColuna = new TableColumn<>("Situação");
		situacaoColuna.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		TableColumn<Chave, String> locatarioColuna = new TableColumn<>("Locatário");
		locatarioColuna.setCellValueFactory(new PropertyValueFactory<>("locatario"));
		TableColumn<Chave, String> dataEmpColuna = new TableColumn<>("Data empréstimo");
		dataEmpColuna.setCellValueFactory(new PropertyValueFactory<>("dataEmprestimo"));
		TableColumn<Chave, String> dataDevColuna = new TableColumn<>("Data devolução prevista");
		dataDevColuna.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));

		tabelaArmarios.setItems(obsChaves);
		tabelaArmarios.getColumns().addAll(registroColuna,situacaoColuna,locatarioColuna,dataEmpColuna,dataDevColuna);
		registroColuna.setPrefWidth(240);
		registroColuna.setResizable(false);
		situacaoColuna.setPrefWidth(240);
		situacaoColuna.setResizable(false);
		locatarioColuna.setPrefWidth(240);
		locatarioColuna.setResizable(false);
		dataEmpColuna.setPrefWidth(240);
		dataEmpColuna.setResizable(false);
		dataDevColuna.setPrefWidth(240);
		dataDevColuna.setResizable(false);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colunas();
		mensagemNaTela.setText("Bem-vindo(a), " + Usuario.nomeTela);

		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		TimerTask tarefa = new TimerTask(){

			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					public void run(){
						horaNaTela.setText(formatar.format(new Date()));

					}
				});


			}

		};
		new Timer().scheduleAtFixedRate(tarefa, 0,1000);


	}

}