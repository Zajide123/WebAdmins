package webAdmins.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import webAdmins.demo.entity.messages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webAdmins.demo.entity.user;

import java.util.List;

@Repository
public interface messagesRepository extends JpaRepository<messages,Integer> {
    @Query(value = "SELECT messages FROM messages u where u.UserID= :ID", nativeQuery = true)
    user FindByid(@Param("ID") int ID);

    @Query(value = "SELECT messages FROM messages u where u.recipient= :recipient", nativeQuery = true)
    user FindByRecipient(@Param("recipient") String recipient);
}
