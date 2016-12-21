package homework.lab13;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PORT", propOrder = "PORT")
interface PORT {
    @XmlAttribute(required = true)
    int PORT = 4422;
}
