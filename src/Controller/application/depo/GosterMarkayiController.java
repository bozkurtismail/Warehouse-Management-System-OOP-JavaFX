
package Controller.application.depo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author İsmail BOZKURT
 */


public class GosterMarkayiController implements Initializable {

    @FXML
    private TextField tfAra;
    @FXML
    private Button btnYenile;
    @FXML
    private Button btnMarkaEkle;
    @FXML
    private Button btnGuncelle;
    @FXML
    private Button btnSil;
    @FXML
    private TableView<?> tblMarka;
    @FXML
    private TableColumn<?, ?> tblCollumId;
    @FXML
    private TableColumn<?, ?> tblCollumMarkaIsmi;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void detaylariGoster() {        
        
    }

    @FXML
    private void tfAraOnAction(ActionEvent event) {
    }

    @FXML
    private void tfAraOnKeyPress(KeyEvent event) {
    }

    @FXML
    private void btnYenileOnAction(ActionEvent event) {
    }

    @FXML
    private void btnMarkaEkleOnAction(ActionEvent event) {
    }

    @FXML
    private void btnGuncelleOnAction(ActionEvent event) {
    }

    @FXML
    private void btnSilOnAction(ActionEvent event) {
    }

    @FXML
    private void miAra(ActionEvent event) {
    }

    @FXML
    private void miGuncelle(ActionEvent event) {
    }

    @FXML
    private void miGecmisGuncellemeyiGor(ActionEvent event) {
    }

    @FXML
    private void miSil(ActionEvent event) {
    }

    @FXML
    private void miYeniEkle(ActionEvent event) {
    }

    @FXML
    private void tblMarkaOnClick(MouseEvent event) {
    }
}
