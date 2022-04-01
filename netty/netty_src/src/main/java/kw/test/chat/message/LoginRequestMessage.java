package kw.test.chat.message;

public class LoginRequestMessage extends Message {
    private String username;
    private String password;

    public LoginRequestMessage(){}

    public LoginRequestMessage(String username,String password){
        this.password = password;
        this.username = username;
    }

    @Override
    public int getMessageType() {
        return LoginRequestMessage;
    }
}
