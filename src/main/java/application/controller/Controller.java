package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.data.CData;
import application.modele.StackImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {

    private CData data;

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
    
    @FXML
    void calculate(ActionEvent event) {
        String requete = this.requete.getText();
        String rep = this.stackImpl.infixToPostfix(requete);
        int reponse = this.stackImpl.postfixToEvaluation(rep);
        afficheReponse(reponse);

        // Ajouter le calcul dans l'historique
        data.getHistorique().add(reponse + " = " + reponse);

        // Rafraichir l'historique
        updateHistorique();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // Initialiser les données
        this.data = new CData();

        this.reponse.setText("");
        this.validRequete = new Button();
        this.stackImpl = new StackImpl();
    }

    public void afficheReponse(Integer i) {
        reponse.setText("La réponse est : " + i);
    }
    
    public void updateHistorique() {
    	for(int i = 0; i < Math.min(data.getHistorique().size(), 10); i++) {
    		Label reponse = new Label(data.getHistorique().get(i));
			reponse.setLayoutX(8);
			pane.getChildren().add(reponse);
    	}
    }
}
