package homework.lab12;

class KeyNotUniqueException extends Exception {
    private static final long serialVersionUID = 1L;

    KeyNotUniqueException(String key) {
        super("Key is not unique: " + key);
    }
}
