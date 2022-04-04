package kw.test.chat.message;

public class LoginRequestMessage extends Message {
    private String username;
    private String password;

    public LoginRequestMessage(){}

    public LoginRequestMessage(String username,String password){
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int getMessageType() {
        return LoginRequestMessage;
    }

    @Override
    public String toString() {
        return "LoginRequestMessage{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
