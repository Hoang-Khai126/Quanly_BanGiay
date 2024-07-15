CREATE DATABASE QL_BAN_GIAY_08;
GO
USE QL_BAN_GIAY_08;

GO
CREATE TABLE NhanVien (
    MaNV CHAR(10) NOT NULL,
    TenNV NVARCHAR(30) NOT NULL,
    DiaChi NVARCHAR(30),
    GioiTinh NVARCHAR(5),
	Luong FLOAT,
    Sdt VARCHAR(15),
    Email VARCHAR(20),
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_NhanVien PRIMARY KEY (MaNV)
);

GO
CREATE TABLE TaiKhoan (
	MaNV CHAR(10) NOT NULL,
    TenDN varchar(40) NOT NULL,
    MatKhau varchar(40) NOT NULL,
    ChucVu varchar(40) NOT NULL,
    TrangThai NVARCHAR(20),
	CONSTRAINT pk_TaiKhoan PRIMARY KEY (TenDN),
	CONSTRAINT fk_TaiKhoan_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
);

GO
CREATE TABLE LoaiSP (
    MaLoai CHAR(10) NOT NULL,
    TenLoai NVARCHAR(50) NOT NULL,
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_LoaiSP PRIMARY KEY (MaLoai)
);

GO
CREATE TABLE NhaCC (
    MaNCC CHAR(10) NOT NULL,
    TenNCC NVARCHAR(50),
    DiaChi NVARCHAR(30),
    Sdt VARCHAR(15),
    Email VARCHAR(20),
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_NhaCC PRIMARY KEY (MaNCC)
);

GO
CREATE TABLE SanPham (
    MaSP CHAR(10) Not null,
    TenSP NVARCHAR(50) not null,
    SoLuong INT,
    GiaNhap FLOAT, -- Thêm giá nhập
    GiaBan FLOAT,
    Hinh VARCHAR(50),
    MaLoai CHAR(10),
	MaNCC CHAR(10),
    Mota NVARCHAR(50),
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_SanPham PRIMARY KEY (MaSP),
    CONSTRAINT fk_SanPham_LoaiSP FOREIGN KEY (MaLoai) REFERENCES LoaiSP (MaLoai),
    CONSTRAINT fk_SanPham_MaNhaCC FOREIGN KEY (MaNCC) REFERENCES NhaCC (MaNCC)
);

GO
CREATE TABLE MauSP (
    MaMau CHAR(10) Not null,
    TenMau NVARCHAR(20) not null,
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_Mau PRIMARY KEY (MaMau)
);

GO
CREATE TABLE Size (
    MaSize CHAR(10) Not null,
    TenSize VARCHAR(20) not null,
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_Size PRIMARY KEY (MaSize)
);

GO
CREATE TABLE ChiTiet_SanPham (
    MaSP CHAR(10) Not null,
    MaMau CHAR(10) Not null,
    MaSize CHAR(10) Not null,
    SoLuong INT,
    MaCTSP CHAR(10) UNIQUE,
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_ChiTiet_SanPham PRIMARY KEY (MaSP, MaMau, MaSize),
    CONSTRAINT fk_CTSP_SP FOREIGN KEY (MaSP) REFERENCES SanPham (MaSP),
    CONSTRAINT fk_CTSP_Mau FOREIGN KEY (MaMau) REFERENCES MauSP (MaMau),
    CONSTRAINT fk_CTSP_Size FOREIGN KEY (MaSize) REFERENCES Size(MaSize)
);

GO
CREATE TABLE KhachHang (
    MaKH CHAR(10),
    TenKH NVARCHAR(30),
    DiaChi NVARCHAR(30),
    Sdt VARCHAR(15),s
    Email VARCHAR(20),
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_KhachHang PRIMARY KEY (MaKH)
);

