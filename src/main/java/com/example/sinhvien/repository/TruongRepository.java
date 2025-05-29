package com.example.sinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sinhvien.entity.Truong;

@Repository
public interface TruongRepository extends JpaRepository<Truong, String> {
}
