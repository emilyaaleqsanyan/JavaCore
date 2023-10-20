package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.PersonStorage;
import homework.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;


public class MedicalCenterDemo implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static PersonStorage personStorage = new PersonStorage();

    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_BY_ID:
                    changeDoctorById();
                    break;
                case ADD_PATIENT:
                    AddPatient();
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    printAllPatientsByDoctors();
                    break;
                case PRINT_ALL_DOCTORS:
                   personStorage.printDoctors();
                    break;
                case PRINT_TODAYS_PATIENTS:
                    personStorage.printTodaysPatients();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }


    }


    private static void printAllPatientsByDoctors() {
        personStorage.printDoctors();
        System.out.println("Please choose doctor id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = personStorage.getDoctorBYId(doctorId);
        if(doctorById != null){
            personStorage.printAllPatientsBYDoctor(doctorById);
        }else {
            System.out.println("doctor with " + doctorId + "does not exists!");
        }
    }

    private static void AddPatient() {
        personStorage.printDoctors();
        System.out.println("Please choose doctor id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = personStorage.getDoctorBYId(doctorId);
        if(doctorById != null){
            System.out.println("Please input patient id");
            String patientId = scanner.nextLine();
            System.out.println("Please input patient name");
            String patientName = scanner.nextLine();
            System.out.println("Please input patient surname");
            String patientSurname = scanner.nextLine();
            System.out.println("Please input patient phone");
            String patientPhone = scanner.nextLine();
            System.out.println("Please input register date time(dd/MM/yyyy hh:mm");
            String registerDateTame = scanner.nextLine();
            try{
            Date registerDateTime = DateUtil.stringToDateTime(registerDateTame);
            if(personStorage.isDoctorAvailable(doctorById,registerDateTime)){
            Patient patient = new Patient(patientId, patientName, patientSurname, patientPhone, doctorById,registerDateTime);
            personStorage.add(patient);
            System.out.println("Patient registered!");
            }else {
                System.out.println("doctor is unavailable in that time, please choose another time");
            }
        } catch (ParseException e) {
                System.out.println("Incorrect date time format, please try again!");
            }
        }else {
            System.out.println("doctor with " + doctorId + "does not exists!");
        }
    }

    private static void changeDoctorById(){
        personStorage.printDoctors();
        System.out.println("Please choose doctor id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = personStorage.getDoctorBYId(doctorId);
        if(doctorById != null){
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
            doctorById.setName(doctorName);
            doctorById.setSurname(doctorSurname);
            doctorById.setPhone(doctorPhone);
            doctorById.setEmail(doctorEmail);
            doctorById.setProfession(doctorProfession);
            System.out.println("doctor updated");
        }else {
            System.out.println("doctor with " + doctorId + "dose not exists!");
        }
    }


    private static void deleteDoctorById(){
        personStorage.printDoctors();
        System.out.println("Please choose doctor id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = personStorage.getDoctorBYId(doctorId);
        if(doctorById != null){
            personStorage.deleteDoctorById(doctorId);
        }else {
            System.out.println("doctor with " + doctorId + "dose not exists!");
        }
    }

    private static void searchDoctorByProfession() {
        System.out.println("Please choose doctor profession");
        personStorage.printDoctors();
        String doctorProfession = scanner.nextLine();
        personStorage.searchDoctorByProfession(doctorProfession);

    }

    private static void addDoctor() {
        System.out.println("Please input doctor id ");
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = personStorage.getDoctorBYId(doctorId);
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
        personStorage.add(doctor);
        System.out.println("Doctor registered");
    }



}
