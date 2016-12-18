package homework.lab13;

class Protocol implements CMD, RESULT, PORT {
    private static final byte CMD_MIN = CMD_CONTEXT;
    private static final byte CMD_MAX = CMD_LETTER;

    static boolean validID(byte id) {
        return id >= CMD_MIN && id <= CMD_MAX;
    }
}
