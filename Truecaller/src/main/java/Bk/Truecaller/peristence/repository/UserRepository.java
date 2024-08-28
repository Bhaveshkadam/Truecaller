package Bk.Truecaller.peristence.repository;

import Bk.Truecaller.peristence.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByMobileNumber(String mobileNumber);
}

