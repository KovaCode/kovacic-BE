package main.java.com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill  {
    @Column
    @Id
    @GeneratedValue
    private Long ID;
    @Column(unique = true)
    private String name;

//    @OneToMany(
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private User user;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Skill(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }


	public Long getID() {
        return ID;
    }

    public void setSkillId(Long ID) {
        this.ID = ID;
    }

    public String getSkillName() {
        return name;
    }

    public void setSkillName(String name) {
        this.name = name;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
