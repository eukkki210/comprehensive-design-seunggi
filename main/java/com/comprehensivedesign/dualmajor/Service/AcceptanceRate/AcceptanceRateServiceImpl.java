//package com.comprehensivedesign.dualmajor.Service.AcceptanceRate;
//
//import com.comprehensivedesign.dualmajor.repository.acceptanceRate.GlobalMajorRepository;
//import com.comprehensivedesign.dualmajor.repository.acceptanceRate.SeoulMajorRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class AcceptanceRateServiceImpl implements AcceptanceRateService{
//    @Autowired private final SeoulMajorRepository seoulMajorRepository;
//    @Autowired private final GlobalMajorRepository globalMajorRepository;
//
//    /* 서울캠퍼스 전공 리스트 */
//    @Override
//    public Map viewMajorListSeoul() {
//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("SeoulMajor", seoulMajorRepository);
//    }
//
//    /* 글로벌캠퍼스 전공 리스트 */
//    @Override
//    public Map viewMajorListGlobal() {
//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("GlobalMajor", globalMajorRepository);
//    }
//
//    /* 지웑 여부 도출 로직 */
//    @Override
//    @Transactional
//    public Map applyinfo() {
//
//        return
//    }
//}
