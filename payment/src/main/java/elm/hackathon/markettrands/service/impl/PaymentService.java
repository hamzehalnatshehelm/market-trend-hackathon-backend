package elm.hackathon.markettrands.service.impl;

import elm.hackathon.markettrands.domain.dto.client.request.CustomerRequestDTO;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentCreationResponseDto;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentInquiryResponseDto;

public interface PaymentService {
    PaymentCreationResponseDto createInvoice(CustomerRequestDTO customerRequestDTO);
    PaymentInquiryResponseDto inquiryInvoice(String paymentRequestId);
}
