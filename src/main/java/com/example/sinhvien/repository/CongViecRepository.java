package com.example.sinhvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sinhvien.entity.CongViec;
import com.example.sinhvien.entity.CongViecId;

@Repository
public interface CongViecRepository extends JpaRepository<CongViec, CongViecId> {
    
    @Query("SELECT cv FROM CongViec cv JOIN cv.sinhVien sv JOIN cv.nganh n " +
           "WHERE (:hoTen IS NULL OR sv.hoTen LIKE %:hoTen%) AND " +
           "(:tenCongTy IS NULL OR cv.tenCongTy LIKE %:tenCongTy%) AND " +
           "(:tenNganh IS NULL OR n.tenNganh LIKE %:tenNganh%)")
    List<CongViec> findBySearchCriteria(@Param("hoTen") String hoTen,
                                        @Param("tenCongTy") String tenCongTy,
                                        @Param("tenNganh") String tenNganh);
}
