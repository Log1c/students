package base.students.controllers;

import base.students.entities.Student;
import base.students.service.StudentService;
import base.students.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class StudentsController {

//    @RequestMapping(value="/student", method= RequestMethod.GET)
//    public String studentForm(Model model) {
//        model.addAttribute("student", new Student());
//        return "student";
//    }
//
//    @RequestMapping(value="/student", method=RequestMethod.POST)
//    public String greetingSubmit(@ModelAttribute Student student, Model model) {
//        model.addAttribute("student", student);
//        return "result";
//    }

    @Autowired
    private StudentService studentService;
//
//    @Autowired
//    private UserService userService;

    @PostMapping
    public String student(@RequestBody Student student) {
        studentService.insert(student);

        return "student created";
    }

    @GetMapping
    public List<Student> students() {
        return studentService.getAllStudents();
    }
}
