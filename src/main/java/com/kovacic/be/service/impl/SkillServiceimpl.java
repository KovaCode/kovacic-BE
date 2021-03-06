package com.kovacic.be.service.impl;

import com.kovacic.be.service.ISkillService;
import com.kovacic.be.converter.SkillConverter;
import com.kovacic.be.dto.SkillDto;
import com.kovacic.be.entity.Skill;
import com.kovacic.be.repository.SkillRepository;
import com.kovacic.be.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ikovacic.
 */
@Service
public class SkillServiceimpl implements ISkillService {
    @Autowired
    SkillRepository skillRepository;

    @Override
    public ResponseEntity<SkillDto> getSkillByName(String name) {
        Skill skill = skillRepository.findByName(name);
        return new ResponseEntity<>(SkillConverter.entityToDto(skill), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SkillDto> getSkillById(Long skillId) {
        Skill skill = skillRepository.findOne(skillId);
        return new ResponseEntity<>(SkillConverter.entityToDto(skill), HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveSkill(SkillDto skillDto) {
        skillRepository.save(SkillConverter.dtoToEntity(skillDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<SkillDto> updateSkill(Long skillId, SkillDto skillDto) {
        Skill skillCurrent = SkillConverter.dtoToEntity(this.getSkillById(skillId).getBody());
        Skill skillUpdate = SkillConverter.dtoToEntity(skillDto);

        Utils.copyNonNullProperties(skillCurrent, skillUpdate);
        skillRepository.save(skillUpdate);

        return new ResponseEntity<>(SkillConverter.entityToDto(skillUpdate), HttpStatus.ACCEPTED);
    }


    @Override
    public ResponseEntity<SkillDto> updateSkill(SkillDto skillDto) {
        Skill skill = SkillConverter.dtoToEntity(skillDto);
        skill = skillRepository.save(skill);
        return new ResponseEntity<>(SkillConverter.entityToDto(skill), HttpStatus.ACCEPTED);
    }


    @Override
    public ResponseEntity<List<SkillDto>> getSkills() {
        List<SkillDto> list = new ArrayList<>();

        return new ResponseEntity<List<SkillDto>>(SkillConverter.entityToDtoList(skillRepository.findAll()), HttpStatus.OK);
//        return new ResponseEntity<List<SkillDto>>(skillRepository.findAll().stream().map(SkillConverter::entityToDtoList).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity deleteSkill(SkillDto skillDto) {
        this.skillRepository.delete(SkillConverter.dtoToEntity(skillDto));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
