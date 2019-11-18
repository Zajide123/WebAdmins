package webAdmins.demo.service;

import org.springframework.http.ResponseEntity;
import webAdmins.demo.entity.bills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webAdmins.demo.entity.data;
import webAdmins.demo.repository.billsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class billsService {

    @Autowired
    billsRepository BillsRepository ;

    // Create user
    public bills createBills (bills User_Product ) {
        return BillsRepository.save(User_Product );
    }

    //update user
    // prepise usera v s tymto id
    public bills updateBills(int Id, bills Bills) {
        bills updated;
        Optional<bills> search = BillsRepository.findById(Id);
        if (search.isPresent()) {
            bills sample = search.get();
            sample.setCapacity(Bills.getCapacity());
            sample.setEndDate(Bills.getEndDate());
            sample.setStartDate(Bills.getStartDate());
            updated = BillsRepository.save(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    //DElete usera
    public ResponseEntity<Object> deleteBills(int Id) {
        Optional<bills> Product= BillsRepository.findById(Id);
        if (Product.isPresent()) {
            bills sample = Product.get();
            BillsRepository.delete(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    //get all users
    public List<bills> getAllBills() {
        return (List<bills>) BillsRepository.findAll();
    }


}
