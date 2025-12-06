package elm.hackathon.markettrands.markettrends.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Getter
@Builder
@Table(name = "port")
@NoArgsConstructor
@AllArgsConstructor
public class Port implements Serializable {

    // --- Primary Key ---
    @Id
    @Column(name = "port_code", length = 6, nullable = false)
    private String portCode;

    // --- Descriptive Columns ---
    @Column(name = "code_desc_ar", length = 140, nullable = false)
    private String codeDescAr;

    @Column(name = "code_desc_en", length = 140, nullable = false)
    private String codeDescEn;

    // --- Foreign Key Relationship (fk_port_type_id) ---

    // 1. The Relationship Object (Recommended JPA approach)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "fk_port_type_id",
            referencedColumnName = "id", // References the 'id' column in the PortType table
            nullable = false,
            insertable = false, // Prevents Hibernate from updating the FK column via the relationship object
            updatable = false   // Prevents Hibernate from updating the FK column via the relationship object
    )
    private PortType portType;

}
