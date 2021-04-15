-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 28, 2021 lúc 09:05 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `tour_dulich`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tours`
--

CREATE TABLE `tours` (
  `tour_id` int(10) NOT NULL,
  `tour_ten` text COLLATE utf8_unicode_ci NOT NULL,
  `tour_mota` text COLLATE utf8_unicode_ci NOT NULL,
  `loai_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tours`
--

INSERT INTO `tours` (`tour_id`, `tour_ten`, `tour_mota`, `loai_id`) VALUES
(2, 'Tour nho', 'Noel', 2),
(3, 'Tour he', 'Nam cu', 4),
(4, 'Tour vui', 'Hop gia dinh', 3),
(5, 'Di du xuan', 'di choi', 3),
(6, 'tour 5', 'wfafwa', 1),
(7, 'tour 6', 'fwafwfwa', 1),
(8, 'tphcm - nha trang', 'dad', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_chiphi`
--

CREATE TABLE `tour_chiphi` (
  `chiphi_id` int(11) NOT NULL,
  `doan_id` int(11) NOT NULL,
  `chiphi_total` double NOT NULL,
  `chiphi_chitiet` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'lưu danh sách chi phí (json)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_chiphi`
--

INSERT INTO `tour_chiphi` (`chiphi_id`, `doan_id`, `chiphi_total`, `chiphi_chitiet`) VALUES
(3, 1, 120000, 'HD1|Khách sạn 4 sao|2021-03-26|Khach san parrav|20000,HD2|Ăn uống bình dân|2021-03-26|An com|100000,'),
(4, 5, 600000, 'rr|Khách sạn 3 sao|2021-03-26|rrr|300000,ttt|Ăn uống bình dân|2021-03-26|rrr|300000,');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_chitiet`
--

CREATE TABLE `tour_chitiet` (
  `ct_id` int(11) NOT NULL,
  `tour_id` int(11) NOT NULL,
  `dd_id` int(11) NOT NULL,
  `ct_thutu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_chitiet`
--

INSERT INTO `tour_chitiet` (`ct_id`, `tour_id`, `dd_id`, `ct_thutu`) VALUES
(2, 2, 13, 1),
(6, 4, 11, 1),
(23, 5, 6, 1),
(28, 3, 12, 1),
(29, 3, 10, 2),
(30, 3, 10, 3),
(33, 6, 13, 1),
(34, 6, 9, 2),
(35, 7, 13, 1),
(36, 8, 9, 1),
(37, 8, 12, 2),
(38, 8, 13, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_diadiem`
--

CREATE TABLE `tour_diadiem` (
  `dd_id` int(11) NOT NULL,
  `dd_thanhpho` text COLLATE utf8_unicode_ci NOT NULL,
  `dd_ten` text COLLATE utf8_unicode_ci NOT NULL,
  `dd_mota` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_diadiem`
--

INSERT INTO `tour_diadiem` (`dd_id`, `dd_thanhpho`, `dd_ten`, `dd_mota`) VALUES
(6, 'Ha Noi', 'Chua 1 Cot', 'Dam Sen'),
(8, 'quang tri', 'bien den', 'Dep'),
(9, 'Ho Chi Minh', 'Quan 2', 'Dep'),
(10, 'Ho Chi Minh', 'Quan 3', 'Dep'),
(11, 'Ho Chi Minh', 'Quan  Nha Be', 'Sieu Dep'),
(12, 'Hue', 'Thanh Do', 'Dep'),
(13, 'Da Nang ', 'Cau Rong', 'Dep'),
(21, 'Ho Chi Minh', 'asdasd', 'asdasd');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_doan`
--

CREATE TABLE `tour_doan` (
  `doan_id` int(11) NOT NULL,
  `tour_id` int(11) NOT NULL,
  `gia_id` int(11) NOT NULL,
  `doan_name` text COLLATE utf8_unicode_ci NOT NULL,
  `doan_ngaydi` date NOT NULL,
  `doan_ngayve` date NOT NULL,
  `doan_chitietchuongtrinh` text COLLATE utf8_unicode_ci NOT NULL,
  `doan_tinhtrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_doan`
--

INSERT INTO `tour_doan` (`doan_id`, `tour_id`, `gia_id`, `doan_name`, `doan_ngaydi`, `doan_ngayve`, `doan_chitietchuongtrinh`, `doan_tinhtrang`) VALUES
(1, 5, 8, 'Dai hoc Sai Gon', '2021-03-26', '2021-03-31', 'Di choi mua he', 1),
(2, 5, 8, 'Dai hoc Su Pham', '2021-03-26', '2021-03-31', 'Di choi mua he', 0),
(4, 5, 8, 'Dai hoc Ky thuat', '2021-03-26', '2021-03-31', 'Di choi cho vui', 0),
(5, 8, 14, 'doan nt1', '2021-03-26', '2021-03-27', 'knklvklnvklnsklvnskldnvklsdnklv', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_gia`
--

CREATE TABLE `tour_gia` (
  `gia_id` int(11) NOT NULL,
  `gia_sotien` double NOT NULL,
  `tour_id` int(11) NOT NULL,
  `gia_tungay` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_gia`
--

INSERT INTO `tour_gia` (`gia_id`, `gia_sotien`, `tour_id`, `gia_tungay`) VALUES
(8, 5000, 5, '2021-03-26'),
(9, 3000, 5, '2021-03-30'),
(10, 600000, 2, '2021-03-26'),
(12, 5000, 6, '2021-03-26'),
(13, 566454, 7, '2021-03-26'),
(14, 300000, 8, '2021-03-26'),
(15, 400000, 8, '2021-04-01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_khachhang`
--

CREATE TABLE `tour_khachhang` (
  `kh_id` int(11) NOT NULL,
  `kh_ten` text COLLATE utf8_unicode_ci NOT NULL,
  `kh_sdt` text COLLATE utf8_unicode_ci NOT NULL,
  `kh_ngaysinh` date NOT NULL,
  `kh_email` text COLLATE utf8_unicode_ci NOT NULL,
  `kh_cmnd` text COLLATE utf8_unicode_ci NOT NULL,
  `kh_ghichu` text COLLATE utf8_unicode_ci NOT NULL,
  `kh_trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_khachhang`
--

INSERT INTO `tour_khachhang` (`kh_id`, `kh_ten`, `kh_sdt`, `kh_ngaysinh`, `kh_email`, `kh_cmnd`, `kh_ghichu`, `kh_trangthai`) VALUES
(1, 'Phuong Nam', '0123456789', '2000-01-23', 'nam123@gmail.com', '012012012', 'Đại học Sài Gòn', 0),
(2, 'Nam Le', '01234567', '2000-01-23', 'nam@gmail.com', '012012013', 'Dai hoc Sai Gon', 0),
(3, 'Nam Le Le', '0123456789', '2000-01-23', 'nam@gmail.com', '012012014', 'Dai hoc Sai Gon', 0),
(4, 'Nam Le Bu', '0123456789', '2020-01-14', 'nam@gmail.com', '012012015', 'Dai hoc Sai Gon', 0),
(5, 'Nam Le Hi', '0123456789', '2000-01-23', 'nam@gmail.com', '012012016', 'Dai hoc Sai Gon', 0),
(6, 'Nam Ha', '0123456789', '2000-01-23', 'nam@gmail.com', '012012017', 'Dai hoc Sai Gon', 0),
(7, 'Nam He', '0123456789', '2000-01-23', 'nam@gmail.com', '012012018', 'Dai hoc Sai Gon', 0),
(8, 'Le Bao', '0123456789', '2000-03-09', 'bao@gmail.com', '023023023', 'Dai hoc Sai Gon', 0),
(9, 'Le Huy Huy', '0123456789', '2000-03-23', 'huy@gmail.com', '012012022', 'Dai hoc Sai Gon', 1),
(10, 'Bao', '0123483743', '2012-03-08', 'bao@gmail.com', '123223345', 'parapen', 1),
(11, 'Hung', '0129348392', '2010-03-06', 'hung@gmail.com', '284756483', 'dep chai', 1),
(12, 'Huan', '0129348392', '2010-03-06', 'hung@gmail.com', '284756485', 'dep chai', 1),
(13, 'Huyen', '0129348392', '2010-03-06', 'hung@gmail.com', '284756482', 'dep chai cute', 1),
(14, 'Thuyen', '0129348392', '2010-03-06', 'hung@gmail.com', '284756480', 'dep chai', 1),
(15, 'Tien', '0129348392', '2010-03-06', 'hung@gmail.com', '284756432', 'dep chai', 1),
(16, 'Kiet', '0129348392', '2010-03-06', 'hung@gmail.com', '284756438', 'dep chai', 0),
(17, 'Khang', '0129348392', '2010-03-06', 'hung@gmail.com', '284756430', 'dep chai', 0),
(18, 'Khanh', '0129348392', '2010-03-06', 'hung@gmail.com', '284756433', 'dep chai', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_loai`
--

CREATE TABLE `tour_loai` (
  `loai_id` int(10) NOT NULL,
  `loai_ten` text COLLATE utf8_unicode_ci NOT NULL,
  `loai_mota` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_loai`
--

INSERT INTO `tour_loai` (`loai_id`, `loai_ten`, `loai_mota`) VALUES
(1, 'Du lịch di động', 'Hình thức du lịch di động'),
(2, 'Du lịch kết hợp nghề nghiệp', 'Hình thức du lịch xã hội và gia đình'),
(3, 'Du lịch xã hội và gia đình', 'Hình thức du lịch di động'),
(4, 'Du lịch giải trí tham quan', 'Hình thức du lịch di động');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_loaichiphi`
--

CREATE TABLE `tour_loaichiphi` (
  `cp_id` int(11) NOT NULL,
  `cp_ten` text COLLATE utf8_unicode_ci NOT NULL,
  `cp_mota` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_loaichiphi`
--

INSERT INTO `tour_loaichiphi` (`cp_id`, `cp_ten`, `cp_mota`) VALUES
(1, 'Khách sạn 5 sao', 'Khách hàng 5 sao 5 tầng'),
(2, 'Khách sạn 4 sao', 'Khách hàng 4 sao 4 tầng'),
(3, 'Khách sạn 3 sao', 'Khách hàng 5 sao 5 tầng'),
(4, 'Ăn uống nhà hàng hải sản', 'Tôm, cua, ghẹ, blabla'),
(5, 'Ăn uống bình dân', 'Nhà hàng bình dân nhưng vẫn đảm bảo vệ sinh'),
(6, 'Chi phí khác', 'Các chi phí vui chơi, giải trí');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_nguoidi`
--

CREATE TABLE `tour_nguoidi` (
  `nguoidi_id` int(11) NOT NULL,
  `doan_id` int(11) NOT NULL,
  `nguoidi_dsnhanvien` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'lưu danh sách mã số nhân viên đi (json)',
  `nguoidi_dskhach` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'lưu danh sách mã số khách hàng (json)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_nguoidi`
--

INSERT INTO `tour_nguoidi` (`nguoidi_id`, `doan_id`, `nguoidi_dsnhanvien`, `nguoidi_dskhach`) VALUES
(10, 1, '19-Hướng dẫn viên,', '18,'),
(11, 2, '10-Tiền trạm,8-Lái xe,', '13,'),
(13, 4, '13-Lao công,', '11,'),
(14, 5, '1-Hướng dẫn viên,3-Lái xe,5-Lái Xe,', '15,14,12,10,9,');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_nhanvien`
--

CREATE TABLE `tour_nhanvien` (
  `nv_id` int(11) NOT NULL,
  `nv_ten` text COLLATE utf8_unicode_ci NOT NULL,
  `nv_sdt` text COLLATE utf8_unicode_ci NOT NULL,
  `nv_ngaysinh` date NOT NULL,
  `nv_email` text COLLATE utf8_unicode_ci NOT NULL,
  `nv_nhiemvu` text COLLATE utf8_unicode_ci NOT NULL,
  `nv_trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tour_nhanvien`
--

INSERT INTO `tour_nhanvien` (`nv_id`, `nv_ten`, `nv_sdt`, `nv_ngaysinh`, `nv_email`, `nv_nhiemvu`, `nv_trangthai`) VALUES
(1, 'Le Nam Nam', '0123456781', '2000-03-09', 'nam123@gmail.com', 'Hướng dẫn viên,Thông dịch viên Anh - Việt,', 1),
(2, 'Nam le', '0123456789', '2000-03-08', 'nam@gmail.com', 'Lái xe,Hướng dẫn viên', 0),
(3, 'Nam le', '0123456789', '2000-03-08', 'nam@gmail.com', 'Lái xe,Hướng dẫn viên', 1),
(4, 'Lê Tèo', '0123456789', '2000-12-12', 'teo@gmail.com', 'Lái xe,', 0),
(5, 'Le Huy', '0123456789', '2000-03-11', 'huy@gmail.com', 'Lái Xe', 1),
(6, 'Lê Tèo', '0123456789', '2000-03-15', 'teoteo@gmail.com', 'Phục vụ,Tiền trạm,', 0),
(9, 'Ti', '8128641029', '1998-03-19', 'jahsdkj@5768.com', 'Tiền trạm,', 0),
(11, 'Tu', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Tiền trạm,', 0),
(12, 'Tung', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Tiền trạm,Hướng dẫn viên,', 0),
(13, 'Trong', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Lao công,', 1),
(14, 'Bao', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Lao công,', 0),
(15, 'Huy', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Thông dịch viên Anh - Việt,', 0),
(16, 'Huyen', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Dẫn đoàn,', 0),
(17, 'Thien', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Thông dịch viên Anh - Việt,', 0),
(18, 'Thu', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Tiền trạm,', 0),
(19, 'Thuy', '0127464833', '1998-03-19', 'jahsdkj@5768.com', 'Hướng dẫn viên,', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour_nhiemvu`
--

CREATE TABLE `tour_nhiemvu` (
  `nhiemvu_id` int(11) NOT NULL,
  `nhiemvu_ten` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `tour_nhiemvu`
--

INSERT INTO `tour_nhiemvu` (`nhiemvu_id`, `nhiemvu_ten`) VALUES
(1, 'Hướng dẫn viên'),
(2, 'Lái xe'),
(3, 'Tiền trạm'),
(4, 'Thông dịch viên Anh - Việt'),
(5, 'Thông dịch viên Trung - Việt'),
(6, 'Phục vụ'),
(7, 'Lao công'),
(8, 'Dẫn đoàn'),
(9, 'Đàm phán');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tours`
--
ALTER TABLE `tours`
  ADD PRIMARY KEY (`tour_id`),
  ADD KEY `loai_id` (`loai_id`);

--
-- Chỉ mục cho bảng `tour_chiphi`
--
ALTER TABLE `tour_chiphi`
  ADD PRIMARY KEY (`chiphi_id`,`doan_id`),
  ADD KEY `doan_id` (`doan_id`);

--
-- Chỉ mục cho bảng `tour_chitiet`
--
ALTER TABLE `tour_chitiet`
  ADD PRIMARY KEY (`ct_id`),
  ADD KEY `tour_id` (`tour_id`,`dd_id`),
  ADD KEY `dd_id` (`dd_id`);

--
-- Chỉ mục cho bảng `tour_diadiem`
--
ALTER TABLE `tour_diadiem`
  ADD PRIMARY KEY (`dd_id`);

--
-- Chỉ mục cho bảng `tour_doan`
--
ALTER TABLE `tour_doan`
  ADD PRIMARY KEY (`doan_id`),
  ADD KEY `tour_id` (`tour_id`),
  ADD KEY `gia_id` (`gia_id`);

--
-- Chỉ mục cho bảng `tour_gia`
--
ALTER TABLE `tour_gia`
  ADD PRIMARY KEY (`gia_id`),
  ADD KEY `tour_id` (`tour_id`);

--
-- Chỉ mục cho bảng `tour_khachhang`
--
ALTER TABLE `tour_khachhang`
  ADD PRIMARY KEY (`kh_id`);

--
-- Chỉ mục cho bảng `tour_loai`
--
ALTER TABLE `tour_loai`
  ADD PRIMARY KEY (`loai_id`);

--
-- Chỉ mục cho bảng `tour_loaichiphi`
--
ALTER TABLE `tour_loaichiphi`
  ADD PRIMARY KEY (`cp_id`);

--
-- Chỉ mục cho bảng `tour_nguoidi`
--
ALTER TABLE `tour_nguoidi`
  ADD PRIMARY KEY (`nguoidi_id`,`doan_id`),
  ADD KEY `doan_id` (`doan_id`);

--
-- Chỉ mục cho bảng `tour_nhanvien`
--
ALTER TABLE `tour_nhanvien`
  ADD PRIMARY KEY (`nv_id`);

--
-- Chỉ mục cho bảng `tour_nhiemvu`
--
ALTER TABLE `tour_nhiemvu`
  ADD PRIMARY KEY (`nhiemvu_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tour_chiphi`
--
ALTER TABLE `tour_chiphi`
  MODIFY `chiphi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `tour_chitiet`
--
ALTER TABLE `tour_chitiet`
  MODIFY `ct_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT cho bảng `tour_diadiem`
--
ALTER TABLE `tour_diadiem`
  MODIFY `dd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `tour_doan`
--
ALTER TABLE `tour_doan`
  MODIFY `doan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `tour_gia`
--
ALTER TABLE `tour_gia`
  MODIFY `gia_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `tour_khachhang`
--
ALTER TABLE `tour_khachhang`
  MODIFY `kh_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `tour_loai`
--
ALTER TABLE `tour_loai`
  MODIFY `loai_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `tour_loaichiphi`
--
ALTER TABLE `tour_loaichiphi`
  MODIFY `cp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `tour_nguoidi`
--
ALTER TABLE `tour_nguoidi`
  MODIFY `nguoidi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `tour_nhanvien`
--
ALTER TABLE `tour_nhanvien`
  MODIFY `nv_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `tour_nhiemvu`
--
ALTER TABLE `tour_nhiemvu`
  MODIFY `nhiemvu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tours`
--
ALTER TABLE `tours`
  ADD CONSTRAINT `tours_ibfk_1` FOREIGN KEY (`loai_id`) REFERENCES `tour_loai` (`loai_id`);

--
-- Các ràng buộc cho bảng `tour_chiphi`
--
ALTER TABLE `tour_chiphi`
  ADD CONSTRAINT `tour_chiphi_ibfk_1` FOREIGN KEY (`doan_id`) REFERENCES `tour_doan` (`doan_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `tour_chitiet`
--
ALTER TABLE `tour_chitiet`
  ADD CONSTRAINT `tour_chitiet_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`tour_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `tour_chitiet_ibfk_2` FOREIGN KEY (`dd_id`) REFERENCES `tour_diadiem` (`dd_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `tour_doan`
--
ALTER TABLE `tour_doan`
  ADD CONSTRAINT `tour_doan_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`tour_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `tour_doan_ibfk_2` FOREIGN KEY (`gia_id`) REFERENCES `tour_gia` (`gia_id`);

--
-- Các ràng buộc cho bảng `tour_gia`
--
ALTER TABLE `tour_gia`
  ADD CONSTRAINT `tour_gia_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`tour_id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `tour_nguoidi`
--
ALTER TABLE `tour_nguoidi`
  ADD CONSTRAINT `tour_nguoidi_ibfk_1` FOREIGN KEY (`doan_id`) REFERENCES `tour_doan` (`doan_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
