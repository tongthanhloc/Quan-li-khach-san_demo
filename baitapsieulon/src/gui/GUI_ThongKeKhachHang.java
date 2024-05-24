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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import entity.KhachHang;
import entity.NhanVien;

import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;



public class GUI_ThongKeKhachHang extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTable table;
	private DefaultTableModel modelHD;
	private DefaultTableModel modelDT;
	private JTextField txtSLKH;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtThanThiet;
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
	private JTextField txtavgTuoi;
	private ArrayList<KhachHang> dsKH;
	private int avg;
	private JPanel panelBieuDo;
	
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

	private GUI_QuanLiDatPhong qlp;
	private GUI_QuanLiHoaDon qlhd;
	private GUI_QuanLiKhachHang qlkh;
	private JButton btnHT;
	private JButton btnTK;
	private JPanel panelTK;
	private JButton btnTKDMK;
	private JButton btnTKDX;
	private JLabel btnTKHTNV;
	private JLabel btnTKTNV;
	private JLabel btnmaNV;
	private NhanVien nhanvien;
	private NhanVien_DAO nv_dao;
	private ArrayList<NhanVien> ListNV;
	
	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	NhanVien nv = new NhanVien("QL0000010");
                	GUI_ThongKeKhachHang frame = new GUI_ThongKeKhachHang(nv);
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
	public GUI_ThongKeKhachHang(NhanVien nv) {

		try {
			ConnectDB.getInstance().connect();
			} catch (Exception e) {
				e.printStackTrace();
		}
		dsKH = new KhachHang_DAO().getalltbKhachHang();
		nhanvien = nv;
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
		setBounds(0,0,1920,1080);
		setLocationRelativeTo(null);
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
		btnThongKe.setBackground(new Color(41, 139, 116));
		btnThongKe.setForeground(new Color(255, 255, 255));
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
		
		JButton btnThngKNhn = new JButton("Nhân Viên");
		btnThngKNhn.setBackground(new Color(41, 139, 116));
		btnThngKNhn.setForeground(new Color(255, 255, 255));
		btnThngKNhn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnThngKNhn.setBounds(250, 25, 200, 100);
		panel_top.add(btnThngKNhn);
		
		JButton btnKhchHng = new JButton("Khách Hàng");
		btnKhchHng.setForeground(new Color(244, 244, 244));
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnKhchHng.setBackground(new Color(164, 194, 163));
		btnKhchHng.setForeground(new Color(0,0,0));
		btnKhchHng.setBounds(494, 25, 200, 100);
		panel_top.add(btnKhchHng);
		
		JButton btnDoanhThu = new JButton("Doanh thu");
		btnDoanhThu.setForeground(new Color(244, 244, 244));
		btnDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDoanhThu.setBackground(new Color(41, 139, 106));
		btnDoanhThu.setBounds(746, 25, 200, 100);
		panel_top.add(btnDoanhThu);
		btnmaNV.setText("<html><div style='text-align: center;'>" +"Mã Nhân viên: "+ nhanvien.getMaNV() + "</div></html>");
		btnTKHTNV.setText("<html><div style='text-align: center;'>" + "Họ tên: "+nhanvien.getHoTenNV() + "</div></html>");
		int tuoi = (int) ChronoUnit.YEARS.between(nhanvien.getNgaySinh(), java.time.LocalDate.now());
		btnTKTNV.setText("<html><div style='text-align: center;'>" + "Tuổi: "+tuoi + "</div></html>");
		
		
		
		
		if(!nhanvien.getMaNV().contains("QL")) {
			btnQLNV.setVisible(false);
			btnThongKe.setVisible(false);
			
			btnHT.setBounds(0, 350, 250, 70);
		}
		
		
		
		
		
		JPanel panel_Center_Left = new JPanel();
		panel_Center_Left.setBounds(250, 150, 690, 891);
		panel_Center_Left.setLayout(null);
		
		JPanel panel_Center_Right = new JPanel();
		panel_Center_Right.setBounds(940, 150, 962, 891);
		panel_Center_Right.setLayout(null);
		panelBieuDo = new JPanel();
		panelBieuDo.setPreferredSize(new Dimension(962, 2050));
		JScrollPane scrollPane = new JScrollPane(panelBieuDo);
		scrollPane.setBounds(0,0, 962, 891);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		panel_Center_Right.add(scrollPane);
		
		
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
		lblNewLabel_9.setBounds(28, 9, 175, 16);
		panel.add(lblNewLabel_9);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBounds(0, 2, 10, 122);
		panel.add(panel_2_1_1);
		panel_2_1_1.setBackground(new Color(41, 139, 116));
				
				JLabel lblTT = new JLabel("0.0%");
				lblTT.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblTT.setForeground(new Color(0, 0, 0));
				lblTT.setBounds(113, 61, 55, 16);
				panel.add(lblTT);
				
				JLabel lbltileTT = new JLabel("0/0");
				lbltileTT.setFont(new Font("Dialog", Font.BOLD, 25));
				lbltileTT.setBounds(28, 37, 78, 58);
				panel.add(lbltileTT);
				
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
				
				JLabel lblNewLabel_9_1 = new JLabel("Tỉ lệ Nam");
				lblNewLabel_9_1.setBounds(28, 9, 119, 16);
				panel_1.add(lblNewLabel_9_1);
				
				JPanel panel_2_1_1_1 = new JPanel();
				panel_2_1_1_1.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1.setBounds(0, 2, 10, 122);
				panel_1.add(panel_2_1_1_1);
				
				JLabel lbltileNam = new JLabel("40/50");
				lbltileNam.setFont(new Font("Dialog", Font.BOLD, 25));
				lbltileNam.setBounds(36, 37, 78, 58);
				panel_1.add(lbltileNam);
				
				JLabel lblNam = new JLabel("0.0%");
				lblNam.setForeground(new Color(0, 0, 0));
				lblNam.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNam.setBounds(116, 61, 55, 16);
				panel_1.add(lblNam);
				
				JLabel lblNewLabel_7_1 = new JLabel("Điểm Trung bình");
				lblNewLabel_7_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1.setBounds(24, 232, 171, 16);
				panel_2.add(lblNewLabel_7_1);
				
				JPanel panel_1_2 = new JPanel();
				panel_1_2.setLayout(null);
				panel_1_2.setBackground(Color.WHITE);
				panel_1_2.setBounds(335, 232, 298, 124);
				panel_2.add(panel_1_2);
				
				JLabel lblNewLabel_9_1_2 = new JLabel("Tỉ lệ Nữ");
				lblNewLabel_9_1_2.setBounds(36, 10, 119, 16);
				panel_1_2.add(lblNewLabel_9_1_2);
				
				JPanel panel_2_1_1_1_2 = new JPanel();
				panel_2_1_1_1_2.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1_2.setBounds(0, 2, 10, 122);
				panel_1_2.add(panel_2_1_1_1_2);
				
				JLabel lbltileNu = new JLabel("40");
				lbltileNu.setFont(new Font("Dialog", Font.BOLD, 25));
				lbltileNu.setBounds(36, 37, 78, 58);
				panel_1_2.add(lbltileNu);
				

				
				JLabel lblNu = new JLabel("0.0%");
				lblNu.setForeground(Color.BLACK);
				lblNu.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNu.setBounds(114, 61, 55, 16);
				panel_1_2.add(lblNu);
				
				txtTBT = new JTextField();
				txtTBT.setColumns(10);
				txtTBT.setBounds(192, 230, 114, 25);
				txtTBT.setEditable(false);
//				Integer avg = findAverageAge(dsT);
//				txtTBT.setText(avg.toString());
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

//				Integer maxT = findMaxAge(dsT);
//				txtTCN.setText(maxT.toString());
				panel_2.add(txtTCN);
				
				JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Điểm thấp nhất");
				lblNewLabel_7_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1_1_1_1.setBounds(24, 301, 171, 16);
				panel_2.add(lblNewLabel_7_1_1_1_1);
				
				txtTTN = new JTextField();
				txtTTN.setColumns(10);
				txtTTN.setBounds(192, 293, 114, 25);
				txtTTN.setEditable(false);
//				Integer minT = findMinAge(dsT);
//				txtTTN.setText(minT.toString());
				panel_2.add(txtTTN);
				
				txtavgTuoi = new JTextField();
				txtavgTuoi.setText("100");
				txtavgTuoi.setEditable(false);
				txtavgTuoi.setColumns(10);
				txtavgTuoi.setBounds(192, 328, 114, 25);
				panel_2.add(txtavgTuoi);
				
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
				panel_2_1_1_2.setBackground(new Color(41, 139, 116));
				panel_2_1_1_2.setBounds(0, 2, 10, 122);
				panel_4.add(panel_2_1_1_2);
				
				JLabel lbltileVang = new JLabel("40/100");
				lbltileVang.setFont(new Font("Dialog", Font.BOLD, 25));
				lbltileVang.setBounds(36, 37, 84, 58);
				panel_4.add(lbltileVang);
				
				JLabel lblVang = new JLabel("0.0%");
				lblVang.setForeground(Color.BLACK);
				lblVang.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblVang.setBounds(199, 61, 55, 16);
				panel_4.add(lblVang);
				
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
				
				JLabel lbltileBac = new JLabel("5/10");
				lbltileBac.setFont(new Font("Dialog", Font.BOLD, 25));
				lbltileBac.setBounds(28, 37, 70, 58);
				panel_1_1.add(lbltileBac);
				
				JLabel lblBac = new JLabel("0.0%");
				lblBac.setForeground(Color.BLACK);
				lblBac.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblBac.setBounds(125, 61, 55, 16);
				panel_1_1.add(lblBac);
				
				JLabel lblNewLabel_15 = new JLabel("Top 5 Khách Hàng tiềm năng");
				lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNewLabel_15.setBounds(30, 202, 286, 25);
				panel_3.add(lblNewLabel_15);
				
				String[] col = new String[] {"Mã Khách Hàng", "Họ tên","Điểm", "Hạng"};
				headerFont = new Font("Tahoma", Font.PLAIN, 20);
				
		        model = new DefaultTableModel(col, 0);
		           
		           
				panel_3.setLayout(null);
				
				
			
			
				tableNV = new JTable(model);
//				tableNV.setTableHeader(tableNV.getTableHeader());
				tableNV.getTableHeader().setFont(headerFont);
				tableNV.getTableHeader().setReorderingAllowed(false);
				tableNV.getTableHeader().setResizingAllowed(false);
				
				
				tableNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tableNV.setRowHeight(30);
				
				JScrollPane paneKH = new JScrollPane(tableNV);
				paneKH.setBounds(7, 231, 623, 229);
				panel_3.add(paneKH);
		Frame.add(panel_Center_Right);
		
		
		txtSLKH.setText(dsKH.size()+"");
		int slTT = 0;
		for (KhachHang kh : dsKH) {
			if (kh.getHang().equals("Gold")||kh.getHang().equals("Silver")) {
				slTT++;
			}
		}
		txtThanThiet.setText(slTT+"");
		int slNam = 0;
		int slNu = 0;
		for (KhachHang kh : dsKH) {
			if (kh.getGioiTinh()==true) {
				slNam++;
			} else {
				slNu++;
			}
		}
		txtNam.setText(slNam+"");
		txtNu.setText(slNu+"");
		int slV = 0;
		int slB = 0;
		for (KhachHang kh : dsKH) {
			if (kh.getHang().equals("Gold")) {
				slV++;
			} else if (kh.getHang().equals("Silver")){
				slB++;
			}
		}
		txtTL.setText(slV+"");
		txtHSL.setText(slB+"");
		int sum = 0;
		for (KhachHang kh : dsKH) {
			int diem = Integer.parseInt(kh.getDiem()+"");
			sum += diem;
		}
		avg = sum/dsKH.size();
		txtTBT.setText(avg+"");
		int max = 0;
		for (KhachHang kh : dsKH) {
			int diem = Integer.parseInt(kh.getDiem()+"");
			if (diem > max) {
				max = diem;
			}
		}
		txtTCN.setText(max+"");
		int min = 100;
		for (KhachHang kh : dsKH) {
			int diem = Integer.parseInt(kh.getDiem()+"");
			if (diem < min) {
				min = diem;
			}
		}
		txtTTN.setText(min+"");
		int sum1 = 0;
		for (KhachHang kh : dsKH) {
			sum1 += ChronoUnit.YEARS.between(kh.getNgaySinh(), LocalDate.now());
		}
		int avg1 = sum1/dsKH.size();
		txtavgTuoi.setText(avg1+"");
		
		lbltileTT.setText(slTT+"/"+dsKH.size());
		lblTT.setText((slTT*100/dsKH.size())+"%");
        lbltileNam.setText(slNam+"/"+dsKH.size());
        lblNam.setText((slNam*100/dsKH.size())+"%");
        lbltileNu.setText(slNu+"/"+dsKH.size());
        lblNu.setText((100-slNam*100/dsKH.size())+"%");
        lbltileVang.setText(slV+"/"+dsKH.size());
        lblVang.setText((slV*100/dsKH.size())+"%");
        lbltileBac.setText(slB+"/"+dsKH.size());
        lblBac.setText((slB*100/dsKH.size())+"%");
        ArrayList<KhachHang> dsTT = new ArrayList<>();
        for (KhachHang kh : dsKH) {
			if (kh.getHang().equals("Gold") || kh.getHang().equals("Silver")) {
				dsTT.add(kh);
			}
        }
        dsTT.sort(new Comparator<KhachHang>() {
        	@Override
            public int compare(KhachHang o1, KhachHang o2) {
        		int diem1 = Integer.parseInt(o1.getDiem()+"");
        		int diem2 = Integer.parseInt(o2.getDiem()+"");
                return diem2 - diem1;
            }});
        		
        for (int i = 0; i < 5; i++) {
        	model.addRow(new Object[] {dsTT.get(i).getmaKH(), dsTT.get(i).getHoTen(), dsTT.get(i).getDiem(), dsTT.get(i).getHang()});
        }
        
        //vẽ biểu đồ thống kê hình tròn số lương khách hàng
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Khách hàng thân thiết", slTT);
        dataset.setValue("Khách hàng mới", dsKH.size()-slTT);
        JFreeChart chart = ChartFactory.createPieChart("Thống kê số lượng khách hàng", dataset, true, true, false);
        
        PiePlot plot = (PiePlot) chart.getPlot();
        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setBounds(200,20, 200, 300);
        chartPanel.setPreferredSize(new Dimension(900, 400));
        //set them so luong khach hang tren hinh tron
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {1} ({2})"));
        panelBieuDo.add(chartPanel);
        
        //vẽ biểu đồ thống kê hình tròn số lương khách hàng
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        dataset1.setValue("Nam", slNam);
        dataset1.setValue("Nữ", slNu);
        JFreeChart chart1 = ChartFactory.createPieChart("Thống kê số lượng khách hàng", dataset1, true, true, false);
        PiePlot plot1 = (PiePlot) chart1.getPlot();
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        chartPanel1.setPreferredSize(new Dimension(900, 400));
        //set them so luong khach hang tren hinh tron
        plot1.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {1} ({2})"));
        panelBieuDo.add(chartPanel1);
        
        //vẽ biểu đồ thống kê hình tròn số lương khách hàng
        DefaultPieDataset dataset2 = new DefaultPieDataset();
        dataset2.setValue("Khách hàng Vàng", slV);
        dataset2.setValue("Khách hàng Bạc", slB);
        dataset2.setValue("Khách hàng Đồng", dsKH.size()-slV-slB);
        JFreeChart chart2 = ChartFactory.createPieChart("Thống kê số lượng khách hàng", dataset2, true, true, false);
        PiePlot plot2 = (PiePlot) chart2.getPlot();
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        chartPanel2.setPreferredSize(new Dimension(900, 400));
        //set them so luong khach hang tren hinh tron
        plot2.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {1} ({2})"));
        //set color
        plot2.setSectionPaint("Khách hàng Vàng", Color.YELLOW);
        plot2.setSectionPaint("Khách hàng Bạc", Color.GRAY);
        plot2.setSectionPaint("Khách hàng Đồng", Color.BLUE);
        panelBieuDo.add(chartPanel2);
        
        
        
        //vẽ biểu đồ cột tuổi khách hàng
        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
        int i = 0;
		for (KhachHang kh : dsKH) {
			i++;
			dataset3.addValue(ChronoUnit.YEARS.between(kh.getNgaySinh(), LocalDate.now()), "Tuổi", i + "");
		}
		JFreeChart chart3 = ChartFactory.createBarChart("Tuổi khách hàng", "Tên khách hàng", "Tuổi", dataset3, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot plot3 = chart3.getCategoryPlot();
		plot3.setRangeGridlinePaint(Color.BLACK);
		ChartPanel chartPanel3 = new ChartPanel(chart3);
		chartPanel3.setPreferredSize(new Dimension(900, 400));
		//set color
	    plot3.getRenderer().setSeriesPaint(0, Color.BLUE);
	    panelBieuDo.add(chartPanel3);
	    
	    //vẽ biểu đồ cột điểm khách hàng
		DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();
		int j = 0;
		for (KhachHang kh : dsKH) {
			j++;
			int diem = Integer.parseInt(kh.getDiem()+"");
			dataset4.addValue(diem, "Điểm", j + "");
		}
		JFreeChart chart4 = ChartFactory.createBarChart("Điểm khách hàng", "Tên khách hàng", "Điểm", dataset4, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot plot4 = chart4.getCategoryPlot();
		plot4.setRangeGridlinePaint(Color.BLACK);
		ChartPanel chartPanel4 = new ChartPanel(chart4);
		chartPanel4.setPreferredSize(new Dimension(900, 400));
		// set color
		plot4.getRenderer().setSeriesPaint(0, Color.RED);
		panelBieuDo.add(chartPanel4);

		
        
        
        
        
        
		ActionListener actionListener = new ActionListener() {
            private GUI_QuanLiNhanVien qlnv;

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
				}};
				
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

	

	
	public void populateComboBox(JComboBox<String> yearComboBox) {
		int startYear = 2012;
	    int currentYear = java.time.Year.now().getValue();

        // Thêm các năm từ startYear đến endYear vào combobox
        for (int i = startYear; i <= currentYear; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
    }
}