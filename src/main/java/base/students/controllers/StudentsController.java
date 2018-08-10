package base.students.controllers;

import base.students.entities.Student;
import base.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
//@RestController
public class StudentsController {
    private String sortDateMethod = "ASC";
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
    public @ResponseBody String student(@RequestBody Student student) {
        studentService.insert(student);

        return "student created";
    }

//    @GetMapping
//    public @ResponseBody List<Student> students() {
//        return studentService.getAllStudents();
//    }

    @GetMapping
    public String students(Model model) {
        List<Student> students = filterAndSort();
        model.addAttribute("students", students);
        return "students";
    }

    private List<Student> filterAndSort() {
        //TODO fix it
        switch (sortDateMethod) {
            case "ASC":
                return studentService.getAllStudents();
            case "DESC":
                return studentService.getAllStudents();
        }
        return null;
    }

    @GetMapping("/users/getByName")
    public @ResponseBody List<Student> findByName(@PathVariable String firstName) {
        return studentService.findByName(firstName);

    }
}
