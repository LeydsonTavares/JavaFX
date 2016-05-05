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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class TelaCriarUsuarioController implements Initializable {

	private GerenciadorDeUsuario gerenciador;

	public  TelaCriarUsuarioController() {
		gerenciador = GerenciadorDeUsuario.getInstance();

	}
	@FXML
	private TextField nomeUsuario;

	@FXML
	private TextField loginUsuario;

	@FXML
	private PasswordField senhaUsuario;

	@FXML
	private PasswordField confSenhaUsuario;

	@FXML
	private Button botãoVoltarTelaInicial;

	@FXML
	private Button botaoInserirUsuario;

	@FXML
	private Button botaoLimparText;

	@FXML
	private Label horaNaTela;





	@FXML
	public void InserirUsuario(ActionEvent event) throws Exception {
		if(nomeUsuario.getText().length() != 0){
			if(loginUsuario.getText().length() != 0){
				if(senhaUsuario.getText().length() != 0){
					if(confSenhaUsuario.getText().length() != 0){
						if(gerenciador.verificaLogin(loginUsuario.getText()) != true){
							if(senhaUsuario.getText().equals(confSenhaUsuario.getText())){
								gerenciador.adicionarUsuario(new Usuario(loginUsuario.getText(),senhaUsuario.getText(),nomeUsuario.getText()));
								criaAlert(AlertType.INFORMATION, " Login Inserido ", " Inserido com sucesso! ").show();
								Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
								Principal.SCENE.setRoot(parent);
								
							}else{
								senhaUsuario.clear();
								confSenhaUsuario.clear();
								criaAlert(AlertType.ERROR, " Login Nâo Realizado ", "As senhas são diferente ").show();
							}
						}else{
							loginUsuario.clear();
							criaAlert(AlertType.ERROR, " Login Nâo Realizado ", "Login já existe, tente novamente com um LOGIN novo!").show();
						}
					}else{
						criaAlert(AlertType.ERROR, " Login Nâo Realizado ", "Campo CONFIRMA SENHA deve ser preenchido!").show();
					}
				}else{
					criaAlert(AlertType.ERROR, " Login Nâo Realizado ", "Campo SENHA deve ser preenchido!").show();
				}
			}else{
				criaAlert(AlertType.ERROR, " Login Nâo Realizado ", "Campo LOGIN deve ser preenchido!").show();
			}
		}else{
			criaAlert(AlertType.ERROR, " Login Nâo Realizado ", "Campo NOME deve ser preenchido!").show();
		}
	}




	@FXML
	public void VoltarTelaInicial(ActionEvent event) throws Exception{
		Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Principal.SCENE.setRoot(parent);;
	}
	@FXML
	public void LimparText(ActionEvent event) throws Exception{
		loginUsuario.clear();
		senhaUsuario.clear();
		confSenhaUsuario.clear();
		nomeUsuario.clear();

	}
	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		return a;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
