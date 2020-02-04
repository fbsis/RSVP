package com.fbsis.eventtuar.rsvp.repository;

import com.fbsis.eventtuar.rsvp.domain.invites;
import com.fbsis.eventtuar.rsvp.domain.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface invitesRepository extends CrudRepository<invites, Integer> {

    @Query(value = "SELECT\n" +
            "  invites.*\n" +
            "FROM\n" +
            "  invites\n" +
            "  INNER JOIN party_invites ON invites.id = party_invites.invites_id\n" +
            "WHERE\n" +
            "  party_invites.party_id = ?1 AND invites.id = ?2", nativeQuery = true)
    public Optional<invites> findInviteUsingPartyId(Integer partyId, Integer InviteId);
}
