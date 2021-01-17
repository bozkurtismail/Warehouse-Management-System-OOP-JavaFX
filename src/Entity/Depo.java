
package Entity;
/**
 *
 * @author İsmail BOZKURT
 */

public class Depo {    
    protected String id;
    protected String aktifMi;
    protected String buttonIsmi;

    public Depo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(String aktifMi) {
        this.aktifMi = aktifMi;
    }

    public String getButtonIsmi() {
        return buttonIsmi;
    }

    public void setButtonIsmi(String buttonIsmi) {
        this.buttonIsmi = buttonIsmi;
    }
    
}
