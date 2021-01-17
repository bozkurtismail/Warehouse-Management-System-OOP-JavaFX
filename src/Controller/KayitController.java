package Controller;

import Denetim.DenetleSifreAlanini;
import Denetim.DenetleTextAlanini;
import Entity.Kullanici;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author İsmail BOZKURT
 */
public class KayitController implements Initializable {

    @FXML
    private Hyperlink hlGiris;
    @FXML
    private TextField tfKullaniciAdi;
    @FXML
    private TextField tfisim;
    @FXML
    private PasswordField pfSifre;
    @FXML
    private PasswordField pfSifreTekrar;
    @FXML
    private Button btnKullaniciAdiTemizle;
    @FXML
    private Button btnIsimTemizle;
    @FXML
    private Button btnSifreTemizle;
    @FXML
    private Button btnTekrarSifreTemizle;
    @FXML
    private Button btnKaydol;
    @FXML
    private TextField tfsoyad;
    @FXML
    private TextField tfsicil;
    @FXML
    private Button btnSoyadTemizle;
    @FXML
    private Button btnSicilTemizle;
    private int ID = 0;
    public LinkedList<Kullanici> kullaniciLinked = new LinkedList<>();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DenetleTextAlanini denetleTextAlanini = new DenetleTextAlanini();
        DenetleSifreAlanini denetleSifreAlanini = new DenetleSifreAlanini();

        denetleTextAlanini.TemizleTextAlanini(tfKullaniciAdi, btnKullaniciAdiTemizle);
        denetleTextAlanini.TemizleTextAlanini(tfisim, btnIsimTemizle);
        denetleTextAlanini.TemizleTextAlanini(tfsoyad, btnSoyadTemizle);
        denetleTextAlanini.TemizleTextAlanini(tfsicil, btnSicilTemizle);
        denetleSifreAlanini.TemizleSifreAlanini(pfSifre, btnSifreTemizle);
        denetleSifreAlanini.TemizleSifreAlanini(pfSifreTekrar, btnTekrarSifreTemizle);

        BooleanBinding boolenBinding = tfKullaniciAdi.textProperty().isEmpty().or(tfisim.textProperty().isEmpty()
                .or(pfSifre.textProperty().isEmpty())
                .or(pfSifreTekrar.textProperty().isEmpty()));
        btnKaydol.disableProperty().bind(boolenBinding);
    }

    @FXML
    private void giriseGeriGit(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/View/Giris.fxml"));
        Scene scene = new Scene(root);
        Stage nStage = new Stage();
        nStage.setScene(scene);
        nStage.setMaximized(true);
        nStage.setTitle("EMSOT Girisine Hosgeldiniz");
        nStage.show();
        Stage hlLoginStage = (Stage) hlGiris.getScene().getWindow();
        hlLoginStage.close();
    }

    @FXML
    private void btnKaydol(ActionEvent event) {
        if (parolaKarsilastirma()) {
            Kullanici kullanici = new Kullanici();
            kullanici.setKullaniciAdi(tfKullaniciAdi.getText());
            kullanici.setAd(tfisim.getText());
            kullanici.setSoyad(tfsoyad.getText());
            kullanici.setSicilNo(tfsicil.getText());
            kullanici.setSifre(pfSifre.getText());
            kullanici.setDurum(true);
            kullanici.setPersonelID(ID);
            this.kullaniciLinked.add(kullanici);
            //System.out.println(kullanici.getPersonelID()+kullanici.getAd()+kullanici.getSoyad()+kullanici.getKullaniciAdi()+kullanici.getSifre());
            kullanici.KullaniciEkle(kullaniciLinked);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Simdi Giris");
            alert.setHeaderText("Simdi Giris");
            alert.setContentText("Yonetici hesabiniz basariyla olusturuldu \n Simdi giris yapmak icin OK'e tiklayin");
            alert.initStyle(StageStyle.UNDECORATED);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    giriseGeriGit(event);
                } catch (IOException ex) {
                    Logger.getLogger(KayitController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText("Hata");
            alert.setContentText("Lutfen sifreleri ayni giriniz");
            alert.initStyle(StageStyle.UNDECORATED);
            Optional<ButtonType> result = alert.showAndWait();
        }

    }

    private boolean parolaKarsilastirma() {

        boolean parola = false;
        String sifre = pfSifre.getText();
        String sifreTekrar = pfSifreTekrar.getText();
        if (sifre.matches(sifreTekrar)) {
            System.out.println("sifre eslesti");
            parola = true;
        } else {
            System.out.println("Password Not Match");
            parola = false;
        }
        return parola;

    }
}
