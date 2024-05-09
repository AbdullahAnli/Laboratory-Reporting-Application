package com.laboratoryreportingapplication.controller;
import com.laboratoryreportingapplication.entity.LabReport;
import com.laboratoryreportingapplication.service.LabReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab-reports")
public class LabReportController {
    @Autowired
    private LabReportService labReportService;

    @PostMapping("/create")
    public ResponseEntity<LabReport>createLabReport(@RequestBody LabReport labReport){
        LabReport createdLabReport = labReportService.saveLabReport(labReport);
        return  new ResponseEntity<>(createdLabReport, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LabReport>updateLabReport(@PathVariable Long id ,  @RequestBody LabReport labReport){
        LabReport updateLabReport = labReportService.uptadeLabReport(id,labReport);
        return new ResponseEntity<>(updateLabReport,HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<LabReport>>getAllReports(){
        List<LabReport>labReports=labReportService.getAllLabReport();
        return new ResponseEntity<>(labReports,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LabReport>getLabReportById(@PathVariable Long id){
        LabReport labReports= labReportService.getLabReportById(id);
        if (labReports != null){
            return new ResponseEntity<>(labReports,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteLabReport(@PathVariable Long id){
        labReportService.deleteLabReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<List<LabReport>>searchLabReport(
            @RequestParam(required = false) String patientFirstName,
            @RequestParam(required = false) String patientLastName,
            @RequestParam(required = false) String patientIdentityNumber,
            @RequestParam(required = false) String labAssistantFirstName,
            @RequestParam(required = false) String labAssistantLastName,
            @RequestParam(required = false) String orderByDate){
        List<LabReport> labReports;
        if (patientFirstName != null || patientLastName != null){
            labReports = labReportService.searchByPatientName(patientFirstName,patientLastName);
        }
        // İstekte hasta kimlik numarası varsa ilgili metodu çağırır.
        else if (patientIdentityNumber != null) {
            labReports = labReportService.searchByPatientIdentityNumber(patientIdentityNumber);
        }
        // İstekte laborant adı veya soyadı varsa ilgili metodu çağırır.
        else if (labAssistantFirstName != null || labAssistantLastName != null) {
            labReports = labReportService.searchByLabAssistantName(labAssistantFirstName,labAssistantLastName);
        }
        // İstekte "orderByDate" parametresi "date" ise tarihe göre sıralı raporları getirir.
        else if ("date".equalsIgnoreCase(orderByDate)) {
            labReports = labReportService.getAllLabReportsOrderByDate();
        }
        // Hiçbir parametre belirtilmemişse tüm raporları getirir.
        else {
            labReports = labReportService.getAllLabReports();
        }
        // Sonuçları ve HTTP 200 (OK) durum kodunu döndürür.
        return ResponseEntity.ok(labReports);

    }


}
