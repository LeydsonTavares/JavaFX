package Logica;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class TelaLoginController implements Initializable {

	private GerenciadorDeUsuario gerenciador;

	public  TelaLoginController() {
		gerenciador = GerenciadorDeUsuario.getInstance();
	}



	@FXML
	private TextField loginUsuario;

	@FXML
	private PasswordField senhaUsuario;

	@FXML
	private Button botaoChamarTelaUsuario;

	@FXML
	private Button botaoChamaTelaCriarUsuario;

	@FXML
	private Button botaoLimparText;

	@FXML
	public void ChamaTelaCriarUsuario(ActionEvent event) throws Exception{
		
		Parent parent = FXMLLoader.load(getClass().getResource("TelaCriarUsuario.fxml"));
		Principal.SCENE.setRoot(parent);

	}

	@FXML
	public void ChamarTelaUsuario(ActionEvent event) throws Exception{
		tentaLogin(event);
	}

	private void tentaLogin(Event event) throws Exception {
		if(loginUsuario.getText().length()!=0 && senhaUsuario.getText().length()!=0){
			if(gerenciador.loginCorreto(loginUsuario.getText(),(senhaUsuario.getText()))== true){ 
				Parent parent = FXMLLoader.load(getClass().getResource("TelaUsuario.fxml"));
				Principal.SCENE.setRoot(parent);
			}
			else {
				criaAlert(AlertType.ERROR, "Login Nâo Realizado", "LOGIN ou SENHA, incorretos ou não existem").show();
				loginUsuario.setText("");
				senhaUsuario.setText("");
			}
		}else if(loginUsuario.getText().length()==0 && senhaUsuario.getText().length()!=0){

			criaAlert(AlertType.ERROR, "Login Nâo Realizado", "O campo 'LOGIN' deve ser preenchido").show();

		}else if(loginUsuario.getText().length()!=0 && senhaUsuario.getText().length()==0){

			criaAlert(AlertType.ERROR, "Login Nâo Realizado", "O campo 'SENHA' deve ser preenchido").show();

		}else{

			criaAlert(AlertType.ERROR, "Login Nâo Realizado", "O campo 'USUÀRIO' e 'SENHA' deve ser preenchido").show();

		}
	}

	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		return a;
	}

	@FXML
	public void LimparText(ActionEvent event) throws Exception{
		loginUsuario.clear();
		senhaUsuario.clear();
	}



	@FXML 
	public void senhaDigitada(KeyEvent event) throws Exception {
		if (event.getCode() == KeyCode.ENTER) {
			tentaLogin(event);
			
		
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loginUsuario.setText("Leydson");
		senhaUsuario.setText("153468");
		
	}
}
