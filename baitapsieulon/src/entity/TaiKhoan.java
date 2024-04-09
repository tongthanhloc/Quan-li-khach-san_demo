package entity;

import java.util.Objects;

public class TaiKhoan {

	private NhanVien nhanVien;
	private String matKhau;
	private String trangThai;
	public TaiKhoan(NhanVien nhanVien, String matKhau, String trangThai) {
		super();
		this.nhanVien = nhanVien;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
	}
	public TaiKhoan(NhanVien nv) {
		this.nhanVien = nv;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nhanVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(nhanVien, other.nhanVien);
	}

	
	
}
