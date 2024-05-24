package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.DAO_PhieuDatDichVu;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatDichVu;
import entity.PhieuDatPhong;
import entity.Phong;


import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;



public class GUI_TraPhong extends JFrame implements ItemListener{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
	static JTextField txtCCKH;
    static JTextField txtSDTKH;
    static JTextField txtTenKH;
    static JTextField txtTuoiKH;
    private JLabel lblNewLabel_1_4;
	private Container outerPanel;
	private JButton button[];
	String soPhong[];
    String tenKhachHang[] ;//= {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private JPanel panel;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	private PhieuDatPhong_DAO pdp;
	private GUI_ChiTietHoaDon chitiethoadon;

	private JCheckBox chckbxPdon;
	private JCheckBox chckbxPdoi;
	private JCheckBox chckbxPVip;
	private JPanel panelKH;
	static JTextField txtNgayN;
	private JLabel lblNewLabel_1_1_3;
	static JTextField txtPhongs;
	private JLabel lblNewLabel_1_1_4;
	static JTextField txtSoNguoi;
	private JButton btnXutHan;
	private JButton btnHy;
	static JTextField txtGT;
	static JTextField txtNgayT;
	static ArrayList<PhieuDatPhong> dsPDP;
	private KhachHang_DAO kh;
	private JButton btnTim;
	static ArrayList<Phong> dsP;
	static ArrayList<KhachHang> dsKH;
	private JLabel lblNewLabel_1_1_5;
	private JTextField txtDiem;
	private JTextField txtHang;
	private ArrayList<PhieuDatPhong> dsPDPTr;
	private ArrayList<PhieuDatDichVu> dsPDVTr;
	private NhanVien_DAO nv;
	private KhachHang_DAO Khachhang_dao;
	
	
	private NhanVien_DAO nhanVien_DAO;
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
					NhanVien nv = new NhanVien("QL0000010");
					GUI_TraPhong frame = new GUI_TraPhong(nv);
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
	public GUI_TraPhong(NhanVien nv1) {
		
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
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
		Khachhang_dao = new KhachHang_DAO();
		pdp = new PhieuDatPhong_DAO();
		dsP = Phong_dao.getalltbPhong();
		dsKH = Khachhang_dao.getalltbKhachHang();
		dsPDP = pdp.getAllTbPhieuDatPhong();
		
		panelTK = new JPanel();
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
		nhanvien = nv1;
		panel = new JPanel(null);
		getContentPane().add(panelTK);
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv1.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
		}
		
		
		
		soPhong = new String[0];
		trangThai = new int[0];
		tenKhachHang = new String[0];
		
		
		for (int i = 0; i < dsPDP.size(); i++) {
			
			if (dsPDP.get(i).getTrangThai().contains("Đã nhận")) {
				soPhong = Arrays.copyOf(soPhong, soPhong.length + 1);
				soPhong[soPhong.length - 1] = dsPDP.get(i).getPhong().getMaPhong();
				trangThai = Arrays.copyOf(trangThai, trangThai.length + 1);
				trangThai[trangThai.length - 1] = 2;
				tenKhachHang = Arrays.copyOf(tenKhachHang, tenKhachHang.length + 1);
				for (int j = 0; j < dsKH.size(); j++) {
					if (dsKH.get(j).getmaKH().equals(dsPDP.get(i).getKhachHang().getmaKH())) {
						tenKhachHang[tenKhachHang.length - 1] = dsKH.get(j).getHoTen();
					}
					
					
			
				}
				
			}
		}
		
		
		panelKH = new JPanel();
		panelKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelKH.setBounds(250, 150, 1654, 279);
		Frame.add(panelKH);
		panelKH.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Căn cước công dân:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(100, 37, 185, 26);
		panelKH.add(lblNewLabel_1);
		
		txtCCKH = new JTextField();
		txtCCKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCCKH.setBounds(313, 37, 350, 26);
		panelKH.add(txtCCKH);
		txtCCKH.setColumns(10);
		
		btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim.setBounds(696, 37, 96, 26);
		panelKH.add(btnTim);
		
		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(313, 86, 350, 26);
		txtSDTKH.setEditable(false);
		panelKH.add(txtSDTKH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(100, 86, 185, 26);
		panelKH.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Khách hàng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(990, 37, 185, 26);
		panelKH.add(lblNewLabel_1_2);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(1185, 37, 368, 26);
		txtTenKH.setEditable(false);
		panelKH.add(txtTenKH);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(990, 86, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		txtTuoiKH = new JTextField();
		txtTuoiKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTuoiKH.setColumns(10);
		txtTuoiKH.setBounds(1067, 86, 120, 26);
		txtTuoiKH.setEditable(false);
		panelKH.add(txtTuoiKH);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1243, 86, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(100, 132, 185, 26);
		panelKH.add(lblNewLabel_1_1_1);
		
		txtNgayN = new JTextField();
		txtNgayN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayN.setColumns(10);
		txtNgayN.setBounds(313, 132, 350, 26);
		txtNgayN.setEditable(false);
		panelKH.add(txtNgayN);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ngày trả phòng:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(990, 132, 185, 26);
		panelKH.add(lblNewLabel_1_1_2);
		
		lblNewLabel_1_1_3 = new JLabel("Phòng:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setBounds(100, 179, 185, 26);
		panelKH.add(lblNewLabel_1_1_3);
		
		txtPhongs = new JTextField();
		txtPhongs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhongs.setColumns(10);
		txtPhongs.setBounds(313, 179, 350, 26);
		txtPhongs.setEditable(false);
		panelKH.add(txtPhongs);
		
		lblNewLabel_1_1_4 = new JLabel("Số Người:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_4.setBounds(990, 179, 185, 26);
		panelKH.add(lblNewLabel_1_1_4);
		
		txtSoNguoi = new JTextField();
		txtSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoNguoi.setColumns(10);
		txtSoNguoi.setBounds(1185, 179, 368, 26);
		txtSoNguoi.setEditable(false);
		panelKH.add(txtSoNguoi);
		
		btnXutHan = new JButton("Xuất Hóa đơn");
		btnXutHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXutHan.setBackground(new Color(234, 232, 214));
		btnXutHan.setBounds(1203, 238, 166, 26);
		panelKH.add(btnXutHan);
		
		btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBackground(new Color(234, 232, 214));
		btnHy.setBounds(1387, 238, 166, 26);
		panelKH.add(btnHy);
		
		txtGT = new JTextField();
		txtGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGT.setColumns(10);
		txtGT.setBounds(1349, 86, 204, 26);
		txtGT.setEditable(false);
		panelKH.add(txtGT);
		
		txtNgayT = new JTextField();
		txtNgayT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayT.setColumns(10);
		txtNgayT.setBounds(1185, 132, 368, 26);
		txtNgayT.setEditable(false);
		panelKH.add(txtNgayT);
		
		lblNewLabel_1_1_5 = new JLabel("Điểm:");
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_5.setBounds(100, 226, 185, 26);
		panelKH.add(lblNewLabel_1_1_5);
		
		txtDiem = new JTextField();
		txtDiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiem.setEditable(false);
		txtDiem.setColumns(10);
		txtDiem.setBounds(188, 227, 127, 26);
		panelKH.add(txtDiem);
		
		JLabel lblNewLabel_1_1_5_1 = new JLabel("Hạng:");
		lblNewLabel_1_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_5_1.setBounds(334, 226, 185, 26);
		panelKH.add(lblNewLabel_1_1_5_1);
		
		txtHang = new JTextField();
		txtHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHang.setEditable(false);
		txtHang.setColumns(10);
		txtHang.setBounds(424, 226, 239, 26);
		panelKH.add(txtHang);
		
		chckbxPdon = new JCheckBox("Phòng đơn (A)");
		chckbxPdon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdon.setBounds(287, 436, 178, 43);
		Frame.add(chckbxPdon);
		chckbxPdon.setSelected(true);
		

		
		chckbxPdoi = new JCheckBox("Phòng đôi (B)");
		chckbxPdoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdoi.setBounds(577, 439, 178, 43);
		Frame.add(chckbxPdoi);
		chckbxPdoi.setSelected(true);
		

		
		chckbxPVip = new JCheckBox("Phòng VIP (C)");
		chckbxPVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPVip.setBounds(863, 439, 178, 43);
		Frame.add(chckbxPVip);
		chckbxPVip.setSelected(true);
		
		outerPanel = new JPanel(null);
		outerPanel.setBounds(287, 486, 1580, 464);
		Frame.add(outerPanel);
		
		
		

        // Tạo một panel bên trong với layout null và kích thước cố định
		panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(1500, 380));
		
		 JScrollPane scrollPane = new JScrollPane(panel);                      
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
		 scrollPane.setBounds(0, 0, 1580, 464);

	        // Thêm JScrollPane vào panel bên ngoài
	     outerPanel.add(scrollPane);
	     mangHaiChieu = new String[3][soPhong.length];
	        for (int i = 0; i < soPhong.length; i++) {
	            mangHaiChieu[0][i] = soPhong[i];
	            mangHaiChieu[1][i] = tenKhachHang[i];
	            mangHaiChieu[2][i] = String.valueOf(trangThai[i]);
	        }
//	        
	        mangHaiChieu = sapXep(mangHaiChieu);
	        soPhong = mangHaiChieu[0];
	        tenKhachHang = mangHaiChieu[1];
	        trangThai = new int[soPhong.length];
	        
			for (int i = 0; i < soPhong.length; i++) {
				trangThai[i] = Integer.parseInt(mangHaiChieu[2][i]);
			}
			
//	        button=createButtons(panel, soPhong, tenKhachHang, trangThai);
			
//			soPhong = Arrays.copyOf(soPhong, soPhong.length + 1);
//			soPhong[soPhong.length - 1] = "A11";
//			tenKhachHang = Arrays.copyOf(tenKhachHang, tenKhachHang.length + 1);
//			tenKhachHang[tenKhachHang.length - 1] = "Khongbie";
//			trangThai = Arrays.copyOf(trangThai, trangThai.length + 1);
//			trangThai[trangThai.length - 1] = 2;
			
			
			
			
			
			
		//	button = createButtons(panel, soPhong, tenKhachHang, trangThai);
			
			
			
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
				logo.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH)));
				logo.setBounds(0, 0, 250, 150);
				panel_top.add(logo);
				
				
				
				
				btnTK = new JButton("<html><div style='text-align: center;'>Trần ngu</div></html>");
				btnTK.setFont(new Font("Tahoma", Font.PLAIN, 25));
				btnTK.setForeground(new Color(244, 244, 244));
				btnTK.setBackground(new Color(41, 139, 116));
				btnTK.setBounds(1647, 11, 247, 40);
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/account-icon.png")).getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH)));
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
				btnNhanP.setForeground(new Color(244, 244, 244));
				btnNhanP.setFont(new Font("Tahoma", Font.PLAIN, 30));
				btnNhanP.setBackground(new Color(41, 139, 106));
				btnNhanP.setBounds(460, 25, 200, 99);
				panel_top.add(btnNhanP);
				
