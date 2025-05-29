package com.example.sinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sinhvien.entity.Nganh;

@Repository
public interface NganhRepository extends JpaRepository<Nganh, String> {
}
