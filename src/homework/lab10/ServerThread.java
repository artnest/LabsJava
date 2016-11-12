package homework.lab10;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;

class ServerThread extends Thread {
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private InetAddress address;

    private String userNick;
    private String userFullName;

    private Vector<String> letters;

    ServerThread(Socket socket) throws IOException {
        os = new ObjectOutputStream(socket.getOutputStream());
        is = new ObjectInputStream(socket.getInputStream());
        address = socket.getInetAddress();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = (Message) is.readObject();

                switch (msg.getID()) {
                    case Protocol.CMD_CONNECT:
                        connect((MessageConnect) msg);
                        break;
                    case Protocol.CMD_DISCONNECT:
                        synchronized (Server.syncMap) {
                            Server.users.remove(userNick);
                        }
                        break;
                    case Protocol.CMD_USER:
                        user((MessageUser) msg);
                        break;
                    case Protocol.CMD_CHECK_MAIL:
                        checkMail((MessageCheckMail) msg);
                        break;
                    case Protocol.CMD_LETTER:
                        letter((MessageLetter) msg);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Disconnect...");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            disconnect();
        }
    }

    private boolean connect(MessageConnect msg) throws IOException {
        userNick = msg.userNick;
        userFullName = msg.userFullName;

        ServerThread old;
        synchronized (Server.syncMap) {
            old = Server.users.get(userNick);
            if (old == null) {
                Server.users.put(userNick, this);
            }
        }

        if (old == null) {
            os.writeObject(new MessageConnectResult());
            return true;
        } else {
            os.writeObject(new MessageConnectResult("User " + old.userFullName +
                                                    " already connected as " + userNick));
            return false;
        }
    }

    private void user(MessageUser msg) throws IOException {
        String[] nicks = null;
        synchronized (Server.syncMap) {
            if (Server.users.isEmpty()) {
                os.writeObject(new MessageUserResult("Unable to get users list"));
            } else {
                nicks = Server.users.keySet().toArray(new String[Server.users.keySet().size()]);
            }
        }

        os.writeObject(new MessageUserResult(nicks));
    }

    private void letter(MessageLetter msg) throws IOException {
        ServerThread thread;
        synchronized (Server.users) {
            if (Server.users.isEmpty()) {
                os.writeObject(new MessageLetterResult("Users not found"));
            } else {
                for (String user : Server.users.keySet()) {
                    thread = Server.users.get(user);
                    if (thread.letters == null) {
                        thread.letters = new Vector<>();
                    }

                    thread.letters.add(userNick + ": " + msg.text);
                }
            }
        }

        os.writeObject(new MessageLetterResult());
    }

    private void checkMail(MessageCheckMail msg) throws IOException {
        String[] lts = null;
        synchronized (this) {
            if (letters != null) {
                lts = letters.toArray(new String[letters.size()]);
                letters = null; // TODO change the behaviour to save stack messages
            }
        }

        if (lts != null) {
            os.writeObject(new MessageCheckMailResult(lts));
        } else {
            os.writeObject(new MessageCheckMailResult("Unable to get mail"));
        }
    }

    private void disconnect() {
        try {
            System.out.println(address + " disconnected");
            os.close();
            is.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            interrupt();
        }
    }
}
