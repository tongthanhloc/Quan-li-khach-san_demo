package entity;

import java.util.Objects;

public class Phong {

	private String maPhong;
	private String loaiPhong;
	private double donGiaTheoNgay;
	private int soGiuong;
	private String soTang;
	private String phongCach;
	private String trangThai;
	private String moTa;
	private String hinhAnh;
	
	public Phong(String maPhong, String loaiPhong, double donGiaTheoNgay, int soGiuong, String soTang,
			String phongCach, String trangThai, String moTa, String hinhAnh) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.donGiaTheoNgay = donGiaTheoNgay;
		this.soGiuong = soGiuong;
		this.soTang = soTang;
		this.phongCach = phongCach;
		this.trangThai = trangThai;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
	}
	public Phong() {
		
	}
	public Phong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public double getDonGiaTheoNgay() {
		return donGiaTheoNgay;
	}
	public void setDonGiaTheoNgay(double donGiaTheoNgay) {
		this.donGiaTheoNgay = donGiaTheoNgay;
	}
	public int getSoGiuong() {
		return soGiuong;
	}
	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}
	public String getSoTang() {
		return soTang;
	}
	public void setSoTang(String soTang) {
		this.soTang = soTang;
	}
	public String getPhongCach() {
		return phongCach;
	}
	public void setPhongCach(String phongCach) {
		this.phongCach = phongCach;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;	
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	
	
}
