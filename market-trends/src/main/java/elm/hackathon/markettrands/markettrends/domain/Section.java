package elm.hackathon.markettrands.markettrends.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "section")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    @Id
    @Column(name = "section_cd", length = 10)
    private String sectionCd;

    @Column(name = "section_desc_ar", length = 1000, nullable = false)
    private String sectionDescAr;

    @Column(name = "section_desc_en", length = 1000, nullable = false)
    private String sectionDescEn;

}