GO
CREATE TABLE HoaDon (
    MaHD CHAR(10),
    MaKH CHAR(10),
    MaNV CHAR(10),
    NgayLap DATE,
    TongTien FLOAT,
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_HoaDon PRIMARY KEY (MaHD),
    CONSTRAINT fk_HoaDon_KhachHang FOREIGN KEY (MaKH) REFERENCES KhachHang (MaKH),
    CONSTRAINT fk_HoaDon_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien (MaNV)
);

GO
CREATE TABLE ChiTiet_HoaDon (
    MaCTSP CHAR(10) UNIQUE,
    MaHD CHAR(10) UNIQUE,
    SoLuong INT,
    ThanhTien FLOAT,
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_CTHD PRIMARY KEY (MaHD, MaCTSP),
    CONSTRAINT fk_CTHD_CTSP FOREIGN KEY (MaCTSP) REFERENCES ChiTiet_SanPham (MaCTSP),
    CONSTRAINT fk_CTHD_HD FOREIGN KEY (MaHD) REFERENCES HoaDon (MaHD)
);

GO

CREATE TABLE PhieuNhap (
    MaPN CHAR(10),
    MaNCC CHAR(10),
    MaNV CHAR(10),
    NgayLap DATE,
    TongTien FLOAT,
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_PhieuNhap PRIMARY KEY (MaPN),
    CONSTRAINT fk_PhieuNhap_NhaCC FOREIGN KEY (MaNCC) REFERENCES NhaCC (MaNCC),
    CONSTRAINT fk_PhieuNhap_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien (MaNV)
);
GO
CREATE TABLE ChiTiet_PhieuNhap (
    MaCTSP CHAR(10) UNIQUE,
    MaPN CHAR(10),
    SoLuong INT,
    GiaNhap FLOAT, -- Thêm giá nhập
    ThanhTien FLOAT,
    TrangThai NVARCHAR(20), -- Thuộc tính trạng thái
    CONSTRAINT pk_CTPN PRIMARY KEY (MaPN, MaCTSP),
    CONSTRAINT fk_CTPN_CTSP FOREIGN KEY (MaCTSP) REFERENCES ChiTiet_SanPham (MaCTSP),
    CONSTRAINT fk_CTPN_PN FOREIGN KEY (MaPN) REFERENCES PhieuNhap (MaPN)
);


GO


------TRIGGER

--Trigger này có thể kiểm tra xem dữ liệu được chèn vào bảng SanPham có hợp lệ không, ví dụ: giá nhập và giá bán phải lớn hơn hoặc bằng 0.
CREATE OR ALTER TRIGGER trg_Check_SanPham_Price
ON SanPham
AFTER INSERT
AS
BEGIN
    -- Check if the inserted prices are valid
    IF EXISTS (
        SELECT 1
        FROM inserted
        WHERE GiaNhap < 0 OR GiaBan < 0
    )
    BEGIN
        RAISERROR ('Invalid prices. Prices must be greater than or equal to 0.', 16, 1)
        ROLLBACK TRANSACTION;
        RETURN;
    END
END;


--Trigger tự động cập nhật số lượng trong bảng ChiTiet_SanPham khi có sự thay đổi số lượng trong bảng SanPham
CREATE OR ALTER TRIGGER trg_Update_ChiTiet_SanPham_Quantity
ON SanPham
AFTER UPDATE
AS
BEGIN
    -- Update quantity in ChiTiet_SanPham based on changes in SanPham
    UPDATE ChiTiet_SanPham
    SET ChiTiet_SanPham.SoLuong = i.SoLuong
    FROM ChiTiet_SanPham c
    INNER JOIN inserted i ON c.MaSP = i.MaSP
END;


--Trigger tự động cập nhật tổng tiền trong bảng HoaDon khi có sự thay đổi số lượng hoặc giá của sản phẩm trong bảng ChiTiet_HoaDon**:
CREATE OR ALTER TRIGGER trg_Update_HoaDon
ON ChiTiet_HoaDon
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    UPDATE HoaDon
    SET TongTien = (
        SELECT SUM(SoLuong * ThanhTien)
        FROM ChiTiet_HoaDon
        WHERE ChiTiet_HoaDon.MaHD = HoaDon.MaHD
    )
    WHERE EXISTS (
        SELECT 1
        FROM inserted
        WHERE inserted.MaHD = HoaDon.MaHD
    ) OR EXISTS (
        SELECT 1
        FROM deleted
        WHERE deleted.MaHD = HoaDon.MaHD
    )
