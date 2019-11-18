package webAdmins.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import webAdmins.demo.entity.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface userRepository extends JpaRepository<user,Integer> {
    @Query(value = "SELECT user FROM user u where u.Login = :Login", nativeQuery = true)
  user FindByLogin(@Param("Login") String Login);
}
