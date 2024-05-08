package com.laboratoryreportingapplication.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LabReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileNumber;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date dateGiven;
    private Date desiredDate;
    private String photoPath;

    @ManyToOne
    @JoinColumn(name = "lab_assistant_id")
    private LabAssistant labAssistant;

    public LabAssistant getLabAssistant() {
        return labAssistant;
    }

    public void setLabAssistant(LabAssistant labAssistant) {
        this.labAssistant = labAssistant;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getDiagnosisTitle() {
        return diagnosisTitle;
    }

    public void setDiagnosisTitle(String diagnosisTitle) {
        this.diagnosisTitle = diagnosisTitle;
    }

    public String getDiagnosisDetails() {
        return diagnosisDetails;
    }

    public void setDiagnosisDetails(String diagnosisDetails) {
        this.diagnosisDetails = diagnosisDetails;
    }

    public Date getDateGiven() {
        return dateGiven;
    }

    public void setDateGiven(Date dateGiven) {
        this.dateGiven = dateGiven;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public Date getDesiredDate() {
        return desiredDate;
    }

    public void setDesiredDate(Date desiredDate) {
        this.desiredDate = desiredDate;
    }

}
