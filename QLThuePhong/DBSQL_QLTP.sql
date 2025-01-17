--USE [master]
GO
/****** Object:  Database [QLKSEZ]    Script Date: 12/28/2023 3:58:50 PM ******/
CREATE DATABASE [QLKSEZ]
/*
CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLKSEZ', FILENAME = N'D:\SQLDB\QLKSEZ.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLKSEZ_log', FILENAME = N'D:\SQLDB\QLKSEZ_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF	
 */
GO
USE [QLKSEZ]
GO
ALTER DATABASE [QLKSEZ] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLKSEZ].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLKSEZ] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLKSEZ] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLKSEZ] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLKSEZ] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLKSEZ] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLKSEZ] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLKSEZ] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLKSEZ] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLKSEZ] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLKSEZ] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLKSEZ] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLKSEZ] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLKSEZ] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLKSEZ] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLKSEZ] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLKSEZ] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLKSEZ] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLKSEZ] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLKSEZ] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLKSEZ] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLKSEZ] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLKSEZ] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLKSEZ] SET RECOVERY FULL 
GO
ALTER DATABASE [QLKSEZ] SET  MULTI_USER 
GO
ALTER DATABASE [QLKSEZ] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLKSEZ] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLKSEZ] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLKSEZ] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLKSEZ] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLKSEZ] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLKSEZ', N'ON'
GO
ALTER DATABASE [QLKSEZ] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLKSEZ] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLKSEZ]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 12/28/2023 3:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
	[acc] [int] IDENTITY(1,1) NOT NULL,
	[taikhoan] [nvarchar](50) NOT NULL,
	[matkhau] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[acc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 12/28/2023 3:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDV] [int] IDENTITY(1,1) NOT NULL,
	[tenDV] [nvarchar](50) NULL,
	[giaDV] [nvarchar](50) NULL,
	[DVT] [nvarchar](50) NULL,
 CONSTRAINT [PK__DichVu__7A3EF4119A8632CF] PRIMARY KEY CLUSTERED 
