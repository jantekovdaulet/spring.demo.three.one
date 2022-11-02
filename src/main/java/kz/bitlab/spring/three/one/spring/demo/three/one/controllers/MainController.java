package kz.bitlab.spring.three.one.spring.demo.three.one.controllers;

import kz.bitlab.spring.three.one.spring.demo.three.one.db.DBManager;
import kz.bitlab.spring.three.one.spring.demo.three.one.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String getIndex(Model model){
        ArrayList<Student> students = DBManager.getAllStudents();
        model.addAttribute("students", students);
        return "studentlist";
    }

    @GetMapping(value = "/registerstudent")
    public String formStudent(Model model){
        return "registerstudent";
    }

    @PostMapping(value = "/addstudent")
    public String addStudent(@RequestParam(name = "name", defaultValue = "No Name") String name,
                             @RequestParam(name = "surname", defaultValue = "No Surname") String surname,
                             @RequestParam(name = "exam", defaultValue = "0") int exam){

        String mark;
        if(exam>=90) mark = "A";
        else if (exam>=75) mark = "B";
        else if(exam>=60) mark = "C";
        else if(exam>=50) mark = "D";
        else mark = "F";

        DBManager.addStudent(new Student(null, name, surname, exam, mark));
        return "redirect:/";
    }
}
