package model;

public abstract class MedicalRecord {
    private int recordNumber;
    private String recordCode;
    private String patientName;
    private String admissionDate;
    private String dischargeDate;
    private String reasonForAdmission;

    public MedicalRecord(int recordNumber, String recordCode, String patientName, String admissionDate, String dischargeDate, String reasonForAdmission) {
        this.recordNumber = recordNumber;
        this.recordCode = recordCode;
        this.patientName = patientName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reasonForAdmission = reasonForAdmission; // Initialize the new field
    }

    // Abstract method to display medical record information
    public abstract String getMedicalRecordInfo();

    public int getRecordNumber() {
        return recordNumber;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public String getReasonForAdmission() { // Getter for reason for admission
        return reasonForAdmission;
    }
}