package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.modele.StackImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {

    @FXML
    private Label reponse;

    @FXML
    private TextField requete;

    @FXML
    private Button validRequete;
    
    @FXML
    private Pane pane;
    
    @FXML
    private Label text;
    
    @FXML
    private Label titrePane;

    private StackImpl stackImpl;
    
    private ArrayList<String> historique;
    
    @FXML
    void calculate(ActionEvent event) {
        //2+(2+9-9)
        System.out.println("calculate");
        String requete = getRequete();
        String rep = this.stackImpl.infixToPostfix(requete);
        int reponse = this.stackImpl.postfixToEvaluation(rep);
        afficheReponse(reponse);
        this.historique.add(requete +" = "+ Integer.toString(reponse)) ;
        historique();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        this.reponse.setText("");
        this.validRequete = new Button();
        this.stackImpl = new StackImpl();
        this.historique = new ArrayList<String>();
        
    }

    public String getRequete() {
        return this.requete.getText();
    }


    public void afficheReponse(Integer i) {
        this.reponse.setText("La réponse est : "+Integer.toString(i));
    }
    
    public void historique() {
    	for(int i=0; i < this.historique.size();i++) {
    		Label reponse = new Label(this.historique.get(i));
			System.out.println("fu");
			
				reponse.setLayoutX(8);
			
			
				

			
			
			this.pane.getChildren().add(reponse);
			if(i>=10) {
				break;

			}
    	}
    }
}
