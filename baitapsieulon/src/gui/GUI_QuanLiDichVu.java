package gui;

import java.awt.Color;
import java.awt.Component;
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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;
import dao.DAO_DichVu;
import dao.NhanVien_DAO;
import entity.DichVu;
import entity.NhanVien;

public class GUI_QuanLiDichVu extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel Frame;
    private JPanel panel_Center_Top;
    private JPanel panel;
    private JLabel lblMa;
    private JLabel lblThueVat;
    private JLabel lblTen;
    private JLabel lblGiaNhap;
    private JLabel lblSoLuong;
    private JLabel lblGiaBan;
    private JTextField txtMaDV;
    private JTextField txtThueVat;
    private JTextField txtTenDV;
    private JTextField txtNhaCCDV;
    private JTextField txtSoLuong;
    private JTextField txtGiaVe;
    private JButton btbXoaTrang;
    private JLabel lblMaDichVu_Tim;
    private JTextField txtTimMa;
    private JLabel lblTenDichVu_Tim;
    private JTextField txtTenDichVu_Tim;
    private JButton btn_Tim;
    private JTable tableHD;
    private DefaultTableModel modelHD;
    private ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
    private JPanel paneDV = new JPanel();
	private JLabel lblMaDV;
	private Component lblTrangThai;
	private JComboBox cbTrangThai;
	
	static NhanVien nhanvien;
	
	private ArrayList<NhanVien> ListNV;
	private NhanVien_DAO nv_dao;
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
	private GUI_QuanLiDatPhong qlp;
	private GUI_QuanLiHoaDon qlhd;
	private GUI_QuanLiKhachHang qlkh;
	private GUI_QuanLiNhanVien qlnv;
	private GUI_QuanLiDichVu qldv;
	private GUI_ThongKeNhanVien tknv;
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
					GUI_QuanLiDichVu frame = new GUI_QuanLiDichVu(nv);
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
	public GUI_QuanLiDichVu(NhanVien nv) {
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setResizable(false);
		setLocationRelativeTo(null);
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
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
        DAO_DichVu dv = new DAO_DichVu();
        dsDV = dv.getAllDichVu();
		Frame = new JPanel();
		Frame.setBackground(new Color(255, 255, 255));
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		
		panelTK = new JPanel();
		Frame.add(panelTK);
		
		
		
		
		
		
		
		
		
		
		panelTK.setBounds(1647, 53, 247, 218);
		panelTK.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		
		panelTK.setLayout(null);
		panelTK.setVisible(false);
		
		
		
		
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
		btnTrangChu.setBackground(new Color(255,255,255));
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
		btnQLDV.setBackground(new Color(41, 139, 116));
		btnQLDV.setForeground(new Color(255, 255, 255));
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
		
		JButton btntDchV = new JButton("Đặt dịch vụ");
		btntDchV.setForeground(new Color(244, 244, 244));
		btntDchV.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btntDchV.setBackground(new Color(41, 139, 106));
		btntDchV.setBounds(260, 26, 200, 99);
		panel_top.add(btntDchV);
		
		
		
		btntDchV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_DatDichVu dv = new GUI_DatDichVu(nhanvien);
				dv.setVisible(true);
				dispose();
			}
		});
		
		
		
		
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
		panel_Center_Top.setBounds(250, 150, 1666, 223);
		Frame.add(panel_Center_Top);
		panel_Center_Top.setLayout(null);
		
		lblMa = new JLabel("Mã dịch vụ");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(140, 25, 200, 35);
		panel_Center_Top.add(lblMa);
		
		lblThueVat = new JLabel("Thuế vặt");
		lblThueVat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThueVat.setBounds(140, 75, 186, 35);
		panel_Center_Top.add(lblThueVat);
		
		txtMaDV = new JTextField();
		txtMaDV.setBackground(new Color(164, 194, 163));
		txtMaDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaDV.setColumns(10);
		txtMaDV.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMaDV);
		
		txtThueVat = new JTextField();
		txtThueVat.setBackground(new Color(164, 194, 163));
		txtThueVat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThueVat.setColumns(10);
		txtThueVat.setBounds(350, 75, 350, 40);
		panel_Center_Top.add(txtThueVat);
		
		lblTen = new JLabel("Tên dịch vụ");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(900, 25, 210, 35);
		panel_Center_Top.add(lblTen);
		
		lblGiaNhap = new JLabel("Nhà CCDV");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaNhap.setBounds(900, 75, 175, 35);
		panel_Center_Top.add(lblGiaNhap);
		
		txtTenDV = new JTextField();
		txtTenDV.setBackground(new Color(164, 194, 163));
		txtTenDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenDV.setColumns(10);
		txtTenDV.setBounds(1100, 25, 350, 40);
		panel_Center_Top.add(txtTenDV);
		
		txtNhaCCDV = new JTextField();
		txtNhaCCDV.setBackground(new Color(164, 194, 163));
		txtNhaCCDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNhaCCDV.setColumns(10);
		txtNhaCCDV.setBounds(1100, 75, 350, 40);
		panel_Center_Top.add(txtNhaCCDV);

		
		btbXoaTrang = new JButton("Xóa trắng");
		btbXoaTrang.setBackground(new Color(234, 232, 214));
	    // btn xóa trắng nằm ngang giữa
		btbXoaTrang.setBounds(870, 176, 175, 35);
		panel_Center_Top.add(btbXoaTrang);
		btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btn_Sua = new JButton("Sửa");
		btn_Sua.setBackground(new Color(234, 232, 214));
		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Sua.setBounds(1070, 176, 175, 35);
		panel_Center_Top.add(btn_Sua);
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(234, 232, 214));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBounds(1270, 176, 175, 35);
		panel_Center_Top.add(btnThem);
		
		lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoLuong.setBounds(140, 125, 186, 35);
		panel_Center_Top.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBackground(new Color(164, 194, 163));
		txtSoLuong.setBounds(350, 125, 350, 40);
		panel_Center_Top.add(txtSoLuong);
		
		lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrangThai.setBounds(140, 175, 186, 35);
		panel_Center_Top.add(lblTrangThai);
		cbTrangThai = new JComboBox();
		cbTrangThai.setBackground(new Color(164, 194, 163));
		cbTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbTrangThai.setBounds(350, 175, 350, 40);
		panel_Center_Top.add(cbTrangThai);
		
		cbTrangThai.addItem("Ngừng kinh doanh");
		cbTrangThai.addItem("Đang kinh doanh");
		
		
		lblGiaBan = new JLabel("Gía vé");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaBan.setBounds(900, 125, 175, 35);
		panel_Center_Top.add(lblGiaBan);
		
		txtGiaVe = new JTextField();
		txtGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaVe.setColumns(10);
		txtGiaVe.setBackground(new Color(164, 194, 163));
		txtGiaVe.setBounds(1100, 125, 350, 40);
		panel_Center_Top.add(txtGiaVe);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(268, 384, 1648, 513);

		// panel_Center_Bot xét thành absolute layout
		panel_Center_Bot.setLayout(null);
		String[] cols = { "Mã dịch vụ", "Tên dịch vụ", "Nhà CCDV", "Thuế vặt", "Số lượng", "Đơn giá" , "Trạng thái"};
		
        modelHD = new DefaultTableModel(cols, 0);

        paneDV.setLayout(null);
        tableHD = new JTable(modelHD);
        tableHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tableHD.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //set màu header
        JTableHeader header = tableHD.getTableHeader();
        header.setBackground(new Color(164, 194, 163));
        header.setForeground(Color.white);
        header.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tableHD.setRowHeight(30);
        
        
        
        
        JScrollPane paneNV = new JScrollPane(tableHD);
 	    paneNV.setBounds(0, 0, 1630, 500);

        panel_Center_Bot.add(paneNV);

        JTableHeader headers = tableHD.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 20);
        headers.setFont(headerFont);
        //set màu table và height
        tableHD.setBackground(new Color(234, 232, 214));
        
        

        tableHD.setFont(new Font("Tahoma", Font.PLAIN, 20));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableHD.setDefaultRenderer(Object.class, centerRenderer);
        tableHD.setRowHeight(30);
   
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
				}
		    }
		};
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


        
        
		Frame.add(panel_Center_Bot);
		
		panel = new JPanel();
		panel.setBounds(250, 897, 1654, 112);
		Frame.add(panel);
		panel.setLayout(null);
		
		lblMaDichVu_Tim = new JLabel("Mã dịch vụ");
		lblMaDichVu_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaDichVu_Tim.setBounds(45, 45, 246, 35);
		panel.add(lblMaDichVu_Tim);
		
		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimMa.setColumns(10);
		txtTimMa.setBackground(new Color(164, 194, 163));
		txtTimMa.setBounds(205, 45, 350, 40);
		panel.add(txtTimMa);
		
		lblTenDichVu_Tim = new JLabel("Tên dịch vụ");
		lblTenDichVu_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenDichVu_Tim.setBounds(700, 45, 210, 35);
		panel.add(lblTenDichVu_Tim);
		
		txtTenDichVu_Tim = new JTextField();
		txtTenDichVu_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenDichVu_Tim.setColumns(10);
		txtTenDichVu_Tim.setBackground(new Color(164, 194, 163));
		txtTenDichVu_Tim.setBounds(900, 41, 350, 40);
		panel.add(txtTenDichVu_Tim);
		
		btn_Tim = new JButton("Tìm");
		btn_Tim.setBackground(new Color(234, 232, 214));
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Tim.setBounds(1367, 45, 175, 35);
		panel.add(btn_Tim);
		// CHỈNH CỘT 2 VÀ 3 Của bảng tableHD to ra hơn
		tableHD.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableHD.getColumnModel().getColumn(2).setPreferredWidth(200);
		
		
		
		// khi nhấn vào btn tìm thì sẽ in ra hết dữ liệu của dịch vụ
		btn_Tim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// tim theo ma va ten
				modelHD.setRowCount(0);
				DAO_DichVu dv = new DAO_DichVu();
				ArrayList<DichVu> dsDV = dv.getAllDichVu();
				for (DichVu dv1 : dsDV) {
					if (dv1.getMaDichVu().contains(txtTimMa.getText())
							&& dv1.getTenDichVu().contains(txtTenDichVu_Tim.getText())) {
						modelHD.addRow(new Object[] { dv1.getMaDichVu(), dv1.getTenDichVu(), dv1.getNhaCCDV(),
								dv1.getThueVAT() + "%", dv1.getSoLuong(), dv1.getDonGia(), dv1.getTrangThai() });
					}
				}
				
				
			}
		});
        
		// khi nhấn vào 1 hàng của bảng thì sẽ hiện thông tin của hàng đó lên các textfield
		tableHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableHD.getSelectedRow();
				txtMaDV.setText(modelHD.getValueAt(i, 0).toString());
				txtTenDV.setText(modelHD.getValueAt(i, 1).toString());
				txtNhaCCDV.setText(modelHD.getValueAt(i, 2).toString());
				// thuế vặt không cần dấu %
				
			    txtThueVat.setText(modelHD.getValueAt(i, 3).toString().replace("%", ""));
				txtSoLuong.setText(modelHD.getValueAt(i, 4).toString());
				txtGiaVe.setText(modelHD.getValueAt(i, 5).toString());
				cbTrangThai.setSelectedItem(modelHD.getValueAt(i, 6).toString());
			}
		});
		btbXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaDV.setText("");
				txtTenDV.setText("");
				txtNhaCCDV.setText("");
				txtThueVat.setText("");
				txtSoLuong.setText("");
				txtGiaVe.setText("");
			}
		});
		
		// chọn hàng trong bảng và nhấn vào btnSua thì sẽ sửa thông tin của dịch vụ đó và thông báo đã sửa thành công và cập nhật lại bảng
		
		btn_Sua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DAO_DichVu dv = new DAO_DichVu();
				DichVu dv1 = new DichVu(txtMaDV.getText(), txtTenDV.getText(),
						Integer.parseInt(txtThueVat.getText().replace("%", "")), txtNhaCCDV.getText(),
						Double.parseDouble(txtGiaVe.getText()), Integer.parseInt(txtSoLuong.getText()),
						cbTrangThai.getSelectedItem().toString());
				dv.updateDichVu(dv1);
				modelHD.setRowCount(0);
				dsDV = dv.getAllDichVu();
				for (DichVu dv2 : dsDV) {
					modelHD.addRow(new Object[] { dv2.getMaDichVu(), dv2.getTenDichVu(), dv2.getNhaCCDV(),
							dv2.getThueVAT() + "%", dv2.getSoLuong(), dv2.getDonGia(), dv2.getTrangThai() });
				}
				JOptionPane.showMessageDialog(null, "Sửa thành công");
			}
		});
	// KIỂM TRA trùng thì thông báo đã trùng nếu thêm thành công thì thông báo thêm thành công
	btnThem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (vailData()) {
				DAO_DichVu dv = new DAO_DichVu();
				DichVu dv1 = new DichVu(txtMaDV.getText(), txtTenDV.getText(),
						Integer.parseInt(txtThueVat.getText().replace("%", "")), txtNhaCCDV.getText(),
						Double.parseDouble(txtGiaVe.getText()), Integer.parseInt(txtSoLuong.getText()),
						cbTrangThai.getSelectedItem().toString());
				if (dv.themDichVu(dv1)) {
					modelHD.setRowCount(0);
					dsDV = dv.getAllDichVu();
					for (DichVu dv2 : dsDV) {
						modelHD.addRow(new Object[] { dv2.getMaDichVu(), dv2.getTenDichVu(), dv2.getNhaCCDV(),
								dv2.getThueVAT() + "%", dv2.getSoLuong(), dv2.getDonGia(), dv2.getTrangThai() });
					}
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Mã dịch vụ đã tồn tại");
				}
			}
		}
	});

		
		
		
		
	 
		
		
		

