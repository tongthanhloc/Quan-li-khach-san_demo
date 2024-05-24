package entity;

import java.time.LocalDate;
import java.util.Objects;

import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class PhieuDatDichVu {
	private String maPhieu;
	private LocalDate thoiGianDat;
	private double donGia;
	private int soLuong;
	private DichVu dichVu;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private String trangThai;
	private HoaDon hoaDon;
	private double giaTrcThue;
	public double getGiaTrcThue() {
		return giaTrcThue;
	}
	public void setGiaTrcThue(double giaTrcThue) {
		this.giaTrcThue = giaTrcThue;
	}
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
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public PhieuDatDichVu(String maPhieu, LocalDate thoiGianDat, double donGia, int soLuong, DichVu dichVu,
			KhachHang khachHang, NhanVien nhanVien, String trangThai,double giaTrcThue) {
		super();
		this.maPhieu = maPhieu;
		this.thoiGianDat = thoiGianDat;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.dichVu = dichVu;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.trangThai = trangThai;
	    this.giaTrcThue = giaTrcThue;
	}
	
	public PhieuDatDichVu(String maPhieu, LocalDate thoiGianDat, double donGia, int soLuong, DichVu dichVu,
			KhachHang khachHang, NhanVien nhanVien, String trangThai, HoaDon hoaDon, double giaTrcThue) {
		super();
		this.maPhieu = maPhieu;
		this.thoiGianDat = thoiGianDat;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.dichVu = dichVu;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.trangThai = trangThai;
		this.hoaDon = hoaDon;
		this.giaTrcThue = giaTrcThue;
	}
	@Override
	public String toString() {
		return "DAO_PhieuDatDichVu [maPhieu=" + maPhieu + ", thoiGianDat=" + thoiGianDat + ", donGia=" + donGia
				+ ", soLuong=" + soLuong + ", dichVu=" + dichVu + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien
				+ ", trangThai=" + trangThai + ", hoaDon=" + hoaDon + "]";
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
		PhieuDatDichVu other = (PhieuDatDichVu) obj;
		return Objects.equals(maPhieu, other.maPhieu);
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
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
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	
	
}
