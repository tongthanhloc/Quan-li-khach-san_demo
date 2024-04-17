package entity;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

public class ChiTietHoaDonPhong {
	private HoaDon hoaDon;
	private PhieuDatPhong phieuDatPhong;
	private int soluongNguoiO;
	private LocalDate thoiGianDat;
	private LocalDate thoiGianTra;
	private LocalDate thoiGianNhan;
	private int soNgayO;
	private double donGiaPhong;
	public double thanhTien;

	public ChiTietHoaDonPhong(HoaDon hoaDon, PhieuDatPhong phieuDatPhong, int soluongNguoiO, LocalDate thoiGianDat,
			LocalDate thoiGianTra, LocalDate thoiGianNhan, double donGiaPhong) {
		super();
		this.hoaDon = hoaDon;
		this.phieuDatPhong = phieuDatPhong;
		this.soluongNguoiO = soluongNguoiO;
		this.thoiGianDat = thoiGianDat;
		this.thoiGianTra = thoiGianTra;
		this.thoiGianNhan = thoiGianNhan;
		tinhSoNgayO();
		this.donGiaPhong = donGiaPhong;
		tinhThanhTien();
	}
	public LocalDate getThoiGianDat() {
		return thoiGianDat;
	}
	public void setThoiGianDat(LocalDate thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}
	public LocalDate getThoiGianTra() {
		return thoiGianTra;
	}
	public void setThoiGianTra(LocalDate thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}
	public LocalDate getThoiGianNhan() {
		return thoiGianNhan;
	}
	public void setThoiGianNhan(LocalDate thoiGianNhan) {
		this.thoiGianNhan = thoiGianNhan;
	}
	public void setDonGiaPhong(double donGiaPhong) {
		this.donGiaPhong = donGiaPhong;
	}
	public ChiTietHoaDonPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public PhieuDatPhong getPhieuDatPhong() {
		return phieuDatPhong;
	}
	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}
	public int getSoluongNguoiO() {
		return soluongNguoiO;
	}
	public void setSoluongNguoiO(int soluongNguoiO) {
		this.soluongNguoiO = soluongNguoiO;
	}
	public void tinhSoNgayO() {
		this.soNgayO = (int) ChronoUnit.DAYS.between(phieuDatPhong.getThoiGianNhan(), phieuDatPhong.getThoiGianTra());
    }
	public int getSoNgayO() {
		return soNgayO;
	}
	public double getDonGiaPhong() {
		return phieuDatPhong.getDonGiaPhieu();
	}
	public void setDonGiaPhong(float donGiaPhong) {
		this.donGiaPhong = donGiaPhong;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void tinhThanhTien() {
		this.thanhTien = phieuDatPhong.getDonGiaPhieu() * soNgayO;
	}
}
