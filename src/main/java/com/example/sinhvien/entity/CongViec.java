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
@Table(name = "CONG_VIEC")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CongViecId.class)
public class CongViec {
    @Id
    @Column(name = "SoCMND", length = 20)
    private String soCMND;
    
    @Id
    @Column(name = "NgayVaoCongTy")
    private LocalDate ngayVaoCongTy;
    
    @Column(name = "MaNganh", length = 20)
    private String maNganh;
    
    @Column(name = "TenCongTy", length = 100)
    private String tenCongTy;
    
    @Column(name = "DiaChiCongTy", length = 200)
    private String diaChiCongTy;
    
    @Column(name = "ThoiGianLamViec")
    private Integer thoiGianLamViec;
    
    @ManyToOne
    @JoinColumn(name = "SoCMND", insertable = false, updatable = false)
    private SinhVien sinhVien;
    
    @ManyToOne
    @JoinColumn(name = "MaNganh", insertable = false, updatable = false)
    private Nganh nganh;
}
