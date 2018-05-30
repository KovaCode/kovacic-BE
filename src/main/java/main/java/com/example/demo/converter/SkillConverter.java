package main.java.com.example.demo.converter;

import main.java.com.example.demo.dto.SkillDto;
import main.java.com.example.demo.entity.Skill;

/**
 * Created by ashish on 13/5/17.
 */
public class SkillConverter {

	public static Skill dtoToEntity(SkillDto SkillDto) {
		Skill Skill = new Skill(SkillDto.getName(), null);
		Skill.setSkillId(SkillDto.getID());
		return Skill;
	}

	public static SkillDto entityToDto(Skill skill) {
		return new SkillDto(skill.getSkillId(), skill.getSkillName());
	}
}
