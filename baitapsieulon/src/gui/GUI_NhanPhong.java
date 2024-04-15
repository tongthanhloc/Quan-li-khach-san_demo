package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Phong_DAO;
import entity.Phong;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.border.LineBorder;



public class GUI_NhanPhong extends JFrame {

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
    private JButton btnGUI_datPhong;
    private JButton btnGUI_nhanPhong;
    private JButton btnGUI_TraPhong;
    private JButton btnGUI_doiPhong;
    private JButton btnGUI_GiahanPhong;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JLabel lblNewLabel_1_4;
    private JTextField textField_4;
    private JPanel panelP;
    private JLabel lblNewLabel_7;
    private JTextField textField_5;
    private JLabel lblNewLabel_8;
    private JTextField textField_6;
    private JLabel lblNewLabel_9;
    private JTextField textField_7;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JTextField textField_8;
    private JTextField textField_9;
    private JButton btntPhng;
    private JButton btnHy;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[] = {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	private JComboBox<String> cbPhongBan;
	private JPanel panelKH;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_NhanPhong frame = new GUI_NhanPhong();
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
	public GUI_NhanPhong() {
		
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1000);
		setLocationRelativeTo(null);
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
		ArrayList<Phong> dsP = Phong_dao.getalltbPhong();
		soPhong = new String[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			soPhong[i] = dsP.get(i).getMaPhong();
		}
		trangThai = new int[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			if (dsP.get(i).getTrangThai().equals("Đã đặt")) {
				trangThai[i] = 1;
			}
			if (dsP.get(i).getTrangThai().equals("Đã thuê")) {
				trangThai[i] = 2;
			}
			if (dsP.get(i).getTrangThai().equals("Tr?ng")) {
				trangThai[i] = 3;
			}
			if (dsP.get(i).getTrangThai().equals("Bảo trì")) {
				trangThai[i] = 4;
			}
		}
		
		
		
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
		btnTK.setBackground(new Color(41, 139, 106));
		btnTK.setBounds(1647, 11, 247, 40);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/account-icon.png")).getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH)));
		btnTK.add(lblNewLabel);
		panel_top.add(btnTK);
		
		btnGUI_datPhong = new JButton("Đặt phòng");
		btnGUI_datPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_datPhong.setForeground(Color.WHITE);
		btnGUI_datPhong.setBackground(new Color(41, 139, 116));
		btnGUI_datPhong.setBounds(290, 25, 200, 100);
		panel_top.add(btnGUI_datPhong);
		
		btnGUI_nhanPhong = new JButton("Nhận Phòng");
		btnGUI_nhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_nhanPhong.setForeground(new Color(0, 0, 0));
		btnGUI_nhanPhong.setBackground(new Color(164, 194, 163));
		btnGUI_nhanPhong.setBounds(520, 26, 200, 100);
		panel_top.add(btnGUI_nhanPhong);
		
		btnGUI_TraPhong = new JButton("Trả Phòng");
		btnGUI_TraPhong.setForeground(Color.WHITE);
		btnGUI_TraPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_TraPhong.setBackground(new Color(41, 139, 116));
		btnGUI_TraPhong.setBounds(750, 26, 200, 100);
		panel_top.add(btnGUI_TraPhong);
		
		btnGUI_doiPhong = new JButton("Đổi Phòng");
		btnGUI_doiPhong.setForeground(Color.WHITE);
		btnGUI_doiPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_doiPhong.setBackground(new Color(41, 139, 116));
		btnGUI_doiPhong.setBounds(980, 26, 200, 100);
		panel_top.add(btnGUI_doiPhong);
		
		btnGUI_GiahanPhong = new JButton("Gia hạn phòng");
		btnGUI_GiahanPhong.setForeground(Color.WHITE);
		btnGUI_GiahanPhong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGUI_GiahanPhong.setBackground(new Color(41, 139, 116));
		btnGUI_GiahanPhong.setBounds(1210, 26, 200, 100);
		panel_top.add(btnGUI_GiahanPhong);
		
		

		
		Panel panel_menu = new Panel();
		panel_menu.setLayout(null);
		panel_menu.setBackground(Color.LIGHT_GRAY);
		panel_menu.setBounds(0, 150, 250, 815);
		Frame.add(panel_menu);
		
		
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
		btnQLP.setBounds(0, 68, 250, 68);
		panel_menu.add(btnQLP);
		
		
		btnQLHD = new JButton("Quản lí hóa đơn");
		btnQLHD.setBackground(new Color(255, 255, 255));
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
		lblNewLabel_2.setBounds(0, 628, 260, 19);
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
		
		panelKH = new JPanel();
		panelKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelKH.setBounds(250, 150, 1654, 138);
		Frame.add(panelKH);
		panelKH.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Căn cước công dân:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(100, 37, 185, 26);
		panelKH.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(313, 37, 350, 26);
		panelKH.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(234, 232, 214));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(696, 37, 96, 26);
		panelKH.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(313, 86, 350, 26);
		panelKH.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(100, 86, 185, 26);
		panelKH.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Khách hàng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(990, 37, 185, 26);
		panelKH.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1185, 37, 350, 26);
		panelKH.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(990, 86, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(1067, 86, 120, 26);
		panelKH.add(textField_3);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1243, 86, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(1370, 86, 166, 26);
		panelKH.add(textField_4);
		
		panelP = new JPanel();
		panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelP.setBounds(250, 288, 1654, 260);
		Frame.add(panelP);
		panelP.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Mã Phòng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(100, 27, 185, 26);
		panelP.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(313, 27, 350, 26);
		panelP.add(textField_5);
		
		lblNewLabel_8 = new JLabel("Số người");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(100, 75, 185, 26);
		panelP.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(313, 75, 350, 26);
		panelP.add(textField_6);
		
		lblNewLabel_9 = new JLabel("Dịch vụ:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(100, 120, 185, 26);
		panelP.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(313, 120, 350, 26);
		panelP.add(textField_7);
		
		lblNewLabel_10 = new JLabel("Số người");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(992, 75, 185, 26);
		panelP.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Mã Phòng:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(992, 27, 185, 26);
		panelP.add(lblNewLabel_11);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(1205, 27, 350, 26);
		panelP.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(1205, 75, 350, 26);
		panelP.add(textField_9);
		
		btntPhng = new JButton("Nhận Phòng");
		btntPhng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btntPhng.setBackground(new Color(234, 232, 214));
		btntPhng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btntPhng.setBounds(1207, 223, 153, 26);
		panelP.add(btntPhng);
		
		btnHy = new JButton("Hủy");
		btnHy.setBackground(new Color(234, 232, 214));
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBounds(1380, 223, 153, 26);
		panelP.add(btnHy);
		
		JLabel lblNewLabel_12 = new JLabel("Phòng đơn:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(100, 166, 101, 24);
		panelP.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("Phòng đơn:");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12_1.setBounds(254, 167, 101, 24);
		panelP.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_12_2 = new JLabel("Phòng đơn:");
		lblNewLabel_12_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12_2.setBounds(413, 167, 101, 24);
		panelP.add(lblNewLabel_12_2);
		
		JLabel lblsoPhongDon = new JLabel("10");
		lblsoPhongDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongDon.setBounds(211, 166, 33, 24);
		panelP.add(lblsoPhongDon);
		
		JLabel lblsoPhongDoi = new JLabel("10");
		lblsoPhongDoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongDoi.setBounds(365, 167, 59, 24);
		panelP.add(lblsoPhongDoi);
		
		JLabel lblsoPhongVip = new JLabel("10");
		lblsoPhongVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongVip.setBounds(524, 167, 59, 24);
		panelP.add(lblsoPhongVip);
	     
        
		
		
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
                    
                } else if (clickedButton == btnGUI_datPhong) {
                    // Xử lý khi nhấn vào nút btnHT
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_DatPhong().setVisible(true);
                } else if (clickedButton == btnGUI_nhanPhong) {
                    // Xử lý khi nhấn vào nút btnHT
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    
                } else if (clickedButton == btnGUI_TraPhong) {
                    // Xử lý khi nhấn vào nút btnHT
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_TraPhong().setVisible(true);
                } else if (clickedButton == btnGUI_doiPhong) {
                    // Xử lý khi nhấn vào nút btnHT
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_DoiPhong().setVisible(true);
                } else if (clickedButton == btnGUI_GiahanPhong) {
                    // Xử lý khi nhấn vào nút btnHT
                	btnTKDMK.setVisible(false);
                    btnTKDX.setVisible(false);
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_GiaHanPhong().setVisible(true);
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
                    btnGUI_datPhong.addActionListener(actionListener);
                    btnGUI_nhanPhong.addActionListener(actionListener);
                    btnGUI_TraPhong.addActionListener(actionListener);
                    btnGUI_doiPhong.addActionListener(actionListener);
                    btnGUI_GiahanPhong.addActionListener(actionListener);
                    
                 
                    
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
}
