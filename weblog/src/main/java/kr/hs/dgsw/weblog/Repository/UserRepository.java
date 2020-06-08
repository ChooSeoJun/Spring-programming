package kr.hs.dgsw.weblog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.hs.dgsw.weblog.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByAccount(String account);
}