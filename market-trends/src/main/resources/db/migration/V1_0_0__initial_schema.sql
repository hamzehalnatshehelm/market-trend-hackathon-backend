-- ============================================================================
-- PORT_TYPE TABLE (Parent table - no dependencies)
-- ============================================================================
CREATE TABLE port_type
(
    id      NUMERIC(9),
    name_en VARCHAR(50) NOT NULL UNIQUE,
    name_ar VARCHAR(80) NOT NULL,

    CONSTRAINT pk_port_type_id PRIMARY KEY (id)
);

-- ============================================================================
-- TYPE TABLE (Parent table - no dependencies)
-- ============================================================================
CREATE TABLE market_trend_type
(
    id   VARCHAR(1) PRIMARY KEY,
    type VARCHAR(5) NOT NULL UNIQUE
);

-- ============================================================================
-- SECTION TABLE (Parent table - no dependencies)
-- ============================================================================
CREATE TABLE section
(
    section_cd      VARCHAR(10) PRIMARY KEY,
    section_desc_ar VARCHAR(1000) NOT NULL,
    section_desc_en VARCHAR(1000) NOT NULL
);

-- ============================================================================
-- PORT TABLE (References port_type)
-- ============================================================================
CREATE TABLE port
(
    port_code       VARCHAR(6)   NOT NULL,
    code_desc_ar    VARCHAR(140) NOT NULL,
    code_desc_en    VARCHAR(140) NOT NULL,
    fk_port_type_id NUMERIC(9)   NOT NULL,

    CONSTRAINT pk_port_port_code PRIMARY KEY (port_code),

    CONSTRAINT fk_port_port_type_id
        FOREIGN KEY (fk_port_type_id)
            REFERENCES port_type (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

-- ============================================================================
-- CHAPTER TABLE (References section)
-- ============================================================================
CREATE TABLE chapter
(
    section_cd      VARCHAR(10)   NOT NULL,
    chapter_cd      VARCHAR(10)   NOT NULL,
    chapter_desc_ar VARCHAR(1000) NOT NULL,
    chapter_desc_en VARCHAR(1000) NOT NULL,

    CONSTRAINT pk_chapter PRIMARY KEY (chapter_cd),

    CONSTRAINT fk_chapter_section
        FOREIGN KEY (section_cd)
            REFERENCES section (section_cd)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

-- ============================================================================
-- TARIFF TABLE (References section and chapter)
-- ============================================================================
-- ============================================================================
CREATE TABLE tariff
(
    sk           NUMERIC(9) PRIMARY KEY,
    section_cd   VARCHAR(10)   NOT NULL,
    chapter_cd   VARCHAR(10)   NOT NULL,
    hrmnzd_code  VARCHAR(16)   NOT NULL,
    eff_date     DATE          NOT NULL,
    item_desc_ar VARCHAR(3000) NOT NULL,
    item_desc_en VARCHAR(1000),

    CONSTRAINT fk_tariff_section
        FOREIGN KEY (section_cd)
            REFERENCES section (section_cd)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_tariff_chapter
        FOREIGN KEY (chapter_cd)
            REFERENCES chapter (chapter_cd)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

-- ============================================================================
-- MARKET_TRENDS TABLE (Main fact table - references market_trends dimension tables)
-- ============================================================================
CREATE TABLE market_trends
(
    id                SERIAL PRIMARY KEY, -- Auto-increment surrogate key
    month             DATE        NOT NULL,
    direction         VARCHAR(50),
    type_id           VARCHAR(1)  NOT NULL,
    fk_port_type_id   NUMERIC(9)  NOT NULL,
    fk_port_id        VARCHAR(9)  NOT NULL,
    fk_section_id     VARCHAR(10) NOT NULL,
    fk_chapter_cd_id  VARCHAR(10) NOT NULL,
    hrmnzd_code       VARCHAR(16) NOT NULL,
    item_desc_ar      VARCHAR(3000),
    item_desc_en      VARCHAR(1000),
    eff_date          DATE        NOT NULL,
    fk_tariff_id      NUMERIC(9)  NOT NULL,
    imp_count         NUMERIC CHECK (imp_count >= 0),
    dec_count         NUMERIC CHECK (dec_count >= 0),
    item_count        NUMERIC CHECK (item_count >= 0),
    qty               NUMERIC CHECK (qty >= 0),
    gross_weight      NUMERIC CHECK (gross_weight >= 0),
    net_weight        NUMERIC CHECK (net_weight >= 0),
    cif_val           NUMERIC CHECK (cif_val >= 0),
    orig_duty         NUMERIC CHECK (orig_duty >= 0),
    cif_val_per_qty   NUMERIC,
    orig_duty_per_qty NUMERIC,
    cost_per_qty      NUMERIC,

    port_type_name_en VARCHAR(1000),
    port_type_name_ar VARCHAR(1000),
    codedesc          VARCHAR(1000),
    engcodedesc       VARCHAR(1000),
    section_arbc_desc VARCHAR(1000),
    section_eng_desc  VARCHAR(1000),
    chapter_arbc_desc VARCHAR(1000),
    chapter_eng_desc  VARCHAR(1000),

    CONSTRAINT fk_market_trends_port_type
        FOREIGN KEY (fk_port_type_id)
            REFERENCES port_type (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_market_trends_port
        FOREIGN KEY (fk_port_id)
            REFERENCES port (port_code)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_market_trends_section
        FOREIGN KEY (fk_section_id)
            REFERENCES section (section_cd)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_market_trends_chapter
        FOREIGN KEY (fk_chapter_cd_id)
            REFERENCES chapter (chapter_cd)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_market_trends_tariff
        FOREIGN KEY (fk_tariff_id)
            REFERENCES tariff (sk)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT chk_net_weight_le_gross
        CHECK (net_weight <= gross_weight)
);

-- ============================================================================
-- INDEXES FOR PERFORMANCE
-- ============================================================================

-- Indexes on market_trends (main query table)
CREATE INDEX idx_market_trends_month ON market_trends (month);
CREATE INDEX idx_market_trends_type_id ON market_trends (type_id);
CREATE INDEX idx_market_trends_port_type ON market_trends (fk_port_type_id);
CREATE INDEX idx_market_trends_section_cd ON market_trends (fk_section_id);
CREATE INDEX idx_market_trends_chapter_cd ON market_trends (fk_chapter_cd_id);
-- CREATE INDEX idx_market_trends_hrmnzd_code ON market_trends (hrmnzd_code);
CREATE INDEX idx_market_trends_tariff_id ON market_trends (fk_tariff_id);
CREATE INDEX idx_market_trends_eff_date ON market_trends (eff_date);

-- Composite indexes for common queries
CREATE INDEX idx_market_trends_month_type ON market_trends (month, type_id);
-- CREATE INDEX idx_market_trends_port_month ON market_trends (port_code, month);
CREATE INDEX idx_market_trends_section_chapter ON market_trends (fk_section_id, fk_chapter_cd_id);

-- Indexes on lookup tables
CREATE INDEX idx_chapter_section ON chapter (section_cd);
CREATE INDEX idx_tariff_section ON tariff (section_cd);
CREATE INDEX idx_tariff_chapter ON tariff (chapter_cd);
CREATE INDEX idx_tariff_hrmnzd ON tariff (hrmnzd_code);
CREATE INDEX idx_port_type ON port (fk_port_type_id);

-- ============================================================================
-- COMMENTS (Documentation)
-- ============================================================================

COMMENT
ON TABLE market_trends IS 'Main fact table containing market_trends hackathon trade data';
COMMENT
ON TABLE port IS 'Dimension table for port information';
COMMENT
ON TABLE port_type IS 'Dimension table for port types';
COMMENT
ON TABLE section IS 'Dimension table for HS code sections';
COMMENT
ON TABLE chapter IS 'Dimension table for HS code chapters';
COMMENT
ON TABLE tariff IS 'Dimension table for tariff items with surrogate key';

COMMENT
ON COLUMN market_trends.month IS 'Trade transaction month';
COMMENT
ON COLUMN market_trends.type_id IS 'Foreign key to type.id';
COMMENT
ON COLUMN market_trends.fk_port_type_id IS 'Foreign key to port_type.id';
COMMENT
ON COLUMN market_trends.fk_tariff_id IS 'Foreign key to tariff.sk (surrogate key)';
COMMENT
ON COLUMN market_trends.cif_val IS 'CIF (Cost, Insurance, Freight) value';
COMMENT
ON COLUMN market_trends.orig_duty IS 'Original duty amount';
COMMENT
ON COLUMN market_trends.hrmnzd_code IS 'Harmonized System code';

COMMENT
ON COLUMN tariff.sk IS 'Surrogate key for tariff table';
COMMENT
ON COLUMN tariff.hrmnzd_code IS 'Harmonized System code (natural key)';
COMMENT
ON COLUMN port_type.id IS 'Numeric identifier for port type';
