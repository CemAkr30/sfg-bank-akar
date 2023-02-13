package ca.springframework.sfgbankakar.dto;

import ca.springframework.sfgbankakar.enums.Role;
import ca.springframework.sfgbankakar.model.Kimlik;
import lombok.Data;

//@Data -> okumuyor MapperDtoImpl
public class KullaniciGirisDTO {

    private String password;
    private String  username;
    private Kimlik kimlik;
    private Role role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Kimlik getKimlik() {
        return kimlik;
    }

    public void setKimlik(Kimlik kimlik) {
        this.kimlik = kimlik;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
