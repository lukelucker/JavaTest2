package pl.kurs.zadanie02.models;

import pl.kurs.zadanie01.models.Osoba;
import pl.kurs.zadanie01.models.Pracownik;
import pl.kurs.zadanie01.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Figura {

    private static int numerFigury = 0;
    protected int id;

    public Figura() {
        this.id = 0;
    }

    public static Figura stworzKwadrat(int a) {
        Kwadrat kwadrat = new Kwadrat(a);
        kwadrat.id = ++numerFigury;
        return kwadrat;
    }

    public static Figura stworzKolo(int d) {
        Kolo kolo = new Kolo(d);
        kolo.id = ++numerFigury;
        kolo.setR(d / 2);
        return kolo;
    }

    public static Figura stworzProstokat(int a, int b) {
        Prostokat prostokat = new Prostokat(a, b);
        prostokat.id = ++numerFigury;
        return prostokat;
    }

    public abstract double obliczObwod();

    public abstract double obliczPole();

    public static Figura podajFigureZNajwiekszymObwodem(List<Figura> figury) {
        Figura figuraONajwiekszymObwodzie = null;
        double najwiekszyObwod = 0;
        for (Figura figura : figury) {
            double obwod = figura.obliczObwod();
            if (obwod > najwiekszyObwod) {
                najwiekszyObwod = obwod;
                figuraONajwiekszymObwodzie = figura;
            }
        }
        return figuraONajwiekszymObwodzie;
    }

    public static Figura podajFigureZNajwiekszymPolem(List<Figura> figury) {
        Figura figuraZNajwiekszymPolem = null;
        double najwiekszePole = 0;
        for (Figura figura : figury) {
            double pole = figura.obliczPole();
            if (pole > najwiekszePole) {
                najwiekszePole = pole;
                figuraZNajwiekszymPolem = figura;
            }
        }
        return figuraZNajwiekszymPolem;
    }

    public abstract String konwertowanieNaStringa();

    public static void zapiszFiguryDoPliku(List<Figura> figury, String sciezkaPliku) {
        try (FileWriter fw = new FileWriter(sciezkaPliku);
             BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (Figura figura : figury) {
                if (figura != null) {
                    bw.write(figura.konwertowanieNaStringa());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Figura przeksztalcenieStringaNaObiekt(String linia) {
        String[] split = linia.split(",");
        Figura figura = null;
        int id = Integer.parseInt(split[1]);
        if (split[0].equals("Kwadrat")) {
            figura = new Kwadrat(Integer.parseInt(split[2]));
        } else if (split[0].equals("Kolo")) {
            figura = new Kolo(Integer.parseInt(split[2]));
        } else if (split[0].equals("Prostokat")) {
            figura = new Prostokat(Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        }
        if (figura != null) {
            figura.setId(id);
        }
        return figura;
    }

    public static List<Figura> stworzListeFigurzPliku(String sciezkaPliku) {
        List<Figura> listaFigur = new ArrayList<>();
        try (
                FileReader fr = new FileReader(sciezkaPliku);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String linia = null;
            while ((linia = br.readLine()) != null) {
                if (!linia.trim().isEmpty()) {
                    Figura figura = Figura.przeksztalcenieStringaNaObiekt(linia);
                    if (figura != null) {
                        listaFigur.add(figura);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaFigur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public abstract String toString();
}
