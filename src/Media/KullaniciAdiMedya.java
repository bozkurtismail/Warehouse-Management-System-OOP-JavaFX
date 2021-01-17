package Media;

/**
 *
 * @author İsmail BOZKURT
 */
public class KullaniciAdiMedya {
    String Id;
    String isim;
    String soyisim;
    String kullaniciAdi;
    String sifre;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
    

    public KullaniciAdiMedya() {
    }

    public KullaniciAdiMedya(String kullaniciAdi, String sifre,String id,String isim,String soyisim) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.Id=id;
        this.isim=isim;
        this.soyisim=soyisim;
    }

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
    
}
