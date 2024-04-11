package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDon {
	private String MaHD;
	private LocalDateTime ngayLap;
	private String trangThai;
	private double tienThanhToan;
	private double thanhTien;
	private double tienThoi;
	public HoaDon() {
		
	}
	public HoaDon(String MaHD) {
		this.MaHD = MaHD;
	}
	public double getTienThoi() {
		return tienThoi;
	}
	public void tinhTienThoi(double tienThoi) {
		this.tienThoi = tienThoi;
	}
	public HoaDon(String maHD,
			LocalDateTime ngayLap, String trangThai, double tienThanhToan) {
		super();
		MaHD = maHD;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
		this.tienThanhToan = tienThanhToan;
	}
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		ngayLap = ngayLap;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public double getTienThanhToan() {
		return tienThanhToan;
	}
	public void setTienThanhToan(double tienThanhToan) {
		this.tienThanhToan = tienThanhToan;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaHD);
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
		return Objects.equals(MaHD, other.MaHD);
	}

	/*
	 * public double tinhThanhTien() { thanhTien = 0; for (ChiTietHoaDonPhong cthd :
	 * dsChiTietHoaDonPhong) { thanhTien += cthd.tinhThanhTien(); } for
	 * (ChiTietDichVu ctdv : dsDichVu) { thanhTien += ctdv.tinhThanhTien(); }
	 * 
	 * return thanhTien; }
	 */
	
	
}
