package com.example.Mangoman.Controler;

import com.example.Mangoman.Service.SkillService;
import com.example.Mangoman.dto.AddSkillDTO;
import com.example.Mangoman.dto.SkillDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skills")
public class Mango {
    private final SkillService skillService;

//    public Mango(SkillService skillService){
//        this.skillService = skillService;
//    }

    @GetMapping
    public ResponseEntity<List<SkillDTO>> getSkills(){
        return ResponseEntity.status(HttpStatus.OK).body(skillService.getSkills());
//        return ResponseEntity.ok(skillService.getSkills()) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> getSkill(@PathVariable Long id){
        return ResponseEntity.ok(skillService.getSkillsById(id));
    }
    @PostMapping
    public ResponseEntity<SkillDTO> addSkill(@RequestBody AddSkillDTO addSkillDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(skillService.addSkill(addSkillDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SkillDTO> deleteSkill(@PathVariable Long id){
        skillService.deleteskill(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<SkillDTO> updateSkill(@PathVariable Long id,
                                                @RequestBody AddSkillDTO addSkillDTO){
        return ResponseEntity.ok(skillService.updateskill(id, addSkillDTO));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<SkillDTO> updateSkill(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return ResponseEntity.ok(skillService.updateSkill(id, updates));
    }
}