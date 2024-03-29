package com.thoughtworks.ssr.infrastructure.persistence.scan.entity;


import com.thoughtworks.ssr.domain.scan.enums.ScanTaskEnum;
import com.thoughtworks.ssr.infrastructure.persistence.common.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;

@Entity(name = "scan_task")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScanTaskEntity extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long appId;

    private Long toolId;

    private Long useCaseId;

    @Enumerated(value = EnumType.STRING)
    private ScanTaskEnum status;

    private Instant startTime;

    private Instant endTime;

}
