package Controller.application.demirbas;

import Dosya.DosyaDepo;
import Entity.Depo;
import Entity.Urunler;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

/**
 *
 * @author İsmail BOZKURT
 */

public class DemirbasController implements Initializable {

    @FXML
    private Label lblDepoIsmi;
    @FXML
    private Button K2;
    @FXML
    private Button K1;
    @FXML
    private Button K3;
    @FXML
    private Button K4;
    @FXML
    private Button K5;
    @FXML
    private Button K6;
    @FXML
    private Button K7;
    @FXML
    private Button K8;
    @FXML
    private Button K9;
    @FXML
    private Button K10;
    @FXML
    private Button Y21;
    @FXML
    private Button Y22;
    @FXML
    private Button Y23;
    @FXML
    private Button Y24;
    @FXML
    private Button Y25;
    @FXML
    private Button Y26;
    @FXML
    private Button Y27;
    @FXML
    private Button Y28;
    @FXML
    private Button Y30;
    @FXML
    private Button Y29;
    @FXML
    private Button T41;
    @FXML
    private Button T42;
    @FXML
    private Button T43;
    @FXML
    private Button T44;
    @FXML
    private Button T45;
    @FXML
    private Button T46;
    @FXML
    private Button T47;
    @FXML
    private Button T48;
    @FXML
    private Button T49;
    @FXML
    private Button T50;

    public DosyaDepo depo;
    public List<Depo> depoListesi;

    String pasif = "-fx-background-color:red;"
            + "-fx-background-radius: 10";
    String aktif = "-fx-background-color:green;"
            + "-fx-background-radius: 10";
    List<Button> butonListesi = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            depo = new DosyaDepo();
            depoListesi = new LinkedList<>();

            depoListesi = depo.dosyadanOku();

            for (int i = 0; i < 10; i++) {
                if (this.depoListesi.get(i).getAktifMi().equals("1")) {
                    String button = depoListesi.get(i).getButtonIsmi();
                    if (K1.getId().equals(button)) {
                        K1.setStyle(aktif);
                    } else if (K2.getId().equals(button)) {
                        K2.setStyle(aktif);
                    } else if (K3.getId().equals(button)) {
                        K3.setStyle(aktif);
                    } else if (K4.getId().equals(button)) {
                        K4.setStyle(aktif);
                    } else if (K5.getId().equals(button)) {
                        K5.setStyle(aktif);
                    } else if (K6.getId().equals(button)) {
                        K6.setStyle(aktif);
                    } else if (K7.getId().equals(button)) {
                        K7.setStyle(aktif);
                    } else if (K8.getId().equals(button)) {
                        K8.setStyle(aktif);
                    } else if (K9.getId().equals(button)) {
                        K9.setStyle(aktif);
                    } else if (K10.getId().equals(button)) {
                        K10.setStyle(aktif);
                    }
                }
            }

            for (int i = 10; i < 20; i++) {
                if (this.depoListesi.get(i).getAktifMi().equals("1")) {
                    String button = depoListesi.get(i).getButtonIsmi();
                    if (Y21.getId().equals(button)) {
                        Y21.setStyle(aktif);
                    } else if (Y22.getId().equals(button)) {
                        Y22.setStyle(aktif);
                    } else if (Y23.getId().equals(button)) {
                        Y23.setStyle(aktif);
                    } else if (Y24.getId().equals(button)) {
                        Y24.setStyle(aktif);
                    } else if (Y25.getId().equals(button)) {
                        Y25.setStyle(aktif);
                    } else if (Y26.getId().equals(button)) {
                        Y26.setStyle(aktif);
                    } else if (Y27.getId().equals(button)) {
                        Y27.setStyle(aktif);
                    } else if (Y28.getId().equals(button)) {
                        Y28.setStyle(aktif);
                    } else if (Y29.getId().equals(button)) {
                        Y29.setStyle(aktif);
                    } else if (Y30.getId().equals(button)) {
                        Y30.setStyle(aktif);
                    }
                }
            }

            for (int i = 20; i < 30; i++) {
                if (this.depoListesi.get(i).getAktifMi().equals("1")) {
                    String button = depoListesi.get(i).getButtonIsmi();
                    if (T41.getId().equals(button)) {
                        T41.setStyle(aktif);
                    } else if (T42.getId().equals(button)) {
                        T42.setStyle(aktif);
                    } else if (T43.getId().equals(button)) {
                        T43.setStyle(aktif);
                    } else if (T44.getId().equals(button)) {
                        T44.setStyle(aktif);
                    } else if (T45.getId().equals(button)) {
                        T45.setStyle(aktif);
                    } else if (T46.getId().equals(button)) {
                        T46.setStyle(aktif);
                    } else if (T47.getId().equals(button)) {
                        T47.setStyle(aktif);
                    } else if (T48.getId().equals(button)) {
                        T48.setStyle(aktif);
                    } else if (T49.getId().equals(button)) {
                        T49.setStyle(aktif);
                    } else if (T50.getId().equals(button)) {
                        T50.setStyle(aktif);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("error botn");
        }
    }

    public void kasaYaziciAlanina(Urunler urun) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Basarili");
        alert.setHeaderText("Kaydedildi");
        alert.setContentText("Urun" + "  '" + urun.getUrunIsmi() + "' " + "Yazici Alanina Basariyla Eklendi");
        alert.initStyle(StageStyle.UNDECORATED);
        alert.showAndWait();
    }
   
}
