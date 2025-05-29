package com.example.sinhvien.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SINHVIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {
    @Id
    @Column(name = "SoCMND", length = 20)
    private String soCMND;
    
    @Column(name = "HoTen", length = 100)
    private String hoTen;
    
    @Column(name = "Email", length = 100)
    private String email;
    
    @Column(name = "SoDT", length = 15)
    private String soDT;
    
    @Column(name = "DiaChi", length = 200)
    private String diaChi;
}
