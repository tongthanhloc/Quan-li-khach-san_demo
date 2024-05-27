package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.DichVuTienIch;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class GUI_DatPhong extends JFrame implements ItemListener{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblNewLabel_1_4;
    private JTextField txtGT;
    private JPanel panelP;
    private JLabel lblNewLabel_7;
    private JTextField txtMaP;
    private JLabel lblNewLabel_8;
    private JTextField txtSoN;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JButton btndatPhng;
    private JButton btnHy;
	private Container outerPanel;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[];
    int trangThai[];
	private String[][] mangHaiChieu;
	private JPanel panel;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	private JComboBox<String> cbPhongBan;
	private JCheckBox chckbxPdon;
	private JCheckBox chckbxPdoi;
	private JCheckBox chckbxPVip;
	
	private JPanel panelKH;
	private KhachHang_DAO khachHang_DAO;
	private PhieuDatPhong_DAO phieuDatPhong_DAO;
	private JDateChooser dateNhanP;
	private JDateChooser dateTraP;
	private String maNV;
	private String tenNV;
	private ArrayList<PhieuDatPhong> dsPDP;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<Phong> dsP;
	
	private NhanVien_DAO nhanVien_DAO;
	private Object dsNV;
	
	
	
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
	private java.util.Date ngaybd;
	private java.util.Date ngaykt;
	static String[] maphongs1;
	/**
	 * Launch the application.
	 */
	static NhanVien nhanvien;
	static int dem;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien nv = new NhanVien("NV0000001");
					GUI_DatPhong frame = new GUI_DatPhong(nv);
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
	public GUI_DatPhong(NhanVien nv) {
		
		setIconImage(new ImageIcon(GUI_DangNhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setLocationRelativeTo(null);
		setResizable(false);
		
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);

		
		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		Phong_dao  = new Phong_DAO();
		dsP = Phong_dao.getalltbPhong();
		
		khachHang_DAO = new KhachHang_DAO();
		dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		
		nhanVien_DAO = new NhanVien_DAO();
		dsNV = nhanVien_DAO.getalltbNhanVien();
		
		ListNV = nhanVien_DAO.getalltbNhanVien();
		for (NhanVien nv1 : ListNV) {
			if (nv1.getMaNV().equals(nv.getMaNV())) {
				nv = nv1;
			}
		}
		
		panelTK = new JPanel();
		nv_dao = new  NhanVien_DAO();
		ListNV = nhanVien_DAO.getalltbNhanVien();
		nhanvien = nv;
		panel = new JPanel(null);
		getContentPane().add(panelTK);
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
		}
		
		
		
		
		
		
		maNV = nv.getMaNV();
		
		
		trangThai = new int[dsP.size()];
		
		soPhong = new String[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			soPhong[i] = dsP.get(i).getMaPhong();
			trangThai[i] = 3;
		}
		
		// lay thoi gian hien tai
		
		
		
		
		
		
		
		

		
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
		
		
		JButton btnTim = new JButton("Tìm");
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
		txtTen.setBounds(1185, 37, 350, 26);
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
		txtGT.setBounds(1370, 86, 166, 26);
		txtGT.setEditable(false);
		panelKH.add(txtGT);
		
		panelP = new JPanel();
		panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelP.setBounds(250, 288, 1654, 182);
		Frame.add(panelP);
		panelP.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Mã Phòng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(100, 27, 185, 26);
		panelP.add(lblNewLabel_7);
		
		txtMaP = new JTextField();
		txtMaP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaP.setColumns(10);
		txtMaP.setBounds(313, 27, 350, 26);
		panelP.add(txtMaP);
		
		lblNewLabel_8 = new JLabel("Số người");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(100, 75, 185, 26);
		panelP.add(lblNewLabel_8);
		
		txtSoN = new JTextField();
		txtSoN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoN.setColumns(10);
		txtSoN.setBounds(313, 75, 350, 26);
		panelP.add(txtSoN);
		
		lblNewLabel_10 = new JLabel("Ngày trả Phòng:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(992, 75, 185, 26);
		panelP.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(992, 27, 185, 26);
		panelP.add(lblNewLabel_11);
		
		btndatPhng = new JButton("Đặt phòng");
		btndatPhng.setBackground(new Color(234, 232, 214));
		btndatPhng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btndatPhng.setBounds(1205, 140, 153, 26);
		
		panelP.add(btndatPhng);
		
		btnHy = new JButton("Hủy");
		btnHy.setBackground(new Color(234, 232, 214));
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBounds(1379, 140, 153, 26);
		panelP.add(btnHy);
		
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
		//set date ngày hôm sau của dateNhanP
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateNhanP.getDate());
		cal.add(Calendar.DATE, 1);
		dateTraP.setDate(cal.getTime());
		panelP.add(dateTraP);
		//in ngày đã chọn của dateTraP
		
		
		chckbxPdon = new JCheckBox("Phòng đơn (A)");
		chckbxPdon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdon.setBounds(287, 480, 178, 43);
		Frame.add(chckbxPdon);
		
		

		
		chckbxPdoi = new JCheckBox("Phòng đôi (B)");
		chckbxPdoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdoi.setBounds(577, 483, 178, 43);
		Frame.add(chckbxPdoi);
		
		

		
		chckbxPVip = new JCheckBox("Phòng VIP (C)");
		chckbxPVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPVip.setBounds(863, 483, 178, 43);
		Frame.add(chckbxPVip);
		
		
		outerPanel = new JPanel(null);
		outerPanel.setBounds(287, 550, 1580, 453);
		Frame.add(outerPanel);
		
		

        // Tạo một panel bên trong với layout null và kích thước cố định
		
        panel.setPreferredSize(new Dimension(1500, 380));
		
		 JScrollPane scrollPane = new JScrollPane(panel);                      
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
		 scrollPane.setBounds(0, 0, 1580, 453);

	        // Thêm JScrollPane vào panel bên ngoài
	     outerPanel.add(scrollPane);

		
	     
	     
	     
	     
	     
	     
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
			btnDatPhong.setBackground(new Color(164, 194, 163));
			btnDatPhong.setForeground(new Color(0,0,0));
			btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnDatPhong.setBounds(250, 25, 200, 99);
			panel_top.add(btnDatPhong);
			
			JButton btnNhanP = new JButton("Nhận phòng");
			btnNhanP.setForeground(new Color(244, 244, 244));
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
						String url = "https://docs.google.com/document/d/1TgBigF9snicPf6nJ6vfsfwC6LhhG7rnjhzX6ui6ovkM/edit?usp=sharing";
		                
		                // Check if Desktop is supported
		                if (Desktop.isDesktopSupported()) {
		                    Desktop desktop = Desktop.getDesktop();
		                    try {
		                        // Open the web page
		                        desktop.browse(new URI(url));
		                    } catch (Exception ex) {
		                    	ex.printStackTrace();
		                    }
		                } else {
		                    System.out.println("Desktop is not supported");
		                }
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
					}
					if (clickedButton == btnXemPhiut) {
						GUI_PhieuDatPhong xpd = new GUI_PhieuDatPhong(nhanvien);
						xpd.setVisible(true);
						dispose();
					}
					if (clickedButton == btnTim) {
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
		
	}
   else {
   		JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng");
   	}
	}else if (clickedButton == btnHy) {
        // Xử lý khi nhấn vào nút btnHT
    	txtmaKH.setText("");
    	txtTen.setText("");
    	txtTuoi.setText("");
    	txtGT.setText("");
     	txtSDT.setText("");
     	txtMaP.setText("");
     	txtSoN.setText("");
     	
     	dateNhanP.setDate(new java.util.Date());
     	dateTraP.setDate(cal.getTime());
    }else if (clickedButton == btndatPhng) {
    	String[] maPhongs = txtMaP.getText().split(" , ");
    	if(ktraChinhQuy(maPhongs)==1) {
		for (int i = 0; i < maPhongs.length; i++) {
			ThemPhong(maPhongs[i]);
		}
    	JOptionPane.showMessageDialog(null,"Đặt phòng thành công");
    
    	}else if(ktraChinhQuy(maPhongs)==-2) {
    		JOptionPane.showMessageDialog(null,"Khách Hàng đã đặt quá 5 phòng");
    		for (int i = 0; i < maPhongs.length; i++) {
    			ThemPhong(maPhongs[i]);
    		}
    	}else if(ktraChinhQuy(maPhongs)==-10) {
    		JOptionPane.showMessageDialog(null,"Phòng đặt không quá 1 tháng");
    	}else if(ktraChinhQuy(maPhongs)==-3) {
    		JOptionPane.showMessageDialog(null,"Số lượng người không hợp lệ");
    	}
    	
    	
    	
    	
    	
    }

					
			    }
			};
			
		
		
                    btnTim.addActionListener(actionListener);
                    btnHy.addActionListener(actionListener);
                    btndatPhng.addActionListener(actionListener);
                    
                    btnTrangChu.addActionListener(actionListener);
        			btnQLP.addActionListener(actionListener);
        			btnQLHD.addActionListener(actionListener);
        			btnQLKH.addActionListener(actionListener);
        			btnQLDV.addActionListener(actionListener);
        			btnThongKe.addActionListener(actionListener);
        			btnQLNV.addActionListener(actionListener);
        			btnXemPhiut.addActionListener(actionListener);
        			btnTK.addActionListener(actionListener);
        			btnTKDX.addActionListener(actionListener);
        			btnHT.addActionListener(actionListener);
        			btnTKDMK.addActionListener(actionListener);
        			btnDatPhong.addActionListener(actionListener);
        			btnNhanP.addActionListener(actionListener);
        			btnTraP.addActionListener(actionListener);
        			btnDoiP.addActionListener(actionListener);
        			btnGHP.addActionListener(actionListener);
        			
        			
        			
        			chckbxPdon.addItemListener(this);
                    chckbxPdoi.addItemListener(this);
                    chckbxPVip.addItemListener(this);
					
                    
                 
                    
	}
	
	public void itemStateChanged(ItemEvent e) {
		maphongs = new String[0];
		tens = new String[0];
		trangTs = new int[0];
		for (int i = 0; i < maphongs.length; i++) {
			maphongs[i] = null;
			tens[i] = null;
			trangTs[i] = 0;
		}
		
		
		if (chckbxPdon.isSelected()) {
			ngaybd = dateNhanP.getDate();
			ngaykt = dateTraP.getDate();
		    // ép kiểu thành string ngaybd, ngaykt
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ngaybd1 = sdf.format(ngaybd);
			String ngaykt1 = sdf.format(ngaykt);
			ArrayList<String> dsPhong = new ArrayList<String>();
			dsPhong = PhieuDatPhong_DAO.getPhieuDatPhongTheoTrangThai(ngaybd1, ngaykt1);
			
		 // chạy hết dsPhong da lay ra
			for (int i = 0; i < dsPhong.size(); i++) {
				String maPhong = dsPhong.get(i);
				if (maPhong.contains("A") && trangThai[Arrays.asList(soPhong).indexOf(maPhong)] == 3) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = maPhong;
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[Arrays.asList(soPhong).indexOf(maPhong)];
				}
			}
			
		}
		
		
		if (chckbxPdoi.isSelected()) {
			ngaybd = dateNhanP.getDate();
			ngaykt = dateTraP.getDate();
		    // ép kiểu thành string ngaybd, ngaykt
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ngaybd1 = sdf.format(ngaybd);
			String ngaykt1 = sdf.format(ngaykt);
			ArrayList<String> dsPhong = new ArrayList<String>();
			dsPhong = PhieuDatPhong_DAO.getPhieuDatPhongTheoTrangThai(ngaybd1, ngaykt1);
			
		 // chạy hết dsPhong da lay ra
			for (int i = 0; i < dsPhong.size(); i++) {
				String maPhong = dsPhong.get(i);
				if (maPhong.contains("B") && trangThai[Arrays.asList(soPhong).indexOf(maPhong)] == 3) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = maPhong;
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[Arrays.asList(soPhong).indexOf(maPhong)];
				}
			}
			
		}
		
		if (chckbxPVip.isSelected()) {
			ngaybd = dateNhanP.getDate();
			ngaykt = dateTraP.getDate();
		    // ép kiểu thành string ngaybd, ngaykt
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ngaybd1 = sdf.format(ngaybd);
			String ngaykt1 = sdf.format(ngaykt);
			ArrayList<String> dsPhong = new ArrayList<String>();
			dsPhong = PhieuDatPhong_DAO.getPhieuDatPhongTheoTrangThai(ngaybd1, ngaykt1);
			
			            // chạy hết dsPhong da lay ra
			for (int i = 0; i < dsPhong.size(); i++) {
				String maPhong = dsPhong.get(i);
				if (maPhong.contains("C") && trangThai[Arrays.asList(soPhong).indexOf(maPhong)] == 3) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = maPhong;
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[Arrays.asList(soPhong).indexOf(maPhong)];
				}
			}
		}
		if (chckbxPdon.isSelected() == false && chckbxPdoi.isSelected() == false && chckbxPVip.isSelected() == false) {
			chckbxPdon.setSelected(true);
			chckbxPdoi.setSelected(true);
			chckbxPVip.setSelected(true);
		}
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
		String[][] mangHaiChie = new String[3][maphongs.length];
		
		for (int i = 0; i < maphongs.length; i++) {
			mangHaiChie[0][i] = maphongs[i];
			mangHaiChie[1][i] = String.valueOf(trangTs[i]);
		}
		mangHaiChie = createTwoDimensionalArray(maphongs, trangTs);
		mangHaiChie = sapXep(mangHaiChie);
		
		maphongs = mangHaiChie[0];
		trangTs = new int[maphongs.length];
		for (int i = 0; i < maphongs.length; i++) {
			trangTs[i] = Integer.parseInt(mangHaiChie[1][i]);
		}
		button = createButtons(panel, maphongs, trangTs);
		
		for (int i = 0; i < button.length; i++) {
			//cap nhat lai mau cua phong
			//lay ma phong tu button
			String maPhong = button[i].getText().substring(64,69);
			System.out.println(maPhong);
			String ten = button[i].getText().substring(21);
			//lay ma phong tu textfield co nhieu ma phong
			maphongs1 = txtMaP.getText().split(" , ");
			
			//duyet qua danh sach phong da chon
			for (int j = 0; j < maphongs1.length; j++) {
//				System.out.println(maphongs1[j]);
				if (maPhong.equals(maphongs1[j])) {
					button[i].setBackground(new Color(164, 194, 163));
				}
			}
			button[i].addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					JButton clickedButton = (JButton) e.getSource();
					String txtmaPhong = txtMaP.getText();
					
					for (int j = 0; j < button.length; j++) {
						if (clickedButton == button[j]) {
							//kiem tra xem phong da duoc chon hay chua
							if(txtmaPhong.equals("")) {
                                txtMaP.setText(maphongs[j]);
                                button[j].setBackground(new Color(164, 194, 163));
                                dem++;
                            }else if(txtmaPhong.contains(maphongs[j]+" , ")) {
                                //xóa phòng đã chọn
                            	txtMaP.setText(txtmaPhong.replace(maphongs[j]+" , ", ""));
                            	button[j].setBackground(new Color(5, 207, 251));
                            	dem--;
                            }else if(txtmaPhong.contains(" , "+maphongs[j])) {
                                //xóa phòng đã chọn
                            	dem--;
                            	txtMaP.setText(txtmaPhong.replace(" , "+maphongs[j], ""));
                            	button[j].setBackground(new Color(5, 207, 251));
                            }else if(txtmaPhong.contains(maphongs[j])) {
                                //xóa phòng đã chọn
                            	dem--;
                            	txtMaP.setText(txtmaPhong.replace(maphongs[j], ""));
                            	button[j].setBackground(new Color(5, 207, 251));
                            }else if(txtmaPhong.trim().split(" , ").length < 5){
                            	dem++;
                            	txtMaP.setText(txtmaPhong + " , "+ maphongs[j] );
                            	button[j].setBackground(new Color(164, 194, 163));
                            }else {
                                JOptionPane.showMessageDialog(null, "Chỉ chọn tối đa 5 phòng");
                            }

					}
				}
				}});
		}
	}
	
	public static String[][] createTwoDimensionalArray(String[] maphong, int[] trangT) {
        Set<String> uniqueMaphong = new HashSet<>();
        List<String> uniqueMaphongList = new ArrayList<>();
        List<String> tenList = new ArrayList<>();
        List<Integer> trangTList = new ArrayList<>();

        for (int i = 0; i < maphong.length; i++) {
            if (!uniqueMaphong.contains(maphong[i])) {
                uniqueMaphong.add(maphong[i]);
                uniqueMaphongList.add(maphong[i]);
                trangTList.add(trangT[i]);
            }
        }

        String[][] mangHaiChieu = new String[3][uniqueMaphongList.size()];
        for (int i = 0; i < uniqueMaphongList.size(); i++) {
            mangHaiChieu[0][i] = uniqueMaphongList.get(i);
            mangHaiChieu[1][i] = String.valueOf(trangTList.get(i));
        }
        return mangHaiChieu;
    }
	
	
	public static JButton[] createButtons(JPanel panel, String[] roomNumbers, int[] statuses) {
        JButton[] buttons = new JButton[roomNumbers.length];
        for (int i = 0; i < roomNumbers.length; i++) {
            buttons[i] = new JButton();
            StringBuilder htmlText = new StringBuilder("<html><center>");
            htmlText.append("<span style='font-family:Tahoma; font-size:60pt;'>").append(roomNumbers[i]).append("</span><br/>");
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("na").append("</span>");
            htmlText.append("</center></html>");
            buttons[i].setText(htmlText.toString());
            buttons[i].setBounds(70 +((i)%5)*290, 50+((i)/5)*190 , 250, 150);
            panel.setPreferredSize(new Dimension(1500, 100+((i)/5)*190+150));
            buttons[i].setText(buttons[i].getText().replaceAll("na", ""));
            buttons[i].setBackground(new Color(5, 207, 251));
            panel.add(buttons[i]);
        }
		return buttons;
    }

	
	public static String[][] sapXep(String[][] mangHaiChieu) {
		String temp;
		for (int i = 0; i < mangHaiChieu[0].length; i++) {
			for (int j = i + 1; j < mangHaiChieu[0].length; j++) {
				if (mangHaiChieu[0][i].compareTo(mangHaiChieu[0][j]) > 0) {
					temp = mangHaiChieu[0][i];
					mangHaiChieu[0][i] = mangHaiChieu[0][j];
					mangHaiChieu[0][j] = temp;

					temp = mangHaiChieu[1][i];
					mangHaiChieu[1][i] = mangHaiChieu[1][j];
					mangHaiChieu[1][j] = temp;

					
				}
			}
		}
		return mangHaiChieu;
	}

	public int kiemtraTrong(String maphongktra) {
		
	
		LocalDate thoiGianNhan = dateNhanP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate thoiGianTra = dateTraP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int hieuNgayN = thoiGianNhan.compareTo(LocalDate.now());
		int hieuNgayT = thoiGianTra.compareTo(thoiGianNhan);
		if (txtmaKH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng");
			return-1;
		}
		else if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập và kiểm tra mã khách hàng");
			return-1;
		}
		else if (txtMaP.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng");
			return-1;
		}
		else if (txtSoN.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số người");
			return-1;
		}
		else if (dateNhanP.getDate() == null|| hieuNgayN < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày nhận phòng lại");
			return-1;
		}
		else if (dateTraP.getDate() == null || hieuNgayT < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày trả phòng lại");
			return-1;}
		else if(kiemTraPhong(maphongktra) == -1) {
			JOptionPane.showMessageDialog(null, "Phòng không tồn tại");
			return-1;
		} else if (kiemTraThoiGianDat(maphongktra, thoiGianNhan, thoiGianTra) == -1) {
			return -2;
		} else {
			return 1;
		}
	}
	
	
	public void ThemPhong(String maphongktra) {
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		LocalDate thoiGianNhan = dateNhanP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate thoiGianTra = dateTraP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate thoiGianDat = LocalDate.now();
		int soNgay= (int) ChronoUnit.DAYS.between(thoiGianNhan, thoiGianTra);
		Double DonGia = 0.0;
		if (maphongktra.contains("A")) {
			DonGia = 1500000.0*soNgay;
		}else if (maphongktra.contains("B")) {
			DonGia = 2000000.0*soNgay;
		}else {
			DonGia = 3000000.0*soNgay;
		}
		KhachHang maKH = new KhachHang(txtmaKH.getText());
		Phong maPhong = new Phong(maphongktra);
		NhanVien maNhanVien = new NhanVien(maNV);
		String formatter = thoiGianDat.format(DateTimeFormatter.ofPattern("yyMMdd"));
		int count = 1;
		for (int a = 0; a < dsPDP.size(); a++) {
			if (dsPDP.get(a).getMaPhieu().contains("PD"+formatter)) {
				count++;
			}
		}
		String maPhieu;
		if (count < 10) {
			maPhieu="PD"+formatter + "000" + count;
		} else if (count < 100) {
			maPhieu = "PD" + formatter + "00" + count;
		} else if (count < 1000) {
			maPhieu = "PD" + formatter + "0" + count;
		} else {
			maPhieu = "PD" + formatter + count;
		}
		String trangThai;
		if(LocalDate.now().isBefore(dateNhanP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
			trangThai = "Đã đặt";
		} else {
			trangThai = "Đã nhận";
		}
		String soPhong = txtSoN.getText();
		
		
		PhieuDatPhong pdp = new PhieuDatPhong(maPhieu, thoiGianDat, thoiGianNhan, thoiGianTra, DonGia, maPhong, maKH,maNhanVien,trangThai,soPhong,null);
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<>();
		danhSachPhieuDatPhong.add(pdp);
		phieuDatPhong_DAO.insertPhieuDatPhong(danhSachPhieuDatPhong);
	}
			
		
		
		
	

	public int kiemTraPhong(String maPhong) {
		for (int i = 0; i < soPhong.length; i++) {
			if (soPhong[i].equals(maPhong)) {
				return 1;
			}
		}
		return -1;
	}

	public int kiemTraThoiGianDat(String maPhong, LocalDate thoiGianNhan, LocalDate thoiGianTra) {
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getPhong().getMaPhong().equals(maPhong)) {
				if ((dsPDP.get(i).getThoiGianNhan().isBefore(thoiGianNhan) 
						&& dsPDP.get(i).getThoiGianTra().isAfter(thoiGianNhan))
						||(dsPDP.get(i).getThoiGianNhan().isAfter(thoiGianNhan)
						&& dsPDP.get(i).getThoiGianNhan().isBefore(thoiGianTra))) {
                    return -1;
                }
			}
		}
		return 1;
	}

	public int ktraChinhQuy(String[] maPhongs) {
		int count = 0;
		for (int i = 0; i < maPhongs.length; i++) {
    		if(kiemtraTrong(maPhongs[i])==-1) {
    			     
    			return -1;
           	}else if(kiemtraTrong(maPhongs[i])==-2){
           		JOptionPane.showMessageDialog(null, "Phòng "+maPhongs[i]+" đã có người đặt");
           		count++;
           	}
       	}
		if (ktraPhongDat(txtmaKH.getText()) >= 5) {
			
			return -2;
		}
		if (count > 0) {
			return -1;
		}
		int songay = (int) ChronoUnit.DAYS.between(dateNhanP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), dateTraP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		if (songay > 31) {
			return -10;
		}
		int demsonguoi=0;
		for (int i = 0; i < maPhongs.length; i++) {
			
			 if(maPhongs[i].contains("A")) {
				 demsonguoi+=2;
                 
			 }
			if (maPhongs[i].contains("B")) {
					demsonguoi += 5;

			}
			if (maPhongs[i].contains("C")) {
					demsonguoi += 10;
			}
		}
		if (Integer.parseInt(txtSoN.getText())> demsonguoi) {
			
			return -3;
		}
		
		return 1;
	}
	//kiem tra khach hang đa dat bao nhieu phong
	public int ktraPhongDat(String maKH) {
		int count = 0;
		for (int i = 0; i < dsPDP.size(); i++) {
			
			if (dsPDP.get(i).getKhachHang().getmaKH().equals(maKH)&&(dsPDP.get(i).getTrangThai().equals("Đã đặt")||dsPDP.get(i).getTrangThai().equals("Đã nhận"))) {
				count++;
			}
			System.out.println(count);
		}
		int count1 = txtMaP.getText().split(" , ").length;
		
		return count+count1;
	}
}
