package com.fbsis.eventtuar.rsvp.repository;

import com.fbsis.eventtuar.rsvp.domain.invites;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface invitesRepository extends CrudRepository<invites, Integer> {

}
