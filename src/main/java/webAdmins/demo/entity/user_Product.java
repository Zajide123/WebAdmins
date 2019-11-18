package webAdmins.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;

@Entity
@Table(name = "User_Product")
public class user_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int   UP_ID;
    @NotNull
    @Column(name = "UserID")
    private  int UserID;
    @NotNull
    @Column(name = "Start_Date")
    private java.sql.Date Start_Date;
    @NotNull
    @Column(name = "End_Date")
    private java.sql.Date End_Date;
    @NotNull
    @Column(name = "Active")
    private  boolean Active;

    public user_Product() {
    }

    public user_Product(int UP_ID, int userID, Date start_Date, Date end_Date, boolean active) {
        this.UP_ID = UP_ID;
        UserID = userID;
        Start_Date = start_Date;
        End_Date = end_Date;
        Active = active;
    }

    public int getUP_ID() {
        return UP_ID;
    }

    public void setUP_ID(int UP_ID) {
        this.UP_ID = UP_ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date start_Date) {
        Start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(Date end_Date) {
        End_Date = end_Date;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    @Override
    public String toString() {
        return "user_Product{" +
                "UP_ID=" + UP_ID +
                ", UserID=" + UserID +
                ", Start_Date=" + Start_Date +
                ", End_Date=" + End_Date +
                ", Active=" + Active +
                '}';
    }
}
