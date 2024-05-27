package gui;

import javax.swing.*;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class GUI_ManHinhCho {
    private static Phong_DAO Phong_dao;
	private static String[] soPhong;
	private static KhachHang_DAO khachHang_DAO;
	private static PhieuDatPhong_DAO phieuDatPhong_DAO;

	public static void main(String[] args) {
    	
    	try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Phong_dao  = new Phong_DAO();
		ArrayList<Phong> dsP = Phong_dao.getalltbPhong();
		
		
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		ArrayList<PhieuDatPhong> dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		// kiểm tra trạng thái phòng
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getTrangThai().contains("Đã đặt")&& ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now()) > 0) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
			}
			
			
		}
		LocalDate tghientai = LocalDate.now();
		for (int i = 0; i < dsP.size(); i++) {
			if (!dsP.get(i).getTrangThai().contains("Bảo trì")) {
				Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Trống");
			}
			for(int j = 0; j < dsPDP.size(); j++) {
				
				
				if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
						&& dsPDP.get(j).getTrangThai().contains("Đã đặt")
						&& (dsPDP.get(j).getThoiGianNhan().compareTo(tghientai) == 0)
						) {
					Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Đã đặt");
				}else if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
                        && dsPDP.get(j).getTrangThai().contains("Đã nhận")
                        ) {
					System.out.println(dsP.get(i).getMaPhong());
                    Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Đã thuê");
				}
			}
		}
		
        // Tạo một JFrame
        JFrame frame = new JFrame();
        frame.setSize(564, 781);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setIconImage(new ImageIcon(GUI_ManHinhCho.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 564, 781);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Quản lí khách sạn LLPT");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(0, 68, 564, 68);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("CHAU TIỂU LONG");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(0, 138, 564, 35);
        panel.add(lblNewLabel_1_1);
        
        
        
        JLabel lblNewLabel_1_1_1 = new JLabel("TỐNG THÀNH LỘC");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(0, 178, 564, 35);
        panel.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("NGÔ HỒNG PHƯƠNG");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_2.setBounds(0, 218, 564, 35);
        panel.add(lblNewLabel_1_1_2);
        
        JLabel lblNewLabel_1_1_3 = new JLabel("NGUYỄN NHẬT TÙNG");
        lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_3.setBounds(0, 258, 564, 35);
        panel.add(lblNewLabel_1_1_3);
        
        
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon(GUI_DangNhap.class.getResource("/img/logoiuh.png")).getImage().getScaledInstance(76, 76, java.awt.Image.SCALE_SMOOTH)));
        lblNewLabel_2.setBounds(0, 0, 76, 76);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon(new ImageIcon(GUI_DangNhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH)));
        lblNewLabel_2_1.setBounds(488, 0, 76, 76);
        panel.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(GUI_ManHinhCho.class.getResource("/img/manhinhcho.jpg")));
        lblNewLabel.setBounds(0, 0, 564, 781);
        panel.add(lblNewLabel);
        
        

        // Sử dụng javax.swing.Timer để lên lịch cho việc hiển thị cửa sổ sau 1 phút
        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị cửa sổ khi thời gian đã đến
                frame.dispose();
                new GUI_DangNhap().setVisible(true);
            }
        });
        timer.setRepeats(false); // Không lặp lại

        // Bắt đầu đếm thời gian
        timer.start();

        // Hiển thị JFrame
        frame.setVisible(true);
    }

	private static void setIconImage(Image scaledInstance) {
		// TODO Auto-generated method stub
		
	}
}