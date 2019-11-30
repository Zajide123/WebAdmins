package webAdmins.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/{id}/Messages")
    public String sample(@PathVariable(value = "id") int Id, Model model) {
        //return
        model.addAttribute("mojeSpravy", service.getAllMessages(Id));
        model.addAttribute("dorucene", service.getDostane(Id));
        return "AdmMsgs";
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
