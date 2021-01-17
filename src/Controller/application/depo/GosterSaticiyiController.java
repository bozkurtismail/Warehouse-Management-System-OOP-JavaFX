
package Controller.application.depo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author İsmail BOZKURT
 */


public class GosterSaticiyiController implements Initializable {

    @FXML
    private AnchorPane acIcerik;
    @FXML
    private TextField tfAra;
    @FXML
    private Button btnYenile;
    @FXML
    private Button btnYeniEkle;
    @FXML
    private Button btnGuncelle;
    @FXML
    private TableView<?> tblSatici;
    @FXML
    private MenuItem mbAra;
    @FXML
    private TableColumn<?, ?> clmSaticiId;
    @FXML
    private TableColumn<?, ?> clmSaticiIsmi;
    @FXML
    private TableColumn<?, ?> clmSaticiTelefonNumarasi;
    @FXML
    private TableColumn<?, ?> clmSaticiAdresi;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void tfAraOnType(KeyEvent event) {
    }

    @FXML
    private void btnYenileOnAction(ActionEvent event) {
    }

    @FXML
    private void btnYeniEkleOnAction(ActionEvent event) {
    }

    @FXML
    private void btnGuncelleOnAction(ActionEvent event) {
    }

    @FXML
    private void btnSilOnAction(ActionEvent event) {
    }

    @FXML
    private void mbAra(ActionEvent event) {
    }

    @FXML
    private void mbGoster(ActionEvent event) {
    }

    @FXML
    private void mbGecmisGosterim(ActionEvent event) {
    }

    @FXML
    private void mbYeniEkle(ActionEvent event) {
    }

    @FXML
    private void mbSil(ActionEvent event) {
    }

    @FXML
    private void mbDuzenle(ActionEvent event) {
    }

    @FXML
    private void tblSaticiOnClick(MouseEvent event) {
    }

    @FXML
    private void tblSaticiOnKeyPress(KeyEvent event) {
    }
    
    public void detaylariGoster() {
        
        
    }
    
}
