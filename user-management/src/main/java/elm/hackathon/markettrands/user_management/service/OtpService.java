package elm.hackathon.markettrands.user_management.service;

import java.util.Random;

public interface OtpService {

    String generateOtp(String email);

    boolean validateOtp(String email, String otp);
}
