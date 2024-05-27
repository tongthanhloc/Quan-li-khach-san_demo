package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;



public class GUI_NhanPhong extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblNewLabel_1_4;
    private JPanel panelP;
    private JLabel lblNewLabel_7;
    static JTextField txtmaP;
    private JLabel lblNewLabel_8;
    static JTextField txtNguoi;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JTextField textField_8;
    private JTextField textField_9;
    private JButton bntNhanP;
    private JButton btnHy;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[] ;//= {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	
	private JPanel panelKH;
	private JTextField txtGT;
	private JButton btnTim;
	private ArrayList<Phong> dsP;
	private KhachHang_DAO khachHang_DAO;
	private ArrayList<KhachHang> dsKH;
	private PhieuDatPhong_DAO phieuDatPhong_DAO;
	private ArrayList<PhieuDatPhong> dsPDP;
	private JPanel outerPanel;
	private JPanel panel;
	private static ArrayList<PhieuDatPhong> dsPDPKH;
	private static String[][] roomNumbers;
	private static String[] checkOutDates;
	static JDateChooser dateNhanP;
	static JDateChooser dateTraP;
	private JPanel panelTK;
	private JButton btnTK;
	private JButton btnTKDMK;
	private JButton btnTKDX;
	private JLabel btnTKHTNV;
	private JLabel btnTKTNV;
	private JLabel btnTKca;
	private JLabel btnmaNV;
	private JButton btnTrangChu;
	private JButton btnQLP;
	private JButton btnQLHD;
	private JButton btnQLKH;
	private JButton btnQLNV;
	private JButton btnQLDV;
	private JLabel lblNewLabel_2;
	private JButton btnThongKe;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnHT;
	private NhanVien_DAO nv_dao;
	private ArrayList<NhanVien> ListNV;
	private GUI_QuanLiDatPhong qlp;
	private GUI_QuanLiHoaDon qlhd;
	private GUI_QuanLiKhachHang qlkh;
	private GUI_QuanLiDichVu qldv;
	private GUI_ThongKeNhanVien tknv;
	private GUI_DatPhong dp;
	private GUI_NhanPhong np;
	private GUI_TraPhong tp;
	private GUI_DoiPhong dop;
	private GUI_GiaHanPhong ghp;
	/**
	 * Launch the application.
	 */
	static NhanVien nhanvien;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien nv = new NhanVien("NV0000001");
					GUI_NhanPhong frame = new GUI_NhanPhong(nv);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_NhanPhong(NhanVien nv) {
		nhanvien = nv;
		
		setIconImage(new ImageIcon(GUI_DangNhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setResizable(false);
		setLocationRelativeTo(null);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		Frame.setVisible(true);

		
		
		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Phong_DAO Phong_dao  = new Phong_DAO();
		ArrayList<Phong> dsP = Phong_dao.getalltbPhong();
		
		khachHang_DAO = new KhachHang_DAO();
		dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getTrangThai().contains("Đã đặt")&&dsPDP.get(i).getThoiGianNhan().compareTo(LocalDate.now())<0) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
			}
		}
		
		
		panelTK = new JPanel();
		
		nhanvien = nv;
		panel = new JPanel(null);
		getContentPane().add(panelTK);
		
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
		}
		
		
		panelKH = new JPanel();
		panelKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelKH.setBounds(250, 150, 1654, 138);
		Frame.add(panelKH);
		panelKH.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Căn cước công dân:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(100, 37, 185, 26);
		panelKH.add(lblNewLabel_1);
		
		txtmaKH = new JTextField();
		txtmaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmaKH.setBounds(313, 37, 350, 26);
		panelKH.add(txtmaKH);
		txtmaKH.setColumns(10);
		
		btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim.setBounds(696, 37, 96, 26);
		panelKH.add(btnTim);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(313, 86, 350, 26);
		txtSDT.setEditable(false);
		panelKH.add(txtSDT);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(100, 86, 185, 26);
		panelKH.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Khách hàng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(990, 37, 185, 26);
		panelKH.add(lblNewLabel_1_2);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTen.setColumns(10);
		txtTen.setBounds(1205, 41, 350, 26);
		txtTen.setEditable(false);
		panelKH.add(txtTen);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(990, 86, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		txtTuoi = new JTextField();
		txtTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(1067, 86, 120, 26);
		txtTuoi.setEditable(false);
		panelKH.add(txtTuoi);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1243, 86, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		txtGT = new JTextField();
		txtGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGT.setColumns(10);
		txtGT.setBounds(1370, 86, 185, 26);
		txtGT.setEditable(false);
		panelKH.add(txtGT);
		
		panelP = new JPanel();
		panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelP.setBounds(250, 288, 1654, 244);
		Frame.add(panelP);
		panelP.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Mã Phòng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(100, 27, 185, 26);
		panelP.add(lblNewLabel_7);
		
		txtmaP = new JTextField();
		txtmaP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmaP.setColumns(10);
		txtmaP.setBounds(313, 27, 350, 26);
		panelP.add(txtmaP);
		
		lblNewLabel_8 = new JLabel("Số người");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(100, 75, 185, 26);
		panelP.add(lblNewLabel_8);
		
		txtNguoi = new JTextField();
		txtNguoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNguoi.setColumns(10);
		txtNguoi.setBounds(313, 75, 350, 26);
		panelP.add(txtNguoi);
		
		lblNewLabel_10 = new JLabel("Ngày trả Phòng:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(992, 75, 185, 26);
		panelP.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(992, 27, 185, 26);
		panelP.add(lblNewLabel_11);
		
		dateNhanP = new JDateChooser();
		dateNhanP.setDateFormatString("dd/MM/yyyy");
		dateNhanP.setBounds(1205, 27, 350, 26);
		dateNhanP.setFont(new Font("Tahoma", Font.PLAIN, 20));

		dateNhanP.setDate(new java.util.Date());
		panelP.add(dateNhanP);
		
		dateTraP = new JDateChooser();
		dateTraP.setDateFormatString("dd/MM/yyyy");
		dateTraP.setBounds(1205, 75, 350, 26);
		dateTraP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//set date ngày mai
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		dateTraP.setDate(cal.getTime());
		panelP.add(dateTraP);
		
		bntNhanP = new JButton("Nhận Phòng");
		bntNhanP.setBackground(new Color(234, 232, 214));
		bntNhanP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bntNhanP.setBounds(1205, 173, 153, 26);
		panelP.add(bntNhanP);
		
		btnHy = new JButton("Hủy");
		btnHy.setBackground(new Color(234, 232, 214));
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBounds(1380, 173, 153, 26);
		panelP.add(btnHy);
		
		JLabel lblNewLabel_12 = new JLabel("Phòng đơn:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(100, 118, 101, 24);
		panelP.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("Phòng đơn:");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12_1.setBounds(254, 119, 101, 24);
		panelP.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_12_2 = new JLabel("Phòng đơn:");
		lblNewLabel_12_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12_2.setBounds(413, 119, 101, 24);
		panelP.add(lblNewLabel_12_2);
		
		JLabel lblsoPhongDon = new JLabel("10");
		lblsoPhongDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongDon.setBounds(211, 118, 33, 24);
		panelP.add(lblsoPhongDon);
		
		JLabel lblsoPhongDoi = new JLabel("10");
		lblsoPhongDoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongDoi.setBounds(365, 119, 59, 24);
		panelP.add(lblsoPhongDoi);
		
		JLabel lblsoPhongVip = new JLabel("10");
		lblsoPhongVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongVip.setBounds(524, 119, 59, 24);
		panelP.add(lblsoPhongVip);
		
		

		outerPanel = new JPanel(null);
		outerPanel.setBounds(287, 580, 1580, 423);
		Frame.add(outerPanel);
		
		

        // Tạo một panel bên trong với layout null và kích thước cố định
		panel = new JPanel(null);
		panel.setVisible(true);
        panel.setPreferredSize(new Dimension(1500, 380));
		
		JScrollPane scrollPane = new JScrollPane(panel);                      
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
		scrollPane.setBounds(0, 0, 1580, 423);

	        // Thêm JScrollPane vào panel bên ngoài
	    outerPanel.add(scrollPane);
	    scrollPane.setVisible(true);
	    outerPanel.setVisible(true);
	    
	    //lay maphong, ngay tra phong, ngay nhan phong tu button len cac textfield
	    
		
	    
        //tao su kien cho bien button
	    
	    
	    
	    
	    
	    
	    panelTK.setBounds(1647, 53, 247, 218);
		panelTK.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		
		panelTK.setLayout(null);
		panelTK.setVisible(false);
		
		
		
		
		Panel panel_top = new Panel();
		panel_top.setLayout(null);
		panel_top.setBackground(Color.LIGHT_GRAY);
		panel_top.setBounds(0, 0, 1904, 150);
		getContentPane().add(panel_top);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(new ImageIcon(GUI_DangNhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH)));
		logo.setBounds(0, 0, 250, 150);
		panel_top.add(logo);
		
		
		
		
		btnTK = new JButton("<html><div style='text-align: center;'>Trần ngu</div></html>");
		btnTK.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTK.setForeground(new Color(244, 244, 244));
		btnTK.setBackground(new Color(41, 139, 116));
		btnTK.setBounds(1647, 11, 247, 40);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(GUI_DangNhap.class.getResource("/img/account-icon.png")).getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH)));
		btnTK.add(lblNewLabel);
		panel_top.add(btnTK);
		
		
		
		
		
      
		
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
		
		btnTKTNV = new JLabel("Tuổi");
		btnTKTNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTKTNV.setHorizontalAlignment(SwingConstants.CENTER);
		btnTKTNV.setBounds(0, 50, 247, 20);
		panelTK.add(btnTKTNV);
		
		btnmaNV = new JLabel("Mã nhân viên");
		btnmaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnmaNV.setHorizontalAlignment(SwingConstants.CENTER);
		btnmaNV.setBounds(0, 0, 247, 29);
		panelTK.add(btnmaNV);
		

		
		
		Panel panel_menu = new Panel();
		panel_menu.setLayout(null);
		panel_menu.setBackground(Color.LIGHT_GRAY);
		panel_menu.setBounds(0, 150, 250, 891);
		getContentPane().add(panel_menu);
		
		
		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTrangChu.setForeground(new Color(0, 0, 0));
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setBounds(0, 0, 250, 70);
		panel_menu.add(btnTrangChu);
		
		
		btnQLP = new JButton("Quản lí phòng");
		btnQLP.setForeground(new Color(244, 244, 244));
		btnQLP.setBackground(new Color(41, 139, 106));
		btnQLP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLP.setBounds(0, 70, 250, 70);
		panel_menu.add(btnQLP);
		
		
		btnQLHD = new JButton("Quản lí hóa đơn");
		btnQLHD.setBackground(new Color(255, 255, 255));
		btnQLHD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLHD.setBounds(0, 140, 250, 70);
		panel_menu.add(btnQLHD);
		
		
		btnQLKH = new JButton("Quản lí Khách hàng");
		btnQLKH.setBackground(new Color(255, 255, 255));
		btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnQLKH.setBounds(0, 210, 250, 70);
		panel_menu.add(btnQLKH);
		
		
		btnQLNV = new JButton("Quản lí nhân viên");
		btnQLNV.setBackground(new Color(255, 255, 255));
		btnQLNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLNV.setBounds(0, 350, 250, 70);
		panel_menu.add(btnQLNV);
		
		
		
		
		
		btnQLDV = new JButton("Quản lí dịch vụ");
		btnQLDV.setBackground(new Color(255, 255, 255));
		btnQLDV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLDV.setBounds(0, 280, 250, 70);
		panel_menu.add(btnQLDV);
		
		btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(new Color(255, 255, 255));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnThongKe.setBounds(0, 420, 250, 70);
		panel_menu.add(btnThongKe);
		
		lblNewLabel_2 = new JLabel("__________________________________________");
		lblNewLabel_2.setForeground(new Color(41, 111, 106));
		lblNewLabel_2.setBounds(0, 706, 260, 19);
		panel_menu.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Thông tin khách sạn");
		lblNewLabel_3.setForeground(new Color(41, 111, 106));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 731, 250, 30);
		panel_menu.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Hotline: 0387272513");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(41, 111, 106));
		
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(0, 772, 250, 30);
		panel_menu.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Địa chỉ: 416/39 Dương Quảng Hàm");
		lblNewLabel_5.setForeground(new Color(41, 111, 106));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 812, 250, 30);
		panel_menu.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Phường 5, Gò Vấp, TP.HCM");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(41, 111, 106));
		
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(0, 832, 250, 30);
		panel_menu.add(lblNewLabel_6);
		
		btnHT = new JButton("Hỗ trợ");
		btnHT.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnHT.setBackground(Color.WHITE);
		btnHT.setBounds(0, 490, 250, 70);
		panel_menu.add(btnHT);
		

		btnTK.setText("<html><div style='text-align: center;'>" + nhanvien.getHoTenNV() + "</div></html>");
		
		JButton btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setBackground(new Color(41, 139, 106));
		btnDatPhong.setForeground(new Color(244, 244, 244));
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDatPhong.setBounds(250, 25, 200, 99);
		panel_top.add(btnDatPhong);
		
		JButton btnNhanP = new JButton("Nhận phòng");
		btnNhanP.setForeground(new Color(164, 194, 163));
		btnNhanP.setForeground(new Color(0,0,0));
		btnNhanP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNhanP.setBackground(new Color(41, 139, 106));
		btnNhanP.setBounds(460, 25, 200, 99);
		panel_top.add(btnNhanP);
		
		JButton btnTraP = new JButton("Trả Phòng");
		btnTraP.setForeground(new Color(244, 244, 244));
		btnTraP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTraP.setBackground(new Color(41, 139, 106));
		btnTraP.setBounds(670, 25, 200, 99);
		panel_top.add(btnTraP);
		
		JButton btnDoiP = new JButton("Đổi Phòng");
		btnDoiP.setForeground(new Color(244, 244, 244));
		btnDoiP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDoiP.setBackground(new Color(41, 139, 106));
		btnDoiP.setBounds(880, 25, 200, 99);
		panel_top.add(btnDoiP);
		
		JButton btnGHP = new JButton("Gia hạn phòng");
		btnGHP.setForeground(new Color(244, 244, 244));
		btnGHP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGHP.setBackground(new Color(41, 139, 106));
		btnGHP.setBounds(1090, 25, 200, 99);
		panel_top.add(btnGHP);
		
		JButton btnXemPhiut = new JButton("Xem phiếu đặt");
		btnXemPhiut.setForeground(new Color(244, 244, 244));
		btnXemPhiut.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnXemPhiut.setBackground(new Color(41, 139, 106));
		btnXemPhiut.setBounds(1300, 25, 200, 99);
		panel_top.add(btnXemPhiut);
		
		
		btnmaNV.setText("<html><div style='text-align: center;'>" +"Mã Nhân viên: "+ nhanvien.getMaNV() + "</div></html>");
		btnTKHTNV.setText("<html><div style='text-align: center;'>" + "Họ tên: "+nhanvien.getHoTenNV() + "</div></html>");
		int tuoi = (int) ChronoUnit.YEARS.between(nhanvien.getNgaySinh(), java.time.LocalDate.now());
		btnTKTNV.setText("<html><div style='text-align: center;'>" + "Tuổi: "+tuoi + "</div></html>");
		
		btnNhanP.setBackground(new Color(164, 194, 163));
		btnNhanP.setForeground(new Color(0,0,0));
		
		
		if(!nhanvien.getMaNV().contains("QL")) {
			btnQLNV.setVisible(false);
			btnThongKe.setVisible(false);
			
			btnHT.setBounds(0, 350, 250, 70);
		}
		
		
		
		
		
		ActionListener actionListener = new ActionListener() {
		    private GUI_QuanLiNhanVien qlnv;

			public void actionPerformed(ActionEvent e) {
		    	
		    	
		    	
		        JButton clickedButton = (JButton) e.getSource();
				
				if(clickedButton == btnTrangChu) {
					
					GUI_TrangChu tc = new GUI_TrangChu(nhanvien);
					tc.setVisible(true);
					dispose();
					
					
				}if(clickedButton == btnQLP) {
					qlp = new GUI_QuanLiDatPhong(nhanvien);
					qlp.setVisible(true);
					dispose();
				}if(clickedButton == btnQLHD) {
					qlhd = new GUI_QuanLiHoaDon(nhanvien);
					qlhd.setVisible(true);
					dispose();
				}if(clickedButton == btnQLKH) {
					qlkh = new GUI_QuanLiKhachHang(nhanvien);
					qlkh.setVisible(true);
					dispose();
				}if(clickedButton == btnQLNV) {
					qlnv = new GUI_QuanLiNhanVien(nhanvien);
					qlnv.setVisible(true);
					dispose();
				}
				if(clickedButton == btnQLDV) {
					qldv = new GUI_QuanLiDichVu(nhanvien);
					qldv.setVisible(true);
					dispose();
				}if(clickedButton == btnThongKe) {
					tknv = new GUI_ThongKeNhanVien(nhanvien);
					tknv.setVisible(true);
					dispose();
				}if(clickedButton == btnTK) {
					panelTK.setVisible(!panelTK.isVisible());
				}if(clickedButton == btnTKDX) {
					GUI_DangNhap dn = new GUI_DangNhap();
					dn.setVisible(true);
					dispose();
				}if(clickedButton == btnHT) {
					
				}if(clickedButton == btnTKDMK) {
					GUI_DoiMatKhau dmk = new GUI_DoiMatKhau();
					dmk.txttendangnhap.setText(nhanvien.getMaNV());
					dmk.txttendangnhap.setEditable(false);
					dmk.setVisible(true);
				}if(clickedButton == btnDatPhong) {
					dp = new GUI_DatPhong(nhanvien);
					dp.setVisible(true);
					dispose();
				}if(clickedButton == btnNhanP) {
					np = new GUI_NhanPhong(nhanvien);
					np.setVisible(true);
					
					dispose();
				}if(clickedButton == btnTraP) {
					tp = new GUI_TraPhong(nhanvien);
					tp.setVisible(true);
					dispose();
				}if(clickedButton == btnDoiP) {
					dop = new GUI_DoiPhong(nhanvien);
					dop.setVisible(true);
					dispose();
				}if(clickedButton == btnGHP) {
					ghp = new GUI_GiaHanPhong(nhanvien);
					ghp.setVisible(true);
					dispose();
				}if(clickedButton == btnXemPhiut) {
					GUI_PhieuDatPhong xpd = new GUI_PhieuDatPhong(nhanvien);
                    xpd.setVisible(true);
                    dispose();
                
				}
                // Xử lý sự kiện cho mỗi nút ở đây
                if (clickedButton == bntNhanP) {
                    // Xử lý khi nhấn vào nút btnHT
                	//lay ma phieu dat phong
                	String[] maPhongs = txtmaP.getText().split(" , ");
                	for (int i = 0; i < maPhongs.length; i++) {
                		System.out.println(maPhongs[i]);
						for (int j = 0; j < dsPDPKH.size(); j++) {
							if (dsPDPKH.get(j).getPhong().getMaPhong().equals(maPhongs[i])) {
								String maPhieu = dsPDPKH.get(j).getMaPhieu();
								phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã nhận");
								//cap nhat lai trang thai phong
						        Phong phong = new Phong(maPhongs[i]);
						        Phong_dao.updateTrangThaiPhong(maPhieu, "Đã thuê");
						        //thông báo
						        JOptionPane.showMessageDialog(null,"Nhận phòng thành công");
						        //xoa panel
						        panel.removeAll();
						        panel.repaint();
						        panel.revalidate();
								txtmaKH.setText("");
								txtTen.setText("");
								txtTuoi.setText("");
								txtSDT.setText("");
								txtGT.setText("");
								txtmaP.setText("");
								txtNguoi.setText("");

								dateNhanP.setDate(new java.util.Date());
								dateTraP.setDate(cal.getTime());
							}
						}
					}
                    
                }if (clickedButton == btnTim) {
                    // Xử lý khi nhấn vào nút btnHT
                	KhachHang khs = new KhachHang(txtmaKH.getText());
              	   	if(dsKH.contains(khs)) {
              		   KhachHang kh = dsKH.get(dsKH.indexOf(khs));
              		   JOptionPane.showMessageDialog(null,"Tìm thấy khách hàng");
              		   
              		   String maKH = txtmaKH.getText();
              		   // lay nam hien tai
              		   Calendar cal = Calendar.getInstance();
              		   txtTen.setText(kh.getHoTen());
              		   //tuoi la nam hien tai - ngay sinh
              		   txtTuoi.setText(String.valueOf(cal.get(Calendar.YEAR) - kh.getNgaySinh().getYear()));
              		   txtSDT.setText(kh.getSoDT());
              		   if(kh.getGioiTinh()==true) {
              			   txtGT.setText("Nam");
              		   } else {
  							txtGT.setText("Nữ");
              		   }
              		   // lay danh sach phieu dat phong cua khach hang
              		   dsPDPKH = new ArrayList<PhieuDatPhong>();
              		   for (int i = 0; i < dsPDP.size(); i++) {
              			   	
							if (dsPDP.get(i).getKhachHang().getmaKH().equals(maKH)&&dsPDP.get(i).getTrangThai().contains("Đã đặt")&&dsPDP.get(i).getThoiGianNhan().compareTo(LocalDate.now())==0) {
								dsPDPKH.add(dsPDP.get(i));
								
							}
              		   }
              		   if (dsPDPKH.size()>0) {
              			   button = createButtons(panel);
							
              			   
              		   }else {
              			   JOptionPane.showMessageDialog(null,"Khách hàng chưa đặt phòng");
              		   }
                  	}
              	   else {
              	   		JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng");
              	   	}
                }if (clickedButton == btnHy) {
                    // Xử lý khi nhấn vào nút btnHT
                	txtmaKH.setText("");
                	txtTen.setText("");
                	txtTuoi.setText("");
                	txtSDT.setText("");
                	txtGT.setText("");
                	txtmaP.setText("");
                	txtNguoi.setText("");
                	
                	dateNhanP.setDate(new java.util.Date());
                	dateTraP.setDate(cal.getTime());
                	panel.removeAll();
                	panel.repaint();
                	panel.revalidate();
                }
                }};
                    btnHy.addActionListener(actionListener);
                    bntNhanP.addActionListener(actionListener);
                    btnTim.addActionListener(actionListener);
                    btnTrangChu.addActionListener(actionListener);
                    btnQLP.addActionListener(actionListener);
                    btnQLHD.addActionListener(actionListener);
                    btnQLKH.addActionListener(actionListener);
                    btnQLNV.addActionListener(actionListener);
                    btnQLDV.addActionListener(actionListener);
                    btnThongKe.addActionListener(actionListener);
                    btnTK.addActionListener(actionListener);
                    btnTKDX.addActionListener(actionListener);
                    btnHT.addActionListener(actionListener);
                    btnTKDMK.addActionListener(actionListener);
                    btnDatPhong.addActionListener(actionListener);
                    btnNhanP.addActionListener(actionListener);
                    btnTraP.addActionListener(actionListener);
                    btnDoiP.addActionListener(actionListener);
                    btnGHP.addActionListener(actionListener);
                    btnXemPhiut.addActionListener(actionListener);
                    btnTKDX.addActionListener(actionListener);
                    btnTKDMK.addActionListener(actionListener);
                    
					
					
                    
					
                    
                    
                 
                    
	}
	public static JButton createButtons1(int i,JPanel panel, String[] roomNumbers, String checkInDates, String checkOutDates) {
        JButton buttons = new JButton();
        
        
            buttons = new JButton();
            StringBuilder htmlText = new StringBuilder("<html><center>");
            htmlText.append("<span style='font-family:Tahoma; font-size:25pt;'>");
            htmlText.append(roomNumbers[0]);
			for (int j = 1; j < roomNumbers.length; j++) {
				htmlText.append(" , ");
				htmlText.append(roomNumbers[j]);
			}
			//set kieu date cho checkInDates, checkOutDates
			String[] temp = checkInDates.split("-");
			checkInDates = temp[2]+"/"+temp[1]+"/"+temp[0];
			temp = checkOutDates.split("-");
			checkOutDates = temp[2]+"/"+temp[1]+"/"+temp[0];
			
            htmlText.append("</span><br/>");
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("Ngày nhận phòng: ").append(checkInDates).append("</span><br/>");
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("Ngày trả phòng: ").append(checkOutDates).append("</span>");
            htmlText.append("</center></html>");
            buttons.setText(htmlText.toString());
            buttons.setBounds(70 +((i)%3)*490, 50+((i)/3)*240 , 420, 200);
            panel.setPreferredSize(new Dimension(1500, 100+((i)/3)*20+150));
            buttons.setText(buttons.getText().replaceAll("na", ""));
            buttons.setBackground(new Color(5, 207, 251));
            buttons.setVisible(true);
            
        
		return buttons;
    }
	//create buttons
	public static JButton[] createButtons(JPanel panel) {
	    // Assuming dsPDPKH is a list of some custom object

	    // Initialize arrays
	    int size = dsPDPKH.size();
	    roomNumbers = new String[size][0];
	    checkOutDates = new String[size];
	    // Populate arrays
	    for (int i = 0; i < size; i++) {
	        checkOutDates[i] = dsPDPKH.get(i).getThoiGianTra().toString();
	        System.out.println(checkOutDates[i]);
	    }
	    String[] checkOutDates1 = countDuplicates(checkOutDates, checkOutDates[0]);
	    for (int i = 0; i < size; i++) {
        	for (int j = 0; j < checkOutDates1.length; j++) {
				if (dsPDPKH.get(i).getThoiGianTra().toString().equals(checkOutDates1[j])) {
					//them so phong vao mang
                    roomNumbers[j] = Arrays.copyOf(roomNumbers[j], roomNumbers[j].length + 1);
                    roomNumbers[j][roomNumbers[j].length - 1] = dsPDPKH.get(i).getPhong().getMaPhong();
					
				}
        	}
//        	roomNumbers[i] = temp;
	    }
	    
	    
	    // Create buttons
	    JButton[] buttons = new JButton[checkOutDates1.length];
	    panel.removeAll();
		panel.repaint();
		panel.revalidate();
	    for (int i = 0; i < checkOutDates1.length; i++) {
	    	System.out.println(roomNumbers[i]);
	        buttons[i] = createButtons1(i, panel, roomNumbers[i], dsPDPKH.get(i).getThoiGianNhan().toString(), checkOutDates1[i]);
	        buttons[i].setVisible(true);
	        panel.add(buttons[i]);
	    }
	    for (int i = 0; i < buttons.length; i++) {
			   buttons[i].addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       JButton clickedButton = (JButton) e.getSource();
                       for (int j = 0; j < buttons.length; j++) {
                           if (clickedButton == buttons[j]) {
                               StringBuilder htmlText = new StringBuilder("");
								// Xử lý khi nhấn vào nút btnHT
                        	   //thay doi txtmaP, txtNguoi, txtDV,txtNhanP, txtTraP
                        	   	htmlText.append(roomNumbers[j][0].toString());
                   				for (int k = 1;  k< roomNumbers[j].length; k++) {
                   					htmlText.append(" , ");
                   					htmlText.append(roomNumbers[j][k].toString());
                   				}
                   				
                   				txtmaP.setText(htmlText.toString());
                   				
                        	   
                        	                          	   
                        	   //set kieu date cho txtNhanP, txtTraP 
                   			   for (int k = 0; k < dsPDPKH.size(); k++) {
                   				   if (dsPDPKH.get(k).getPhong().getMaPhong().equals(roomNumbers[j][0])) {
                   					   dateNhanP.setDate(java.sql.Date.valueOf(dsPDPKH.get(k).getThoiGianNhan()));
                   					   dateTraP.setDate(java.sql.Date.valueOf(dsPDPKH.get(k).getThoiGianTra()));
                   					   txtNguoi.setText(String.valueOf(dsPDPKH.get(k).getSoNguoi()));
                   					  
                   					   break;
                   				   }
                   			   }
                        	   
                        	   
                        	   
                               
                           }
                       }
                   }
            });
	    }
			           
	    return buttons;
	}

	
	//ham dem co bao nhieu phan tu khong trung nhau
	public static String[] countDuplicates(String[] arr, String value) {
		String[] temp = new String[1];
		temp[0] = value;
		for (String s : arr) {
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].equals(s)) {
					break;
				}
				else if (i == temp.length - 1) {
					temp = Arrays.copyOf(temp, temp.length + 1);
					temp[temp.length - 1] = s;
				}
			}
		}
		return temp;
	}

	
	
	

	

	
}
