package Entity;
/**
 *
 * @author İsmail BOZKURT
 */

public abstract class Donanim extends Urunler{
    protected String marka,model,seriNo;        
    
    public abstract void markaDoldurun(String marka);
    public abstract void modelDoldurun(String model);
    public abstract void seriNoDoldurun(String seriNo);

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }
}
