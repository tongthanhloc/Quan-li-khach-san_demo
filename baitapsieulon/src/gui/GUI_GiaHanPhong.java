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



public class GUI_GiaHanPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblNewLabel_1_4;
    private JPanel panelP;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JTextField txtNgayN;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JTextField textField_8;
    private JTextField textField_9;
    private JButton btnGHP;
    private JButton btnHuy;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[]; //= {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private String maphongs[]=null;
	private String maPhieuDatPhong[]=null;
	private long ngay;
	
	
	
	private Phong_DAO Phong_dao;
	private JPanel panel;
	private JPanel panelKH;
	private JTextField txtPTrong;
	private JTextField txtGioi;
	private KhachHang_DAO khachHang_DAO;
	private PhieuDatPhong_DAO phieuDatPhong_DAO;
	private ArrayList<PhieuDatPhong> dsPDP;
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
					GUI_GiaHanPhong frame = new GUI_GiaHanPhong(nv);
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
	public GUI_GiaHanPhong(NhanVien nv) {
		
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setResizable(false);
		setLocationRelativeTo(null);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		maphongs = new String[0];
		maPhieuDatPhong = new String[0];
		

		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Phong_dao  = new Phong_DAO();
		ArrayList<Phong> dsP = Phong_dao.getalltbPhong();
		soPhong = new String[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			soPhong[i] = dsP.get(i).getMaPhong();
		}
		khachHang_DAO = new KhachHang_DAO();
		ArrayList<KhachHang> dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		// kiểm tra trạng thái phòng
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getTrangThai().contains("Đã đặt")&&dsPDP.get(i).getThoiGianNhan().compareTo(LocalDate.now())<0) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
			}
			if (dsPDP.get(i).getTrangThai().contains("Đã nhận")
					&& dsPDP.get(i).getThoiGianTra().compareTo(LocalDate.now()) ==-1) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
