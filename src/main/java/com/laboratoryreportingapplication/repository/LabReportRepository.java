package com.laboratoryreportingapplication.repository;

import com.laboratoryreportingapplication.entity.LabReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabReportRepository extends JpaRepository<LabReport, Long> {
    List<LabReport>findByPatientFirstNameContainingIgnoreCaseOrPatientLastNameContainingIgnoreCaseOrPatientIdentityNumberContainingIgnoreCaseOrLabAssistantFirstNameContainingIgnoreCaseOrLabAssistantLastNameContainingIgnoreCase(String firstName, String lastName,
                                                                                                                                                                                                                                   String identityNumber, String assistantFirstName, String assistantLastName);
    List<LabReport> findByOrderByDateGivenDesc();

    List<LabReport> findByPatientFirstNameAndPatientLastName(String patientFirstName, String patientLastName);

    List<LabReport> findByPatientIdentityNumber(String patientIdentityNumber);

    List<LabReport> findByLabAssistantFirstNameAndLabAssistantLastName(String labAssistantFirstName, String labAssistantLastName);

}
