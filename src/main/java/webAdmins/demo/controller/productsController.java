package webAdmins.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webAdmins.demo.entity.products;
import webAdmins.demo.entity.user;
import webAdmins.demo.service.productsService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class productsController {
    @Autowired
    productsService service;

    @RequestMapping(value = "/Products")
    public List<products> sample() {
        return service.getAllProducts();
    }
    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public products createUser(@Valid @RequestBody products products) {
        return service.createProduct(products);
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") int id) {
        return service.deleteProducts(id);
    }

    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
    public products updateUser(@PathVariable(value = "id") int id,
                               @Valid @RequestBody products products) {
        return service.updateProducts(id, products);
    }
}
