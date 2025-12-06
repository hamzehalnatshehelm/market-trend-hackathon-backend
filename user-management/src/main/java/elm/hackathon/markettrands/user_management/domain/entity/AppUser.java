package elm.hackathon.markettrands.user_management.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "app_user")
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "last_modification_date")
    private Date lastModifiedDate;

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
