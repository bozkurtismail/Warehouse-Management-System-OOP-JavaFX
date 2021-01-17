package Dosya;

import Entity.Satici;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author İsmail BOZKURT
 */
public class DosyaSatici {

    File file;

    public DosyaSatici() throws Exception {
        file = new File("satici.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void dosyayaYaz(LinkedList<Satici> saticiListesi) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter pw = new BufferedWriter(fw);
        for (int i = 0; i < saticiListesi.size(); i++) {
            pw.write("/" + saticiListesi.get(i).getId()
                    + "#" + saticiListesi.get(i).getSaticiIsmi()
                    + "$" + saticiListesi.get(i).getSaticiTelefonu()
                    + "&" + saticiListesi.get(i).getSaticiAdresi()
                    + "*" + saticiListesi.get(i).getOlusturan()
                    + "?" + saticiListesi.get(i).getTarih() + "%");
            pw.newLine();
        }
        pw.close();
    }

    public LinkedList<Satici> dosyadanOku() throws NumberFormatException, IOException {
        LinkedList<Satici> saticiListesi = new LinkedList<>();

        FileReader fr = new FileReader(file);
        BufferedReader sc = new BufferedReader(fr);
        String s = null;
        while ((s = sc.readLine()) != null) {
            Satici satici = new Satici();
            System.out.println("AAAAAAAAAAAAAAAA" + s);
            String id = s.substring(s.indexOf("/") + 1, s.indexOf("#"));
            String saticiIsmi = (s.substring(s.indexOf("#") + 1, s.indexOf("$")));
            String saticiTelefonu = (s.substring(s.indexOf("$") + 1, s.indexOf("&")));
            String saticiAdresi = (s.substring(s.indexOf("&") + 1, s.indexOf("*")));
            String saticiOlusturan = s.substring(s.indexOf("*") + 1, s.indexOf("?"));
            String tarih = (s.substring(s.indexOf("?") + 1, s.indexOf("%")));
            satici.setId(id);
            satici.setSaticiIsmi(saticiIsmi);
            satici.setSaticiTelefonu(saticiTelefonu);
            satici.setSaticiAdresi(saticiAdresi);
            satici.setOlusturan(saticiOlusturan);
            satici.setTarih(tarih);
            saticiListesi.add(satici);
        }
        return saticiListesi;
    }
}
