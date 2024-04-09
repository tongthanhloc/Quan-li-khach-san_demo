package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDon {
	private String MaHD;
	private KhachHang MaKH;
	private NhanVien MaNV;
	private KhuyenMai maKM;
	private LocalDateTime NgayLap;
	private String trangThai;
	private double tienThanhToan;
	private ArrayList<ChiTietHoaDonPhong> dsChiTietHoaDonPhong;
	private ArrayList<ChiTietDichVu> dsDichVu;
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
	public void setTienThoi(double tienThoi) {
		this.tienThoi = tienThoi;
	}
	public HoaDon(String maHD, KhachHang maKH, NhanVien maNV, KhuyenMai maKM,
			LocalDateTime ngayLap, String trangThai, double tienThanhToan) {
		super();
		MaHD = maHD;
		MaKH = maKH;
		MaNV = maNV;
		this.maKM = maKM;
		NgayLap = ngayLap;
		this.trangThai = trangThai;
		this.tienThanhToan = tienThanhToan;
	}
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public KhachHang getMaKH() {
		return MaKH;
	}
	public void setMaKH(KhachHang maKH) {
		MaKH = maKH;
	}
	public NhanVien getMaNV() {
		return MaNV;
	}
	public void setMaNV(NhanVien maNV) {
		MaNV = maNV;
	}
	public KhuyenMai getMaKM() {
		return maKM;
	}
	public void setMaKM(KhuyenMai maKM) {
		this.maKM = maKM;
	}
	public LocalDateTime getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		NgayLap = ngayLap;
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
