package webAdmins.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Products")
public class products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer ProductID;
    @NotNull
    @Column(name = "Name")
    private  String Name;
    @NotNull
    @Column(name = "Info")
    private  String Info;
    @NotNull
    @Column(name = "Price")
    private Integer Price;
    @NotNull
    @Column(name = "Capacity")
    private  String Capacity;

    public products() {
    }

    public products(Integer productID, String name, String info, Integer price, String capacity) {
        ProductID = productID;
        Name = name;
        Info = info;
        Price = price;
        Capacity = capacity;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    @Override
    public String toString() {
        return "products{" +
                "ProductID=" + ProductID +
                ", Name='" + Name + '\'' +
                ", Info='" + Info + '\'' +
                ", Price=" + Price +
                ", Capacity='" + Capacity + '\'' +
                '}';
    }
}
