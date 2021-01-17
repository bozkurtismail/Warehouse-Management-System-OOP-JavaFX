
package Controller.application.depo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author İsmail BOZKURT
 */
public class MarkaEkleController implements Initializable {

    @FXML
    private TextField tfMarkaIsmi;
    @FXML
    private Button btnMarkaEkle;
    @FXML
    public Button btnGuncelle;
    @FXML
    public Label lblUst;
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
    private void btnMarkaEkleOnAction(ActionEvent event) {
    }

    @FXML
    private void btnGuncelleOnAction(ActionEvent event) {
    }

    @FXML
    private void btnKapatOnAction(ActionEvent event) {
        Stage stage = (Stage) btnKapat.getScene().getWindow();
        stage.close();
    }
    
}
