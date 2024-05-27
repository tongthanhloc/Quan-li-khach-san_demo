package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class GUI_ChiTietKH extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmaKH;
	private JTextField txtTenKH;
	private JTextField txtTuoi;
	private JTextField txtSDT;
	private JTextField txtMail;
	private JTextField txtDC;
	private JTextField txtHang;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI_ChiTietKH(String maKH) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 550);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		//boder
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
		KhachHang khachHang = khachHang_DAO.getKhachHangByMaKhachHang(maKH);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Thông tin Khách Hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 79, 521, 149);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Mã Khách hàng");
		lblNewLabel.setBounds(12, 24, 106, 16);
		panel.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setBounds(12, 53, 106, 16);
		panel.add(lblHTn);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setBounds(12, 84, 106, 16);
		panel.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh");
		lblNgySinh.setBounds(12, 113, 66, 16);
		panel.add(lblNgySinh);
		
		JDateChooser dateNgaySinh = new JDateChooser();
		dateNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateNgaySinh.setBounds(119, 110, 380, 22);
		panel.add(dateNgaySinh);
		
		txtmaKH = new JTextField();
		txtmaKH.setColumns(10);
		txtmaKH.setBounds(119, 21, 380, 22);
		panel.add(txtmaKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(119, 50, 380, 22);
		panel.add(txtTenKH);
		
		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setBounds(126, 80, 51, 25);
		panel.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(194, 80, 43, 25);
		panel.add(rdNu);
		
		JLabel lblTui = new JLabel("Tuổi");
		lblTui.setBounds(308, 84, 38, 16);
		panel.add(lblTui);
		
		txtTuoi = new JTextField();
		txtTuoi.setEditable(false);
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(341, 81, 159, 22);
		panel.add(txtTuoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Thông tin loại khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 381, 520, 94);
		contentPane.add(panel_1);
		
		JLabel lblNgyVoLm = new JLabel("Hạng Khách Hàng");
		lblNgyVoLm.setBounds(24, 57, 114, 16);
		panel_1.add(lblNgyVoLm);
		
		JLabel lblTnhTrng = new JLabel("Điểm");
		lblTnhTrng.setBounds(24, 29, 80, 16);
		panel_1.add(lblTnhTrng);
		
		JTextField txtDiem = new JTextField();
		txtDiem.setColumns(10);
		txtDiem.setBounds(148, 26, 344, 22);
		txtDiem.setEditable(false);
		panel_1.add(txtDiem);
		
		txtHang = new JTextField();
		txtHang.setColumns(10);
		txtHang.setBounds(148, 54, 344, 22);
		txtHang.setEditable(false);
		panel_1.add(txtHang);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin li\u00EAn lac", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 239, 521, 131);
		contentPane.add(panel_2);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(22, 26, 79, 16);
		panel_2.add(lblSinThoi);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(121, 23, 375, 22);
		panel_2.add(txtSDT);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 58, 79, 16);
		panel_2.add(lblEmail);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(121, 55, 375, 22);
		panel_2.add(txtMail);
		
		JLabel lblSinThoi_1_1 = new JLabel("Địa chỉ");
		lblSinThoi_1_1.setBounds(22, 90, 79, 16);
		panel_2.add(lblSinThoi_1_1);
		
		txtDC = new JTextField();
		txtDC.setColumns(10);
		txtDC.setBounds(121, 87, 375, 22);
		panel_2.add(txtDC);
		
		JButton btnCpNht = new JButton("Cập Nhật");
		btnCpNht.setForeground(Color.WHITE);
		btnCpNht.setBackground(new Color(55, 149, 128));
		btnCpNht.setBounds(10, 486, 116, 45);
		contentPane.add(btnCpNht);
		
		btnCpNht.addActionListener(e -> {
			String maKH1 = txtmaKH.getText();
			String hoTen = txtTenKH.getText();
			Boolean gioiTinh = rdNam.isSelected();
			java.sql.Date ngaySinh = new java.sql.Date(dateNgaySinh.getDate().getTime());
			String soDT = txtSDT.getText();
			String email = txtMail.getText();
			String diaChi = txtDC.getText();
			
			KhachHang kh = new KhachHang(maKH1, hoTen, gioiTinh, ngaySinh.toLocalDate(), soDT, diaChi, email, khachHang.getDiem(), khachHang.getHang(), khachHang.getNgayDatDau());
			khachHang_DAO.suaKhachHang(kh);
			GUI_QuanLiKhachHang.dskh = khachHang_DAO.getalltbKhachHang();
			GUI_QuanLiKhachHang.modelHD.setRowCount(0);
			GUI_QuanLiKhachHang.dskh.forEach(kh1 -> {
				GUI_QuanLiKhachHang.modelHD.addRow(new Object[] { kh1.getmaKH(), kh1.getHoTen(),
						kh1.getGioiTinh() ? "Nam" : "Nữ", kh1.getNgaySinh(), kh1.getSoDT(), kh1.getEmail(),
						kh1.getDiaChi(), kh1.getDiem(), kh1.getHang() });
			});
			
			
		});
		
		JButton btnXaTrng = new JButton("Xóa trắng");
		btnXaTrng.setForeground(Color.WHITE);
		btnXaTrng.setBackground(new Color(55, 149, 128));
		btnXaTrng.setBounds(143, 486, 116, 45);
		contentPane.add(btnXaTrng);
		btnXaTrng.addActionListener(e -> {
			txtmaKH.setText("");
			txtTenKH.setText("");
			rdNam.setSelected(false);
			rdNu.setSelected(false);
			dateNgaySinh.setDate(null);
			txtSDT.setText("");
			txtMail.setText("");
			txtDC.setText("");
			txtDiem.setText("");
			txtHang.setText("");
			txtTuoi.setText("");
			
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(164, 194, 163));
		panel_5.setBounds(10, 11, 521, 57);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Thông tin Khách hàng");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_4.setBackground(new Color(164, 194, 163));
		lblNewLabel_4.setBounds(0, 0, 521, 57);
		panel_5.add(lblNewLabel_4);
		
		JButton btnKhoiPhuc = new JButton("Khôi Phục");
		btnKhoiPhuc.setForeground(Color.WHITE);
		btnKhoiPhuc.setBackground(new Color(55, 149, 128));
		btnKhoiPhuc.setBounds(280, 486, 116, 45);
		contentPane.add(btnKhoiPhuc);
		
		btnKhoiPhuc.addActionListener(e -> {
			txtmaKH.setText(khachHang.getmaKH());
			txtTenKH.setText(khachHang.getHoTen());
			if (khachHang.getGioiTinh()) {
				rdNam.setSelected(true);
			} else {
				rdNu.setSelected(true);
			}
			// truyen localdate sang date
			Date date = java.sql.Date.valueOf(khachHang.getNgaySinh());
			dateNgaySinh.setDate(date);
			txtSDT.setText(khachHang.getSoDT());
			txtMail.setText(khachHang.getEmail());
			txtDC.setText(khachHang.getDiaChi());
			txtDiem.setText(String.valueOf(khachHang.getDiem()));
			txtHang.setText(khachHang.getHang());
			int tuoi = khachHang.getNgaySinh().until(java.time.LocalDate.now()).getYears();
			txtTuoi.setText(String.valueOf(tuoi));
		});
		
		txtmaKH.setText(khachHang.getmaKH());
		txtTenKH.setText(khachHang.getHoTen());
		if(khachHang.getGioiTinh()) {
            rdNam.setSelected(true);
        }else {
        	rdNu.setSelected(true);
        }
		//truyen localdate sang date
		Date date = java.sql.Date.valueOf(khachHang.getNgaySinh());
		dateNgaySinh.setDate(date);
		txtSDT.setText(khachHang.getSoDT());
		txtMail.setText(khachHang.getEmail());
		txtDC.setText(khachHang.getDiaChi());
		txtDiem.setText(String.valueOf(khachHang.getDiem()));
		txtHang.setText(khachHang.getHang());
		int tuoi = khachHang.getNgaySinh().until(java.time.LocalDate.now()).getYears();
		txtTuoi.setText(String.valueOf(tuoi));
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(55, 149, 128));
		btnDong.setBounds(415, 486, 116, 45);
		contentPane.add(btnDong);
		btnDong.addActionListener(e -> {
			this.dispose();
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				rdNam.addActionListener(e -> {
					rdNu.setSelected(false);
				});
				rdNu.addActionListener(e -> {
					rdNam.setSelected(false);
				});
			}
		});
		
		
		
		
		
	}
}
