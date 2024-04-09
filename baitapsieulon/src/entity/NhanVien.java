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
	private double luong;
	private TaiKhoan TaiKhoan;
	private HoaDon HoaDon;
	private PhieuDatPhong PhieuDatPhong;
	
	public PhieuDatPhong getPhieuDatPhong() {
		return PhieuDatPhong;
	}
	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		PhieuDatPhong = phieuDatPhong;
	}
	public HoaDon getHoaDon() {
		return HoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		HoaDon = hoaDon;
	}
	public NhanVien() {
		
	}
	public TaiKhoan getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		TaiKhoan = taiKhoan;
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public NhanVien(String maNV, String hoTenNV, boolean gioiTinh, String viTri, String soDT, String diaChi,
			LocalDate ngaySinh, LocalDate ngayVaoLam, LocalDate ngayNghiLam, String trangThai, String trinhDoHocVan,
			String anhDaiDien, double luong) {
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
		this.luong = luong;
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

	public boolean getGioiTinh() {
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

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	

}
