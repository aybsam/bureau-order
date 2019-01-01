package com.lismart.smartregie.infrastructure.jpa;

import com.lismart.smartregie.domain.Email;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EmailAttributeConverter implements AttributeConverter<Email, String> {

    @Override
    public String convertToDatabaseColumn(Email email) {
        if (email != null) {
            return email.toString();
        }
        return null;
    }

    @Override
    public Email convertToEntityAttribute(String s) {
        if (s != null) {
            return Email.of(s);
        }
        return null;
    }
}
