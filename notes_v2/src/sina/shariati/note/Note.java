package sina.shariati.note;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Note.
 */
public class Note implements Serializable {
    private final String body;
    private final String name;
    private final Date date;

    /**
     * Instantiates a new Note.
     *
     * @param name the name
     * @param body the body
     * @param date the date
     */
    public Note(String name, String body, Date date) {
        this.body = body;
        this.name = name;
        this.date = date;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
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