//		
	}
	// TẠO 1 hàm để kiểm tra dữ liệu thêm vào có đúng không
	
	// kiểm tra mã dịch vụ có trùng không và phải đúng định dạng DVxxx
	// kiểm tra thuế vặt có đúng không và phải là số lớn hơn 0 và nhỏ hơn 15
	// kiểm tra số lượng có đúng không và phải là số lớn hơn 0 và nhỏ hơn 200
	// kiểm tra giá vé có đúng không và phải là số lớn hơn 0 và nhỏ hơn 1000000
	// kiểm tra trạng thái có đúng không và phải là 1 trong 2 giá trị "Ngừng kinh doanh" hoặc "Đang kinh doanh"
	// kiểm tra tên dịch vụ và nhà cung cấp dịch vụ có đúng không và phải là chuỗi kí tự và không được để trống và không được chứa kí tự đặc biệt 
	// khi nhấn vào btnThem thì sẽ thêm dịch vụ vào bảng và thông báo đã thêm thành công và cập nhật lại bảng
    // sao không thực hiện giống các nội dung trên
	
	public boolean vailData() {
		String maDV = txtMaDV.getText();
		String tenDV = txtTenDV.getText();
		String nhaCCDV = txtNhaCCDV.getText();
		String thueVat = txtThueVat.getText();
		String soLuong = txtSoLuong.getText();
		String giaVe = txtGiaVe.getText();
		String trangThai = cbTrangThai.getSelectedItem().toString();
		if (!maDV.matches("DV[0-9]{3}")) {
			JOptionPane.showMessageDialog(null, "Mã dịch vụ không đúng định dạng DVxxx vd: DV001");
			return false;
		}
		// tên dịch vụ có thể chứa số
		if (!tenDV.matches("[A-Z][a-zA-Z0-9]+")) {
			JOptionPane.showMessageDialog(null, "Tên dịch vụ không đúng định dạng");
			return false;
		}
	
		if (!nhaCCDV.matches("[A-Z][a-zA-Z0-9]+")) {
			JOptionPane.showMessageDialog(null, "Nhà cung cấp dịch vụ không đúng định dạng");
			return false;
		}
		if (!thueVat.matches("[0-9]+") || Integer.parseInt(thueVat) < 5 || Integer.parseInt(thueVat) > 15) {
			JOptionPane.showMessageDialog(null, "Thuế vặt không đúng định dạng phải lớn hơn 5 và nhỏ hơn 15");
			return false;
		}
		if (!soLuong.matches("[0-9]+") || Integer.parseInt(soLuong) < 10 || Integer.parseInt(soLuong) > 200) {
			JOptionPane.showMessageDialog(null, "Số lượng không đúng định dạng phải lớn hơn 10 và nhỏ hơn 200");
			return false;
		}
		if (!giaVe.matches("[0-9]+") || Double.parseDouble(giaVe) < 100000 || Double.parseDouble(giaVe) > 1000000) {
			JOptionPane.showMessageDialog(null, "Giá vé không đúng định dạng phải lớn hơn 100000 và nhỏ hơn 1000000");
			return false;
		}
		if (!trangThai.equals("Ngừng kinh doanh") && !trangThai.equals("Đang kinh doanh")) {
			JOptionPane.showMessageDialog(null, "Trạng thái không đúng định dạng");
			return false;
		}
		return true;
		
	}
}
