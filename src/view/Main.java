package view;

import controller.MedicalRecordController;
import model.RegularPatientMedicalRecord;
import model.VIPPatientMedicalRecord;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicalRecordController medicalRecordController = MedicalRecordController.getInstance();

        RegularPatientMedicalRecord regularPatientRecord = new RegularPatientMedicalRecord(1, "BA-001", "Nguyen Van A", "2024-10-01", "2024-10-10", 500000, "ung thu");
        VIPPatientMedicalRecord vipPatientRecord = new VIPPatientMedicalRecord(2, "BA-003", "Nguyen Van B", "2024-10-02", "2024-10-12", "VIP I", 30, "dau bung");

        medicalRecordController.addPredefinedMedicalRecord(regularPatientRecord);
        medicalRecordController.addPredefinedMedicalRecord(vipPatientRecord);

        while (true) {
            System.out.println("\n--- Medical Record Management ---");
            System.out.println("1. Add New Medical Record");
            System.out.println("2. Delete Medical Record");
            System.out.println("3. List Medical Records");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    medicalRecordController.addMedicalRecordFromInput(scanner);
                    break;
                case 2:
                    medicalRecordController.deleteMedicalRecord(scanner);
                    break;
                case 3:
                    medicalRecordController.listMedicalRecords();
                    break;
                case 4:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}