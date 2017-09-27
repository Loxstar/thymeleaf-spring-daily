package com.theironyard.demo;

import com.theironyard.demo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping(path = "/new_student", method = RequestMethod.GET)
    public String newStudent(Model model) {
         /* call the method on the Grade enum to get all the grades */
        model.addAttribute("grades", Grade.values());
        return "new_student";
    }

    @RequestMapping(path = "/create_student", method = RequestMethod.POST)
    public String createStudent(String firstName, String lastName, Grade grade, Model model) {
        Student student = new Student(firstName, lastName, grade);

        /* set student firstName, lastName and grade using the http request parameters */

        /* add the student to the model that will be used by the view_student html file */
        model.addAttribute("student", student);
        return "view_student";
    }
}
