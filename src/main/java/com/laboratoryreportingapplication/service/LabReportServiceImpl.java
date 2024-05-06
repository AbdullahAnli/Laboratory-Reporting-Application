package com.laboratoryreportingapplication.service;

import com.laboratoryreportingapplication.entity.LabReport;
import com.laboratoryreportingapplication.repository.LabReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabReportServiceImpl implements LabReportService {
    @Autowired
    private LabReportRepository labReportRepository;

    @Override
    public LabReport saveLabReport(LabReport labReport){
        return labReportRepository.save(labReport);
    }
    @Override
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


