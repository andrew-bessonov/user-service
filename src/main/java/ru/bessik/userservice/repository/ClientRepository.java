package ru.bessik.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bessik.userservice.entity.User;

@Repository
public interface ClientRepository extends CrudRepository<User, Long> {
}
