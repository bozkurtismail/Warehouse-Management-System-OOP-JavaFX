
package Controller.application.anasayfa;

import Entity.Urunler;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author İsmail BOZKURT
 */
public class AnasayfaController implements Initializable {

    Urunler urunler = new Urunler() {
        @Override
        public void depoyaYerlestir(Urunler urun) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    @FXML
    private Label lblFirmaIsmi;
    @FXML
    private Text txtFirmaTelefonu;
    @FXML
    private Label lblToplamUrun;
    @FXML
    private Label lblToplamPersonel;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            urunleriSay();
        } catch (Exception ex) {
            System.out.println("error");
        }
    }

    public void urunleriSay() throws Exception {
        String mevcudu = "0";
        if (urunler.urunAdedi().equals("0")) {
            lblToplamUrun.setText(mevcudu);
        } else {
            mevcudu = urunler.urunAdedi();
            lblToplamUrun.setText(mevcudu);
        }
    }

}
