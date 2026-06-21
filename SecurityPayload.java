import java.time.Instant;

public class SecurityPayload {
    private final String transactionId;
    private final String rawData;
    private final String originIp;
    private final long timestamp;
    private String cryptographicSeal;

    public SecurityPayload(String transactionId, String rawData, String originIp) {
        this.transactionId = transactionId;
        this.rawData = rawData;
        this.originIp = originIp;
        this.timestamp = Instant.now().toEpochMilli();
        this.cryptographicSeal = "UNSEALED";
    }

    public String getTransactionId() { return transactionId; }
    public String getRawData() { return rawData; }
    public String getOriginIp() { return originIp; }
    public long getTimestamp() { return timestamp; }
    public String getCryptographicSeal() { return cryptographicSeal; }
    public void setCryptographicSeal(String seal) { this.cryptographicSeal = seal; }
}

