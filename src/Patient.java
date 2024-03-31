package src;

public class Patient implements Comparable<Patient> {
    String name;
    String symptom;
    Character precedence;

    /**
     * Devuelve el nombre del paciente
     * @return Nombre del paciente
     */
    public String getName() {
        return name;
    }

    /**
     * Actualiza el nombre del paciente
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el síntoma del paciente 
     * @return Síntoma del paciente
     */
    public String getSymptom() {
        return symptom;
    }

    /**
     * Actualiza el síntoma del paciente
     * @param symptom Síntoma del paciente
     */
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    /**
     * Devuelve la prioridad del paciente
     * @return Prioridad del paciente
     */
    public Character getPrecedence() {
        return precedence;
    }

    /**
     * Actualiza la prioridad del paciente
     * @param precedence
     */
    public void setPrecedence(Character precedence) {
        this.precedence = precedence;
    }

    /**
     * Método para comparar dos pacientes en función de su prioridad
     */
    @Override
    public int compareTo(Patient p2) {
        if (Character.compare(p2.getPrecedence(), this.precedence) >= 1) {
            return 1;
        } else if (Character.compare(p2.getPrecedence(), this.precedence) <= -1) {
            return -1;
        } else {
            return 0;
        }
    }
    
}