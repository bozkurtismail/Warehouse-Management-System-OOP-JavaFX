package Entity;

import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author İsmail BOZKURT
 */

public class Toner extends SarfMalzeme{
    private String uyumluModeller;
    private String kapasitesi;

    public String getUyumluModeller() {
        return uyumluModeller;
    }

    public void setUyumluModeller(String uyumluModeller) {
        this.uyumluModeller = uyumluModeller;
    }

    public String getKapasitesi() {
        return kapasitesi;
    }

    public void setKapasitesi(String kapasitesi) {
        this.kapasitesi = kapasitesi;
    }   
    
    @Override
    public void kullanildigiYeriDoldurun(String kullanildigiYer) {
        this.setKullanildigiYer(kullanildigiYer);
    }   

    @Override
    public void depoyaYerlestir(Urunler urun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    

}
