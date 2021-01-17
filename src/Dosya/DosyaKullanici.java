package Dosya;

import Entity.Kullanici;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author İsmail BOZKURT
 */

public class DosyaKullanici {

    File file;

    public DosyaKullanici() throws Exception {
        file = new File("kullanici.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void dosyayaYaz(LinkedList<Kullanici> kullaniciListesi) throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter pw = new BufferedWriter(fw);
        java.util.Iterator<Kullanici> ite = kullaniciListesi.iterator();
        while (ite.hasNext()) {
            Kullanici kullanici = ite.next();
            pw.write("/" + kullanici.getPersonelID() + "#" + kullanici.getSicilNo() + "$" + kullanici.getAd() + "&" + kullanici.getSoyad()
                    + "*" + kullanici.getKullaniciAdi() + "?" + kullanici.getSifre() + "%");
            pw.newLine();
        }
        pw.close();
    }
    public String[] idSiOkuma() throws IOException {
        String satir = "";
        int satirSayisi = satirSayisi();
        System.out.println(satirSayisi);
        String[] id;
        id = new String[satirSayisi];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            while ((satir = br.readLine()) != null) {
                id[i] = satir.substring(satir.indexOf("/") + 1, satir.indexOf("#"));
                i++;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        return id;
    }
    
    public String[] adOkuma() throws IOException {
        String satir = "";
        int satirSayisi = satirSayisi();
        System.out.println(satirSayisi);
        String[] ad;
        ad = new String[satirSayisi];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            while ((satir = br.readLine()) != null) {
                ad[i] = satir.substring(satir.indexOf("$") + 1, satir.indexOf("&"));
                i++;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        return ad;
    }
    
    public String[] soyadOkuma() throws IOException {
        String satir = "";
        int satirSayisi = satirSayisi();
        System.out.println(satirSayisi);
        String[] soyad;
        soyad = new String[satirSayisi];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            while ((satir = br.readLine()) != null) {
                soyad[i] = satir.substring(satir.indexOf("&") + 1, satir.indexOf("*"));
                i++;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        return soyad;
    }

    public String[] kullaniciAdiOku() throws IOException {
        String satir = "";
        int satirSayisi = satirSayisi();
        System.out.println(satirSayisi);
        String[] kullaniciAdi;
        kullaniciAdi = new String[satirSayisi];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            while ((satir = br.readLine()) != null) {
                kullaniciAdi[i] = satir.substring(satir.indexOf("*") + 1, satir.indexOf("?"));
                i++;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        return kullaniciAdi;
    }

    public String[] sifreOku() throws IOException {
        String satir = "";
        int satirSayisi = satirSayisi();
        System.out.println(satirSayisi);
        String[] sifre;
        sifre = new String[satirSayisi];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            while ((satir = br.readLine()) != null) {
                sifre[i] = satir.substring(satir.indexOf("?") + 1, satir.indexOf("%"));
                i++;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return sifre;
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

    public String DosyaIdOku() {
        String Id = null;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String satir = null;

            satir = br.readLine();           
            if (satir == null || satir.equals(" ")) {
                fr.close();
                br.close();
                return Id;
            } else {
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA" + satir);
                Id = satir.substring(satir.indexOf("/") + 1, satir.indexOf("#"));
                System.out.println(Id);

                fr.close();
                br.close();
            }
        } catch (IOException e) {
            System.out.println("Hata");
        }
        return Id;
    }
}
