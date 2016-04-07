package com.twu.biblioteca.anotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidationChecker {

    public List<String> validateSize(Object obj) throws IllegalAccessException {
        List<String> errors = new ArrayList<String>();
        Field[] fields = obj.getClass().getFields();
            for (int i = 0; i < fields.length; i++) {
                Size annotations = fields[i].getAnnotation(Size.class);
                if (annotations != null) {
                        try {
                            if (fields[i].get(obj).toString().length() < 3) {
                                errors.add((annotations).message());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
        }
        return errors;
    }

    public List<String> validateNotNull(Object obj) throws IllegalAccessException {
        List<String> errors = new ArrayList<String>();
        Field[] fields = obj.getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            NotNull annotations = fields[i].getAnnotation(NotNull.class);
            if (annotations != null) {
                    try {
                        if (fields[i].get(obj) == null) {
                            errors.add((annotations).message());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
        return errors;
    }

    public List<String> validateFormat(Object obj) throws IllegalAccessException {
        List<String> errors = new ArrayList<String>();
        Field[] fields = obj.getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            Format annotations = fields[i].getAnnotation(Format.class);
            if (annotations != null) {
                try {
                    if (!(fields[i].get(obj).toString().matches("/d{3}-d{5}/"))) {
                        errors.add((annotations).message());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return errors;
    }
}
