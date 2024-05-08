package com.laboratoryreportingapplication.service;
import com.laboratoryreportingapplication.entity.LabReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LabReportService {
    LabReport saveLabReport(LabReport labReport);
    LabReport uptadeLabReport(Long id, LabReport labReport);
    List<LabReport>getAllLabReport();
    LabReport getLabReportById(Long id);
    void  deleteLabReport(Long id);
    List<LabReport> searchByPatientName(String patientFirstName, String patientLastName);
    List<LabReport> searchByPatientIdentityNumber(String patientIdentityNumber);
    List<LabReport> searchByLabAssistantName(String labAssistantFirstName, String labAssistantLastName);
    List<LabReport> getAllLabReportsOrderByDate();
    List<LabReport> getAllLabReports();

}
