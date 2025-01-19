package pl.kurs.zadanie02.models;

import java.util.Objects;

public class Kwadrat extends Figura {

    private int a;

    public Kwadrat(int a) {
        super();
        this.a = a;
    }

    @Override
    public double obliczObwod() {
        return 4 * a;
    }

    @Override
    public double obliczPole() {
        return a * a;
    }

    @Override
    public String konwertowanieNaStringa() {
        return getClass().getSimpleName() + "," + super.id + "," + a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kwadrat kwadrat = (Kwadrat) o;
        return a == kwadrat.a;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(a);
    }

    @Override
    public String toString() {
        return "Figura nr " + id +": " + getClass().getSimpleName() + " o boku " + a + ".";
    }
}
