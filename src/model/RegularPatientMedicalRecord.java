package model;

public class RegularPatientMedicalRecord extends MedicalRecord {
    private long hospitalFee;

    public RegularPatientMedicalRecord(int recordNumber, String recordCode, String patientName, String admissionDate, String dischargeDate, long hospitalFee, String reasonForAdmission) {
        super(recordNumber, recordCode, patientName, admissionDate, dischargeDate, reasonForAdmission); // Pass reason to superclass
        this.hospitalFee = hospitalFee;
    }

    public long getHospitalFee() {
        return hospitalFee;
    }

    public void setHospitalFee(long hospitalFee) {
        this.hospitalFee = hospitalFee;
    }

    @Override
    public String getMedicalRecordInfo() {
        return String.format("Record Number: %d, Record Code: %s, Patient Name: %s, Admission Date: %s, Discharge Date: %s, Reason for Admission: %s, Hospital Fee: %d",
                getRecordNumber(), getRecordCode(), getPatientName(), getAdmissionDate(), getDischargeDate(), getReasonForAdmission(), hospitalFee);
    }
}