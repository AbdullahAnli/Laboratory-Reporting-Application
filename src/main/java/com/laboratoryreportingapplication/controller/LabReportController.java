package com.laboratoryreportingapplication.controller;
import com.laboratoryreportingapplication.entity.LabReport;
import com.laboratoryreportingapplication.service.LabReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
