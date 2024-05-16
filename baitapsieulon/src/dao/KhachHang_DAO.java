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
				int diem = rs.getInt(8);
				String hang = rs.getString(9);
				LocalDate ngayBatDau = rs.getDate(10).toLocalDate();
				
				KhachHang kh = new KhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, soDT, diaChi, email, diem, hang, ngayBatDau);
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
	//them khach hang
	public boolean themKhachHang(KhachHang kh) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Insert into KhachHang values(?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getHoTen());
			statement.setBoolean(3, kh.getGioiTinh());
			statement.setDate(4, java.sql.Date.valueOf(kh.getNgaySinh()));
			statement.setString(5, kh.getSoDT());
			statement.setString(6, kh.getDiaChi());
			statement.setString(7, kh.getEmail());
			statement.setInt(8, kh.getDiem());
			statement.setString(9, kh.getHang());
			statement.setDate(10, java.sql.Date.valueOf(kh.getNgayBatDau()));
			
			
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public KhachHang getOneKhachHangByMaKhachHang(String maKH) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang where maKhachHang = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maKhachHang = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String diaChi = rs.getString(6);
				String email = rs.getString(7);
				int diem = rs.getInt(8);
				String hang = rs.getString(9);
				LocalDate ngayBatDau = rs.getDate(10).toLocalDate();

				KhachHang kh = new KhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, soDT, diaChi, email, diem, hang,
						ngayBatDau);
				return kh;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//sua khach hang
	public boolean suaKhachHang(KhachHang kh) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Update KhachHang set hoTen = ?, gioiTinh = ?, ngaySinh = ?, soDienThoai = ?, diaChi = ?, email = ?, diem = ?, hang = ?, ngayDatDau = ? where maKhachHang = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, kh.getHoTen());
			statement.setBoolean(2, kh.getGioiTinh());
			statement.setDate(3, java.sql.Date.valueOf(kh.getNgaySinh()));
			statement.setString(4, kh.getSoDT());
			statement.setString(5, kh.getDiaChi());
			statement.setString(6, kh.getEmail());
			statement.setInt(7, kh.getDiem());
			statement.setString(8, kh.getHang());
			statement.setDate(9, java.sql.Date.valueOf(kh.getNgayBatDau()));
			statement.setString(10, kh.getMaKH());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	

}