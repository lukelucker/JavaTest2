package pl.kurs.zadanie02.models;

import java.util.Objects;

public class Kolo extends Figura {

    private int r;

    public Kolo(int r) {
        super();
        this.r = r;
    }

    @Override
    public double obliczObwod() {
        return 2 * Math.PI * r;
    }

    @Override
    public double obliczPole() {
        return Math.PI * r * r;
    }

    @Override
    public String konwertowanieNaStringa() {
        return getClass().getSimpleName() + "," + super.id + "," + r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kolo kolo = (Kolo) o;
        return r == kolo.r;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(r);
    }

    @Override
    public String toString() {
        return "Figura nr " + id +": " + getClass().getSimpleName() + " o promieniu " + r + ".";
    }
}
