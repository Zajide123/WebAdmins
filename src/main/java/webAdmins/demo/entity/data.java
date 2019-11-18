package webAdmins.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Data")
public class data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DataID;
    @NotNull
    @Column(name = "BillID")
    private int BillID;
    @NotNull
    @Column(name = "DataUsed")
    private String DataUsed;

    public data() {
    }

    public data(int dataID, int billID, String dataUsed) {
        DataID = dataID;
        BillID = billID;
        DataUsed = dataUsed;
    }

    public int getDataID() {
        return DataID;
    }

    public void setDataID(int dataID) {
        DataID = dataID;
    }

    public int getBillID() {
        return BillID;
    }

    public void setBillID(int billID) {
        BillID = billID;
    }

    public String getDataUsed() {
        return DataUsed;
    }

    public void setDataUsed(String dataUsed) {
        DataUsed = dataUsed;
    }

    @Override
    public String toString() {
        return "data{" +
                "DataID=" + DataID +
                ", BillID=" + BillID +
                ", DataUsed='" + DataUsed + '\'' +
                '}';
    }
}
