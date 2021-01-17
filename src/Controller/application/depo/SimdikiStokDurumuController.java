package Controller.application.depo;

import Dosya.DosyaUrunler;
import Entity.Urunler;
import Media.KullaniciAdiMedya;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author İsmail BOZKURT
 */

public class SimdikiStokDurumuController implements Initializable {

    @FXML
    public StackPane spUrunIcerigi;
    @FXML
    private TextField tfAra;
    @FXML
    private Button btnYenile;
    @FXML
    private Button btnYeniUrun;
    @FXML
    private Button btnGuncelle;
    @FXML
    private Button btnSil;
    @FXML
    private TableView<Urunler> tblSimdikiDepoyuGoster;
    @FXML
	protected ObservableList<Urunler> tablo=FXCollections.<Urunler>observableArrayList();
	
    @FXML
    private TableColumn<Urunler, String> tblClmUrunId;
    @FXML
    private TableColumn<Urunler, String> tblClmUrunIsmi;
    private KullaniciAdiMedya kullaniciAdiMedya=new KullaniciAdiMedya();
    @FXML
    private TableColumn<Urunler, String> tblClmAlimYapan;
    @FXML
    private TableColumn<Urunler, String> tblClmAciklama;
    @FXML
    private TableColumn<Urunler, String> tblClmAlimTarihi;
    @FXML
    private TableColumn<Urunler, String> tblClmSatici;
    @FXML
    private TableColumn<Object, String> tblClmMarka;
    
    @FXML
    private TableColumn<Object, String> tblClmModel;
    @FXML
    private TableColumn<Object, String> tblClmSeriNo;
    @FXML
    private TableColumn<Object, String> tblClmIslemciMarkası;
    @FXML
    private TableColumn<Object, String> tblClmRamKapasitesi;
    @FXML
    private TableColumn<Object, String> tblClmBaskiSayisi;
    @FXML
    private TableColumn<Object, String> tblClmUyumluModeller;
    @FXML
    private TableColumn<Object, String> tblClmKapasitesi;
    DosyaUrunler dosyaUrunler;

    public KullaniciAdiMedya getKullaniciAdiMedya() {
        return kullaniciAdiMedya;
    }

    public void setKullaniciAdiMedya(KullaniciAdiMedya kullaniciAdiMedya) {
        this.kullaniciAdiMedya = kullaniciAdiMedya;
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void tfAraOnKeyRelese(KeyEvent event) {
    }

    @FXML
    private void btnYenileOnACtion(ActionEvent event) throws Exception {
        tblClmUrunId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblClmUrunIsmi.setCellValueFactory(new PropertyValueFactory<>("urunIsmi"));
        tblClmAlimYapan.setCellValueFactory(new PropertyValueFactory<>("alimYapan"));
        dosyaUrunler=new DosyaUrunler();
        Iterator<Urunler> iter=dosyaUrunler.dosyadanOku().iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        tablo= FXCollections.<Urunler>observableArrayList(dosyaUrunler.dosyadanOku());
        tblSimdikiDepoyuGoster.setItems(tablo);
        tblSimdikiDepoyuGoster.refresh();        
    }


    @FXML
    private void btnYeniUrunOnAction(ActionEvent event) {
        YeniUrunController yuc = new YeniUrunController();
        KullaniciAdiMedya medya=new KullaniciAdiMedya();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/application/depo/YeniUrun.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            YeniUrunController yeniUrunController = fxmlLoader.getController();
            medya=kullaniciAdiMedya;
            yeniUrunController.setKullaniciAdiMedya(medya);
            yeniUrunController.cbAlimYapan.setValue(medya.getIsim()+" "+medya.getSoyisim());
            yeniUrunController.lblUst.setText("YENI URUN");
            yeniUrunController.btnGuncelle.setVisible(false);
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
    private void btnGuncelleOnAction(ActionEvent event) {
        if (!tblSimdikiDepoyuGoster.getSelectionModel().isEmpty()) {
            secileniGoster();
        } else {
            System.out.println("BOS SECIM");
        }
    }
    private void secileniGoster(){
        YeniUrunController yuc=new YeniUrunController();        

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/application/depo/YeniUrun.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            YeniUrunController yeniUrunController=fxmlLoader.getController();

            yeniUrunController.lblUst.setText("Urun Detaylari");
            yeniUrunController.btnGuncelle.setVisible(true);
            yeniUrunController.btnKaydet.setVisible(false);

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
    private void btnSilOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Yonetici");
        alert.setHeaderText("Dogrulayin");
        alert.setContentText("Urunu Silmek Istediginizden Emin misiniz?\nOnaylamak Icin Ok'e Basiniz!!!");
        alert.initStyle(StageStyle.UNDECORATED);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
        }
    }

    @FXML
    private void tblSimdikiDepoyuGosterOnClick(MouseEvent event) {
    }

    @FXML
    private void tblSimdikiDepoyuGosterOnScroll(ScrollEvent event) {
    }

}
