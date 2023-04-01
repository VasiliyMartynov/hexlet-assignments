package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    String name;
    Map<String, String> attributes;
    Tag(String tagName, Map<String, String> tagAttributes) {
        this.name = tagName;
        this.attributes = tagAttributes;
    }

    public abstract String toString();
}
// END
