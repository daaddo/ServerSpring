package it.cascella.redisBridge.repository;

import it.cascella.redisBridge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndPassword(String name, String password);
}