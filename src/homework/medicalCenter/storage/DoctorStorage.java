package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;

public class DoctorStorage {

    private Doctor[] doctors = new Doctor[10];
    private int size;


    public Doctor getById(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(doctorId)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void add(Doctor doctor) {
        if (size == doctors.length) {
            extend();
        }
        doctors[size++] = doctor;
    }

    private void extend() {
        Doctor[] tmp = new Doctor[doctors.length + 10];
        System.arraycopy(doctors, 0, tmp, 0, doctors.length);
        doctors = tmp;

    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);

        }
    }

    public void deleteById(String doctorId) {
        int indexById = getIndexById(doctorId);
        if (indexById == -1) {
            System.out.println("Doctor does not exists!");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(doctorId)) {
                doctors[i - 1] = doctors[i];
            }
        }
        size--;
    }

    private int getIndexById(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(doctorId)) {
                return i;
            }
        }
        return -1;
    }


    public Doctor getProfession(String doctorProfession) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().equals(doctorProfession)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void searchDoctorByProfession(Doctor professionFromStorage) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().contains(professionFromStorage.getProfession())) {
                System.out.println(doctors[i].getId() + " " + doctors[i].getName() + " " + doctors[i].getSurname() + " " + doctors[i].getPhone() + " " + doctors[i].getEmail() + " " + doctors[i].getProfession());
            }
        }
    }
}
