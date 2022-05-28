//package com.comprehensivedesign.dualmajor.repository.acceptanceRate;
//
//import com.comprehensivedesign.dualmajor.domain.acceptanceRate.GlobalMajor;
//import com.comprehensivedesign.dualmajor.dto.CampusMajorList;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface GlobalMajorRepository extends JpaRepository<GlobalMajor, Long> {
//
//    @Query(value = "select g.id as id, g.majorName as name from GLOBAL_MAJOR g ", nativeQuery = true)
//    List<CampusMajorList> viewMajorListGlobal;
//}
