package nl.hu.bep.countrycase.security;

public class LoginRequest {
    
    private String user;
    private String password;

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }
}
