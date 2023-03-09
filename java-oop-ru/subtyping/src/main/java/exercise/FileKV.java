package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage{
    private final String filePath;

    FileKV (String filePath, Map<String, String> data) {
        this.filePath = filePath;
        var file = Utils.serialize(data);
        Utils.writeFile(this.filePath, file);
    }

    @Override
    public void set(String key, String value) {
        var file = Utils.readFile(this.filePath);
        var data = Utils.unserialize(file);
        data.put(key, value);
        var json = Utils.serialize(data);
        Utils.writeFile(this.filePath, json);
    }

    @Override
    public void unset(String key) {
        var file = Utils.readFile(this.filePath);
        var data = Utils.unserialize(file);
        data.remove(key);
        var json = Utils.serialize(data);
        Utils.writeFile(this.filePath, json);
    }

    @Override
    public String get(String key, String defaultValue) {
        var file = Utils.readFile(this.filePath);
        var data = Utils.unserialize(file);
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        var file = Utils.readFile(this.filePath);
        var data = Utils.unserialize(file);
        return new HashMap<>(data);
    }
}
// END
