package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;


import javax.swing.border.LineBorder;


public class GUI_QuanLiDatPhong extends JFrame implements ItemListener{

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
    private JCheckBox chckbxdadat;
    private JCheckBox chckbxThue;
    private JCheckBox chckbxTrong;
    private JCheckBox chckbxBaotri;
    private JCheckBox chckbxPdon;
    private JCheckBox chckbxPdoi;
    private JCheckBox chckbxPVip;
	private JLabel lbldadat;
	private Panel panel_Center_dathue;
	private JLabel lblNewLabel_7;
	private JLabel lbldathue;
	private Panel panel_Center_trong;
	private JLabel lblnew;
	private JLabel lbltrong;
	private Panel panel_Center_baotri;
	private JLabel lblBoTr;
	private JLabel lblbaotri;
	private JButton[] button;
    String soPhong[] = {"A0101","C0103","A0102","A0103","A0104","A0105","A0106","A0107","A0108","A0109","A0110","B0101","B0102","B0103","B0104","B0105","C0101","C0102"};
    String tenKhachHang[] = {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc",""};
    int trangThai[] = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4};
	private String[][] mangHaiChieu;
	private JPanel panel;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLiDatPhong frame = new GUI_QuanLiDatPhong();
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
	public GUI_QuanLiDatPhong() {
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1000);
		setLocationRelativeTo(null);
		Frame = new JPanel();
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
		btnTK.setBackground(new Color(41, 139, 106));
		btnTK.setBounds(1647, 11, 247, 40);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/account-icon.png")).getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH)));
		btnTK.add(lblNewLabel);
		panel_top.add(btnTK);
		
		btnGUI_datPhong = new JButton("Đặt phòng");
		btnGUI_datPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_datPhong.setForeground(new Color(255, 255, 255));
		btnGUI_datPhong.setBackground(new Color(41, 139, 116));
		btnGUI_datPhong.setBounds(290, 25, 200, 100);
		panel_top.add(btnGUI_datPhong);
		
		btnGUI_nhanPhong = new JButton("Nhận Phòng");
		btnGUI_nhanPhong.setForeground(Color.WHITE);
		btnGUI_nhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_nhanPhong.setBackground(new Color(41, 139, 116));
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
		
		chckbxdadat = new JCheckBox("Đã đặt");
		chckbxdadat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxdadat.setBounds(287, 170, 97, 43);
		Frame.add(chckbxdadat);
		chckbxdadat.setSelected(true);
		
//		chckbxdadat.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Xử lý sự kiện khi checkbox được chọn hoặc không được chọn
//                if (chckbxdadat.isSelected()) {
//                	chckbxPdon.setSelected(true);
//                	chckbxPdoi.setSelected(true);
//                	chckbxPVip.setSelected(true);
//                    // Thực hiện hành động khi checkbox được chọn
//					for (int i = 0; i < soPhong.length; i++) {
//						if (trangThai[i] == 1) {
//							button[i].setVisible(true);
//						}
//					}
//                } else {
//                    // Thực hiện hành động khi checkbox không được chọn
//                	for (int i = 0; i < soPhong.length; i++) {
//						if (trangThai[i] == 1) {
//							button[i].setVisible(false);
//						}
//					}
//                }
//            }
//        });
		
		
		
		
		chckbxThue = new JCheckBox("Đã thuê");
		chckbxThue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxThue.setBounds(386, 170, 112, 43);
		Frame.add(chckbxThue);
		chckbxThue.setSelected(true);
		
//		chckbxThue.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// Xử lý sự kiện khi checkbox được chọn hoặc không được chọn
//				if (chckbxThue.isSelected()) {
//					// Thực hiện hành động khi checkbox được chọn
//					chckbxPdon.setSelected(true);
//					chckbxPdoi.setSelected(true);
//					chckbxPVip.setSelected(true);
//					for (int i = 0; i < soPhong.length; i++) {
//						if (trangThai[i] == 2) {
//							button[i].setVisible(true);
//						}
//					}
//				} else {
//					// Thực hiện hành động khi checkbox không được chọn
//					for (int i = 0; i < soPhong.length; i++) {
//						if (trangThai[i] == 2) {
//							button[i].setVisible(false);
//						}
//					}
//				}
//			}
//		});
		
