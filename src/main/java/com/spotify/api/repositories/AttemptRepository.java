package com.spotify.api.repositories;

import com.spotify.api.entitites.Attempt;
import com.spotify.api.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    List<Attempt> findAllByUserOrderByTakenDesc(User user);
}
