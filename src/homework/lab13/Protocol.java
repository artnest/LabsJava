package homework.lab13;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Protocol", propOrder = {
        "CMD_MIN",
        "CMD_MAX"
}, namespace = "Protocol")
@XmlRootElement (name = "Protocol")
class Protocol implements CMD, RESULT, PORT {
    @XmlAttribute(required = true)
    private static final byte CMD_MIN = CMD_CONTEXT;
    @XmlAttribute(required = true)
    private static final byte CMD_MAX = CMD_LETTER;

    static boolean validID(byte id) {
        return id >= CMD_MIN && id <= CMD_MAX;
    }
}
