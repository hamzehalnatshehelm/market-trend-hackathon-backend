package elm.hackathon.markettrands.markettrends.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor // Generates a constructor with no arguments
@AllArgsConstructor // Generates a constructor with all arguments
@Entity
@Table(name = "chapter")
public class Chapter implements Serializable {

    // --- Primary Key ---
    @Id
    @Column(name = "chapter_cd", length = 10, nullable = false)
    private String chapterCd;

    // --- Foreign Key Relationship ---
    // The 'section_cd' column acts as the foreign key.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_cd", referencedColumnName = "section_cd", nullable = false)
    private Section section; // This maps the FK column to the Section entity

    // --- Descriptive Columns ---
    @Column(name = "chapter_desc_ar", length = 1000, nullable = false)
    private String chapterDescAr;

    @Column(name = "chapter_desc_en", length = 1000, nullable = false)
    private String chapterDescEn;

    // NOTE: The 'section_cd' field itself is NOT declared directly
    // as a String/VARCHAR here, because it is represented by the
    // 'Section section' object defined above.

    @OneToMany(mappedBy = "chapter")
    private List<Tariff> tariffs;

}