END;
GO

select * from Mau
--Trigger tự động cập nhật số lượng trong bảng Mau và Size khi có sự thay đổi số lượng trong bảng ChiTiet_SanPham:
CREATE OR ALTER TRIGGER trg_Update_Mau_Size_Quantity
ON ChiTiet_SanPham
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    -- Update quantity in Mau and Size based on changes in ChiTiet_SanPham
    DECLARE @MaSP CHAR(10), @MaMau CHAR(10), @MaSize CHAR(10), @SoLuong INT;

    -- Check if there are any inserted or deleted rows in ChiTiet_SanPham
    IF EXISTS(SELECT * FROM inserted) OR EXISTS(SELECT * FROM deleted)
    BEGIN
        -- Iterate through inserted and deleted rows
        DECLARE cur CURSOR FOR
        SELECT MaSP, MaMau, MaSize, SoLuong
        FROM inserted
        UNION
        SELECT MaSP, MaMau, MaSize, SoLuong
        FROM deleted;

        OPEN cur;
        FETCH NEXT FROM cur INTO @MaSP, @MaMau, @MaSize, @SoLuong;
        WHILE @@FETCH_STATUS = 0
        BEGIN
            -- Update quantity in Mau table
            UPDATE Mau
            SET SoLuong = SoLuong - @SoLuong
            WHERE MaMau = @MaMau;

            -- Update quantity in Size table
            UPDATE Size
            SET SoLuong = SoLuong - @SoLuong
            WHERE MaSize = @MaSize;

            FETCH NEXT FROM cur INTO @MaSP, @MaMau, @MaSize, @SoLuong;
        END;
        CLOSE cur;
        DEALLOCATE cur;
    END;
END;
GO


--Function
--Function tính tổng tiền của một hóa đơn: Function này nhận vào mã hóa đơn và trả về tổng tiền của hóa đơn đó bằng cách tính tổng giá của từng sản phẩm trong hóa đơn.
CREATE OR ALTER FUNCTION dbo.GetTotalAmountOfInvoice
(
    @MaHD CHAR(10)
)
RETURNS FLOAT
AS
BEGIN
    DECLARE @TotalAmount FLOAT;

    SELECT @TotalAmount = SUM(SoLuong * ThanhTien)
    FROM ChiTiet_HoaDon
    WHERE MaHD = @MaHD;

    RETURN ISNULL(@TotalAmount, 0);
END;

DECLARE @MaHD CHAR(10);
SET @MaHD = 'YourInvoiceID';

SELECT dbo.GetTotalAmountOfInvoice(@MaHD) AS TotalAmount;


--Function kiểm tra tồn kho của sản phẩm: Function này nhận vào mã sản phẩm và trả về số lượng tồn kho hiện tại của sản phẩm đó.
CREATE OR ALTER FUNCTION dbo.GetInventoryQuantityOfProduct
(
    @MaSP CHAR(10)
)
RETURNS INT
AS
BEGIN
    DECLARE @InventoryQuantity INT;

    SELECT @InventoryQuantity = SUM(SoLuong)
    FROM ChiTiet_SanPham
    WHERE MaSP = @MaSP;

    RETURN ISNULL(@InventoryQuantity, 0);
END;

DECLARE @MaSP CHAR(10);
SET @MaSP = 'YourProductID';

SELECT dbo.GetInventoryQuantityOfProduct(@MaSP) AS InventoryQuantity;

--Stored procedure


