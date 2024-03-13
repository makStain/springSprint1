package kz.bitlab.springboot.springSprint1.controllers;

import kz.bitlab.springboot.springSprint1.db.DBManager;
import kz.bitlab.springboot.springSprint1.model.Students;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping (value = "/home")
    public String indexPage (Model model) {
        ArrayList<Students> allStudents = DBManager.getAllStudents();
        model.addAttribute("allStudentsAttribute", allStudents);
        return "index";
    }

    @GetMapping (value = "/addPage")
    public String addPage (Model model) {
        return "addStudent";
    }

    @PostMapping (value = "/addStudent")
    public String addStudent (@RequestParam(name = "name") String studentName,
                              @RequestParam(name = "surname") String studentSurname,
                              @RequestParam(name = "exam") int studentExam){
        Students student = new Students();
        student.setName(studentName);
        student.setSurname(studentSurname);
        student.setExam(studentExam);
        DBManager.addStudent(student);
        return "redirect:/home";
    }
}
