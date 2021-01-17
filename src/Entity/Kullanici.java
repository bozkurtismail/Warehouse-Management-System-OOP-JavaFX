
package Entity;
/**
 *
 * @author İsmail BOZKURT
 */

import Dosya.DosyaKullanici;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Kullanici extends Personel{

    private String kullaniciAdi, sifre; 
    DosyaKullanici dosyaOkumaYazma;

    public String getKullaniciAdi() {

        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;

    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    /**
     *
     * @param kullaniciListesi
     */
    public void KullaniciEkle(LinkedList<Kullanici> kullaniciListesi){//overloded
        try {
            dosyaOkumaYazma=new DosyaKullanici();
            dosyaOkumaYazma.dosyayaYaz(kullaniciListesi);           
        } catch (Exception ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    public void giris() {

    }

    public void cikis() {

    }   

    /**
     *
     * @param kullaniciAdi     
     */
    public void personelBul(String kullaniciAdi) {//overloaded

    }

    

   
    
    

}
