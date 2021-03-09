package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	

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
    private TextField txtTempo;

    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	String parola = txtParola.getText();
    	long tempo1 = System.nanoTime();
    	elenco.addParola(parola);
    	long tempo2 = System.nanoTime();
    	txtParola.setText("");
    	elenco.getElenco();
    	String risultato = "";
		for(String s: elenco.getElenco()) {
			risultato += s +"\n";
		}
    	txtResult.setText(risultato);
    	long tempo = tempo2-tempo1;
    	txtTempo.setText("" + tempo);
    
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
    	long tempo2 = System.nanoTime();
    	txtResult.clear();
    	String risultato = "";
		for(String s: elenco.getElenco()) {
			risultato += s +"\n";
		}
    	txtResult.setText(risultato);
    	long tempo = tempo2-tempo1;
    	txtTempo.setText(""+ tempo);
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
