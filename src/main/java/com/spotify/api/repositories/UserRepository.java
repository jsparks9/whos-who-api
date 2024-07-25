package com.spotify.api.repositories;

import com.spotify.api.dtos.LeaderBoardRespDto;
import com.spotify.api.entitites.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCredentialsUsername(String username);

    Optional<User> findByCredentialsUsernameIgnoreCase(String username);

    @Query("""
            SELECT
            new com.spotify.api.dtos.LeaderBoardRespDto(
                u.credentials.username, u.profile.firstName, SUM(a.score)
            )
            FROM User u JOIN u.attempts a
            GROUP BY u
            ORDER BY SUM(a.score) DESC
           """)
    List<LeaderBoardRespDto> getTopScorers(Pageable pageable);
}
