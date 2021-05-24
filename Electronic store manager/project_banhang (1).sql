-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 23, 2021 lúc 05:25 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `project_banhang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sale_catalog`
--

CREATE TABLE `sale_catalog` (
  `loai_id` int(11) NOT NULL,
  `loai_ten` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sale_catalog`
--

INSERT INTO `sale_catalog` (`loai_id`, `loai_ten`) VALUES
(1, 'Laptop'),
(2, 'Bàn phim'),
(3, 'Màn hình'),
(4, 'Chuột Gaming'),
(5, 'Tai nghe');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sale_customer`
--

CREATE TABLE `sale_customer` (
  `kh_id` int(11) NOT NULL,
  `kh_ten` text COLLATE utf8_unicode_ci NOT NULL,
  `kh_sdt` text COLLATE utf8_unicode_ci NOT NULL,
  `kh_diachi` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'lưu mảng(diachi1|diachi2))',
  `kh_email` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'username',
  `kh_ghichu` text COLLATE utf8_unicode_ci NOT NULL,
  `kh_password` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'MD5',
  `kh_joindate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sale_customer`
--

INSERT INTO `sale_customer` (`kh_id`, `kh_ten`, `kh_sdt`, `kh_diachi`, `kh_email`, `kh_ghichu`, `kh_password`, `kh_joindate`) VALUES
(1, 'Phuong Nam', '0123456789', '5 An Duong Vuong', 'khachhang@gmail.com', 'Khach hang', 'khachhang', '2021-05-21'),
(2, 'Minh Huy', '0123456788', '6 An Duong Vuong', 'khachhang2@gmail.com', 'Khach hang', 'khachhang', '2021-05-21'),
(3, 'Gia Bao', '0123456787', '7 An Duong Vuong', 'khachhang3@gmail.com', 'Khach hang', 'khachhang', '2021-05-21'),
(4, 'Gia Han', '0123456786', '8 An Duong Vuong', 'khachhang4@gmail.com', 'Khach hang', 'khachhang', '2021-05-21'),
(5, 'Minh Chau', '0123456785', '9 An Duong Vuong', 'khachhang5@gmail.com', 'Khach hang', 'khachhang', '2021-05-21');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sale_invoice`
--

CREATE TABLE `sale_invoice` (
  `hd_id` int(11) NOT NULL,
  `hd_ngaylap` date NOT NULL,
  `kh_id` int(11) DEFAULT NULL,
  `hd_nguoinhan` text NOT NULL,
  `hd_diachi` text NOT NULL,
  `hd_ngaygiao` date NOT NULL,
  `hd_total` double NOT NULL,
  `hd_ghichu` text NOT NULL,
  `hd_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sale_invoice`
--

INSERT INTO `sale_invoice` (`hd_id`, `hd_ngaylap`, `kh_id`, `hd_nguoinhan`, `hd_diachi`, `hd_ngaygiao`, `hd_total`, `hd_ghichu`, `hd_status`) VALUES
(1, '2021-05-23', 1, 'Nguyên Văn A', '5 An Duong Vuong', '2021-05-24', 3000000, 'dê vơ', 1),
(2, '2021-05-23', 2, 'Nguyên Văn B', '6 An Duong Vuong', '2021-05-24', 4000000, 'dê vơ', 1),
(3, '2021-05-23', 3, 'Nguyên Văn C', '7 An Duong Vuong', '2021-05-24', 5000000, 'dê vơ', 1),
(4, '2021-05-23', 4, 'Nguyên Văn D', '8 An Duong Vuong', '2021-05-24', 6000000, 'dê vơ', 1),
(5, '2021-05-23', 5, 'Nguyên Văn E', '9 An Duong Vuong', '2021-05-24', 7000000, 'dê vơ', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sale_invoicedetail`
--

CREATE TABLE `sale_invoicedetail` (
  `ct_id` int(11) NOT NULL,
  `hd_id` int(11) NOT NULL,
  `sp_id` int(11) NOT NULL,
  `ct_soluong` int(100) DEFAULT NULL,
  `ct_dongia` double NOT NULL,
  `ct_thanhtien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sale_product`
--

CREATE TABLE `sale_product` (
  `sp_id` int(11) NOT NULL,
  `sp_ten` text NOT NULL,
  `loai_id` int(11) NOT NULL,
  `sp_mota` text NOT NULL,
  `sp_tonkho` int(11) NOT NULL,
  `sp_daban` int(11) NOT NULL DEFAULT 0,
  `sp_dongia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sale_product`
--

INSERT INTO `sale_product` (`sp_id`, `sp_ten`, `loai_id`, `sp_mota`, `sp_tonkho`, `sp_daban`, `sp_dongia`) VALUES
(7, 'Laptop Lenovo Ideapad L340-15IRH 81LK01J3VN Gaming', 1, 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz<br>														   RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2400 MHz<br>														 Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA<br>														  Màn hình: 15.6 inch, Full HD (1920 x 1080)<br>														   Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics<br>														   Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, LAN (RJ45)<br>														   Hệ điều hành: Windows 10 Home SL<br>														   Thiết kế: Vỏ nhựa, PIN liền<br>														   Kích thước: Dày 19.9 mm, 1.7 kg<br>', 112, 0, 20000000),
(8, 'Laptop Acer Gaming Nitro 5 AN515-55-55E3 NH.Q7QSV.002', 1, 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz<br>														   RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2400 MHz<br>														 Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA<br>														  Màn hình: 15.6 inch, Full HD (1920 x 1080)<br>														   Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics<br>														   Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, LAN (RJ45)<br>														   Hệ điều hành: Windows 10 Home SL<br>														   Thiết kế: Vỏ nhựa, PIN liền<br>														   Kích thước: Dày 19.9 mm, 1.7 kg<br>', 100, 0, 20000000),
(9, 'Laptop MSI GF63 Thin 10SCXR 020VN', 1, 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz<br>														   RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2400 MHz<br>														 Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA<br>														  Màn hình: 15.6 inch, Full HD (1920 x 1080)<br>														   Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics<br>														   Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, LAN (RJ45)<br>														   Hệ điều hành: Windows 10 Home SL<br>														   Thiết kế: Vỏ nhựa, PIN liền<br>														   Kích thước: Dày 19.9 mm, 1.7 kg<br>', 100, 0, 30000000),
(10, 'Laptop Asus TUF Gaming F15 FX506LU-HN138T', 1, 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz<br>														   RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2400 MHz<br>														 Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA<br>														  Màn hình: 15.6 inch, Full HD (1920 x 1080)<br>														   Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics<br>														   Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, LAN (RJ45)<br>														   Hệ điều hành: Windows 10 Home SL<br>														   Thiết kế: Vỏ nhựa, PIN liền<br>														   Kích thước: Dày 19.9 mm, 1.7 kg<br>', 100, 0, 40000000),
(11, 'Laptop Acer Nitro 5 AMD AN515-45-R3SM NH.QBMSV.005', 1, 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz<br>														   RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2400 MHz<br>														 Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA<br>														  Màn hình: 15.6 inch, Full HD (1920 x 1080)<br>														   Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics<br>														   Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, LAN (RJ45)<br>														   Hệ điều hành: Windows 10 Home SL<br>														   Thiết kế: Vỏ nhựa, PIN liền<br>														   Kích thước: Dày 19.9 mm, 1.7 kg<br>', 100, 0, 200000),
(12, 'Bàn phím cơ Fuhlen G87L Blue switch', 2, 'Màu sắc: đen<br>													   Kiểu kết nối: bàn phím có dây, 160cm<br>														   Kết nối: USB 2.0<br>														   Phím chức năng: Standard<br>														   Kích thước: Full size, 485x230x40mm<br>														   Kiểu bàn phím: bàn phím cơ<br>\r\nTrọng lượng: 1083g\'<br>', 100, 0, 2000000),
(13, 'Bàn phím cơ IKBC CD87 PD Blue switch', 2, 'Màu sắc: đen<br>													   Kiểu kết nối: bàn phím có dây, 160cm<br>														   Kết nối: USB 2.0<br>														   Phím chức năng: Standard<br>														   Kích thước: Full size, 485x230x40mm<br>														   Kiểu bàn phím: bàn phím cơ<br>\r\nTrọng lượng: 1083g\'<br>', 100, 0, 5000000),
(14, 'Màn hình máy tính Samsung LS24F354FHEXXV 23.5 inch Full HD', 3, 'Tương thích: Windows<br>													   Độ phân giải: 1200 - 3200 DPI<br>\r\nCách kết nối: Dây cắm USB<br>										   Độ dài dây / Khoảng cách kết nối: Dây dài 158 cm<br>									   Trọng lượng: 69g<br>											   Thương hiệu của: Trung Quốc<br>', 100, 0, 4000000),
(15, 'Màn hình máy tính Asus ProArt PA248QV 24.1 inch IPS FHD', 3, 'Tương thích: Windows<br>													   Độ phân giải: 1200 - 3200 DPI<br>\r\nCách kết nối: Dây cắm USB<br>										   Độ dài dây / Khoảng cách kết nối: Dây dài 158 cm<br>									   Trọng lượng: 69g<br>											   Thương hiệu của: Trung Quốc<br>', 100, 0, 2000000),
(16, 'Chuột không dây Logitech MX Anywhere 3', 4, 'Công nghệ cảm biến: Darkfield có độ chính xác cao, hoạt đông được trên kính<br>\r\nĐộ phân giải : 1000 dpi<br>\r\nKhoảng cách tối đa 10m<br>\r\nPin: Pin sạc Li-Po (500 mAh)<br>\r\nKết nối : Bluetooth & USB Unifying<br>\r\nTương thích : Windows 10 trở lên, macOS <br>10.15 trở lên, iPadOS 13.4 trở lên,Chrome OS,Linux 7<br>', 100, 0, 200000),
(17, 'Chuột không dây Logitech MX Anywhere 3', 4, 'Công nghệ cảm biến: Darkfield có độ chính xác cao, hoạt đông được trên kính<br>\r\nĐộ phân giải : 1000 dpi<br>\r\nKhoảng cách tối đa 10m<br>\r\nPin: Pin sạc Li-Po (500 mAh)<br>\r\nKết nối : Bluetooth & USB Unifying<br>\r\nTương thích : Windows 10 trở lên, macOS <br>10.15 trở lên, iPadOS 13.4 trở lên,Chrome OS,Linux 7<br>', 100, 0, 300000),
(18, 'Laptop Asus Gaming Rog Strix G512 i7 10750H/144Hz (IAL001T)', 1, 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz<br>														   RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2400 MHz<br>														 Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA<br>														  Màn hình: 15.6 inch, Full HD (1920 x 1080)<br>														   Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics<br>														   Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, LAN (RJ45)<br>														   Hệ điều hành: Windows 10 Home SL<br>														   Thiết kế: Vỏ nhựa, PIN liền<br>														   Kích thước: Dày 19.9 mm, 1.7 kg<br>', 100, 0, 51000000),
(19, 'Laptop Asus ZenBook 13 UX325EA-EG079T', 1, 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz<br>														   RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2400 MHz<br>														 Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA<br>														  Màn hình: 15.6 inch, Full HD (1920 x 1080)<br>														   Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics<br>														   Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, LAN (RJ45)<br>														   Hệ điều hành: Windows 10 Home SL<br>														   Thiết kế: Vỏ nhựa, PIN liền<br>														   Kích thước: Dày 19.9 mm, 1.7 kg<br>', 100, 0, 15000000),
(20, 'alo', 1, 'ola', 0, 0, 1000),
(21, 'aloha', 2, 'hasayo', 0, 0, 2389000),
(22, 'gchg', 1, 'hg', 0, 0, 76876),
(23, 'áđ', 1, 'adsád', 0, 0, 1234),
(24, 'sadsd', 1, 'áđâsd', 0, 0, 23231),
(25, 'ádsad', 1, 'áđá', 0, 0, 1000),
(26, 'sdfsdf', 1, 'ádsad', 0, 0, 1000),
(27, 'abc', 1, 'xyz', 0, 0, 1000),
(28, 'gcghhh', 1, 'jgvgvjh', 70, 0, 4000),
(29, 'nbjhvhjb', 5, 'bvjbm', 98, 0, 7698),
(30, 'ưeqưe', 5, 'qưewe', 21, 0, 12321),
(31, 'abcxyz', 1, 'abc', 10, 0, 20000),
(32, 'áđá', 1, 'áđá', 3, 0, 4321),
(33, 'baobeo', 1, 'vcl', 6, 0, 4570),
(34, 'baobeo', 1, 'bjknlj', 87, 0, 98766),
(35, 'anh gì ơi', 1, 'gì v em', 100, 0, 1000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sale_storage`
--

CREATE TABLE `sale_storage` (
  `pn_id` int(11) NOT NULL,
  `pn_ngaylap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sale_storage`
--

INSERT INTO `sale_storage` (`pn_id`, `pn_ngaylap`) VALUES
(1, '2021-05-22'),
(2, '2021-05-22'),
(3, '2021-05-22'),
(4, '2021-05-23'),
(5, '2021-05-23'),
(6, '2021-05-23'),
(7, '2021-05-23'),
(8, '2021-05-23'),
(9, '2021-05-23'),
(10, '2021-05-23'),
(11, '2021-05-23');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sale_storagedetail`
--

CREATE TABLE `sale_storagedetail` (
  `pn_id` int(11) NOT NULL,
  `sp_id` int(11) NOT NULL,
  `ct_soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sale_storagedetail`
--

INSERT INTO `sale_storagedetail` (`pn_id`, `sp_id`, `ct_soluong`) VALUES
(1, 7, 2),
(2, 7, 2),
(3, 7, 2),
(4, 28, 67),
(5, 29, 98),
(6, 30, 21),
(6, 28, 3),
(7, 31, 10),
(8, 32, 3),
(9, 33, 6),
(10, 34, 87),
(11, 35, 100);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `sale_catalog`
--
ALTER TABLE `sale_catalog`
  ADD PRIMARY KEY (`loai_id`);

--
-- Chỉ mục cho bảng `sale_customer`
--
ALTER TABLE `sale_customer`
  ADD PRIMARY KEY (`kh_id`);

--
-- Chỉ mục cho bảng `sale_invoice`
--
ALTER TABLE `sale_invoice`
  ADD PRIMARY KEY (`hd_id`);

--
-- Chỉ mục cho bảng `sale_invoicedetail`
--
ALTER TABLE `sale_invoicedetail`
  ADD PRIMARY KEY (`ct_id`),
  ADD KEY `hd_id` (`hd_id`),
  ADD KEY `sp_id` (`sp_id`);

--
-- Chỉ mục cho bảng `sale_product`
--
ALTER TABLE `sale_product`
  ADD PRIMARY KEY (`sp_id`),
  ADD KEY `loai_id` (`loai_id`);

--
-- Chỉ mục cho bảng `sale_storage`
--
ALTER TABLE `sale_storage`
  ADD PRIMARY KEY (`pn_id`);

--
-- Chỉ mục cho bảng `sale_storagedetail`
--
ALTER TABLE `sale_storagedetail`
  ADD KEY `pn_id` (`pn_id`),
  ADD KEY `sp_id` (`sp_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `sale_catalog`
--
ALTER TABLE `sale_catalog`
  MODIFY `loai_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `sale_customer`
--
ALTER TABLE `sale_customer`
  MODIFY `kh_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `sale_invoice`
--
ALTER TABLE `sale_invoice`
  MODIFY `hd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `sale_invoicedetail`
--
ALTER TABLE `sale_invoicedetail`
  MODIFY `ct_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sale_product`
--
ALTER TABLE `sale_product`
  MODIFY `sp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT cho bảng `sale_storage`
--
ALTER TABLE `sale_storage`
  MODIFY `pn_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `sale_invoicedetail`
--
ALTER TABLE `sale_invoicedetail`
  ADD CONSTRAINT `sale_invoicedetail_ibfk_1` FOREIGN KEY (`hd_id`) REFERENCES `sale_invoice` (`hd_id`),
  ADD CONSTRAINT `sale_invoicedetail_ibfk_2` FOREIGN KEY (`sp_id`) REFERENCES `sale_product` (`sp_id`);

--
-- Các ràng buộc cho bảng `sale_product`
--
ALTER TABLE `sale_product`
  ADD CONSTRAINT `sale_product_ibfk_1` FOREIGN KEY (`loai_id`) REFERENCES `sale_catalog` (`loai_id`);

--
-- Các ràng buộc cho bảng `sale_storagedetail`
--
ALTER TABLE `sale_storagedetail`
  ADD CONSTRAINT `sale_storagedetail_ibfk_1` FOREIGN KEY (`pn_id`) REFERENCES `sale_storage` (`pn_id`),
  ADD CONSTRAINT `sale_storagedetail_ibfk_2` FOREIGN KEY (`sp_id`) REFERENCES `sale_product` (`sp_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
