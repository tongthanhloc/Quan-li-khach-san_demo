package entity;

import java.time.LocalDateTime;

public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private	LocalDateTime thoiGianTao;
	private LocalDateTime thoiGianKetThuc;
	private LocalDateTime thoiGIanBatDau;
	private double phanTramKhuyenMai;
	private HoaDon HoaDon;
	
	public KhuyenMai() {
		super();

	}
	public KhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, LocalDateTime thoiGianTao, LocalDateTime thoiGianKetThuc,
			LocalDateTime thoiGIanBatDau, double phanTramKhuyenMai, entity.HoaDon hoaDon) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.thoiGianTao = thoiGianTao;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.thoiGIanBatDau = thoiGIanBatDau;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
		HoaDon = hoaDon;
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
	public LocalDateTime getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(LocalDateTime thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public LocalDateTime getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public LocalDateTime getThoiGIanBatDau() {
		return thoiGIanBatDau;
	}
	public void setThoiGIanBatDau(LocalDateTime thoiGIanBatDau) {
		this.thoiGIanBatDau = thoiGIanBatDau;
	}
	public double getPhanTramKhuyenMai() {
		return phanTramKhuyenMai;
	}
	public void setPhanTramKhuyenMai(double phanTramKhuyenMai) {
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}
	public HoaDon getHoaDon() {
		return HoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		HoaDon = hoaDon;
	}
	
}