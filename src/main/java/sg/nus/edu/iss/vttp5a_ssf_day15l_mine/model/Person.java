package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person implements Serializable {

    private String identifier;

    @NotBlank(message = "Id cannot be blank")
    private String id;

    @Size(min = 2, max = 50, message = "Full Name must be between 2 and 50 characters")
    @NotBlank(message = "Full Name cannot be blank")
    private String fullName;

    @Email(message = "Email input does not conform to email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    public Person(){

    }

    public Person(String id, String fullName, String email) {
        this.identifier = new Identifier().generateIdentifier();
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
}
