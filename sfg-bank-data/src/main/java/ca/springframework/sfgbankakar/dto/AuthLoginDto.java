package ca.springframework.sfgbankakar.dto;

public class AuthLoginDto {

    private boolean loginOnay;
    private String email;

    public boolean isLoginOnay() {
        return loginOnay;
    }

    public void setLoginOnay(boolean loginOnay) {
        this.loginOnay = loginOnay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
