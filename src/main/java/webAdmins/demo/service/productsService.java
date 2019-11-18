package webAdmins.demo.service;

import org.springframework.http.ResponseEntity;
import webAdmins.demo.entity.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webAdmins.demo.entity.user_Product;
import webAdmins.demo.repository.productsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class productsService {
    @Autowired
    productsRepository ProductsRepo;

    // Create user
    public products createProduct (products User_Product ) {
        return ProductsRepo.save(User_Product );
    }

    //update user
    // prepise usera v s tymto id
    public products  updateProducts(int Id, products  Product ) {
        products updated;
        Optional<products> search = ProductsRepo.findById(Id);
        if (search.isPresent()) {
            products sample = search.get();
            sample.setCapacity(Product.getCapacity());
            sample.setInfo(Product.getInfo());
            sample.setName(Product.getName());
            sample.setPrice(Product.getPrice());
            updated = ProductsRepo.save(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    //DElete usera
    public ResponseEntity<Object> deleteProducts(int Id) {
        Optional<products> Product= ProductsRepo.findById(Id);
        if (Product.isPresent()) {
            products sample = Product.get();
            ProductsRepo.delete(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    //get all users
    public List<products> getAllProducts() {
        return (List<products>) ProductsRepo.findAll();
    }
}