select * from SanPham
select * from ChiTiet_HoaDon
select * from ChiTiet_SanPham
select * from HoaDon
-- Nhập dữ liệu cho bảng NhanVien
INSERT INTO NhanVien (MaNV, TenNV, DiaChi, GioiTinh, Luong, Sdt, Email, TrangThai)
VALUES ('NV001', 'Nguyễn Văn A', 'Hà Nội', 'Nam', 5000, '0123456789', 'nv.a@example.com', 'Đang làm việc');

INSERT INTO NhanVien (MaNV, TenNV, DiaChi, GioiTinh, Luong, Sdt, Email, TrangThai)
VALUES ('NV002', 'Trần Thị B', 'Hồ Chí Minh', 'Nữ', 6000, '0987654321', 'nv.b@example.com', 'Đang làm việc');

-- Nhập dữ liệu cho bảng TaiKhoan
INSERT INTO TaiKhoan (MaNV, TenDN, MatKhau, ChucVu, TrangThai)
VALUES ('NV001', 'nva', '123456', 'Quản lý', 'Đang làm việc');

INSERT INTO TaiKhoan (MaNV, TenDN, MatKhau, ChucVu, TrangThai)
VALUES ('NV002', 'nvb', '654321', 'Nhân viên', 'Đang làm việc');

-- Nhập dữ liệu cho bảng LoaiSP
INSERT INTO LoaiSP (MaLoai, TenLoai, TrangThai)
VALUES ('LSP001', 'Điện thoại', 'Hoạt động');

INSERT INTO LoaiSP (MaLoai, TenLoai, TrangThai)
VALUES ('LSP002', 'Laptop', 'Hoạt động');

-- Nhập dữ liệu cho bảng NhaCC
INSERT INTO NhaCC (MaNCC, TenNCC, DiaChi, Sdt, Email, TrangThai)
VALUES ('NCC001', 'Samsung', 'Hàn Quốc', '0123456789', 'samsung@example.com', 'Hoạt động');

INSERT INTO NhaCC (MaNCC, TenNCC, DiaChi, Sdt, Email, TrangThai)
VALUES ('NCC002', 'Apple', 'Mỹ', '0987654321', 'apple@example.com', 'Hoạt động');

-- Nhập dữ liệu cho bảng SanPham
INSERT INTO SanPham (MaSP, TenSP, SoLuong, GiaNhap, GiaBan, Hinh, MaLoai, MaNCC, MoTa, TrangThai)
VALUES ('SP001', 'iPhone 12', 10, 1000, 1200, 'iphone12.jpg', 'LSP001', 'NCC002', 'Điện thoại di động', 'Hoạt động');

INSERT INTO SanPham (MaSP, TenSP, SoLuong, GiaNhap, GiaBan, Hinh, MaLoai, MaNCC, MoTa, TrangThai)
VALUES ('SP002', 'Samsung Galaxy S21', 8, 900, 1100, 'galaxys21.jpg', 'LSP001', 'NCC001', 'Điện thoại di động', 'Hoạt động');

-- Nhập dữ liệu cho bảng MauSP
INSERT INTO MauSP (MaMau, TenMau, TrangThai)
VALUES ('MSP001', 'Đen', 'Hoạt động');

INSERT INTO MauSP (MaMau, TenMau, TrangThai)
VALUES ('MSP002', 'Trắng', 'Hoạt động');

-- Nhập dữ liệu cho bảng Size
INSERT INTO Size (MaSize, TenSize, TrangThai)
VALUES ('SZ001', 'S', 'Hoạt động');

INSERT INTO Size (MaSize, TenSize, TrangThai)
VALUES ('SZ002', 'M', 'Hoạt động');



-- tigger
-- thủ tục 
-----khach hang


-- thủ tục hiển thị danh sách khách hàng
CREATE PROC danhsachKH01 as
select * from KhachHang where TrangThai =0;
exec danhsachKH01

-- thủ tục tìm kiếm khách hàng
create proc TimKiemKH (@GiaTriCanTim nvarchar(20)) as
SELECT * FROM KhachHang WHERE (MaKH = @GiaTriCanTim OR TenKH LIKE N'%' + @GiaTriCanTim + '%') AND TrangThai = 0;
exec TimKiemKH N'kh01'

