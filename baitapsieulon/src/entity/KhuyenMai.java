package entity;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Objects;

public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private	LocalDate thoiGianTao;
	private LocalDate thoiGianKetThuc;
	private LocalDate thoiGIanBatDau;
	private double phanTramKhuyenMai;
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, LocalDate thoiGianTao, LocalDate thoiGianKetThuc,
			LocalDate thoiGIanBatDau, double phanTramKhuyenMai) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.thoiGianTao = thoiGianTao;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.thoiGIanBatDau = thoiGIanBatDau;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}
	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public LocalDate getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(LocalDate thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public LocalDate getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public LocalDate getThoiGIanBatDau() {
		return thoiGIanBatDau;
	}
	public void setThoiGIanBatDau(LocalDate thoiGIanBatDau) {
		this.thoiGIanBatDau = thoiGIanBatDau;
	}
	public double getPhanTramKhuyenMai() {
		return phanTramKhuyenMai;
	}
	public void setPhanTramKhuyenMai(double phanTramKhuyenMai) {
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhuyenMai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(maKhuyenMai, other.maKhuyenMai);
	}
	
}