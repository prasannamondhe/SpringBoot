package com.in28minutes.rest.webservices.MongoChallange;

import com.in28minutes.rest.webservices.MongoChallange.studentRecords.Student;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Prasanna.Mondhe on 1/17/2019.
 */

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/createStudentRecord")
    public Map<String, Object> createStudentRecord(@RequestBody Student student){
        student = studentRepository.save(student);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("StudentRecord",student);
        return data;
    }

    @GetMapping("/getAllStudentRecord")
    public List<Student> getAllStudentRecords(){
        return studentRepository.findAll();
    }

    @DeleteMapping("/deleteRecord/{id}")
    public void deleteStudentRecord(@PathVariable String id){
        studentRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAllRecord")
    public void deleteAllStudentRecord(){
        studentRepository.deleteAll();
    }

    @PostMapping("/update/{id}/{name}")
    public Student updateAndGetStudent(@PathVariable String id, @PathVariable String name){
        Optional<Student> student = studentRepository.findById(id);
        for (int i = 0; i < student.get().getSubjects().size(); i++) {
            if(student.get().getSubjects().get(i).getName().contentEquals(name)){
                student.get().getSubjects().get(i).setStatus(10);
                break;
            }else{
                student.get().getSubjects().get(student.get().getSubjects().size()+1).setName(name);
                student.get().getSubjects().get(student.get().getSubjects().size()+1).setStatus(2);
                studentRepository.insert(student.get());
            }

        }
        return student.get();
    }

}
