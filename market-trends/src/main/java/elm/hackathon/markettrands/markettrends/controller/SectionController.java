package elm.hackathon.markettrands.markettrends.controller;

import elm.hackathon.markettrands.markettrends.domain.dto.SectionDto;
import elm.hackathon.markettrands.markettrends.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/section")
public class SectionController {

    private final SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<SectionDto>> findAll() {
        return ResponseEntity.ok(sectionService.findAll());
    }

}
