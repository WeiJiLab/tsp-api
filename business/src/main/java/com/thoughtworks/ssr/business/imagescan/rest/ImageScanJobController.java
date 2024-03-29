package com.thoughtworks.ssr.business.imagescan.rest;

import com.thoughtworks.ssr.business.imagescan.service.ImageScanJobService;
import com.thoughtworks.ssr.domain.imagescan.model.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/image-scan")
@RequiredArgsConstructor
public class ImageScanJobController {
    private final ImageScanJobService imageScanJobService;

    @PostMapping(value = "/upload/{type}")
    public String upload(@PathVariable String type, @RequestParam("file") MultipartFile file) {
        imageScanJobService.store(type,file);
        return "You successfully uploaded " + file.getOriginalFilename() + "!";
    }
    @PostMapping("/start")
    @ResponseStatus(OK)
    public Long imageScan(@Valid @RequestBody ImageScanRequest request) {
        return imageScanJobService.saveImageScanJob(request);
    }

    @GetMapping("/jobs")
    @ResponseStatus(OK)
    public List<ImageScanCommand> getAllImageScanJobs() {
        return imageScanJobService.getAllImageScanJobs();
    }

    @GetMapping("/stage-status/{pj_id}")
    @ResponseStatus(OK)
    public List<ImageScanStage> getStepResult(@Valid @PathVariable(value = "pj_id") Long pjId) {
        return imageScanJobService.findStagesByProjectId(pjId);
    }

    @PostMapping(value = "/stage-status")
    @ResponseBody
    public ImageScanStage saveStageResult(@RequestBody ImageScanStage resultEntity) {
        return imageScanJobService.saveStage(resultEntity);
    }

    @GetMapping("/steps/{pj_id}")
    @ResponseStatus(OK)
    public List<ImageScanResult> getScanResult(@Valid @PathVariable(value = "pj_id") Long pjId) {
        return imageScanJobService.findResultsByProjectId(pjId);
    }

    @PostMapping(value = "/detail-result")
    public ImageScanResult saveScanResult(@Valid @RequestBody ImageScanResult scanStageEntity) {
        return imageScanJobService.saveResult(scanStageEntity);
    }

    @PostMapping(value = "/report/{projectId}")
    public ImageScanReport saveScanReport(@RequestParam MultipartFile file, @PathVariable Long projectId) {
        return imageScanJobService.saveScanReport(projectId, file);
    }

    @GetMapping(value = "/report/{pj_id}")
    public String downloadScanReport(@PathVariable("pj_id") Long projectId) throws IOException {
        return imageScanJobService.getScanReport(projectId);
    }

    @PostMapping(value = "/stop")
    public String stopScan(@Valid @RequestBody StopCommand stopCommand) {
        return imageScanJobService.stopScan(stopCommand);
    }
}
