package it.polito.tdp.parole;
import javafx.scene.control.Label;
import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.Parole2;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	Parole2 elenco2;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    private Label txtTempo;

    @FXML
    private Button btnCancella;
    
    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	// ArrayList
    	long tempo1 = System.nanoTime();
    	String parola = txtParola.getText();
    	elenco.addParola(parola);
    	txtParola.setText("");
    	elenco.getElenco();
    	String risultato = "";
		for(String s: elenco.getElenco()) {
			risultato += s +"\n";
		}
    	txtResult.setText(risultato);
    	long tempo2 = System.nanoTime();
    	long tempo = tempo2-tempo1;
    	txtTempo.setText("Tempo impiegato " + tempo);
    	
   
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	elenco.reset();
    	txtResult.setText("");
    	txtParola.setText("");
    	txtTempo.setText("");
    	
    }

    @FXML
    void doCancella(ActionEvent event) {
    	long tempo1 = System.nanoTime();
    	elenco.Cancella(txtResult.getSelectedText());
    	txtResult.clear();
    	String risultato = "";
		for(String s: elenco.getElenco()) {
			risultato += s +"\n";
		}
    	txtResult.setText(risultato);
    	long tempo2 = System.nanoTime();
    	long tempo = tempo2-tempo1;
    	txtTempo.setText("Tempo impiegato " + tempo);
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}
