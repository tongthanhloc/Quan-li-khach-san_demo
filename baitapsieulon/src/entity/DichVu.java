package entity;

import java.util.Objects;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private int thueVAT;
	private String nhaCCDV;
	private Double donGia;
	private int soLuong;
	private String trangThai;
	
	public DichVu() {
		super();
	}

	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}

	
	public DichVu(String maDichVu, String tenDichVu, int thueVAT, String nhaCCDV, Double donGia, int soLuong,
			String trangThai) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.thueVAT = thueVAT;
		this.nhaCCDV = nhaCCDV;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
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



	public int getThueVAT() {
		return thueVAT;
	}



	public void setThueVAT(int thueVAT) {
		this.thueVAT = thueVAT;
	}



	public String getNhaCCDV() {
		return nhaCCDV;
	}



	public void setNhaCCDV(String nhaCCDV) {
		this.nhaCCDV = nhaCCDV;
	}



	public Double getDonGia() {
		return donGia;
	}



	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}



	public int getSoLuong() {
		return soLuong;
	}



	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	public String getTrangThai() {
		return trangThai;
	}



	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}
	
	
}
