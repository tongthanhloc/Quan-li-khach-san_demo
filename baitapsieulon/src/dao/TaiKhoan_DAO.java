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

public class TaiKhoan_DAO {
	public TaiKhoan_DAO() {
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
	
}
