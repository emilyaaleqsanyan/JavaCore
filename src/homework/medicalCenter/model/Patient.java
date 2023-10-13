package homework.medicalCenter.model;

import java.util.Objects;

public class Patient extends Person {
    private Doctor doctor;
    private String registerDate;


    public Patient(String id, String name, String surname, String phone, Doctor doctor, String registerDate) {
        super(id, name, surname, phone);
        this.doctor = doctor;
        this.registerDate = registerDate;
    }

    public Patient() {
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (!Objects.equals(doctor, patient.doctor)) return false;
        return Objects.equals(registerDate, patient.registerDate);
    }

    @Override
    public int hashCode() {
        int result = doctor != null ? doctor.hashCode() : 0;
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" + super.toString() +
                "doctor=" + doctor +
                ", registerDate='" + registerDate + '\'' +
                "} " ;
    }
}
