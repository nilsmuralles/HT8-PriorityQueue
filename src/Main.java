package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Reader reader = new Reader("pacientes.txt");
        boolean menu = true;

        while (menu) {
            System.out.println("---BIENVENIDO---");
            System.out.println("1. Abstract Data Type");
            System.out.println("2. Java Collection Frameworks");
            System.out.println("3. Salir");
            System.out.print("Seleccione la implementación de Priority Queue deseada: ");
        
            try {
                int op = input.nextInt();
                input.nextLine();

                switch (op) {
                    case 1:
                        PriorityQueue<Patient> pacientes = reader.fillQueue();
                        System.out.println("\nOrden en que se deben atender los pacientes");
                        for (int i = 0; i < pacientes.size(); i++) {
                            System.out.println(pacientes.pop().toString() + "\n");
                        }
                        break;
                    
                    case 2:
                        java.util.PriorityQueue<Patient> pacientesJCF = reader.fillQueueJCF();
                        System.out.println("\nOrden en que se deben atender los pacientes");
                        int length = pacientesJCF.size();
                        for (int i = 0; i < length; i++) {
                            System.out.println(pacientesJCF.poll().toString() + "\n");
                        }
                        break;

                    case 3:
                        menu = false;
                        break;

                    default:
                        break;
                }

            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("\nDebe seleccionar un número");
            }
        }
        input.close();
    }
}
