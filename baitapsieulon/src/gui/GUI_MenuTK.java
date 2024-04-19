package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.Phong_DAO;
import dao.TaiKhoan_DAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_MenuTK extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Phong_DAO Phong_dao;
	private KhachHang_DAO khachHang_DAO;
	private ArrayList<Phong> dsP;
	private ArrayList<KhachHang> dsKH;
	private TaiKhoan_DAO taiKhoan_DAO;
	private Panel panelTK;
	private JButton btnTKDMK;
	private JButton btnTKDX;
	private JLabel btnTKHTNV;
	private JLabel btnTKTNV;
	private JLabel btnTKca;
	private JLabel btnmaNV;
	private JButton btnTK;
	private NhanVien_DAO nv_dao;
	private NhanVien nv;
	private ArrayList<NhanVien> ListNV;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI_MenuTK(NhanVien nv) {
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1655,85, 247, 218);
		setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getNhanVienTiepTan();
		
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nv = nhanVien;
				break;
			}
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelTK = new Panel();
		panelTK.setBounds(0,0, 247, 218);
		contentPane.add(panelTK);
		panelTK.setLayout(null);
		
		
       
		
		btnTKDMK = new JButton("Đổi mật khẩu");
		btnTKDMK.setBounds(0, 141, 247, 39);
		panelTK.add(btnTKDMK);
		btnTKDMK.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTKDMK.setForeground(new Color(244, 244, 244));
		btnTKDMK.setBackground(new Color(41, 139, 106));
		
		btnTKDX = new JButton("<html><div style='text-align: center;'>Đăng xuất</div></html>");
		btnTKDX.setBounds(0, 179, 247, 39);
		panelTK.add(btnTKDX);
		btnTKDX.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTKDX.setForeground(new Color(244, 244, 244));
		btnTKDX.setBackground(new Color(41, 139, 106));
		
		btnTKHTNV = new JLabel("Họ tên nhân viên");
		btnTKHTNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTKHTNV.setHorizontalAlignment(SwingConstants.CENTER);
		btnTKHTNV.setBounds(0, 26, 247, 20);
		panelTK.add(btnTKHTNV);
		
		btnTKHTNV.setText("Họ tên nhân viên: "+nv.getHoTenNV());
		
		btnTKTNV = new JLabel("Tuổi");
		btnTKTNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTKTNV.setHorizontalAlignment(SwingConstants.CENTER);
		btnTKTNV.setBounds(0, 50, 247, 20);
		panelTK.add(btnTKTNV);
		
		//tuổi bằng năm hiện tại trừ năm sinh
		int namSinh = nv.getNgaySinh().getYear();
		int namHienTai = LocalDate.now().getYear();
		int tuoi = namHienTai - namSinh;
		btnTKTNV.setText("Tuổi: "+tuoi);
		
		
		btnmaNV = new JLabel("Mã nhân viên");
		btnmaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnmaNV.setHorizontalAlignment(SwingConstants.CENTER);
		btnmaNV.setBounds(0, 69, 247, 20);
		panelTK.add(btnmaNV);
		btnmaNV.setText("Mã nhân viên: "+nv.getMaNV());
		
		
		
		
	
	}

}
