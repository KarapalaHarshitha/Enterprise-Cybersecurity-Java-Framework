import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class CryptoEngine {
    
    public static String generateSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            System.err.println("[CRITICAL] Cryptographic Failure: " + e.getMessage());
            return null;
        }
    }
    
    public static boolean verifyIntegrity(SecurityPayload payload, String expectedSeal) {
        String currentDataHash = generateSHA256(payload.getRawData() + payload.getOriginIp());
        return currentDataHash != null && currentDataHash.equals(expectedSeal);
    }
}
