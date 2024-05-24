package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatDichVu;
public class DAO_PhieuDatDichVu {
	public DAO_PhieuDatDichVu() {
	
	}
	//lấy danh sách phiếu đặt dịch vụ
	public ArrayList<PhieuDatDichVu> getDSPhieuDatDichVu() {
		ArrayList<PhieuDatDichVu> dsPhieuDatDichVu = new ArrayList<PhieuDatDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from PhieuDatDichVu;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String maPhieu = rs.getString(1);
				LocalDate ngayDat = rs.getDate(2).toLocalDate();
				double donGia = rs.getDouble(3);
				int soLuong = rs.getInt(4);
				DichVu dichVu = new DichVu(rs.getString(5));
				KhachHang khachHang = new KhachHang(rs.getString(6));
				NhanVien nhanVien = new NhanVien(rs.getString(7));
				String trangThai = rs.getString(8);
				HoaDon hoaDon = new HoaDon(rs.getString(9));
				double giaTrThue = rs.getDouble(10);
				PhieuDatDichVu phieuDatDichVu = new PhieuDatDichVu(maPhieu, ngayDat, donGia, soLuong, dichVu, khachHang, nhanVien, trangThai, hoaDon, giaTrThue);
				dsPhieuDatDichVu.add(phieuDatDichVu);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDatDichVu;
	}
	// insert phiếu đặt dịch vụ
	public void insertPhieuDichVu(PhieuDatDichVu pdv) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into PhieuDatDichVu (maPhieu, thoiGianDat, donGia, soLuong, maDichVu, maKhachHang, maNhanVien, trangThai, maHoaDon, giaTrcThue) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, pdv.getMaPhieu());
			stmt.setDate(2, java.sql.Date.valueOf(pdv.getThoiGianDat()));
			stmt.setDouble(3, pdv.getDonGia());
			stmt.setInt(4, pdv.getSoLuong());
			stmt.setString(5, pdv.getDichVu().getMaDichVu());
			stmt.setString(6, pdv.getKhachHang().getmaKH());
			stmt.setString(7, pdv.getNhanVien().getMaNV());
			stmt.setString(8, pdv.getTrangThai());
			stmt.setString(9, null);
			stmt.setDouble(10, pdv.getGiaTrcThue());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Lấy danh sách phiếu đặt chưa thanh toán và mã khách hàng
	public ArrayList<PhieuDatDichVu> getDSPhieuDatChuaThanhToan(String maKH) {
		ArrayList<PhieuDatDichVu> dsPhieuDatDichVu = new ArrayList<PhieuDatDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from PhieuDatDichVu where maKhachHang = ? and trangThai = N'Chưa thanh toán';";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maKH);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maPhieu = rs.getString(1);
				LocalDate ngayDat = rs.getDate(2).toLocalDate();
				double donGia = rs.getDouble(3);
				int soLuong = rs.getInt(4);
				DichVu dichVu = new DichVu(rs.getString(5));
				KhachHang khachHang = new KhachHang(rs.getString(6));
				NhanVien nhanVien = new NhanVien(rs.getString(7));
				String trangThai = rs.getString(8);
				HoaDon hoaDon = new HoaDon(rs.getString(9));
				double giaTrThue = rs.getDouble(10);
				PhieuDatDichVu phieuDatDichVu = new PhieuDatDichVu(maPhieu, ngayDat, donGia, soLuong, dichVu, khachHang,
						nhanVien, trangThai, hoaDon, giaTrThue);
				dsPhieuDatDichVu.add(phieuDatDichVu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDatDichVu;
	}
	// Set trạng thái đã thanh toán
	public void updateTrangThaiPhieuDatDichVu(String maPhieu) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update PhieuDatDichVu set trangThai = N'Đã thanh toán' where maPhieu = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maPhieu);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Update maHoaDon cho Phiếu đặt dịch vụ
	public void updateMaHoaDonPhieuDatDichVu(PhieuDatDichVu pdv, String maHoaDon) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update PhieuDatDichVu set maHoaDon = ? where maPhieu = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maHoaDon);
			stmt.setString(2, pdv.getMaPhieu());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Lấy danh sách phiếu đặt dịch vụ theo năm
	public ArrayList<PhieuDatDichVu> getDSPhieuDatDichVuTheoNam(int nam) {
		ArrayList<PhieuDatDichVu> dsPhieuDatDichVu = new ArrayList<PhieuDatDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from PhieuDatDichVu where year(thoiGianDat) = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, nam);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maPhieu = rs.getString(1);
				LocalDate ngayDat = rs.getDate(2).toLocalDate();
				double donGia = rs.getDouble(3);
				int soLuong = rs.getInt(4);
				DichVu dichVu = new DichVu(rs.getString(5));
				KhachHang khachHang = new KhachHang(rs.getString(6));
				NhanVien nhanVien = new NhanVien(rs.getString(7));
				String trangThai = rs.getString(8);
				HoaDon hoaDon = new HoaDon(rs.getString(9));
				double giaTrThue = rs.getDouble(10);
				PhieuDatDichVu phieuDatDichVu = new PhieuDatDichVu(maPhieu, ngayDat, donGia, soLuong, dichVu, khachHang,
						nhanVien, trangThai, hoaDon, giaTrThue);
				dsPhieuDatDichVu.add(phieuDatDichVu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDatDichVu;
	}
}