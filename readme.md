II. Mô tả chung về bài toán:
Bộ giáo dục đào tạo có nhu cầu cần một hệ thống website để quản lý thống kê việc làm của sinh viên khi tốt nghiệp của tất cả các trường đại học, cao đẳng, trung cấp nghề trên toàn quốc, hệ thống nhằm giúp xã hội: "Điều chỉnh cơ cấu đào tạo theo hướng giảm dần các ngành nghề đang dư thừa trên thị trường lao động, tăng cường đào tạo các ngành có nhu cầu cao của thị trường. Kiểm soát quy mô đào tạo theo hướng giảm chỉ tiêu các ngành ít có nhu cầu tuyển dụng và chất lượng thấp".
Yêu cầu của hệ thống là các sinh viên sau khi tốt nghiệp một năm phải khai báo thông tin về trường tốt nghiệp và thông tin về việc làm cho bộ giáo dục.
Mô tả quan hệ dữ liệu:
Một sinh viên có thể tốt nghiệp một nghành của một trường bất kỳ. Ngoài ra, một sinh viên có thể tốt nghiệp nhiều nghành của nhiều trường khác nhau (trường hợp sinh viên đã có nhiều bằng cấp)
Sau khi tốt nghiệp thì sinh viên có thể làm nhiều công việc ở các công ty khác nhau, một công việc sẽ tương ứng với một ngành nào đó, có thể là ngành sinh viên đã tốt nghiệp hoặc làm việc trái ngành (không phải là ngành sinh viên đó tốt nghiệp).

CREATE TABLE TRUONG (
    MaTruong VARCHAR(20) PRIMARY KEY,
    TenTruong VARCHAR(100),
    DiaChi VARCHAR(200),
    SoDT VARCHAR(15)
);

CREATE TABLE NGANH (
    MaNganh VARCHAR(20) PRIMARY KEY,
    TenNganh VARCHAR(100),
    LoaiNganh VARCHAR(50)
);
CREATE TABLE SINHVIEN (
    SoCMND VARCHAR(20) PRIMARY KEY,
    HoTen VARCHAR(100),
    Email VARCHAR(100),
    SoDT VARCHAR(15),
    DiaChi VARCHAR(200)
);

CREATE TABLE TOT_NGHIEP (
    SoCMND VARCHAR(20),
    MaTruong VARCHAR(20),
    MaNganh VARCHAR(20),
    HeTN VARCHAR(50),
    NgayTN DATE,
    LoaiTN VARCHAR(50),
    PRIMARY KEY (SoCMND, MaTruong, MaNganh),
    FOREIGN KEY (SoCMND) REFERENCES SINHVIEN(SoCMND),
    FOREIGN KEY (MaTruong) REFERENCES TRUONG(MaTruong),
    FOREIGN KEY (MaNganh) REFERENCES NGANH(MaNganh)
);

CREATE TABLE CONG_VIEC (
    SoCMND VARCHAR(20),
    NgayVaoCongTy DATE,
    MaNganh VARCHAR(20),
    TenCongTy VARCHAR(100),
    DiaChiCongTy VARCHAR(200),
    ThoiGianLamViec INT,
    PRIMARY KEY (SoCMND, NgayVaoCongTy),
    FOREIGN KEY (SoCMND) REFERENCES SINHVIEN(SoCMND),
    FOREIGN KEY (MaNganh) REFERENCES NGANH(MaNganh)
);
* Yêu cầu 2 (4.5 điểm): Tạo trang web có form để nhập (khai báo) thông tin cho một sinh viên sau khi tốt nghiệp vào cơ sở dữ liệu.
Yêu cầu của form nhập thông tin phải có đủ các trường của 2 table "SINHVIEN" và "TOT_NGHIEP"
1. Thí sinh đưa được dữ liệu từ form nhập vào DataBase (2 điểm)
2. Thí sinh thiết kế form có sử dụng thêm ComboBox để lấy thông tin của Trường và Ngành từ 2 bản "TRUONG" và "NGHANH" (1 điểm).
3. Thí sinh có kiểm tra bắt buộc nhập cho các trường SoCMND, MaTruong. MaNganh
(1 điểm)
4. Thí sinh có kiểm tra dữ liệu hợp lệ cho trường Ngày tốt nghiệp (Ngay TN) (0.5 điểm).
* Yêu cầu 3 (2.5 điểm): Tạo 2 trang web có form cho phép tìm kiếm thông tin của sinh viên như sau:
1. Form 1: Tìm kiếm thông tin cơ bản của các sinh viên. (1.5 điểm)
Danh sách kết quả tìm kiếm yêu cầu phải có các thông tin cơ bản: SoCMND, HoTen, Email, SODT, DiaChi của các sinh viên tìm được.
2. Form 2: Tìm kiếm thông tin tốt nghiệp và việc làm của các sinh viên. (1 điểm)
Danh sách của kết quả tìm kiếm yêu cầu phải có các thông tin sau: SoCMND, HoTen, MaNganh (tốt nghiệp). Ma Truong (tốt nghiệp), MaNghanh(công ty), TenCongTy, Thoi GianLam Viec