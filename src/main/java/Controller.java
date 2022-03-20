import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable{

    @FXML
    private Label reponse;

    @FXML
    private TextField requete;

    @FXML
    private Button validRequete;

    private StackImpl stackImpl;
    @FXML
    void calculate(ActionEvent event) {
    	//2+(2+9-9)
    	System.out.println("calculate");
    		String rep = this.stackImpl.infixToPostfix(getRequete());
    		afficheReponse(this.stackImpl.postfixToEvaluation(rep));
    	
}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.reponse.setText("");		
		this.validRequete = new Button();
		this.stackImpl = new StackImpl();
	}
	
	public String getRequete() {
		return this.requete.getText();
	}

	
	public void afficheReponse(Integer i) {
		this.reponse.setText(Integer.toString(i));
	}
}
