package main.java.com.example.demo.dto;

/**
 * Created by ashish on 13/5/17.
 */
public class UserDto {
    Integer ID;
    String userName;
    String password;
    String firstName;
    String lastName;
//    List<SkillDto> skillDtos= new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String userName, String password/*, List<SkillDto> skillDtos*/) {
        this.ID  = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

//        this.skillDtos = skillDtos;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

//
//    public List<SkillDto> getSkillDtos() {
//        return skillDtos;
//    }
//
//    public void setSkillDtos(List<SkillDto> skillDtos) {
//        this.skillDtos = skillDtos;
//    }
}
