package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.SubjectService;
import ua.lviv.iot.spring.rest.model.Subject;

import java.util.List;

@RequestMapping("/subjects")
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public final List<Subject> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Subject> getSubject(final @PathVariable("id") Integer id) {
        Subject subjectNow;
        return (subjectNow = subjectService.getSubject(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(subjectNow, HttpStatus.OK);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public final Subject createSubject(final @RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @DeleteMapping(path = "/{id}")
    public final ResponseEntity<Subject> deleteSubject(final @PathVariable("id") Integer id) {
        HttpStatus status = subjectService.deleteSubject(id) ? HttpStatus.OK :
                HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @PutMapping(path = "/{id}")
    public final ResponseEntity<Subject> updateSubject(final @PathVariable("id") Integer id,
                                                       final @RequestBody Subject subject) {
        subject.setId(id);
        Subject previousSubject;
        return (previousSubject = subjectService.updateSubject(id, subject)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(previousSubject, HttpStatus.OK);
    }
}
