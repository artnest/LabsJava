package homework.lab9;

/**
 * Created by artem on 01.11.2016.
 */
public class KeyNotUniqueException extends Exception {
    private static final long serialVersionUID = 1L;

    public KeyNotUniqueException(String key) {
        super("Key is not unique: " + key);
    }
}