		chckbxTrong = new JCheckBox("Trống");
		chckbxTrong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxTrong.setBounds(500, 170, 91, 43);
		Frame.add(chckbxTrong);
		chckbxTrong.setSelected(true);
		
//		chckbxTrong.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// Xử lý sự kiện khi checkbox được chọn hoặc không được chọn
//				if (chckbxTrong.isSelected()) {
//					// Thực hiện hành động khi checkbox được chọn
//					chckbxPdon.setSelected(true);
//					chckbxPdoi.setSelected(true);
//					chckbxPVip.setSelected(true);
//					for (int i = 0; i < soPhong.length; i++) {
//						if (trangThai[i] == 3) {
//							button[i].setVisible(true);
//						}
//					}
//				} else {
//					// Thực hiện hành động khi checkbox không được chọn
//					for (int i = 0; i < soPhong.length; i++) {
//						if (trangThai[i] == 3) {
//							button[i].setVisible(false);
//						}
//					}
//				}
//			}
//		});
		
		chckbxBaotri = new JCheckBox("Bảo trì");
		chckbxBaotri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxBaotri.setBounds(593, 170, 112, 43);
		Frame.add(chckbxBaotri);
		chckbxBaotri.setSelected(true);
		
//		chckbxBaotri.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// Xử lý sự kiện khi checkbox được chọn hoặc không được chọn
//				if (chckbxBaotri.isSelected()) {
//					// Thực hiện hành động khi checkbox được chọn
//					chckbxPdon.setSelected(true);
//					chckbxPdoi.setSelected(true);
//					chckbxPVip.setSelected(true);
//					for (int i = 0; i < soPhong.length; i++) {
//						if (trangThai[i] == 4) {
//							button[i].setVisible(true);
//						}
//					}
//				} else {
//					// Thực hiện hành động khi checkbox không được chọn
//					for (int i = 0; i < soPhong.length; i++) {
//						if (trangThai[i] == 4) {
//							button[i].setVisible(false);
//						}
//					}
//				}
//			}
//		});
		
		chckbxPdon = new JCheckBox("Phòng đơn (A)");
		chckbxPdon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdon.setBounds(287, 228, 178, 43);
		Frame.add(chckbxPdon);
		chckbxPdon.setSelected(true);
		
//		chckbxPdon.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// Xử lý sự kiện khi checkbox được chọn hoặc không được chọn
//				if (chckbxPdon.isSelected()) {
//					// Thực hiện hành động khi checkbox được chọn
//					chckbxdadat.setSelected(true);
//					chckbxThue.setSelected(true);
//					chckbxTrong.setSelected(true);
//					chckbxBaotri.setSelected(true);
//					for (int i = 0; i < soPhong.length; i++) {
//						if (soPhong[i].contains("A")) {
//							button[i].setVisible(true);
//						}
//					}
//				} else {
//					// Thực hiện hành động khi checkbox không được chọn
//					for (int i = 0; i < soPhong.length; i++) {
//						if (soPhong[i].contains("A")) {
//							button[i].setVisible(false);
//						}
//					}
//				}
//			}
//		});
		
		chckbxPdoi = new JCheckBox("Phòng đôi (B)");
		chckbxPdoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdoi.setBounds(489, 228, 178, 43);
		Frame.add(chckbxPdoi);
		chckbxPdoi.setSelected(true);
		
//		chckbxPdoi.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// Xử lý sự kiện khi checkbox được chọn hoặc không được chọn
//				if (chckbxPdoi.isSelected()) {
//					// Thực hiện hành động khi checkbox được chọn
//					chckbxdadat.setSelected(true);
//					chckbxThue.setSelected(true);
//					chckbxTrong.setSelected(true);
//					chckbxBaotri.setSelected(true);
//					for (int i = 0; i < soPhong.length; i++) {
//						if (soPhong[i].contains("B")) {
//							button[i].setVisible(true);
//						}
//					}
//				} else {
//					// Thực hiện hành động khi checkbox không được chọn
//					for (int i = 0; i < soPhong.length; i++) {
//						if (soPhong[i].contains("B")) {
//							button[i].setVisible(false);
//						}
//					}
//				}
//			}
//		});
		
