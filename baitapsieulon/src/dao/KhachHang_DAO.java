package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.KhachHang;


public class KhachHang_DAO {
	public KhachHang_DAO() {
		
	}
	
	
	public ArrayList<KhachHang> getalltbKhachHang(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
		
				String maKhachHang = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String diaChi = rs.getString(6);
				String email = rs.getString(7);
				String anhCanCuoc = rs.getString(8);
				KhachHang kh = new KhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, soDT, diaChi, email, anhCanCuoc);
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	public ArrayList<String> getTenKhachHangByMaKhachHang() {
	    ArrayList<String> tenKhachHangs = new ArrayList<>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT hoTen FROM KhachHang";
	        Statement statement = con.createStatement();
	        ResultSet rs = statement.executeQuery(sql);
	        while(rs.next()) {
	            String tenKhachHang = rs.getString("hoTen");
	            tenKhachHangs.add(tenKhachHang);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return tenKhachHangs;
	}

	

}