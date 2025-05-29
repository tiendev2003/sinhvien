package com.example.sinhvien.service;

import com.example.sinhvien.entity.*;
import com.example.sinhvien.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private TruongRepository truongRepository;
    
    @Autowired
    private NganhRepository nganhRepository;
    
    @Autowired
    private SinhVienRepository sinhVienRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Initialize sample data if tables are empty
        initializeTruong();
        initializeNganh();
    }
    
    private void initializeTruong() {
        if (truongRepository.count() == 0) {
            truongRepository.save(new Truong("DH001", "Đại học Bách Khoa Hà Nội", "Số 1 Đại Cồ Việt, Hai Bà Trưng, Hà Nội", "024-38691234"));
            truongRepository.save(new Truong("DH002", "Đại học Quốc gia Hà Nội", "144 Xuân Thủy, Cầu Giấy, Hà Nội", "024-37547479"));
            truongRepository.save(new Truong("DH003", "Đại học Công nghệ", "E3 Building, 144 Xuân Thủy, Cầu Giấy, Hà Nội", "024-37548135"));
            truongRepository.save(new Truong("DH004", "Đại học Kinh tế Quốc dân", "207 Giải Phóng, Đống Đa, Hà Nội", "024-38622117"));
            truongRepository.save(new Truong("DH005", "Đại học Ngoại thương", "91 Chùa Láng, Đống Đa, Hà Nội", "024-38349144"));
            truongRepository.save(new Truong("CD001", "Cao đẳng Công nghệ Thông tin", "Km 10, Nguyễn Trãi, Thanh Xuân, Hà Nội", "024-33551234"));
            truongRepository.save(new Truong("CD002", "Cao đẳng Kinh tế - Kỹ thuật", "Số 456 Minh Khai, Hai Bà Trưng, Hà Nội", "024-38621234"));
        }
    }
    
    private void initializeNganh() {
        if (nganhRepository.count() == 0) {
            nganhRepository.save(new Nganh("CNTT", "Công nghệ Thông tin", "Công nghệ"));
            nganhRepository.save(new Nganh("KTPM", "Kỹ thuật Phần mềm", "Công nghệ"));
            nganhRepository.save(new Nganh("KHMT", "Khoa học Máy tính", "Công nghệ"));
            nganhRepository.save(new Nganh("ATTT", "An toàn Thông tin", "Công nghệ"));
            nganhRepository.save(new Nganh("TMDT", "Thương mại Điện tử", "Kinh tế"));
            nganhRepository.save(new Nganh("QTKD", "Quản trị Kinh doanh", "Kinh tế"));
            nganhRepository.save(new Nganh("TCNH", "Tài chính Ngân hàng", "Kinh tế"));
            nganhRepository.save(new Nganh("KTKT", "Kế toán Kiểm toán", "Kinh tế"));
            nganhRepository.save(new Nganh("KTDT", "Kỹ thuật Điện tử", "Kỹ thuật"));
            nganhRepository.save(new Nganh("KTCO", "Kỹ thuật Cơ khí", "Kỹ thuật"));
            nganhRepository.save(new Nganh("XDDD", "Xây dựng Dân dụng", "Xây dựng"));
            nganhRepository.save(new Nganh("NNTA", "Ngôn ngữ Tiếng Anh", "Ngoại ngữ"));
        }
    }
}
