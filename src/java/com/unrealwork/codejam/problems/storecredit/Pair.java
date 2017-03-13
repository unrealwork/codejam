package com.unrealwork.codejam.problems.storecredit;


public class Pair<T extends Comparable> {
    private T key;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair<?> pair = (Pair<?>) o;

        if (getKey() != null ? !getKey().equals(pair.getKey()) : pair.getKey() != null) return false;
        return getValue() != null ? getValue().equals(pair.getValue()) : pair.getValue() == null;

    }

    @Override
    public int hashCode() {
        int result = getKey() != null ? getKey().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    private T value;

    public Pair(T key, T value) {
        this.key = (value.compareTo(key) > 0) ? key : value;
        this.value = (value.compareTo(key) > 0) ? value : key;
    }

    public T getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
}
