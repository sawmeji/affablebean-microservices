package com.example.apisecurity.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    @Query("""
select u.* from user u inner join token t on u.id=t.user 
where u.id=:userId and t.refresh_token=:refreshToken and t.expired_at>=:expiredAt 
""")
    Optional<User> findByIdAndTokensRefreshToken(Long userId, String refreshToken, LocalDateTime expiredAt);

}
