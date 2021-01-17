package Entity;
/**
 *
 * @author İsmail BOZKURT
 */
public class Departman {

    private int bolumID;
    private String bolumAdi;

    public Departman() {
    }

    public Departman(int bolumID, String bolumAdi) {
        super();
        this.bolumID = bolumID;
        this.bolumAdi = bolumAdi;
    }
    

    public void tabloDoldur() {

    }  

    public void ekranTemizle() {

    }
     public void ekle() {

    }

    public void sil() {

    }

    public void guncelle() {

    }

    public void kapat() {

    }

    public int getBolumID() {
        return bolumID;
    }

    public void setBolumID(int bolumID) {
        this.bolumID = bolumID;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

}

