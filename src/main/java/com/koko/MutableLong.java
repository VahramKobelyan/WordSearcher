package com.koko;

public class MutableLong {

    private long number;

    public MutableLong(final long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(final long number) {
        this.number = number;
    }

    public long getAndIncrement() {
        return number++;
    }
}
