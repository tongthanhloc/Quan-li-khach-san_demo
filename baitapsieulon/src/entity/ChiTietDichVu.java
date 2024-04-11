package entity;

import java.util.Objects;

public class ChiTietDichVu {
	private HoaDon hoaDon;
	private DichVuTienIch dichVuTienIch;
	private int soLuong;
	private double thanhTienDichVu;
	public ChiTietDichVu(HoaDon maHD, entity.DichVuTienIch dichVuTienIch, int soNgaySD, int soLuong,
			double tienDichVu) {
		super();
		this.hoaDon = maHD;
		this.dichVuTienIch = dichVuTienIch;
		this.soLuong = soLuong;
		tinhTienDichVuValue();
	}
	public double tinhTienDichVuValue() {
		// Số tiền = (Tiền dịch vụ * số lượng)*(phần trăm khuyến mãi - phần trăm thuế)
		return (dichVuTienIch.getGiaDichVu() * soLuong)*(dichVuTienIch.getPhanTramKhuyenMai() - dichVuTienIch.getPhanTramThueDichVu());
	}
	public double getTienDichVu() {
		return thanhTienDichVu;
	}
	public ChiTietDichVu() {
		super();
	}
	@Override
	public String toString() {
		return "ChiTietDichVu [HoaDon=" + hoaDon + ", DichVuTienIch=" + dichVuTienIch + ", soNgaySD="
				+ ", soLuong=" + soLuong + ", tienDichVu=" + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dichVuTienIch, hoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDichVu other = (ChiTietDichVu) obj;
		return Objects.equals(dichVuTienIch, other.dichVuTienIch) && Objects.equals(hoaDon, other.hoaDon);
	}
	public HoaDon getMaHD() {
		return hoaDon;
	}
	public void setMaHD(HoaDon maHD) {
		hoaDon = maHD;
	}
	public DichVuTienIch getDichVuTienIch() {
		return dichVuTienIch;
	}
	public void setDichVuTienIch(DichVuTienIch dichVuTienIch) {
		this.dichVuTienIch = dichVuTienIch;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
