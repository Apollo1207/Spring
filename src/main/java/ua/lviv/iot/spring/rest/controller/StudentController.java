package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.StudentService;
import ua.lviv.iot.spring.rest.model.Student;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public final List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getSportBuild(final @PathVariable("id") Integer id) {
        Student studentNow;
        return (studentNow = studentService.getStudent(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(studentNow, HttpStatus.OK);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public final Student createStudent(final @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public final ResponseEntity<Student> deleteStudent(final @PathVariable("id") Integer id) {
        HttpStatus status = studentService.deleteStudent(id) ? HttpStatus.OK :
                HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @PutMapping(path = "/{id}")
    public final ResponseEntity<Student> updateStudent(final @PathVariable("id") Integer id,
                                                       final @RequestBody Student sportBuild) {
        sportBuild.setId(id);
        Student previousStudent;
        return (previousStudent = studentService.updateStudent(id, sportBuild)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(previousStudent, HttpStatus.OK);
    }
}

