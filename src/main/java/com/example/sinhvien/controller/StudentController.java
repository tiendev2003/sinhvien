package com.example.sinhvien.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sinhvien.dto.StudentRegistrationDto;
import com.example.sinhvien.entity.CongViec;
import com.example.sinhvien.entity.SinhVien;
import com.example.sinhvien.entity.TotNghiep;
import com.example.sinhvien.service.StudentService;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    // Student Registration Form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("studentDto", new StudentRegistrationDto());
        model.addAttribute("truongList", studentService.getAllTruong());
        model.addAttribute("nganhList", studentService.getAllNganh());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("studentDto") StudentRegistrationDto studentDto,
                                  BindingResult result,
                                  Model model,
                                  RedirectAttributes redirectAttributes) {
        
        // Validation
        if (studentDto.getSoCMND() == null || studentDto.getSoCMND().trim().isEmpty()) {
            result.rejectValue("soCMND", "error.soCMND", "Số CMND là bắt buộc");
        }
        
        if (studentDto.getMaTruong() == null || studentDto.getMaTruong().trim().isEmpty()) {
            result.rejectValue("maTruong", "error.maTruong", "Mã trường là bắt buộc");
        }
        
        if (studentDto.getMaNganh() == null || studentDto.getMaNganh().trim().isEmpty()) {
            result.rejectValue("maNganh", "error.maNganh", "Mã ngành là bắt buộc");
        }
        
        // Date validation
        if (studentDto.getNgayTN() != null && studentDto.getNgayTN().isAfter(LocalDate.now())) {
            result.rejectValue("ngayTN", "error.ngayTN", "Ngày tốt nghiệp không thể trong tương lai");
        }
        
        if (result.hasErrors()) {
            model.addAttribute("truongList", studentService.getAllTruong());
            model.addAttribute("nganhList", studentService.getAllNganh());
            return "register";
        }
        
        try {
            studentService.registerStudent(studentDto);
            redirectAttributes.addFlashAttribute("successMessage", "Đăng ký thông tin sinh viên thành công!");
            return "redirect:/register";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
            model.addAttribute("truongList", studentService.getAllTruong());
            model.addAttribute("nganhList", studentService.getAllNganh());
            return "register";
        }
    }
    
    // Search Basic Student Info
    @GetMapping("/search/basic")
    public String showBasicSearchForm(Model model) {
        return "search-basic";
    }
    
    @PostMapping("/search/basic")
    public String searchBasicInfo(@RequestParam(required = false) String hoTen,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required = false) String soDT,
                                  @RequestParam(required = false) String diaChi,
                                  Model model) {
        
        List<SinhVien> students = studentService.searchStudents(hoTen, email, soDT, diaChi);
        model.addAttribute("students", students);
        model.addAttribute("searchPerformed", true);
        
        // Keep search values in form
        model.addAttribute("hoTen", hoTen);
        model.addAttribute("email", email);
        model.addAttribute("soDT", soDT);
        model.addAttribute("diaChi", diaChi);
        
        return "search-basic";
    }
    
    // Search Graduation and Job Info
    @GetMapping("/search/advanced")
    public String showAdvancedSearchForm(Model model) {
        return "search-advanced";
    }
    
    @PostMapping("/search/advanced")
    public String searchAdvancedInfo(@RequestParam(required = false) String hoTen,
                                     @RequestParam(required = false) String tenTruong,
                                     @RequestParam(required = false) String tenNganh,
                                     @RequestParam(required = false) String tenCongTy,
                                     Model model) {
        
        List<TotNghiep> graduationInfo = studentService.searchGraduationInfo(hoTen, tenTruong, tenNganh);
        List<CongViec> jobInfo = studentService.searchJobInfo(hoTen, tenCongTy, tenNganh);
        
        model.addAttribute("graduationInfo", graduationInfo);
        model.addAttribute("jobInfo", jobInfo);
        model.addAttribute("searchPerformed", true);
        
        // Keep search values in form
        model.addAttribute("hoTen", hoTen);
        model.addAttribute("tenTruong", tenTruong);
        model.addAttribute("tenNganh", tenNganh);
        model.addAttribute("tenCongTy", tenCongTy);
        
        return "search-advanced";
    }
}
