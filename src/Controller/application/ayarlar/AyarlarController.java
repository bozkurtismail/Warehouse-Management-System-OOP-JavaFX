
package Controller.application.ayarlar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author İsmail BOZKURT
 */
public class AyarlarController implements Initializable {

    @FXML
    public BorderPane bpAyarlar;
    @FXML
    private Label lblSımdikiDurum;
    @FXML
    private StackPane spAyarlarIcerik;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void hesabimOnClick(ActionEvent event) throws IOException {

        lblSımdikiDurum.setText("Hesabim");
        HesabimController hc = new HesabimController();
//        userNameMedia usrIdMedia = new userNameMedia();
        FXMLLoader fxmlload = new FXMLLoader();
        fxmlload.load(getClass().getResource("/View/application/ayarlar/Hesabim.fxml").openStream());

        HesabimController hesabim = fxmlload.getController();

        hesabim.detaylariGoster();
        AnchorPane acPane = fxmlload.getRoot();
        spAyarlarIcerik.getChildren().clear();
        spAyarlarIcerik.getChildren().add(acPane);
    }
}
