package exercise;

import java.lang.reflect.Field;
import java.text.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    private static Address address;

    public static List<String> validate(Address address)  {
        List<String> nullField = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                String fieldValue = (String) field.get(address);
                if (field.isAnnotationPresent(NotNull.class) && fieldValue == null) {
                    nullField.add(field.getName());
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nullField;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result  = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            List<String> errors = new ArrayList<>();
            MinLength minLength = field.getAnnotation(MinLength.class);

            int length = 0;
            if (minLength != null) {
                length = minLength.minLength();
            }

            try {
                String fieldValue = (String) field.get(address);
                if (field.isAnnotationPresent(NotNull.class) && fieldValue == null) {
                    errors.add("can not be null");
                    result.put(fieldName, errors);
                }
                if (field.isAnnotationPresent(MinLength.class) && fieldValue.length() < length) {
                    errors.add("length less than " + length);
                    result.put(fieldName, errors);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}
// END
