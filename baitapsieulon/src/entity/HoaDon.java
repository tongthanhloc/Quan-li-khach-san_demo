package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private LocalDate ngayLap;
	private String trangThai;
	private double giaTrcThue;
	private double thanhTien;
	
	public HoaDon() {
		
	}
	public HoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public LocalDate getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public double getGiaTrcThue() {
		return giaTrcThue;
	}
	public void setGiaTrcThue(double giaTrcThue) {
		this.giaTrcThue = giaTrcThue;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	public HoaDon(String maHoaDon, LocalDate ngayLap, String trangThai, double giaTrcThue, double thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
		this.giaTrcThue = giaTrcThue;
		this.thanhTien = thanhTien;
	}
	
	
	
	
	
}