package com.test2.test2.repository;

import com.test2.test2.entity.Test2Entity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Test2Repo extends JpaRepository<Test2Entity,Integer> {

    List<Test2Entity>findAll();
    List<Test2Entity>findByIdd(Integer id);
    List<Test2Entity>findByName(String name);
    String deleteByName(String name);
    @Modifying
    @Transactional
    @Query(value="insert into test2entity (idd,country,name)values (:idd,:country,:name)",nativeQuery = true)
    int getInsertedData(@Param("idd") Integer idd,@Param("country") String country,@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value="delete from test2entity where idd=:idd",nativeQuery = true)
    int getDeleted(@Param("idd") Integer idd);

    @Modifying
    @Transactional
    @Query(value="update test2entity set name=:newName where name=:oldName",nativeQuery = true)
    int getUpdated(@Param("newName") String newName,@Param("oldName") String oldName);

    @Query(value="select *From test2entity where country=:cn and name=:n",nativeQuery = true)
    List<Test2Entity> getNamedData(@Param("n") String name,  @Param("cn") String country);

    @Query(value="SELECT t.country FROM Test2Entity t")
    List<String> selectingJPQL();
}