		chckbxPVip = new JCheckBox("Phòng VIP (C)");
		chckbxPVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPVip.setBounds(699, 228, 178, 43);
		Frame.add(chckbxPVip);
		chckbxPVip.setSelected(true);
		
//		chckbxPVip.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// Xử lý sự kiện khi checkbox được chọn hoặc không được chọn
//				chckbxdadat.setSelected(true);
//				chckbxThue.setSelected(true);
//				chckbxTrong.setSelected(true);
//				chckbxBaotri.setSelected(true);
//				if (chckbxPVip.isSelected()) {
//					// Thực hiện hành động khi checkbox được chọn
//					for (int i = 0; i < soPhong.length; i++) {
//						if (soPhong[i].contains("C")) {
//							button[i].setVisible(true);
//						}
//					}
//				} else {
//					// Thực hiện hành động khi checkbox không được chọn
//					for (int i = 0; i < soPhong.length; i++) {
//						if (soPhong[i].contains("C")) {
//							button[i].setVisible(false);
//						}
//					}
//				}
//			}
//		});
		
	
		
//		ItemListener itemListener1 = new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    chckbxPdon.setSelected(true);
//                    chckbxPdoi.setSelected(true);
//                    chckbxPVip.setSelected(true);
//                } 
//            }
//        };
//
//        // Create item listener for group 2
//        ItemListener itemListener2 = new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    chckbxdadat.setSelected(true);
//                    chckbxThue.setSelected(true);
//                    chckbxTrong.setSelected(true);
//                    chckbxBaotri.setSelected(true);
//                } 
//            }
//        };
//        
//     // Add item listener to checkboxes in group 1
//        chckbxdadat.addItemListener(itemListener1);
//        chckbxThue.addItemListener(itemListener1);
//        chckbxTrong.addItemListener(itemListener1);
//        chckbxBaotri.addItemListener(itemListener1);
//
//        // Add item listener to checkboxes in group 2
//        chckbxPdon.addItemListener(itemListener2);
//        chckbxPdoi.addItemListener(itemListener2);
//        chckbxPVip.addItemListener(itemListener2);
		
		Panel panel_Center_dadat = new Panel();
		panel_Center_dadat.setBackground(new Color(34, 242, 93));
		panel_Center_dadat.setBounds(305, 289, 145, 43);
		Frame.add(panel_Center_dadat);
		panel_Center_dadat.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Đã đặt :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(0, 0, 100, 43);
		panel_Center_dadat.add(lblNewLabel_1);
		
		lbldadat = new JLabel("30");
		lbldadat.setHorizontalAlignment(SwingConstants.CENTER);
		lbldadat.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbldadat.setBounds(100, 0, 45, 43);
		panel_Center_dadat.add(lbldadat);
		
		panel_Center_dathue = new Panel();
		panel_Center_dathue.setLayout(null);
		panel_Center_dathue.setBackground(new Color(242, 128, 116));
		panel_Center_dathue.setBounds(481, 289, 145, 43);
		Frame.add(panel_Center_dathue);
		
		lblNewLabel_7 = new JLabel("Đã thuê:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(0, 0, 100, 43);
		panel_Center_dathue.add(lblNewLabel_7);
		
		lbldathue = new JLabel("301");
		lbldathue.setHorizontalAlignment(SwingConstants.CENTER);
		lbldathue.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbldathue.setBounds(100, 0, 45, 43);
		panel_Center_dathue.add(lbldathue);
		
		panel_Center_trong = new Panel();
		panel_Center_trong.setLayout(null);
		panel_Center_trong.setBackground(new Color(5, 207, 251));
		panel_Center_trong.setBounds(661, 289, 145, 43);
		Frame.add(panel_Center_trong);
		
		lblnew = new JLabel("Trống");
		lblnew.setHorizontalAlignment(SwingConstants.CENTER);
		lblnew.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblnew.setBounds(0, 0, 100, 43);
		panel_Center_trong.add(lblnew);
		
		lbltrong = new JLabel("301");
		lbltrong.setHorizontalAlignment(SwingConstants.CENTER);
		lbltrong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbltrong.setBounds(100, 0, 45, 43);
		panel_Center_trong.add(lbltrong);
		
		panel_Center_baotri = new Panel();
		panel_Center_baotri.setLayout(null);
		panel_Center_baotri.setBackground(new Color(251, 193, 146));
		panel_Center_baotri.setBounds(839, 289, 145, 43);
		Frame.add(panel_Center_baotri);
		
		lblBoTr = new JLabel("Bảo trì");
		lblBoTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoTr.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBoTr.setBounds(0, 0, 100, 43);
		panel_Center_baotri.add(lblBoTr);
		
		lblbaotri = new JLabel("301");
		lblbaotri.setHorizontalAlignment(SwingConstants.CENTER);
		lblbaotri.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblbaotri.setBounds(100, 0, 45, 43);
		panel_Center_baotri.add(lblbaotri);
		
		JPanel outerPanel = new JPanel(null);
        outerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        outerPanel.setBounds(287, 357, 1580, 580); // Đặt vị trí và kích thước của panel bên ngoài
        Frame.add(outerPanel);

        // Tạo một panel bên trong với layout null và kích thước cố định
        panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(1500, 1000)); // Đặt kích thước của panel bên trong
//        panel.setBackground(Color.WHITE); // Đặt màu nền cho panel bên trong

