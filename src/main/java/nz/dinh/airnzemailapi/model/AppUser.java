package nz.dinh.airnzemailapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotEmpty @Email
    private String email;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public AppUser(String id, String email, String username, String password) {
        this.setId(id);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
    }

    public AppUser() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
