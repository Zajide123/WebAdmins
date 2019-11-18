package webAdmins.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import webAdmins.demo.entity.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dataRepository extends JpaRepository<data,Integer> {


}