//				JOptionPane.showMessageDialog(null, "Phòng " + dsPDP.get(i).getPhong().getMaPhong() + " đã quá hạn"+(dsPDP.get(i).getThoiGianTra().compareTo(LocalDate.now()))+"ngày");
			}
		}
		LocalDate tghientai = LocalDate.now();
		for (int i = 0; i < dsP.size(); i++) {
			for(int j = 0; j < dsPDP.size(); j++) {
			
				if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
						&& dsPDP.get(j).getTrangThai().contains("Đã đặt")
						&& (dsPDP.get(j).getThoiGianNhan().compareTo(tghientai) == 0)
						) {
					Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Đã đặt");
				}else if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
                        && dsPDP.get(j).getTrangThai().contains("Đã nhận")
                        ) {
                    Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Đã thuê");
				}
			}
		}
		
		
		panelTK = new JPanel();
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
		nhanvien = nv;
		panel = new JPanel(null);
		getContentPane().add(panelTK);
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
		}
		
		
		
		
		
		
		
		
		trangThai = new int[dsP.size()];
		// lay thoi gian hien tai
		
		
		tenKhachHang = new String[dsP.size()];
		


		
		for (int i = 0; i < dsP.size(); i++) {
			
			if (dsP.get(i).getTrangThai().contains("Đã đặt")) {
				trangThai[i] = 1;
				for (int j = 0; j < dsPDP.size(); j++) {
					if (dsP.get(i).getMaPhong().equals(dsPDP.get(j).getPhong().getMaPhong())
							&& dsPDP.get(j).getTrangThai().contains("Đã đặt")) {
						for (int k = 0; k < dsKH.size(); k++) {
							if (dsKH.get(k).getmaKH().equals(dsPDP.get(j).getKhachHang().getmaKH())) {
								tenKhachHang[i] = dsKH.get(k).getHoTen();
								
							}
						}
					}
				}
			} else if (dsP.get(i).getTrangThai().contains("Đã thuê")) {
				trangThai[i] = 2;
				for (int j = 0; j < dsPDP.size(); j++) {
					if (dsP.get(i).getMaPhong().contains(dsPDP.get(j).getPhong().getMaPhong())
							&& dsPDP.get(j).getTrangThai().contains("Đã nhận")) {
						
						for (int k = 0; k < dsKH.size(); k++) {
							if (dsKH.get(k).getmaKH().equals(dsPDP.get(j).getKhachHang().getmaKH())) {
								tenKhachHang[i] = dsKH.get(k).getHoTen();
								
							}
						}
					}
				}
			} else if (dsP.get(i).getTrangThai().contains("Trống")) {
				trangThai[i] = 3;
				tenKhachHang[i] = "";
				
			}else {
				trangThai[i] = 4;
				tenKhachHang[i] = "";
				
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
		txtmaKH.setBounds(313, 37, 350, 26);
		panelKH.add(txtmaKH);
		txtmaKH.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim.setBounds(696, 37, 96, 26);
		panelKH.add(btnTim);
		
		txtSDT = new JTextField();
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
		lblNewLabel_1_2.setBounds(938, 37, 185, 26);
		panelKH.add(lblNewLabel_1_2);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(1205, 41, 350, 26);
		txtTen.setEditable(false);
		panelKH.add(txtTen);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(938, 82, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(1045, 86, 150, 26);
		txtTuoi.setEditable(false);
		panelKH.add(txtTuoi);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1237, 82, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		txtGioi = new JTextField();
		txtGioi.setColumns(10);
		txtGioi.setBounds(1362, 86, 193, 26);
		txtGioi.setEditable(false);
		panelKH.add(txtGioi);
		
		panelP = new JPanel();
		panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelP.setBounds(250, 288, 1654, 190);
		Frame.add(panelP);
		panelP.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Số Phòng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(100, 27, 185, 26);
		panelP.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(100, 75, 185, 26);
		panelP.add(lblNewLabel_8);
		
		txtNgayN = new JTextField();
		txtNgayN.setColumns(10);
		txtNgayN.setBounds(313, 75, 350, 26);
		txtNgayN.setEditable(false);
		panelP.add(txtNgayN);
		
		lblNewLabel_10 = new JLabel("Ngày trả Phòng:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(937, 75, 185, 26);
		panelP.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Phòng còn trống tới ngày:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(937, 27, 258, 26);
		panelP.add(lblNewLabel_11);
		
		JDateChooser dateTraP = new JDateChooser();
		dateTraP.setDateFormatString("dd/MM/yyyy");
		dateTraP.setBounds(1205, 75, 350, 26);
		dateTraP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//set date ngày mai
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		dateTraP.setDate(cal.getTime());
		//tat chuc nang sua text
		dateTraP.getDateEditor().setEnabled(false);
		panelP.add(dateTraP);
		
		btnGHP = new JButton("Gia hạn phòng");
		btnGHP.setBackground(new Color(234, 232, 214));
		btnGHP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGHP.setBounds(1204, 133, 173, 26);
		panelP.add(btnGHP);
		
		btnHuy = new JButton("Hủy");
		
		btnHuy.setBackground(new Color(234, 232, 214));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuy.setBounds(1387, 133, 168, 26);
		panelP.add(btnHuy);
		
		txtPTrong = new JTextField();
		txtPTrong.setColumns(10);
		txtPTrong.setBounds(1205, 27, 350, 26);
		txtPTrong.setEditable(false);
		panelP.add(txtPTrong);
		
		JComboBox cbxPhong = new JComboBox();
		cbxPhong.setBounds(313, 27, 350, 26);
		panelP.add(cbxPhong);
	     
        
		
		
		
		
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
		btnGHP.setForeground(new Color(0, 0, 0));
		btnGHP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGHP.setBackground(new Color(164, 194, 163));
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
		
		btnGHP.setBackground(new Color(164, 194, 163));
		btnGHP.setForeground(new Color(0,0,0));
		
		
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
				}if(clickedButton == btnXemPhiut) {
					GUI_PhieuDatPhong pdp = new GUI_PhieuDatPhong(nhanvien);
					pdp.setVisible(true);
					dispose();
				}
	                // Xử lý sự kiện cho mỗi nút ở đây
	                if (clickedButton==btnTim) {
	                	
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
	             			   txtGioi.setText("Nam");
	 						} else {
	 							txtGioi.setText("Nữ");
	 						}
	             		   
	             		   cbxPhong.removeAllItems();
	                 		for (int i = 0; i < dsPDP.size(); i++) {
								if (dsPDP.get(i).getKhachHang().getmaKH().equals(maKH)&&(dsPDP.get(i).getTrangThai().contains("Đã nhận")||dsPDP.get(i).getTrangThai().contains("Đã đặt")) ){
									cbxPhong.addItem(dsPDP.get(i).getPhong().getMaPhong());
									//tao bien lay ma phong va ma phieu
									maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
		        					maphongs[maphongs.length - 1] = soPhong[i];
		        					maPhieuDatPhong = Arrays.copyOf(maPhieuDatPhong, maPhieuDatPhong.length + 1);
		        					maPhieuDatPhong[maPhieuDatPhong.length - 1] = dsPDP.get(i).getMaPhieu();
								}
	                 		}
	                 		cbxPhong.addActionListener(new ActionListener() {
	    	    				

								public void actionPerformed(ActionEvent e) {
	    	    					
	    	    					if(cbxPhong.getSelectedItem() != null) {
	    	    						txtPTrong.setText("");
	    	    						for (int i = 0; i < dsPDP.size(); i++) {
	    	    							if (cbxPhong.getSelectedItem().equals(dsPDP.get(i).getPhong().getMaPhong())) {
	    	    								txtNgayN.setText(dsPDP.get(i).getThoiGianDat().toString());
	    	    								
	    	    							}
	    	    						}
	    	    						int	count = 0;
	    	    						int kiemtra=0;
	    	    						//lay thoi gian phong con trong
	    	    						for (int i = 0; i < dsPDP.size(); i++) {
	    	    							//lay so thu tu cua cbxPhong
	    	    							int so = cbxPhong.getSelectedIndex();
	    	    							
	    	    								if (dsPDP.get(i).getMaPhieu().equals(maPhieuDatPhong[so])) {
	    	    									continue;
	    	    								}
	    	    							int dem = 0;
	    	    							if (cbxPhong.getSelectedItem().toString().equals(dsPDP.get(i).getPhong().getMaPhong().toString())) {

	    	    								if (ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now()) < 0 &&dsPDP.get(i).getTrangThai().contains("Đã đặt")) {
//	    	    									JOptionPane.showMessageDialog(null, "Phòng còn trống tới ngày " + dsPDP.get(i).getThoiGianNhan());
													if (dem == 0) {
														ngay=-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now());
														txtPTrong.setText(-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now())+" ngày");
														LocalDate tra = dsPDP.get(i).getThoiGianNhan().plusDays(-1);
														dateTraP.setDate(java.sql.Date.valueOf(tra));
														dem++;
													}else {
														if(-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now())<Integer.parseInt(txtPTrong.getText().substring(0, txtPTrong.getText().indexOf(" ")))) {
                                                            ngay=-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now());
															txtPTrong.setText(-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now())+" ngày");
															LocalDate tra = dsPDP.get(i).getThoiGianNhan().plusDays(-1);
															dateTraP.setDate(java.sql.Date.valueOf(tra));
														}
													}
//	    	    									txtPTrong.setText(-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now())+" ngày");
//	    	    									System.out.println("phong "+dsPDP.get(i).getPhong().getMaPhong());
	    	    									count++;
	    	    								}
	    	    								
	    	    							}
	    	    							
	    	    						}
	    	    						if (count == 0) {
	    	    							txtPTrong.setText("Không có đặt trước");
	    	    						}
	    	    					}
	    	    	                
	    	    			}
	    	    		});
	                 	}
	             	   else {
	             	   		JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng");
	             	   	
	             	 }
	                }if(clickedButton==btnGHP) {
                    	
                    	if (cbxPhong.getSelectedItem() == null) {
                    		JOptionPane.showMessageDialog(null, "Chưa chọn phòng");
                    		return;
                    	} else if (dateTraP.getDate() == null) {
							JOptionPane.showMessageDialog(null, "Chưa chọn ngày trả phòng");
							return;
                    	} else if (txtmaKH.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa nhập mã khách hàng");
							return;
						}  //kiem tra ngay tra phong
                    	else if(!txtPTrong.getText().equals("Không có đặt trước")) {
                    		if (ChronoUnit.DAYS.between(LocalDate.now(), dateTraP.getDate().toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate()) < 0) {
                        		JOptionPane.showMessageDialog(null, "Ngày trả phòng không hợp lệ");
                        		return;
                    		} else if (ChronoUnit.DAYS.between(LocalDate.now(), dateTraP.getDate().toInstant()
    								.atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate()) 
    								> ngay) {
    							JOptionPane.showMessageDialog(null, "Ngày trả phòng không hợp lệ");
    							return;
                    		}
                    	}
                    	//update ngay tra
                    	String maPhieu = maPhieuDatPhong[cbxPhong.getSelectedIndex()];
                    	LocalDate ngayTra = dateTraP.getDate().toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();
                    	phieuDatPhong_DAO.updateNgayTraPhieuDatPhong(maPhieu, ngayTra);
                    	JOptionPane.showMessageDialog(null, "Gia hạn thành công");
						dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
//                    	for (int i = 0; i < dsPDP.size(); i++) {
//							if (dsPDP.get(i).getMaPhieu().equals(maPhieu)) {
//								JOptionPane.showMessageDialog(null, "Phòng " + dsPDP.get(i).getPhong().getMaPhong() + " đã được gia hạn tới ngày " + ngayTra);
//							}
//						}
                    	
                    		
                    	
	                
	                
	                
	                }if(clickedButton==btnHuy) {
                    	txtmaKH.setText("");
                    	txtSDT.setText("");
                    	txtTen.setText("");
                    	txtTuoi.setText("");
                    	txtGioi.setText("");
                    	txtNgayN.setText("");
                    	txtPTrong.setText("");
                    	cbxPhong.removeAllItems();
                    	dateTraP.setDate(null);
                    	maPhieuDatPhong = new String[0];
                    	maphongs = new String[0];
                    	
	                }
	                }};
	                btnTim.addActionListener(actionListener);
	                btnGHP.addActionListener(actionListener);
	                btnHuy.addActionListener(actionListener);
	                
	                btnTrangChu.addActionListener(actionListener);
        			btnQLP.addActionListener(actionListener);
        			btnQLHD.addActionListener(actionListener);
        			btnQLKH.addActionListener(actionListener);
        			btnQLDV.addActionListener(actionListener);
        			btnThongKe.addActionListener(actionListener);
        			btnQLNV.addActionListener(actionListener);
        			
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
	                
	                          
	
	

	
}}
