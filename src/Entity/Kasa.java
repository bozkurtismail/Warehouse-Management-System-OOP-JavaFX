package Entity;
/**
 *
 * @author İsmail BOZKURT
 */

import Dosya.DosyaDepo;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kasa extends Donanim {

    protected String islemciMarkasi;
    protected String ramKapasitesi;
    

    public String getIslemciMarkasi() {
        return islemciMarkasi;
    }

    public void setIslemciMarkasi(String islemciMarkasi) {
        this.islemciMarkasi = islemciMarkasi;
    }

    public String getRamKapasitesi() {
        return ramKapasitesi;
    }

    public void setRamKapasitesi(String ramKapasitesi) {
        this.ramKapasitesi = ramKapasitesi;
    }
    

    @Override
   public void depoyaYerlestir(Urunler urun){
        try {
//            System.out.println("========================================");
//            System.out.println("KASA ENTITY"+urun.getId()+" "+urun.getUrunIsmi()+" "+urun.getAlimYapan());
//            System.out.println("========================================");
            List<Kasa> kasaListesi=new LinkedList<>();
            DosyaDepo dosyaDepo=new DosyaDepo();
//            kasaListesi.add((Kasa) urun);
            dosyaDepo.kasaAlanaYerlestir(urun);
        } catch (Exception ex) {
            Logger.getLogger(Kasa.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
   }  

    @Override
    public void modelDoldurun(String model) {
        this.setModel(model);
    }

    @Override
    public void seriNoDoldurun(String seriNo) {
        this.setSeriNo(seriNo);
    }

    @Override
    public void markaDoldurun(String marka) {
        this.setMarka(marka);
    }

   
}
