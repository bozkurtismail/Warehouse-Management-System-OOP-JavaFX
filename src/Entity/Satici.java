
package Entity;
/**
 *
 * @author İsmail BOZKURT
 */

public class Satici {
    String id;
    private String saticiIsmi;
    private String saticiTelefonu;
    private String SaticiAdresi;
    private String olusturan;
    private String tarih;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSaticiIsmi() {
        return saticiIsmi;
    }

    public void setSaticiIsmi(String saticiIsmi) {
        this.saticiIsmi = saticiIsmi;
    }

    public String getSaticiTelefonu() {
        return saticiTelefonu;
    }

    public void setSaticiTelefonu(String saticiTelefonu) {
        this.saticiTelefonu = saticiTelefonu;
    }

    public String getSaticiAdresi() {
        return SaticiAdresi;
    }

    public void setSaticiAdresi(String SaticiAdresi) {
        this.SaticiAdresi = SaticiAdresi;
    }

    public String getOlusturan() {
        return olusturan;
    }

    public void setOlusturan(String olusturan) {
        this.olusturan = olusturan;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

   
}
