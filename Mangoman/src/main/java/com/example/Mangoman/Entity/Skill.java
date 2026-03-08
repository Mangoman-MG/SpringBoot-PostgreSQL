package com.example.Mangoman.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "skill_name")
    private String skillName;
    private String description;
    private String url;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSkillName() {
//        return skillName;
//    }
//
//    public void setSkillName(String skillName) {
//        this.skillName = skillName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public Skill(Long id, String skillName, String description, String url) {
//        this.id = id;
//        this.skillName = skillName;
//        this.description = description;
//        this.url = url;
//    }
//
//    public Skill() {
//    }
}
