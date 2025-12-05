package elm.hackathon.markettrands.user_management.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

// User entity (simplified, only email)
@Entity
@Table(name = "user")
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "last_modification_date")
    private Date lastModifiedDate;
}
