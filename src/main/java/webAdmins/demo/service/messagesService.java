package webAdmins.demo.service;

import org.springframework.http.ResponseEntity;
import webAdmins.demo.entity.messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webAdmins.demo.entity.products;
import webAdmins.demo.entity.user;
import webAdmins.demo.repository.messagesRepository;
import webAdmins.demo.repository.userRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class messagesService {
    @Autowired
    messagesRepository MessagesRepo;
    userRepository UserRepo;
    // Create user
    public messages createMessages (messages User_Product ) {
        if(User_Product.getTag()=="ine"){

            String one = "zariadenie";
            String two = "dáta";
            String three = "internet";

            if(isContainExactWord(User_Product.getBody(), one))
            {
                User_Product.setTag("Problémy s HW");
            }
            if(isContainExactWord(User_Product.getBody(), two))
            {
                User_Product.setTag("Problémy s Dátami");
            }
            if(isContainExactWord(User_Product.getBody(), three))
            {
                User_Product.setTag("Problémy s internetom");
            }
            }
        return MessagesRepo.save(User_Product );
        }





    //update user
    // prepise usera v s tymto id
    public messages updateMessages(int Id, messages  Messages ) {
        messages updated;
        Optional<messages> search = MessagesRepo.findById(Id);
        if (search.isPresent()) {
            messages sample = search.get();
            sample.setBody(Messages.getBody());
            sample.setRecipient(Messages.getRecipient());
            sample.setTag(Messages.getTag());
            sample.setTitle(Messages.getTitle());
            sample.setUserID(Messages.getUserID());
            updated = MessagesRepo.save(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    //DElete usera
    public ResponseEntity<Object> deleteMessages(int Id) {
        Optional<messages> Product= MessagesRepo.findById(Id);
        if (Product.isPresent()) {
            messages sample = Product.get();
            MessagesRepo.delete(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    //get all users

    public List<messages> getAllMessages(int ID) {
        return (List<messages>) MessagesRepo.FindByid(ID);
    }


    public List<messages> getDostane(int ID) {
        user user= UserRepo.FindByID(ID);
        return (List<messages>) MessagesRepo.FindByRecipient(user.getFirstName());
    }
    private boolean isContainExactWord(String fullString, String partWord){
        String pattern = "\\b"+partWord+"\\b";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(fullString);
        return m.find();
    }
}
