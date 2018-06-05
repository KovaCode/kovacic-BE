package main.java.com.example.demo.controller;

import main.java.com.example.demo.dto.SkillDto;
import main.java.com.example.demo.service.ISkillService;
import main.java.com.example.demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/skill")
@RestController
public class SkillController {

	@Autowired
	ISkillService skillService;

	@RequestMapping(Constants.GET_SKILL_BY_ID)
	public ResponseEntity<SkillDto> getSkillById(@PathVariable Long skillId) {
		return skillService.getSkillById(skillId);
	}

	@RequestMapping(Constants.GET_SKILL_BY_NAME)
	public ResponseEntity<SkillDto> getSkillByName(@PathVariable String name) {
		return skillService.getSkillByName(name);
	}

	@RequestMapping(Constants.GET_ALL_SKILLS)
	public ResponseEntity<List<SkillDto>> getAllSkils() {
		return skillService.getSkills();
	}

	@PutMapping(Constants.UPDATE_SKILL)
	public ResponseEntity<SkillDto> updateSkill(@PathVariable(value = "id") Long skillId,
						   @Valid @RequestBody SkillDto skillDto) {
		return skillService.updateSkill(skillId, skillDto);
	}

	@PostMapping(value= Constants.SAVE_SkILL)
	public ResponseEntity saveSkill(@RequestBody SkillDto skillDto) {
		return skillService.saveSkill(skillDto);
	}

	@DeleteMapping(value= Constants.DELETE_SKILL)
	public ResponseEntity deleteSkill(@RequestBody SkillDto skillDto) {
		return skillService.deleteSkill(skillDto);
	}




}
