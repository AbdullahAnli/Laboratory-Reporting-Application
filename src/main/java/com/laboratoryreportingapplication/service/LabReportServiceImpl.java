package com.laboratoryreportingapplication.service;

import com.laboratoryreportingapplication.entity.LabReport;
import com.laboratoryreportingapplication.repository.LabAssistantRepository;
import com.laboratoryreportingapplication.repository.LabReportRepository;
import com.laboratoryreportingapplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LabReportServiceImpl implements LabReportService {
    @Autowired
    private LabReportRepository labReportRepository;
    @Autowired
    private LabAssistantRepository labAssistantRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional
    public LabReport saveLabReport(LabReport labReport){
        if (labReport.getLabAssistant() != null) {
            labAssistantRepository.save(labReport.getLabAssistant());
        }
        if (labReport.getPatient()!= null) {
            patientRepository.save(labReport.getPatient());
        }
        return labReportRepository.save(labReport);
    }
    @Override
    @Transactional
    public LabReport uptadeLabReport(Long id, LabReport labReport) {
        LabReport existingLabReport = labReportRepository.findById(id).orElse(null);
        if (existingLabReport != null){
            existingLabReport.setFileNumber(labReport.getFileNumber());
            existingLabReport.setDiagnosisTitle(labReport.getDiagnosisTitle());
            existingLabReport.setDiagnosisDetails(labReport.getDiagnosisDetails());
            existingLabReport.setDateGiven(labReport.getDateGiven());
            existingLabReport.setPhotoPath(labReport.getPhotoPath());
            existingLabReport.setLabAssistant(labReport.getLabAssistant());
            existingLabReport.setPatient(labReport.getPatient());
            return labReportRepository.save(existingLabReport);
        }
        return null;
    }

    @Override
    public List<LabReport> getAllLabReport() {
        return labReportRepository.findAll();
    }

    @Override
    public LabReport getLabReportById(Long id) {
        return labReportRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLabReport(Long id) {
        labReportRepository.deleteById(id);
    }
}


