package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag{
    List<Tag> childTags;
    String tagBody;

    PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> tags) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childTags = tags;

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("<" + name);
        for(Map.Entry<String,String> entry: attributes.entrySet()) {
            s.append(" " + entry.getKey() + "=\"" + entry.getValue() + "\"");
        }
        s.append(">");
        s.append(tagBody);
        for(Tag t:childTags) {
            s.append(t.toString());
        }
        s.append("</" + name + ">");
        return s.toString();
    }
}
// END
