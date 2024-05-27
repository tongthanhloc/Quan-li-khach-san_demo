package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.NhanVien;


public class DAO_DichVu {
	

    
	private Object preparedStatement;
	public DAO_DichVu() {

	}
	
	public ArrayList<DichVu> getalltbDichVu() {
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int thueVAT = rs.getInt(3);
				String nhaCCDV = rs.getString(4);
				Double donGia = rs.getDouble(5);
				int soLuong = rs.getInt(6);
				String tranThai = rs.getString(7);
				DichVu dv = new DichVu(maDichVu, tenDichVu, thueVAT, nhaCCDV, donGia, soLuong, tranThai);
				dsDV.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDV;
	}
	
	public ArrayList<String> getTenDichVuByMaDichVu() {
		ArrayList<String> tenDichVus = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT tenDichVu FROM DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String tenDichVu = rs.getString("tenDichVu");
				tenDichVus.add(tenDichVu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenDichVus;
	}
	
	// lấy dịch vụ theo mã
	public DichVu getDichVuByMa(String maDichVu) {
		DichVu dv = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu where maDichVu = '" + maDichVu + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String tenDichVu = rs.getString(2);
				int thueVAT = rs.getInt(3);
				String nhaCCDV = rs.getString(4);
				Double donGia = rs.getDouble(5);
				int soLuong = rs.getInt(6);
				String trangThai = rs.getString(7);
				dv = new DichVu(maDichVu, tenDichVu, thueVAT, nhaCCDV, donGia, soLuong, trangThai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dv;
	}
	
	/// getTenDichVuByMaDichVu
	
	// LẤY HẾT DỮ LIỆU CỦA DỊCH VỤ
	public ArrayList<DichVu> getAllDichVu() {
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int thueVAT = rs.getInt(3);
				String nhaCCDV = rs.getString(4);
				Double donGia = rs.getDouble(5);
				int soLuong = rs.getInt(6);
				String trangThai = rs.getString(7);
				DichVu dv = new DichVu(maDichVu, tenDichVu, thueVAT, nhaCCDV, donGia, soLuong , trangThai);
				dsDV.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDV;
	}
	// update dịch vụ , Thêm N" " Cập nhật để tránh lỗi font
	// CẤU Trúc câu lệnh updateDichVu giống dưới đây
//	public boolean capNhatNhanVien(NhanVien nv) {
//		int n = 0;
//        PreparedStatement statement = null;
//        try {
//            ConnectDB.getInstance();
//            Connection con = ConnectDB.getConnection();
//            String sql = "Update NhanVien set hoTen = ?, gioiTinh = ?, viTri = ?, soDT = ?, email = ?, diaChi = ?, canCuoc = ?, ngaySinh = ?, ngayVaoLam = ?, ngayNghiLam = ?, trangThai = ?, trinhDoHocVan = ?, anhDaiDien = ?, heSoLuong = ?, luongCoBan = ? where maNhanVien = ?";
//            statement = con.prepareStatement(sql);
//            statement.setString(1, nv.getHoTenNV());
//            statement.setBoolean(2, nv.isGioiTinh());
//            statement.setString(3, nv.getViTri());
//            statement.setString(4, nv.getSoDT());
//            statement.setString(5, nv.getEmail());
//            statement.setString(6, nv.getDiaChi());
//            statement.setString(7, nv.getCanCuoc());
//            statement.setDate(8, Date.valueOf(nv.getNgaySinh()));
//            statement.setDate(9, Date.valueOf(nv.getNgayVaoLam()));
//            if (nv.getNgayNghiLam() != null) {
//                statement.setDate(10, Date.valueOf(nv.getNgayNghiLam()));
//            } else {
//                statement.setDate(10, null);
//            }
//            statement.setString(11, nv.getTrangThai());
//            statement.setString(12, nv.getTrinhDoHocVan());
//            statement.setBytes(13, nv.getAnhDaiDien());
//            statement.setDouble(14, nv.getHeSoLuong());
//            statement.setDouble(15, nv.getLuongCoBan());
//            statement.setString(16, nv.getMaNV());
//            n = statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                statement.close();
//            } catch (Exception e) {
//            	e.printStackTrace();
//           }
//        }
//        return n > 0;
//	}
//	
	
	// sua dich vu giong nhan vien o tren
	public boolean updateDichVu(DichVu dv) {
        int n = 0;
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "update DichVu set tenDichVu = ?, thueVAT = ?, nhaCCDV = ?, donGia = ?, soLuong = ?, trangThai = ? where maDichVu = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, dv.getTenDichVu());
            statement.setInt(2, dv.getThueVAT());
            statement.setString(3, dv.getNhaCCDV());
            statement.setDouble(4, dv.getDonGia());
            statement.setInt(5, dv.getSoLuong());
            statement.setString(6, dv.getTrangThai());
            statement.setString(7, dv.getMaDichVu());
            n = statement.executeUpdate();
            } catch (SQLException e) {
            	e.printStackTrace();
            	
            }
        finally {
        	            try {
                statement.close();
            } catch (Exception e) {
            	e.printStackTrace();
           }
        }
        return n > 0;
	}
	// thêm dịch vụ
	
	public boolean themDichVu(DichVu dv) {
        int n = 0;
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "insert into DichVu values(?,?,?,?,?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, dv.getMaDichVu());
            statement.setString(2, dv.getTenDichVu());
            statement.setInt(3, dv.getThueVAT());
            statement.setString(4, dv.getNhaCCDV());
            statement.setDouble(5, dv.getDonGia());
            statement.setInt(6, dv.getSoLuong());
            statement.setString(7, dv.getTrangThai());
            n = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (Exception e) {
            	e.printStackTrace();
           }
        }
        return n > 0;
	}
	//giam so luong dich vu
	public boolean giamSoLuongDichVu(DichVu dv) {
        int n = 0;
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "update DichVu set soLuong = ? where maDichVu = ?";
            statement = con.prepareStatement(sql);
            statement.setInt(1, dv.getSoLuong());
            statement.setString(2, dv.getMaDichVu());
            n = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
     }

	
}
