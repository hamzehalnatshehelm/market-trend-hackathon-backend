package elm.hackathon.markettrands.client;

import elm.hackathon.markettrands.domain.dto.client.request.CustomerRequestDTO;
import elm.hackathon.markettrands.domain.dto.client.request.PaymentCreationRequestDto;
import elm.hackathon.markettrands.domain.dto.client.response.InquiryResponseDTO;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentCreationResponseDto;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentInquiryResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(   name="ELMPAY-API" ,
                url= "${feign.client.payment.url}",
                configuration = ElmPayApiClientConfig.class)
public interface ElmPayApiClient {
    @PostMapping(value = "/payment/api/product/createpaymentrequest",
            consumes = "application/json",
            produces = "application/json"
    )
    PaymentCreationResponseDto createPayment(@RequestBody PaymentCreationRequestDto declarationNumber);

    @PostMapping(value = "/payment/api/product/inquirepaymentrequest")
    PaymentInquiryResponseDto paymentInquiry(@RequestBody String declarationNumber);

}
