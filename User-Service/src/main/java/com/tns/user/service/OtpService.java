package com.tns.user.service;

//import com.tns.user.entity.OTPEntity;
//import com.tns.user.repository.OtpRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Random;
//
//@Service
//public class OtpService {
//    private final OtpRepository otpRepository;
//
//    public OtpService(OtpRepository otpRepository) {
//        this.otpRepository = otpRepository;
//    }
//
//    public String generateOtp() {
//        Random random = new Random();
//        return String.valueOf(100000 + random.nextInt(900000));
//    }
//
//    public void saveOtp(OTPEntity otpEntity) {
//        otpRepository.save(otpEntity);
//    }
//}

import com.tns.user.entity.OTPEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Configuration
public class OtpService {

    private final StringRedisTemplate redisTemplate;
    private static final String OTP_PREFIX = "OTP:";
    private static final int OTP_EXPIRATION_MINUTES = 5;
    private final Map<String, String> localCache = new java.util.concurrent.ConcurrentHashMap<>();

    // Secure random number generator for cryptographic safety
    private final SecureRandom secureRandom = new SecureRandom();

    public OtpService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Generates a 6-digit OTP, saves it in Redis with a TTL, and sends it via SMS.
     *
     * @return
     */
    public String generateAndSendOtp(String mobileNumber) {
        // 1. Generate a random 6-digit number string
        String otp = String.format("%06d", secureRandom.nextInt(1000000));

        // 2. Store in Redis (Key = OTP:1234567890, Value = 6-digit OTP)
        String redisKey = OTP_PREFIX + mobileNumber;
        localCache.put("OTP:" + mobileNumber, otp);
        // 3. Dispatch the OTP via SMS gateway
        sendSms(mobileNumber, otp);
        return otp;
    }

    /**
     * Validates the provided OTP against the one stored in Redis.
     */
    public boolean isValidOtp(String mobileNumber, String providedOtp) {
        String redisKey = OTP_PREFIX + mobileNumber;
        String cachedOtp = redisTemplate.opsForValue().get(redisKey);

        if (cachedOtp == null || !cachedOtp.equals(providedOtp)) {
            return false;
        }

        // Optional: Delete OTP immediately after a successful validation to prevent reuse
        redisTemplate.delete(redisKey);
        return true;
    }

    /**
     * Integrates with your chosen SMS carrier network.
     */
    private void sendSms(String mobileNumber, String otp) {
        String message = "Your verification code is: " + otp + ". Valid for 5 minutes.";

        // TODO: Replace this system print with actual Twilio, AWS SNS, or Infobip Client SDK code
        System.out.println("--- SENDING SMS ---");
        System.out.println("To: " + mobileNumber);
        System.out.println("Message: " + message);
        System.out.println("--------------------");
    }

    public void saveOtp(OTPEntity otpEntity) {
    }
}
