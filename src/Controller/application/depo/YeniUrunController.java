package Controller.application.depo;

import Dosya.DosyaDepo;
import Dosya.DosyaSatici;
import Dosya.DosyaUrunler;
import Entity.Kasa;
import Entity.Satici;
import Entity.Toner;
import Entity.Urunler;
import Entity.Yazici;
import Media.KullaniciAdiMedya;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author İsmail BOZKURT
 */

public class YeniUrunController implements Initializable {

    @FXML
    public Label lblUst;
    @FXML
    private Label lblUrunId;
    @FXML
    private Label lblUrunIsmi;
    @FXML
    private Label lblAlimYapan;
    @FXML
    private Label lblAciklama;
    @FXML
    private Label lblSatici;
    @FXML
    private Label lblMarka;
    @FXML
    private Label lblModel;
    @FXML
    private Label lblAlimTarihi;
    @FXML
    private TextField tfUrunId;
    @FXML
    private TextArea taUrunAciklama;
    @FXML
    private DatePicker dpDate;
    @FXML
    public Button btnKaydet;
    @FXML
    private ComboBox<String> cbSatici;
    @FXML
    private ComboBox<String> cmbMarka;
    @FXML
    private ComboBox<String> cmbModel;
    @FXML
    public Button btnGuncelle;
    @FXML
    public ComboBox<String> cbAlimYapan;
    @FXML
    private ComboBox<String> cbUrunIsmi;
    @FXML
    private Button btnSaticiEkle;
    @FXML
    private Button btnMarkaEkle;
    @FXML
    private Button btnModelEkle;
    @FXML
    private Label lblSeriNo;
    @FXML
    private TextField tfSeriNo;
    @FXML
    private Label lblIslemciMarkasi;
    @FXML
    private ComboBox<String> cbIslemciMarkasi;
    @FXML
    private Label lblRamKapasitesi;
    @FXML
    private ComboBox<String> cbRamKapasitesi;
    @FXML
    private Label lblBaskiSayisi;
    @FXML
    private TextField tfBaskiSayisi;
    @FXML
    private Label lblUyumluModeller;
    @FXML
    private TextField tfUyumluModeller;
    @FXML
    private Label lblKapasitesi;
    @FXML
    private TextField tfKapasitesi;
    @FXML
    private Button btnKapat;

    LinkedList<Kasa> kasaListesi;
    LinkedList<Yazici> yaziciListesi;
    LinkedList<Toner> tonerListesi;
    DosyaUrunler dosyaurunler;
    DosyaDepo dosyaDepo;

    private KullaniciAdiMedya kullaniciAdiMedya = new KullaniciAdiMedya();
    private LinkedList<Satici> saticiListesi = new LinkedList<Satici>();

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
            tfUrunId.setText(builder.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tfUrunId.setEditable(false);

        lblAlimYapan.setVisible(false);
        cbAlimYapan.setVisible(false);
        lblAciklama.setVisible(false);
        taUrunAciklama.setVisible(false);
        lblAlimTarihi.setVisible(false);
        dpDate.setVisible(false);
        lblSatici.setVisible(false);
        cbSatici.setVisible(false);
        btnSaticiEkle.setVisible(false);
        lblMarka.setVisible(false);
        cmbMarka.setVisible(false);
        btnMarkaEkle.setVisible(false);
        lblModel.setVisible(false);
        cmbModel.setVisible(false);
        btnModelEkle.setVisible(false);
        lblSeriNo.setVisible(false);
        tfSeriNo.setVisible(false);
        lblIslemciMarkasi.setVisible(false);
        cbIslemciMarkasi.setVisible(false);
        lblRamKapasitesi.setVisible(false);
        cbRamKapasitesi.setVisible(false);
        lblBaskiSayisi.setVisible(false);
        tfBaskiSayisi.setVisible(false);
        lblUyumluModeller.setVisible(false);
        tfUyumluModeller.setVisible(false);
        lblKapasitesi.setVisible(false);
        tfKapasitesi.setVisible(false);

        LinkedList<String> saticiIsmi = new LinkedList<>();
        try {
            DosyaSatici saticiListesi = new DosyaSatici();
            this.saticiListesi = saticiListesi.dosyadanOku();
            for (int i = 0; i < this.saticiListesi.size(); i++) {
                System.out.println("i nin degeri=" + i + " " + this.saticiListesi.get(i).getSaticiIsmi());
                ObservableList<String> liste = FXCollections.observableArrayList(this.saticiListesi.get(i).getSaticiIsmi(), this.saticiListesi.get(i + 1).getSaticiIsmi(), this.saticiListesi.get(i + 2).getSaticiIsmi());
                cbSatici.setItems(liste);
            }
        } catch (Exception ex) {
            System.out.println("error");
        }
    }

