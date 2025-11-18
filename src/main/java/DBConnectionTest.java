import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBConnectionTest {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ParkingLotPU");
            EntityManager em = emf.createEntityManager();
            System.out.println("✅ Connected successfully to MySQL database!");
            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
