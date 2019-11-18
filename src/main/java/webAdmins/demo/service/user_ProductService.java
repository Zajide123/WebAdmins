package webAdmins.demo.service;

import org.springframework.http.ResponseEntity;
import webAdmins.demo.entity.user;
import webAdmins.demo.entity.user_Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webAdmins.demo.repository.user_ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class user_ProductService {
    @Autowired
    user_ProductRepository User_ProductRepo;

    // Create user
    public user_Product createUser_Product (user_Product User_Product ) {
        return User_ProductRepo.save(User_Product );
    }

    //update user
    // prepise usera v s tymto id
    public user_Product  updateUser_Product (int Id, user_Product  User_Product ) {
        user_Product updated;
        Optional<user_Product>  search = User_ProductRepo.findById(Id);
        if (search.isPresent()) {
            user_Product sample = search.get();
            sample.setActive(User_Product.isActive());
            sample.setEnd_Date(User_Product.getEnd_Date());
            sample.setStart_Date(User_Product.getStart_Date());
            sample.setUserID(User_Product.getUserID());
            updated = User_ProductRepo.save(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    //DElete usera
    public ResponseEntity<Object> deleteUser_Product(int Id) {
        Optional<user_Product> User_Product= User_ProductRepo.findById(Id);
        if (User_Product.isPresent()) {
            user_Product sample = User_Product.get();
            User_ProductRepo.delete(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    //get all users
    public List<user_Product> getAllUser_Product() {
        return (List<user_Product>) User_ProductRepo.findAll();
    }

}
