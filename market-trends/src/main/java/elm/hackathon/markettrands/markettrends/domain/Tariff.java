package elm.hackathon.markettrands.markettrends.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter // Generates Getters, Setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a constructor with no arguments
@AllArgsConstructor // Generates a constructor with all arguments
@Entity
@Table(name = "tariff")
public class Tariff {

    // --- Primary Key ---
    // NUMERIC(9) is best mapped to BigDecimal in Java for precise numeric types,
    // though Long could also be used if it's strictly an integer ID.
    @Id
    @Column(name = "sk", precision = 9, scale = 0)
    private BigDecimal sk;

    // --- Foreign Key Relationship 1: Section ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "section_cd",
            referencedColumnName = "section_cd",
            nullable = false,
            insertable = false, // Prevents JPA from trying to insert this value directly
            updatable = false   // Prevents JPA from trying to update this value directly
    )
    private Section section;

    // --- Foreign Key Relationship 2: Chapter ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "chapter_cd",
            referencedColumnName = "chapter_cd",
            nullable = false,
            insertable = false, // Prevents JPA from trying to insert this value directly
            updatable = false   // Prevents JPA from trying to update this value directly
    )
    private Chapter chapter;

    // Explicit FK column declaration
    @Column(name = "chapter_cd", length = 10, nullable = false)
    private String chapterCd;


    // --- Other Columns ---
    @Column(name = "hrmnzd_code", length = 16, nullable = false)
    private String hrmnzdCode;

    @Column(name = "eff_date", nullable = false)
    private LocalDate effDate; // DATE type in SQL maps well to LocalDate in Java

    @Column(name = "item_desc_ar", length = 3000, nullable = false)
    private String itemDescAr;

    @Column(name = "item_desc_en", length = 1000)
    private String itemDescEn;

}
