package elm.hackathon.markettrands.user_management.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "app_user")
@Data
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "otp_number")
    private String otpNumber;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "last_modification_date")
    private Date lastModifiedDate;
}
