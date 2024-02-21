package net.penguincoders.splitwise.dataaccess.repository;

import net.penguincoders.splitwise.dataaccess.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    @Query(value = "select * from User", nativeQuery = true)
    List<UsersEntity> getAllUsers();
}
