package com.example.Mangoman.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddSkillDTO {
    @NotBlank( message = "Khong de trong ten")
    @Size(min = 2, max = 30, message = "ten chi tu 2 - 30 ky tu")
    private String skillName;
    @NotBlank(message = "Khong de trong mo ta")
    private String description;
    @URL
    @NotBlank(message = "Khong de trong url")
    private String url;
}
