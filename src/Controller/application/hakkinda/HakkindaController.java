
package Controller.application.hakkinda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author İsmail BOZKURT
 */
public class HakkindaController implements Initializable {

    Image firmaResmi = new Image("/Icon/icon.png");
    @FXML
    private ImageView imgFirmaResim;
    @FXML
    private Label lblFirmaIsmi;
    @FXML
    private Label lblCreatedBy;
    @FXML
    private Label lblUretici;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       imgFirmaResim.setImage(firmaResmi);
       
    }    
    
}
