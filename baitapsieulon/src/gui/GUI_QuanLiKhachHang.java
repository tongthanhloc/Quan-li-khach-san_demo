package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import entity.KhachHang;
import entity.NhanVien;

import javax.swing.JComboBox;

public class GUI_QuanLiKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Frame;
	private JPanel panel_Center_Top;
	private JLabel lblMaKH;
	private JLabel lblEmail;
	private JTextField txtMa;
	private JTextField txtEmail;
	private JLabel lblTen;
	private JLabel lblSDT;
	private JLabel lblDC;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDC;
	private JButton btbXoaTrang;
	static DefaultTableModel modelHD;
	private JTable tableNV;
	private JTextField textField;
	private String maKH;
	private JButton btnThmKhchHng;
	private JButton btnXemChiTit;
	private NhanVien_DAO nv_dao;
	private ArrayList<NhanVien> ListNV;
	private NhanVien nhanvien;
	static ArrayList<KhachHang> dskh;
	private GUI_QuanLiDatPhong qlp;
	private GUI_QuanLiHoaDon qlhd;
	private GUI_QuanLiKhachHang qlkh;
	
	private GUI_QuanLiDichVu qldv;
	private GUI_ThongKeNhanVien tknv;
	private JButton btnTrangChu;
	private JButton btnQLP;
	private JButton btnQLHD;
	private JButton btnQLKH;
	private JButton btnQLNV;
	private JButton btnQLDV;
	private JButton btnThongKe;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel  lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel  lblNewLabel_6;

	private JButton btnHT;
	private JButton btnTK;
	private JPanel panelTK;
	private JButton btnTKDMK;
	private JButton btnTKDX;
	private JLabel btnTKHTNV;
	private JLabel btnTKTNV;
	private JLabel btnmaNV;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien nv = new NhanVien("QL0000010");
					GUI_QuanLiKhachHang frame = new GUI_QuanLiKhachHang(nv);
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
	public GUI_QuanLiKhachHang(NhanVien nv) {
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setLocationRelativeTo(null);
		
		nhanvien = nv;
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
		
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
		}
		
		
		
		
		Frame = new JPanel();
		Frame.setBackground(new Color(255, 255, 255));
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		
		
		panelTK = new JPanel();
		
		
		
		panelTK.setBounds(1647, 53, 247, 218);
		panelTK.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		
		panelTK.setLayout(null);
		panelTK.setVisible(false);
		Frame.add(panelTK);
		
		
		
		
		Panel panel_top = new Panel();
		panel_top.setLayout(null);
		panel_top.setBackground(Color.LIGHT_GRAY);
		panel_top.setBounds(0, 0, 1904, 150);
		Frame.add(panel_top);
		
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
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setBounds(0, 0, 250, 70);
		panel_menu.add(btnTrangChu);
		
		
		btnQLP = new JButton("Quản lí phòng");
		btnQLP.setBackground(new Color(255, 255, 255));
		btnQLP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLP.setBounds(0, 70, 250, 70);
		panel_menu.add(btnQLP);
		
		
		btnQLHD = new JButton("Quản lí hóa đơn");
		btnQLHD.setBackground(new Color(255, 255, 255));
		btnQLHD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLHD.setBounds(0, 140, 250, 70);
		panel_menu.add(btnQLHD);
		
		
		btnQLKH = new JButton("Quản lí Khách hàng");
		btnQLKH.setBackground(new Color(41, 139, 116));
		btnQLKH.setForeground(new Color(255, 255, 255));
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
		btnmaNV.setText("<html><div style='text-align: center;'>" +"Mã Nhân viên: "+ nhanvien.getMaNV() + "</div></html>");
		btnTKHTNV.setText("<html><div style='text-align: center;'>" + "Họ tên: "+nhanvien.getHoTenNV() + "</div></html>");
		int tuoi = (int) ChronoUnit.YEARS.between(nhanvien.getNgaySinh(), java.time.LocalDate.now());
		btnTKTNV.setText("<html><div style='text-align: center;'>" + "Tuổi: "+tuoi + "</div></html>");
		
		
		
		
		if(!nhanvien.getMaNV().contains("QL")) {
			btnQLNV.setVisible(false);
			btnThongKe.setVisible(false);
			
			btnHT.setBounds(0, 350, 250, 70);
		}
		
		
		panel_Center_Top = new JPanel();
		panel_Center_Top.setBackground(new Color(255, 255, 255));
		panel_Center_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Center_Top.setBounds(251, 150, 1653, 223);
		Frame.add(panel_Center_Top);
		panel_Center_Top.setLayout(null);
		
		lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKH.setBounds(140, 25, 186, 35);
		panel_Center_Top.add(lblMaKH);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(140, 75, 186, 35);
		panel_Center_Top.add(lblEmail);
		
		txtMa = new JTextField();
		txtMa.setBackground(new Color(164, 194, 163));
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMa.setColumns(10);
		txtMa.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMa);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(164, 194, 163));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(350, 75, 350, 40);
		panel_Center_Top.add(txtEmail);
		
		lblTen = new JLabel("Tên khách hàng");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(900, 25, 210, 35);
		panel_Center_Top.add(lblTen);
		
		lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBounds(900, 75, 175, 35);
		panel_Center_Top.add(lblSDT);
		
		lblDC = new JLabel("Địa chỉ");
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDC.setBounds(900, 125, 198, 35);
		panel_Center_Top.add(lblDC);
		
		txtTenKH = new JTextField();
		txtTenKH.setBackground(new Color(164, 194, 163));
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(1100, 25, 350, 40);
		panel_Center_Top.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setBackground(new Color(164, 194, 163));
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(1100, 75, 350, 40);
		panel_Center_Top.add(txtSDT);
		
		txtDC = new JTextField();
		txtDC.setBackground(new Color(164, 194, 163));
		txtDC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDC.setColumns(10);
		txtDC.setBounds(1100, 125, 350, 40);
		panel_Center_Top.add(txtDC);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setBounds(1125, 176, 210, 35);
		panel_Center_Top.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btbXoaTrang = new JButton("Xóa trắng");
		btbXoaTrang.setBackground(new Color(234, 232, 214));
		btbXoaTrang.setBounds(1366, 176, 198, 35);
		panel_Center_Top.add(btbXoaTrang);
		btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTuoi = new JLabel("Tuổi");
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTuoi.setBounds(140, 125, 63, 35);
		panel_Center_Top.add(lblTuoi);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBackground(new Color(164, 194, 163));
		textField.setBounds(225, 125, 127, 40);
		panel_Center_Top.add(textField);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGioiTinh.setBounds(375, 125, 100, 35);
		panel_Center_Top.add(lblGioiTinh);
		
		JComboBox cbxGioi = new JComboBox();
		cbxGioi.setBackground(new Color(164, 194, 163));
		cbxGioi.setBounds(485, 126, 215, 35);
		cbxGioi.addItem("Nam");
		cbxGioi.addItem("Nữ");
		panel_Center_Top.add(cbxGioi);
		
		btnThmKhchHng = new JButton("Thêm Khách Hàng");
		btnThmKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThmKhchHng.setBackground(new Color(234, 232, 214));
		btnThmKhchHng.setBounds(650, 176, 210, 35);
		panel_Center_Top.add(btnThmKhchHng);
		
		btnXemChiTit = new JButton("Xem chi tiết");
		btnXemChiTit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXemChiTit.setBackground(new Color(234, 232, 214));
		btnXemChiTit.setBounds(888, 176, 210, 35);
		panel_Center_Top.add(btnXemChiTit);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(271, 369, 1648, 648);

		
		String[] cols = new String[] {"Mã khách hàng", "Tên khách hàng", "Giới tính", "Email", "Số điện thoại", "Địa chỉ", "Ngày sinh"};
		modelHD = new DefaultTableModel(cols,0);
		panel_Center_Bot.setLayout(null);
		tableNV = new JTable(modelHD);
		tableNV.setBackground(new Color(234, 232, 214));
		JScrollPane paneNV = new JScrollPane(tableNV);
		paneNV.setBounds(10, 38, 1610, 599);
		paneNV.setPreferredSize(new Dimension(1000,1000));
		panel_Center_Bot.add(paneNV);;
		JTableHeader headers = tableNV.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 25);
        headers.setFont(headerFont);
        headers.setPreferredSize(new Dimension(paneNV.getWidth(), 30));
        headers.setBackground(new Color(164, 194, 163));
        headers.setForeground(Color.BLACK);
        headers.setReorderingAllowed(false);
        headers.setResizingAllowed(false);
        //set height table va header
        tableNV.setRowHeight(30);
        tableNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tableNV.setDefaultEditor(Object.class, null);
        tableNV.getTableHeader().setPreferredSize(new Dimension(paneNV.getWidth(), 30));
        tableNV.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 20));
        tableNV.getTableHeader().setReorderingAllowed(false);
        tableNV.getTableHeader().setResizingAllowed(false);
        tableNV.getColumnModel().getColumn(0).setPreferredWidth(200);
        tableNV.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableNV.getColumnModel().getColumn(2).setPreferredWidth(100);
        tableNV.getColumnModel().getColumn(3).setPreferredWidth(300);
        tableNV.getColumnModel().getColumn(4).setPreferredWidth(200);
        tableNV.getColumnModel().getColumn(5).setPreferredWidth(300);
        tableNV.getColumnModel().getColumn(6).setPreferredWidth(200);
        
                Frame.add(panel_Center_Bot);
                        Frame.setVisible(true);
        
		
		
		
		
        
		
		
		tableNV.addMouseListener(new MouseAdapter() {
			  
			

		    

			public void mouseClicked(MouseEvent e) {
		        int row = tableNV.getSelectedRow();
		        maKH = (String) tableNV.getValueAt(row, 0);
		       
		    }
		});
		

		
        
		
		ActionListener actionListener = new ActionListener() {
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
				}
				if (clickedButton == btnQLNV) {
					GUI_QuanLiNhanVien qlnv = new GUI_QuanLiNhanVien(nhanvien);
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
				}if(clickedButton == btnTim) {
                    // Xử lý khi nhấn vào nút btnTim
                		KhachHang kh = new KhachHang(null);
                		kh.setmaKH(txtMa.getText());
                	    kh.setHoTen(txtTenKH.getText());
                	    kh.setEmail(txtEmail.getText());
                	    kh.setSoDT(txtSDT.getText());
                	    kh.setDiaChi(txtDC.getText());
                	    if (textField.getText().isEmpty()) {
                	        kh.setNgaySinh(null);
                	    } else {
                	        try {
                	            int tuoi = Integer.parseInt(textField.getText());
                	            kh.setNgaySinh(LocalDate.now().minusYears(tuoi));
//                	            JOptionPane.showMessageDialog(null, kh.getNgaySinh());
                	        } catch (NumberFormatException ex) {
                	            JOptionPane.showMessageDialog(null, "Tuổi phải là một số nguyên dương.");
                	            return; // Stop processing further
                	        }}
                	    if (cbxGioi.getSelectedItem().equals("Nam")) {
						kh.setGioiTinh(true);
                	    } else {
						kh.setGioiTinh(false);
                	    }
                	    // Lấy danh sách trung voi khach hang tim kiem tu co so du lieu
                	    dskh = new ArrayList<KhachHang>();
                	    dskh = timKiemKhachHang(kh);
               	        
               	        // Cập nhật lại model
               	        if (dskh.isEmpty()) {
               	        	JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên nào.");
               	        	updateModel(dskh);
               	        } else {
               	        	updateModel(dskh);
               	        }

                } else if(clickedButton == btbXoaTrang) {
                	txtMa.setText("");
                	txtTenKH.setText("");
                	txtEmail.setText("");
                	txtSDT.setText("");
                	txtDC.setText("");
                	textField.setText("");
                	cbxGioi.setSelectedIndex(0);
                	modelHD.setRowCount(0);
                } else if(clickedButton == btnThmKhchHng) {
					KhachHang kh = new KhachHang(null);
					kh.setmaKH(txtMa.getText());
					kh.setHoTen(txtTenKH.getText());
					kh.setEmail(txtEmail.getText());
					kh.setSoDT(txtSDT.getText());
					kh.setDiaChi(txtDC.getText());
					if (textField.getText().isEmpty()) {
						kh.setNgaySinh(null);
					} else {
						try {
							int tuoi = Integer.parseInt(textField.getText());
							kh.setNgaySinh(LocalDate.now().minusYears(tuoi));
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Tuổi phải là một số nguyên dương.");
							return; // Stop processing further
						}
					}
					System.out.println(kh.getNgaySinh());
					if (cbxGioi.getSelectedItem().equals("Nam")) {
						kh.setGioiTinh(true);
					} else {
						kh.setGioiTinh(false);
					}
					kh.setDiem("0");
					kh.setHang("Bronze");
					kh.setNgayDatDau(LocalDate.now().toString());
					// Lấy danh sách trung voi khach hang tim kiem tu co so du lieu
					dskh = new ArrayList<KhachHang>();
					dskh = timKiemKhachHang(kh);
					// Cập nhật lại model
					
					if(dskh.size() == 0) {
						new KhachHang_DAO().themKhachHang(kh);
						JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công.");
						modelHD.setRowCount(0);
						updateModel(new KhachHang_DAO().getalltbKhachHang());
					}else {
						System.out.println("Thêm khách hàng thất bại.");
					}
					
					
                }else if(clickedButton == btnXemChiTit) {
                	if(maKH == null) {
                		JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng.");
                	}else {
                		new GUI_ChiTietKH(maKH).setVisible(true);
                	}}
                }};
                    btnTim.addActionListener(actionListener);
                    btbXoaTrang.addActionListener(actionListener);
                    btnThmKhchHng.addActionListener(actionListener);
                    btnXemChiTit.addActionListener(actionListener);
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
                  }

	

	public JButton getBtnTK() {
		return btnTK;
	}

	public void setBtnTK(JButton btnTK) {
		this.btnTK = btnTK;
	}

	public JButton getBtnXTT() {
		return btnTKDMK;
	}

	public void setBtnXTT(JButton btnXTT) {
		this.btnTKDMK = btnXTT;
	}
	
	public static void updateModel(ArrayList<KhachHang> dsKH) {
		modelHD.setRowCount(0);
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		for (KhachHang kh : dsKH) {
		    // Tạo một mảng chứa dữ liệu của từng đối tượng NhanVien
		    Object[] rowData = new Object[] { 
		    		kh.getmaKH(),
		            kh.getHoTen(),
		            kh.getGioiTinh() == true ? "Nam" : "Nữ",
		            kh.getEmail(), kh.getSoDT(), 
		            kh.getDiaChi(), 
		            kh.getNgaySinh()
		        
		    };
		    modelHD.addRow(rowData);
		}

		    // Thêm hàng mới vào mô hình với dữ liệu từ đối tượng NhanVien
	

	}
	public ArrayList<KhachHang> timKiemKhachHang(KhachHang kh) {
	            ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        ArrayList<KhachHang> dskhTimKiem = new ArrayList<KhachHang>();
        dskh = new KhachHang_DAO().getalltbKhachHang();
        for (KhachHang khachHang : dskh) {
            if (kh.getmaKH() != null && !kh.getmaKH().isEmpty() && !kh.getmaKH().equals(khachHang.getmaKH())) {
                continue;
            }
            if (kh.getHoTen() != null && !kh.getHoTen().isEmpty() && !kh.getHoTen().equals(khachHang.getHoTen())) {
                continue;
            }
            if (kh.getEmail() != null && !kh.getEmail().isEmpty() && !kh.getEmail().equals(khachHang.getEmail())) {
                continue;
            }
            if (kh.getSoDT() != null && !kh.getSoDT().isEmpty() && !kh.getSoDT().equals(khachHang.getSoDT())) {
                continue;
            }
            if (kh.getDiaChi() != null && !kh.getDiaChi().isEmpty() && !kh.getDiaChi().equals(khachHang.getDiaChi())) {
                continue;
            }
            if (kh.getNgaySinh() != null && !kh.getNgaySinh().equals(khachHang.getNgaySinh())) {
                continue;
            }
            if (kh.getGioiTinh() != khachHang.getGioiTinh()) {
                continue;
            }
            dskhTimKiem.add(khachHang);
        }
        return dskhTimKiem;
    }
}

