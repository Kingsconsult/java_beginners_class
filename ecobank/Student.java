package ecobank;

public class Student {
    String name;
    long Id;
    String email;

    

    // Student (long Id, String name, String email) {
    //     this.Id = Id;
    //     this.name = name;
    //     this.email = email;
    // }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
