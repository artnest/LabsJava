package homework.lab13;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "RESULT", propOrder = {
        "RESULT_CODE_OK",
        "RESULT_CODE_ERROR"
}, namespace = "RESULT")
interface RESULT {
    @XmlAttribute(required = true)
    int RESULT_CODE_OK      = 0;
    @XmlAttribute(required = true)
    int RESULT_CODE_ERROR   = -1;
}
