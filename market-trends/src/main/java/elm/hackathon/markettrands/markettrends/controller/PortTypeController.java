package elm.hackathon.markettrands.markettrends.controller;

import elm.hackathon.markettrands.markettrends.domain.dto.BaseResponse;
import elm.hackathon.markettrands.markettrends.domain.dto.PortTypeDto;
import elm.hackathon.markettrands.markettrends.service.PortTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/port-types")
public class PortTypeController {

    private final PortTypeService portTypeService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<PortTypeDto>>> findAll() {
        return ResponseEntity.ok(new BaseResponse<>(portTypeService.findAll()));
    }

}
