package test;

import src.Patient;
import src.PriorityQueue;

import static org.junit.Assert.assertEquals;

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

    /**
     * test 2: Obtener el elemento de mayor prioridad
     */
    @Test
    public void testGetMostPriorityElement() {
        PriorityQueue<Patient> mPriorityQueue = new PriorityQueue<>();
        Patient patientA = new Patient();
        Patient patientB = new Patient();
        Patient patientC = new Patient();
        patientA.setName("Robert Smith");
        patientA.setSymptom("Stomachache");
        patientA.setPrecedence('D');
        mPriorityQueue.insert(patientA);
        patientB.setName("Joe Shmoe");
        patientB.setSymptom("headache");
        patientB.setPrecedence('C');
        mPriorityQueue.insert(patientB);
        patientC.setName("Marie Jordan");
        patientC.setSymptom("Signs of labor");
        patientC.setPrecedence('A');
        mPriorityQueue.insert(patientC);
        assertEquals(mPriorityQueue.pop(), patientC);
    }
}

