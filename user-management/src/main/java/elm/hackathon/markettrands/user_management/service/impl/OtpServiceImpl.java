package elm.hackathon.markettrands.user_management.service.impl;

import elm.hackathon.markettrands.user_management.domain.entity.AppUser;
import elm.hackathon.markettrands.user_management.domain.entity.Otp;
import elm.hackathon.markettrands.user_management.general.exception.schema.response.BusinessException;
import elm.hackathon.markettrands.user_management.repository.OtpRepository;
import elm.hackathon.markettrands.user_management.repository.UserRepository;
import elm.hackathon.markettrands.user_management.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {
    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();
    private final OtpRepository otpRepository;
    private final UserRepository userRepository;

    public String generateOtp(String email) {
        Optional<AppUser> appUserOptional = userRepository.findByEmail(email);
        String otpNumber = String.valueOf(new Random().nextInt(999999));
        Otp otp = new Otp();
        if(appUserOptional.isPresent()) {
            otp.setUserId(appUserOptional.get().getId());
        }
        otp.setEmail(email);
        otp.setOtpNumber(otpNumber);
        otpRepository.save(otp);
//        otpStorage.put(email, otp);
        return otpNumber;
    }

    public boolean validateOtp(String email, String otp) {
        Optional<AppUser> appUserOptional = userRepository.findByEmail(email);
        if(!appUserOptional.isEmpty()) {
            AppUser appUser = appUserOptional.get();
            Optional<Otp> byUserIdAndOtpNumberOrderByCreationDateDesc = otpRepository.findFirstByUserIdOrderByCreationDateDesc(appUser.getId().intValue());
            if (byUserIdAndOtpNumberOrderByCreationDateDesc.isEmpty() || !byUserIdAndOtpNumberOrderByCreationDateDesc.get().getOtpNumber().equals(otp)) {
                return false;
            }
        }else{
            Optional<Otp> firstByEmailOrderByCreationDateDesc = otpRepository.findFirstByEmailOrderByCreationDateDesc(email);
            if (firstByEmailOrderByCreationDateDesc.isEmpty() || !firstByEmailOrderByCreationDateDesc.get().getOtpNumber().equals(otp)) {
                return false;
            }
        }
        return true;
    }
}
