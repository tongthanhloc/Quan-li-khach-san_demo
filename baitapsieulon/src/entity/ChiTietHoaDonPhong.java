package entity;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

public class ChiTietHoaDonPhong {
	private HoaDon HoaDon;
	private PhieuDatPhong PhieuDatPhong;
	private int soluongNguoiO;
	private LocalDateTime thoiGianDat;
	private LocalDateTime thoiGianTra;
	private LocalDateTime thoiGianNhan;
	private int soNgayO;
	private double donGiaPhong;

	public double tinhThanhTien;
	
	public ChiTietHoaDonPhong(entity.HoaDon hoaDon, entity.PhieuDatPhong phieuDatPhong, int soluongNguoiO, double donGiaPhong) {
		super();
		HoaDon = hoaDon;
		PhieuDatPhong = phieuDatPhong;
		this.soluongNguoiO = soluongNguoiO;
		this.thoiGianDat = PhieuDatPhong.getThoiGianDat();
		this.thoiGianTra = PhieuDatPhong.getThoiGianTra();
		this.thoiGianNhan = PhieuDatPhong.getThoiGianNhan();
		this.soNgayO = getSoNgayO();
		this.donGiaPhong = getDonGiaPhong();
	}
	public ChiTietHoaDonPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon getHoaDon() {
		return HoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		HoaDon = hoaDon;
	}
	public PhieuDatPhong getPhieuDatPhong() {
		return PhieuDatPhong;
	}
	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		PhieuDatPhong = phieuDatPhong;
	}
	public int getSoluongNguoiO() {
		return soluongNguoiO;
	}
	public void setSoluongNguoiO(int soluongNguoiO) {
		this.soluongNguoiO = soluongNguoiO;
	}
	public int getSoNgayO() {
		return soNgayO = (int) ChronoUnit.DAYS.between(PhieuDatPhong.getThoiGianNhan(), PhieuDatPhong.getThoiGianTra());
    }
//	public void setSoNgayO(int soNgayO) {
//		this.soNgayO = soNgayO;
//	}
	public double getDonGiaPhong() {
		return donGiaPhong = PhieuDatPhong.getDonGiaPhieu() * soNgayO;
	}
}
