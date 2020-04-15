package ua.lviv.iot.spring.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.SubjectRepository;
import ua.lviv.iot.spring.rest.model.Subject;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubject(Integer id) {
        if (subjectRepository.existsById(id)) {
            return subjectRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public boolean deleteSubject(Integer id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Subject updateSubject(Integer id, Subject subject) {
        if (subjectRepository.existsById(id)) {
            Subject previousSubject = subjectRepository.findById(id).get();
            subjectRepository.save(subject);
            return previousSubject;
        } else {
            return null;
        }
    }
}
