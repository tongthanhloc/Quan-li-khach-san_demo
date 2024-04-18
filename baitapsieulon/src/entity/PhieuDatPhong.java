package entity;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Objects;

public class PhieuDatPhong {
	private String maPhieu;
	private LocalDate thoiGianDat;
	private LocalDate thoiGianNhan;
	private LocalDate thoiGianTra;
	private double donGiaPhieu;
	private Phong phong;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private String trangThai;
	private String soNguoi;
	private DichVuTienIch dichVu;
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public LocalDate getThoiGianDat() {
		return thoiGianDat;
	}
	public void setThoiGianDat(LocalDate thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}
	public LocalDate getThoiGianNhan() {
		return thoiGianNhan;
	}
	public void setThoiGianNhan(LocalDate thoiGianNhan) {
		this.thoiGianNhan = thoiGianNhan;
	}
	public LocalDate getThoiGianTra() {
		return thoiGianTra;
	}
	public void setThoiGianTra(LocalDate thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}
	public double getDonGiaPhieu() {
		return donGiaPhieu;
	}
	public void setDonGiaPhieu(double donGiaPhieu) {
		this.donGiaPhieu = donGiaPhieu;
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
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(String soNguoi) {
		this.soNguoi = soNguoi;
	}
	
	public DichVuTienIch getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVuTienIch dichVu) {
		this.dichVu = dichVu;
	}
	public PhieuDatPhong(String maPhieu, LocalDate thoiGianDat, LocalDate thoiGianNhan, LocalDate thoiGianTra,
			double donGiaPhieu, Phong phong, KhachHang khachHang, NhanVien nhanVien, String trangThai, String soNguoi,
			DichVuTienIch dichVu) {
		super();
		this.maPhieu = maPhieu;
		this.thoiGianDat = thoiGianDat;
		this.thoiGianNhan = thoiGianNhan;
		this.thoiGianTra = thoiGianTra;
		this.donGiaPhieu = donGiaPhieu;
		this.phong = phong;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.trangThai = trangThai;
		this.soNguoi = soNguoi;
		this.dichVu = dichVu;
	}
	public PhieuDatPhong(String maPhieu) {
		super();
		this.maPhieu = maPhieu;
	}
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
	
	

	
	
	

}
