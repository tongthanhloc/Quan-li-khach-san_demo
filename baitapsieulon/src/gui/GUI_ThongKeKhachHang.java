package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;



public class GUI_ThongKeKhachHang extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
	private JButton btnTK;
    private JButton btnTKDMK;
    private JButton btnTKDX;
    private JButton btnTrangChu;
    private JButton btnQLP;
    private JButton btnQLHD;
    private JButton btnQLKH;
    private JButton btnQLNV;
    private JButton btnQLKM;
    private JButton btnQLDV;
    private JButton btnHT;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private Panel panelTK;
    private JLabel btnTKHTNV;
    private JLabel btnTKTNV;
    private JLabel btnTKca;
    private JLabel btnmaNV;
    private JTable table;
	private DefaultTableModel modelHD;
	private DefaultTableModel modelDT;
	private JTextField txtSLKH;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtThanThiet;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_12;
	private JTextField txtNam;
	private JTextField txtNu;
	private JPanel panel_3;
	private JTextField txtTL;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JTextField txtHSL;
	private DefaultTableModel model;
	private JTable tableNV;
	private JTextField txtTBT;
	private JTextField txtTCN;
	private JTextField txtTTN;
	private ArrayList<NhanVien> dsNV;
	private ArrayList<LocalDate> dsT;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	GUI_ThongKeKhachHang frame = new GUI_ThongKeKhachHang();
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to cửa sổ JFrame
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
	public GUI_ThongKeKhachHang() {

		try {
			ConnectDB.getInstance().connect();
			} catch (Exception e) {
				e.printStackTrace();
		}
		dsNV = new  ArrayList<NhanVien>();
		dsNV = new NhanVien_DAO().getalltbNhanVien();
		dsT = new ArrayList<LocalDate>();
		for (NhanVien nv : dsNV) {
			dsT.add(nv.getNgaySinh());
		}
		System.out.println(dsNV.size());
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setLocationRelativeTo(null);
		Frame = new JPanel();
		Frame.setBackground(new Color(255, 255, 255));
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		


		
		panelTK = new Panel();
		panelTK.setBounds(1647, 53, 247, 218);
		Frame.add(panelTK);
		panelTK.setLayout(null);
		panelTK.setVisible(false);
		
       
		
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
		
		btnTKca = new JLabel("Ca làm");
		btnTKca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTKca.setHorizontalAlignment(SwingConstants.CENTER);
		btnTKca.setBounds(0, 69, 247, 20);
		panelTK.add(btnTKca);
		
		btnmaNV = new JLabel("Mã nhân viên");
		btnmaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnmaNV.setHorizontalAlignment(SwingConstants.CENTER);
		btnmaNV.setBounds(0, 0, 247, 29);
		panelTK.add(btnmaNV);
		
		Panel panel_top = new Panel();
		panel_top.setBackground(new Color(192, 192, 192));
		panel_top.setBounds(0, 0, 1904, 150);
		Frame.add(panel_top);
		panel_top.setLayout(null);
		
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
		
		JButton btnTim_1 = new JButton("Thống Kê nhân viên");
		btnTim_1.setBackground(new Color(164, 194, 163));
		btnTim_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim_1.setBounds(298, 24, 334, 99);
		panel_top.add(btnTim_1);
		btnTim_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		

		
		Panel panel_menu = new Panel();
		panel_menu.setLayout(null);
		panel_menu.setBackground(Color.LIGHT_GRAY);
		panel_menu.setBounds(0, 150, 250, 891);
		Frame.add(panel_menu);
		
		
		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTrangChu.setBounds(0, 0, 250, 70);
		panel_menu.add(btnTrangChu);
		
		
		btnQLP = new JButton("Quản lí phòng");
		btnQLP.setBackground(new Color(255, 255, 255));
		btnQLP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLP.setBounds(0, 68, 250, 68);
		panel_menu.add(btnQLP);
		
		
		btnQLHD = new JButton("Quản lí hóa đơn");
		btnQLHD.setForeground(new Color(244, 244, 244));
		btnQLHD.setBackground(new Color(41, 139, 116));
		btnQLHD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLHD.setBounds(0, 133, 250, 68);
		panel_menu.add(btnQLHD);
		
		
		btnQLKH = new JButton("Quản lí Khách hàng");
		btnQLKH.setBackground(new Color(255, 255, 255));
		btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnQLKH.setBounds(0, 198, 250, 68);
		panel_menu.add(btnQLKH);
		
		
		btnQLNV = new JButton("Quản lí nhân viên");
		btnQLNV.setBackground(new Color(255, 255, 255));
		btnQLNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLNV.setBounds(0, 261, 250, 68);
		panel_menu.add(btnQLNV);
		
		btnQLKM = new JButton("Quản lí khuyến mãi");
		btnQLKM.setBackground(new Color(255, 255, 255));
		btnQLKM.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLKM.setBounds(0, 323, 250, 68);
		panel_menu.add(btnQLKM);
		
		btnQLDV = new JButton("Quản lí dịch vụ");
		btnQLDV.setBackground(new Color(255, 255, 255));
		btnQLDV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLDV.setBounds(0, 388, 250, 68);
		panel_menu.add(btnQLDV);
		
		btnHT = new JButton("Hỗ trợ");
		btnHT.setBackground(new Color(255, 255, 255));
		btnHT.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnHT.setBounds(0, 453, 250, 68);
		panel_menu.add(btnHT);
		
		lblNewLabel_2 = new JLabel("__________________________________________");
		lblNewLabel_2.setForeground(new Color(41, 111, 106));
		lblNewLabel_2.setBounds(0, 629, 260, 19);
		panel_menu.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Thông tin khách sạn");
		lblNewLabel_3.setForeground(new Color(41, 111, 106));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 654, 250, 30);
		panel_menu.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Hotline: 0387272513");
		lblNewLabel_4.setForeground(new Color(41, 111, 106));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(0, 703, 250, 30);
		panel_menu.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Địa chỉ: 416/39 Dương Quảng Hàm");
		lblNewLabel_5.setForeground(new Color(41, 111, 106));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 735, 250, 30);
		panel_menu.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Phường 5, Gò Vấp, TP.HCM");
		lblNewLabel_6.setForeground(new Color(41, 111, 106));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(0, 754, 250, 30);
		panel_menu.add(lblNewLabel_6);
		
		JPanel panel_Center_Left = new JPanel();
		panel_Center_Left.setBounds(257, 156, 685, 885);
		panel_Center_Left.setLayout(null);
		
		JPanel panel_Center_Right = new JPanel();
		panel_Center_Right.setBounds(942, 156, 962, 885);
		panel_Center_Right.setLayout(null);
		
		String[] cols = new String[] {"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã Khuyến mãi ", "Ngày lập hóa đơn", "Tổng tiền thanh toán" ,"Tiền khách đưa" , "Tiền thối", "Trang thái"};
		modelHD = new DefaultTableModel(new Object[]{"Thông tin", "Giá trị"}, 0);
		panel_Center_Left.setLayout(null);

		for (String col : cols) {
		    modelHD.addRow(new Object[]{col, ""});
		}

		// Thêm giá trị vào cột thứ hai (cột "Giá trị")
		for (int i = 0; i < modelHD.getRowCount(); i++) {
		    modelHD.setValueAt("Giá trị " + i, i, 1);
		}
		Font headerFont = new Font("Tahoma", Font.PLAIN, 25);


		// Đặt font cho nội dung của bảng và kích thước lớn hơn
		Font rowFont = new Font("Tahoma", Font.PLAIN, 25);

		
		Frame.add(panel_Center_Left);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thống kê số lượng khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_2.setBounds(12, 12, 663, 378);
		panel_Center_Left.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Tổng số Khách Hàng");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_7.setBounds(24, 35, 134, 16);
		panel_2.add(lblNewLabel_7);
		
		txtSLKH = new JTextField();
		txtSLKH.setBounds(240, 32, 114, 25);
		panel_2.add(txtSLKH);
		txtSLKH.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Số Khách Hàng Thân Thiết");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_8.setBounds(24, 62, 185, 16);
		panel_2.add(lblNewLabel_8);
		
		txtThanThiet = new JTextField();
		txtThanThiet.setBounds(240, 59, 114, 25);
		panel_2.add(txtThanThiet);
		txtThanThiet.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Khách hàng nam");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(399, 35, 108, 16);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_12 = new JLabel("Khách hàng nữ");
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_12.setBounds(399, 63, 108, 16);
		panel_2.add(lblNewLabel_12);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 96, 294, 124);
		panel_2.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Khách Hàng thân thiết");
		lblNewLabel_9.setBounds(28, 9, 119, 16);
		panel.add(lblNewLabel_9);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBounds(0, 2, 10, 122);
		panel.add(panel_2_1_1);
		panel_2_1_1.setBackground(new Color(41, 139, 116));
		
		lblNewLabel_10 = new JLabel("40");
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_10.setBounds(36, 37, 30, 58);
		panel.add(lblNewLabel_10);
				
				JLabel lblNewLabel_11 = new JLabel("0.0%");
				lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNewLabel_11.setForeground(new Color(0, 0, 0));
				lblNewLabel_11.setBounds(78, 63, 55, 16);
				panel.add(lblNewLabel_11);
				
				txtNam = new JTextField();
				txtNam.setBounds(532, 32, 101, 25);
				panel_2.add(txtNam);
				txtNam.setColumns(10);
				
				txtNu = new JTextField();
				txtNu.setColumns(10);
				txtNu.setBounds(532, 60, 101, 25);
				panel_2.add(txtNu);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(335, 96, 298, 124);
				panel_2.add(panel_1);
				panel_1.setLayout(null);
				panel_1.setBackground(Color.WHITE);
				
				JLabel lblNewLabel_9_1 = new JLabel("Tỉ lệ nam/nữ");
				lblNewLabel_9_1.setBounds(28, 9, 119, 16);
				panel_1.add(lblNewLabel_9_1);
				
				JPanel panel_2_1_1_1 = new JPanel();
				panel_2_1_1_1.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1.setBounds(0, 2, 10, 122);
				panel_1.add(panel_2_1_1_1);
				
				JLabel lblNewLabel_10_1 = new JLabel("40/50");
				lblNewLabel_10_1.setFont(new Font("Dialog", Font.BOLD, 25));
				lblNewLabel_10_1.setBounds(36, 37, 78, 58);
				panel_1.add(lblNewLabel_10_1);
				
				JLabel lblNewLabel_11_1 = new JLabel("0.0%");
				lblNewLabel_11_1.setForeground(new Color(0, 0, 0));
				lblNewLabel_11_1.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNewLabel_11_1.setBounds(116, 61, 55, 16);
				panel_1.add(lblNewLabel_11_1);
				
				JLabel lblNewLabel_7_1 = new JLabel("Điểm Trung bình");
				lblNewLabel_7_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1.setBounds(24, 232, 171, 16);
				panel_2.add(lblNewLabel_7_1);
				
				JPanel panel_1_2 = new JPanel();
				panel_1_2.setLayout(null);
				panel_1_2.setBackground(Color.WHITE);
				panel_1_2.setBounds(335, 232, 298, 124);
				panel_2.add(panel_1_2);
				
				JLabel lblNewLabel_9_1_2 = new JLabel("");
				lblNewLabel_9_1_2.setBounds(28, 9, 119, 16);
				panel_1_2.add(lblNewLabel_9_1_2);
				
				JPanel panel_2_1_1_1_2 = new JPanel();
				panel_2_1_1_1_2.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1_2.setBounds(0, 2, 10, 122);
				panel_1_2.add(panel_2_1_1_1_2);
				
				JLabel lblNewLabel_10_1_2 = new JLabel("40");
				lblNewLabel_10_1_2.setFont(new Font("Dialog", Font.BOLD, 25));
				lblNewLabel_10_1_2.setBounds(36, 37, 30, 58);
				panel_1_2.add(lblNewLabel_10_1_2);
				

				
				JLabel lblNewLabel_11_1_2 = new JLabel("0.0%");
				lblNewLabel_11_1_2.setForeground(Color.BLACK);
				lblNewLabel_11_1_2.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNewLabel_11_1_2.setBounds(78, 63, 55, 16);
				panel_1_2.add(lblNewLabel_11_1_2);
				
				JLabel lblNewLabel_9_1_3 = new JLabel("Độ tuổi");
				lblNewLabel_9_1_3.setBounds(28, 9, 85, 16);
				panel_1_2.add(lblNewLabel_9_1_3);
				
				txtTBT = new JTextField();
				txtTBT.setColumns(10);
				txtTBT.setBounds(192, 230, 114, 25);
				txtTBT.setEditable(false);
				Integer avg = findAverageAge(dsT);
				txtTBT.setText(avg.toString());
				panel_2.add(txtTBT);
				
				JLabel lblNewLabel_7_1_1_1 = new JLabel("Điểm cao nhất");
				lblNewLabel_7_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1_1_1.setBounds(24, 265, 171, 16);
				panel_2.add(lblNewLabel_7_1_1_1);
				
				txtTCN = new JTextField();
				txtTCN.setColumns(10);
				txtTCN.setBounds(192, 259, 114, 25);
				txtTCN.setEditable(false);
				// Lấy danh sách tuổi của nhân viên

				Integer maxT = findMaxAge(dsT);
				txtTCN.setText(maxT.toString());
				panel_2.add(txtTCN);
				
				JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Điểm thấp nhất");
				lblNewLabel_7_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1_1_1_1.setBounds(24, 301, 171, 16);
				panel_2.add(lblNewLabel_7_1_1_1_1);
				
				txtTTN = new JTextField();
				txtTTN.setColumns(10);
				txtTTN.setBounds(192, 293, 114, 25);
				txtTTN.setEditable(false);
				Integer minT = findMinAge(dsT);
				txtTTN.setText(minT.toString());
				panel_2.add(txtTTN);
				
				textField = new JTextField();
				textField.setText("100");
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBounds(192, 328, 114, 25);
				panel_2.add(textField);
				
				JLabel lblNewLabel_7_1_1_1_1_1 = new JLabel("Độ tuổi trung bình");
				lblNewLabel_7_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1_1_1_1_1.setBounds(24, 336, 171, 16);
				panel_2.add(lblNewLabel_7_1_1_1_1_1);
				
				panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(new CompoundBorder(null, new LineBorder(new Color(99, 130, 191))), "Th\u1ED1ng k\u00EA L\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_3.setBounds(12, 402, 663, 471);
				panel_Center_Left.add(panel_3);
				panel_3.setLayout(null);
				
				txtTL = new JTextField();
				txtTL.setBounds(190, 29, 114, 25);
				panel_3.add(txtTL);
				txtTL.setColumns(10);
				
				lblNewLabel_13 = new JLabel("Số Khách hàng Vàng");
				lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_13.setBounds(10, 31, 151, 16);
				panel_3.add(lblNewLabel_13);
				
				lblNewLabel_14 = new JLabel("Số Khách hàng Bạc");
				lblNewLabel_14.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_14.setBounds(348, 32, 133, 16);
				panel_3.add(lblNewLabel_14);
				
				txtHSL = new JTextField();
				txtHSL.setColumns(10);
				txtHSL.setBounds(516, 29, 114, 25);
				panel_3.add(txtHSL);
				
				JPanel panel_4 = new JPanel();
				panel_4.setLayout(null);
				panel_4.setBackground(Color.WHITE);
				panel_4.setBounds(10, 66, 294, 124);
				panel_3.add(panel_4);
				
				JLabel lblNewLabel_9_2 = new JLabel("Hệ số khách hàng Vàng");
				lblNewLabel_9_2.setBounds(28, 9, 147, 16);
				panel_4.add(lblNewLabel_9_2);
				
				JPanel panel_2_1_1_2 = new JPanel();
				panel_2_1_1_2.setBackground(new Color(222, 220, 203));
				panel_2_1_1_2.setBounds(0, 2, 10, 122);
				panel_4.add(panel_2_1_1_2);
				
				JLabel lblNewLabel_10_2 = new JLabel("40/100");
				lblNewLabel_10_2.setFont(new Font("Dialog", Font.BOLD, 25));
				lblNewLabel_10_2.setBounds(36, 37, 84, 58);
				panel_4.add(lblNewLabel_10_2);
				
				JLabel lblNewLabel_11_2 = new JLabel("0.0%");
				lblNewLabel_11_2.setForeground(Color.BLACK);
				lblNewLabel_11_2.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNewLabel_11_2.setBounds(199, 61, 55, 16);
				panel_4.add(lblNewLabel_11_2);
				
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setLayout(null);
				panel_1_1.setBackground(Color.WHITE);
				panel_1_1.setBounds(332, 66, 298, 124);
				panel_3.add(panel_1_1);
				
				JLabel lblNewLabel_9_1_1 = new JLabel("Hệ số Khách hàng Bạc");
				lblNewLabel_9_1_1.setBounds(28, 9, 135, 16);
				panel_1_1.add(lblNewLabel_9_1_1);
				
				JPanel panel_2_1_1_1_1 = new JPanel();
				panel_2_1_1_1_1.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1_1.setBounds(0, 2, 10, 122);
				panel_1_1.add(panel_2_1_1_1_1);
				
				JLabel lblNewLabel_10_1_1 = new JLabel("5/10");
				lblNewLabel_10_1_1.setFont(new Font("Dialog", Font.BOLD, 25));
				lblNewLabel_10_1_1.setBounds(36, 37, 62, 58);
				panel_1_1.add(lblNewLabel_10_1_1);
				
				JLabel lblNewLabel_11_1_1 = new JLabel("0.0%");
				lblNewLabel_11_1_1.setForeground(Color.BLACK);
				lblNewLabel_11_1_1.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNewLabel_11_1_1.setBounds(125, 61, 55, 16);
				panel_1_1.add(lblNewLabel_11_1_1);
				
				JLabel lblNewLabel_15 = new JLabel("Top 5 Khách Hàng tiềm năng");
				lblNewLabel_15.setBounds(30, 202, 200, 16);
				panel_3.add(lblNewLabel_15);
				
				String[] colNV = new String[] {"Mã Khách Hàng", "Họ tên","Điểm", "Hạng"};
				
		        model = new DefaultTableModel(colNV, 0);
		        
				panel_3.setLayout(null);
				
			
			
				tableNV = new JTable(model);
				JScrollPane paneNV = new JScrollPane(tableNV);
				paneNV.setBounds(10, 230, 623, 210);
				panel_3.add(paneNV);
		Frame.add(panel_Center_Right);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setForeground(new Color(255, 255, 255));
		panel_5.setBounds(26, 22, 644, 235);
		panel_Center_Right.add(panel_5);
		Frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Ẩn btnXTT và btnDX khi click ra ngoài
                panelTK.setVisible(false);
                // Hiển thị btnTK
                btnTK.setVisible(true);
            }
        });
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                boolean isVisible = panelTK.isVisible();
                if (clickedButton == btnTK && isVisible == false) {
                    // Xử lý khi nhấn vào nút btnTK
                	panelTK.setVisible(true);
                } else if (clickedButton == btnTK && isVisible == true) {
                    // Xử lý khi nhấn vào nút btnXTT
                	panelTK.setVisible(false);
                }
                else if (clickedButton == btnTKDMK) {
                    // Xử lý khi nhấn vào nút btnXTT
                } else if (clickedButton == btnTKDX) {
                    // Xử lý khi nhấn vào nút btnDX
                	int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                	setVisible(false); // Đóng frame hiện tại
                    new dangnhap().setVisible(true);
                }} else if (clickedButton == btnTrangChu) {
                    // Xử lý khi nhấn vào nút btnTrangChu
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_TrangChu().setVisible(true);
                } else if (clickedButton == btnQLP) {
                    // Xử lý khi nhấn vào nút btnQLP
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_QuanLiDatPhong().setVisible(true);
                } else if (clickedButton == btnQLHD) {
                    // Xử lý khi nhấn vào nút btnQLHD
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_QuanLiHoaDon().setVisible(true);
                } else if (clickedButton == btnQLKH) {
                    // Xử lý khi nhấn vào nút btnQLKH
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_QuanLiKhachHang().setVisible(true);
                } else if (clickedButton == btnQLNV) {
                    // Xử lý khi nhấn vào nút btnQLNV
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_QuanLiNhanVien().setVisible(true);
                } else if (clickedButton == btnQLKM) {
                    // Xử lý khi nhấn vào nút btnQLKM
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_QuanLiKhuyenMai().setVisible(true);
                } else if (clickedButton == btnQLDV) {
                    // Xử lý khi nhấn vào nút btnQLDV
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_QuanLiDichVu().setVisible(true);
                } else if (clickedButton == btnHT) {
                    // Xử lý khi nhấn vào nút btnHT
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                }}};
                    btnTK.addActionListener(actionListener);
                    btnTKDMK.addActionListener(actionListener);
                    btnTKDX.addActionListener(actionListener);
                    btnTrangChu.addActionListener(actionListener);
                    btnQLP.addActionListener(actionListener);
                    btnQLHD.addActionListener(actionListener);
                    btnQLKH.addActionListener(actionListener);
                    btnQLNV.addActionListener(actionListener);
                    btnQLKM.addActionListener(actionListener);
                    btnQLDV.addActionListener(actionListener);
                    btnHT.addActionListener(actionListener);
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
	public void populateComboBox(JComboBox<String> yearComboBox) {
		int startYear = 2012;
	    int currentYear = java.time.Year.now().getValue();

        // Thêm các năm từ startYear đến endYear vào combobox
        for (int i = startYear; i <= currentYear; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
    }
	public  int findMaxAge(ArrayList<LocalDate> birthdays) {
        int maxAge = 0;
        LocalDate currentDate = LocalDate.now();

        for (LocalDate birthday : birthdays) {
            int age = currentDate.getYear() - birthday.getYear();
            // Kiểm tra xem tuổi hiện tại có lớn hơn tuổi lớn nhất hiện tại không
            if (age > maxAge) {
                maxAge = age; // Cập nhật tuổi lớn nhất
            }
        }

        return maxAge;
    }

	public int findMinAge(ArrayList<LocalDate> birthdays) {
		int minAge = 100;
		LocalDate currentDate = LocalDate.now();

		for (LocalDate birthday : birthdays) {
			int age = currentDate.getYear() - birthday.getYear();
			// Kiểm tra xem tuổi hiện tại có nhỏ hơn tuổi nhỏ nhất hiện tại không
			if (age < minAge) {
				minAge = age; // Cập nhật tuổi nhỏ nhất
			}
		}

		return minAge;
	}

	public int findAverageAge(ArrayList<LocalDate> birthdays) {
		int sum = 0;
		LocalDate currentDate = LocalDate.now();

		for (LocalDate birthday : birthdays) {
			int age = currentDate.getYear() - birthday.getYear();
			sum += age;
		}

		return sum / birthdays.size();
	}

	//Hàm update thông tin nhân viên vào model
	
	public void updateNV(ArrayList<NhanVien> dsNV) {
		model.setRowCount(0);
		for (NhanVien nv : dsNV) {
			model.addRow(new Object[] { 
					nv.getMaNV(), 
					nv.getHoTenNV(), 
					nv.getHeSoLuong(), 
					nv.getTongLuong() });
		}
	}
	
}
