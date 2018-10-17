package com.gvt.ika.common.domain.entity.converter;

import javax.persistence.AttributeConverter;

public class Boolean2StringConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean bol) {
        if (bol != null) {
            return ((bol) ? "YES" : "NO");
        }
        return "NO";
    }

    @Override
    public Boolean convertToEntityAttribute(String str) {
        if (str == null) {
            return false;
        }
        return ((str.equalsIgnoreCase("YES")) ? true : false);
    }
}
