package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {
	public NhanVien_DAO() {
		
	}

	public ArrayList<NhanVien> getalltbNhanVien() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String manv1 = rs.getString(1);
				String tennv = rs.getString(2);
				boolean gioitinh = rs.getBoolean(3);
				String vitri = rs.getString(4);
				String sdt = rs.getString(5);
				String email = rs.getString(6);
				String diachi = rs.getString(7);
				String cancuoc = rs.getString(8);
				LocalDate ngaysinh = rs.getDate(9).toLocalDate();
				LocalDate ngayvaolam = rs.getDate(10).toLocalDate();
				LocalDate ngaynghiviec = null;
				Date dateNgayNghiViec = rs.getDate(11);
				if (dateNgayNghiViec != null) {
				    ngaynghiviec = dateNgayNghiViec.toLocalDate();
				}

				String trangthai = rs.getString(12);
				String trinhdo = rs.getString(13);
				Blob anhBlob = rs.getBlob(14);
				byte[] anhBytes = null;
				if (anhBlob != null) {
				    anhBytes = anhBlob.getBytes(1, (int) anhBlob.length());
				}
				double hesoluong = rs.getDouble(15);
				double luongcoban = rs.getDouble(16);
				
				NhanVien nv = new NhanVien(manv1, tennv, gioitinh, vitri, sdt, email, diachi, cancuoc, ngaysinh, ngayvaolam,
						ngaynghiviec, trangthai, trinhdo, anhBytes, hesoluong, luongcoban);
				dsnv.add(nv);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public ArrayList<NhanVien> getNhanVienTiepTan() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien where viTri = N'Nhân Viên Tiếp Tân'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String manv1 = rs.getString(1);
				String tennv = rs.getString(2);
				boolean gioitinh = rs.getBoolean(3);
				String vitri = rs.getString(4);
				String sdt = rs.getString(5);
				String email = rs.getString(6);
				String diachi = rs.getString(7);
				String cancuoc = rs.getString(8);
				LocalDate ngaysinh = rs.getDate(9).toLocalDate();
				LocalDate ngayvaolam = rs.getDate(10).toLocalDate();
				LocalDate ngaynghiviec = null;
				Date dateNgayNghiViec = rs.getDate(11);
				if (dateNgayNghiViec != null) {
				    ngaynghiviec = dateNgayNghiViec.toLocalDate();
				}

				String trangthai = rs.getString(12);
				String trinhdo = rs.getString(13);
				Blob anhBlob = rs.getBlob(14);
				byte[] anhBytes = null;
				if (anhBlob != null) {
				    anhBytes = anhBlob.getBytes(1, (int) anhBlob.length());
				}
				double hesoluong = rs.getDouble(15);
				double luongcoban = rs.getDouble(16);
				
				NhanVien nv = new NhanVien(manv1, tennv, gioitinh, vitri, sdt, email, diachi, cancuoc, ngaysinh, ngayvaolam,
						ngaynghiviec, trangthai, trinhdo, anhBytes, hesoluong, luongcoban);
				dsnv.add(nv);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public NhanVien getNhanVienTheoMaNV(String manv){
		NhanVien nv = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from NhanVien where maNhanVien = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, manv);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
            	String manv1 = rs.getString(1);
				String tennv = rs.getString(2);
				boolean gioitinh = rs.getBoolean(3);
				String vitri = rs.getString(4);
				String sdt = rs.getString(5);
				String email = rs.getString(6);
				String diachi = rs.getString(7);
				String cancuoc = rs.getString(8);
				LocalDate ngaysinh = rs.getDate(9).toLocalDate();
				LocalDate ngayvaolam = rs.getDate(10).toLocalDate();
				LocalDate ngaynghiviec = null;
				Date dateNgayNghiViec = rs.getDate(11);
				if (dateNgayNghiViec != null) {
				    ngaynghiviec = dateNgayNghiViec.toLocalDate();
				}

				String trangthai = rs.getString(12);
				String trinhdo = rs.getString(13);
				Blob anhBlob = rs.getBlob(14);
				byte[] anhBytes = null;
				if (anhBlob != null) {
				    anhBytes = anhBlob.getBytes(1, (int) anhBlob.length());
				}
				double hesoluong = rs.getDouble(15);
				double luongcoban = rs.getDouble(16);
				
				nv = new NhanVien(manv1, tennv, gioitinh, vitri, sdt, email, diachi, cancuoc, ngaysinh, ngayvaolam,
						ngaynghiviec, trangthai, trinhdo, anhBytes, hesoluong, luongcoban);
            }
         } catch (SQLException ee) {
                ee.printStackTrace();
            	
            }
	            return nv;
        }
	public boolean themNhanVien(NhanVien nv) {
		int n = 0;
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Insert into NhanVien (maNhanVien, hoTen, gioiTinh, viTri, soDT, email, diaChi, canCuoc, ngaySinh, ngayVaoLam, ngayNghiLam, trangThai, trinhDoHocVan, anhDaiDien, heSoLuong, luongCoBan)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, nv.getMaNV());
			statement.setString(2, nv.getHoTenNV());
			statement.setBoolean(3, nv.isGioiTinh());
			statement.setString(4, nv.getViTri());
			statement.setString(5, nv.getSoDT());
			statement.setString(6, nv.getEmail());
			statement.setString(7, nv.getDiaChi());
			statement.setString(8, nv.getCanCuoc());
			statement.setDate(9, Date.valueOf(nv.getNgaySinh()));
			statement.setDate(10, Date.valueOf(nv.getNgayVaoLam()));
			if (nv.getNgayNghiLam() != null) {
				statement.setDate(11, Date.valueOf(nv.getNgayNghiLam()));
			} else {
				statement.setDate(11, null);
			}
			statement.setString(12, nv.getTrangThai());
			statement.setString(13, nv.getTrinhDoHocVan());
			statement.setBytes(14, nv.getAnhDaiDien());
			statement.setDouble(15, nv.getHeSoLuong());
			statement.setDouble(16, nv.getLuongCoBan());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public boolean capNhatNhanVien(NhanVien nv) {
		int n = 0;
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Update NhanVien set hoTen = ?, gioiTinh = ?, viTri = ?, soDT = ?, email = ?, diaChi = ?, canCuoc = ?, ngaySinh = ?, ngayVaoLam = ?, ngayNghiLam = ?, trangThai = ?, trinhDoHocVan = ?, anhDaiDien = ?, heSoLuong = ?, luongCoBan = ? where maNhanVien = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, nv.getHoTenNV());
            statement.setBoolean(2, nv.isGioiTinh());
            statement.setString(3, nv.getViTri());
            statement.setString(4, nv.getSoDT());
            statement.setString(5, nv.getEmail());
            statement.setString(6, nv.getDiaChi());
            statement.setString(7, nv.getCanCuoc());
            statement.setDate(8, Date.valueOf(nv.getNgaySinh()));
            statement.setDate(9, Date.valueOf(nv.getNgayVaoLam()));
            if (nv.getNgayNghiLam() != null) {
                statement.setDate(10, Date.valueOf(nv.getNgayNghiLam()));
            } else {
                statement.setDate(10, null);
            }
            statement.setString(11, nv.getTrangThai());
            statement.setString(12, nv.getTrinhDoHocVan());
            statement.setBytes(13, nv.getAnhDaiDien());
            statement.setDouble(14, nv.getHeSoLuong());
            statement.setDouble(15, nv.getLuongCoBan());
            statement.setString(16, nv.getMaNV());
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

	
	
}
