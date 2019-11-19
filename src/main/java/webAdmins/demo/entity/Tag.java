package webAdmins.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int ID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Words")
    private String Words;

    public Tag() {
    }

    public Tag(int ID, String name, String words) {
        this.ID = ID;
        Name = name;
        Words = words;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWords() {
        return Words;
    }

    public void setWords(String words) {
        Words = words;
    }
}
