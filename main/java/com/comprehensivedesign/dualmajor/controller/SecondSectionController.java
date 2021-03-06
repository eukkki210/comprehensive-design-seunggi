package com.comprehensivedesign.dualmajor.controller;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.comprehensivedesign.dualmajor.Service.MemberRecommendedMajor.MemberRecommendedMajorService;
import com.comprehensivedesign.dualmajor.Service.SecondSection.SecondSectionService;
import com.comprehensivedesign.dualmajor.config.auth.MemberAdapter;
import com.comprehensivedesign.dualmajor.domain.secondSection.SecondSectionResponse;
import com.comprehensivedesign.dualmajor.dto.MemberDto;
import com.comprehensivedesign.dualmajor.dto.SecondSectionQuestionDto;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SecondSectionController {

    @Autowired private final SecondSectionService secondSectionService;
    @Autowired private final MemberRecommendedMajorService memberRecommendedMajorService;

    @PostMapping("/submitFirstSectionResult")
    public Map saveSector(@RequestBody SecondSectionQuestionDto secondSectionQuestionDto) {
        Map<String, Object> map = new LinkedHashMap<>();
        System.out.println("academic name in submitfirstsectionresult : "+secondSectionQuestionDto.getAcademicName());
        System.out.println("testKey in submitfirstsectionresult : "+secondSectionQuestionDto.getTestKey());
        SecondSectionResponse response = secondSectionService.createResponse(secondSectionQuestionDto.getTestKey(), secondSectionQuestionDto.getAcademicName());
        map.put("testKey", secondSectionQuestionDto.getTestKey());
        map.put("success", true);
        map.put("academicName", response.getSectorName());
        return map;
    }

    @PostMapping("/secondSectionQuestion")
    public Map viewQuestion(@RequestBody SecondSectionQuestionDto secondSectionQuestionDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Map map = secondSectionService.recommendProcess(secondSectionQuestionDto, secondSectionQuestionDto.getTestKey());
        return map;
    }

    @PostMapping("/secondSectionAnswer")
    public Map getAnswer(@RequestBody SecondSectionQuestionDto secondSectionQuestionDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Map<String, Object> map = new LinkedHashMap<>();
        /* ?????? ?????? ????????? ????????? ?????? ?????? 1, 2?????? ?????? ?????? */
        if(secondSectionQuestionDto.getQuestionNum()==1 || secondSectionQuestionDto.getQuestionNum()==2){
            String str = secondSectionService.saveCollegeAnswer(secondSectionQuestionDto, secondSectionQuestionDto.getTestKey());
            if(str.equals("q1")){
                map.put("testKey", secondSectionQuestionDto.getTestKey());
                map.put("success", true);
                map.put("finished", false);
            } else { //?????? ????????? ?????? ??? ????????? ?????? vs ????????? ??????
                if (str.equals("humanity")) { //????????? ????????? ?????? ?????? 2?????? ????????? ?????????.
                    map.put("testKey", secondSectionQuestionDto.getTestKey());
                    map.put("success", true);
                    map.put("finished", true);
                }
                else{
                    map.put("testKey", secondSectionQuestionDto.getTestKey());
                    map.put("success", true);
                    map.put("finished", false);
                }
            }
            return map;
        }
        /* ????????? ?????? ????????? ?????? ?????? ?????? */
        String progress = secondSectionService.binaryTree(secondSectionQuestionDto.getAnswer(), secondSectionQuestionDto.getTestKey());
        if (progress.equals("end")) { //????????? ????????? ????????? ?????? ???????????? ????????? ???????????? ?????? ????????? ?????? API
            map.put("testKey", secondSectionQuestionDto.getTestKey());
            map.put("success", true);
            map.put("finished", "result101");
            return map;
        }
        map.put("testKey", secondSectionQuestionDto.getTestKey());
        map.put("success", true);
        map.put("finished", false);
        return map;
    }

    @PostMapping("/finalResult")
    public Map viewResult(@RequestBody SecondSectionQuestionDto secondSectionQuestionDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        if (secondSectionQuestionDto.getResultType().equals("result101")) {
            return secondSectionService.viewResult(secondSectionQuestionDto.getTestKey());
        }
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", false);
        return map;

    }

    @PostMapping("/saveResult")
    public Object saveResult(@RequestBody MemberDto memberDto, @RequestBody SecondSectionQuestionDto secondSectionQuestionDto) throws Exception {
        if (secondSectionQuestionDto.getResultType().equals("result101")) {
            memberRecommendedMajorService.saveResult(memberDto, secondSectionQuestionDto.getTestKey());
        }
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", true);
        return map;
    }
}
