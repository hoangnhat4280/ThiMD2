package model;

public class VIPPatientMedicalRecord extends MedicalRecord {
    private String vipLevel;
    private int vipDuration;

    public VIPPatientMedicalRecord(int recordNumber, String recordCode, String patientName, String admissionDate, String dischargeDate, String vipLevel, int vipDuration, String reasonForAdmission) {
        super(recordNumber, recordCode, patientName, admissionDate, dischargeDate, reasonForAdmission);
        this.vipLevel = vipLevel;
        this.vipDuration = vipDuration;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    public int getVipDuration() {
        return vipDuration;
    }

    public void setVipDuration(int vipDuration) {
        this.vipDuration = vipDuration;
    }

    @Override
    public String getMedicalRecordInfo() {
        return String.format("Record Number: %d, Record Code: %s, Patient Name: %s, Admission Date: %s, Discharge Date: %s, Reason for Admission: %s, VIP Level: %s, VIP Duration: %d days",
                getRecordNumber(), getRecordCode(), getPatientName(), getAdmissionDate(), getDischargeDate(), getReasonForAdmission(), vipLevel, vipDuration);
    }
}