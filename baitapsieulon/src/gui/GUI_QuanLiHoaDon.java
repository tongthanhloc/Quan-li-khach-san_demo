package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;



public class GUI_QuanLiHoaDon extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JPanel panel_Center_Top;
    private JLabel lblMahoaDon;
    private JLabel lblMaNhanVien;
    private JLabel lblNgNhanPhong;
    private JTextField txtMahoaDon;
    private JTextField txtMaNhanVien;
    private JTextField txtNgNhanPhong;
    private JLabel lblKhachHang;
    private JLabel lblNgDatPhong;
    private JLabel lblNgTraPhong;
    private JTextField txtMaKhachHang;
    private JButton btbXoaTrang;
    private JTable table;
	private DefaultTableModel modelHD;
	private JTable tableHD;
	

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
                    GUI_QuanLiHoaDon frame = new GUI_QuanLiHoaDon(nv);
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
	public GUI_QuanLiHoaDon(NhanVien nv) {
		
		
		
		
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
		
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setResizable(false);
		
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
		btnTrangChu.setForeground(new Color(244, 244, 244));
		btnTrangChu.setBackground(new Color(41, 139, 106));
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
        
	
		
		panel_Center_Top = new JPanel();
		panel_Center_Top.setBackground(new Color(255, 255, 255));
		panel_Center_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Center_Top.setBounds(250, 150, 1653, 223);
		Frame.add(panel_Center_Top);
		panel_Center_Top.setLayout(null);
		
		lblMahoaDon = new JLabel("Mã hóa đơn");
		lblMahoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMahoaDon.setBounds(140, 25, 126, 35);
		panel_Center_Top.add(lblMahoaDon);
		
		lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNhanVien.setBounds(140, 75, 126, 35);
		panel_Center_Top.add(lblMaNhanVien);
		
		lblNgNhanPhong = new JLabel("Ngày nhận phòng");
		lblNgNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgNhanPhong.setBounds(140, 125, 186, 35);
		panel_Center_Top.add(lblNgNhanPhong);
		
		txtMahoaDon = new JTextField();
		txtMahoaDon.setBackground(new Color(41, 139, 116));
		txtMahoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMahoaDon.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMahoaDon);
		txtMahoaDon.setColumns(10);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBackground(new Color(41, 139, 116));
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(350, 73, 350, 40);
		panel_Center_Top.add(txtMaNhanVien);
		
		txtNgNhanPhong = new JTextField();
		txtNgNhanPhong.setBackground(new Color(41, 139, 116));
		txtNgNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgNhanPhong.setColumns(10);
		txtNgNhanPhong.setBounds(350, 125, 350, 40);
		panel_Center_Top.add(txtNgNhanPhong);
		
		lblKhachHang = new JLabel("Mã khách hàng");
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKhachHang.setBounds(900, 25, 210, 35);
		panel_Center_Top.add(lblKhachHang);
		
		lblNgDatPhong = new JLabel("Ngày đặt phòng");
		lblNgDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgDatPhong.setBounds(900, 75, 175, 35);
		panel_Center_Top.add(lblNgDatPhong);
		
		lblNgTraPhong = new JLabel("Ngày trả phòng");
		lblNgTraPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgTraPhong.setBounds(900, 125, 198, 35);
		panel_Center_Top.add(lblNgTraPhong);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBackground(new Color(41, 139, 116));
		txtMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(1100, 25, 350, 40);
		panel_Center_Top.add(txtMaKhachHang);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setBounds(1160, 176, 175, 35);
		panel_Center_Top.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btbXoaTrang = new JButton("Xóa trắng");
		btbXoaTrang.setBackground(new Color(234, 232, 214));
		btbXoaTrang.setBounds(1389, 176, 175, 35);
		panel_Center_Top.add(btbXoaTrang);
		btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(1100, 75, 350, 35);
		panel_Center_Top.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(1100, 125, 350, 35);
		panel_Center_Top.add(dateChooser_1);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(256, 375, 1648, 576);

		
		String[] cols = new String[] {"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã Khuyến mãi ", "Ngày lập hóa đơn", "Tổng tiền thanh toán" ,"Tiền khách đưa" , "Tiền thối", "Trang thái"};
		modelHD = new DefaultTableModel(cols,0);
		panel_Center_Bot.setLayout(null);
		tableHD = new JTable(modelHD);
		tableHD.setBackground(new Color(128, 255, 0));
		JScrollPane paneNV = new JScrollPane(tableHD);
		paneNV.setBounds(10, 27, 1610, 538);
		paneNV.setPreferredSize(new Dimension(1000,1000));
		panel_Center_Bot.add(paneNV);;
		JTableHeader headers = tableHD.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 15);
        headers.setFont(headerFont);
		Frame.add(panel_Center_Bot);
		
		
		
		
        
		
		
		
		
	}


	

	

	
}