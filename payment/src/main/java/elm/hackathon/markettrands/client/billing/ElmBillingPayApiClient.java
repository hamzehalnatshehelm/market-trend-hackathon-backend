package elm.hackathon.markettrands.client.billing;

import elm.hackathon.markettrands.domain.dto.client.request.CustomerRequestDTO;
import elm.hackathon.markettrands.domain.dto.client.request.PaymentCreationRequestDto;
import elm.hackathon.markettrands.domain.dto.client.response.InquiryResponseDTO;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentCreationResponseDto;
import elm.hackathon.markettrands.domain.dto.client.response.PaymentInquiryResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(   name="ELBillingMPAY-API" ,
                url= "${feign.client.billing.url}",
                configuration = ElmBillingPayApiClientConfig.class)
public interface ElmBillingPayApiClient {

    @PostMapping(value = "/billing/v3/api/invoice/generateinvoicewithcustomer")
    InquiryResponseDTO createInvoice(@RequestBody CustomerRequestDTO customerRequestDTO);
}
