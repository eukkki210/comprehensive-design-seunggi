package com.comprehensivedesign.dualmajor.controller;

import com.comprehensivedesign.dualmajor.Service.AcceptanceRate.AcceptanceRateService;
import com.comprehensivedesign.dualmajor.dto.AcceptanceRateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AcceptanceRateController {
    private final AcceptanceRateService acceptanceRateService;

    @Autowired
    public AcceptanceRateController(AcceptanceRateService acceptanceRateService) {
        this.acceptanceRateService = acceptanceRateService;
    }

    /* 서울캠퍼스 개설 전공 목록 받아오는 API */
    @GetMapping("majorList/seoul/")
    public Map majorListSeoul() {
        return AcceptanceRateService.viewMajorListSeoul();
    }

    /* 글로벌캠퍼스 개설 전공 목록 받아오는 API*/
    @GetMapping("majorList/global/")
    public Map majorListGlobal() {
        return AcceptanceRateService.viewMajorListGlobal();
    }

    /* 경쟁률 정보 API */
    @PostMapping("/majorList/global/{majorName}")
    public Map rateInfo(@RequestBody AcceptanceRateDto acceptanceRateDto) {
        Map<String, Object> map = new LinkedHashMap<>();
        AcceptanceRateDto  = new AcceptanceRateDto();
    }


    @GetMapping("getApplyInfo/")
    public Map applyInfo(@RequestBody AcceptanceRateDto acceptanceRateDto) {
        return
    }

    @PostMapping("postApply/")
    public boolean apply(@RequestBody AcceptanceRateDto acceptanceRateDto) {
        return
    }

}
