package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

public class DAO_TaiKhoan {
	public DAO_TaiKhoan() {
	}

	public ArrayList<TaiKhoan> getTaiKhoan(){
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				NhanVien tenDangNhap = new NhanVien(rs.getString(1));
				String matKhau = rs.getString(2);
				String maNhanVien = rs.getString(3);
				TaiKhoan tk = new TaiKhoan(tenDangNhap, matKhau, maNhanVien);
				dsTK.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTK;
	}
	//doi mat khau
	public void doiMatKhau(String tenDangNhap, String matKhau) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "UPDATE TaiKhoan SET matKhau = '" + matKhau + "' WHERE tenDangNhap = '" + tenDangNhap + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// thêm tài khoản từ 1 nhân viên
		public void insertTaiKhoan(NhanVien nv) {
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				//Tạo mật khẩu mặc định là password@ + 2 số cuối mã nhân viên
				String matKhau = "password@" + nv.getMaNV().substring(2);
				String sql = "INSERT INTO TaiKhoan (maNhanVien, matKhau, trangThai) VALUES ('" + nv.getMaNV() + "', '" + matKhau + "', 'Còn làm')";
				Statement statement = con.createStatement();
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// Cập nhật trạng thái tài khoản khi truyền vào 1 nhân viên
		public void updateTrangThaiTaiKhoan(NhanVien nv) {
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "UPDATE TaiKhoan SET trangThai = 'Nghỉ việc' WHERE maNhanVien = '" + nv.getMaNV() + "'";
				Statement statement = con.createStatement();
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}
