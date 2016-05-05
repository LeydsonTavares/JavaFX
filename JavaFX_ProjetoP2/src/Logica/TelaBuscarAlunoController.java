package Logica;



import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;



public class TelaBuscarAlunoController implements Initializable {

	private GerenciadorEmprestimo gerenciador;
	public static String nome = "";
	public static String matricula = "";

	@FXML
	private TableView<Aluno> tabelaAlunos;


	@FXML
	private TextField letrasParaPesquisa;

	private	ObservableList<Aluno> dados = FXCollections.observableArrayList(); 

	private ObservableList<Aluno> filtrar = FXCollections.observableArrayList();



	public TelaBuscarAlunoController(){

		gerenciador = GerenciadorEmprestimo.getInstance();
		Collection<Aluno> listaNomes= gerenciador.alunos.values();
		dados.addAll(listaNomes);
		filtrar.addAll(dados);


	}@SuppressWarnings("unchecked")
	private void colunas(){
		TableColumn<Aluno, String> nomeAluno = new TableColumn<>("Nome do Aluno");
		nomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabelaAlunos.setItems(filtrar);
		tabelaAlunos.getColumns().addAll(nomeAluno);
		nomeAluno.setPrefWidth(600);

	}



	@FXML 
	public void letraDigitada(KeyEvent evt) {
		String nome = letrasParaPesquisa.getText();
		filtrar.clear();
		if(nome.length() > 0){
			for(Aluno aluno : dados){
				if(aluno.getNome().toLowerCase().startsWith(nome.toLowerCase())){
					filtrar.add(aluno);
				}
			}
		}
	}
	@FXML
	public void mouseClicado(MouseEvent e) throws Exception{
		if(e.getClickCount()==2){
			Aluno selecionado = (Aluno) tabelaAlunos.getSelectionModel().getSelectedItem();
			gerenciador.alunos.containsValue(selecionado);
			Collection<String> matriculas = gerenciador.alunos.keySet();

			for(String mat : matriculas)
				if(gerenciador.alunos.get(mat).equals(selecionado)) {
					matricula = mat;
					nome = selecionado.getNome();
					((Node) (e.getSource())).getScene().getWindow().hide();	
					Parent parent = FXMLLoader.load(getClass().getResource("TelaEmprestimo.fxml"));
					Principal.SCENE.setRoot(parent);


				}
		}


	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		colunas();
		filtrar.clear();


	}


}







