package Controller;

import Controller.application.ayarlar.AyarlarController;
import Controller.application.depo.StokController;
import Media.KullaniciAdiMedya;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author İsmail BOZKURT
 */
public class ApplicationController implements Initializable {

    @FXML
    private AnchorPane acAna;
    @FXML
    private AnchorPane acPanel;
    @FXML
    private ScrollPane solSideBarScroolPan;
    @FXML
    private Text lblPanel;
    @FXML
    private Button btnAnasayfa;
    @FXML
    private ImageView imgAnasayfaBtn;
    @FXML
    private Button btnDepo;
    @FXML
    private ImageView imgDepoBtn;
    @FXML
    private Button btnPersonel;
    @FXML
    private ImageView imgPersonelBtn;
    @FXML
    private Button btnDemirbas;  
    @FXML
    private Button btnAyarlar;
    @FXML
    private ImageView imgAyarlarBtn;
    @FXML
    private Button btnHakkinda;
    @FXML
    private ImageView imgHakkindaBtn;
    @FXML
    private BorderPane appContent;
    @FXML
    private AnchorPane acHead;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Label lblUsrName;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label lblKullaniciAdiPop;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblRoleAs;
    @FXML
    private Hyperlink hlEditUpdateAccount;
    @FXML
    private Button btnCikis;
    @FXML
    private ToggleButton sideMenuToogleBtn;
    @FXML
    private ImageView imgMenuBtn;
    @FXML
    private Label lblKullaniciID;
    @FXML
    private StackPane acIcerik;
    
    String Id;
    String isim;
    String soyisim;
    String kullaniciAdi;
    String sifre;
    
    private KullaniciAdiMedya kullaniciAdiMedya;
    @FXML
    private ImageView imgDemirbasBtn;

    public KullaniciAdiMedya getKullaniciAdiMedya() {
        return kullaniciAdiMedya;
    }

    public void setKullaniciAdiMedya(KullaniciAdiMedya kullaniciAdiMedya) {
        lblKullaniciID.setText(kullaniciAdiMedya.getId());
        lblUsrName.setText(kullaniciAdiMedya.getKullaniciAdi());
        lblFullName.setText(kullaniciAdiMedya.getIsim()+" "+kullaniciAdiMedya.getSoyisim());
        lblKullaniciAdiPop.setText(kullaniciAdiMedya.getKullaniciAdi());        
        this.kullaniciAdiMedya = kullaniciAdiMedya;
    }

    Image image;
    Image menuImage = new Image("/icon/menu.png");
    Image menuImageRed = new Image("/icon/menuRed.png");

    String defultStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:none";

    String activeStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:#FF4E3C";

    Image anasayfa = new Image("/icon/home.png");
    Image anasayfaSelected = new Image("/icon/homeSelected.png");
    Image stok = new Image("/icon/stock.png");
    Image stokkSelected = new Image("/icon/stockSelected.png");
    Image demirbas = new Image("/icon/demirbas.png");
    Image demirbasSelected = new Image("/icon/demirbasSelected.png");
    Image personel = new Image("/icon/employee.png");
    Image personelSelected = new Image("/icon/employeeSelected.png");
    Image ayarlar = new Image("/icon/settings.png");
    Image ayarlarSelected = new Image("/icon/settingsSelected.png");
    Image hakkinda = new Image("/icon/about.png");
    Image hakkindaSelected = new Image("/icon/aboutSelected.png");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgMenuBtn.setImage(menuImage);
        Image usrImg = new Image("/image/user.png");
        imgUsrTop.setFill(new ImagePattern(usrImg));
        circleImgUsr.setFill(new ImagePattern(usrImg));
    }

    @FXML
    private void sideMenuToogleBtnOnCLick(ActionEvent event) throws IOException {

        if (sideMenuToogleBtn.isSelected()) {
            imgMenuBtn.setImage(menuImageRed);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acPanel);
            sideMenu.setByX(-130);
            sideMenu.play();
            acPanel.getChildren().clear();
        } else {
            imgMenuBtn.setImage(menuImage);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acPanel);
            sideMenu.setByX(130);
            sideMenu.play();
            acPanel.getChildren().add(solSideBarScroolPan);
        }
    }

    @FXML
    private void btnCikis(ActionEvent event) throws IOException {
        acIcerik.getChildren().clear();
        acIcerik.getChildren().add(FXMLLoader.load(getClass().getResource("/View/giris.fxml")));
        acPanel.getChildren().clear();
        acHead.getChildren().clear();
        acHead.setMaxHeight(0.0);
    }

    @FXML
    private void acAna(KeyEvent event) {
        if (event.getCode() == KeyCode.F11) {
            Stage stage = (Stage) acAna.getScene().getWindow();
            stage.setFullScreen(true);
        }
    }


    @FXML
    public void btnAnasayfaOnClick(ActionEvent event) {

        anaSayfaAktif();
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/View/application/anasayfa/Anasayfa.fxml").openStream());
        } catch (IOException e) {

        }
        AnchorPane root = fxmlLoader.getRoot();
        acIcerik.getChildren().clear();
        acIcerik.getChildren().add(root);
    }

    @FXML
    private void btnDepoOnClick(ActionEvent event) throws IOException {

        depoAktif();
        KullaniciAdiMedya medya=new KullaniciAdiMedya();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/depo/Stok.fxml").openStream());
        medya=kullaniciAdiMedya;        
        StokController stokController = fXMLLoader.getController();        
        stokController.bpDepo.getStylesheets().add("/Style/MainStyle.css");
        stokController.btnStokOnAction(event);
        stokController.setKullaniciAdiMedya(medya);
        stokController.btnStokOnAction(event);
        AnchorPane acPane = fXMLLoader.getRoot();
        acIcerik.getChildren().clear();
        acIcerik.getChildren().add(acPane);
    }
    @FXML
    private void btnDemirbasOnClick(ActionEvent event) {
        try {
            demirbasAktif();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/View/application/demirbas/Demirbas.fxml").openStream());
            AnchorPane anchorPane = fXMLLoader.getRoot();
            acIcerik.getChildren().clear();
            acIcerik.getChildren().add(anchorPane);
        } catch (Exception e) {
            System.out.println("error");
        }       
    }

   
    //    @FXML
