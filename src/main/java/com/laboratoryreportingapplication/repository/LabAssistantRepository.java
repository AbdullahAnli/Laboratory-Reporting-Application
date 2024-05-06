package com.laboratoryreportingapplication.repository;

import com.laboratoryreportingapplication.entity.LabAssistant;
import com.laboratoryreportingapplication.entity.LabReport;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabAssistantRepository extends JpaRepository<LabAssistant, Long> {
}
