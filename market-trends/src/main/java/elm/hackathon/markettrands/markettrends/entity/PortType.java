package elm.hackathon.markettrands.markettrends.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(
        name = "port_type",
        uniqueConstraints = {
                @UniqueConstraint(name = "pk_port_type_id", columnNames = "id")
        }
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PortType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Port type name in English is required")
    @Size(max = 50, message = "Port type name in English must not exceed 50 characters")
    @Column(name = "port_type_name_en", nullable = false, length = 50, unique = true)
    private String portTypeNameEn;

    @NotBlank(message = "Port type name in Arabic is required")
    @Size(max = 80, message = "Port type name in Arabic must not exceed 80 characters")
    @Column(name = "port_type_name_ar", nullable = false, length = 80)
    private String portTypeNameAr;

}
