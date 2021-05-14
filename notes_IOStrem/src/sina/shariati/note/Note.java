package sina.shariati.note;

import java.io.Serializable;

public class Note implements Serializable {
    private final String body;
    private final String name;

    public Note(String name, String body) {
        this.body = body;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }
}
