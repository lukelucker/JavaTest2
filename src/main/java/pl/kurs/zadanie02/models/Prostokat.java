package pl.kurs.zadanie02.models;

import java.util.Objects;

public class Prostokat extends Figura {

    private int a;
    private int b;

    public Prostokat(int a, int b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public double obliczObwod() {
        return (2 * a) + (2 * b);
    }

    @Override
    public double obliczPole() {
        return a * b;
    }

    @Override
    public String konwertowanieNaStringa() {
        return getClass().getSimpleName() + "," + super.id + "," + a + "," + b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prostokat prostokat = (Prostokat) o;
        return a == prostokat.a && b == prostokat.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Figura nr " + id +": " + getClass().getSimpleName() + " o bokach " + a + "x" + b + ".";
    }
}
