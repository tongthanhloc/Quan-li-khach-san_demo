package entity;

import java.util.Objects;

public class ChiTietDichVu {
	private HoaDon HoaDon;
	private DichVuTienIch DichVuTienIch;
	private int soLuong;
	private double thanhTienDichVu;
	public ChiTietDichVu(HoaDon maHD, entity.DichVuTienIch dichVuTienIch, int soNgaySD, int soLuong,
			double tienDichVu) {
		super();
		HoaDon = maHD;
		DichVuTienIch = dichVuTienIch;
		this.soLuong = soLuong;
		this.thanhTienDichVu = getTienDichVuValue();
	}
	public double getTienDichVuValue() {
		// Số tiền = (Tiền dịch vụ * số lượng)*(phần trăm khuyến mãi - phần trăm thuế)
		return (DichVuTienIch.getGiaDichVu() * soLuong)*(DichVuTienIch.getPhanTramKhuyenMai() - DichVuTienIch.getPhanTramThueDichVu());
	}
	public ChiTietDichVu() {
		super();
	}
	@Override
	public String toString() {
		return "ChiTietDichVu [HoaDon=" + HoaDon + ", DichVuTienIch=" + DichVuTienIch + ", soNgaySD="
				+ ", soLuong=" + soLuong + ", tienDichVu=" + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(DichVuTienIch, HoaDon);
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
		return Objects.equals(DichVuTienIch, other.DichVuTienIch) && Objects.equals(HoaDon, other.HoaDon);
	}
	public HoaDon getMaHD() {
		return HoaDon;
	}
	public void setMaHD(HoaDon maHD) {
		HoaDon = maHD;
	}
	public DichVuTienIch getDichVuTienIch() {
		return DichVuTienIch;
	}
	public void setDichVuTienIch(DichVuTienIch dichVuTienIch) {
		DichVuTienIch = dichVuTienIch;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
