package com.fbsis.eventtuar.rsvp.repository;

import com.fbsis.eventtuar.rsvp.domain.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends CrudRepository<user, Integer> {

    public Optional<user> findBypassword(String password);
}
