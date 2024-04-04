package test;

import src.Patient;
import src.PriorityQueue;
import org.junit.Test;

/**
 * @author Nils Muralles Morales
 * @since 03/04/24
 * @description Tests de la Priority Queue
 */
public class PriorityQueueTest {
    
    /**
     * test 1: Inserción funciona correctamente
     */
    @Test
    public void testInsertValue() {
        PriorityQueue<Patient> mPriorityQueue = new PriorityQueue<>();
        Patient patientA = new Patient();
        patientA.setName("Robert Smith");
        patientA.setSymptom("Stomachache");
        patientA.setPrecedence('D');
        mPriorityQueue.insert(patientA);
    }
}

