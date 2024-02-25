package Hastane_projesi;

import java.util.ArrayList;
import java.util.Scanner;

public class StaticMethods {

    public static String hastayaDurumunuSor(Scanner scan){
        System.out.println("Lutfen hangi doktordan randevu almaniz gerektigini ogrenmek icin" +
                " sikayetinizi giriniz: Allerji, Bas agrisi, Diabet, Soguk Alginligi, Migren, Kalp hastaliklari");

       String durum = scan.nextLine().trim().toLowerCase();

        while (!isValid(durum)) {
            System.out.println("Geçersiz giriş. Lütfen tekrar deneyiniz.");
            durum = scan.nextLine().trim().toLowerCase();
        }

       return durum;
    }
    private static boolean isValid(String durum) {
        switch (durum){
            case "allerji":
            case "baş ağrısı":
            case "diabet":
            case "soğuk algınlığı":
            case "migren":
            case "kalp hastalıkları":
                return true;
            default:
                return false;
        }
    }

    public static String doktorUnvan(String durum) {
    String unvan = "gecersiz unvan";

        for (int i = 0; i < VeriBankasi.durumlar.size(); i++) {
            if (durum.equalsIgnoreCase(VeriBankasi.durumlar.get(i))) {
                unvan = VeriBankasi.unvanlar.get(i);
                break;
            }
        }

        return unvan;
    }

    public static Doktor doktorBul(String unvan) {
        Doktor doktor = new Doktor();
        for (int i = 0; i < VeriBankasi.unvanlar.size(); i++) {
            if (VeriBankasi.unvanlar.get(i).equals(unvan)) {
                doktor.setIsim(VeriBankasi.doctorIsimleri.get(i));
                doktor.setSoyIsim(VeriBankasi.doctorSoyIsimleri.get(i));
                doktor.setUnvan(VeriBankasi.unvanlar.get(i));
                break;
            }
        }
        return doktor;
    }
    
    public static ArrayList<Doktor> doktorlariBul(String unvan){
        ArrayList<Doktor> doktorlar = new ArrayList<>();
        for (int i = 0; i < VeriBankasi.unvanlar.size(); i++) {

            if (VeriBankasi.unvanlar.get(i).equalsIgnoreCase(unvan)){
                Doktor doktor = new Doktor();
                doktor.setIsim(VeriBankasi.doctorIsimleri.get(i));
                doktor.setSoyIsim(VeriBankasi.doctorSoyIsimleri.get(i));
                doktor.setUnvan(VeriBankasi.unvanlar.get(i));
                doktorlar.add(doktor);
            }
        }
        return doktorlar;
    }
    public static Durum hastaDurumuBul(String durum) {
        Durum hastaAciliyetDurumu = new Durum();
        switch (durum) {
            case "allerji":
            case "bas agrisi":
            case "diabet":
            case "soguk alginligi":
                hastaAciliyetDurumu.setAciliyet(false);
                break;
            case "migren":
            case "kalp hastaliklari":
                hastaAciliyetDurumu.setAciliyet(true);
                break;
            default:
                System.out.println("Gecerli bir durum degil");
                hastaAciliyetDurumu.setAktuelDurum("Gecerli bir durum degil");

        }
        return hastaAciliyetDurumu;

    }

    public static Hasta hastaBul(String durum) {
        Hasta hasta = new Hasta();
        for (int i = 0; i < VeriBankasi.durumlar.size(); i++) {
            if (VeriBankasi.durumlar.get(i).equalsIgnoreCase(durum)) {
                hasta.setIsim(VeriBankasi.hastaIsimleri.get(i));
                hasta.setSoyIsim(VeriBankasi.hastaIsimleri.get(i));
                hasta.setHastaID(VeriBankasi.hastaIDleri.get(i));
                hasta.setHastaDurumu((hastaDurumuBul(durum)));
                break;
            }

        }
        return hasta;
    }


}

