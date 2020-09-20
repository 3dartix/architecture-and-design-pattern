package ru.geekbrains.atm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geekbrains.atm.entity.User;

import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {
    //JPA альтернатива мепперу и identity map
    @Query("SELECT u FROM User u WHERE u.pin = :pin and u.cardCode = :cardCode")
    Optional<User> findUserBy(@Param("cardCode")String cardCode, @Param("pin")Long pin);
}
