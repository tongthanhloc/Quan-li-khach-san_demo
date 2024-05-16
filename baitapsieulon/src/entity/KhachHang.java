package entity;

import java.time.LocalDate;
import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String hoTen;
	private Boolean gioiTinh;
	private LocalDate ngaySinh;
	private String soDT;
	private String diaChi;
	private String email;
	private int diem;
	private String hang;
	private LocalDate ngayBatDau;

	public KhachHang(String maKH, String hoTen, Boolean gioiTinh, LocalDate ngaySinh, String soDT, String diaChi,
			String email, int diem, String hang, LocalDate ngayBatDau) {
        super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.email = email;
		this.diem = diem;
		this.hang = hang;
		this.ngayBatDau = ngayBatDau;
	}
	
	

	public String getMaKH() {
		return maKH;
	}



	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}



	public String getHoTen() {
		return hoTen;
	}



	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	public Boolean getGioiTinh() {
		return gioiTinh;
	}



	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}



	public LocalDate getNgaySinh() {
		return ngaySinh;
	}



	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getDiem() {
		return diem;
	}



	public void setDiem(int diem) {
		this.diem = diem;
	}



	public String getHang() {
		return hang;
	}



	public void setHang(String hang) {
		this.hang = hang;
	}



	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}



	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}



	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}



	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	
	
}
