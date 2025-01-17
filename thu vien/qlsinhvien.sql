USE [QLSINHVIEN]
GO
/****** Object:  User [admin]    Script Date: 17/03/24 12:34:21 AM ******/
CREATE USER [admin] FOR LOGIN [admin] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [ADMIN\Admin]    Script Date: 17/03/24 12:34:21 AM ******/
CREATE USER [ADMIN\Admin] FOR LOGIN [ADMIN\Admin] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [chau]    Script Date: 17/03/24 12:34:21 AM ******/
CREATE USER [chau] FOR LOGIN [chau] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  StoredProcedure [dbo].[ChenDiem_SV]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ChenDiem_SV](@masv nvarchar(10),@diemta float,@diemth float,@diemGD float)
as
begin
    declare @dtb float
	set @dtb=round((@diemta+@diemth+@diemGD)/3,1)
     insert into DiemSV values(@masv,@diemta,@diemth,@diemGD,@dtb,'0')
end
GO
/****** Object:  StoredProcedure [dbo].[ChenDiemSinhVien]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ChenDiemSinhVien](@masv nvarchar(10), @tienganh decimal,@tinhoc decimal ,@giaoduc decimal)
as
begin
	insert into diemsv values(@masv,@tienganh,@tinhoc,@giaoduc,ROUND((@tienganh+@tinhoc+@giaoduc)/3,1),'0')
end
GO
/****** Object:  StoredProcedure [dbo].[ChenDiemSinhvien31]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ChenDiemSinhvien31] (@masv nvarchar(10),@tienganh float,@tinhoc float,@giaoduc float)
	as
		insert into DiemSV values(@masv,@tienganh,@tinhoc,@giaoduc,ROUND((@tienganh+@tinhoc+@giaoduc)/3,1),'0')
GO
/****** Object:  StoredProcedure [dbo].[danhsachdiem]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[danhsachdiem]
as
begin
		select * from DiemSV where trangthai='0'
end
GO
/****** Object:  StoredProcedure [dbo].[danhsachdiemsinhvien]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[danhsachdiemsinhvien]
as
begin
	select d.*,tensv from DiemSV d,sinhvien s where d.masv=s.masv

end
GO
/****** Object:  StoredProcedure [dbo].[Danhsachsinhvien]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Danhsachsinhvien](@masv nvarchar(10))
as
begin
 select * from sinhvien where masv=@masv
end
GO
/****** Object:  StoredProcedure [dbo].[TimKiemsinhvien]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[TimKiemsinhvien](@masv nvarchar(10))
as
begin
 select * from sinhvien where masv=@masv
end
GO
/****** Object:  StoredProcedure [dbo].[Timkiemsinhvien31]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Timkiemsinhvien31] @masv nvarchar(10)
as
	begin
		select * from sinhvien
		where masv=@masv
	end
GO
/****** Object:  StoredProcedure [dbo].[timkiemsv_theomasv]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[timkiemsv_theomasv](@masv nvarchar(10))
as
begin
	select * from sinhvien
	where masv=@masv
end
GO
/****** Object:  StoredProcedure [dbo].[xoadiem_sv]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[xoadiem_sv](@masv nvarchar(10))
as
begin
		update DiemSV 
		set trangthai='1'
		where masv=@masv
end
GO
/****** Object:  Table [dbo].[banga]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[banga](
	[masv] [nvarchar](10) NOT NULL,
	[tensv] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[SoDT] [nvarchar](15) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[diachi] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DiemSV]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiemSV](
	[masv] [nvarchar](10) NULL,
	[tienganh] [decimal](2, 1) NULL,
	[tinhoc] [decimal](2, 1) NULL,
	[giaoduc] [decimal](2, 1) NULL,
	[diemtb] [decimal](2, 1) NULL,
	[trangthai] [nvarchar](10) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[sinhvien]    Script Date: 17/03/24 12:34:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sinhvien](
	[masv] [nvarchar](10) NOT NULL,
	[tensv] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[SoDT] [nvarchar](15) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[diachi] [nvarchar](50) NULL,
	[hinh] [nvarchar](50) NULL,
 CONSTRAINT [pk_masv] PRIMARY KEY CLUSTERED 
(
	[masv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[banga] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi]) VALUES (N'sv001', N'Huỳnh minh long', N'hmlong@gmail.com', N'0911112222', N'nam', N'567 trần hưng đạo,p5, q5')
INSERT [dbo].[banga] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi]) VALUES (N'sv002', N'Lê Minh Nam', N'lnnam@gmail.com', N'0922222222', N'nam', N'345/2 trần bình trọng p5 q5')
INSERT [dbo].[banga] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi]) VALUES (N'sv003', N'Trần Ngọc Linh', N'tnlinh@gmail.com', N'0933333333', N'nữ', N'123/2a trần bình trọng p5 q5')
INSERT [dbo].[banga] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi]) VALUES (N'sv004', N'Vu ngọc lan', N'vnlan@gmail.com', N'0944445555', N'nữ', N'3 dht2 p.tân hưng thuận, q12')
INSERT [dbo].[banga] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi]) VALUES (N'sv005', N'Nguyễn Đăng Khoa ', N'ndkhoa@gmail.com', N'0955556666', N'nam', N'345 đường dht3, p.Đông Hưng Thuận, Q12')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv001', CAST(5.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), N'1')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv002', CAST(7.0 AS Decimal(2, 1)), CAST(5.0 AS Decimal(2, 1)), CAST(8.0 AS Decimal(2, 1)), CAST(6.7 AS Decimal(2, 1)), N'0')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv003', CAST(8.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), N'0')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv004', CAST(6.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(8.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), N'0')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv005', CAST(7.0 AS Decimal(2, 1)), CAST(8.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(7.3 AS Decimal(2, 1)), N'0')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv007', CAST(5.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), N'0')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv008', CAST(5.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), N'0')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv009', CAST(8.0 AS Decimal(2, 1)), CAST(8.0 AS Decimal(2, 1)), CAST(8.0 AS Decimal(2, 1)), CAST(8.0 AS Decimal(2, 1)), N'0')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'SV001', CAST(5.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), N'1')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv001', CAST(5.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), N'1')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv001', CAST(5.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), CAST(7.0 AS Decimal(2, 1)), CAST(6.0 AS Decimal(2, 1)), N'1')
INSERT [dbo].[DiemSV] ([masv], [tienganh], [tinhoc], [giaoduc], [diemtb], [trangthai]) VALUES (N'sv006', CAST(2.0 AS Decimal(2, 1)), CAST(3.0 AS Decimal(2, 1)), CAST(4.0 AS Decimal(2, 1)), CAST(3.0 AS Decimal(2, 1)), N'0')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv001', N'Huỳnh minh long', N'hmlong@gmail.com', N'0911112222', N'nam', N'567 trần hưng đạo,p5, q5fsdf', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv002', N'Lê Minh Nam', N'lnnam@gmail.com', N'0922222222', N'nam', N'345/2 trần bình trọng p5 q5', N'sv002.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv003', N'Trần Ngọc Linh', N'tnlinh@gmail.com', N'0933333333', N'nam', N'123/2a trần bình trọng p5 q5', N'sv003.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv004', N'Vu ngọc lan', N'vnlan@gmail.com', N'0944445555', N'nam', N'3 dht2 p.tân hưng thuận, q12', N'sv004.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv005', N'Nguyễn Đăng Khoa ', N'ndkhoa@gmail.com', N'0955556666', N'nam', N'345 đường dht3, p.Đông Hưng Thuận, Q12', N'sv006.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv006', N'cxczc123', N'xzcz', N'1234567890', N'nam', N'sadda', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv007', N'csdf', N'fsf', N'2312313', N'nữ', N'đâsd', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv008', N'cxzcz', N'cxzcz', N'xczxczc', N'nữ', N'cxzczx', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv009', N'sad', N'đá', N'đá', N'nữ', N'đasa', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv010', N'sad', N'dsad', N'dsad', N'nữ', N'dsad', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv011', N'sf', N'fsf', N'fsf', N'nữ', N'fsafsa', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv012', N'fđf', N'sfa', N'3213221', N'nam', N'sfÀGDTGS', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv013', N'dfsf123', N'fsdf', N'fsf', N'nữ', N'sfsd', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv014', N'dsfdf', N'dfdsf', N'fdsfsf', N'nam', N'dfdsf', N'sv003.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv015', N'x', N'fdsf', N'fsdaf', N'nữ', N'fasf', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv016', N'vdsf', N'sdf', N'fsdf', N'nữ', N'fsdfs', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv017', N'ưewq', N'eqwe', N'eqwe', N'nữ', N'ewqe', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv018', N'', N'', N'', N'nữ', N'', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv019', N'ád', N'da', N'2313', N'nam', N'', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv020', N'', N'', N'', N'nữ', N'', N'sv001.jpg')
INSERT [dbo].[sinhvien] ([masv], [tensv], [Email], [SoDT], [GioiTinh], [diachi], [hinh]) VALUES (N'sv021', N'ffhgf', N'hdfd', N'gdg', N'nữ', N'gfdg', N'sv001.jpg')
