package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private File file;

    /**
     * Constructor de clase
     * @param fileName Nombre del archivo a leer
     */
    Reader(String fileName) {
        file = new File(fileName);
    }

    public PriorityQueue<Patient> fillQueue() {
        PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
        
            String line;
            while ((line = br.readLine()) != null) {
                Patient newPatient = new Patient();
                String[] data = line.split(",");
                newPatient.setName(data[0]);
                newPatient.setSymptom(data[1]);
                newPatient.setPrecedence(data[2].charAt(0));
                pQueue.insert(newPatient);
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return pQueue;
    }

}
