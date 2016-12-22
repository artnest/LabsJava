package homework.lab13;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlType(name = "Message", propOrder = {
        "data"
}, namespace = "Message")
@XmlRootElement(name = "Message")
abstract class Message extends MessageXml {
    @XmlType(namespace = "Message")
    static class Data implements Serializable {
        private static final long serialVersionUID = 1L;

        protected byte id;

        @XmlAttribute
        public byte getID() {
            return id;
        }

        public void setID(byte id) {
            assert Protocol.validID(id);
            this.id = id;
        }

        @Override
        public String toString() {
            return Integer.toString(id);
        }
    }

    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    protected abstract Data getData();

    byte getID() {
        return getData().getID();
    }

    protected Message() {
    }

    protected void setup(byte id) {
        getData().setID(id);
    }

    @Override
    public String toString() {
        return getData().toString();
    }
}
