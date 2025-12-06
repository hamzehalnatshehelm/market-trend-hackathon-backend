package elm.hackathon.markettrands.markettrends.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(
        name = "port_type",
        uniqueConstraints = {
                @UniqueConstraint(name = "pk_port_type_id", columnNames = "id")
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PortType {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Port type name in English is required")
    @Size(max = 50, message = "Port type name in English must not exceed 50 characters")
    @Column(name = "name_en", nullable = false, length = 50, unique = true)
    private String nameEn;

    @NotBlank(message = "Port type name in Arabic is required")
    @Size(max = 80, message = "Port type name in Arabic must not exceed 80 characters")
    @Column(name = "name_ar", nullable = false, length = 80)
    private String nameAr;

    @OneToMany(mappedBy = "portType")
    private List<Port> ports;

}
