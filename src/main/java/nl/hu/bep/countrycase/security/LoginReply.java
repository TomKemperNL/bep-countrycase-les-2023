package nl.hu.bep.countrycase.security;

public class LoginReply {

    private String token;
    public LoginReply(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
