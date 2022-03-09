package models;

import java.util.Objects;

public class Tupla<K,V> {
    private K cat;
    private V rest;

    public Tupla(K cat, V rest)
    {
        this.cat=cat;
        this.rest=rest;
    }

    @Override
    public String toString() {
        return  "cat=" + cat + ", rest=" + rest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tupla<?, ?> tupla = (Tupla<?, ?>) o;
        return Objects.equals(cat, tupla.cat) && Objects.equals(rest, tupla.rest);
    }

}
