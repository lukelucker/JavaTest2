package pl.kurs.zadanie01.app;

import pl.kurs.zadanie01.models.Osoba;
import pl.kurs.zadanie01.models.Pracownik;
import pl.kurs.zadanie01.models.Student;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Student student1 = new Student("Jacek", "Domański", "02251184238", "Kraków", "Automatyka", 1050);
        Student student2 = new Student("Monika", "Misztal", "05281834268", "Warszawa", "Filologia", 1200);
        Student student3 = new Student("Radosław", "Kornafel", "05291287552", "Szczecin", "Prawo", 980);
        Student student4 = new Student("Anna", "Solosz", "04232574687", "Poznań", "Zarządzanie", 750);
        Student student5 = new Student("Artur", "Kuryj", "03300648232", "Dęblin", "Lotnictwo", 1560);
        Pracownik pracownik1 = new Pracownik("Robert", "Giernal", "86020454370", "Rzeszów", "Operator CNC", 4624);
        Pracownik pracownik2 = new Pracownik("Marcin", "Robczyk", "90050874315", "Wrocław", "Kurier", 5230);
        Pracownik pracownik3 = new Pracownik("Katarzyna", "Lis", "76110195725", "Kielce", "Księgowa", 7200);
        Pracownik pracownik4 = new Pracownik("Magda", "Dragan", "81090338543", "Elbląg", "Kasjerka", 3800);
        Pracownik pracownik5 = new Pracownik("Paulina", "Kowal", "88123086961", "Gdańsk", "Pedagog", 4900);

        Osoba[] tablicaOsob = {student1, student2, student3, student4, student5, pracownik1, pracownik2, pracownik3, pracownik4, pracownik5};

        System.out.println(Osoba.iloscKobiet(tablicaOsob));

        System.out.println(Osoba.zwrocNajwiekszyDochodWsrodOsob(tablicaOsob));

        String sciezkaPliku = "Lista_Osób.txt";

        Osoba.zapiszOsobyDoPliku(tablicaOsob, sciezkaPliku);

        System.out.println(Osoba.stworzListezOsobwPliku(sciezkaPliku));
        List<Osoba> listaOsob = Osoba.stworzListezOsobwPliku(sciezkaPliku);

    }
}
