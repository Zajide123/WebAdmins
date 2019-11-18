package webAdmins.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webAdmins.demo.entity.data;
import webAdmins.demo.entity.user;
import webAdmins.demo.service.dataService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class dataController {
    @Autowired
    dataService service;

    @RequestMapping(value = "/Data")
    public List<data> sample() {
        return service.getAllData();
    }
    @RequestMapping(value = "/createData", method = RequestMethod.POST)
    public data createUser(@Valid @RequestBody data Data) {
        return service.createData(Data);
    }

    @RequestMapping(value = "/deleteData/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") int id) {
        return service.deleteData(id);
    }

    @RequestMapping(value = "/updateData/{id}", method = RequestMethod.PUT)
    public data updateUser(@PathVariable(value = "id") int id,
                                     @Valid @RequestBody data Data) {
        return service.updateData(id, Data);
    }
}
