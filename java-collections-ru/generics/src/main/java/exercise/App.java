package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static  List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> params) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book: books) {
            boolean isSameBook = false;
            for (Map.Entry<String, String> searchItem : params.entrySet()) {
                if (book.containsKey(searchItem.getKey())) {
                    if (book.containsValue((searchItem.getValue()))) {
                        isSameBook = true;
                    } else {
                        isSameBook = false;
                        break;
                    }
                }
            }
            if (isSameBook) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
