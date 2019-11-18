package webAdmins.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webAdmins.demo.entity.messages;
import webAdmins.demo.entity.user;
import webAdmins.demo.service.messagesService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class messagesController {
    @Autowired
    messagesService service;

    @RequestMapping(value = "/Messages")
    public List<messages> sample() {
        return service.getAllMessages();
    }
    @RequestMapping(value = "/createMessage", method = RequestMethod.POST)
    public messages createUser(@Valid @RequestBody messages messages) {
        return service.createMessages(messages);
    }

    @RequestMapping(value = "/deleteMessage/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") int id) {
        return service.deleteMessages(id);
    }

    @RequestMapping(value = "/updateMessage/{id}", method = RequestMethod.PUT)
    public messages updateUser(@PathVariable(value = "id") int id,
                                     @Valid @RequestBody messages messages) {
        return service.updateMessages(id, messages);
    }
}
