package src;

public class Person extends BaseEntity {

    private String fName;
    private String lName;
    private String password;
    private String address;
    private String email;

     public Person(String fName, String lName, String password, String address, String email) {
         setfName(fName);
         setlName(lName);
         setPassword(password);
         setAddress(address);
         setEmail(email);
     }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getfName() {
        return fName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
