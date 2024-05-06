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
}
