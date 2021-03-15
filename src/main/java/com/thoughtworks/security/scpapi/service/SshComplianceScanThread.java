package com.thoughtworks.security.scpapi.service;

import com.thoughtworks.security.scpapi.domain.EnvironmentTypePara;
import com.thoughtworks.security.scpapi.entity.ScanTaskEntity;
import com.thoughtworks.security.scpapi.repository.ScanResultRepository;
import com.thoughtworks.security.scpapi.repository.ScanTaskRepository;
import com.thoughtworks.security.scpapi.repository.UseCaseRepository;

public class SshComplianceScanThread extends ComplianceScanThread{
    public SshComplianceScanThread(ScanTaskEntity scanTaskEntity, ScanResultRepository scanResultRepository, ScanTaskRepository scanTaskRepository, UseCaseRepository useCaseRepository, EnvironmentTypePara environmentTypePara) {
        super(scanTaskEntity, scanResultRepository, scanTaskRepository, useCaseRepository, environmentTypePara);
    }
    @Override
    public String getScanEnvironmentCmd() {
        EnvironmentTypePara environmentTypePara = getEnvironmentPara();
        return " -t ssh://" + environmentTypePara.getUserName() + ":" + environmentTypePara.getPassword()
                + "@" + environmentTypePara.getAddr();
    }
}