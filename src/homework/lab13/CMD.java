package homework.lab13;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CMD", propOrder = {
        "CMD_CONTEXT",
        "CMD_CONNECT",
        "CMD_DISCONNECT",
        "CMD_USER",
        "CMD_CHECK_MAIL",
        "CMD_LETTER",
        "CMD_CONNECT_USER",
        "CMD_DISCONNECT_USER"
}, namespace = "CMD")
interface CMD {
    @XmlAttribute(required = true)
    byte CMD_CONTEXT = 1;
    @XmlAttribute(required = true)
    byte CMD_CONNECT = 2;
    @XmlAttribute(required = true)
    byte CMD_DISCONNECT = 3;
    @XmlAttribute(required = true)
    byte CMD_USER = 4;
    @XmlAttribute(required = true)
    byte CMD_CHECK_MAIL = 5;
    @XmlAttribute(required = true)
    byte CMD_LETTER = 6;
    @XmlAttribute(required = true)
    byte CMD_CONNECT_USER = 7;
    @XmlAttribute(required = true)
    byte CMD_DISCONNECT_USER = 8;
}
