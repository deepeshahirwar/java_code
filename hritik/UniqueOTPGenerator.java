
import java.util.HashSet;
import java.util.Random;

class UniqueOTPGenerator { 
    // this our main function
    public static void main(String[] args) {
        HashSet<Integer> otpSet = new HashSet<>(); 
        Random rand = new Random(); 

        // for generate 10 unique OTPs
        while (otpSet.size() < 10) {
            int otp = generateSixDigitOTP(rand); 
            otpSet.add(otp); 
        }

        System.out.println("Unique OTPs generated: " + otpSet);
    }

    // method  for  generate a six-digit OTP
    public static int generateSixDigitOTP(Random rand) {
        return 100000 + rand.nextInt(900000); 
    }
}