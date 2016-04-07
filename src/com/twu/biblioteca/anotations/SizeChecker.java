package com.twu.biblioteca.anotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SizeChecker {

    public List<String> validateSize(Object obj) throws IllegalAccessException {
        List<String> errors = new ArrayList<String>();
        Field[] fields = obj.getClass().getFields();
            for (int i = 0; i < fields.length; i++) {
                Size annotations = fields[i].getAnnotation(Size.class);
                if (annotations != null) {
                    for (Field field : fields) {
                        try {
                            if (fields[i].get(obj).toString().length() < 3) {
                                errors.add((annotations).message());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
        return errors;
    }

}
