package Dosya;

import Entity.Kasa;
import Entity.Toner;
import Entity.Urunler;
import Entity.Yazici;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author İsmail BOZKURT
 */

public class DosyaUrunler {

    File file;

    public DosyaUrunler() throws Exception {
        file = new File("urunler.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void kasaDosyayaYaz(LinkedList<Kasa> kasaListesi) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter pw = new BufferedWriter(fw);
        for (int i = 0; i < kasaListesi.size(); i++) {
            pw.write("/" + kasaListesi.get(i).getId()
                    + "#" + kasaListesi.get(i).getUrunIsmi()
                    + "$" + kasaListesi.get(i).getAlimYapan()
                    + "&" + kasaListesi.get(i).getAciklama()
                    + "*" + kasaListesi.get(i).getAlimTarihi()
                    + "?" + kasaListesi.get(i).getSatici()
                    + "%" + kasaListesi.get(i).getMarka()
                    + "+" + kasaListesi.get(i).getModel()
                    + "[" + kasaListesi.get(i).getSeriNo()
                    + "{" + kasaListesi.get(i).getIslemciMarkasi()
                    + "}" + kasaListesi.get(i).getRamKapasitesi()
                    + "]");
            pw.newLine();
        }
        pw.close();
    }

    public void yaziciDosyayaYaz(LinkedList<Yazici> yaziciListesi) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter pw = new BufferedWriter(fw);
        for (int i = 0; i < yaziciListesi.size(); i++) {
            pw.write("/" + yaziciListesi.get(i).getId()
                    + "#" + yaziciListesi.get(i).getUrunIsmi()
                    + "$" + yaziciListesi.get(i).getAlimYapan()
                    + "&" + yaziciListesi.get(i).getAciklama()
                    + "*" + yaziciListesi.get(i).getAlimTarihi()
                    + "?" + yaziciListesi.get(i).getSatici()
                    + "%" + yaziciListesi.get(i).getMarka()
                    + "+" + yaziciListesi.get(i).getModel()
                    + "[" + yaziciListesi.get(i).getSeriNo()
                    + "{" + yaziciListesi.get(i).getBaskiSayisi()
                    + "}" + " "
                    + "]");
            pw.newLine();
        }
        pw.close();
    }

    public void tonerDosyayaYaz(LinkedList<Toner> tonerListesi) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter pw = new BufferedWriter(fw);
        for (int i = 0; i < tonerListesi.size(); i++) {
            pw.write("/" + tonerListesi.get(i).getId()
                    + "#" + tonerListesi.get(i).getUrunIsmi()
                    + "$" + tonerListesi.get(i).getAlimYapan()
                    + "&" + tonerListesi.get(i).getAciklama()
                    + "*" + tonerListesi.get(i).getAlimTarihi()
                    + "?" + tonerListesi.get(i).getSatici()
                    + "%" + " "
                    + "+" + " "
                    + "[" + tonerListesi.get(i).getUyumluModeller()
                    + "{" + tonerListesi.get(i).getKapasitesi()
                    + "}" + " "
                    + "]");
            pw.newLine();
        }
        pw.close();
    }

    public LinkedList<Urunler> dosyadanOku() throws NumberFormatException, IOException {
        LinkedList<Urunler> urunlerListesi = new LinkedList<>();

        FileReader fr = new FileReader(file);
        BufferedReader sc = new BufferedReader(fr);
        String s = null;
        while ((s = sc.readLine()) != null) {

            System.out.println("AAAAAAAAAAAAAAAA" + s);
            String id = s.substring(s.indexOf("/") + 1, s.indexOf("#"));
            String urunIsmi = (s.substring(s.indexOf("#") + 1, s.indexOf("$")));
            String alimYapan = (s.substring(s.indexOf("$") + 1, s.indexOf("&")));
            String aciklama = (s.substring(s.indexOf("&") + 1, s.indexOf("*")));
            String tarih = s.substring(s.indexOf("*") + 1, s.indexOf("?"));
            String satici = (s.substring(s.indexOf("?") + 1, s.indexOf("%")));
            Urunler urun = null;
            if (urunIsmi.equals("Bilgisyar")) {
                urun = new Kasa();
                String marka = (s.substring(s.indexOf("%") + 1, s.indexOf("+")));
                String model = (s.substring(s.indexOf("+") + 1, s.indexOf("[")));
                String seriNo = (s.substring(s.indexOf("[") + 1, s.indexOf("{")));
                String islemciMarkasi = (s.substring(s.indexOf("{") + 1, s.indexOf("}")));
                String ramKapasitesi = (s.substring(s.indexOf("}") + 1, s.indexOf("]")));
                
            } else if (urunIsmi.equals("Yazici")) {         
                
                String marka = (s.substring(s.indexOf("%") + 1, s.indexOf("+")));
                String model = (s.substring(s.indexOf("+") + 1, s.indexOf("[")));
                String seriNo = (s.substring(s.indexOf("[") + 1, s.indexOf("{")));
                String baskiSayisi=(s.substring(s.indexOf("{") + 1, s.indexOf("}")));                
               urun = new Yazici();
            }else if(urunIsmi.equals("Toner")){
                String uyumluModeller=(s.substring(s.indexOf("[") + 1, s.indexOf("{")));
                String kapasitesi=(s.substring(s.indexOf("{") + 1, s.indexOf("}")));
                urun=new Toner();
            }
             urunlerListesi.add(urun);
        }
        return urunlerListesi;
    }

    public void depoyaYerlestir(List<Urunler> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int satirSayisi() {
        int sayac = 0;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null) {
                sayac++;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return sayac;
    }

}
