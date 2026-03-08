package com.example.Mangoman.Service.Impl;

import com.example.Mangoman.Entity.Skill;
import com.example.Mangoman.Repo.SkillRepository;
import com.example.Mangoman.Service.SkillService;
import com.example.Mangoman.dto.AddSkillDTO;
import com.example.Mangoman.dto.SkillDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final ModelMapper modelMapper;
//    public SkillServiceImpl(SkillRepository _skillRepository) {
//        this.skillRepository = _skillRepository;
//    }

    @Override
    public List<SkillDTO> getSkills() {
        List<Skill> skills = skillRepository.findAll();
        return skills
                .stream()
                .map(skill -> modelMapper.map(skill, SkillDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public SkillDTO getSkillsById(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Skill ko co id nay"+id));
        return modelMapper.map(skill, SkillDTO.class);
    }

    @Override
    public SkillDTO addSkill(AddSkillDTO addSkillDTO) {
        Skill newskill = modelMapper.map(addSkillDTO, Skill.class);
        Skill skill = skillRepository.save(newskill);
        return modelMapper.map(skill, SkillDTO.class);
    }

    @Override
    public void deleteskill(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new IllegalArgumentException("Skill ko co id nay"+id);
        }
        skillRepository.deleteById(id);
    }

    @Override
    public SkillDTO updateskill(Long id, AddSkillDTO addSkillDTO) {
        Skill skill = skillRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Skill ko co id nay"+id));
        modelMapper.map(addSkillDTO, skill);
        skill = skillRepository.save(skill);
        return modelMapper.map(skill, SkillDTO.class);
    }

    @Override
    public SkillDTO updateSkill(Long id, Map<String, Object> updates) {
        Skill skill = skillRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Skill ko co id nay"+id));
        updates.forEach((fieldName, value) -> {
            switch (fieldName) {
                case "skillName": skill.setSkillName((String) value); break;
                case "description": skill.setDescription((String) value); break;
                case "url": skill.setUrl((String) value); break;
                default:
                    throw new IllegalArgumentException("dong nay ko ho tro"+fieldName);
            }
        });
        Skill saveskill = skillRepository.save(skill);
        return modelMapper.map(saveskill, SkillDTO.class);
    }
//    @Override
//    public SkillDTO addSkill(AddSkillDTO addSkillDTO) {
//
//        System.out.println("DTO URL: " + addSkillDTO.getUrl());
//
//        Skill newskill = modelMapper.map(addSkillDTO, Skill.class);
//
//        System.out.println("Entity URL: " + newskill.getUrl());
//
//        Skill skill = skillRepository.save(newskill);
//
//        return modelMapper.map(skill, SkillDTO.class);
//    }


}
