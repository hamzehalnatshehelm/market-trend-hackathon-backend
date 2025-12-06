package elm.hackathon.markettrands.markettrends.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChapterDto {

    private String id;
    private String label;
    private String chapterDescAr;
    private String chapterDescEn;
    private String level = "chapter";
    private List<TariffDto> children;

}