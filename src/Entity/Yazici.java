package Entity;
/**
 *
 * @author İsmail BOZKURT
 */

import java.util.LinkedList;
import java.util.List;

public class Yazici extends Donanim {

    private String baskiSayisi;

    public String getBaskiSayisi() {
        return baskiSayisi;
    }

    public void setBaskiSayisi(String baskiSayisi) {
        this.baskiSayisi = baskiSayisi;
    }

    @Override
    public void depoyaYerlestir(Urunler urun) {

    }

    @Override
    public void markaDoldurun(String marka) {
        this.setMarka(marka);
    }

    @Override
    public void modelDoldurun(String model) {
        this.setModel(model);
    }

    @Override
    public void seriNoDoldurun(String seriNo) {
        this.setSeriNo(seriNo);
    }

}