    @FXML
    private void btnSaticiEkleOnAction(ActionEvent event) {

        SaticiEkleController saticiEkleController = new SaticiEkleController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/View/Application/depo/SaticiEkle.fxml"));

        try {
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            SaticiEkleController saticiController = fXMLLoader.getController();
            KullaniciAdiMedya medya = new KullaniciAdiMedya();
            medya = kullaniciAdiMedya;
            saticiController.setKullaniciAdiMedya(medya);

            saticiController.lblBaslik.setText("Satici Ekle");
            saticiController.btnGuncelle.setVisible(false);

            Stage nStage = new Stage();
            saticiController.saticiEkleStage(nStage);
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnMarkaEkleOnAction(ActionEvent event) {
        MarkaEkleController markaEkleController = new MarkaEkleController();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/application/depo/MarkaEkle.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            MarkaEkleController markaController = fxmlLoader.getController();

            markaController.lblUst.setText("Marka Ekle");
            markaController.btnGuncelle.setVisible(false);

            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnModelEkleOnAction(ActionEvent event) {
        ModelEkleController modelEkleController = new ModelEkleController();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/application/depo/ModelEkle.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            ModelEkleController markaController = fxmlLoader.getController();

            markaController.lblUst.setText("Model Ekle");
            markaController.btnGuncelle.setVisible(false);

            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cbSaticiOnClicked(MouseEvent event) {
    }

    @FXML
    private void cbSaticiOnAction(ActionEvent event) {
    }

    @FXML
    private void cmbMarkaOnClick(MouseEvent event) {
    }

    @FXML
    private void cmbMarkaOnAction(ActionEvent event) {
    }

    @FXML
    private void cmbModelOnClick(MouseEvent event) {
    }

    @FXML
    private void cmbModelOnAction(ActionEvent event) {
    }

    @FXML
    private void btnGuncelleOnAction(ActionEvent event) {
    }

    @FXML
    private void cbAlimYapanOnAction(ActionEvent event) {
    }

    @FXML
    private void btnKapatOnAction(ActionEvent event) {
        Stage stage = (Stage) btnKapat.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cbUrunIsmiOnAction(ActionEvent event) {
        if (cbUrunIsmi.getValue().equals("Bilgisayar")) {
            lblAlimYapan.setVisible(true);
            cbAlimYapan.setVisible(true);
            lblAciklama.setVisible(true);
            taUrunAciklama.setVisible(true);
            lblAlimTarihi.setVisible(true);
            dpDate.setVisible(true);
            lblSatici.setVisible(true);
            cbSatici.setVisible(true);
            btnSaticiEkle.setVisible(true);
            lblMarka.setVisible(true);
            cmbMarka.setVisible(true);
            btnMarkaEkle.setVisible(true);
            lblModel.setVisible(true);
            cmbModel.setVisible(true);
            btnModelEkle.setVisible(true);
            lblSeriNo.setVisible(true);
            tfSeriNo.setVisible(true);
            lblIslemciMarkasi.setVisible(true);
            cbIslemciMarkasi.setVisible(true);
            lblRamKapasitesi.setVisible(true);
            cbRamKapasitesi.setVisible(true);
            lblBaskiSayisi.setVisible(false);
            tfBaskiSayisi.setVisible(false);
            lblUyumluModeller.setVisible(false);
            tfUyumluModeller.setVisible(false);
            lblKapasitesi.setVisible(false);
            tfKapasitesi.setVisible(false);
        } else if (cbUrunIsmi.getValue().equals("Yazici")) {
            lblAlimYapan.setVisible(true);
            cbAlimYapan.setVisible(true);
            lblAciklama.setVisible(true);
            taUrunAciklama.setVisible(true);
            lblAlimTarihi.setVisible(true);
            dpDate.setVisible(true);
            lblSatici.setVisible(true);
            cbSatici.setVisible(true);
            btnSaticiEkle.setVisible(true);
            lblMarka.setVisible(true);
            cmbMarka.setVisible(true);
            btnMarkaEkle.setVisible(true);
            lblModel.setVisible(true);
            cmbModel.setVisible(true);
            btnModelEkle.setVisible(true);
            lblSeriNo.setVisible(true);
            tfSeriNo.setVisible(true);
            lblBaskiSayisi.setVisible(true);
            tfBaskiSayisi.setVisible(true);
            lblIslemciMarkasi.setVisible(false);
            cbIslemciMarkasi.setVisible(false);
            lblRamKapasitesi.setVisible(false);
            cbRamKapasitesi.setVisible(false);
        } else if (cbUrunIsmi.getValue().equals("Toner")) {
            lblAlimYapan.setVisible(true);
            cbAlimYapan.setVisible(true);
            lblAciklama.setVisible(true);
            taUrunAciklama.setVisible(true);
            lblAlimTarihi.setVisible(true);
            dpDate.setVisible(true);
            lblSatici.setVisible(true);
            cbSatici.setVisible(true);
            btnSaticiEkle.setVisible(true);
            lblUyumluModeller.setVisible(true);
            tfUyumluModeller.setVisible(true);
            lblKapasitesi.setVisible(true);
            tfKapasitesi.setVisible(true);
            lblMarka.setVisible(false);
            cmbMarka.setVisible(false);
            btnMarkaEkle.setVisible(false);
            lblModel.setVisible(false);
            cmbModel.setVisible(false);
            btnModelEkle.setVisible(false);
            lblSeriNo.setVisible(false);
            tfSeriNo.setVisible(false);
            lblIslemciMarkasi.setVisible(false);
            cbIslemciMarkasi.setVisible(false);
            lblRamKapasitesi.setVisible(false);
            cbRamKapasitesi.setVisible(false);
            lblBaskiSayisi.setVisible(false);
            tfBaskiSayisi.setVisible(false);
        }
    }

    @FXML
    private void cbAlimYapanOnClicked(MouseEvent event) {
    }

    @FXML
    private void cbIslemciMarkasiOnClicked(MouseEvent event) {
    }

    @FXML
    private void cbRamKapasitesiOnClicked(MouseEvent event) {
    }

    @FXML
    private void btnKaydetOnAction(ActionEvent event) throws Exception {
        Urunler urunler = null;
        if (cbUrunIsmi.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "LUTFEN URUN ISMI SECINIZ....").showAndWait();
        } else if (cbUrunIsmi.getValue().equals("Bilgisayar") && cbUrunIsmi.getValue() != null) {
            System.out.println("deneme1");
            urunler = new Kasa();//polimorfizim geç bağlama

        } else if (cbUrunIsmi.getValue().equals("Yazici") && cbUrunIsmi.getValue() != null) {
            System.out.println("deneme2");
            urunler = new Yazici();
        } else if (cbUrunIsmi.getValue().equals("Toner") && cbUrunIsmi.getValue() != null) {
            System.out.println("deneme3");
            urunler = new Toner();
        }
        if (urunler != null) {
            urunler.setId(tfUrunId.getText());
            urunler.setUrunIsmi(cbUrunIsmi.getSelectionModel().getSelectedItem().toString());
            urunler.setAlimYapan(cbAlimYapan.getSelectionModel().getSelectedItem().toString());

            urunler.setAciklama(taUrunAciklama.getText());
            urunler.setAlimTarihi(dpDate.getValue().toString());
            System.out.println(urunler.getId() + " " + urunler.getUrunIsmi() + " " + urunler.getAlimYapan() + " " + urunler.getAciklama() + " " + urunler.getAlimTarihi());
            urunler.setSatici(cbSatici.getSelectionModel().getSelectedItem().toString());
            if (urunler instanceof Kasa) {
                Kasa kasaNesnesi = (Kasa) urunler;//down casting
                System.out.println("KASA NESNESİ+++++++++++++++++++++++++");
                kasaNesnesi.setMarka(cmbMarka.getSelectionModel().getSelectedItem().toString());
                kasaNesnesi.setModel(cmbModel.getSelectionModel().getSelectedItem().toString());
                kasaNesnesi.setSeriNo(tfSeriNo.getText());
                kasaNesnesi.setIslemciMarkasi(cbIslemciMarkasi.getSelectionModel().getSelectedItem().toString());
                kasaNesnesi.setRamKapasitesi(cbRamKapasitesi.getSelectionModel().getSelectedItem().toString());
                kasaListesi = new LinkedList<>();
                kasaListesi.add(kasaNesnesi);
                dosyaurunler = new DosyaUrunler();
                dosyaurunler.kasaDosyayaYaz(kasaListesi);
                kasaNesnesi.depoyaYerlestir(kasaNesnesi);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Basarili");
                alert.setHeaderText("Kaydedildi");
                alert.setContentText("Urun" + "  '" + kasaNesnesi.getUrunIsmi() + "' " + "Basariyla Eklendi");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();

                ekraniTemizle();
            } else if (urunler instanceof Yazici) {
                Yazici yaziciNesnesi = (Yazici) urunler;//down casting
                System.out.println("YAZICI NESNESI+++++++++++++++++++++++++");

                yaziciNesnesi.setMarka(cmbMarka.getSelectionModel().getSelectedItem().toString());
                yaziciNesnesi.setModel(cmbModel.getSelectionModel().getSelectedItem().toString());
                yaziciNesnesi.setSeriNo(tfSeriNo.getText());
                yaziciNesnesi.setBaskiSayisi(tfBaskiSayisi.getText());

                yaziciListesi = new LinkedList<>();
                yaziciListesi.add(yaziciNesnesi);
                dosyaurunler = new DosyaUrunler();
                dosyaurunler.yaziciDosyayaYaz(yaziciListesi);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Basarili");
                alert.setHeaderText("Kaydedildi");
                alert.setContentText("Urun" + "  '" + yaziciNesnesi.getUrunIsmi() + "' " + "Basariyla Eklendi");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();

                ekraniTemizle();
            } else if (urunler instanceof Toner) {
                Toner tonerNesnesi = (Toner) urunler;//down casting
                System.out.println("TONER NESNESI+++++++++++++++++++++++++");

                tonerNesnesi.setUyumluModeller(tfUyumluModeller.getText());
                tonerNesnesi.setKapasitesi(tfKapasitesi.getText());

                tonerListesi = new LinkedList<>();
                tonerListesi.add(tonerNesnesi);
                dosyaurunler = new DosyaUrunler();
                dosyaurunler.tonerDosyayaYaz(tonerListesi);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Basarili");
                alert.setHeaderText("Kaydedildi");
                alert.setContentText("Urun" + "  '" + tonerNesnesi.getUrunIsmi() + "' " + "Basariyla Eklendi");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();

                ekraniTemizle();
            }
        }
    }

    public void ekraniTemizle() {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(LocalDateTime.now().getYear());
            builder.append(LocalDateTime.now().getMonthValue());
            builder.append(LocalDateTime.now().getDayOfMonth());
            builder.append(LocalDateTime.now().getHour());
            builder.append(LocalDateTime.now().getMinute());
            builder.append(LocalDateTime.now().getSecond());
            tfUrunId.setText(builder.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tfUrunId.setEditable(false);
        cbUrunIsmi.setValue(null);        
        taUrunAciklama.clear();
        dpDate.setValue(null);
        cbSatici.setValue(null);
        cmbMarka.setValue(null);
        cmbModel.setValue(null);
        tfSeriNo.clear();
        cbIslemciMarkasi.setValue(null);
        cbRamKapasitesi.setValue(null);
        tfBaskiSayisi.clear();
        tfKapasitesi.clear();
        tfUyumluModeller.clear();
    }

}
