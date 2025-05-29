package com.example.sinhvien.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRUONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Truong {
    @Id
    @Column(name = "MaTruong", length = 20)
    private String maTruong;
    
    @Column(name = "TenTruong", length = 100)
    private String tenTruong;
    
    @Column(name = "DiaChi", length = 200)
    private String diaChi;
    
    @Column(name = "SoDT", length = 15)
    private String soDT;
}
