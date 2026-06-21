
import java.util.Scanner;

public class EnterpriseSecuritySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===============================================================");
        System.out.println("   INITIALIZING INDUSTRIAL CYBERSECURITY MANAGEMENT PLATFORM   ");
        System.out.println("   DEVELOPED VIA ADVANCED BLUEJ DEVELOPMENT ARCHITECTURE       ");
        System.out.println("===============================================================");
        
        // Ingesting Simulated Stream
        System.out.print("\n[CONFIG] Define Packet Transaction Reference ID: ");
        String txId = scanner.nextLine();
        
        System.out.print("[CONFIG] Specify Source IP Vector (e.g. 192.168.1.1): ");
        String sourceIp = scanner.nextLine();
        
        System.out.print("[INGEST] Enter secure payload message string: ");
        String dataContent = scanner.nextLine();
        
        // Instantiating Payload Model
        SecurityPayload dynamicPacket = new SecurityPayload(txId, dataContent, sourceIp);
        
        System.out.println("\n[SYSTEM] Deploying Multi-Threaded Ingestion Filter Engine...");
        NetworkInspector inspectorTask = new NetworkInspector(dynamicPacket);
        Thread parallelWorker = new Thread(inspectorTask);
        
        // Spawning background verification thread
        parallelWorker.start();
        
        try {
            parallelWorker.join(); // Wait for security operations to finalize safely
        } catch (InterruptedException e) {
            System.err.println("[CRITICAL] System Orchestration Interrupted.");
        }
        
        System.out.println("\n===============================================================");
        System.out.println("   ENGINE CYCLE SHUTDOWN: ARCHITECTURE VALIDATION COMPLETE   ");
        System.out.println("===============================================================");
        scanner.close();
    }
}
