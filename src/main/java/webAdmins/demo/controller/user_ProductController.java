package webAdmins.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webAdmins.demo.entity.user;
import webAdmins.demo.entity.user_Product;
import webAdmins.demo.service.user_ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class user_ProductController {
    @Autowired
    user_ProductService service;

    @RequestMapping(value = "/User_Products")
    public List<user_Product> sample() {
        return service.getAllUser_Product();
    }
    @RequestMapping(value = "/createUser_Product", method = RequestMethod.POST)
    public user_Product createUser(@Valid @RequestBody user_Product user_Product) {
        return service.createUser_Product(user_Product);
    }

    @RequestMapping(value = "/deleteUser_Product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") int id) {
        return service.deleteUser_Product(id);
    }

    @RequestMapping(value = "/updateUser_Product/{id}", method = RequestMethod.PUT)
    public user_Product updateUser(@PathVariable(value = "id") int id,
                                     @Valid @RequestBody user_Product user_Product) {
        return service.updateUser_Product(id, user_Product);
    }
}
