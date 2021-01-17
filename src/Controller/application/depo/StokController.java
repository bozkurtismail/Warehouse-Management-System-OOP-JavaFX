package Controller.application.depo;

import Media.KullaniciAdiMedya;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author İsmail BOZKURT
 */

public class StokController implements Initializable {

    @FXML
    public BorderPane bpDepo;
    @FXML
    private AnchorPane acUstDepo;
    @FXML
    private ToggleButton btnStok;
    @FXML
    private ToggleButton btnSatici;
    @FXML
    private ToggleButton btnMarka;
    @FXML
    private ToggleButton btnKategori;
    @FXML
    private ToggleButton btnDepo;
    @FXML
    private Label lblUst;
    @FXML
    private StackPane spAnaIcerik;
    @FXML
    private ToggleButton btnModel;

    private KullaniciAdiMedya kullaniciAdiMedya = new KullaniciAdiMedya();

    public KullaniciAdiMedya getKullaniciAdiMedya() {
        return kullaniciAdiMedya;
    }

    public void setKullaniciAdiMedya(KullaniciAdiMedya kullaniciAdiMedya) {
        this.kullaniciAdiMedya = kullaniciAdiMedya;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup toggleGroup = new ToggleGroup();
        btnStok.setSelected(true);
        btnStok.setToggleGroup(toggleGroup);
        btnSatici.setToggleGroup(toggleGroup);
        btnMarka.setToggleGroup(toggleGroup);
        btnModel.setToggleGroup(toggleGroup);
        btnDepo.setToggleGroup(toggleGroup);
    }

    @FXML
    public void btnStokOnAction(ActionEvent event) {
        try {
            lblUst.setText("Depo");
            KullaniciAdiMedya medya = new KullaniciAdiMedya();
            SimdikiStokDurumuController simdikiDurum = new SimdikiStokDurumuController();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/View/application/depo/SimdikiStokDurumu.fxml").openStream());
            medya = kullaniciAdiMedya;
            SimdikiStokDurumuController simdikiStokDurumuController = fXMLLoader.getController();
            simdikiStokDurumuController.setKullaniciAdiMedya(medya);
            StackPane acPane = fXMLLoader.getRoot();
            spAnaIcerik.getChildren().clear();
            spAnaIcerik.getChildren().add(acPane);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnSaticiFirmaOnAction(ActionEvent event) {
        try {
            lblUst.setText("Satici");

            GosterSaticiyiController gsc = new GosterSaticiyiController();

            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/View/application/depo/GosterSaticiyi.fxml").openStream());

            GosterSaticiyiController gosterSaticiyiController = fXMLLoader.getController();

            gosterSaticiyiController.detaylariGoster();
            AnchorPane acPane = fXMLLoader.getRoot();
            spAnaIcerik.getChildren().clear();
            spAnaIcerik.getChildren().add(acPane);
        } catch (IOException ex) {
            Logger.getLogger(StokController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnMarkaOnAction(ActionEvent event) {
        try {
            lblUst.setText("Marka");

            GosterMarkayiController gmc = new GosterMarkayiController();

            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/View/application/depo/GosterMarkayi.fxml").openStream());

            GosterMarkayiController gosterMarkayiController = fXMLLoader.getController();

            gosterMarkayiController.detaylariGoster();

            AnchorPane acPane = fXMLLoader.getRoot();
            spAnaIcerik.getChildren().clear();
            spAnaIcerik.getChildren().add(acPane);
        } catch (IOException ex) {
            Logger.getLogger(StokController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUniteOnAction(ActionEvent event) {
    }

    @FXML
    private void btnModelOnAction(ActionEvent event) {
        try {
            lblUst.setText("Model");

            GosterModelController gmc = new GosterModelController();

            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/View/application/depo/GosterModel.fxml").openStream());

            GosterModelController gosterModelController = fXMLLoader.getController();

            gosterModelController.detaylariGoster();

            AnchorPane acPane = fXMLLoader.getRoot();
            spAnaIcerik.getChildren().clear();
            spAnaIcerik.getChildren().add(acPane);
        } catch (IOException ex) {
            Logger.getLogger(StokController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
