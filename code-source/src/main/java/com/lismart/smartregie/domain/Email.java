package com.lismart.smartregie.domain;

import java.io.Serializable;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Email implements Serializable {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-+](.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]" +
            "+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    private final String value;

    private Email(String value) {
        this.value = value;
    }

    public static Email of(String value) {
        checkNotNull(value);
        checkArgument(value.matches(EMAIL_REGEX));
        return new Email(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
