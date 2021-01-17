package Dosya;

import Entity.Depo;
import Entity.Urunler;
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

public class DosyaDepo {

    File file;
    List<Depo> depoListesi;

    public DosyaDepo() throws Exception {
        file = new File("depoAlan.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public LinkedList<Depo> dosyadanOku() throws NumberFormatException, IOException {
        LinkedList<Depo> alanListesi = new LinkedList<>();

        FileReader fr = new FileReader(file);
        BufferedReader sc = new BufferedReader(fr);
        String s = null;
        while ((s = sc.readLine()) != null) {
            Depo depo = new Depo();
            System.out.println("AAAAAAAAAAAAAAAA" + s);
            String alanIsmi = s.substring(s.indexOf("/") + 1, s.indexOf("#"));
            String aktifMi = (s.substring(s.indexOf("#") + 1, s.indexOf("$")));
            String id = (s.substring(s.indexOf("$") + 1, s.indexOf("&")));

            depo.setButtonIsmi(alanIsmi);
            depo.setAktifMi(aktifMi);
            depo.setId(id);

            alanListesi.add(depo);
        }
        return alanListesi;
    }

    public void kasaAlanaYerlestir(Urunler urun) throws IOException {
        int i=0;
        depoListesi = new LinkedList<>();
        System.out.println("=================");
        System.out.println(kasaAlanVarmi()+" KASA ICIN ALAN VARMI BAKIYORUZ");
        System.out.println("=================");
        if (kasaAlanVarmi() == true) {
            depoListesi = dosyadanOku();
            for (i = 0; i < 10; i++) {
                if (this.depoListesi.get(i).getAktifMi().equals("0")) {
                    break;
                }
            }
            
         depoListesi.get(i).setAktifMi("1");
         depoListesi.get(i).setId(urun.getId());
         dosyayaYaz(depoListesi);
        }
    }

    public boolean kasaAlanVarmi() throws IOException {
        FileReader fr = null;
        boolean alan = false;
        depoListesi = new LinkedList<>();
        try {
            fr = new FileReader(file);
            BufferedReader sc = new BufferedReader(fr);
            String s = null;
            
            while ((s = sc.readLine()) != null) {
                Depo depo = new Depo();
                String alanIsmi = s.substring(s.indexOf("/") + 1, s.indexOf("#"));
                String aktifMi = (s.substring(s.indexOf("#") + 1, s.indexOf("$")));
                String id = (s.substring(s.indexOf("$") + 1, s.indexOf("&")));

                depo.setButtonIsmi(alanIsmi);
                depo.setAktifMi(aktifMi);
                depo.setId(id);

                depoListesi.add(depo);
////////////////////////////////////////////////////////////////////////////                
                for(int i=0;i<depoListesi.size(); i++){
                    System.out.println(depoListesi.get(i).getButtonIsmi());
                }
////////////////////////////////////////////////////////////////////////////
                for (int i = 0; i < 10; i++) {
                    if (depoListesi.get(i).getAktifMi().equals("0")) {
                        alan = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("dosya bulunmadi");
        }
        return alan;
    }
    public void dosyayaYaz(List<Depo> depoListesi) throws IOException{        
        FileWriter fw = new FileWriter(file);
        BufferedWriter pw = new BufferedWriter(fw);
        for (int i = 0; i < depoListesi.size(); i++) {           
            pw.write("/" + depoListesi.get(i).getButtonIsmi()
                    + "#" + depoListesi.get(i).getAktifMi()
                    + "$" + depoListesi.get(i).getId()+ "&");
            pw.newLine();
        }
        pw.close();
    }   
}

