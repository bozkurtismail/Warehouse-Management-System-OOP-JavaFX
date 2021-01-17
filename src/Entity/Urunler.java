package Entity;

import Dosya.DosyaUrunler;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author İsmail BOZKURT
 */

public abstract class Urunler implements UrunlerInterface {

    protected String id;
    protected String aciklama;
    protected String alimTarihi;
    protected String urunIsmi;
    protected String alimYapan;
    protected String satici;    
    protected Personel personel;

    public Urunler() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getAlimTarihi() {
        return alimTarihi;
    }

    public void setAlimTarihi(String alimTarihi) {
        this.alimTarihi = alimTarihi;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }  

    public String getAlimYapan() {
        return alimYapan;
    }

    public void setAlimYapan(String alimYapan) {
        this.alimYapan = alimYapan;
    }

    public String getSatici() {
        return satici;
    }

    public void setSatici(String satici) {
        this.satici = satici;
    }
    public String urunAdedi() throws Exception{
        DosyaUrunler dosyaUrunler=new DosyaUrunler();
        int urunAdedi=0;
        urunAdedi=dosyaUrunler.satirSayisi();
        return String.valueOf(urunAdedi);          
    }

    /**
     *
     * @param list
     */
    @Override
    public abstract void depoyaYerlestir(Urunler urun);

}
