package Entity;
/**
 *
 * @author İsmail BOZKURT
 */

public class Personel {

    protected int personelID;
    protected String ad,soyad,tel,sicilNo;
    protected boolean durum;
    private Gorev gorev;
    private Departman departman;

    public Personel() {
        System.out.println("personel yapilandiricisi");
    }    

    public void personelEkle() {

    }

    public void personelSil() {

    }
    public void KullaniciEkle(){
        
    }
    
    public int getPersonelID() {
        return personelID;
    }

    public void setPersonelID(int personelID) {
        this.personelID = personelID;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }  

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isDurum() {
        return durum;
    }

    public void setDurum(boolean durum) {
        this.durum = durum;
    }

    public Gorev getGorev() {
        return gorev;
    }

    public void setGorev(Gorev gorev) {
        this.gorev = gorev;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }
    
    
}




