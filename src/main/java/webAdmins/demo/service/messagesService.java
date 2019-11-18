package webAdmins.demo.service;

import org.springframework.http.ResponseEntity;
import webAdmins.demo.entity.messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webAdmins.demo.entity.products;
import webAdmins.demo.repository.messagesRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class messagesService {
    @Autowired
    messagesRepository MessagesRepo;

    // Create user
    public messages createMessages (messages User_Product ) {
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
    public List<messages> getAllMessages() {
        return (List<messages>) MessagesRepo.findAll();
    }
}
