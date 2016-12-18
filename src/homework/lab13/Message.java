package homework.lab13;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

abstract class Message extends MessageXml {
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