CREATE PROCEDURE sinhmaKhachHang AS
BEGIN
	IF ((SELECT COUNT(*) FROM KhachHang) = 0)
		SELECT 'KH0000' AS TenDN;
	ELSE
		SELECT TOP 1 MaKH FROM KhachHang ORDER BY MaKH DESC;
END;
GO

--Thủ tục thêm khách hàng
CREATE PROC ThemKH(@MaKH CHAR(10), @TenKH NVARCHAR(30),@DiaChi NVARCHAR(30),@Sdt VARCHAR(15),@Email VARCHAR(20) ) as
insert into KhachHang values (@MaKH,@TenKH,@DiaChi,@Sdt,@Email,0);
exec ThemKH 'KH07','Đào Ngọc Ti', '152 Cà Mau', '0965321478','UU@gmail.com'

-- thủ tục sửa khachhang
create proc SuaKhachHang(@MaKH CHAR(10), @TenKH NVARCHAR(30),@DiaChi NVARCHAR(30),@Sdt VARCHAR(15),@Email VARCHAR(20) ) as
update KhachHang set TenKH = @TenKH,DiaChi = @DiaChi, Sdt = @Sdt, Email = @Email where MaKH = @MaKH;
exec SuaKhachHang 'KH01','Nguyễn Văn Phát','123 Tây Ninh','0254136589','HH@gmail.com'

-- thủ tục xóa khách hàng
create proc XoaKhachHang(@makh varchar(10)) as
update KhachHang set TrangThai = 1 where MaKH = @MaKH;

exec XoaKhachHang 'kh02'

select * from KhachHang

INSERT INTO KhachHang VALUES ('KH05','Nguyen Hong Anh','254 Bến Tre','0365214789','pp@gmail.com',0)

--Thủ tục hiển thị danh sách tài khoản
CREATE PROC dsTaiKhoan as
select * from TaiKhoan where TrangThai =0;
exec dsTaiKhoan

-- thủ tục tìm kiếm tài khoản
create proc TimtaiKhoan (@GiaTriCanTim nvarchar(20)) as
SELECT * FROM TaiKhoan WHERE TenDN = @GiaTriCanTim AND TrangThai = 0;
exec TimtaiKhoan N'user1'


--Thủ tục thêm tài khoản
create proc Themtaikhoan(@TenDN NVARCHAR(30),@MatKhau CHAR(10) ) as
insert into TaiKhoan values (@TenDN, @MatKhau,0);
exec Themtaikhoan 'user4',N'mk01'
go

--Thủ tục sủa tài khoản
create proc SuaTaiKhoan(@TenDN NVARCHAR(30),@MatKhau CHAR(10)) as
update TaiKhoan set MatKhau = @MatKhau where TenDN = @TenDN;
exec SuaTaiKhoan 'user1','mkuser1'


--Thủ tục xóa tài khoản
-- thủ tục xóa nhân viên -> hoàn thành
create proc XoaTaiKhoan(@TenDN varchar(10)) as
update TaiKhoan set TrangThai = 1 where TenDN = @TenDN;
exec XoaTaiKhoan 'user4'
GO

CREATE PROCEDURE kiemTraMatKhau
    @matKhau NVARCHAR(255)
AS
BEGIN
    IF EXISTS (SELECT 1 FROM TaiKhoan WHERE MatKhau = @matKhau)
    BEGIN
        SELECT 1 AS Result;
    END
    ELSE
    BEGIN
        SELECT 0 AS Result;
    END
END
GO



select * from TaiKhoan
---------------------------------------------------------------------------------------------
GO
--sinh mã tài khoản
CREATE PROCEDURE sinhmatk AS
BEGIN
	IF ((SELECT COUNT(*) FROM TaiKhoan) = 0)
		SELECT 'TK0000' AS TenDN;
	ELSE
		SELECT TOP 1 TenDN FROM TaiKhoan ORDER BY TenDN DESC;