//    private void btnPersonelOnClick(ActionEvent event) throws IOException {
//
//        personelAktif()
//        PersonelController personelCont = new PersonelController();
//        userNameMedia nm = new userNameMedia();
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/View/application/Personel.fxml").openStream());
//        nm.setId(id);
//        PersonelController personelController = fXMLLoader.getController();
//        personelController.bpContent.getStylesheets().add("/style/MainStyle.css");
//        personelController.setNameMedia(usrNameMedia);
//        personelController.btnViewPersonelOnAction(event);
//        AnchorPane acPane = fXMLLoader.getRoot();
//        acIcerik.getChildren().clear();
//        acIcerik.getChildren().add(acPane);
//    }

    @FXML
    private void btnAyarlarOnClick(ActionEvent event) throws IOException {
        try {
            ayarlarAktif();
            AyarlarController ac=new AyarlarController();
            FXMLLoader settingLoader = new FXMLLoader();
            settingLoader.load(getClass().getResource("/View/application/ayarlar/Ayarlar.fxml").openStream());
            System.out.println("1234567890");            
            AyarlarController ayarlarControl = settingLoader.getController();                    
            ayarlarControl.bpAyarlar.getStylesheets().add("/Style/MainStyle.css");            
            ayarlarControl.hesabimOnClick(event);            
            AnchorPane acPane = settingLoader.getRoot();
            acIcerik.getChildren().clear();
            acIcerik.getChildren().add(acPane);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @FXML
    private void btnHakkindaOnClick(ActionEvent event) {

        try {
            hakkindaAktif();           
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/View/application/hakkinda/Hakkinda.fxml").openStream());
            AnchorPane anchorPane = fXMLLoader.getRoot();
            acIcerik.getChildren().clear();
            acIcerik.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void anaSayfaAktif() {
        imgAnasayfaBtn.setImage(anasayfaSelected);
        imgDepoBtn.setImage(stok);
        imgDemirbasBtn.setImage(demirbas);
        imgPersonelBtn.setImage(personel);
        imgAyarlarBtn.setImage(ayarlar);
        imgHakkindaBtn.setImage(hakkinda);
        btnAnasayfa.setStyle(activeStyle);
        btnDepo.setStyle(defultStyle);
        btnDemirbas.setStyle(defultStyle);
        btnPersonel.setStyle(defultStyle);
        btnAyarlar.setStyle(defultStyle);
        btnHakkinda.setStyle(defultStyle);
    }

    private void depoAktif() {
        imgAnasayfaBtn.setImage(anasayfa);
        imgDepoBtn.setImage(stokkSelected);
        imgDemirbasBtn.setImage(demirbas);
        imgPersonelBtn.setImage(personel);
        imgAyarlarBtn.setImage(ayarlar);
        imgHakkindaBtn.setImage(hakkinda);
        btnAnasayfa.setStyle(defultStyle);
        btnDepo.setStyle(activeStyle);
        btnDemirbas.setStyle(defultStyle);
        btnPersonel.setStyle(defultStyle);
        btnAyarlar.setStyle(defultStyle);
        btnHakkinda.setStyle(defultStyle);
    }
    private void demirbasAktif() {
        imgAnasayfaBtn.setImage(anasayfa);
        imgDepoBtn.setImage(stok);
        imgDemirbasBtn.setImage(demirbasSelected);
        imgPersonelBtn.setImage(personel);
        imgAyarlarBtn.setImage(ayarlar);
        imgHakkindaBtn.setImage(hakkinda);
        btnAnasayfa.setStyle(defultStyle);
        btnDepo.setStyle(defultStyle);
        btnDemirbas.setStyle(activeStyle);
        btnPersonel.setStyle(defultStyle);
        btnAyarlar.setStyle(defultStyle);
        btnHakkinda.setStyle(defultStyle);
    }

    private void ayarlarAktif() {
        imgAnasayfaBtn.setImage(anasayfa);
        imgDepoBtn.setImage(stok);
        imgDemirbasBtn.setImage(demirbas);
        imgPersonelBtn.setImage(personel);
        imgAyarlarBtn.setImage(ayarlarSelected);
        imgHakkindaBtn.setImage(hakkinda);
        btnAnasayfa.setStyle(defultStyle);
        btnDepo.setStyle(defultStyle);
        btnDemirbas.setStyle(defultStyle);
        btnPersonel.setStyle(defultStyle);
        btnAyarlar.setStyle(activeStyle);
        btnHakkinda.setStyle(defultStyle);
    }

    private void hakkindaAktif() {
        imgAnasayfaBtn.setImage(anasayfa);
        imgDepoBtn.setImage(stok);
        imgDemirbasBtn.setImage(demirbas);
        imgPersonelBtn.setImage(personel);
        imgAyarlarBtn.setImage(ayarlar);
        imgHakkindaBtn.setImage(hakkindaSelected);
        btnAnasayfa.setStyle(defultStyle);
        btnDepo.setStyle(defultStyle);
        btnDemirbas.setStyle(defultStyle);
        btnPersonel.setStyle(defultStyle);
        btnAyarlar.setStyle(defultStyle);
        btnHakkinda.setStyle(activeStyle);
    }   
}
