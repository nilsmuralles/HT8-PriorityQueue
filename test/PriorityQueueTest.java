package test;

import src.Patient;
import src.PriorityQueue;

import org.junit.Test;

public class PriorityQueueTest {
    
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
