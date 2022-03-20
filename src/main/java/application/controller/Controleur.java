package application.Controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Modele.Calculator;
import application.Modele.StackImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
	
public class Controleur implements Initializable{

    @FXML
    private Label reponse;

    @FXML
    private TextField requete;

    @FXML
    private Button validRequete;
    
    @FXML
    private Button aide;
    
    @FXML
    private Button quit;
    
    @FXML
    private Pane paneAide;

    @FXML
    private Label textAide;

    @FXML
    private Button quitAide;
    
    @FXML
    private Pane pane;
    
    @FXML
    private Label text;
    
    @FXML
    private Label titreHistorique;

    private StackImpl stackImpl;
    
    private ArrayList<String> historique;
    
    @FXML
    private Pane paneHistorique;

    
    private Calculator cal;
    @FXML
    private Pane paneRecherche;
    
    @FXML
    void calculate(ActionEvent event) {
        //2+(2+9-9)
        System.out.println("calculate");
        String requete = getRequete();
        String rep = this.cal.infixToPostfix(requete);
        int reponse = this.cal.postfixToEvaluation(rep);
        afficheReponse(reponse);
        this.historique.add( requete +" = "+ Integer.toString(reponse)) ;
        historique();

    }
    
    @FXML
    void aide(ActionEvent event) {
    	this.paneAide.setVisible(true);
    	this.paneHistorique.setVisible(false);
    }

    @FXML
    void quitter(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void quitAide(ActionEvent event) {
    	this.paneAide.setVisible(false);
    	this.paneHistorique.setVisible(true);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        this.reponse.setText("");
        this.validRequete = new Button();
        this.stackImpl = new StackImpl();
        this.historique = new ArrayList<String>();
        this.paneAide.setVisible(false);    
        initAide();
        this.cal = new Calculator();
    }

    public String getRequete() {
        return this.requete.getText();
    }


    public void afficheReponse(Integer i) {
        this.reponse.setText("La réponse est : "+Integer.toString(i));
    }
    
    public void historique() {
    	int compt2 =0;
    	int compt3 = 0;
    	for(int i=0; i < this.historique.size();i++) {
    		Label reponse = new Label(this.historique.get(i));

			if(i<7) {
				reponse.setLayoutX(8);
				reponse.setLayoutY(i*30+50);
			}
			if(i>=7) {
				reponse.setLayoutX(208);
				reponse.setLayoutY(compt2*30+50);
				compt2++;

			}
			 if(i >=14) {
				reponse.setLayoutX(408 );
				reponse.setLayoutY(compt3*30+50);
				compt3++;
			}
			this.paneHistorique.getChildren().add(reponse);

			if(i>=21) {
				this.historique.clear();
				this.paneHistorique.getChildren().clear();
				this.paneHistorique.getChildren().add(titreHistorique);
				i=0;
			}
    	}
    }
    
    public void initAide() {
    	this.textAide.setText("	Symboles autorisés :  \n\n "
    			+ "		Multiplication : * \n "
    			+ "		Addition : + \n "
    			+ "		Soustraction : - \n "
    			+ "		Division : / \n "
    			+ "		Parenthèses ( ) \n "
    			+ "		Chiffre 0 à 9");
    }
    
}
