USE [master]
GO
/****** Object:  Database [web_candy]    Script Date: 5/12/2022 5:05:08 PM ******/
CREATE DATABASE [web_candy]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'web_candy', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\web_candy.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'web_candy_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\web_candy_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [web_candy] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [web_candy].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [web_candy] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [web_candy] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [web_candy] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [web_candy] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [web_candy] SET ARITHABORT OFF 
GO
ALTER DATABASE [web_candy] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [web_candy] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [web_candy] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [web_candy] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [web_candy] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [web_candy] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [web_candy] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [web_candy] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [web_candy] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [web_candy] SET  ENABLE_BROKER 
GO
ALTER DATABASE [web_candy] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [web_candy] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [web_candy] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [web_candy] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [web_candy] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [web_candy] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [web_candy] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [web_candy] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [web_candy] SET  MULTI_USER 
GO
ALTER DATABASE [web_candy] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [web_candy] SET DB_CHAINING OFF 
GO
ALTER DATABASE [web_candy] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [web_candy] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [web_candy] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [web_candy] SET QUERY_STORE = OFF
GO
USE [web_candy]
GO
/****** Object:  Table [dbo].[ct_hoa_don_ban_hang]    Script Date: 5/12/2022 5:05:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ct_hoa_don_ban_hang](
	[so_luong] [int] NOT NULL,
	[don_gia] [float] NULL,
	[ma_hoa_don] [int] NOT NULL,
	[ma_san_pham] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[danh_muc_san_pham]    Script Date: 5/12/2022 5:05:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danh_muc_san_pham](
	[ma_loai_san_pham] [int] IDENTITY(1,1) NOT NULL,
	[ten_loai_san_pham] [nvarchar](255) NULL,
	[hinh_anh] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_loai_san_pham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoa_don_ban_hang]    Script Date: 5/12/2022 5:05:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoa_don_ban_hang](
	[ma_hoa_don] [int] IDENTITY(1,1) NOT NULL,
	[ngay_lap_dat] [date] NULL,
	[ngay_lap_giao] [date] NULL,
	[tong_so_luong] [int] NOT NULL,
	[sdt_nguoi_nhan] [varchar](30) NULL,
	[tong_tien] [float] NULL,
	[ghi_chu] [nvarchar](255) NULL,
	[nguo_nhan] [nvarchar](255) NULL,
	[ma_khach_hang] [int] NULL,
	[trang_thai] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_hoa_don] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khach_hang]    Script Date: 5/12/2022 5:05:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khach_hang](
	[ma_khach_hang] [int] IDENTITY(1,1) NOT NULL,
	[ten_khach_hang] [nvarchar](255) NULL,
	[sdt] [varchar](30) NULL,
	[dia_chi] [nvarchar](255) NULL,
	[email] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_khach_hang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[san_pham]    Script Date: 5/12/2022 5:05:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[san_pham](
	[ma_san_pham] [int] IDENTITY(1,1) NOT NULL,
	[ten_san_pham] [nvarchar](255) NULL,
	[so_luong] [int] NOT NULL,
	[don_gia] [float] NOT NULL,
	[hinh_anh] [varchar](255) NULL,
	[khuyen_mai] [float] NOT NULL,
	[thong_tin_san_pham] [nvarchar](255) NULL,
	[ma_loai_san_pham] [int] NULL,
	[hinh_anh2] [varchar](255) NULL,
	[hinh_anh3] [varchar](255) NULL,
	[hinh_anh1] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_san_pham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tai_khoan]    Script Date: 5/12/2022 5:05:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tai_khoan](
	[ten_tai_khoan] [nvarchar](30) NOT NULL,
	[ma_khach_hang] [int] NULL,
	[role] [varchar](15) NULL,
	[mat_khau] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ten_tai_khoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 16, 1, 3)
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 16, 2, 3)
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 16, 3, 3)
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 15.5, 3, 5)
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 26.41, 4, 2)
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 30, 5, 12)
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 15, 6, 4)
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 16, 7, 3)
INSERT [dbo].[ct_hoa_don_ban_hang] ([so_luong], [don_gia], [ma_hoa_don], [ma_san_pham]) VALUES (1, 15.5, 7, 5)
GO
SET IDENTITY_INSERT [dbo].[danh_muc_san_pham] ON 

INSERT [dbo].[danh_muc_san_pham] ([ma_loai_san_pham], [ten_loai_san_pham], [hinh_anh]) VALUES (1, N'Red Velvet', N'flaticon-005-pancake')
INSERT [dbo].[danh_muc_san_pham] ([ma_loai_san_pham], [ten_loai_san_pham], [hinh_anh]) VALUES (2, N'Cup Cake', N'flaticon-029-cupcake-3')
INSERT [dbo].[danh_muc_san_pham] ([ma_loai_san_pham], [ten_loai_san_pham], [hinh_anh]) VALUES (3, N'Biscuit', N'flaticon-030-cupcake-2')
INSERT [dbo].[danh_muc_san_pham] ([ma_loai_san_pham], [ten_loai_san_pham], [hinh_anh]) VALUES (4, N'Donut', N'flaticon-006-macarons')
SET IDENTITY_INSERT [dbo].[danh_muc_san_pham] OFF
GO
SET IDENTITY_INSERT [dbo].[hoa_don_ban_hang] ON 

INSERT [dbo].[hoa_don_ban_hang] ([ma_hoa_don], [ngay_lap_dat], [ngay_lap_giao], [tong_so_luong], [sdt_nguoi_nhan], [tong_tien], [ghi_chu], [nguo_nhan], [ma_khach_hang], [trang_thai]) VALUES (1, CAST(N'2022-05-12' AS Date), CAST(N'2022-05-12' AS Date), 1, N'0339701675', 8, N'', N'Hong Thuy', 1, N'Chờ xử lý')
INSERT [dbo].[hoa_don_ban_hang] ([ma_hoa_don], [ngay_lap_dat], [ngay_lap_giao], [tong_so_luong], [sdt_nguoi_nhan], [tong_tien], [ghi_chu], [nguo_nhan], [ma_khach_hang], [trang_thai]) VALUES (2, CAST(N'2022-05-12' AS Date), CAST(N'2022-05-12' AS Date), 2, N'0339701675', 31, N'', N'Hong Thuy', 1, N'Chờ xử lý')
INSERT [dbo].[hoa_don_ban_hang] ([ma_hoa_don], [ngay_lap_dat], [ngay_lap_giao], [tong_so_luong], [sdt_nguoi_nhan], [tong_tien], [ghi_chu], [nguo_nhan], [ma_khach_hang], [trang_thai]) VALUES (3, CAST(N'2022-05-12' AS Date), CAST(N'2022-05-12' AS Date), 2, N'0339701675', 31.5, N'', N'Hong Thuy', 1, N'Chờ xử lý')
INSERT [dbo].[hoa_don_ban_hang] ([ma_hoa_don], [ngay_lap_dat], [ngay_lap_giao], [tong_so_luong], [sdt_nguoi_nhan], [tong_tien], [ghi_chu], [nguo_nhan], [ma_khach_hang], [trang_thai]) VALUES (4, CAST(N'2022-05-12' AS Date), CAST(N'2022-05-12' AS Date), 2, N'0339701675', 42.41, N'', N'Hong Thuy', 1, N'Chờ xử lý')
INSERT [dbo].[hoa_don_ban_hang] ([ma_hoa_don], [ngay_lap_dat], [ngay_lap_giao], [tong_so_luong], [sdt_nguoi_nhan], [tong_tien], [ghi_chu], [nguo_nhan], [ma_khach_hang], [trang_thai]) VALUES (5, CAST(N'2022-05-12' AS Date), CAST(N'2022-05-12' AS Date), 1, N'0339701675', 30, N'', N'Hong Thuy', 1, N'Chờ xử lý')
INSERT [dbo].[hoa_don_ban_hang] ([ma_hoa_don], [ngay_lap_dat], [ngay_lap_giao], [tong_so_luong], [sdt_nguoi_nhan], [tong_tien], [ghi_chu], [nguo_nhan], [ma_khach_hang], [trang_thai]) VALUES (6, CAST(N'2022-05-12' AS Date), CAST(N'2022-05-12' AS Date), 1, N'0339701675', 15, N'', N'Hong Thuy', 1, N'Chờ xử lý')
INSERT [dbo].[hoa_don_ban_hang] ([ma_hoa_don], [ngay_lap_dat], [ngay_lap_giao], [tong_so_luong], [sdt_nguoi_nhan], [tong_tien], [ghi_chu], [nguo_nhan], [ma_khach_hang], [trang_thai]) VALUES (7, CAST(N'2022-05-12' AS Date), CAST(N'2022-05-12' AS Date), 2, N'0339701675', 31.5, N'', N'Hong Thuy', 1, N'Chờ xử lý')
SET IDENTITY_INSERT [dbo].[hoa_don_ban_hang] OFF
GO
SET IDENTITY_INSERT [dbo].[khach_hang] ON 

INSERT [dbo].[khach_hang] ([ma_khach_hang], [ten_khach_hang], [sdt], [dia_chi], [email]) VALUES (1, N'Hong Thuy', N'0339701675', N'KienGiang', N'hohongthuy001@gmail.com')
INSERT [dbo].[khach_hang] ([ma_khach_hang], [ten_khach_hang], [sdt], [dia_chi], [email]) VALUES (2, N'tin', N'0388055011', N'dong thap', N'tin@gmail.com')
SET IDENTITY_INSERT [dbo].[khach_hang] OFF
GO
SET IDENTITY_INSERT [dbo].[san_pham] ON 

INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (2, N'SWEET AUTUMN LEAVES', 99, 26.41, N'img/shop/details/product-big-1.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 1, N'img/shop/details/product-big-3.jpg', N'img/shop/details/product-big-4.jpg', N'img/shop/details/product-big-2.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (3, N'Dozen Cupcakes', 198, 32, N'img/shop/product-1.jpg', 0.5, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 2, N'img/shop/details/product-big-3.jpg', N'img/shop/details/product-big-4.jpg', N'img/shop/details/product-big-2.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (4, N'COOKIES AND CREAM', 100, 30, N'img/shop/product-2.jpg', 0.5, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 3, N'img/shop/details/product2-2.jpg', N'img/shop/details/product2-3.jpg', N'img/shop/details/product2-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (5, N'GLUTEN FREE MINI DOZEN', 99, 31, N'img/shop/product-3.jpg', 0.5, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 2, N'img/shop/details/thumb-2.jpg', N'img/shop/details/thumb-3.jpg', N'img/shop/details/thumb-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (6, N'DONUTS CHOICE', 100, 35, N'img/shop/donut1.jpg', 0.5, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 4, N'img/shop/details/donut1-2.jpg', N'img/shop/details/donut1-3.jpg', N'img/shop/details/donut1-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (7, N'DONUTS ', 100, 25, N'img/shop/donut2.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 4, N'img/shop/details/donut2-2.jpg', N'img/shop/details/donut2-3.jpg', N'img/shop/details/donut2-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (8, N'DONUTS BOX', 100, 50, N'img/shop/donut3.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 4, N'img/shop/details/donut3-2.jpg', N'img/shop/details/donut3-3.jpg', N'img/shop/details/donut3-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (9, N'DONUTS BOX', 100, 20, N'img/shop/red2.jpg', 0.5, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 1, N'img/shop/details/red2-2.jpg', N'img/shop/details/red2-3.jpg', N'img/shop/details/red2-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (10, N'RED VELVET CREAM', 100, 20, N'img/shop/red3.jpg', 0.5, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 1, N'img/shop/details/red3-2.jpg', N'img/shop/details/red3-3.jpg', N'img/shop/details/red3-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (11, N'RED VELVET CREAM.D ', 100, 25, N'img/shop/red4.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 1, N'img/shop/details/red4-2.jpg', N'img/shop/details/red4-3.jpg', N'img/shop/details/red4-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (12, N'Red Velvet Heart Cake', 99, 30, N'img/shop/red5.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 1, N'img/shop/details/red5-2.jpg', N'img/shop/details/red5-3.jpg', N'img/shop/details/red5-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (13, N'CHOCOLICIOUS CHOCO CHIP', 100, 25, N'img/shop/cup3.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 2, N'img/shop/details/cup3-2.jpg', N'img/shop/details/cup3-3.jpg', N'img/shop/details/cup3-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (14, N'Strawberry Cream', 100, 30, N'img/shop/cup4.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 2, N'img/shop/details/cup4-2.jpg', N'img/shop/details/cup4-3.jpg', N'img/shop/details/cup4-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (15, N'I Love You Cupcakes 2 Pieces', 100, 50, N'img/shop/cup5.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 2, N'img/shop/details/cup5-2.jpg', N'img/shop/details/cup5-3.jpg', N'img/shop/details/cup5-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (17, N'Ginger Chocolate', 100, 30, N'img/shop/bis2.jpg', 0, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 3, N'img/shop/details/bis2-2.jpg', N'img/shop/details/bis2-3.jpg', N'img/shop/details/bis2-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (18, N'BUNDLE', 100, 35, N'img/shop/bis3.jpg', 0.5, N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida', 3, N'img/shop/details/bis3-2.jpg', N'img/shop/details/bis3-3.jpg', N'img/shop/details/bis3-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (20, N'
Butterfly Red Velvet', 100, 35, N'img/shop/red6.jpg', 0, N'Make it a delightful Women is Day celebration 
as you appreciate her presence with this drool 
some red velvet cake. The delicious round velvet 
cake prettied with butterfly design is surely
 worth every bite.', 1, N'img/shop/details/red6-2.jpg', N'img/shop/details/red6-3.jpg', N'img/shop/details/red6-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (21, N'
Cocoa Nib & Sea Salt', 100, 20, N'img/shop/bis4.jpg', 0.5, N'Our sweet, crunchy & salty Gold, 
Cocoa Nib & Sea Salt Brownies are made 
to order every day and can be enjoyed 
straight to your door. ', 3, N'img/shop/details/bis4-2.jpg', N'img/shop/details/bis4-3.jpg', N'img/shop/details/bis4-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (22, N'
Sweet Red Little Heart', 100, 25, N'img/shop/cup6.jpg', 0, N'Our sweet, crunchy & salty Gold, 
Cocoa Nib & Sea Salt Brownies are made 
to order every day and can be enjoyed 
straight to your door. ', 2, N'img/shop/details/cup6-2.jpg', N'img/shop/details/cup6-3.jpg', N'img/shop/details/cup6-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (23, N'
Chocolate Sprinkle', 100, 25, N'img/shop/do4.jpg', 0, N'A giant 10” donut cake not filled, 
just topped with our house made chocolate glaze and 
covered in sprinkles.', 4, N'img/shop/details/do4-2.jpg', N'img/shop/details/do4-3.jpg', N'img/shop/details/do4-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (24, N'
Luscious Layered', 100, 30, N'img/shop/red7.jpg', 0, N'A giant 10” donut cake not filled, 
just topped with our house made chocolate glaze and 
covered in sprinkles.', 1, N'img/shop/details/red7-2.jpg', N'img/shop/details/red7-3.jpg', N'img/shop/details/red7-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (25, N'
Black Forest', 100, 30, N'img/shop/bis5.jpg', 0.3, N'The heavenly taste of this Choco Truffle Cake will even leave the hardest-to-please chocolate addicts tranquil in every sense.', 3, N'img/shop/details/bis5-2.jpg', N'img/shop/details/bis5-3.jpg', N'img/shop/details/bis5-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (26, N'
Set Of Six Delicious', 100, 50, N'img/shop/cup7.jpg', 0, N'Let it be known to your special lady 
that she holds a lot of value in your life as 
you surprise her with this delicious set of six
 cupcakes made specially for Women Day.', 2, N'img/shop/details/cup7-2.jpg', N'img/shop/details/cup7-3.jpg', N'img/shop/details/cup7-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (27, N'
Giant Nutella Rocher', 100, 30, N'img/shop/do5.jpg', 0, N'There’s no better way to show someone how BIG your love is by gifting them Australia’s largest croissant-donut - weighing 1.5kg! ', 4, N'img/shop/details/do5-2.jpg', N'img/shop/details/do5-3.jpg', N'img/shop/details/do5-1.jpg')
INSERT [dbo].[san_pham] ([ma_san_pham], [ten_san_pham], [so_luong], [don_gia], [hinh_anh], [khuyen_mai], [thong_tin_san_pham], [ma_loai_san_pham], [hinh_anh2], [hinh_anh3], [hinh_anh1]) VALUES (28, N'
Toblerone Party Pack', 100, 35, N'img/shop/do6.jpg', 0.4, N'25-30cm Toblerone donut cake - caramel glaze, chopped almonds, Toblerone pieces and mini Nutella jar', 4, N'img/shop/details/do6-2.jpg', N'img/shop/details/do6-3.jpg', N'img/shop/details/do6-1.jpg')
SET IDENTITY_INSERT [dbo].[san_pham] OFF
GO
INSERT [dbo].[tai_khoan] ([ten_tai_khoan], [ma_khach_hang], [role], [mat_khau]) VALUES (N'tin', 1, N'USER', N'$2a$12$2421X.bHZ8LCXcSqagdOv.EctQX6iznGiB2Gs07e4KVmLSxIa9Ok6')
GO
/****** Object:  Index [UQ__tai_khoa__C9817AF7652E8FE4]    Script Date: 5/12/2022 5:05:08 PM ******/
ALTER TABLE [dbo].[tai_khoan] ADD UNIQUE NONCLUSTERED 
(
	[ma_khach_hang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ct_hoa_don_ban_hang]  WITH CHECK ADD FOREIGN KEY([ma_hoa_don])
REFERENCES [dbo].[hoa_don_ban_hang] ([ma_hoa_don])
GO
ALTER TABLE [dbo].[ct_hoa_don_ban_hang]  WITH CHECK ADD FOREIGN KEY([ma_san_pham])
REFERENCES [dbo].[san_pham] ([ma_san_pham])
GO
ALTER TABLE [dbo].[hoa_don_ban_hang]  WITH CHECK ADD FOREIGN KEY([ma_khach_hang])
REFERENCES [dbo].[khach_hang] ([ma_khach_hang])
GO
ALTER TABLE [dbo].[san_pham]  WITH CHECK ADD FOREIGN KEY([ma_loai_san_pham])
REFERENCES [dbo].[danh_muc_san_pham] ([ma_loai_san_pham])
GO
ALTER TABLE [dbo].[tai_khoan]  WITH CHECK ADD FOREIGN KEY([ma_khach_hang])
REFERENCES [dbo].[khach_hang] ([ma_khach_hang])
GO
USE [master]
GO
ALTER DATABASE [web_candy] SET  READ_WRITE 
GO
