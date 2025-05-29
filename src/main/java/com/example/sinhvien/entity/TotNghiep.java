package com.example.sinhvien.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TOT_NGHIEP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TotNghiepId.class)
public class TotNghiep {
    @Id
    @Column(name = "SoCMND", length = 20)
    private String soCMND;
    
    @Id
    @Column(name = "MaTruong", length = 20)
    private String maTruong;
    
    @Id
    @Column(name = "MaNganh", length = 20)
    private String maNganh;
    
    @Column(name = "HeTN", length = 50)
    private String heTN;
    
    @Column(name = "NgayTN")
    private LocalDate ngayTN;
    
    @Column(name = "LoaiTN", length = 50)
    private String loaiTN;
    
    @ManyToOne
    @JoinColumn(name = "SoCMND", insertable = false, updatable = false)
    private SinhVien sinhVien;
    
    @ManyToOne
    @JoinColumn(name = "MaTruong", insertable = false, updatable = false)
    private Truong truong;
    
    @ManyToOne
    @JoinColumn(name = "MaNganh", insertable = false, updatable = false)
    private Nganh nganh;
}
