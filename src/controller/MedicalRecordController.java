package controller;

import model.MedicalRecord;
import model.RegularPatientMedicalRecord;
import model.VIPPatientMedicalRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordController {
    private static MedicalRecordController instance;
    private List<MedicalRecord> medicalRecords;

    private MedicalRecordController() {
        medicalRecords = new ArrayList<>();
    }

    public static MedicalRecordController getInstance() {
        if (instance == null) {
            instance = new MedicalRecordController();
        }
        return instance;
    }

    public void addMedicalRecordFromInput(Scanner scanner) {
        System.out.print("Enter record type (1 for Regular, 2 for VIP): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Record Number: ");
        int recordNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Record Code: ");
        String recordCode = scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter Admission Date (YYYY-MM-DD): ");
        String admissionDate = scanner.nextLine();

        System.out.print("Enter Discharge Date (YYYY-MM-DD): ");
        String dischargeDate = scanner.nextLine();

        System.out.print("Enter Reason for Admission: ");
        String reasonForAdmission = scanner.nextLine(); // New input for reason

        if (type == 1) {
            System.out.print("Enter Hospital Fee: ");
            long hospitalFee = scanner.nextLong();
            medicalRecords.add(new RegularPatientMedicalRecord(recordNumber, recordCode, patientName, admissionDate, dischargeDate, hospitalFee, reasonForAdmission));
            System.out.println("Regular Patient Medical Record added.");
        } else if (type == 2) {
            System.out.println("Select VIP Level:");
            System.out.println("1. VIP I");
            System.out.println("2. VIP II");
            System.out.println("3. VIP III");
            int vipChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String vipLevel;
            switch (vipChoice) {
                case 1:
                    vipLevel = "VIP I";
                    break;
                case 2:
                    vipLevel = "VIP II";
                    break;
                case 3:
                    vipLevel = "VIP III";
                    break;
                default:
                    System.out.println("Invalid VIP Level selected. Defaulting to VIP I.");
                    vipLevel = "VIP I";
                    break;
            }

            System.out.print("Enter VIP Duration (days): ");
            int vipDuration = scanner.nextInt();
            medicalRecords.add(new VIPPatientMedicalRecord(recordNumber, recordCode, patientName, admissionDate, dischargeDate, vipLevel, vipDuration, reasonForAdmission));
            System.out.println("VIP Patient Medical Record added.");
        } else {
            System.out.println("Invalid type selected.");
        }
    }
    public void deleteMedicalRecord(Scanner scanner) {
        System.out.print("Enter Record Number to delete: ");
        int recordNumber = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordNumber() == recordNumber) {
                found = true;
                System.out.print("Are you sure you want to delete this record? (yes/no): ");
                String confirmation = scanner.nextLine().trim().toLowerCase();

                if (confirmation.equals("yes")) {
                    medicalRecords.remove(record);
                    System.out.println("Medical Record deleted.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Record not found.");
        }
    }
    public void addPredefinedMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public void listMedicalRecords() {
        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records found.");
        } else {
            System.out.println("\n--- List of Medical Records ---");
            for (MedicalRecord record : medicalRecords) {
                System.out.println(record.getMedicalRecordInfo());
            }
        }
    }
}