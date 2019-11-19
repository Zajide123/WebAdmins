package webAdmins.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webAdmins.demo.entity.Tag;
import webAdmins.demo.repository.TagsRepository;

import java.util.List;

@Service
public class TagsService {
    @Autowired
    TagsRepository TagsRepo;

    public List<Tag> getAllTags() {
        return TagsRepo.findAll();
    }
}