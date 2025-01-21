package pl.kurs.zadanie01.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Osoba {

    private String imie;
    private String nazwisko;
    private String pesel;
    private String miasto;

    public Osoba(String imie, String nazwisko, String pesel, String miasto) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.miasto = miasto;
    }

    public abstract double podajDochody();

    public static Osoba zwrocNajwiekszyDochodWsrodOsob(Osoba[] tablicaOsob) {
        double najwyzszyDochod = 0;
        Osoba osobaPosiadajacaNajwiekszyDochod = null;
        for (int i = 0; i < tablicaOsob.length; i++) {
            if (tablicaOsob[i] != null && tablicaOsob[i].podajDochody() > najwyzszyDochod) {
                najwyzszyDochod = tablicaOsob[i].podajDochody();
                osobaPosiadajacaNajwiekszyDochod = tablicaOsob[i];
            }
        }
        return osobaPosiadajacaNajwiekszyDochod;
    }

    public static String getPlec(Osoba osoba) {
        int szukanaLiczba = Character.getNumericValue(osoba.getPesel().charAt(9));
        if (szukanaLiczba % 2 == 0) {
            return "Kobieta";
        } else {
            return "Mezczyzna";
        }
    }

    public static int iloscKobiet(Osoba[] tablicaOsob) {
        int liczbaKobiet = 0;
        for (int i = 0; i < tablicaOsob.length; i++) {
            if (tablicaOsob[i] != null && "Kobieta".equals(tablicaOsob[i].getPlec(tablicaOsob[i]))) {
                liczbaKobiet++;
            }
        }
        return liczbaKobiet;
    }

    public abstract String konwertowanieNaStringa();

    public static void zapiszOsobyDoPliku(Osoba[] tablicaOsob, String sciezkaPliku) {
        try (FileWriter fw = new FileWriter(sciezkaPliku);
             BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (Osoba osoba : tablicaOsob) {
                if (osoba != null) {
                    bw.write(osoba.konwertowanieNaStringa());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Osoba przeksztalcenieStringaNaObiekt(String linia) {
        String[] split = linia.split(",");
        if (split.length != 7) {
            return null;
        }
        Osoba osoba = null;
        if (split[0].equals("Student")) {
            osoba = new Student(split[1], split[2], split[3], split[4], split[5], Double.parseDouble(split[6]));
        } else if (split[0].equals("Pracownik")) {
            osoba = new Pracownik(split[1], split[2], split[3], split[4], split[5], Double.parseDouble(split[6]));
        }
        return osoba;
    }

    public static List<Osoba> stworzListezOsobwPliku(String sciezkaPliku) {
        List<Osoba> listaOsob = new ArrayList<>();
        try (
                FileReader fr = new FileReader(sciezkaPliku);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String linia = null;
            while ((linia = br.readLine()) != null) {
                if (!linia.trim().isEmpty()) {
                    Osoba osoba = Osoba.przeksztalcenieStringaNaObiekt(linia);
                    if (osoba != null) {
                        listaOsob.add(osoba);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaOsob;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                ", miasto='" + miasto + '\'' +
                '}';
    }
}
