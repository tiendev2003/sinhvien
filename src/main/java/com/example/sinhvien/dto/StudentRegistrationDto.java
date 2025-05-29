package com.example.sinhvien.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistrationDto {
    // SinhVien fields
    private String soCMND;
    private String hoTen;
    private String email;
    private String soDT;
    private String diaChi;
    
    // TotNghiep fields
    private String maTruong;
    private String maNganh;
    private String heTN;
    private LocalDate ngayTN;
    private String loaiTN;
}
