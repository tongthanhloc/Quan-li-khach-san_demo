package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.Phong;

public class Phong_DAO {
	private Phong p;
	public Phong_DAO() {
		
	}
	
	
	public ArrayList<Phong> getalltbPhong(){
		ArrayList<Phong> dsP = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from Phong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
		
				String maPhong = rs.getString(1);
				String loaiPhong = rs.getString(2);
				double donGiaTheoNgay = rs.getDouble(3);
				String soGiuong = rs.getString(4);
				String soTang = rs.getString(5);;
				String phongCach = rs.getString(6);
				String trangThai = rs.getString(7);
				String moTa = rs.getString(8);
			    Blob anhBlob= rs.getBlob(9);
			    byte[] hinhAnh = null;
				
				if (anhBlob != null) {
					hinhAnh = anhBlob.getBytes(1, (int) anhBlob.length());
				}
				Phong p = new Phong(maPhong, loaiPhong, donGiaTheoNgay, soGiuong, soTang, phongCach, trangThai, moTa, hinhAnh);
				dsP.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsP;
	}
	public void updateTrangThaiPhong(String maPhong, String trangThaiMoi) {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            // Chuẩn bị câu lệnh SQL cho việc cập nhật trạng thái của phòng
            String sql = "UPDATE Phong SET trangThai = ? WHERE maPhong = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            // Thiết lập giá trị cho các tham số của câu lệnh SQL
            statement.setString(1, trangThaiMoi);
            statement.setString(2, maPhong);
            // Thực hiện câu lệnh SQL cập nhật
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public Phong getPhongTheoMaPhong(String maPh) {
		Phong p = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from Phong where maPhong = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maPh);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString(1);
				String loaiPhong = rs.getString(2);
				double donGiaTheoNgay = rs.getDouble(3);
				String soGiuong = rs.getString(4);
				String soTang = rs.getString(5);
				;
				String phongCach = rs.getString(6);
				String trangThai = rs.getString(7);
				String moTa = rs.getString(8);
				Blob anhBlob= rs.getBlob(9);
				byte[] hinhAnh = null;
				if (anhBlob != null) {
					hinhAnh = anhBlob.getBytes(1, (int) anhBlob.length());
				}
				p = new Phong(maPhong, loaiPhong, donGiaTheoNgay, soGiuong, soTang, phongCach, trangThai, moTa,
						hinhAnh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
		
	}
	// tạo 1 hàm set trạng thái phòng theo mã phòng
	public void setTrangThaiPhong(String maPhong, String trangThai) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Update Phong set trangThai = ? where maPhong = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, trangThai);
			statement.setString(2, maPhong);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
