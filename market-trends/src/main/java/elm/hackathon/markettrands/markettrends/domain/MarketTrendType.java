package elm.hackathon.markettrands.markettrends.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(
        name = "market_trend_type",
        uniqueConstraints = {
                @UniqueConstraint(name = "pk_market_trend_type_id", columnNames = "id")
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MarketTrendType implements Serializable {

    @Id
    @Column(name = "id", length = 1)
    private String id;

    @Column(name = "type", length = 5, nullable = false, unique = true)
    private String type;

}
