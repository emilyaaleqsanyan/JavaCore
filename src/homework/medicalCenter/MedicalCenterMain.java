package homework.medicalCenter;


import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.DoctorStorage;
import homework.medicalCenter.storage.PatientStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterMain {

    private final static Scanner scanner = new Scanner(System.in);
    private final static DoctorStorage doctorStorage = new DoctorStorage();
    private final static PatientStorage patientStorage = new PatientStorage();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public static void main(String[] args) throws ParseException{
        boolean isRun = true;

        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addDoctor();
                    break;
                case "2":
                    searchDoctorByProfession();
                    break;
                case "3":
                    deleteDoctorById();
                    break;
                case "4":
                    changeDoctorById();
                    break;
                case "5":
                    addPatient();
                    break;
                case "6":
                    printAllPatientsByDoctor();
                    break;
                case "7":
                    printAllPatients();
                    break;
                case"8":
                    printAllDoctors();
                default:
                    System.out.println("invalid command. Try again!");
            }
        }

    }

    private static void printAllDoctors() {
        System.out.println("**************");
        doctorStorage.print();
        System.out.println("**************");
    }

    private static void printAllPatients() {
        System.out.println("**************");
        patientStorage.print();
        System.out.println("**************");
    }

    private static void printAllPatientsByDoctor() {
        System.out.println("Please choose doctor id");
        doctorStorage.print();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        patientStorage.printByDoctor(doctorFromStorage);


    }

    private static void addPatient() throws ParseException {
        System.out.println("Please choose doctor id");
        doctorStorage.print();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with " + doctorId + "does not exists!!!");
            return;
        }
        System.out.println("Please input patient id");
        String patientId = scanner.nextLine();
        Patient patientFromStorage = patientStorage.getById(patientId);
        if (patientFromStorage != null) {
            System.out.println("patient with " + patientId + "is already exists");
            return;
        }
        System.out.println("Please input patient name");
        String patientName = scanner.nextLine();
        System.out.println("Please input patient surname");
        String patientSurname = scanner.nextLine();
        System.out.println("Please input patient phone");
        String patientPhone = scanner.nextLine();
        System.out.println("Please input register date time(dd/MM/yyyy hh:mm");
        String registerDateTame = scanner.nextLine();
        Date date = sdf.parse(registerDateTame);
        Patient patient = new Patient(patientId, patientName, patientSurname, patientPhone, doctorFromStorage, registerDateTame);
        patientStorage.add(patient);
        System.out.println("Patient registered!");


    }


    private static void changeDoctorById() {
        System.out.println("Please input doctor id");
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with " + doctorId + "does not exists!!!");
            return;
        }
        System.out.println("Please input new doctor name");
        String doctorName = scanner.nextLine();
        System.out.println("Please input new doctor surname");
        String doctorSurname = scanner.nextLine();
        System.out.println("Please input new  doctor phone");
        String doctorPhone = scanner.nextLine();
        System.out.println("Please input new doctor email");
        String doctorEmail = scanner.nextLine();
        System.out.println("Please input new doctor profession");
        String doctorProfession = scanner.nextLine();
        doctorFromStorage.setName(doctorName);
        doctorFromStorage.setSurname(doctorSurname);
        doctorFromStorage.setPhone(doctorPhone);
        doctorFromStorage.setEmail(doctorEmail);
        doctorFromStorage.setProfession(doctorProfession);
        System.out.println("doctor updated");
    }

    private static void deleteDoctorById() {
        System.out.println("Please input doctor id ");
        doctorStorage.print();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with " + doctorId + "does not exists!!!");
            return;
        }
        doctorStorage.deleteById(doctorId);
    }


    private static void searchDoctorByProfession() {
        System.out.println("Please choose doctor profession");
        doctorStorage.print();
        String doctorProfession = scanner.nextLine();
        Doctor professionFromStorage = doctorStorage.getProfession(doctorProfession);
        if (professionFromStorage == null) {
            System.out.println("Company with " + doctorProfession + "does not exists!!!");
            return;
        }
        doctorStorage.searchDoctorByProfession(professionFromStorage);

    }

    private static void addDoctor() {
        System.out.println("Please input doctor id ");
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage != null) {
            System.out.println("Doctor with " + doctorId + "already exists!!!");
            return;
        }
        System.out.println("Please input doctor name");
        String doctorName = scanner.nextLine();
        System.out.println("Please input doctor surname");
        String doctorSurname = scanner.nextLine();
        System.out.println("Please input doctor phone");
        String doctorPhone = scanner.nextLine();
        System.out.println("Please input doctor email");
        String doctorEmail = scanner.nextLine();
        System.out.println("Please input doctor profession");
        String doctorProfession = scanner.nextLine();
        Doctor doctor = new Doctor(doctorId, doctorName, doctorSurname, doctorPhone, doctorEmail, doctorProfession);
        doctorStorage.add(doctor);
        System.out.println("Doctor registered");
    }

    private static void printCommands() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 for ADD DOCTOR");
        System.out.println("Please input 2 for SEARCH DOCTOR BY PROFESSION");
        System.out.println("Please input 3 for DELETE DOCTOR BY ID");
        System.out.println("Please input 4 for CHANGE DOCTOR BY ID");
        System.out.println("Please input 5 for ADD PATIENT");
        System.out.println("Please input 6 for PRINT ALL PATIENTS BY DOCTOR");
        System.out.println("Please input 7 for PRINT ALL PATIENTS");
        System.out.println("Please input 8 for PRINT ALL DOCTORS ");

    }

}
