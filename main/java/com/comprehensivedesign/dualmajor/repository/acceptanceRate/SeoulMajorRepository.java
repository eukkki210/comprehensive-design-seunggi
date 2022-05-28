//package com.comprehensivedesign.dualmajor.repository.acceptanceRate;
//
//import com.comprehensivedesign.dualmajor.domain.acceptanceRate.SeoulMajor;
//import com.comprehensivedesign.dualmajor.dto.CampusMajorList;
//import com.comprehensivedesign.dualmajor.dto.MajorList;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface SeoulMajorRepository extends JpaRepository<SeoulMajor, Long> {
//
//    @Query(value = "select s.id as id, s.majorName as name from SEOUL_MAJOR s ", nativeQuery = true)
//    List<CampusMajorList> viewMajorListSeoul;
//}
