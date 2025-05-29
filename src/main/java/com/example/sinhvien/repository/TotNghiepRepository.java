package com.example.sinhvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sinhvien.entity.TotNghiep;
import com.example.sinhvien.entity.TotNghiepId;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, TotNghiepId> {
    
    @Query("SELECT tn FROM TotNghiep tn JOIN tn.sinhVien sv JOIN tn.truong t JOIN tn.nganh n " +
           "WHERE (:hoTen IS NULL OR sv.hoTen LIKE %:hoTen%) AND " +
           "(:tenTruong IS NULL OR t.tenTruong LIKE %:tenTruong%) AND " +
           "(:tenNganh IS NULL OR n.tenNganh LIKE %:tenNganh%)")
    List<TotNghiep> findBySearchCriteria(@Param("hoTen") String hoTen,
                                         @Param("tenTruong") String tenTruong,
                                         @Param("tenNganh") String tenNganh);
}
