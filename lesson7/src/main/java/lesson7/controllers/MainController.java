package lesson7.controllers;

import lesson7.dto.StudentDto;
import lesson7.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping({"", "/"})
    public String getIndex(Model model) {
        List<StudentDto> studentDtoList = studentsService.getStudentsDto();
        model.addAttribute("students", studentDtoList);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model  model) {
        StudentDto studentDto = studentsService.findByIDDto(id);
        model.addAttribute("student", studentDto);
        return "edit_student";
    }

    @PostMapping("/edit")
    private String updateStudent(@ModelAttribute StudentDto studentDto){
        studentsService.saveOrUpdate(studentDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentsService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addStudent() {
        return "add_student";
    }

    @PostMapping("/add")
    public  String saveNewStudent(@ModelAttribute StudentDto studentDto) {
        studentsService.saveOrUpdate(studentDto);
        return "redirect:/";
    }

}
