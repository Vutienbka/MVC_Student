package MVC_Student.Model;

public class Student {
    private int Id;
    private String Name;
    private String Email;
    private String Address;
    private String dateOfBirth;
    private String image;

    public Student() {
    }

    public Student(int id, String name, String email, String address, String dateOfBirth, String image) {
        Id = id;
        Name = name;
        Email = email;
        Address = address;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
