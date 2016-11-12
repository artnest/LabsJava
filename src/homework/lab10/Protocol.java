package homework.lab10;

public class Protocol implements CMD, RESULT, PORT {
    private static final byte CMD_MIN = CMD_CONNECT;
    private static final byte CMD_MAX = CMD_LETTER;

    public static boolean validID(byte id) {
        return id >= CMD_MIN && id <= CMD_MAX;
    }
}
