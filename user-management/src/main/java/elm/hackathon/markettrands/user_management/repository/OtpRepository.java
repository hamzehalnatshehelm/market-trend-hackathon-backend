package elm.hackathon.markettrands.user_management.repository;

import elm.hackathon.markettrands.user_management.domain.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    Optional<Otp> findFirstByUserIdOrderByCreationDateDesc(int userId);

    Optional<Otp> findFirstByEmailOrderByCreationDateDesc(String email);
}
