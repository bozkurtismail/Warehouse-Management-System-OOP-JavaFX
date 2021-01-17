package Controller;

import Denetim.DenetleSifreAlanini;
import Denetim.DenetleTextAlanini;
import Dosya.DosyaKullanici;
import Media.KullaniciAdiMedya;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author İsmail BOZKURT
 */

public class GirisController implements Initializable {

    @FXML
    private AnchorPane apAna;
    @FXML
    private AnchorPane apDesignPanel;
    @FXML
    private Hyperlink hlHesapOlustur;
    @FXML
    private TextField tfKulliciAdi;
    @FXML
    private PasswordField pfSifre;
    @FXML
    private Button btnKullaniciAlaniTemizle;
    @FXML
    private Button btnSifreAlaniTemizle;
    @FXML
    private Button btnGiris;

    DenetleTextAlanini denetleTextAlanini = new DenetleTextAlanini();
    DenetleSifreAlanini denetleSifreAlanini = new DenetleSifreAlanini();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        denetleTextAlanini.TemizleTextAlanini(tfKulliciAdi, btnKullaniciAlaniTemizle);
        denetleSifreAlanini.TemizleSifreAlanini(pfSifre, btnSifreAlaniTemizle);
        BooleanBinding boolenBinding = tfKulliciAdi.textProperty().isEmpty().or(pfSifre.textProperty().isEmpty());
        btnGiris.disableProperty().bind(boolenBinding);
    }

    @FXML
    private void hesapOlustur(ActionEvent event) throws Exception {
        DosyaKullanici dosyaOkumaYazma = new DosyaKullanici();
        // System.out.println(dosyaOkumaYazma.DosyaIdOku());
        if (dosyaOkumaYazma.DosyaIdOku() == null) {
            kayitEkraniniCagir();

        } else if (dosyaOkumaYazma.DosyaIdOku().equals("0")) {
            apAna.setOpacity(0.7);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText("Hata");
            alert.setContentText("Yönetici izni olmadan hesap oluşturamazsınız");

            alert.initStyle(StageStyle.UNDECORATED);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                apAna.setOpacity(1.0);
            }
            return;
        }
    }

    @FXML
    private void girisYap(ActionEvent event) {
        try {
            DosyaKullanici dosyaOkumaYazma = new DosyaKullanici();
            if (dosyaOkumaYazma.DosyaIdOku() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Kullanici Bulunamiyor");
                alert.setHeaderText("Hata:Kullanici Bulunamadi");
                alert.setContentText("Lutfen Hesap Olusturun");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
            String[] kullaniciAdi;
            String[] sifre;
            String[] id;
            String[] ad;
            String[] soyad;
            int satirSayisi = dosyaOkumaYazma.satirSayisi();
            kullaniciAdi = new String[satirSayisi];
            sifre = new String[satirSayisi];
            id=new String[satirSayisi];
            ad=new String[satirSayisi];
            soyad=new String[satirSayisi];
            
            kullaniciAdi = dosyaOkumaYazma.kullaniciAdiOku();
            sifre = dosyaOkumaYazma.sifreOku();
            id=dosyaOkumaYazma.idSiOkuma();
            ad=dosyaOkumaYazma.adOkuma();
            soyad=dosyaOkumaYazma.soyadOkuma();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/Application.fxml"));
            loader.load();
            Parent parent = loader.getRoot();
            Scene adminPanelScene = new Scene(parent);
            Stage adminPanelStage = new Stage();
            adminPanelStage.setMaximized(true);
            for (int i = 0; i < satirSayisi; i++) {
                System.out.println(kullaniciAdi[i]);
                System.out.println(sifre[i]);

                if (kullaniciAdi[i].equals(tfKulliciAdi.getText()) && sifre[i].equals(pfSifre.getText())) {
                    KullaniciAdiMedya kullaniciAdiMedya = new KullaniciAdiMedya(kullaniciAdi[i], sifre[i],id[i],ad[i],soyad[i]);
                    ApplicationController apControl = loader.getController();
                    apControl.setKullaniciAdiMedya(kullaniciAdiMedya);
                    apControl.btnAnasayfaOnClick(event);                  
                    adminPanelStage.setScene(adminPanelScene);
                    adminPanelStage.getIcons().add(new Image("/image/icon.png"));
                    adminPanelStage.setTitle(kullaniciAdi[i]);
                    adminPanelStage.show();
                    Stage stage = (Stage) btnGiris.getScene().getWindow();
                    stage.close();
                } else {
                    System.out.println("Sifre Eslesmedi");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Sifre Eslesmiyor");
                    alert.setHeaderText("Hata: KullaniciAdi veya Sifre eslesmedi");
                    alert.setContentText("KullaniciAdi veya Sifre Eslesmedi\nTekrar Deneyin");
                    alert.initStyle(StageStyle.UNDECORATED);
                    alert.showAndWait();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(GirisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void kayitEkraniniCagir() {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/Kayit.fxml"));
            Scene scene = new Scene(root);
            Stage nStage = new Stage();
            nStage.setScene(scene);
//          nStage.setMaximized(true);
            nStage.setTitle("KAYIT - EMSOT");
            nStage.show();
            Stage stage = (Stage) hlHesapOlustur.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
