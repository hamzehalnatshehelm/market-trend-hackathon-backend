package elm.hackathon.markettrands.service.impl;

import elm.hackathon.markettrands.client.ElmPayApiClient;
import elm.hackathon.markettrands.domain.dto.client.request.CustomerRequestDTO;
import elm.hackathon.markettrands.domain.dto.client.request.PaymentCreationRequestDto;
import elm.hackathon.markettrands.domain.dto.client.response.InquiryResponseDTO;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentCreationResponseDto;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentInquiryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final ElmPayApiClient elmPayApiClient;

    public PaymentCreationResponseDto createInvoice(CustomerRequestDTO customerRequestDTO) {
        InquiryResponseDTO invoice = elmPayApiClient.createInvoice(customerRequestDTO);
        PaymentCreationRequestDto paymentCreationRequestDto = new PaymentCreationRequestDto();
        paymentCreationRequestDto.setInvoiceNumber(invoice.getBody().getData().getResult().getSadadNumber());
        paymentCreationRequestDto.setAccountNumber(invoice.getBody().getData().getResult().getAccountNumber());
        paymentCreationRequestDto.setOperation("pay");
        paymentCreationRequestDto.setRedirectUrl("");
        paymentCreationRequestDto.setTransactionType(1);
        paymentCreationRequestDto.setPaymentMethods("MASTER,VISA,MADA,APPLEPAY");
        paymentCreationRequestDto.setLanguage("en");
        paymentCreationRequestDto.setTimeStamp(LocalDateTime.now());
        PaymentCreationResponseDto payment = elmPayApiClient.createPayment(paymentCreationRequestDto);
        return payment;
    }

    public PaymentInquiryResponseDto inquiryInvoice(String paymentRequestId) {
        return elmPayApiClient.paymentInquiry(paymentRequestId);
    }

}
