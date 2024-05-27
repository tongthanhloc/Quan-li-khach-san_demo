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
import java.util.Vector;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.KhachHang;
import entity.NhanVien;


import javax.swing.JComboBox;

public class GUI_QuanLiNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Object String = null;
	private JPanel contentPane;
	private JPanel Frame;
	private JPanel panel_Center_Top;
	private JLabel lblMaNhanVien;
	private JLabel lblCCCD;
	private JTextField txtMaNhanVien;
	private JTextField txtCCCD;
	private JLabel lblTenNV;
	private JLabel lblSDT;
	private JLabel lblDC;
	private JTextField txtTenNV;
	private JTextField txtSDT;
	private JTextField txtDC;
	private JButton btbXoaTrang;
	private DefaultTableModel modelHD;
	private JTable tableNV;
	private JTextField txtTuoi;
	private JComboBox comboBox;
	private NhanVien_DAO nv_dao;
	private Object rowData;
	static DefaultTableModel model;
	private LocalDate decimalFormat;
	private JTable tableHD;
	private JButton btnXem;
	private java.lang.String maNVChon;
	static ArrayList<NhanVien> ListNV;
	static ArrayList<NhanVien> dsnv;
	static GUI_ChiTietNhanVien chiTietNhanVien;
	static GUI_hemNhanVien themNhanVien;
	
	
	
	
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
					GUI_QuanLiNhanVien frame = new GUI_QuanLiNhanVien(nv);
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
	
	public GUI_QuanLiNhanVien(NhanVien nv) {
		
		try {
			ConnectDB.getInstance().connect();
			} catch (Exception e) {
				e.printStackTrace();
		}
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getNhanVienTiepTan();
		setIconImage(new ImageIcon(GUI_DangNhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		Frame = new JPanel();
		Frame.setBackground(new Color(255, 255, 255));
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
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
		btnQLKH.setBackground(new Color(255, 255, 255));
		btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnQLKH.setBounds(0, 210, 250, 70);
		panel_menu.add(btnQLKH);
		
		
		
		btnQLNV = new JButton("Quản lí nhân viên");
		btnQLNV.setBackground(new Color(41, 139, 116));
		btnQLNV.setForeground(new Color(255, 255, 255));
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
		
		lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNhanVien.setBounds(140, 25, 126, 35);
		panel_Center_Top.add(lblMaNhanVien);
		
		lblCCCD = new JLabel("Căn cước công dân");
		lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCCCD.setBounds(140, 75, 186, 35);
		panel_Center_Top.add(lblCCCD);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBackground(new Color(164, 194, 163));
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMaNhanVien);
		
		txtCCCD = new JTextField();
		txtCCCD.setBackground(new Color(164, 194, 163));
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(350, 75, 350, 40);
		panel_Center_Top.add(txtCCCD);
		
		lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(900, 25, 210, 35);
		panel_Center_Top.add(lblTenNV);
		
		lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBounds(900, 75, 175, 35);
		panel_Center_Top.add(lblSDT);
		
		lblDC = new JLabel("Địa chỉ");
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDC.setBounds(900, 125, 198, 35);
		panel_Center_Top.add(lblDC);
		
		txtTenNV = new JTextField();
		txtTenNV.setBackground(new Color(164, 194, 163));
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(1100, 25, 350, 40);
		panel_Center_Top.add(txtTenNV);
		
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
		btnTim.setBounds(1080, 176, 175, 35);
		panel_Center_Top.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btbXoaTrang = new JButton("Xóa trắng");
		btbXoaTrang.setBackground(new Color(234, 232, 214));
		btbXoaTrang.setBounds(1458, 176, 175, 35);
		panel_Center_Top.add(btbXoaTrang);
		btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTuoi = new JLabel("Tuổi");
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTuoi.setBounds(140, 125, 76, 35);
		panel_Center_Top.add(lblTuoi);
		
		txtTuoi = new JTextField();
		txtTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTuoi.setColumns(10);
		txtTuoi.setBackground(new Color(164, 194, 163));
		txtTuoi.setBounds(225, 125, 100, 40);
		panel_Center_Top.add(txtTuoi);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGioiTinh.setBounds(375, 125, 186, 35);
		panel_Center_Top.add(lblGioiTinh);
		
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setEditable(true);
		
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		
		
		comboBox.setBounds(513, 125, 186, 40);
		panel_Center_Top.add(comboBox);
		
		btnXem = new JButton("Xem Chi Tiết");
		btnXem.setBackground(new Color(234, 232, 214));
		btnXem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXem.setBounds(1270, 176, 175, 35);
		panel_Center_Top.add(btnXem);
		
		JButton btnThem = new JButton("Thêm Nhân Viên");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBackground(new Color(234, 232, 214));
		btnThem.setBounds(852, 176, 210, 35);
		panel_Center_Top.add(btnThem);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(251, 369, 1648, 576);

		
		String[] cols = new String[] {"Mã nhân viên", "Họ tên", "Giới tính" , "CCCD", "Vị trí", "Số điện thoại", "Ngày sinh", "Trạng thái","Tổng lương"};
		
        model = new DefaultTableModel(cols, 0);
        
		panel_Center_Bot.setLayout(null);
		
	
	
		tableHD = new JTable(model);
		JScrollPane paneNV = new JScrollPane(tableHD);
		paneNV.setBounds(30, 30, 1590, 530);
		panel_Center_Bot.add(paneNV);
		tableHD.setRowHeight(30);
		tableHD.setBackground(new Color(232,234,214));
	
		JTableHeader headers = tableHD.getTableHeader();
		Font headerFont = new Font("Tahoma", Font.PLAIN, 25);
		headers.setFont(headerFont);
		headers.setBackground(new Color(164, 194, 163));
	
		tableHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tableHD.setDefaultRenderer(Object.class, centerRenderer);
        int rowHeight = 30; // Chiều cao mong muốn cho mỗi hàng
        tableHD.setRowHeight(rowHeight);
		Frame.add(panel_Center_Bot);
	
		
		// Lắng nghe sự kiện khi một dòng được chọn trong bảng
		tableHD.addMouseListener(new MouseAdapter() {
		  
	

		    public void mouseClicked(MouseEvent e) {
		        int row = tableHD.getSelectedRow();
		        maNVChon = (String) tableHD.getValueAt(row, 0);
		       
		    }
		});

		
        
		
		
		Frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Ẩn btnXTT và btnDX khi click ra ngoài
                panelTK.setVisible(false);
                // Hiển thị btnTK
                btnTK.setVisible(true);
            }

//			public void mouseClicked(MouseC e) {
//				panelTK.setVisible(false);
//			}  
        });
		ActionListener actionListener = new ActionListener() {
            

			public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                
                boolean isVisible = panelTK.isVisible();
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
				}if(clickedButton == btnQLDV) {
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
				}else if(clickedButton == btnTim) {
                    // Xử lý khi nhấn vào nút btnTim
                		NhanVien nv = new NhanVien();
                		nv.setMaNV(txtMaNhanVien.getText());
                	    nv.setHoTenNV(txtTenNV.getText());
                	    nv.setCanCuoc(txtCCCD.getText());
              	        nv.setSoDT(txtSDT.getText());
               	        nv.setViTri(txtDC.getText());
               	        if (comboBox.getSelectedItem().equals("Nam")) {
               	        	nv.setGioiTinh(true);
               	        } else {
               	        	nv.setGioiTinh(false);
               	        }
               	        if (txtTuoi.getText().isEmpty()) {
               	            nv.setNgaySinh(null);
               	        } else {
               	            try {
               	                int tuoi = Integer.parseInt(txtTuoi.getText());
               	                nv.setNgaySinh(LocalDate.now().minusYears(tuoi));
               	                JOptionPane.showMessageDialog(null, nv.getNgaySinh());
               	            } catch (NumberFormatException ex) {
               	                JOptionPane.showMessageDialog(null, "Tuổi phải là một số nguyên dương.");
               	                return; // Stop processing further
               	            }
               	        }
               	        if (comboBox.getSelectedItem().equals("Giới Tính")) {
					
               	        } else if (comboBox.getSelectedItem().equals("Nam")) {
               	        	nv.setGioiTinh(true);					
               	        } else {
						nv.setGioiTinh(false);
               	        }
               	        // Lấy danh sách trung voi nhân viên tim kiem tu co so du lieu
               	        dsnv = new ArrayList<NhanVien>();
               	        dsnv= timKiemNhanVien(nv);
               	        // Cập nhật lại model
               	        if (dsnv.isEmpty()) {
               	        	JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên nào.");
               	        	updateModel(dsnv);
               	        } else {
               	        	updateModel(dsnv);
               	        }

                } else if(clickedButton == btbXoaTrang) {
                	txtMaNhanVien.setText("");
                	txtTenNV.setText("");
                	txtCCCD.setText("");
                	txtSDT.setText("");
                	txtDC.setText("");
                	txtMaNhanVien.requestFocus();
                } else if(clickedButton == btnXem) {
                	if(maNVChon == null) {
                		JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xem");
                	} else {
                	
      		        chiTietNhanVien= new GUI_ChiTietNhanVien(maNVChon);
      		        chiTietNhanVien.setVisible(true);
      		        chiTietNhanVien.setAlwaysOnTop(true);
      		        }
                }else if(clickedButton == btnThem) {
                	NhanVien_DAO NhanVienfull= new NhanVien_DAO();
                	ArrayList<NhanVien> ListNVfull = NhanVienfull.getNhanVienTiepTan();
                	int count = ListNVfull.size()+2;
                	//tao ma nhan vien co dang NV0000001
                	String maNV = "NV";
					if (count < 10) {
						maNV += "000000" + count;
					} else if (count < 100) {
						maNV += "00000" + count;
					} else if (count < 1000) {
						maNV += "0000" + count;
					} else if (count < 10000) {
						maNV += "000" + count;
					} else if (count < 100000) {
						maNV += "00" + count;
					} else if (count < 1000000) {
						maNV += "0" + count;
					} else {
						maNV += count;
					}
                	themNhanVien = new GUI_hemNhanVien(maNV);
                	
                	themNhanVien.setVisible(true);
                	themNhanVien.setAlwaysOnTop(true);
                	}
                }};
                    btnTim.addActionListener(actionListener);
                    btbXoaTrang.addActionListener(actionListener);
                    btnXem.addActionListener(actionListener);
                    btnThem.addActionListener(actionListener);
                    
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
	
	public static void updateModel(ArrayList<NhanVien> dsNV) {
		model.setRowCount(0);
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		for (NhanVien nv : dsNV) {
		    // Tạo một mảng chứa dữ liệu của từng đối tượng NhanVien
		    Object[] rowData = new Object[] { 
		        nv.getMaNV(),
		        nv.getHoTenNV(),
		        nv.isGioiTinh() ? "Nam" : "Nữ",
		        nv.getCanCuoc(),
		        nv.getViTri(),
		        nv.getSoDT(),
		        nv.getNgaySinh(),
		        nv.getTrangThai(),
		        decimalFormat.format(nv.getTongLuong()),
		        nv.getTongLuong()
		        
		    };
		    model.addRow(rowData);
		}

		    // Thêm hàng mới vào mô hình với dữ liệu từ đối tượng NhanVien
	

	}
	public ArrayList<NhanVien> timKiemNhanVien(NhanVien nv) {
	    ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
	    int cl = 0;
	    for (NhanVien nhanVien : ListNV) {
			if (nv.getNgaySinh() != null) {
				int date = nhanVien.getNgaySinh().getYear();
		    	int tuoi = nv.getNgaySinh().getYear();
		    	cl = date - tuoi;
			}
	    
			if (nv.getMaNV() != null && !nhanVien.getMaNV().contains(nv.getMaNV())) {
				continue;
			}
			if (nv.getHoTenNV() != null && !nhanVien.getHoTenNV().contains(nv.getHoTenNV())) {
				continue;
			}
			if (nv.getCanCuoc() != null && !nhanVien.getCanCuoc().contains(nv.getCanCuoc())) {
				continue;
			}
			if (nv.getSoDT() != null && !nhanVien.getSoDT().contains(nv.getSoDT())) {
				continue;
			}
			if (nv.getViTri() != null && !nhanVien.getViTri().contains(nv.getViTri())) {
				continue;
			}
			if (nv.getNgaySinh() != null && cl != 0) {
				continue;
			}
			if ((nv.isGioiTinh() == true || nv.isGioiTinh()==false)&& nhanVien.isGioiTinh() != nv.isGioiTinh()) {
				continue;
			}
			// Add the current NhanVien object to the list
			dsnv.add(ListNV.get(ListNV.indexOf(nhanVien)));
	    }
	    return dsnv;
	}
}

