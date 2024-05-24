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
				String diem = rs.getString(8);
				String hang = rs.getString(9);
				String ngayDatDau = rs.getString(10);
				KhachHang kh = new KhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, soDT, diaChi, email, diem, hang,
						ngayDatDau);
				
			
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
			statement.setString(1, kh.getmaKH());
			statement.setString(2, kh.getHoTen());
			statement.setBoolean(3, kh.getGioiTinh());
			statement.setDate(4, java.sql.Date.valueOf(kh.getNgaySinh()));
			statement.setString(5, kh.getSoDT());
			statement.setString(6, kh.getDiaChi());
			statement.setString(7, kh.getEmail());
			statement.setString(8, kh.getDiem());
			statement.setString(9, kh.getHang());
			statement.setDate(10, java.sql.Date.valueOf(kh.getNgayDatDau()));
			
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// Lấy dữ liệu khách hàng theo mã khách hàng
	public KhachHang getKhachHangByMaKhachHang(String maKH){
		KhachHang kh = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang where maKhachHang = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maKhachHang = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				LocalDate ngaySinh = rs.getDate(4).toLocalDate();
				String soDT = rs.getString(5);
				String diaChi = rs.getString(6);
				String email = rs.getString(7);
				String diem = rs.getString(8);
				String hang = rs.getString(9);
				String ngayDatDau = rs.getString(10);
				kh = new KhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, soDT, diaChi, email, diem, hang, ngayDatDau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
	// Cập nhập điểm cho khách hàng
	public boolean capNhapDiem(String maKH, int diem) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			// Điểm = Điểm + diem
			String sql = "Update KhachHang set diem = diem + ? where maKhachHang = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, diem);
			statement.setString(2, maKH);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// Lấy điểm khách hàng
	public int getDiemKhachHang(String maKH) {
		int diem = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select diem from KhachHang where maKhachHang = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				diem = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diem;
	}
	// Cập nhật hạng cho khách hàng
	public boolean capNhapHang(String maKH, String hang) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Update KhachHang set hang = ? where maKhachHang = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, hang);
			statement.setString(2, maKH);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//sua khach hang
	public boolean suaKhachHang(KhachHang kh) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Update KhachHang set hoTen = ?, gioiTinh = ?, ngaySinh = ?, soDT = ?, diaChi = ?, email = ?, diem = ?, hang = ?, ngayDatDau = ? where maKhachHang = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, kh.getHoTen());
			statement.setBoolean(2, kh.getGioiTinh());
			statement.setDate(3, java.sql.Date.valueOf(kh.getNgaySinh()));
			statement.setString(4, kh.getSoDT());
			statement.setString(5, kh.getDiaChi());
			statement.setString(6, kh.getEmail());
			statement.setString(7, kh.getDiem());
			statement.setString(8, kh.getHang());
			statement.setDate(9, java.sql.Date.valueOf(kh.getNgayDatDau()));
			statement.setString(10, kh.getmaKH());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	

}