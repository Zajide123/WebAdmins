package webAdmins.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webAdmins.demo.entity.Tag;

public interface TagsRepository extends JpaRepository<Tag,Integer> {


}
