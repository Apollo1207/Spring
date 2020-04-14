package ua.lviv.iot.spring.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.GroupRepository;
import ua.lviv.iot.spring.rest.model.Group;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Group getGroup(Integer id) {
        if (groupRepository.existsById(id)) {
            return groupRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public boolean deleteGroup(Integer id) {
        if (groupRepository.existsById(id)) {
            groupRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Group updateGroup(Integer id, Group group) {
        if (groupRepository.existsById(id)) {
            Group previousGroup = groupRepository.findById(id).get();
            groupRepository.save(group);
            return previousGroup;
        } else {
            return null;
        }
    }
}
