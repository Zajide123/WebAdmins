package webAdmins.demo.service;

import org.springframework.http.ResponseEntity;
import webAdmins.demo.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webAdmins.demo.repository.userRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class userService {
    @Autowired
    userRepository UserRepo;

    // Create user
    public user createUser(user User) {
        return UserRepo.save(User);
    }

    //update user
    // prepise usera v s tymto id
    public user  updateUser (int Id, user User) {
        user updateduser;
        Optional<user> searchuser = UserRepo.findById(Id);
        if (searchuser.isPresent()) {
            user sample = searchuser.get();
            sample.setAge(User.getAge());
            sample.setAddress(User.getAddress());
            sample.setCity(User.getCity());
            sample.setFirstName(User.getFirstName());
            sample.setLastName(User.getLastName());
            sample.setPhoneNumber(User.getPhoneNumber());
            sample.setIsadmin(User.isIsadmin());
            sample.setLogin(User.getLogin());
            sample.setPassword(User.getPassword());
            updateduser = UserRepo.save(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return updateduser;
    }

    //DElete usera
    public ResponseEntity<Object> deleteUser(int Id) {
        Optional<user> User= UserRepo.findById(Id);
        if (User.isPresent()) {
            user sample = User.get();
            UserRepo.delete(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
    public user FindByLogin(String login){
      user User  = UserRepo.FindByLogin(login);
        return User;
    }

    //get all users
    public List<user> getAllUsers() {
        return (List<user>) UserRepo.findAll();
    }

   /* public List<user> getAll() {
        return UserRepo.getAll();
    }*/
}
