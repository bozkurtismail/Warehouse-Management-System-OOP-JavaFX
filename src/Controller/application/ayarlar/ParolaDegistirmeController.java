
package Controller.application.ayarlar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author İsmail BOZKURT
 */
public class ParolaDegistirmeController implements Initializable {

    @FXML
    private PasswordField pfSimdikiPassword;
    @FXML
    private PasswordField pfYeniPassword;
    @FXML
    private PasswordField pfTekrarTeniParola;
    @FXML
    private Button btnTemizleSimdikiniPf;
    @FXML
    private Button btnTemizleTekrarEdeni;
    @FXML
    private Button btnTemizleYeniParolayi;
    @FXML
    private ImageView imgSimdikiParola;
    @FXML
    private ImageView imgYeniParola;
    @FXML
    private Button btnParolaDegistir;
    @FXML
    private Button btnKapat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pfOnAction(ActionEvent event) {
    }

    @FXML
    private void pfYeniParolaKarsilastirma(KeyEvent event) {
    }

    @FXML
    private void btnParolaDegistirOnAction(ActionEvent event) {
    }

    @FXML
    private void btnKapatOnAction(ActionEvent event) {
        Stage stage = (Stage) btnKapat.getScene().getWindow();
        stage.close();
    }
    
}
