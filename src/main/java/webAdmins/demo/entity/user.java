package webAdmins.demo.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Users")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserID;
    @NotNull
    @Column(name = "LastName")
    private String LastName;
    @NotNull
    @Column(name = "FirstName")
    private String FirstName;
    @NotNull
    @Column(name = "Address")
    private String Address;
    @NotNull
    @Column(name = "City")
    private String City;
    @NotNull
    @Column(name = "PhoneNumber")
    private String PhoneNumber;
    @NotNull
    @Column(name = "Login")
    private String Login;
    @NotNull
    @Column(name = "Password")
    private String Password;
    @NotNull
    @Column(name = "isadmin")
    private boolean isadmin;
    @NotNull
    @Column(name = "age")
    private int age;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public user() {

    }

    public user(Integer userID, String firstName, String lastName, String address, String city, String phoneNumber, String login, String password, boolean isadmin, int age) {
        UserID = userID;
        FirstName=firstName;
        LastName = lastName;
        Address = address;
        City = city;
        PhoneNumber = phoneNumber;
        Login = login;
        Password = password;
        this.isadmin = isadmin;

    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setCity(String city) {
        City = city;
    }


    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }



    public Integer getUserID() {
        return UserID;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public boolean isIsadmin() {
        return isadmin;
    }


    @Override
    public String toString() {
        return "user{" +
                "UserID=" + UserID +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", isadmin=" + isadmin +
                ", age=" + age +
                '}';
    }
}
