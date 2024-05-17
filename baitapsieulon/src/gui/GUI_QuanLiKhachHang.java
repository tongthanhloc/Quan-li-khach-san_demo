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
	static ArrayList<KhachHang> dskh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLiKhachHang frame = new GUI_QuanLiKhachHang();
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
	public GUI_QuanLiKhachHang() {
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
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
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
		btnQLKH.setForeground(new Color(244, 244, 244));
		btnQLKH.setBackground(new Color(41, 139, 116));
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
		btnQLDV.setBounds(0, 387, 250, 68);
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
		panel_Center_Bot.setBounds(271, 369, 1648, 576);

		
		String[] cols = new String[] {"Mã khách hàng", "Tên khách hàng", "Giới tính", "Email", "Số điện thoại", "Địa chỉ", "Ngày sinh"};
		modelHD = new DefaultTableModel(cols,0);
		panel_Center_Bot.setLayout(null);
		tableNV = new JTable(modelHD);
		tableNV.setBackground(new Color(234, 232, 214));
		JScrollPane paneNV = new JScrollPane(tableNV);
		paneNV.setBounds(10, 38, 1610, 538);
		paneNV.setPreferredSize(new Dimension(1000,1000));
		panel_Center_Bot.add(paneNV);;
		JTableHeader headers = tableNV.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 15);
        headers.setFont(headerFont);
        headers.setPreferredSize(new Dimension(paneNV.getWidth(), 30));
        headers.setBackground(new Color(164, 194, 163));
		Frame.add(panel_Center_Bot);
		
		
		
		
        
		
		
		tableNV.addMouseListener(new MouseAdapter() {
			  
			

		    

			public void mouseClicked(MouseEvent e) {
		        int row = tableNV.getSelectedRow();
		        maKH = (String) tableNV.getValueAt(row, 0);
		       
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
                } else if(clickedButton == btnTim) {
                    // Xử lý khi nhấn vào nút btnTim
                		KhachHang kh = new KhachHang(null);
                		kh.setMaKH(txtMa.getText());
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
					kh.setMaKH(txtMa.getText());
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
                    btnTim.addActionListener(actionListener);
                    btbXoaTrang.addActionListener(actionListener);
                    btnThmKhchHng.addActionListener(actionListener);
                    btnXemChiTit.addActionListener(actionListener);
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
		    		kh.getMaKH(),
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
            if (kh.getMaKH() != null && !kh.getMaKH().isEmpty() && !kh.getMaKH().equals(khachHang.getMaKH())) {
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

