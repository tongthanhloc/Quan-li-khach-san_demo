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
import com.toedter.calendar.JDateChooser;

public class GUI_QuanLiKhuyenMai extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Frame;
	private Panel panelTK;
	private JButton btnTKDMK;
	private JButton btnTKDX;
	private JLabel btnTKHTNV;
	private JLabel btnTKTNV;
	private JLabel btnTKca;
	private JLabel btnmaNV;
	private JButton btnTK;
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
	private JPanel panel_Center_Top;
	private JLabel lblMa;
	private JLabel lblThoiGianBD;
	private JTextField txtMaKM;
	private JLabel lblTenKM;
	private JLabel lblThoiGianKT;
	private JTextField txtTenKM;
	private JButton btbXoaTrang;
	private DefaultTableModel modelHD;
	private JTable tableNV;
	private JTextField txtPTKM;
	private JPanel panel;
	private JLabel lblMKhuynMi;
	private JTextField txtTimMa;
	private JLabel lblTenKM_Tim;
	private JTextField txtTenKM_Tim;
	private JButton btn_Tim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLiKhuyenMai frame = new GUI_QuanLiKhuyenMai();
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
	public GUI_QuanLiKhuyenMai() {
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1000);
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
		btnTK.setBackground(new Color(41, 139, 106));
		btnTK.setBounds(1647, 11, 247, 40);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/account-icon.png")).getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH)));
		btnTK.add(lblNewLabel);
		panel_top.add(btnTK);
		
		

		
		Panel panel_menu = new Panel();
		panel_menu.setLayout(null);
		panel_menu.setBackground(Color.LIGHT_GRAY);
		panel_menu.setBounds(0, 150, 250, 821);
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
		btnQLHD.setBackground(Color.WHITE);
		btnQLHD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLHD.setBounds(0, 133, 250, 68);
		panel_menu.add(btnQLHD);
		
		
		btnQLKH = new JButton("Quản lí Khách hàng");
		btnQLKH.setBackground(new Color(255, 255, 255));
		btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnQLKH.setBounds(0, 198, 250, 68);
		panel_menu.add(btnQLKH);
		
		
		btnQLNV = new JButton("Quản lí nhân viên");
		btnQLNV.setBackground(Color.WHITE);
		btnQLNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLNV.setBounds(0, 261, 250, 68);
		panel_menu.add(btnQLNV);
		
		btnQLKM = new JButton("Quản lí khuyến mãi");
		btnQLKM.setForeground(new Color(244, 244, 244));
		btnQLKM.setBackground(new Color(41, 139, 116));
		btnQLKM.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLKM.setBounds(0, 323, 250, 68);
		panel_menu.add(btnQLKM);
		
		btnQLDV = new JButton("Quản lí dịch vụ");
		btnQLDV.setBackground(new Color(255, 255, 255));
		btnQLDV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLDV.setBounds(0, 389, 250, 68);
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
		
		panel_Center_Top = new JPanel();
		panel_Center_Top.setBackground(new Color(255, 255, 255));
		panel_Center_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Center_Top.setBounds(228, 132, 1666, 223);
		Frame.add(panel_Center_Top);
		panel_Center_Top.setLayout(null);
		
		lblMa = new JLabel("Mã khuyến mãi");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(140, 25, 200, 35);
		panel_Center_Top.add(lblMa);
		
		lblThoiGianBD = new JLabel("Thời gian bắt đầu");
		lblThoiGianBD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThoiGianBD.setBounds(140, 75, 186, 35);
		panel_Center_Top.add(lblThoiGianBD);
		
		txtMaKM = new JTextField();
		txtMaKM.setBackground(new Color(41, 139, 116));
		txtMaKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKM.setColumns(10);
		txtMaKM.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMaKM);
		
		lblTenKM = new JLabel("Tên khuyến mãi");
		lblTenKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKM.setBounds(900, 25, 210, 35);
		panel_Center_Top.add(lblTenKM);
		
		lblThoiGianKT = new JLabel("Thời gian kết thúc");
		lblThoiGianKT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThoiGianKT.setBounds(900, 75, 175, 35);
		panel_Center_Top.add(lblThoiGianKT);
		
		txtTenKM = new JTextField();
		txtTenKM.setBackground(new Color(41, 139, 116));
		txtTenKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKM.setColumns(10);
		txtTenKM.setBounds(1100, 25, 350, 40);
		panel_Center_Top.add(txtTenKM);
		
		btbXoaTrang = new JButton("Xóa trắng");
		btbXoaTrang.setBackground(new Color(234, 232, 214));
		btbXoaTrang.setBounds(1438, 176, 158, 35);
		panel_Center_Top.add(btbXoaTrang);
		btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPTKM = new JLabel("Phần trăm khuyến mãi");
		lblPTKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPTKM.setBounds(140, 125, 246, 35);
		panel_Center_Top.add(lblPTKM);
		
		txtPTKM = new JTextField();
		txtPTKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPTKM.setColumns(10);
		txtPTKM.setBackground(new Color(41, 139, 116));
		txtPTKM.setBounds(350, 123, 350, 40);
		panel_Center_Top.add(txtPTKM);
		
		JButton btn_Sua = new JButton("Sửa");
		btn_Sua.setBackground(new Color(234, 232, 214));
		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Sua.setBounds(1229, 176, 175, 35);
		panel_Center_Top.add(btn_Sua);
		
		JButton btn_Xoa = new JButton("Xóa");
		btn_Xoa.setBackground(new Color(234, 232, 214));
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Xoa.setBounds(1021, 176, 175, 35);
		panel_Center_Top.add(btn_Xoa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(234, 232, 214));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBounds(822, 176, 175, 35);
		panel_Center_Top.add(btnThem);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBackground(new Color(41, 139, 116));
		dateChooser.setBounds(350, 75, 350, 35);
		panel_Center_Top.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBackground(new Color(41, 139, 116));
		dateChooser_1.setBounds(1100, 75, 350, 35);
		panel_Center_Top.add(dateChooser_1);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(246, 366, 1648, 513);

		
		String[] cols = new String[] {"Mã nhân viên", "Họ tên", "Giới tính" , "Số căn cước công dân", "Vị trí", "Số điện thoại", "Địa chỉ", "Ngày sinh", "Ngày vào làm", "Ngày nghỉ làm", "Trạng thái", "Trình độ học vấn", "Hệ số lương", "Lương cơ bản", "Tổng lương"};
		modelHD = new DefaultTableModel(cols,0);
		panel_Center_Bot.setLayout(null);
		tableNV = new JTable(modelHD);
		tableNV.setBackground(new Color(128, 255, 0));
		JScrollPane paneNV = new JScrollPane(tableNV);
		paneNV.setBounds(10, 11, 1610, 491);
		paneNV.setPreferredSize(new Dimension(1000,1000));
		panel_Center_Bot.add(paneNV);;
		JTableHeader headers = tableNV.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 15);
        headers.setFont(headerFont);
		Frame.add(panel_Center_Bot);
		
		panel = new JPanel();
		panel.setBounds(256, 853, 1638, 108);
		Frame.add(panel);
		panel.setLayout(null);
		
		lblMKhuynMi = new JLabel("Mã khuyến mãi");
		lblMKhuynMi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMKhuynMi.setBounds(45, 45, 246, 35);
		panel.add(lblMKhuynMi);
		
		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimMa.setColumns(10);
		txtTimMa.setBackground(new Color(55, 149, 128));
		txtTimMa.setBounds(205, 45, 350, 40);
		panel.add(txtTimMa);
		
		lblTenKM_Tim = new JLabel("Tên khuyến mãi");
		lblTenKM_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKM_Tim.setBounds(700, 45, 210, 35);
		panel.add(lblTenKM_Tim);
		
		txtTenKM_Tim = new JTextField();
		txtTenKM_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKM_Tim.setColumns(10);
		txtTenKM_Tim.setBackground(new Color(55, 149, 128));
		txtTenKM_Tim.setBounds(900, 41, 350, 40);
		panel.add(txtTenKM_Tim);
		
		btn_Tim = new JButton("Tìm");
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Tim.setBounds(1280, 45, 175, 35);
		panel.add(btn_Tim);
		
		
		
		
        
		
		
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
}
