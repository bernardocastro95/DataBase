package bernardo.castro.bernardo.castro.database.model;

public class Patient {
    private String id;
    private String name;
    private String lastName;
    private String department;

    public Patient(){

    }

    public Patient(String id, String name, String lastName, String department){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
