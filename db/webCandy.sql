create database web_candy


CREATE TABLE [quyen] (
  [ten_tai_khoan] nvarchar(30),
  [role] nvarchar(255)
)
GO

CREATE TABLE [ct_hoa_don_ban_hang] (
  [so_luong] int NOT NULL,
  [don_gia] float,
  [ma_hoa_don] int NOT NULL,
  [ma_san_pham] int NOT NULL
)
GO

CREATE TABLE [hoa_don_ban_hang] (
  [ma_hoa_don] int PRIMARY KEY IDENTITY(1, 1),
  [ngay_lap_dat] date,
  [ngay_lap_giao] date,
  [tong_so_luong] int NOT NULL,
  [sdt_nguoi_nhan] varchar(30),
  [tong_tien] float,
  [ghi_chu] nvarchar(255),
  [nguo_nhan] nvarchar(255),
  [ma_khach_hang] int,
  [trang_thai] nvarchar(255)
)
GO

CREATE TABLE [khach_hang] (
  [ma_khach_hang] int PRIMARY KEY IDENTITY(1, 1),
  [ten_khach_hang] nvarchar(255),
  [sdt] varchar(30),
  [dia_chi] nvarchar(255),
  [email] nvarchar(255)
)
GO

CREATE TABLE [san_pham] (
  [ma_san_pham] int PRIMARY KEY IDENTITY(1, 1),
  [ten_san_pham] nvarchar(255),
  [so_luong] int NOT NULL,
  [don_gia] float NOT NULL,
  [hinh_anh] varchar(255),
  [khuyen_mai] float NOT NULL,
  [thong_tin_san_pham] nvarchar(255)
)
GO

alter table [san_pham]
add [hinh_anh1] varchar(255)
go
alter table [san_pham]
add [ma_loai_san_pham] int

CREATE TABLE [tai_khoan] (
  [ten_tai_khoan] nvarchar(30) PRIMARY KEY ,
  [mat_khau] varchar(25) NOT NULL,
  [ma_khach_hang] int unique FOREIGN KEY REFERENCES [dbo].[khach_hang] ([ma_khach_hang])
)
GO

CREATE TABLE [danh_muc_san_pham] (
  [ma_loai_san_pham] int PRIMARY KEY IDENTITY(1, 1),
  [ten_loai_san_pham] nvarchar(255),
)

ALTER TABLE [quyen] ADD FOREIGN KEY ([ten_tai_khoan]) REFERENCES [tai_khoan] ([ten_tai_khoan])
GO

ALTER TABLE [ct_hoa_don_ban_hang] ADD FOREIGN KEY ([ma_san_pham]) REFERENCES [san_pham] ([ma_san_pham])
GO

ALTER TABLE [ct_hoa_don_ban_hang] ADD FOREIGN KEY ([ma_hoa_don]) REFERENCES [hoa_don_ban_hang] ([ma_hoa_don])
GO

ALTER TABLE [hoa_don_ban_hang] ADD FOREIGN KEY ([ma_khach_hang]) REFERENCES [khach_hang] ([ma_khach_hang])
GO

ALTER TABLE [san_pham] ADD FOREIGN KEY ([ma_loai_san_pham]) REFERENCES [danh_muc_san_pham] ([ma_loai_san_pham])
GO



INSERT INTO [danh_muc_san_pham]([ten_loai_san_pham])
VALUES ( 'Biscuit');
select * from [danh_muc_san_pham]
go
INSERT INTO [dbo].[san_pham]([ten_san_pham],[so_luong],[don_gia],[hinh_anh],[khuyen_mai],[thong_tin_san_pham],[ma_loai_san_pham],[hinh_anh1],[hinh_anh2],[hinh_anh3])
VALUES ('SWEET AUTUMN LEAVES', 100,26.41,'img/shop/details/product-big-1.jpg',0,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida',1,'img/shop/details/product-big-2.jpg','img/shop/details/product-big-3.jpg','img/shop/details/product-big-4.jpg');

INSERT INTO [dbo].[san_pham]([ten_san_pham],[so_luong],[don_gia],[hinh_anh],[khuyen_mai],[thong_tin_san_pham],[ma_loai_san_pham],[hinh_anh1],[hinh_anh2],[hinh_anh3])
VALUES ('Dozen Cupcakes', 100,32.00,'img/shop/product-1.jpg',0.5,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida',2,'img/shop/details/product-big-2.jpg','img/shop/details/product-big-3.jpg','img/shop/details/product-big-4.jpg');

select * from [san_pham]


INSERT INTO [dbo].[san_pham]([ten_san_pham],[so_luong],[don_gia],[hinh_anh],[khuyen_mai],[thong_tin_san_pham],[ma_loai_san_pham],[hinh_anh1],[hinh_anh2],[hinh_anh3])
VALUES ('CHOCOLICIOUS CHOCO CHIP', 
100,25.00,
'img/shop/cup3.jpg',
0,
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida',
                        2,
                        'img/shop/details/cup3-1.jpg',
                        'img/shop/details/cup3-2.jpg',
                        'img/shop/details/cup3-3.jpg');

select * from [san_pham]
select * from [danh_muc_san_pham]