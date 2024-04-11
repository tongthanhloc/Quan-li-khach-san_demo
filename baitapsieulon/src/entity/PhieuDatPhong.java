package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class PhieuDatPhong {
	private String maPhieu;
	private LocalDateTime thoiGianDat;
	private LocalDateTime thoiGianNhan;
	private LocalDateTime thoiGianTra;
	private double donGiaPhieu;
	private Phong phong;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	
	@Override
	public int hashCode() {
		return Objects.hash(maPhieu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatPhong other = (PhieuDatPhong) obj;
		return Objects.equals(maPhieu, other.maPhieu);
	}
	public PhieuDatPhong(String maPhieu, LocalDateTime thoiGianDat, LocalDateTime thoiGianNhan,
			LocalDateTime thoiGianTra, double donGiaPhieu, Phong phong, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maPhieu = maPhieu;
		this.thoiGianDat = thoiGianDat;
		this.thoiGianNhan = thoiGianNhan;
		this.thoiGianTra = thoiGianTra;
		this.donGiaPhieu = donGiaPhieu;
		this.phong = phong;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public PhieuDatPhong() {
		super();
	}
	public PhieuDatPhong(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public LocalDateTime getThoiGianDat() {
		return thoiGianDat;
	}
	public void setThoiGianDat(LocalDateTime thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}
	public LocalDateTime getThoiGianNhan() {
		return thoiGianNhan;
	}
	public void setThoiGianNhan(LocalDateTime thoiGianNhan) {
		this.thoiGianNhan = thoiGianNhan;
	}
	public LocalDateTime getThoiGianTra() {
		return thoiGianTra;
	}
	public void setThoiGianTra(LocalDateTime thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}
	public double getDonGiaPhieu() {
		return donGiaPhieu;
	}
	public void setDonGiaPhieu(double donGiaPhieu) {
		this.donGiaPhieu = donGiaPhieu;
	}

}
