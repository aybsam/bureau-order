package com.lismart.smartregie.domain;

import java.io.Serializable;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class Cin implements Serializable {

    private final String value;

    private Cin(String value) {
        this.value = value;
    }

    public static Cin of(String value) {
        checkNotNull(value);
        return new Cin(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cin cin = (Cin) o;
        return Objects.equals(value, cin.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
