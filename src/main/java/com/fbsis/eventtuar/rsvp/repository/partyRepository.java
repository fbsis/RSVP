package com.fbsis.eventtuar.rsvp.repository;

import com.fbsis.eventtuar.rsvp.domain.party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface partyRepository extends CrudRepository<party, Integer> {

}
