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
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;

public class PhieuDatPhong_DAO {
	public PhieuDatPhong_DAO() {

	}
	public ArrayList<PhieuDatPhong> getAllTbPhieuDatPhong(){
		ArrayList<PhieuDatPhong> dsPDP = new ArrayList<PhieuDatPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuDatPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieuDatPhong = rs.getString(1);
				LocalDate ngayDat = rs.getDate(2).toLocalDate();
				LocalDate ngayNhan = rs.getDate(3).toLocalDate();
				LocalDate ngayTra = rs.getDate(4).toLocalDate();
				double dongia = rs.getDouble(5);
				Phong p = new Phong(rs.getString("maPhong"));
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
				String tt = rs.getString("trangThai");
			    PhieuDatPhong pdp = new PhieuDatPhong(maPhieuDatPhong, ngayDat, ngayNhan, ngayTra, dongia, p, kh, nv, tt);
				dsPDP.add(pdp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPDP;
	}
	public void insertPhieuDatPhong(ArrayList<PhieuDatPhong> danhSachPhieuDatPhong) {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            // Chuẩn bị câu lệnh SQL cho việc chèn dữ liệu
            String sql = "INSERT INTO PhieuDatPhong (maPhieu, thoiGianDat, thoiGianNhan, thoiGianTra, donGiaPhieu, maPhong, maKhachHang, maNhanVien) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            // Duyệt qua danh sách các đối tượng PhieuDatPhong và chèn từng đối tượng này vào cơ sở dữ liệu
            for (PhieuDatPhong pdp : danhSachPhieuDatPhong) {
                statement.setString(1, pdp.getMaPhieu());
                statement.setDate(2, Date.valueOf(pdp.getThoiGianDat()));
                statement.setDate(3, Date.valueOf(pdp.getThoiGianNhan()));
                statement.setDate(4, Date.valueOf(pdp.getThoiGianTra()));
                statement.setDouble(5, pdp.getDonGiaPhieu());
                statement.setString(6, pdp.getPhong().getMaPhong());
                statement.setString(7, pdp.getKhachHang().getmaKH());
                statement.setString(8, pdp.getNhanVien().getMaNV());
                statement.setString(9, pdp.getTrangThai());
                
                // Thực hiện câu lệnh chèn dữ liệu
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void updateTrangThaiPhieuDatPhong(String maPhieu, String trangThaiMoi) {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            // Chuẩn bị câu lệnh SQL cho việc cập nhật trạng thái của phiếu đặt phòng
            String sql = "UPDATE PhieuDatPhong SET trangThai = ? WHERE maPhieu = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            // Thiết lập giá trị cho các tham số của câu lệnh SQL
            statement.setString(1, trangThaiMoi);
            statement.setString(2, maPhieu);
            // Thực hiện câu lệnh SQL cập nhật
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }}
	
}
