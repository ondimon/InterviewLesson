package lesson7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private int age;
}
