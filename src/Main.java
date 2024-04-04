package src;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Patient> pacientes = new PriorityQueue<Patient>();
        Patient p1 = new Patient();
        Patient p2 = new Patient();
        Patient p3 = new Patient();
        Patient p4 = new Patient();
        Patient p5 = new Patient();
        p1.setPrecedence('A');
        p2.setPrecedence('C');
        p3.setPrecedence('B');
        p4.setPrecedence('D');
        p5.setPrecedence('A');
        pacientes.insert(p1);
        pacientes.insert(p2);
        pacientes.insert(p3);
        pacientes.insert(p4);
        pacientes.insert(p5);
    }
}
