package webAdmins.demo.service;

import org.springframework.http.ResponseEntity;
import webAdmins.demo.entity.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webAdmins.demo.entity.messages;
import webAdmins.demo.repository.dataRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class dataService {
    @Autowired
    dataRepository DataRepo;

    // Create user
    public data createData(data User_Product ) {
        return DataRepo.save(User_Product );
    }

    //update user
    // prepise usera v s tymto id
    public data updateData(int Id, data  Data) {
        data updated;
        Optional<data> search = DataRepo.findById(Id);
        if (search.isPresent()) {
            data sample = search.get();
            sample.setBillID(Data.getBillID());
            sample.setDataUsed(Data.getDataUsed());
            updated = DataRepo.save(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    //DElete usera
    public ResponseEntity<Object> deleteData(int Id) {
        Optional<data> Product= DataRepo.findById(Id);
        if (Product.isPresent()) {
            data sample = Product.get();
            DataRepo.delete(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    //get all users
    public List<data> getAllData() {
        return (List<data>) DataRepo.findAll();
    }

}
