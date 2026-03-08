package com.example.Mangoman.Service;

import com.example.Mangoman.Entity.Skill;
import com.example.Mangoman.dto.AddSkillDTO;
import com.example.Mangoman.dto.SkillDTO;

import java.util.List;
import java.util.Map;

public interface SkillService {
    List<SkillDTO> getSkills();

    SkillDTO getSkillsById(Long id);

    SkillDTO addSkill(AddSkillDTO addSkillDTO);

    void deleteskill(Long id);

    SkillDTO updateskill(Long id, AddSkillDTO addSkillDTO);

    SkillDTO updateSkill(Long id, Map<String, Object> updates);
}
