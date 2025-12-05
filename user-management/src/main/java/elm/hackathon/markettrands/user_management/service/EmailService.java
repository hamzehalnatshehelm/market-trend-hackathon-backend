package elm.hackathon.markettrands.user_management.service;

public interface EmailService {

    void sendOtpEmail(String to, String otp);
}
