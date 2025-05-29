package com.example.sinhvien.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CongViecId implements Serializable {
    private String soCMND;
    private LocalDate ngayVaoCongTy;
    
    public CongViecId() {}
    
    public CongViecId(String soCMND, LocalDate ngayVaoCongTy) {
        this.soCMND = soCMND;
        this.ngayVaoCongTy = ngayVaoCongTy;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CongViecId that = (CongViecId) o;
        return Objects.equals(soCMND, that.soCMND) &&
               Objects.equals(ngayVaoCongTy, that.ngayVaoCongTy);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(soCMND, ngayVaoCongTy);
    }
}
