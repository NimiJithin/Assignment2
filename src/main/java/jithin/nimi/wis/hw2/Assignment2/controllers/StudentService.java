package jithin.nimi.wis.hw2.Assignment2.controllers;


import jithin.nimi.wis.hw2.Assignment2.Assignment2Application;
import jithin.nimi.wis.hw2.Assignment2.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController()
@RequestMapping(value = "/rest/student")
public class StudentService {

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public HashMap<String,Student> getAllStudents() {
        return Assignment2Application.studentHashMap;
    }

    // Adds a new student
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Student addStudent(@RequestParam(value = "name") String name, @RequestParam(value = "subject", defaultValue = "unknown") String subject) {
        Student newStudent = new Student(name,subject);
        Assignment2Application.studentHashMap.put(newStudent.getId(),newStudent);
        return newStudent;

    }

    // updates a student data
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student) throws Exception {

        if (Assignment2Application.studentHashMap.containsKey(student.getId())) {
            Assignment2Application.studentHashMap.put(UUID.randomUUID().toString(),student);
        }
            else {
            throw new Exception("Student " + student.getName() + "id : " + student.getId() + " doesn't exist");
        }
        return student;
    }

    // deletes a student data
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Student deleteStudent(@PathVariable String id) throws Exception {
        Student student;
        if (Assignment2Application.studentHashMap.containsKey(id)) {

            student = Assignment2Application.studentHashMap.get(id);
            Assignment2Application.studentHashMap.remove(id);

        } else {

            throw new Exception("Student id :" + id + " does not exist ");

        }
        return student;
    }

    // get information about the student
    @RequestMapping(value = "/{id}")
    public Student getStudent(@PathVariable String id) {


        Student student = Assignment2Application.studentHashMap.get(id);
        return student;

    }
}
