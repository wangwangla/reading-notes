package kw.test.chat.message;

public class LoginResponseMessage extends AbstractResponseMessage {

    public LoginResponseMessage(boolean success, String reason) {
        super(success, reason);
    }

    @Override
    public int getMessageType() {
        return LoginResponseMessage;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

