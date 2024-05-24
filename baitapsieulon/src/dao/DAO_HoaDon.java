package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;


import entity.HoaDon;
import connectDB.ConnectDB;

public class DAO_HoaDon {
	public DAO_HoaDon() {
		
	}
	//Lấy all hóa đơn
	public ArrayList<HoaDon> getalltbHoaDon(){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HoaDon;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String maHoaDon = rs.getString(1);
				LocalDate ngayLapHoaDon = rs.getDate(2).toLocalDate();
				String trangThai = rs.getString(3);
				double giaTrcThue = rs.getDouble(4);
				double thanhTien = rs.getDouble(5);
				HoaDon hd = new HoaDon(maHoaDon, ngayLapHoaDon, trangThai, giaTrcThue, thanhTien);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	// Insert HoaDon
	public boolean insertHoaDon(HoaDon hd) {
		int n = 0;
		PreparedStatement stmt = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into HoaDon (maHoaDon, ngayLap, trangThai, giaTrcThue, thanhTien) values (?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setDate(2, Date.valueOf(hd.getNgayLap()));
			stmt.setString(3, hd.getTrangThai());
			stmt.setDouble(4, hd.getGiaTrcThue());
			stmt.setDouble(5, hd.getThanhTien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
	return n > 0;
	}
	// Tìm Hóa đơn theo mã
	public HoaDon timHoaDonTheoMa(String maDH) {
		HoaDon hd = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "select * from HoaDon where maHoaDon = ?";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String maHoaDon = rs.getString(1);
				LocalDate ngayLapHoaDon = rs.getDate(2).toLocalDate();
				String trangThai = rs.getString(3);
				double giaTrcThue = rs.getDouble(4);
				double thanhTien = rs.getDouble(5);
				hd = new HoaDon(maHoaDon, ngayLapHoaDon, trangThai, giaTrcThue, thanhTien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hd;
	}
} 
