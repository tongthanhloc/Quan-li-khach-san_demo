package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUI_MenuNV extends JFrame {

	private JPanel Frame;
	private JButton btnTK;
    private JButton btnTKDMK;
    private JButton btnTKDX;
    private JButton btnTrangChu;
    private JButton btnQLP;
    private JButton btnQLHD;
    private JButton btnQLKH;
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
    private JButton btnQLPD;
	/**

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MenuNV frame = new GUI_MenuNV();
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
	public GUI_MenuNV() {
		
			setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
			setTitle("Quản lý khách sạn");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0,1920,1050);
			setLocationRelativeTo(null);
			setResizable(false);
			
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
			
			

			
			Panel panel_menu = new Panel();
			panel_menu.setLayout(null);
			panel_menu.setBackground(Color.LIGHT_GRAY);
			panel_menu.setBounds(0, 150, 250, 861);
			Frame.add(panel_menu);
			
			
			btnTrangChu = new JButton("Trang chủ");
			btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnTrangChu.setForeground(new Color(244, 244, 244));
			btnTrangChu.setBackground(new Color(41, 139, 106));
			btnTrangChu.setBounds(0, 0, 250, 70);
			panel_menu.add(btnTrangChu);
			
			
			btnQLP = new JButton("Quản lí phòng");
			btnQLP.setBackground(new Color(255, 255, 255));
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
			
			btnQLKM = new JButton("Quản lí khuyến mãi");
			btnQLKM.setBackground(new Color(255, 255, 255));
			btnQLKM.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnQLKM.setBounds(0, 264, 250, 68);
			panel_menu.add(btnQLKM);
			
			btnQLDV = new JButton("Quản lí dịch vụ");
			btnQLDV.setBackground(new Color(255, 255, 255));
			btnQLDV.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnQLDV.setBounds(0, 329, 250, 68);
			panel_menu.add(btnQLDV);
			
			btnHT = new JButton("Hỗ trợ");
			btnHT.setBackground(new Color(255, 255, 255));
			btnHT.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnHT.setBounds(0, 461, 250, 68);
			panel_menu.add(btnHT);
			
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
			lblNewLabel_4.setForeground(new Color(41, 111, 106));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_4.setBounds(0, 780, 250, 30);
			panel_menu.add(lblNewLabel_4);
			
			lblNewLabel_5 = new JLabel("Địa chỉ: 416/39 Dương Quảng Hàm");
			lblNewLabel_5.setForeground(new Color(41, 111, 106));
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(0, 812, 250, 30);
			panel_menu.add(lblNewLabel_5);
			
			lblNewLabel_6 = new JLabel("Phường 5, Gò Vấp, TP.HCM");
			lblNewLabel_6.setForeground(new Color(41, 111, 106));
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(0, 831, 250, 30);
			panel_menu.add(lblNewLabel_6);
			
			btnQLPD = new JButton("Quản lí Phiếu đặt");
			btnQLPD.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnQLPD.setBackground(Color.WHITE);
			btnQLPD.setBounds(0, 395, 250, 68);
			panel_menu.add(btnQLPD);
	}

}
