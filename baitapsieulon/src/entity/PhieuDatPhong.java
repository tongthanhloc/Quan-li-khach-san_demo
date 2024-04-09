package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class PhieuDatPhong {
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Phong phong;
	private LocalDateTime thoiGianDat;
	private LocalDateTime thoiGianNhan;
	private LocalDateTime thoiGianTra;
	private double donGiaPhieu;
	public PhieuDatPhong(KhachHang khachHang, NhanVien nhanVien, Phong phong,
			LocalDateTime thoiGianDat, LocalDateTime thoiGianNhan, LocalDateTime thoiGianTra) {
		super();
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.phong = phong;
		this.thoiGianDat = thoiGianDat;
		this.thoiGianNhan = thoiGianNhan;
		this.thoiGianTra = thoiGianTra;
		this.donGiaPhieu = getDonGiaPhieu();
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
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
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
		return donGiaPhieu = phong.getDonGiaTheoNgay();
	}
	@Override
	public int hashCode() {
		return Objects.hash(khachHang, nhanVien, phong);
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
		return Objects.equals(khachHang, other.khachHang) && Objects.equals(nhanVien, other.nhanVien)
				&& Objects.equals(phong, other.phong);
	}
	
	
}
