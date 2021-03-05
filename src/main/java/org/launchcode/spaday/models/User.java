package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message="Username is required.")
    @Size(min=5, max=15, message="Username must be between 5 and 15 characters.")
    private String username;

    @Email(message="A Valid Email Is Required.")
    private String email;

    @NotBlank(message="That isn't a valid password.")
    @Size(min=6, message="Password must be at least 6 characters long.")
    private String password;

    @NotNull(message="Passwords do not match.")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;

        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {

        this.verifyPassword = verifyPassword;

        checkPassword();
    }

    private void checkPassword(){

        if(this.password == null){
            this.verifyPassword = null;
        }
        if(this.verifyPassword.isBlank()){
            this.verifyPassword = null;
        }
        if(!this.password.equals(this.verifyPassword)){
            this.verifyPassword = null;
        }

    }
}
