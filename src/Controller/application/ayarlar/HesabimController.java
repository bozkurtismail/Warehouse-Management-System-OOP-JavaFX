
package Controller.application.ayarlar;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author İsmail BOZKURT
 */
public class HesabimController implements Initializable {

    @FXML
    private AnchorPane apHesabimAna;
    @FXML
    private TextField tfKullaniciAdi;
    @FXML
    private TextField tfIsmi;
    @FXML
    private TextField tfIletisimNumarasi;
    @FXML
    private TextField tfEmailAdresi;
    @FXML
    private Button btnKaydet;
    @FXML
    private Hyperlink hlParolayiDegistir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void detaylariGoster() {

    }

    @FXML
    private void btnKaydetOnAction(ActionEvent event) {
    }

    @FXML
    private void hlParolayiDegistirOnClick(ActionEvent event) throws IOException {

        ParolaDegistirmeController pdc = new ParolaDegistirmeController();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/application/ayarlar/ParolaDegistirme.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        scene.setFill(new Color(0, 0, 0, 0));
        ParolaDegistirmeController parolaDegistirmeController = loader.getController();

        Stage nStage = new Stage();
        nStage.setScene(scene);
        nStage.setTitle("Parola Degistirme");
        nStage.initModality(Modality.APPLICATION_MODAL);
        nStage.initStyle(StageStyle.TRANSPARENT);
        nStage.show();

    }

    @FXML
    private void apAcAction(MouseEvent event) {
    }

}
