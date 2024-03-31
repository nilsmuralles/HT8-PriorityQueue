package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.Patient;

public class PatientTest {
 
    @Test
    public void testCompareTwoPatients() {
        Patient criticalPatient = new Patient();
        criticalPatient.setPrecedence('A');
        Patient stablePatient = new Patient();
        stablePatient.setPrecedence('E');
        Patient randomPatient = new Patient();
        randomPatient.setPrecedence('E');
        assertEquals(criticalPatient.compareTo(stablePatient), 1);
        assertEquals(stablePatient.compareTo(criticalPatient), -1);
        assertEquals(stablePatient.compareTo(randomPatient), 0);
    }
}
