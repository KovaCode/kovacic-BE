package main.java.com.example.demo.dto;

/**
 * Created by ashish on 13/5/17.
 */
public class SkillDto {
    Integer ID;
    String name;

    public SkillDto(Integer id, String name) {
        this.ID = id;
        this.name = name;
    }

    public SkillDto() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String skillName) {
        this.name = name;
    }
}
