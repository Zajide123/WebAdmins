package webAdmins.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webAdmins.demo.entity.bills;
import webAdmins.demo.entity.user;
import webAdmins.demo.service.billsService;


import javax.validation.Valid;
import java.util.List;

@RestController
public class billsController {
    @Autowired
    billsService billsService;

    @RequestMapping(value = "/Bills")
    public List<bills> sample() {
        return billsService.getAllBills();
    }
    @RequestMapping(value = "/createBill", method = RequestMethod.POST)
    public bills createUser(@Valid @RequestBody bills Bills) {
        return billsService.createBills(Bills);
    }

    @RequestMapping(value = "/deleteBill/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") int id) {
        return billsService.deleteBills(id);
    }

    @RequestMapping(value = "/updateBill/{id}", method = RequestMethod.PUT)
    public bills updateUser(@PathVariable(value = "id") int id,
                                     @Valid @RequestBody bills Bills) {
        return billsService.updateBills(id, Bills);
    }
}
