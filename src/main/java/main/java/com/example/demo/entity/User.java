package main.java.com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ikovacic.
 */
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer ID;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Skill> skills = new LinkedList<>();

    public User(){
    }


    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public User(String firstName, String lastName, String userName, String password, List<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
//        this.skills = skills;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer id) {
        this.ID = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }


}
