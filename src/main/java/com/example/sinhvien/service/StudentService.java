package com.example.sinhvien.service;

import com.example.sinhvien.dto.StudentRegistrationDto;
import com.example.sinhvien.entity.*;
import com.example.sinhvien.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StudentService {
    
    @Autowired
    private SinhVienRepository sinhVienRepository;
    
    @Autowired
    private TotNghiepRepository totNghiepRepository;
    
    @Autowired
    private TruongRepository truongRepository;
    
    @Autowired
    private NganhRepository nganhRepository;
    
    @Autowired
    private CongViecRepository congViecRepository;
    
    public List<Truong> getAllTruong() {
        return truongRepository.findAll();
    }
    
    public List<Nganh> getAllNganh() {
        return nganhRepository.findAll();
    }
    
    @Transactional
    public void registerStudent(StudentRegistrationDto dto) {
        // Create or update SinhVien
        SinhVien sinhVien = new SinhVien();
        sinhVien.setSoCMND(dto.getSoCMND());
        sinhVien.setHoTen(dto.getHoTen());
        sinhVien.setEmail(dto.getEmail());
        sinhVien.setSoDT(dto.getSoDT());
        sinhVien.setDiaChi(dto.getDiaChi());
        sinhVienRepository.save(sinhVien);
        
        // Create TotNghiep record
        TotNghiep totNghiep = new TotNghiep();
        totNghiep.setSoCMND(dto.getSoCMND());
        totNghiep.setMaTruong(dto.getMaTruong());
        totNghiep.setMaNganh(dto.getMaNganh());
        totNghiep.setHeTN(dto.getHeTN());
        totNghiep.setNgayTN(dto.getNgayTN());
        totNghiep.setLoaiTN(dto.getLoaiTN());
        totNghiepRepository.save(totNghiep);
    }
    
    public List<SinhVien> searchStudents(String hoTen, String email, String soDT, String diaChi) {
        return sinhVienRepository.findBySearchCriteria(
            hoTen != null && !hoTen.trim().isEmpty() ? hoTen.trim() : null,
            email != null && !email.trim().isEmpty() ? email.trim() : null,
            soDT != null && !soDT.trim().isEmpty() ? soDT.trim() : null,
            diaChi != null && !diaChi.trim().isEmpty() ? diaChi.trim() : null
        );
    }
    
    public List<TotNghiep> searchGraduationInfo(String hoTen, String tenTruong, String tenNganh) {
        return totNghiepRepository.findBySearchCriteria(
            hoTen != null && !hoTen.trim().isEmpty() ? hoTen.trim() : null,
            tenTruong != null && !tenTruong.trim().isEmpty() ? tenTruong.trim() : null,
            tenNganh != null && !tenNganh.trim().isEmpty() ? tenNganh.trim() : null
        );
    }
    
    public List<CongViec> searchJobInfo(String hoTen, String tenCongTy, String tenNganh) {
        return congViecRepository.findBySearchCriteria(
            hoTen != null && !hoTen.trim().isEmpty() ? hoTen.trim() : null,
            tenCongTy != null && !tenCongTy.trim().isEmpty() ? tenCongTy.trim() : null,
            tenNganh != null && !tenNganh.trim().isEmpty() ? tenNganh.trim() : null
        );
    }
}
