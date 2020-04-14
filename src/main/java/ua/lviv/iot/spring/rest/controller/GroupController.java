package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.GroupService;
import ua.lviv.iot.spring.rest.model.Group;

import java.util.List;

@RequestMapping("/groups")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public final List<Group> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Group> getGroup(final @PathVariable("id") Integer id) {
        Group groupNow;
        return (groupNow = groupService.getGroup(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(groupNow, HttpStatus.OK);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public final Group createGroup(final @RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @DeleteMapping(path = "/{id}")
    public final ResponseEntity<Group> deleteGroup(final @PathVariable("id") Integer id) {
        HttpStatus status = groupService.deleteGroup(id) ? HttpStatus.OK :
                HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @PutMapping(path = "/{id}")
    public final ResponseEntity<Group> updateGroup(final @PathVariable("id") Integer id,
                                                   final @RequestBody Group group) {
        group.setId(id);
        Group previousGroup;
        return (previousGroup = groupService.updateGroup(id, group)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(previousGroup, HttpStatus.OK);
    }
}
