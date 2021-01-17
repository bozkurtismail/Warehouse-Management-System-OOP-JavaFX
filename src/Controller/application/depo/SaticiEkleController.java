
package Controller.application.depo;

import Dosya.DosyaSatici;
import Entity.Satici;
import Genel.EffectUtility;
import Media.KullaniciAdiMedya;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 *
 * @author İsmail BOZKURT
 */
public class SaticiEkleController implements Initializable {

    @FXML
    private AnchorPane apIcerik;
    @FXML
    private TextField tfSaticiIsmi;
    @FXML
    private TextArea taSaticiAdresi;
    @FXML
    private Button btnKaydet;
    @FXML
    public Button btnGuncelle;
    @FXML
    public Label lblBaslik;
    @FXML
    private Button btnKapat;
     @FXML
    private TextArea taSaticiTelefonu;
     
     Satici satici=new Satici();
     LinkedList<Satici> saticiListesi;
     DosyaSatici dosyaSatici;
    
    private KullaniciAdiMedya kullaniciAdiMedya=new KullaniciAdiMedya();
   

    public KullaniciAdiMedya getKullaniciAdiMedya() {
        return kullaniciAdiMedya;
    }

    public void setKullaniciAdiMedya(KullaniciAdiMedya kullaniciAdiMedya) {
        this.kullaniciAdiMedya = kullaniciAdiMedya;
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            StringBuilder builder = new StringBuilder();
            builder.append(LocalDateTime.now().getYear());
            builder.append(LocalDateTime.now().getMonthValue());
            builder.append(LocalDateTime.now().getDayOfMonth());
            builder.append(LocalDateTime.now().getHour());
            builder.append(LocalDateTime.now().getMinute());
            builder.append(LocalDateTime.now().getSecond()); 
            satici.setId(builder.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    

    @FXML
    private void btnKaydetOnAction(ActionEvent event) throws Exception {
        if(bosMu()){
            satici.setSaticiIsmi(tfSaticiIsmi.getText());
            satici.setSaticiTelefonu(taSaticiTelefonu.getText());
            satici.setSaticiAdresi(taSaticiAdresi.getText());
            satici.setOlusturan(kullaniciAdiMedya.getIsim()+" "+kullaniciAdiMedya.getSoyisim());
            
            satici.setTarih(LocalDate.now().toString());
            saticiListesi=new LinkedList<>();
            saticiListesi.add(satici);
            dosyaSatici=new DosyaSatici();
            dosyaSatici.dosyayaYaz(saticiListesi);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Basarili");
                alert.setHeaderText("Kaydedildi");
                alert.setContentText("Satici" + "  '" + satici.getSaticiIsmi() + "' " + "Basariyla Eklendi");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            
            ekraniTemizle();            
        }
        
    }
    
    public boolean bosMu(){
        boolean bosmu;
        
        if (tfSaticiIsmi.getText().trim().isEmpty()
                ||taSaticiTelefonu.getText().trim().isEmpty()
                ||taSaticiAdresi.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("HATA");
            alert.setHeaderText("HATA : BOS ALANLAR BULUNDU");
            alert.setContentText("Lutfen tum gerekli alanlari doldurun");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            bosmu = false;
        } else {
            bosmu = true;
        }
        
        return bosmu;
    }
    public void ekraniTemizle(){
        tfSaticiIsmi.clear();
        taSaticiTelefonu.clear();
        taSaticiAdresi.clear();
    }

    @FXML
    private void btnGuncelleAction(ActionEvent event) {
    }

    @FXML
    private void apOnMouseDragged(MouseEvent event) {
    }

    @FXML
    private void apOnMousePressed(MouseEvent event) {
    }

    @FXML
    private void btnKapatnAction(ActionEvent event) {
        Stage stage = (Stage) btnKapat.getScene().getWindow();
        stage.close();
    }
    public void saticiEkleStage(Stage stage) {
       
        EffectUtility.makeDraggable(stage, apIcerik);
    }
    
}
