package com.gvt.ika.common.domain.entity.converter;


import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.*;

public class List2StringConverter implements AttributeConverter<Set<String>, String> {

    private static final String SEPARATOR = "|";

    @Override
    public String convertToDatabaseColumn(Set<String> list) {
        if (list != null) {
            StringJoiner stringJoiner = new StringJoiner(SEPARATOR);
            for (String data : list) {

                stringJoiner.add(StringUtils.capitalize(data));
            }
            return stringJoiner.toString();
        }
        return "";
    }

    @Override
    public Set<String> convertToEntityAttribute(String str) {
        if (str != null) {
            Set<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
            set.addAll(Arrays.asList(str.split(SEPARATOR)));
            return set;
        }
        return new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    }
}