				JButton btnTraP = new JButton("Trả Phòng");
				btnTraP.setBackground(new Color(164, 194, 163));
				btnTraP.setForeground(new Color(0, 0, 0));
				btnTraP.setFont(new Font("Tahoma", Font.PLAIN, 30));
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
							dangnhap dn = new dangnhap();
							dn.setVisible(true);
							dispose();
						}if(clickedButton == btnHT) {
							
						}if(clickedButton == btnTKDMK) {
							DoiMatKhau dmk = new DoiMatKhau();
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
                        
                        
                        
                    }};
				
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
				
				
				
				
			
		btnTim.addActionListener(new ActionListener() {
			private Phong_DAO ph;
			

			public void actionPerformed(ActionEvent e) {
				String mkh = txtCCKH.getText();
				// Lưu list chứa các phiếu đặt phòng cần tìm kiếm
				dsPDPTr = new ArrayList<PhieuDatPhong>();
				dsPDVTr = new DAO_PhieuDatDichVu().getDSPhieuDatChuaThanhToan(mkh);
				System.out.println(dsPDVTr.size());
				// Tìm phiếu đặt phòng có mã khách hàng mà trang thái là đang ở
				for (int i = 0; i < dsPDP.size(); i++) {
					if (dsPDP.get(i).getKhachHang().getmaKH().equals(mkh) && (dsPDP.get(i).getTrangThai().contains("Đã nhận") || dsPDP.get(i).getTrangThai().contains("Đã đổi"))) {
						//Thêm phiếu đặt phòng vào danh sách dsPDPTr
						dsPDPTr.add(dsPDP.get(i));
					}
				}				
				for (int i = 0; i < dsPDVTr.size(); i++) {
					// Lấy danh sách phiếu đặt dịch vụ của khách hàng
					if (dsPDVTr.get(i).getKhachHang().equals(mkh)) {
						dsPDVTr.add(dsPDVTr.get(i));
					}
				}
				// Thêm thông tin vào các textfield
				if (!dsPDPTr.isEmpty()) { // Kiểm tra danh sách không rỗng trước khi thêm
					for(int i = 0; i < dsPDPTr.size(); i++) {		
						kh = new KhachHang_DAO();
						nv = new NhanVien_DAO();
						ph = new Phong_DAO();
						dsPDPTr.get(i).setKhachHang(kh.getKhachHangByMaKhachHang(dsPDPTr.get(i).getKhachHang().getmaKH()));
						dsPDPTr.get(i).setNhanVien(nv.getNhanVienTheoMaNV(dsPDPTr.get(i).getNhanVien().getMaNV()));
						dsPDPTr.get(i).setPhong(ph.getPhongTheoMaPhong(dsPDPTr.get(i).getPhong().getMaPhong()));
					}
				    txtSDTKH.setText(dsPDPTr.get(0).getKhachHang().getSoDT());
				    txtTenKH.setText(dsPDPTr.get(0).getKhachHang().getHoTen());
				    int tuoi = LocalDate.now().getYear() - dsPDPTr.get(0).getKhachHang().getNgaySinh().getYear();
				    txtTuoiKH.setText(String.valueOf(tuoi));
				    boolean gt = dsPDPTr.get(0).getKhachHang().getGioiTinh();
				    txtGT.setText(gt ? "Nam" : "Nữ");
				    txtNgayN.setText(dsPDPTr.get(0).getThoiGianNhan().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				    txtNgayT.setText(dsPDPTr.get(0).getThoiGianTra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				    txtDiem.setText(String.valueOf(dsPDPTr.get(0).getKhachHang().getDiem()));
				    txtHang.setText(dsPDPTr.get(0).getKhachHang().getHang());
				    // settext Phòng, dùng vòng for để lấy thông tin phòng
					for (int i = 0; i < dsPDPTr.size(); i++) {
						if (i == 0)
							txtPhongs.setText(dsPDPTr.get(i).getPhong().getMaPhong());
						else {
							txtPhongs.setText(txtPhongs.getText() + ", " + dsPDPTr.get(i).getPhong().getMaPhong());
						}
					}	
				    txtSoNguoi.setText(dsPDPTr.get(0).getSoNguoi());
				 // Cập nhật các button phòng tương ứng (dsDPTr)
					panel.removeAll();
					panel.repaint();
					panel.revalidate();
					soPhong = new String[0];
					trangThai = new int[0];
					tenKhachHang = new String[0];
					for (int i = 0; i < dsPDPTr.size(); i++) {
						soPhong = Arrays.copyOf(soPhong, soPhong.length + 1);
						soPhong[soPhong.length - 1] = dsPDPTr.get(i).getPhong().getMaPhong();
						trangThai = Arrays.copyOf(trangThai, trangThai.length + 1);
						trangThai[trangThai.length - 1] = 2;
						tenKhachHang = Arrays.copyOf(tenKhachHang, tenKhachHang.length + 1);
						for (int j = 0; j < dsKH.size(); j++) {
							if (dsKH.get(j).getmaKH().equals(dsPDPTr.get(i).getKhachHang().getmaKH())) {
								tenKhachHang[tenKhachHang.length - 1] = dsKH.get(j).getHoTen();
							}
						}
					}
					mangHaiChieu = new String[3][soPhong.length];
					for (int i = 0; i < soPhong.length; i++) {
						mangHaiChieu[0][i] = soPhong[i];
						mangHaiChieu[1][i] = tenKhachHang[i];
						mangHaiChieu[2][i] = String.valueOf(trangThai[i]);
					}
					mangHaiChieu = sapXep(mangHaiChieu);
					soPhong = mangHaiChieu[0];
					tenKhachHang = mangHaiChieu[1];
					trangThai = new int[soPhong.length];
					for (int i = 0; i < soPhong.length; i++) {
						trangThai[i] = Integer.parseInt(mangHaiChieu[2][i]);
					}
					button = createButtons(panel, soPhong, tenKhachHang, trangThai);
				}
                else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin khách hàng");
				}	
			}		
		});
			
		btnXutHan.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {			
			chitiethoadon = new GUI_ChiTietHoaDon(dsPDPTr, dsPDVTr);
			chitiethoadon.setVisible(true);
			// set trạng thái phiếu đạt phòng thành đã hủy, phòng thành bảo trì
			for (int i = 0; i < dsPDPTr.size(); i++) {
				new PhieuDatPhong_DAO().updateTrangThaiPhieuDatPhong(dsPDPTr.get(i).getMaPhieu(), "Đã trả");
				new Phong_DAO().updateTrangThaiPhong(dsPDPTr.get(i).getPhong().getMaPhong(), "Bảo trì");	
			}
			// Set trạng thái phiếu dịch vụ
			for (int i = 0; i < dsPDVTr.size(); i++) {
				new DAO_PhieuDatDichVu().updateTrangThaiPhieuDatDichVu(dsPDVTr.get(i).getMaPhieu());
			}
		}
		});

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
			for (int i = 0; i < soPhong.length; i++) {
				if (soPhong[i].contains("A") && trangThai[i] == 2) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = soPhong[i];
					tens = Arrays.copyOf(tens, tens.length + 1);
					tens[tens.length - 1] = tenKhachHang[i];
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[i];
				}
			}
		}

		if (chckbxPdoi.isSelected()) {
			for (int i = 0; i < soPhong.length; i++) {
				if (soPhong[i].contains("B") && trangThai[i] == 2) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = soPhong[i];
					tens = Arrays.copyOf(tens, tens.length + 1);
					tens[tens.length - 1] = tenKhachHang[i];
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[i];

				}

			}

		}

		if (chckbxPVip.isSelected()) {
			for (int i = 0; i < soPhong.length; i++) {
				if (soPhong[i].contains("C") && trangThai[i]==2) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = soPhong[i];
					tens = Arrays.copyOf(tens, tens.length + 1);
					tens[tens.length - 1] = tenKhachHang[i];
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[i];
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
			mangHaiChie[1][i] = tens[i];
			mangHaiChie[2][i] = String.valueOf(trangTs[i]);
		}
		mangHaiChie = createTwoDimensionalArray(maphongs,tens, trangTs);
		mangHaiChie = sapXep(mangHaiChie);
		
		maphongs = mangHaiChie[0];
		tens = mangHaiChie[1];
		trangTs = new int[maphongs.length];
		for (int i = 0; i < maphongs.length; i++) {
			trangTs[i] = Integer.parseInt(mangHaiChie[2][i]);
		}
		button = createButtons(panel, maphongs, tens, trangTs);
		
	}

	public static String[][] createTwoDimensionalArray(String[] maphong, String[] ten, int[] trangT) {
        Set<String> uniqueMaphong = new HashSet<>();
        List<String> uniqueMaphongList = new ArrayList<>();
        List<String> tenList = new ArrayList<>();
        List<Integer> trangTList = new ArrayList<>();

        for (int i = 0; i < maphong.length; i++) {
            if (!uniqueMaphong.contains(maphong[i])) {
                uniqueMaphong.add(maphong[i]);
                uniqueMaphongList.add(maphong[i]);
                tenList.add(ten[i]);
                trangTList.add(trangT[i]);
            }
        }

        String[][] mangHaiChieu = new String[3][uniqueMaphongList.size()];
        for (int i = 0; i < uniqueMaphongList.size(); i++) {
            mangHaiChieu[0][i] = uniqueMaphongList.get(i);
            mangHaiChieu[1][i] = tenList.get(i);
            mangHaiChieu[2][i] = String.valueOf(trangTList.get(i));
        }
        return mangHaiChieu;
    }
	
	
	public static JButton[] createButtons(JPanel panel, String[] roomNumbers, String[] customerNames, int[] statuses) {
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
            buttons[i].setText(buttons[i].getText().replaceAll("na", customerNames[i]));

            switch (statuses[i]) {
                case 1:
                    buttons[i].setBackground(new Color(34, 242, 93));
                    break;
                case 2:
                    buttons[i].setBackground(new Color(242, 128, 116));
                    break;
                case 3:
                    buttons[i].setBackground(new Color(5, 207, 251));
                    break;
                case 4:
                    buttons[i].setBackground(new Color(251, 193, 146));
                    break;
                default:
                    // Handle other statuses if necessary
                    break;
            }
            
    			buttons[i].addActionListener(new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
    					JButton clickedButton = (JButton) e.getSource();
    					for (int i = 0; i < buttons.length; i++) {
    						if (clickedButton == buttons[i]) {
    							txtPhongs.setText(roomNumbers[i]);
    							txtTenKH.setText(customerNames[i]);
    							for (int j = 0; j < dsPDP.size(); j++) {
    								if (dsPDP.get(i).getPhong().getMaPhong().equals(roomNumbers[i])) {
    									txtCCKH.setText(dsPDP.get(i).getKhachHang().getmaKH());
    									
    									for (int k = 0; k < dsKH.size(); k++) {
    										if (dsKH.get(k).getmaKH().equals(dsPDP.get(i).getKhachHang().getmaKH())) {
    											if (dsKH.get(k).getGioiTinh() == true) {
                                                    txtGT.setText("Nam");
                                                } else {
                                                	txtGT.setText("Nữ");
                                                }
    											txtTenKH.setText(dsKH.get(k).getHoTen());
    											txtTuoiKH.setText(""+LocalDate.now().compareTo(dsKH.get(k).getNgaySinh()));
    											txtSDTKH.setText(dsKH.get(k).getSoDT());
    										}
    									}
    								}
    							}
    							txtNgayN.setText(dsPDP.get(i).getThoiGianNhan().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
    							//lay thoi gian hien tai
    							LocalDate now = LocalDate.now();
    							
    							//set dang dd/MM/yyyy
    							
    							txtNgayT.setText(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
    							txtSoNguoi.setText(""+dsPDP.get(i).getSoNguoi());
    							
    						}
    					}
    				}
    			});
    		
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

					temp = mangHaiChieu[2][i];
					mangHaiChieu[2][i] = mangHaiChieu[2][j];
					mangHaiChieu[2][j] = temp;
				}
			}
		}
		return mangHaiChieu;
	}
}