        // Thêm các thành phần vào panel bên trong
        

        // Tạo một JScrollPane và thêm panel bên trong vào đó
        JScrollPane scrollPane = new JScrollPane(panel);                      
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
        scrollPane.setBounds(0, 0, 1580, 580);

        // Thêm JScrollPane vào panel bên ngoài
        outerPanel.add(scrollPane);
		
        // Hàm tạo buton
        
        
        
        button = new JButton[soPhong.length];
//        for (int i = 0; i < soPhong.length; i++) {
//            button[i] = new JButton();
//            StringBuilder htmlText = new StringBuilder("<html><center>");
//            htmlText.append("<span style='font-family:Tahoma; font-size:60pt;'>").append(soPhong[i]).append("</span><br/>");
//            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("na").append("</span>");
//            htmlText.append("</center></html>");
//            button[i].setText(htmlText.toString());
//            button[i].setBounds(70 +((i)%5)*290, 50+((i)/5)*190 , 250, 150);
//            panel.setPreferredSize(new Dimension(1500, 100+((i)/5)*190+150));
//            button[i].setText(button[i].getText().replaceAll("na", tenKhachHang[i]));
//			if(trangThai[i]==1) {
//				button[i].setBackground(new Color(34, 242, 93));
//			}
//			else if (trangThai[i] == 2) {
//				button[i].setBackground(new Color(242, 128, 116));
//			}else if (trangThai[i] == 3) {
//				button[i].setBackground(new Color(5, 207, 251));
//			} else if (trangThai[i] == 4) {
//				button[i].setBackground(new Color(251, 193, 146));
//			}
//            panel.add(button[i]);
//        }
		
        
		
        //xử lý các checkbox
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
		
        button=createButtons(panel, soPhong, tenKhachHang, trangThai);
        
        
        
        
        
        
        
        
		
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
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_NhanPhong().setVisible(true);
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
                    chckbxdadat.addItemListener(this);
                    chckbxThue.addItemListener(this);
                    chckbxTrong.addItemListener(this);
                    chckbxBaotri.addItemListener(this);
                    chckbxPdon.addItemListener(this);
                    chckbxPdoi.addItemListener(this);
                    chckbxPVip.addItemListener(this);
                 
                    
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		maphongs = new String[0];
		tens = new String[0];
		trangTs = new int[0];
		for (int i = 0; i < maphongs.length; i++) {
			maphongs[i] = null;
			tens[i] = null;
			trangTs[i] = 0;
		}
		if (chckbxdadat.isSelected() == false && chckbxThue.isSelected() == false && chckbxTrong.isSelected() == false
				&& chckbxBaotri.isSelected() == false) {
			chckbxdadat.setSelected(true);
			chckbxThue.setSelected(true);
			chckbxTrong.setSelected(true);
			chckbxBaotri.setSelected(true);
			
		}
		if (chckbxPdon.isSelected() == false && chckbxPdoi.isSelected() == false && chckbxPVip.isSelected() == false) {
			chckbxPdon.setSelected(true);
			chckbxPdoi.setSelected(true);
			chckbxPVip.setSelected(true);
		}
		
