package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import dao.DAO_PhieuDatPhong;
import dao.DAO_Phong;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class GUI_PhieuDatPhong extends JFrame implements ItemListener,MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[];
    int trangThai[];
	private String[][] mangHaiChieu;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private DAO_Phong Phong_dao;
	private JComboBox<String> cbPhongBan;
	private DAO_KhachHang khachHang_DAO;
	private DAO_PhieuDatPhong phieuDatPhong_DAO;
	private String maNV;
	private String tenNV;
	private ArrayList<PhieuDatPhong> dsPDP;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<Phong> dsP;
	
	private DAO_NhanVien nhanVien_DAO;
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
	private DAO_NhanVien nv_dao;
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
	static int dem;
	private JTextField txtmaPhieu;
	private JTextField txtmaKH;
	private JTextField txtmaNV;
	private JTextField txtmaPhong;
	private DefaultTableModel modelHD;
	private JTable tableNV;
	private JButton btnTim;
	private boolean isPanelVisible;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien nv = new NhanVien("NV0000001");
					GUI_PhieuDatPhong frame = new GUI_PhieuDatPhong(nv);
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
	public GUI_PhieuDatPhong(NhanVien nv) {
		
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
		phieuDatPhong_DAO = new DAO_PhieuDatPhong();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		
		
		panelTK = new JPanel();
		nv_dao = new  DAO_NhanVien();
		
		ListNV = nv_dao.getalltbNhanVien();
		nhanvien = nv;
		
		getContentPane().add(panelTK);
		for (NhanVien nhanVien : ListNV) {
			
			if (nhanVien.getMaNV().equals(nhanvien.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
		}
		
		
		
	
		
		
		
		
		//set date ngày hôm sau của dateNhanP
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);

		
	     
	     
	     
	     
	     
	     
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
			
			JButton btnXemPDP = new JButton("Xem phiếu đặt");
			btnXemPDP.setBackground(new Color(164, 194, 163));
			btnXemPDP.setForeground(new Color(0,0,0));
			btnXemPDP.setFont(new Font("Tahoma", Font.PLAIN, 25));
			
			btnXemPDP.setBounds(1300, 25, 200, 99);
			panel_top.add(btnXemPDP);
			btnmaNV.setText("<html><div style='text-align: center;'>" +"Mã Nhân viên: "+ nhanvien.getMaNV() + "</div></html>");
			btnTKHTNV.setText("<html><div style='text-align: center;'>" + "Họ tên: "+nhanvien.getHoTenNV() + "</div></html>");
			
			int tuoi = (int) ChronoUnit.YEARS.between(nhanvien.getNgaySinh(), java.time.LocalDate.now());
			btnTKTNV.setText("<html><div style='text-align: center;'>" + "Tuổi: "+tuoi + "</div></html>");
			
			JPanel panel = new JPanel();
			panel.setBounds(250, 150, 1654, 891);
			Frame.add(panel);
			panel.setLayout(null);
			
			JPanel panel_Center_Top = new JPanel();
			panel_Center_Top.setBounds(0, 0, 1653, 223);
			panel.add(panel_Center_Top);
			panel_Center_Top.setLayout(null);
			panel_Center_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_Center_Top.setBackground(Color.WHITE);
			
			JLabel lblMPhiu = new JLabel("Mã Phiếu");
			lblMPhiu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMPhiu.setBounds(140, 25, 186, 35);
			panel_Center_Top.add(lblMPhiu);
			
			JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
			lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTnKhchHng.setBounds(140, 75, 186, 35);
			panel_Center_Top.add(lblTnKhchHng);
			
			txtmaPhieu = new JTextField();
			txtmaPhieu.setForeground(new Color(255, 255, 255));
			txtmaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtmaPhieu.setColumns(10);
			txtmaPhieu.setBackground(new Color(164, 194, 163));
			txtmaPhieu.setBounds(350, 25, 350, 40);
			panel_Center_Top.add(txtmaPhieu);
			
			txtmaKH = new JTextField();
			txtmaKH.setForeground(new Color(255, 255, 255));
			txtmaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtmaKH.setColumns(10);
			txtmaKH.setBackground(new Color(164, 194, 163));
			txtmaKH.setBounds(350, 75, 350, 40);
			panel_Center_Top.add(txtmaKH);
			
			JLabel lblTen = new JLabel("Mã Nhân Viên");
			lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTen.setBounds(944, 25, 134, 35);
			panel_Center_Top.add(lblTen);
			
			JLabel lblSDT = new JLabel("Ngày Đặt");
			lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSDT.setBounds(944, 75, 134, 35);
			panel_Center_Top.add(lblSDT);
			
			JLabel lblDC = new JLabel("Ngày trả");
			lblDC.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblDC.setBounds(944, 125, 134, 35);
			panel_Center_Top.add(lblDC);
			
			txtmaNV = new JTextField();
			txtmaNV.setForeground(new Color(255, 255, 255));
			txtmaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtmaNV.setColumns(10);
			txtmaNV.setBackground(new Color(164, 194, 163));
			txtmaNV.setBounds(1100, 25, 350, 40);
			panel_Center_Top.add(txtmaNV);
			
			btnTim = new JButton("Tìm");
			btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnTim.setBackground(new Color(234, 232, 214));
			btnTim.setBounds(1125, 176, 210, 35);
			panel_Center_Top.add(btnTim);
			
			JButton btbXoaTrang = new JButton("Xóa trắng");
			btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btbXoaTrang.setBackground(new Color(234, 232, 214));
			btbXoaTrang.setBounds(1366, 176, 198, 35);
			panel_Center_Top.add(btbXoaTrang);
			
			JLabel lblPhong = new JLabel("Phòng");
			lblPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhong.setBounds(140, 125, 63, 35);
			panel_Center_Top.add(lblPhong);
			
			txtmaPhong = new JTextField();
			txtmaPhong.setForeground(new Color(255, 255, 255));
			txtmaPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtmaPhong.setColumns(10);
			txtmaPhong.setBackground(new Color(164, 194, 163));
			txtmaPhong.setBounds(350, 126, 350, 40);
			panel_Center_Top.add(txtmaPhong);
			
			JDateChooser dateNgayD = new JDateChooser();
			dateNgayD.setForeground(new Color(255, 255, 255));
			dateNgayD.setBackground(new Color(164, 194, 163));
			dateNgayD.setDateFormatString("dd/MM/yyyy");
			dateNgayD.setBounds(1100, 75, 350, 35);
			panel_Center_Top.add(dateNgayD);
			
			JDateChooser dateNgayT = new JDateChooser();
			dateNgayT.setForeground(new Color(255, 255, 255));
			dateNgayT.setBackground(new Color(164, 194, 163));
			dateNgayT.setDateFormatString("dd/MM/yyyy");
			dateNgayT.setBounds(1100, 125, 350, 35);
			panel_Center_Top.add(dateNgayT);
			
			JButton btnHuyPhiu = new JButton("Hủy Phiếu");
			btnHuyPhiu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnHuyPhiu.setBackground(new Color(234, 232, 214));
			btnHuyPhiu.setBounds(882, 176, 210, 35);
			panel_Center_Top.add(btnHuyPhiu);

			
			String[] cols = new String[] {"Mã Phiếu", "Ngày Đặt", "Ngày Nhận", "Ngày Trả", "Đơn Giá", "Mã Phòng", "Mã Khách Hàng", "Mã Nhân Viên", "Số Người", "Trạng Thái"};
					

			modelHD = new DefaultTableModel(cols,0);
			
			
			tableNV = new JTable(modelHD);
			tableNV.setBackground(new Color(234, 232, 214));
			JScrollPane paneNV = new JScrollPane(tableNV);
			paneNV.setBounds(23, 234, 1610, 646);
			paneNV.setPreferredSize(new Dimension(1000,1000));
			panel.add(paneNV);
			JTableHeader headers = tableNV.getTableHeader();
	        Font headerFont = new Font("Tahoma", Font.PLAIN, 15);
	        headers.setFont(headerFont);
	        headers.setPreferredSize(new Dimension(paneNV.getWidth(), 30));
	        headers.setBackground(new Color(164, 194, 163));
	        headers.setForeground(Color.BLACK);
	        headers.setReorderingAllowed(false);
	        headers.setResizingAllowed(false);
	        //header can giua
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        
	        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	        tableNV.setDefaultRenderer(String.class, centerRenderer);
	        
	        
	       
	        Frame.add(panel);
	        Frame.setVisible(true);
			
			
			
			if(!nhanvien.getMaNV().contains("QL")) {
				btnQLNV.setVisible(false);
				btnThongKe.setVisible(false);
				
				btnHT.setBounds(0, 350, 250, 70);
			}
			//set panelTK tắt khi nhấn chỗ khác
			
			
			
			
			
			ActionListener actionListener = new ActionListener() {
			    

				private GUI_QuanLiNhanVien qlnv;
				private Date ngayD;
				private Date ngayT;

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
						dispose();
					}if(clickedButton == btnTK) {
						togglePanelVisibility();
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
					if (clickedButton == btnXemPDP) {
						GUI_PhieuDatPhong pdp = new GUI_PhieuDatPhong(nhanvien);
						pdp.setVisible(true);
						dispose();
					}
					if(clickedButton == btnTim) {
						String maPhieu = txtmaPhieu.getText();
						String maKH = txtmaKH.getText();
						String maNV = txtmaNV.getText();
						String maPhong = txtmaPhong.getText();
						if (dateNgayD.getDate() != null) {
							ngayD = new Date(dateNgayD.getDate().getTime());
						}
						if (dateNgayT.getDate() != null) {
							ngayT = new Date(dateNgayT.getDate().getTime());
						}
						
						if(maPhieu.equals("") && maKH.equals("") && maNV.equals("") && maPhong.equals("") && ngayD == null && ngayT == null) {
                            dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
                            modelHD.setRowCount(0);
							for (PhieuDatPhong phieuDatPhong : dsPDP) {
								modelHD.addRow(new Object[] { phieuDatPhong.getMaPhieu(),
										phieuDatPhong.getThoiGianDat(), phieuDatPhong.getThoiGianNhan(),
										phieuDatPhong.getThoiGianTra(), phieuDatPhong.getDonGiaPhieu(),
										phieuDatPhong.getPhong().getMaPhong(), phieuDatPhong.getKhachHang().getmaKH(),
										phieuDatPhong.getNhanVien().getMaNV(), phieuDatPhong.getSoNguoi(),
										phieuDatPhong.getTrangThai() });
							}
							return;
                        }
						System.out.println(maPhieu + " " + maKH + " " + maNV + " " + maPhong + " " + ngayD + " " + ngayT);
						dsPDP = timdsPDP(maPhieu, maKH, maNV, maPhong, ngayD, ngayT);
						
						if (dsPDP.size() == 0) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy phiếu đặt phòng");
							
							return;
						}
						
						modelHD.setRowCount(0);
						for (PhieuDatPhong phieuDatPhong : dsPDP) {
							modelHD.addRow(new Object[] { phieuDatPhong.getMaPhieu(), phieuDatPhong.getThoiGianDat(),
									phieuDatPhong.getThoiGianNhan(), phieuDatPhong.getThoiGianTra(), phieuDatPhong.getDonGiaPhieu(),
									phieuDatPhong.getPhong().getMaPhong(), phieuDatPhong.getKhachHang().getmaKH(), phieuDatPhong.getNhanVien().getMaNV(),
									phieuDatPhong.getSoNguoi(), phieuDatPhong.getTrangThai() });
						
						}
					}if(clickedButton == btbXoaTrang) {
						txtmaPhieu.setText("");
						txtmaKH.setText("");
						txtmaNV.setText("");
						txtmaPhong.setText("");
						dateNgayD.setDate(null);
						dateNgayT.setDate(null);
						ngayD = null;
						ngayT = null;
						modelHD.setRowCount(0);
						
						
					}if(clickedButton == btnHuyPhiu) {
						int row = tableNV.getSelectedRow();
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu đặt phòng cần hủy");
							return;
						}
						String maPhieu = (String) tableNV.getValueAt(row, 0);
						phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
						JOptionPane.showMessageDialog(null, "Hủy phiếu đặt phòng thành công");
						modelHD.setRowCount(0);
						dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
						for (PhieuDatPhong phieuDatPhong2 : dsPDP) {
							modelHD.addRow(new Object[] { phieuDatPhong2.getMaPhieu(), phieuDatPhong2.getThoiGianDat(),
									phieuDatPhong2.getThoiGianNhan(), phieuDatPhong2.getThoiGianTra(),
									phieuDatPhong2.getDonGiaPhieu(), phieuDatPhong2.getPhong().getMaPhong(),
									phieuDatPhong2.getKhachHang().getmaKH(), phieuDatPhong2.getNhanVien().getMaNV(),
									phieuDatPhong2.getSoNguoi(), phieuDatPhong2.getTrangThai() });
						}
					}
					

					
			    }

				private ArrayList<PhieuDatPhong> timdsPDP(String maPhieu, String maKH, String maNV, String maPhong,
						Date ngayD2, Date ngayT2) {
					ArrayList<PhieuDatPhong> ds = new ArrayList<>();
					ArrayList<PhieuDatPhong> dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
					for (PhieuDatPhong phieuDatPhong : dsPDP) {
						if (!maPhieu.equals("") && !phieuDatPhong.getMaPhieu().contains(maPhieu)) {
							continue;
						}
						if (!maKH.equals("") && !phieuDatPhong.getKhachHang().getmaKH().contains(maKH)) {
							continue;
						}
						if (!maNV.equals("") && !phieuDatPhong.getNhanVien().getMaNV().contains(maNV)) {
							continue;
						}
						if (!maPhong.equals("") && !phieuDatPhong.getPhong().getMaPhong().contains(maPhong)) {
							continue;
						}
						if (ngayD2 != null && ChronoUnit.DAYS.between(phieuDatPhong.getThoiGianDat(), ngayD2.toLocalDate()) != 0) {
							continue;
						}
						if (ngayT2 != null && ChronoUnit.DAYS.between(phieuDatPhong.getThoiGianTra(), ngayT2.toLocalDate()) != 0) {
							continue;
						}
						ds.add(phieuDatPhong);
					}
					return ds;
				}
			};
                    
                    btnTrangChu.addActionListener(actionListener);
        			btnQLP.addActionListener(actionListener);
        			btnQLHD.addActionListener(actionListener);
        			btnQLKH.addActionListener(actionListener);
        			btnQLDV.addActionListener(actionListener);
        			btnThongKe.addActionListener(actionListener);
        			btnQLNV.addActionListener(actionListener);
        			btnXemPDP.addActionListener(actionListener);
        			
        			btnTK.addActionListener(actionListener);
        			btnTKDX.addActionListener(actionListener);
        			btnHT.addActionListener(actionListener);
        			btnTKDMK.addActionListener(actionListener);
        			btnDatPhong.addActionListener(actionListener);
        			btnNhanP.addActionListener(actionListener);
        			btnTraP.addActionListener(actionListener);
        			btnDoiP.addActionListener(actionListener);
        			btnGHP.addActionListener(actionListener);
        			btnTim.addActionListener(actionListener);
        			btbXoaTrang.addActionListener(actionListener);
        			btnHuyPhiu.addActionListener(actionListener);
					
        			Frame.addMouseListener(new MouseAdapter() {
        	            @Override
        	            public void mouseClicked(MouseEvent e) {
        	                if (isPanelVisible && !panelTK.getBounds().contains(e.getPoint())) {
        	                    togglePanelVisibility();
        	                }
        	            }
        	        });         
                 
                    
	}
	private void togglePanelVisibility() {
        isPanelVisible = !isPanelVisible;
        panelTK.setVisible(isPanelVisible);
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//panelTK tắt khi click ra ngoài
		if (isPanelVisible && !panelTK.getBounds().contains(e.getPoint())) {
            togglePanelVisibility();
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}