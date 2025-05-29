package com.example.sinhvien.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NGANH")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nganh {
    @Id
    @Column(name = "MaNganh", length = 20)
    private String maNganh;
    
    @Column(name = "TenNganh", length = 100)
    private String tenNganh;
    
    @Column(name = "LoaiNganh", length = 50)
    private String loaiNganh;
}