END;
GO

--------------------------------------------------------------------
select * from Size 

-- thủ tục tìm kiếm tài khoản
create proc TimSize ( @tenSize nvarchar(20)) as
SELECT * FROM Size WHERE (TenSize = @tenSize ) AND TrangThai = 0;

exec TimSize 'm'



--sinh mã Size giay
alter PROCEDURE sinhmaSizeGiay AS
BEGIN
	IF ((SELECT COUNT(*) FROM Size) = 0)
		SELECT 'S0000' AS MaSize;
	ELSE
		SELECT TOP 1 MaSize FROM Size ORDER BY MaSize DESC;
END;
GO


---Kiem tra teen Size trung
CREATE PROCEDURE kiemTraTenSizeTrung
    @tenSize NVARCHAR(255)
AS
BEGIN
    IF EXISTS (SELECT 1 FROM Size WHERE TenSize = @tenSize)
    BEGIN
        SELECT 1 AS Result;
    END
    ELSE
    BEGIN
        SELECT 0 AS Result;
    END
END
GO

--Thủ tục thêm khách hàng
CREATE PROC ThemSize(@MaSize CHAR(10), @TenSize NVARCHAR(30),@soluong int ) as
insert into Size values (@MaSize,@TenSize,@soluong,0);
exec ThemSize's007','xxl',300;

-- thủ tục sửa khachhang
create proc SuaSize(@MaSize CHAR(10), @TenSize NVARCHAR(30),@soluong int ) as
update Size set TenSize = @TenSize, SoLuong = @soluong where MaSize = @MaSize;
exec SuaSize's007','xxxxl',300;

-- thủ tục xóa khách hàng
create proc XoaSize(@maSize varchar(10)) as
update Size set TrangThai = 1 where MaSize = @maSize;
exec XoaSize 's007'

--------------------------------------------------------------------------------------------------------------------------------------------------

--Thủ tục hiện thị danh sách nhân viên
CREATE PROC danhsachnhanvien1 as
select * from NhanVien where TrangThai =0;
exec danhsachnhanvien1

-- thủ tục tìm kiếm nhân viên
create proc TimKiemNV (@GiaTriCanTim nvarchar(20)) as
SELECT * FROM NhanVien WHERE (MaNV = @GiaTriCanTim OR TenNV LIKE N'%' + @GiaTriCanTim + '%') AND TrangThai = 0;
exec TimKiemNV N'nv01'

-- thủ tục thêm nhân viên -> hoàn thành
alter proc themnhanvien(@MaNV CHAR(10), @TenNV NVARCHAR(30),@DiaChi NVARCHAR(30),@GioiTinh NVARCHAR(15),@Sdt VARCHAR(15),@Email VARCHAR(20),@luong FLOAT) as
insert into NhanVien values (@MaNV, @TenNV,@DiaChi,@GioiTinh,@Sdt,@Email,0,@luong);
exec themnhanvien 'NV005',N'Cam','369 long an',N'nữ','0254136987','Wk@gmail.com',414141
go

-- Thủ tục kiểm tra mã nhân viên
CREATE PROCEDURE KiemTraTonTaiMaNV(@MaNV CHAR(10), @Exists BIT OUTPUT) AS
BEGIN
    IF EXISTS (SELECT 1 FROM NhanVien WHERE MaNV = @MaNV)
        SET @Exists = 1;
    ELSE
        SET @Exists = 0;
END	
go

-- thủ tục sửa nhân viên -> hoàn thành
alter proc SuaNhanVien(@MaNV CHAR(10), @TenNV NVARCHAR(30),@DiaChi NVARCHAR(30),@GioiTinh NVARCHAR(15),@Sdt VARCHAR(15),@Email VARCHAR(20),@luong float) as
update NhanVien set TenNV = @TenNV,DiaChi = @DiaChi,GioiTinh =@GioiTinh,Sdt = @Sdt, Email = @Email,Luong=@luong where MaNV = @MaNV;
exec SuaNhanVien 'NV01','Nguyễn Minh Hào','258 Cần Thơ','Nam','0236514789','WW@gmail.com'

