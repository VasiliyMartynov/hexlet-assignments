package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{
    SingleTag(String tagName, Map<String, String> tagAttributes) {
        super(tagName,tagAttributes);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("<" + name);
        for(Map.Entry<String,String> entry: attributes.entrySet()) {
            s.append(" " + entry.getKey() + "=\"" + entry.getValue() + "\"");
        }
        s.append(">");
        return s.toString();
    }
}
// END
