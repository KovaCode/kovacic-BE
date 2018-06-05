package main.java.com.example.demo.service;

import main.java.com.example.demo.dto.SkillDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ikovacic
 */
public interface ISkillService {

    ResponseEntity<List<SkillDto>> getSkillByName(String name);

    ResponseEntity<SkillDto> getSkillById(Long skillId);

    ResponseEntity saveSkill(SkillDto skillDto);

    ResponseEntity<SkillDto> updateSkill(Long skillId, SkillDto skillDto);

    ResponseEntity<SkillDto> updateSkill(SkillDto skillDto);

    ResponseEntity<List<SkillDto>> getSkills();

    ResponseEntity deleteSkill(SkillDto skillDto);
}