-- thủ tục xóa nhân viên -> hoàn thành
create proc XoaNhanVien(@maNV varchar(10)) as
update NhanVien set TrangThai = 1 where MaNV = @maNV;
exec XoaNhanVien 'nv03'

select * from NhanVien
--delete from NhanVien where MaNV = 'nv0022';
--sinh ma nhan vien
CREATE PROCEDURE sinhmaNhanVien AS
BEGIN
	IF ((SELECT COUNT(*) FROM NhanVien) = 0)
		SELECT 'NV0000' AS TenNV;
	ELSE
		SELECT TOP 1 MaNV FROM NhanVien ORDER BY MaNV DESC;
END;
GO
SP_HELP Nhanvien

-------------------TỪ đây-----------------
--sinh ma ctsp
CREATE PROCEDURE sinhmaChiTietSP AS
BEGIN
	IF ((SELECT COUNT(*) FROM ) = 0)
		SELECT 'NV0000' AS TenNV;
	ELSE
		SELECT TOP 1 MaNV FROM NhanVien ORDER BY MaNV DESC;
END;
GO

SP_HELP Nhanvien
SET DATEFORMAT dmy; 
select * from HoaDon
--

create proc TimKiemSP (@GiaTriCanTim nvarchar(20)) as
SELECT * FROM SanPham WHERE (MaSP = @GiaTriCanTim OR TenSP LIKE N'%' + @GiaTriCanTim + '%');
exec TimKiemSP 'SP001'

-- thủ tục thêm sản phẩm
create proc ThemSanPham(@MaSP CHAR(10), @TenSP NVARCHAR(100), @SL INT, @GiaNhap float, @giaBan Float, @hinh varchar(50), @MaLoai char(10), @MaNCC char(10), @Mota nvarchar(100), @trangthai nvarchar(40)) as
insert into sanpham values (@MaSP,@TenSP,@SL,@GiaNhap,@giaBan,@hinh,@MaLoai,@MaNCC,@Mota,@trangthai);


--Thủ tục thêm sản phẩm mới vào cơ sở dữ liệu:
CREATE PROCEDURE sp_ThemSanPham
    @MaSP CHAR(10),
    @TenSP NVARCHAR(50),
    @SoLuong INT,
    @GiaNhap FLOAT,
    @GiaBan FLOAT,
    @Hinh VARCHAR(50),
    @MaLoai CHAR(10),
    @MaNCC CHAR(10),
    @Mota NVARCHAR(MAX)
AS
BEGIN
    INSERT INTO SanPham (MaSP, TenSP, SoLuong, GiaNhap, GiaBan, Hinh, MaLoai, MaNCC, Mota, TrangThai)
    VALUES (@MaSP, @TenSP, @SoLuong, @GiaNhap, @GiaBan, @Hinh, @MaLoai, @MaNCC, @Mota, 'Active')
END
GO

--Thủ tục cập nhật thông tin sản phẩm:
CREATE PROCEDURE sp_CapNhatSanPham
    @MaSP CHAR(10),
    @TenSP NVARCHAR(50),
    @SoLuong INT,
    @GiaNhap FLOAT,
    @GiaBan FLOAT,
    @Hinh VARCHAR(50),
    @MaLoai CHAR(10),
    @MaNCC CHAR(10),
    @Mota NVARCHAR(MAX)
AS
BEGIN
    UPDATE SanPham
    SET TenSP = @TenSP, SoLuong = @SoLuong, GiaNhap = @GiaNhap, GiaBan = @GiaBan, Hinh = @Hinh, MaLoai = @MaLoai, MaNCC = @MaNCC, Mota = @Mota
    WHERE MaSP = @MaSP
END
GO


