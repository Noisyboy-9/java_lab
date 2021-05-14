package sina.shariati.note;

import java.io.Serializable;

/**
 * The type Note.
 */
public class Note implements Serializable {
    private final String body;
    private final String name;

    /**
     * Instantiates a new Note.
     *
     * @param name the name
     * @param body the body
     */
    public Note(String name, String body) {
        this.body = body;
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }
}
