package pl.kurs.zadanie02.app;

import pl.kurs.zadanie02.models.Figura;
import pl.kurs.zadanie02.models.Kolo;
import pl.kurs.zadanie02.models.Kwadrat;

import java.util.Arrays;
import java.util.List;

public class FiguryRunner {
    public static void main(String[] args) {

        List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10,20));
        for(Figura f : figury) {
            System.out.println(f);
        }

        Kwadrat kwadrat = new Kwadrat(5);

        System.out.println(Figura.podajFigureZNajwiekszymObwodem(figury));
        System.out.println(Figura.podajFigureZNajwiekszymPolem(figury));

        System.out.println(figury.contains(new Kwadrat(10)));

        String sciezkaPliku = "Lista_Figur.txt";

        Figura.zapiszFiguryDoPliku(figury, sciezkaPliku);

        List<Figura> listaFigur = Figura.stworzListeFigurzPliku(sciezkaPliku);
    }
}
