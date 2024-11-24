package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model;

public class Person {
    private String identifier;
    private String id;
    private String fullName;
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