--Thủ tục lấy danh sách sản phẩm theo loại:
CREATE PROCEDURE sp_LaySanPhamTheoLoai
    @MaLoai CHAR(10)
AS
BEGIN
    SELECT *
    FROM SanPham
    WHERE MaLoai = @MaLoai
END
GO



select * from ChiTiet_HoaDon
sp_help ChiTiet_HoaDon
-------------------------------------CHI TIET HOA DON--------------------------------------------------------
GO
--Thủ tục hiện thị danh sách chi tiết hoá đơn
CREATE PROC danhSachChiTietHD as
select * from ChiTiet_HoaDon 
where TrangThai =0;
exec danhsachnhanvien1
--Thủ tục hiện thị danh sách chi tiết hoá đơn theo mã
CREATE PROC danhSachChiTietHDTheoMa(@MaHD char(10))as
select * from ChiTiet_HoaDon 
where MaHD=@MaHD
where TrangThai =0;
exec danhsachnhanvien1
sp_help chiTiet_HoaDOn
select * from ChiTiet_HoaDon
--Thủ tục tạo hoá đơn mới ct hoá đơn:
CREATE or alter PROCEDURE ThemCTHoaDon
    @MaCTSP CHAR(10),
    @MaHD CHAR(10),
    @SoLuong int,
    @ThanhTien Float
AS
BEGIN
    INSERT INTO ChiTiet_HoaDon (MaCTSP, MaHD, SoLuong, ThanhTien, TrangThai)
    VALUES (@MaCTSP, @MaHD, @SoLuong, @ThanhTien,0)
END
GO



-------------------Hoá đơn--------------
select * from hoadon
CREATE or alter PROCEDURE sinhmaHoaDon AS
BEGIN
	IF ((SELECT COUNT(*) FROM HoaDon) = 0)
		SELECT 'HD0000' AS MAHD;
	ELSE
		SELECT TOP 1 MaHD FROM HoaDon ORDER BY MaHD DESC;
END;

--Thủ tục tạo hoá đơn mới:
CREATE or alter PROCEDURE ThemHoaDon
    @MaHD CHAR(10),
    @MaKH CHAR(10),
    @MaNV CHAR(10),
    @NgayLap DATE,
    @TongTien FLOAT
AS
BEGIN
    INSERT INTO HoaDon (MaHD, MaKH, MaNV, NgayLap, TongTien, TrangThai)
    VALUES (@MaHD, @MaKH, @MaNV, @NgayLap, @TongTien, 0)
END
GO
exec ThemHoaDon 'HD0006','KH001','NV001','2023-11-03',4560.60
select * from KhachHang

select * from LoaiSP
select * from ChiTiet_SanPham
select * from HoaDon
select * from Size
select * from KhachHang
----Mau-----
--ctsp--
--Thủ tục lấy chi tiết sản phẩm theo mã sản phẩm:
CREATE PROCEDURE proc_LayCTSanPhamTheoMaSP
    @MaCTSP CHAR(10)
AS
BEGIN
    SELECT *
    FROM ChiTiet_SanPham
    WHERE MaCTSP = @MaCTSP
END
GO

create proc SuaHoaDon
	@MaHD CHAR(10),
    @MaKH CHAR(10),
    @MaNV CHAR(10),
    @NgayLap DATE
as
update HoaDon set MaKH = @MaKH,MaNV = @MaNV, NgayLap=@NgayLap
where MaHD = @MaHD;
select * from SanPham
select * from ChiTiet_SanPham
select * from HoaDon
s

delete ChiTiet_HoaDon
delete HoaDon
select * from HoaDon

exec SuaHoaDon 'HD0002','KH002','NV001','2023-11-02'

---Tao trigger 
select * from ChiTiet_HoaDon
sp_help ChiTiet_HoaDon
exec proc_LayCTSanPhamTheoMaSP 'CTSP002'
select * from ChiTiet_SanPham
select * from HoaDon
select * from ChiTiet_HoaDon
select * from PhieuNhap
select * from SanPham
select * from Mau
select * from Size
