package entity;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String hoTenNV;
	private boolean gioiTinh;
	private String viTri;
	private String soDT;
	private String diaChi;
	private LocalDate ngaySinh;
	private LocalDate ngayVaoLam;
	private LocalDate ngayNghiLam;
	private String trangThai;
	private String trinhDoHocVan;
	private String anhDaiDien;
	private double heSoLuong;
	private double luongCoBan;
	private double tongLuong;
	public NhanVien(String maNV, String hoTenNV, boolean gioiTinh, String viTri, String soDT, String diaChi,
			LocalDate ngaySinh, LocalDate ngayVaoLam, LocalDate ngayNghiLam, String trangThai, String trinhDoHocVan,
			String anhDaiDien, double heSoLuong, double luongCoBan) {
		super();
		this.maNV = maNV;
		this.hoTenNV = hoTenNV;
		this.gioiTinh = gioiTinh;
		this.viTri = viTri;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.ngayNghiLam = ngayNghiLam;
		this.trangThai = trangThai;
		this.trinhDoHocVan = trinhDoHocVan;
		this.anhDaiDien = anhDaiDien;
		this.heSoLuong = heSoLuong;
		this.luongCoBan = luongCoBan;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV) {
		this.maNV = maNV;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTenNV() {
		return hoTenNV;
	}
	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public LocalDate getNgayNghiLam() {
		return ngayNghiLam;
	}
	public void setNgayNghiLam(LocalDate ngayNghiLam) {
		this.ngayNghiLam = ngayNghiLam;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getTrinhDoHocVan() {
		return trinhDoHocVan;
	}
	public void setTrinhDoHocVan(String trinhDoHocVan) {
		this.trinhDoHocVan = trinhDoHocVan;
	}
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public double getLuongCoBan() {
		return luongCoBan;
	}
	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	
	
	

}
