package com.example.sinhvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sinhvien.entity.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
    
    @Query("SELECT sv FROM SinhVien sv WHERE " +
           "(:hoTen IS NULL OR sv.hoTen LIKE %:hoTen%) AND " +
           "(:email IS NULL OR sv.email LIKE %:email%) AND " +
           "(:soDT IS NULL OR sv.soDT LIKE %:soDT%) AND " +
           "(:diaChi IS NULL OR sv.diaChi LIKE %:diaChi%)")
    List<SinhVien> findBySearchCriteria(@Param("hoTen") String hoTen,
                                        @Param("email") String email,
                                        @Param("soDT") String soDT,
                                        @Param("diaChi") String diaChi);
}
