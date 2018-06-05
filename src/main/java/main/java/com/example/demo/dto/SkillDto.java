package main.java.com.example.demo.dto;

/**
 * Created by ashish on 13/5/17.
 */
public class SkillDto {
    Long ID;
    String name;

    public SkillDto(Long id, String name) {
        this.ID = id;
        this.name = name;
    }

    public SkillDto() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