		if (chckbxdadat.isSelected()) {
			if (chckbxPdon.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("A")&& trangThai[i]==1) {
						maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
						maphongs[maphongs.length - 1] = soPhong[i];
						tens = Arrays.copyOf(tens, tens.length + 1);
						tens[tens.length - 1] = tenKhachHang[i];
						trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
						trangTs[trangTs.length - 1] = trangThai[i];
					}
				}}
			
			if (chckbxPdoi.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("B")&& trangThai[i]==1) {
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
					if (soPhong[i].contains("C") && trangThai[i]==1) {
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
			
		}if(chckbxThue.isSelected()) {
			if (chckbxPdon.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("A")&& trangThai[i]==2) {
						maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
						maphongs[maphongs.length - 1] = soPhong[i];
						tens = Arrays.copyOf(tens, tens.length + 1);
						tens[tens.length - 1] = tenKhachHang[i];
						trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
						trangTs[trangTs.length - 1] = trangThai[i];
					}
				}}
			
			
			if (chckbxPdoi.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("B")&& trangThai[i]==2) {
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
					if (soPhong[i].contains("C") && trangThai[i]==1) {
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
		}if(chckbxTrong.isSelected()) {
        	if (chckbxPdon.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("A")&& trangThai[i]==3) {
						maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
						maphongs[maphongs.length - 1] = soPhong[i];
						tens = Arrays.copyOf(tens, tens.length + 1);
						tens[tens.length - 1] = tenKhachHang[i];
						trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
						trangTs[trangTs.length - 1] = trangThai[i];
					}
				}}
			
			
			if (chckbxPdoi.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("B")&& trangThai[i]==3) {
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
					if (soPhong[i].contains("C") && trangThai[i]==1) {
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
        }if(chckbxBaotri.isSelected()) {
        	if (chckbxPdon.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("A")&& trangThai[i]==4) {
						maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
						maphongs[maphongs.length - 1] = soPhong[i];
						tens = Arrays.copyOf(tens, tens.length + 1);
						tens[tens.length - 1] = tenKhachHang[i];
						trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
						trangTs[trangTs.length - 1] = trangThai[i];
					}
				}}
			
			
			if (chckbxPdoi.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("B")&& trangThai[i]==4) {
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
					if (soPhong[i].contains("C") && trangThai[i]==4) {
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
        }if(chckbxPdon.isSelected()) {
        	if (chckbxdadat.isSelected()) {
        		for (int i = 0; i < soPhong.length; i++) {
        			if (soPhong[i].contains("A")&& trangThai[i]==1) {
        				maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        				maphongs[maphongs.length - 1] = soPhong[i];
        				tens = Arrays.copyOf(tens, tens.length + 1);
        				tens[tens.length - 1] = tenKhachHang[i];
        				trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        				trangTs[trangTs.length - 1] = trangThai[i];
        			}
        		}
        	}
        	if (chckbxThue.isSelected()) {
        		for (int i = 0; i < soPhong.length; i++) {
        			if (soPhong[i].contains("A")&& trangThai[i]==2) {
        				maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        				maphongs[maphongs.length - 1] = soPhong[i];
        				tens = Arrays.copyOf(tens, tens.length + 1);
        				tens[tens.length - 1] = tenKhachHang[i];
        				trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        				trangTs[trangTs.length - 1] = trangThai[i];
        			}
        		}
        	}
        	if (chckbxTrong.isSelected()) {
        		for (int i = 0; i < soPhong.length; i++) {
        			if (soPhong[i].contains("A")&& trangThai[i]==3) {
        				maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        				maphongs[maphongs.length - 1] = soPhong[i];
        				tens = Arrays.copyOf(tens, tens.length + 1);
        				tens[tens.length - 1] = tenKhachHang[i];
        				trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        				trangTs[trangTs.length - 1] = trangThai[i];
        			}
        		}}if (chckbxBaotri.isSelected()) {
        		for (int i = 0; i < soPhong.length; i++) {
        			if (soPhong[i].contains("A")&& trangThai[i]==4) {
        				maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        				maphongs[maphongs.length - 1] = soPhong[i];
        				tens = Arrays.copyOf(tens, tens.length + 1);
        				tens[tens.length - 1] = tenKhachHang[i];
        				trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        				trangTs[trangTs.length - 1] = trangThai[i];
        			}
        		}}
        }
        if(chckbxPdoi.isSelected()) {
        	if (chckbxdadat.isSelected()) {
        		for (int i = 0; i < soPhong.length; i++) {
        			if (soPhong[i].contains("B")&& trangThai[i]==1) {
        				maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        				maphongs[maphongs.length - 1] = soPhong[i];
        				tens = Arrays.copyOf(tens, tens.length + 1);
        				tens[tens.length - 1] = tenKhachHang[i];
        				trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        				trangTs[trangTs.length - 1] = trangThai[i];
        			}
        		}
        	}if (chckbxThue.isSelected()) {
        		for (int i = 0; i < soPhong.length; i++) {
        			if (soPhong[i].contains("B")&& trangThai[i]==2) {
        				maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        				maphongs[maphongs.length - 1] = soPhong[i];
        				tens = Arrays.copyOf(tens, tens.length + 1);
        				tens[tens.length - 1] = tenKhachHang[i];
        				trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        				trangTs[trangTs.length - 1] = trangThai[i];
        			}
        		}}if (chckbxTrong.isSelected()) {
        		for (int i = 0; i < soPhong.length; i++) {
        			if (soPhong[i].contains("B")&& trangThai[i]==3) {
        				maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        				maphongs[maphongs.length - 1] = soPhong[i];
        				tens = Arrays.copyOf(tens, tens.length + 1);
        				tens[tens.length - 1] = tenKhachHang[i];
        				trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        				trangTs[trangTs.length - 1] = trangThai[i];
        			}
        		}}if (chckbxBaotri.isSelected()) {
				for (int i = 0; i < soPhong.length; i++) {
					if (soPhong[i].contains("B") && trangThai[i] == 4) {
						maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
						maphongs[maphongs.length - 1] = soPhong[i];
						tens = Arrays.copyOf(tens, tens.length + 1);
						tens[tens.length - 1] = tenKhachHang[i];
						trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
						trangTs[trangTs.length - 1] = trangThai[i];
					}
				}
			} 
        	}if(chckbxPVip.isSelected()) {
        		if (chckbxdadat.isSelected()) {
        			for (int i = 0; i < soPhong.length; i++) {
        				if (soPhong[i].contains("C")&& trangThai[i]==1) {
        					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        					maphongs[maphongs.length - 1] = soPhong[i];
        					tens = Arrays.copyOf(tens, tens.length + 1);
        					tens[tens.length - 1] = tenKhachHang[i];
        					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        					trangTs[trangTs.length - 1] = trangThai[i];
        				}
        			}
        		}if (chckbxThue.isSelected()) {
        			for (int i = 0; i < soPhong.length; i++) {
        				if (soPhong[i].contains("C")&& trangThai[i]==2) {
        					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        					maphongs[maphongs.length - 1] = soPhong[i];
        					tens = Arrays.copyOf(tens, tens.length + 1);
        					tens[tens.length - 1] = tenKhachHang[i];
        					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        					trangTs[trangTs.length - 1] = trangThai[i];
        				}
        			}}if(chckbxTrong.isSelected()) {
        			for (int i = 0; i < soPhong.length; i++) {
        				if (soPhong[i].contains("C")&& trangThai[i]==3) {
        					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
        					maphongs[maphongs.length - 1] = soPhong[i];
        					tens = Arrays.copyOf(tens, tens.length + 1);
        					tens[tens.length - 1] = tenKhachHang[i];
        					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
        					trangTs[trangTs.length - 1] = trangThai[i];
        				}
        			}}if (chckbxBaotri.isSelected()) {
					for (int i = 0; i < soPhong.length; i++) {
						if (soPhong[i].contains("C") && trangThai[i] == 4) {
							maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
							maphongs[maphongs.length - 1] = soPhong[i];
							tens = Arrays.copyOf(tens, tens.length + 1);
							tens[tens.length - 1] = tenKhachHang[i];
							trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
							trangTs[trangTs.length - 1] = trangThai[i];
						}
					}
				} 
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
//		mangHaiChieu=new String[3][maphong.length];
//		for (int i = 0; i < maphong.length; i++) {
//			mangHaiChieu[0][i] = maphong[i];
//			mangHaiChieu[1][i] = ten[i];
//			mangHaiChieu[2][i] = String.valueOf(trangT[i]);
//		}
//		mangHaiChieu = sapXep(mangHaiChieu);
//	    maphong = mangHaiChieu[0];
//	    ten = mangHaiChieu[1];
//	    trangT = new int[maphong.length];
//	       	for (int i = 0; i < maphong.length; i++) {
//	            trangT[i] = Integer.parseInt(mangHaiChieu[2][i]);	                    
//	       	}
//		button = createButtons(panel, maphong, ten, trangT);
//	}
			
				
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
