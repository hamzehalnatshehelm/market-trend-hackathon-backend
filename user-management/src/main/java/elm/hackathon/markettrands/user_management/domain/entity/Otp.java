package elm.hackathon.markettrands.user_management.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "otp")
@Data
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "otp_number")
    private String otpNumber;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "last_modification_date")
    private Date lastModifiedDate;
    @Column(name = "email")
    private String email;

    @PrePersist
    private void insertCreationAndLastModifiedDate() {
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
    }
    @PreUpdate
    private void updateLastModifiedDate() {
        this.lastModifiedDate = new Date();
    }
}
