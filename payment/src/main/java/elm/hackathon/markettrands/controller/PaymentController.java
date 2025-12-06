package elm.hackathon.markettrands.controller;

import elm.hackathon.markettrands.domain.dto.client.request.CustomerRequestDTO;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentCreationResponseDto;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentInquiryResponseDto;
import elm.hackathon.markettrands.service.impl.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create-invoice")
    public ResponseEntity<PaymentCreationResponseDto> createInvoice(@RequestBody CustomerRequestDTO requestDTO) {
        return ResponseEntity.ok(paymentService.createInvoice(requestDTO));
    }

    @GetMapping("/inquiry-invoice/{paymentRequestId}")
    public ResponseEntity<PaymentInquiryResponseDto> inquiryInvoice(@PathVariable String paymentRequestId) {
        return ResponseEntity.ok(paymentService.inquiryInvoice(paymentRequestId));
    }
}
