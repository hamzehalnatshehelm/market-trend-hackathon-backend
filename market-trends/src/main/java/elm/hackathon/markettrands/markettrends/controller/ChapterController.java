package elm.hackathon.markettrands.markettrends.controller;

import elm.hackathon.markettrands.markettrends.domain.dto.BaseResponse;
import elm.hackathon.markettrands.markettrends.domain.dto.ChapterDto;
import elm.hackathon.markettrands.markettrends.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/chapters")
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping("/sections/{sectionCode}")
    public ResponseEntity<BaseResponse<List<ChapterDto>>> findAllBySectionCode(@PathVariable String sectionCode) {
        return ResponseEntity.ok(new BaseResponse<>(chapterService.findAllBySectionCode(sectionCode)));
    }

}
