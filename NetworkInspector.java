
public class NetworkInspector implements Runnable {
    private final SecurityPayload payload;
    private static final String[] BLACKLISTED_NETWORKS = {"192.168.1.99", "10.0.4.50", "185.220.101.1"};

    public NetworkInspector(SecurityPayload payload) {
        this.payload = payload;
    }

    @Override
    public void run() {
        System.out.println("\n[THREAD - " + Thread.currentThread().getId() + "] Intercepting Packet ID: " + payload.getTransactionId());
        
        try {
            // Simulate deep packet inspection delay
            Thread.sleep(800); 
            
            // Firewall Rule Check
            boolean isMalicious = false;
            for (String blockedIp : BLACKLISTED_NETWORKS) {
                if (payload.getOriginIp().equals(blockedIp)) {
                    isMalicious = true;
                    break;
                }
            }
            
            if (isMalicious) {
                System.out.println(">>> [ALERT - SECURITY BREACH] Drop Connection! Malicious Origin Blocked: " + payload.getOriginIp());
                return;
            }

            // Cryptographic Ingestion Integration
            String seal = CryptoEngine.generateSHA256(payload.getRawData() + payload.getOriginIp());
            payload.setCryptographicSeal(seal);
            
            System.out.println(">>> [SUCCESS] Packet " + payload.getTransactionId() + " Inspected & Signed.");
            System.out.println(">>> Digital Fingerprint [SHA-256]: " + seal);
            
        } catch (InterruptedException e) {
            System.err.println("[ERROR] Thread Inspection Interrupted: " + e.getMessage());
        }
    }
}

