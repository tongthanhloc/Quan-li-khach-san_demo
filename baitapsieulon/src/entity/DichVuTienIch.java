package entity;

import java.util.Objects;

public class DichVuTienIch {
	private String maDichVu;
	private String tenDichVu;
	private int soLuong;
	private double phanTramKhuyenMai;
	private double giaDichVu;
	private double phanTramThueDichVu;
	private KhuyenMai khuyenMai;
	public DichVuTienIch(String maDichVu, String tenDichVu, int soLuong, double phanTramKhuyenMai, double giaDichVu,
			double phanTramThueDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.soLuong = soLuong;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
		this.giaDichVu = giaDichVu;
		this.phanTramThueDichVu = phanTramThueDichVu;
	}
	public DichVuTienIch(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public DichVuTienIch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getPhanTramKhuyenMai() {
		return phanTramKhuyenMai;
	}
	public void setPhanTramKhuyenMai(double phanTramKhuyenMai) {
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}
	public double getGiaDichVu() {
		return giaDichVu;
	}
	public void setGiaDichVu(double giaDichVu) {
		this.giaDichVu = giaDichVu;
	}
	public double getPhanTramThueDichVu() {
		return phanTramThueDichVu;
	}
	public void setPhanTramThueDichVu(double phanTramThueDichVu) {
		this.phanTramThueDichVu = phanTramThueDichVu;
	}
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVuTienIch other = (DichVuTienIch) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}
	
	
}