(
	[maDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/28/2023 3:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [int] IDENTITY(1,1) NOT NULL,
	[tenKH] [nvarchar](50) NULL,
	[diaChi] [nvarchar](500) NULL,
	[soDTKH] [nvarchar](15) NULL,
	[emailKH] [nvarchar](50) NULL,
	[gioiTinhKH] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/28/2023 3:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [int] IDENTITY(1,1) NOT NULL,
	[tenNV] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [nvarchar](10) NULL,
	[soDT] [nvarchar](20) NULL,
	[email] [nvarchar](50) NULL,
	[luong] [nvarchar](20) NULL,
 CONSTRAINT [PK__NhanVien__7A3EC7D5D38904BE] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 12/28/2023 3:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [int] IDENTITY(1,1) NOT NULL,
	[loaiPhong] [nvarchar](50) NULL,
	[tenPhong] [nvarchar](50) NULL,
	[giaPhong] [int] NULL,
	[tinhTrang] [nvarchar](50) NULL,
 CONSTRAINT [PK__Phong__4CD55E104C571764] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SDDV]    Script Date: 12/28/2023 3:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SDDV](
	[idSDDV] [int] IDENTITY(1,1) NOT NULL,
	[maDV] [int] NOT NULL,
	[maThuePhong] [int] NOT NULL,
	[soLuong] [int] NULL,
	[thanhTien] [float] NULL,
	[ngaySD] [datetime] NULL,
 CONSTRAINT [PK_SDDV] PRIMARY KEY CLUSTERED 
(
	[idSDDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuePhong]    Script Date: 12/28/2023 3:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuePhong](
	[maThuePhong] [int] IDENTITY(1,1) NOT NULL,
	[maKH] [int] NOT NULL,
	[maPhong] [int] NOT NULL,
	[ngayDen] [datetime] NULL,
	[ngayDi] [datetime] NULL,
	[tinhTrangThue] [nvarchar](50) NULL,
 CONSTRAINT [PK__ThuePhon__99717FBFEAE1544B] PRIMARY KEY CLUSTERED 
(
	[maThuePhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[admin] ON 

INSERT [dbo].[admin] ([acc], [taikhoan], [matkhau]) VALUES (1, N'admin', N'123')
SET IDENTITY_INSERT [dbo].[admin] OFF
GO
SET IDENTITY_INSERT [dbo].[DichVu] ON 

INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (1, N'Khăn Uớt', N'5000', N'Cái')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (2, N'Bia Sài Gòn ', N'11000', N'Lon')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (3, N'Nước Lọc', N'4000', N'Lon')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (4, N'Nước Ngọt', N'10000', N'Lon')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (5, N'Dép', N'20000', N'Đôi')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (6, N'Đồ Bơi', N'35000', N'Bộ')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (7, N'Xe Điện', N'21000', N'Cái')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (8, N'Hoa Qủa', N'50000', N'Cân')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (9, N'Sinh Tố', N'15000', N'Cốc')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (10, N'Spa', N'200000', N'Giờ')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [giaDV], [DVT]) VALUES (11, N'Giặt Là', N'20000', N'Cân')
SET IDENTITY_INSERT [dbo].[DichVu] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [soDTKH], [emailKH], [gioiTinhKH]) VALUES (1, N'Nguyễn Gia Tùng', N'Hà Nội', N'0857394575', N'tung@gmail.com', N'Nam')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [soDTKH], [emailKH], [gioiTinhKH]) VALUES (2, N'Nguyễn Hải Đăng', N'Bắc Ninh', N'0326891754', N'hai@hmail.com', N'Nam')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [soDTKH], [emailKH], [gioiTinhKH]) VALUES (3, N'Vũ Thị Hải Tuệ', N'Bắc Giang', N'0956348756', N'tue@gmail.com', N'Nữ')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [soDTKH], [emailKH], [gioiTinhKH]) VALUES (4, N'Ma Hữu Huỳnh', N'Thái Nguyên', N'0332648975', N'huynh12@gmail.com', N'Nam')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [soDTKH], [emailKH], [gioiTinhKH]) VALUES (5, N'Nguyễn Thị Huế', N'Hà Nội ', N'0856264987', N'hue@gmail.com', N'Nữ')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [diaChi], [soDTKH], [emailKH], [gioiTinhKH]) VALUES (8, N'Bùi Việt', N'Hà Nội', N'037603857', N'viet@gmail.com', N'Nam')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [gioiTinh], [soDT], [email], [luong]) VALUES (5, N'hoàng', CAST(N'2000-06-06' AS Date), N'Nam', N'0849307847', N'hoang@gmail.com', N'19000')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [gioiTinh], [soDT], [email], [luong]) VALUES (8, N'Việt Hoàng', CAST(N'2001-07-15' AS Date), N'Nam', N'0366589689', N'vhoang@gmail.com', N'19000')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [gioiTinh], [soDT], [email], [luong]) VALUES (9, N'Như', CAST(N'2002-04-04' AS Date), N'Nữ', N'0989565445', N'nhu@gmail.com', N'20000')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [gioiTinh], [soDT], [email], [luong]) VALUES (10, N'Quỳnh', CAST(N'1999-09-21' AS Date), N'Nữ', N'0356898977', N'quynh@gmail.com', N'20000')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [gioiTinh], [soDT], [email], [luong]) VALUES (11, N'Hải', CAST(N'1998-11-22' AS Date), N'Nữ', N'0955564585', N'hai@gmail.com', N'19000')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [gioiTinh], [soDT], [email], [luong]) VALUES (12, N'Nam', CAST(N'2000-08-08' AS Date), N'Nam', N'0978784545', N'nam@gmail.com', N'19000')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [gioiTinh], [soDT], [email], [luong]) VALUES (13, N'Dương', CAST(N'2002-12-30' AS Date), N'Nam', N'0335485621', N'duong12@gmail.com', N'19000 ')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [gioiTinh], [soDT], [email], [luong]) VALUES (14, N'Rô nan đô', CAST(N'1900-07-07' AS Date), N'Nam', N'0968375649', N'anhdo@gmail.com', N'110000')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[Phong] ON 

INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (1, N'Đơn', N'101', 500000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (2, N'Đôi', N'102', 500000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (3, N'Đôi', N'103', 1000000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (4, N'Bốn', N'104', 1500000, N'Đang Hoạt Động')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (5, N'Đơn ', N'201', 500000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (6, N'Đơn', N'202', 500000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (7, N'Đôi', N'203', 1000000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (8, N'Bốn', N'204', 1500000, N'Đang Hoạt Động')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (9, N'Đơn', N'301', 500000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (10, N'Đơn', N'302', 500000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (11, N'Đôi ', N'303', 1000000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (12, N'Bốn', N'304', 1500000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (13, N'Đơn', N'401', 500000, N'Đang Hoạt Động')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (14, N'Đơn ', N'402', 500000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (15, N'Đôi', N'403', 1000000, N'Trống')
INSERT [dbo].[Phong] ([maPhong], [loaiPhong], [tenPhong], [giaPhong], [tinhTrang]) VALUES (16, N'Bốn', N'404', 1500000, N'Trống')
SET IDENTITY_INSERT [dbo].[Phong] OFF
GO
SET IDENTITY_INSERT [dbo].[SDDV] ON 

INSERT [dbo].[SDDV] ([idSDDV], [maDV], [maThuePhong], [soLuong], [thanhTien], [ngaySD]) VALUES (1, 1, 6, 1, 0, CAST(N'2023-12-27T00:00:00.000' AS DateTime))
INSERT [dbo].[SDDV] ([idSDDV], [maDV], [maThuePhong], [soLuong], [thanhTien], [ngaySD]) VALUES (2, 2, 6, 2, 0, CAST(N'2023-12-22T00:00:00.000' AS DateTime))
INSERT [dbo].[SDDV] ([idSDDV], [maDV], [maThuePhong], [soLuong], [thanhTien], [ngaySD]) VALUES (3, 3, 8, 1, 0, CAST(N'2023-12-12T00:00:00.000' AS DateTime))
INSERT [dbo].[SDDV] ([idSDDV], [maDV], [maThuePhong], [soLuong], [thanhTien], [ngaySD]) VALUES (4, 4, 8, 1, 0, CAST(N'2023-12-11T00:00:00.000' AS DateTime))
INSERT [dbo].[SDDV] ([idSDDV], [maDV], [maThuePhong], [soLuong], [thanhTien], [ngaySD]) VALUES (5, 1, 15, 2, 10000, CAST(N'2023-12-28T11:03:47.383' AS DateTime))
SET IDENTITY_INSERT [dbo].[SDDV] OFF
GO
SET IDENTITY_INSERT [dbo].[ThuePhong] ON 

INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (6, 1, 2, CAST(N'2023-12-01T00:00:00.000' AS DateTime), CAST(N'2023-12-28T00:00:00.000' AS DateTime), N'Đã Trả')
INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (8, 2, 3, CAST(N'2023-12-10T00:00:00.000' AS DateTime), CAST(N'2023-12-28T00:00:00.000' AS DateTime), N'Đã Trả')
INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (14, 3, 6, CAST(N'2023-12-27T00:00:00.000' AS DateTime), CAST(N'2023-12-28T00:00:00.000' AS DateTime), N'Đã Trả')
INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (15, 8, 1, CAST(N'2023-12-22T00:00:00.000' AS DateTime), NULL, N'Đang Thuê')
--INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (16, 4, 9, CAST(N'2023-12-27T00:00:00.000' AS DateTime), CAST(N'2023-01-18T00:00:00.000' AS DateTime), N'Đã Trả')
--INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (17, 3, 10, CAST(N'2023-12-28T00:00:00.000' AS DateTime), CAST(N'2023-01-18T00:00:00.000' AS DateTime), N'Đã Trả')
--INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (20, 4, 9, CAST(N'2023-12-27T00:00:00.000' AS DateTime), CAST(N'2023-01-18T00:00:00.000' AS DateTime), N'Đã Trả')
INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (22, 5, 8, CAST(N'2023-12-27T00:00:00.000' AS DateTime), NULL, N'Đang Thuê')
INSERT [dbo].[ThuePhong] ([maThuePhong], [maKH], [maPhong], [ngayDen], [ngayDi], [tinhTrangThue]) VALUES (23, 5, 13, CAST(N'2023-12-29T00:00:00.000' AS DateTime), NULL, N'Đang Thuê')
SET IDENTITY_INSERT [dbo].[ThuePhong] OFF
GO
ALTER TABLE [dbo].[SDDV]  WITH CHECK ADD  CONSTRAINT [FK_SDDV_DichVu] FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SDDV] CHECK CONSTRAINT [FK_SDDV_DichVu]
GO
ALTER TABLE [dbo].[SDDV]  WITH CHECK ADD  CONSTRAINT [FK_SDDV_ThuePhong] FOREIGN KEY([maThuePhong])
REFERENCES [dbo].[ThuePhong] ([maThuePhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SDDV] CHECK CONSTRAINT [FK_SDDV_ThuePhong]
GO
ALTER TABLE [dbo].[ThuePhong]  WITH CHECK ADD  CONSTRAINT [FK_ThuePhong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ThuePhong] CHECK CONSTRAINT [FK_ThuePhong_KhachHang]
GO
ALTER TABLE [dbo].[ThuePhong]  WITH CHECK ADD  CONSTRAINT [FK_ThuePhong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ThuePhong] CHECK CONSTRAINT [FK_ThuePhong_Phong]
GO
USE [master]
GO
ALTER DATABASE [QLKSEZ] SET  READ_WRITE 
GO
