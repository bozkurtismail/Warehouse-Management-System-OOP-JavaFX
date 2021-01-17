package Entity;
/**
 *
 * @author İsmail BOZKURT
 */

public abstract class SarfMalzeme extends Urunler {

    private String kullanildigiYer;
    
    public abstract void kullanildigiYeriDoldurun(String kullanildigiYer);
    

    public String getKullanildigiYer() {
        return kullanildigiYer;
    }

    public void setKullanildigiYer(String kullanildigiYer) {
        this.kullanildigiYer = kullanildigiYer;
    }
}
