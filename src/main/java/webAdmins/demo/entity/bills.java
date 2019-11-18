package webAdmins.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Bills")
public class bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int   BillID;
    @NotNull
    @Column(name = "StartDate")
    private java.sql.Date StartDate;
    @NotNull
    @Column(name = "EndDate")
    private java.sql.Date EndDate;
    @NotNull
    @Column(name = "Capacity")
    private String Capacity;

    public bills(int billID, Date startDate, Date endDate, String capacity) {
        BillID = billID;
        StartDate = startDate;
        EndDate = endDate;
        Capacity = capacity;
    }

    public bills() {
    }

    @Override
    public String toString() {
        return "bills{" +
                "BillID=" + BillID +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", Capacity='" + Capacity + '\'' +
                '}';
    }

    public int getBillID() {
        return BillID;
    }

    public void setBillID(int billID) {
        BillID = billID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }
}
