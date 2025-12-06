package elm.hackathon.markettrands.markettrends.domain;

import elm.hackathon.markettrands.markettrends.enums.MarketTrendsDirection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "market_trends")
public class MarketTrends implements Serializable {

    // --- Primary Key ---
    // SERIAL maps to SEQUENCE, so we use IDENTITY for PostgreSQL SERIAL primary keys.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Core Data Columns ---
    @Column(name = "month", nullable = false)
    private LocalDate month;

    @Enumerated(EnumType.STRING)
    @Column(name = "direction", length = 50)
    private MarketTrendsDirection direction;

    @Column(name = "type_id", length = 1, nullable = false)
    private String typeId;

    @Column(name = "hrmnzd_code", length = 16, nullable = false)
    private String hrmnzdCode;

    @Column(name = "item_desc_ar", length = 3000)
    private String itemDescAr;

    @Column(name = "item_desc_en", length = 1000)
    private String itemDescEn;

    @Column(name = "eff_date", nullable = false)
    private LocalDate effDate;

    // --- Foreign Key Relationships (Mapped to Entities) ---

    // 1. fk_port_type_id (NUMERIC(9) -> BigDecimal/Long)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_port_type_id", referencedColumnName = "id", nullable = false)
    private PortType portType;

    // 2. fk_port_id (VARCHAR(10))
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_port_id", referencedColumnName = "port_code", nullable = false)
    private Port port;

    // 3. fk_section_id (VARCHAR(10))
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_section_id", referencedColumnName = "section_cd", nullable = false)
    private Section section;

    // 4. fk_chapter_cd_id (VARCHAR(10))
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_chapter_cd_id", referencedColumnName = "chapter_cd", nullable = false)
    private Chapter chapter;

    // 5. fk_tariff_id (NUMERIC(9) -> BigDecimal/Long)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_tariff_id", referencedColumnName = "sk", nullable = false)
    private Tariff tariff;


    // --- Numeric/Statistical Columns ---
    // NUMERIC without precision is typically BigDecimal in Java for full precision.
    // The CHECK constraints (imp_count >= 0) are handled at the database level,
    // not directly mappable via JPA annotations, but the type is BigDecimal.
    @Column(name = "imp_count")
    private BigDecimal impCount;

    @Column(name = "dec_count")
    private BigDecimal decCount;

    @Column(name = "item_count")
    private BigDecimal itemCount;

    @Column(name = "qty")
    private BigDecimal qty;

    @Column(name = "gross_weight")
    private BigDecimal grossWeight;

    @Column(name = "net_weight")
    private BigDecimal netWeight;

    @Column(name = "cif_val")
    private BigDecimal cifVal;

    @Column(name = "orig_duty")
    private BigDecimal origDuty;

    @Column(name = "cif_val_per_qty")
    private BigDecimal cifValPerQty;

    @Column(name = "orig_duty_per_qty")
    private BigDecimal origDutyPerQty;

    @Column(name = "cost_per_qty")
    private BigDecimal costPerQty;


    // --- Denormalized/Description Columns ---
    @Column(name = "port_type_name_en", length = 1000)
    private String portTypeNameEn;

    @Column(name = "port_type_name_ar", length = 1000)
    private String portTypeNameAr;

    @Column(name = "port_code", length = 1000)
    private String portCode;

    @Column(name = "codedesc", length = 1000)
    private String codeDesc; // Renamed to follow Java convention (camelCase)

    @Column(name = "engcodedesc", length = 1000)
    private String engCodeDesc; // Renamed to follow Java convention

    @Column(name = "section_arbc_desc", length = 1000)
    private String sectionArbcDesc;

    @Column(name = "section_eng_desc", length = 1000)
    private String sectionEngDesc;

    @Column(name = "chapter_arbc_desc", length = 1000)
    private String chapterArbcDesc;

    @Column(name = "chapter_eng_desc", length = 1000)
    private String chapterEngDesc;

}
