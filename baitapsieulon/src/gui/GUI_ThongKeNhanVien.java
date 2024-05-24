package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.VerticalAlignment;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;



public class GUI_ThongKeNhanVien extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTable table;
	private DefaultTableModel modelHD;
	private DefaultTableModel modelDT;
	private JTextField txtTNV;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtNL;
	private JLabel lblNghiViec;
	private JComboBox cbNM;
	private JComboBox cbNVM;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_12;
	private JTextField txtNam;
	private JTextField txtNu;
	private JPanel panel_3;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private DefaultTableModel model;
	private JTable tableNV;
	private JTextField txtTBT;
	private JTextField txtSNVTN;
	private JTextField txtTCN;
	private JTextField txtTTN;
	private ArrayList<NhanVien> dsNV;
	private ArrayList<LocalDate> dsT;
	private JComboBox cbDT;
	private JComboBox cbLVT;
	private JComboBox cbTLDT;
	private JLabel lblTiLePtNamNu;
	private JLabel lblTuoiChon;
	private JLabel lblTiLeTuoiChon;
	private ArrayList<NhanVien> dsNVCL;
	private JLabel lblLVT;
	private JButton btnHienBieuDoTLNamNu;
	private JPanel pbd;
	private JPanel pbdduong;
	private JLabel lblTotal;
	private JButton btnNghVic;
	private JButton btnDieuDoTuoi;
	private JButton btnVTr;
	private JButton btnLngTheoV;
	private JPanel pbdd;
	private JButton btnLuongTheoNam;
	private JButton btnLngTheoNam;
	
	
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
                	GUI_ThongKeNhanVien frame = new GUI_ThongKeNhanVien(nv);
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
	public GUI_ThongKeNhanVien(NhanVien nv) {

		try {
			ConnectDB.getInstance().connect();
			} catch (Exception e) {
				e.printStackTrace();
		}
		dsNV = new  ArrayList<NhanVien>();
		dsNV = new NhanVien_DAO().getalltbNhanVien();
		dsNVCL = new ArrayList<NhanVien>();
		dsNVCL = new NhanVien_DAO().getNhanVienConLam();
		
		nhanvien = nv;
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
		
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
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
		btnThngKNhn.setBackground(new Color(164, 194, 163));
		btnThngKNhn.setForeground(new Color(0,0,0));
		btnThngKNhn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnThngKNhn.setBounds(250, 25, 200, 100);
		panel_top.add(btnThngKNhn);
		
		JButton btnKhchHng = new JButton("Khách Hàng");
		btnKhchHng.setForeground(new Color(244, 244, 244));
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnKhchHng.setBackground(new Color(41, 139, 106));
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
		panel_Center_Left.setBounds(257, 156, 673, 885);
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
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u1ED1ng k\u00EA s\u1ED1 l\u01B0\u1EE3ng nh\u00E2n s\u1EF1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_2.setBounds(12, 12, 645, 378);
		panel_Center_Left.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Tổng số nhân viên");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_7.setBounds(24, 35, 134, 16);
		panel_2.add(lblNewLabel_7);
		
		txtTNV = new JTextField();
		txtTNV.setEditable(false);
		txtTNV.setBounds(187, 31, 114, 25);
		panel_2.add(txtTNV);
		txtTNV.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Số nhân viên nghỉ làm");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_8.setBounds(24, 63, 161, 16);
		panel_2.add(lblNewLabel_8);
		
		txtNL = new JTextField();
		txtNL.setEditable(false);
		txtNL.setBounds(187, 59, 114, 25);
		panel_2.add(txtNL);
		txtNL.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nhân sự nam");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(339, 35, 90, 16);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_12 = new JLabel("Nhân sự nữ");
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_12.setBounds(339, 63, 90, 16);
		panel_2.add(lblNewLabel_12);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 96, 294, 124);
		panel_2.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Nghỉ việc");
		lblNewLabel_9.setBounds(28, 9, 119, 16);
		panel.add(lblNewLabel_9);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBounds(0, 2, 10, 122);
		panel.add(panel_2_1_1);
		panel_2_1_1.setBackground(new Color(222, 220, 203));
		
		lblNghiViec = new JLabel();
		lblNghiViec.setText("0");
		lblNghiViec.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNghiViec.setBounds(36, 37, 56, 58);
		panel.add(lblNghiViec);
		cbNVM = new JComboBox();
		cbNVM.setFont(new Font("Dialog", Font.PLAIN, 12));
		cbNVM.setForeground(new Color(0, 0, 0));
		cbNVM.setBackground(new Color(255, 255, 255));
		cbNVM.setBounds(175, 2, 119, 25);
		cbNVM.setUI(new BasicComboBoxUI() {
			protected void installDefaults() {
                super.installDefaults();
                cbNVM.setBorder(BorderFactory.createEmptyBorder());
            }
            protected JButton createArrowButton() {
                // Tạo một JButton tùy chỉnh cho dấu mũi tên
                JButton arrowButton = new JButton();
//                arrowButton.setPreferredSize(new Dimension(20, cbNVM.getPreferredSize().height));
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setContentAreaFilled(false);
                try {
                    // Đường dẫn đến hình ảnh mũi tên
                    File imageFile = new File("src/img/cbbox.jpg");
                    Image arrowImage = ImageIO.read(imageFile);
                    arrowButton.setIcon(new ImageIcon(arrowImage));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return arrowButton;
            }
        });
		populateComboBox(cbNVM);
		
		
		
		
		
			   
		
				panel.add(cbNVM);
				
				JLabel lblTiLeNghi = new JLabel("0.0%");
				lblTiLeNghi.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblTiLeNghi.setForeground(new Color(0, 0, 0));
				lblTiLeNghi.setBounds(104, 63, 85, 16);
				panel.add(lblTiLeNghi);
				
				txtNam = new JTextField();
				txtNam.setEditable(false);
				txtNam.setBounds(461, 31, 101, 25);
				panel_2.add(txtNam);
				txtNam.setColumns(10);
				
				txtNu = new JTextField();
				txtNu.setEditable(false);
				txtNu.setColumns(10);
				txtNu.setBounds(461, 59, 101, 25);
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
				
				JLabel lblTiLeNamNu = new JLabel("0/0");
				lblTiLeNamNu.setFont(new Font("Dialog", Font.BOLD, 25));
				lblTiLeNamNu.setBounds(36, 37, 78, 58);
				panel_1.add(lblTiLeNamNu);
				
				cbNM = new JComboBox();
				cbNM.setFont(new Font("Dialog", Font.PLAIN, 12));
				cbNM.setBackground(Color.WHITE);
				cbNM.setBounds(179, 2, 119, 25);
				cbNM.setUI(new BasicComboBoxUI() {
					protected void installDefaults() {
						super.installDefaults();
						cbNM.setBorder(BorderFactory.createEmptyBorder());
					}
					protected JButton createArrowButton() {
            	// Tạo một JButton tùy chỉnh cho dấu mũi tên
						JButton arrowButton = new JButton();
//						arrowButton.setPreferredSize(new Dimension(20, cbNM.getPreferredSize().height));
						arrowButton.setBorder(BorderFactory.createEmptyBorder());
						arrowButton.setContentAreaFilled(false);
						try {
                    // Đường dẫn đến hình ảnh mũi tên
							File imageFile = new File("src/img/cbbox.jpg");
							Image arrowImage = ImageIO.read(imageFile);
                    		arrowButton.setIcon(new ImageIcon(arrowImage));
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					return arrowButton;
					}
				});
				populateComboBox(cbNM);
				panel_1.add(cbNM);
				
				lblTiLePtNamNu = new JLabel("0.0%");
				lblTiLePtNamNu.setForeground(new Color(0, 0, 0));
				lblTiLePtNamNu.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblTiLePtNamNu.setBounds(116, 61, 105, 16);
				panel_1.add(lblTiLePtNamNu);
				
				JLabel lblNewLabel_7_1 = new JLabel("Trung bình tuổi");
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
				
				lblTuoiChon = new JLabel("0");
				lblTuoiChon.setFont(new Font("Dialog", Font.BOLD, 25));
				lblTuoiChon.setBounds(36, 37, 30, 58);
				panel_1_2.add(lblTuoiChon);
				
				cbDT = new JComboBox();
				cbDT.setFont(new Font("Dialog", Font.PLAIN, 12));
				cbDT.setBackground(Color.WHITE);
				cbDT.setBounds(179, 2, 119, 25);
				cbDT.setUI(new BasicComboBoxUI() {
		            protected void installDefaults() {
		                super.installDefaults();
		                cbDT.setBorder(BorderFactory.createEmptyBorder());
		            }
		            protected JButton createArrowButton() {
		                // Tạo một JButton tùy chỉnh cho dấu mũi tên
		                JButton arrowButton = new JButton();
//		                arrowButton.setPreferredSize(new Dimension(20, cbTNV.getPreferredSize().height));
		                arrowButton.setBorder(BorderFactory.createEmptyBorder());
		                arrowButton.setContentAreaFilled(false);
		                try {
		                    // Đường dẫn đến hình ảnh mũi tên
		                    File imageFile = new File("src/img/cbbox.jpg");
		                    Image arrowImage = ImageIO.read(imageFile);
		                    arrowButton.setIcon(new ImageIcon(arrowImage));
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		                return arrowButton;
		            }
		        });
				panel_1_2.add(cbDT);
				
				lblTiLeTuoiChon = new JLabel("0.0%");
				lblTiLeTuoiChon.setForeground(Color.BLACK);
				lblTiLeTuoiChon.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblTiLeTuoiChon.setBounds(78, 63, 55, 16);
				panel_1_2.add(lblTiLeTuoiChon);
				
				JLabel lblNewLabel_9_1_3 = new JLabel("Độ tuổi");
				lblNewLabel_9_1_3.setBounds(28, 9, 85, 16);
				panel_1_2.add(lblNewLabel_9_1_3);
				
				txtTBT = new JTextField();
				txtTBT.setColumns(10);
				txtTBT.setBounds(192, 230, 114, 25);
				txtTBT.setEditable(false);
				panel_2.add(txtTBT);
				
				
				JLabel lblNewLabel_7_1_1 = new JLabel("Thâm niên (Trên 5 năm)");
				lblNewLabel_7_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1_1.setBounds(24, 268, 171, 16);
				panel_2.add(lblNewLabel_7_1_1);
				
				JLabel lblNewLabel_7_1_1_1 = new JLabel("Tuổi cao nhất");
				lblNewLabel_7_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1_1_1.setBounds(24, 304, 171, 16);
				panel_2.add(lblNewLabel_7_1_1_1);
				
				txtSNVTN = new JTextField();
				txtSNVTN.setEditable(false);
				txtSNVTN.setColumns(10);
				txtSNVTN.setBounds(192, 264, 114, 25);
				panel_2.add(txtSNVTN);
				
				txtTCN = new JTextField();
				txtTCN.setColumns(10);
				txtTCN.setBounds(192, 298, 114, 25);
				txtTCN.setEditable(false);
				panel_2.add(txtTCN);
				// Lấy danh sách tuổi của nhân viên

				
				
				JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Tuổi thấp nhất");
				lblNewLabel_7_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_7_1_1_1_1.setBounds(24, 340, 171, 16);
				panel_2.add(lblNewLabel_7_1_1_1_1);
				
				txtTTN = new JTextField();
				txtTTN.setColumns(10);
				txtTTN.setBounds(192, 332, 114, 25);
				txtTTN.setEditable(false);
			
				panel_2.add(txtTTN);
				
				panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(new CompoundBorder(null, new LineBorder(new Color(99, 130, 191))), "Th\u1ED1ng k\u00EA L\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_3.setBounds(12, 402, 645, 471);
				panel_Center_Left.add(panel_3);
				panel_3.setLayout(null);
				
				lblNewLabel_13 = new JLabel("Tổng chi cho lương");
				lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_13.setBounds(30, 31, 131, 16);
				panel_3.add(lblNewLabel_13);
				
				lblNewLabel_14 = new JLabel("Vị trí");
				lblNewLabel_14.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_14.setBounds(332, 31, 122, 16);
				panel_3.add(lblNewLabel_14);
				
				JPanel panel_4 = new JPanel();
				panel_4.setLayout(null);
				panel_4.setBackground(Color.WHITE);
				panel_4.setBounds(10, 66, 294, 124);
				panel_3.add(panel_4);
				
				JLabel lblNewLabel_9_2 = new JLabel("Tổng lương theo năm");
				lblNewLabel_9_2.setBounds(28, 9, 147, 16);
				panel_4.add(lblNewLabel_9_2);
				
				JPanel panel_2_1_1_2 = new JPanel();
				panel_2_1_1_2.setBackground(new Color(222, 220, 203));
				panel_2_1_1_2.setBounds(0, 2, 10, 122);
				panel_4.add(panel_2_1_1_2);
				
				JLabel lblTongLuong = new JLabel("0");
				lblTongLuong.setForeground(new Color(255, 0, 0));
				lblTongLuong.setFont(new Font("Dialog", Font.BOLD, 25));
				lblTongLuong.setBounds(36, 37, 159, 58);
				panel_4.add(lblTongLuong);
				
				cbTLDT = new JComboBox();
				cbTLDT.setFont(new Font("Dialog", Font.PLAIN, 12));
				cbTLDT.setBackground(Color.WHITE);
				cbTLDT.setBounds(179, 5, 115, 25);
				cbTLDT.setUI(new BasicComboBoxUI() {
		            protected void installDefaults() {
		                super.installDefaults();
		                cbTLDT.setBorder(BorderFactory.createEmptyBorder());
		            }
		            protected JButton createArrowButton() {
		                // Tạo một JButton tùy chỉnh cho dấu mũi tên
		                JButton arrowButton = new JButton();
//		                arrowButton.setPreferredSize(new Dimension(20, cbTNV.getPreferredSize().height));
		                arrowButton.setBorder(BorderFactory.createEmptyBorder());
		                arrowButton.setContentAreaFilled(false);
		                try {
		                    // Đường dẫn đến hình ảnh mũi tên
		                    File imageFile = new File("src/img/cbbox.jpg");
		                    Image arrowImage = ImageIO.read(imageFile);
		                    arrowButton.setIcon(new ImageIcon(arrowImage));
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		                return arrowButton;
		            }
		        });
				panel_4.add(cbTLDT);
				
				JLabel lblNewLabel_11_2 = new JLabel("VND");
				lblNewLabel_11_2.setForeground(Color.BLACK);
				lblNewLabel_11_2.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNewLabel_11_2.setBounds(199, 61, 55, 16);
				panel_4.add(lblNewLabel_11_2);
				
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setLayout(null);
				panel_1_1.setBackground(Color.WHITE);
				panel_1_1.setBounds(332, 66, 298, 124);
				panel_3.add(panel_1_1);
				
				JLabel lblNewLabel_9_1_1 = new JLabel("Lương chi theo vị trí");
				lblNewLabel_9_1_1.setBounds(28, 9, 135, 16);
				panel_1_1.add(lblNewLabel_9_1_1);
				
				JPanel panel_2_1_1_1_1 = new JPanel();
				panel_2_1_1_1_1.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1_1.setBounds(0, 2, 10, 122);
				panel_1_1.add(panel_2_1_1_1_1);
				
				lblLVT = new JLabel("0");
				lblLVT.setFont(new Font("Dialog", Font.BOLD, 25));
				lblLVT.setBounds(36, 37, 127, 58);
				panel_1_1.add(lblLVT);
				
				JLabel lblNewLabel_11_1_1 = new JLabel("VND");
				lblNewLabel_11_1_1.setForeground(Color.BLACK);
				lblNewLabel_11_1_1.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblNewLabel_11_1_1.setBounds(174, 61, 55, 16);
				panel_1_1.add(lblNewLabel_11_1_1);
				
				cbLVT = new JComboBox();
				cbLVT.setFont(new Font("Dialog", Font.PLAIN, 12));
				cbLVT.setForeground(new Color(0, 0, 0));
				cbLVT.setBackground(Color.WHITE);
				cbLVT.setBounds(156, 5, 142, 25);
				cbLVT.setUI(new BasicComboBoxUI() {
		            protected void installDefaults() {
		                super.installDefaults();
		                cbLVT.setBorder(BorderFactory.createEmptyBorder());
		            }
		            protected JButton createArrowButton() {
		                // Tạo một JButton tùy chỉnh cho dấu mũi tên
		                JButton arrowButton = new JButton();
//		                arrowButton.setPreferredSize(new Dimension(20, cbTNV.getPreferredSize().height));
		                arrowButton.setBorder(BorderFactory.createEmptyBorder());
		                arrowButton.setContentAreaFilled(false);
		                try {
		                    // Đường dẫn đến hình ảnh mũi tên
		                    File imageFile = new File("src/img/cbbox.jpg");
		                    Image arrowImage = ImageIO.read(imageFile);
		                    arrowButton.setIcon(new ImageIcon(arrowImage));
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		                return arrowButton;
		            }
		        });
				cbLVT.addItem("Nhân viên tiếp tân");
				cbLVT.addItem("Nhân viên bếp");
				cbLVT.addItem("Nhân viên bảo vệ");
				cbLVT.addItem("Nhân viên phục vụ");
				panel_1_1.add(cbLVT);
				
				JLabel lblNewLabel_15 = new JLabel("Top 5 nhân sự  lương cao nhất");
				lblNewLabel_15.setBounds(30, 202, 200, 16);
				panel_3.add(lblNewLabel_15);
				
				String[] colNV = new String[] {"Mã nhân viên", "Họ tên","Hệ số lương", "Tổng lương"};
				
		        model = new DefaultTableModel(colNV, 0);
		        
				panel_3.setLayout(null);
				
			
			
				tableNV = new JTable(model);
				JScrollPane paneNV = new JScrollPane(tableNV);
				paneNV.setBounds(10, 230, 623, 210);
				panel_3.add(paneNV);
		Frame.add(panel_Center_Right);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Bi\u1EC3u \u0111\u1ED3 c\u01A1 c\u1EA5u nh\u00E2n s\u1EF1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setForeground(new Color(255, 255, 255));
		panel_5.setBounds(25, 22, 912, 408);
		panel_Center_Right.add(panel_5);
		panel_5.setLayout(null);
		
		btnHienBieuDoTLNamNu = new JButton("Tỉ lệ nam/nữ");
		btnHienBieuDoTLNamNu.setBackground(new Color(234, 232, 214));
		btnHienBieuDoTLNamNu.setBounds(52, 36, 152, 26);
		panel_5.add(btnHienBieuDoTLNamNu);
		
		btnNghVic = new JButton("Nghỉ Việc");
		btnNghVic.setBackground(new Color(234, 232, 214));
		btnNghVic.setBounds(217, 36, 152, 26);
		panel_5.add(btnNghVic);
		
		btnDieuDoTuoi = new JButton("Tuổi");
		btnDieuDoTuoi.setBackground(new Color(234, 232, 214));
		btnDieuDoTuoi.setBounds(382, 36, 152, 26);
		panel_5.add(btnDieuDoTuoi);
		
		btnVTr = new JButton("Vị trí");
		btnVTr.setBackground(new Color(234, 232, 214));
		btnVTr.setBounds(546, 36, 152, 26);
		panel_5.add(btnVTr);
		
		pbd = new JPanel();
		pbd.setBackground(new Color(255, 255, 255));
		pbd.setBounds(69, 89, 310, 280);
		
		panel_5.add(pbd);
		pbd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblTotal = new JLabel("");
		lblTotal.setBounds(121, 127, 60, 26);
		
		
		pbdduong = new JPanel();
		pbdduong.setBackground(Color.WHITE);
		pbdduong.setBounds(456, 89, 396, 307);
		panel_5.add(pbdduong);
//		pbd.setLayout(null);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setForeground(Color.WHITE);
		panel_5_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Bi\u1EC3u \u0111\u1ED3 l\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(25, 442, 912, 431);
		panel_Center_Right.add(panel_5_1);
		
		btnLngTheoV = new JButton("Lương theo vị trí");
		btnLngTheoV.setBackground(new Color(234, 232, 214));
		btnLngTheoV.setBounds(52, 36, 152, 26);
		panel_5_1.add(btnLngTheoV);
		
		btnLngTheoNam = new JButton("Lương theo năm");
		btnLngTheoNam.setBackground(new Color(234, 232, 214));
		btnLngTheoNam.setBounds(216, 36, 152, 26);
		panel_5_1.add(btnLngTheoNam);
		
		pbdd = new JPanel();
		pbdd.setBackground(new Color(255, 255, 255));
		pbdd.setBounds(69, 82, 788, 337);
		panel_5_1.add(pbdd);
		Frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Ẩn btnXTT và btnDX khi click ra ngoài
                panelTK.setVisible(false);
                // Hiển thị btnTK
                btnTK.setVisible(true);
            }
        });
		setDuLieuSoLuong();
		ht5NhanSuLuongCaoNhat();
	
		cbNVM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nam = (String) cbNVM.getSelectedItem();
				int count = 0;
				// Lấy danh sách nhân viên vào làm trước năm nam
				ArrayList<Integer> listConLam = new ArrayList<>();
				for (int i = 0; i < dsNV.size(); i++) {
					if (dsNV.get(i).getNgayVaoLam().getYear() < Integer.parseInt(nam)) {
						listConLam.add(i);
					}
					
				}
				// duyệt danh sách listConLam, tìm nhân viên nghỉ làm
				for (int i = 0; i < listConLam.size(); i++) {
					if (dsNV.get(listConLam.get(i)).getNgayNghiLam() != null) {
						if (dsNV.get(listConLam.get(i)).getNgayNghiLam().getYear() < Integer.parseInt(nam)) {
							count++;
						}
					}
				}
				// hiển thị số nhân viên nghỉ làm
				lblNghiViec.setText(count + "");
				// tính tỉ lệ, làm tròn 1 chữ số
				double tl = (double) count / listConLam.size() * 100;
				tl = Math.round(tl * 10) / 10.0;
				// hiển thị tỉ lệ
				lblTiLeNghi.setText(tl + "%");
				
				
			}
		});
		cbNM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nam = (String) cbNM.getSelectedItem();
				System.out.println(nam);
				int countNam = 0;
				int countNu = 0;
				ArrayList<Integer> listConLam = new ArrayList<>();
				// Lấy danh sách nhân viên còn làm cho đến năm nam
				for (int i = 0; i < dsNV.size(); i++) {
					if (dsNV.get(i).getNgayVaoLam().getYear() < Integer.parseInt(nam)) {
						if (dsNV.get(i).getNgayNghiLam() != null) {
							if (dsNV.get(i).getNgayNghiLam().getYear() >= Integer.parseInt(nam)) {
								System.out.println(dsNV.get(i).getMaNV());
								listConLam.add(i);
							}
						} else {
							listConLam.add(i);
						}
					}
					
				}
				// Tìm số nhân viên nam trong listConLam
				for (int i = 0; i < listConLam.size(); i++) {
					if (dsNV.get(listConLam.get(i)).isGioiTinh() == true) {
						countNam++;
					}
				}
				// Tìm số nhân viên nữ trong listConLam
				countNu = listConLam.size() - countNam;
				// hiển thị tỉ lệ nam nữ
				lblTiLeNamNu.setText(countNam + "/" + countNu);
				// tính tỉ lệ, làm tròn 1 chữ số
				double tl = (double) countNam / listConLam.size() * 100;
				tl = Math.round(tl * 10) / 10.0;
				// hiển thị tỉ lệ
				lblTiLePtNamNu.setText(tl + "%" + " (nam)");
				
			}
		});
		// Cập nhật dữ liệu cho combobox cbDT
		for (int i = 18; i < 65; i++) {
			cbDT.addItem(i + "");
		}
		cbDT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//Lấy tuổi được chọn
				String tuoi = (String) cbDT.getSelectedItem();
				// Lấy danh sách tuổi của nhân viên
				ArrayList<LocalDate> birthdays = new ArrayList<>();
				for (int i = 0; i < dsNV.size(); i++) {
					birthdays.add(dsNV.get(i).getNgaySinh());
				}
				// Đếm số nhân viên có tuổi tuoi
				int count = 0;
				for (int i = 0; i < birthdays.size(); i++) {
					if (birthdays.get(i).until(LocalDate.now()).getYears() == Integer.parseInt(tuoi)) {
						count++;
					}
				}
				// hiển thị số nhân viên có tuổi tuoi
				lblTuoiChon.setText(count + "");
				//Tính tỉ lệ độ tuổi đó
				double tl = (double) count / dsNV.size() * 100;
				tl = Math.round(tl * 10) / 10.0;
				// hiển thị tỉ lệ
				lblTiLeTuoiChon.setText(tl + "%");
            }
		});
		// Cập nhật dữ liệu cho combobox cbHSL
		populateComboBox(cbTLDT);
		cbTLDT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nam = (String) cbTLDT.getSelectedItem();
				ArrayList<Integer> listConLam = new ArrayList<>();
				// Lấy danh sách nhân viên còn làm cho đến năm nam
				for (int i = 0; i < dsNV.size(); i++) {
					if (dsNV.get(i).getNgayVaoLam().getYear() < Integer.parseInt(nam)) {
						if (dsNV.get(i).getNgayNghiLam() != null) {
							if (dsNV.get(i).getNgayNghiLam().getYear() >= Integer.parseInt(nam)) {
								System.out.println(dsNV.get(i).getMaNV());
								listConLam.add(i);
							}
						} else {
							listConLam.add(i);
						}
					}
				}
				// Tính tổng lương của nhân viên còn làm
				double tongLuong = 0;
				for (int i = 0; i < listConLam.size(); i++) {
					tongLuong += dsNV.get(listConLam.get(i)).getTongLuong() * 12;
				}
				// set format cho tongLuong
				double tongLuongTi = tongLuong / 1_000_000_000.0;

				// Định dạng giá trị kết quả
				DecimalFormat df = new DecimalFormat("#,##0.00");
				String formattedTongLuongTi = df.format(tongLuongTi);

				// Hiển thị tổng lương đã định dạng kèm chữ " tỉ"
				lblTongLuong.setText(formattedTongLuongTi + " tỉ");
				
			}
		});
		cbLVT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String vt = (String) cbLVT.getSelectedItem();
				ArrayList<Integer> listVT = new ArrayList<>();
				// Tìm nhân viên theo vị trí giống vt
				for (int i = 0; i < dsNVCL.size(); i++) {
					if (dsNVCL.get(i).getViTri().equals(vt)) {
						listVT.add(i);
					}
				}
				// Tính tổng lương listVT
				double tongLuong = 0;
				for (int i = 0; i < listVT.size(); i++) {
					//Kiểm tra ngày vào làm của nhân viên có nằm trong năm hiện tại không
					if (dsNVCL.get(listVT.get(i)).getNgayVaoLam().getYear() < LocalDate.now().getYear()) {
						tongLuong += dsNVCL.get(listVT.get(i)).getTongLuong() * 12;
					}
					else {
						//Đếm số tháng nhân viên đã làm trong năm hiện tại
						int soThangLam = 12 - dsNVCL.get(listVT.get(i)).getNgayVaoLam().getMonthValue();
						tongLuong += dsNVCL.get(listVT.get(i)).getTongLuong() * soThangLam;
					}
				}
				// set format cho tongLuong
			    double tongLuongTi = tongLuong / 1_000_000_000.0;
			    DecimalFormat df = new DecimalFormat("#,##0.00");
			    String formattedTongLuongTi = df.format(tongLuongTi);
			    lblLVT.setText(formattedTongLuongTi + " tỉ");
			}
		});
		btnHienBieuDoTLNamNu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultPieDataset dataset1 = createDataset();
				JFreeChart chart1 = createChartTiLeNamNu(dataset1);
				chart1.setBackgroundPaint(Color.WHITE);
				ChartPanel chartPanel1 = new ChartPanel(chart1);
				chartPanel1.setPreferredSize(new Dimension(310, 280));
				chartPanel1.setBackground(Color.WHITE);
				chartPanel1.setBorder(null);
				pbd.removeAll();
				pbd.add(chartPanel1);
				pbd.revalidate();
				pbd.repaint();
				
				DefaultCategoryDataset dataset2 = createDataset2();
				JFreeChart chart2 = createChartTiLeNamNu2(dataset2);
				chart2.setBackgroundPaint(Color.WHITE);
				ChartPanel chartPanel2 = new ChartPanel(chart2);
				chartPanel2.setPreferredSize(new Dimension(396, 280));
				chartPanel2.setBackground(Color.WHITE);
				chartPanel2.setBorder(null);
				pbdduong.removeAll();
				pbdduong.add(chartPanel2);
				pbdduong.revalidate();
				pbdduong.repaint();
				
				
			}
			// Tạo dữ liệu cho biểu đồ tỉ lệ nam/nữ
			private DefaultPieDataset createDataset() {
		        DefaultPieDataset dataset = new DefaultPieDataset();
		        int countNam = 0;
		        for (int i = 0; i < dsNVCL.size(); i++) {
		        	if(dsNVCL.get(i).isGioiTinh() == true) {
		        		countNam++;
	            	}
		        }
		        dataset.setValue("Nam", countNam);
		        dataset.setValue("Nữ", dsNVCL.size() - countNam);
		        return dataset;
			}
			// Tạo biểu đồ tỉ lệ nam/nữ
			private JFreeChart createChartTiLeNamNu(PieDataset dataset) {
			    CustomRingPlot plot = new CustomRingPlot(dataset, String.valueOf(dsNVCL.size()));
			    plot.setSectionPaint("Nam", new Color(144, 238, 144));
			    plot.setSectionPaint("Nữ", new Color(255, 144, 144));
			    plot.setSimpleLabels(true);
			    plot.setInsets(new RectangleInsets(0, 5, 5, 5));
			    plot.setSectionDepth(0.50); 
			    plot.setBackgroundPaint(Color.WHITE);
			    plot.setShadowPaint(null);
			    plot.setOutlineVisible(false);
			    plot.setLabelGenerator(null);

			    JFreeChart chart = new JFreeChart(
			            "Tỉ lệ nam/nữ hiện tại", JFreeChart.DEFAULT_TITLE_FONT, plot, true
			    );

			    // Hiển thị phần trăm
			    LegendTitle legend = chart.getLegend();
			    legend.setPosition(RectangleEdge.BOTTOM);

			    chart.setBackgroundPaint(Color.WHITE);

			    return chart;
			}

			private DefaultCategoryDataset createDataset2() {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				int countNam;
				int countNu;
				for(int j = 2018; j <= 2024; j++) {
					countNam = 0;
					countNu = 0;
					ArrayList<Integer> listConLam = new ArrayList<>();
					// Lấy danh sách nhân viên còn làm cho đến năm nam
					for (int i = 0; i < dsNV.size(); i++) {
						if (dsNV.get(i).getNgayVaoLam().getYear() < j) {
							if (dsNV.get(i).getNgayNghiLam() != null) {
								if (dsNV.get(i).getNgayNghiLam().getYear() >= j) {
									System.out.println(dsNV.get(i).getMaNV());
									listConLam.add(i);
								}
							} else {
								listConLam.add(i);
							}
						}
						
					}
					// Tìm số nhân viên nam trong listConLam
					for (int i = 0; i < listConLam.size(); i++) {
						if (dsNV.get(listConLam.get(i)).isGioiTinh() == true) {
							countNam++;
						}
					}
					// Tìm số nhân viên nữ trong listConLam
					countNu = listConLam.size() - countNam;
					dataset.addValue(countNam, "Nam", String.valueOf(j));
			        dataset.addValue(countNu, "Nữ", String.valueOf(j));
				}
				return dataset;
			}

			private JFreeChart createChartTiLeNamNu2(CategoryDataset dataset) {
				JFreeChart chart = ChartFactory.createLineChart("Tỉ lệ nam/nữ qua từng năm", // chart title
						"Năm", // domain axis label
						"Số lượng", // range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						true, // include legend
						true, // tooltips
						false // urls
				);
				chart.setBackgroundPaint(Color.WHITE);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setBackgroundPaint(Color.WHITE);
				plot.setRangeGridlinePaint(Color.BLACK);
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
				renderer.setSeriesStroke(0, new BasicStroke(3.0f));
				renderer.setSeriesStroke(1, new BasicStroke(3.0f));
				renderer.setSeriesPaint(0, new Color(144, 238, 144));
				renderer.setSeriesPaint(1, new Color(255, 144, 144));
				return chart;
			}

			
		});
		btnNghVic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultPieDataset dataset = createDatasetNghiViec1();
				JFreeChart chart = createChartNghiViec(dataset);
				chart.setBackgroundPaint(Color.WHITE);
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(310, 280));
				chartPanel.setBackground(Color.WHITE);
				chartPanel.setBorder(null);
				pbd.removeAll();
				pbd.add(chartPanel);
				pbd.revalidate();
				pbd.repaint();
				
				DefaultCategoryDataset dataset2 = createDatasetNghiViec2();
				JFreeChart chart2 = createChartNghiViec2(dataset2);
				chart2.setBackgroundPaint(Color.WHITE);
				ChartPanel chartPanel2 = new ChartPanel(chart2);
				chartPanel2.setPreferredSize(new Dimension(396, 280));
				chartPanel2.setBackground(Color.WHITE);
				chartPanel2.setBorder(null);
				pbdduong.removeAll();
				pbdduong.add(chartPanel2);
				pbdduong.revalidate();
				pbdduong.repaint();
			}

			private DefaultPieDataset createDatasetNghiViec1() {
				DefaultPieDataset dataset = new DefaultPieDataset();
				int count = 0;
				for (int i = 0; i < dsNV.size(); i++) {
					if (dsNV.get(i).getNgayNghiLam() != null) {
						count++;
					}
				}
				dataset.setValue("Nghỉ", count);
				dataset.setValue("Còn", dsNV.size() - count);
				return dataset;
			}
			
			private JFreeChart createChartNghiViec(PieDataset dataset) {
				CustomRingPlot plot = new CustomRingPlot(dataset, String.valueOf(dsNV.size()));
				plot.setSectionPaint("Nghỉ", new Color(144, 238, 144));
				plot.setSectionPaint("Còn", new Color(255, 144, 144));
				plot.setSimpleLabels(true);
				plot.setInsets(new RectangleInsets(0, 5, 5, 5));
				plot.setSectionDepth(0.50);
				plot.setBackgroundPaint(Color.WHITE);
				plot.setShadowPaint(null);
				plot.setOutlineVisible(false);
				plot.setLabelGenerator(null);

				JFreeChart chart = new JFreeChart("Tỉ lệ nhân viên nghỉ việc", JFreeChart.DEFAULT_TITLE_FONT, plot,
						true);

				// Hiển thị phần trăm
				LegendTitle legend = chart.getLegend();
				legend.setPosition(RectangleEdge.BOTTOM);

				chart.setBackgroundPaint(Color.WHITE);

				return chart;
			}
			
			private DefaultCategoryDataset createDatasetNghiViec2() {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				int countN;
				for(int j = 2019; j< 2024;j++) {
					countN = 0;
					// Lấy danh sách nhân viên vào làm trước năm nam
					ArrayList<Integer> listConLam = new ArrayList<>();
					for (int i = 0; i < dsNV.size(); i++) {
						if (dsNV.get(i).getNgayVaoLam().getYear() < j) {
							listConLam.add(i);
						}
						
					}
					// duyệt danh sách listConLam, tìm nhân viên nghỉ làm
					for (int i = 0; i < listConLam.size(); i++) {
						if (dsNV.get(listConLam.get(i)).getNgayNghiLam() != null) {
							if (dsNV.get(listConLam.get(i)).getNgayNghiLam().getYear() < j) {
								countN++;
							}
						}
					}
					dataset.addValue(countN, "Nghỉ", String.valueOf(j));
				}
				return dataset;
			}
			// Vẽ biểu đồ cột
			private JFreeChart createChartNghiViec2(CategoryDataset dataset) {
			    JFreeChart chart = ChartFactory.createBarChart("Số nhân viên nghỉ việc qua từng năm", // chart title
			            "Năm", // domain axis label
			            "Số lượng", // range axis label
			            dataset, // data
			            PlotOrientation.VERTICAL, // orientation
			            true, // include legend
			            true, // tooltips
			            false // urls
			    );
			    chart.setBackgroundPaint(Color.WHITE);
			    CategoryPlot plot = chart.getCategoryPlot();
			    plot.setBackgroundPaint(Color.WHITE);
			    plot.setRangeGridlinePaint(Color.BLACK);
			    BarRenderer renderer = (BarRenderer) plot.getRenderer();
			    renderer.setBarPainter(new StandardBarPainter());
			    renderer.setSeriesPaint(0, new Color(68, 138, 255));
		        return chart;
			}	
		});
		btnDieuDoTuoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DefaultPieDataset dataset = createDatasetTuoi1();
                JFreeChart chart = createChartTuoi(dataset);
                chart.setBackgroundPaint(Color.WHITE);
                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(310, 280));
                chartPanel.setBackground(Color.WHITE);
                chartPanel.setBorder(null);
                pbd.removeAll();
                pbd.add(chartPanel);
                pbd.revalidate();
                pbd.repaint();
                
                DefaultCategoryDataset dataset2 = createDatasetTuoi2();
                JFreeChart chart2 = createChartTuoi2(dataset2);
                chart2.setBackgroundPaint(Color.WHITE);
                ChartPanel chartPanel2 = new ChartPanel(chart2);
                chartPanel2.setPreferredSize(new Dimension(396, 280));
                chartPanel2.setBackground(Color.WHITE);
                chartPanel2.setBorder(null);
                pbdduong.removeAll();
                pbdduong.add(chartPanel2);
                pbdduong.revalidate();
                pbdduong.repaint();
                
                
            }
            //Lấy dữ liệu cho tuổi
			private DefaultPieDataset createDatasetTuoi1() {
				DefaultPieDataset dataset = new DefaultPieDataset();
				int count25to35 = 0;
				int count35to45 = 0;
				int count45to55 = 0;
				for (int i = 0; i < dsNV.size(); i++) {
					if (dsNV.get(i).getNgaySinh().until(LocalDate.now()).getYears() >= 25
							&& dsNV.get(i).getNgaySinh().until(LocalDate.now()).getYears() < 35) {
						count25to35++;
					} else if (dsNV.get(i).getNgaySinh().until(LocalDate.now()).getYears() >= 35
							&& dsNV.get(i).getNgaySinh().until(LocalDate.now()).getYears() < 45) {
						count35to45++;
					} else if (dsNV.get(i).getNgaySinh().until(LocalDate.now()).getYears() >= 45
							&& dsNV.get(i).getNgaySinh().until(LocalDate.now()).getYears() < 55) {
						count45to55++;
					}
				}
				dataset.setValue("25-35", count25to35);
				dataset.setValue("35-45", count35to45);
				dataset.setValue("45-55", count45to55);
				return dataset;
			}
			// Vẽ biểu đồ tròn
			private JFreeChart createChartTuoi(PieDataset dataset) {
				CustomRingPlot plot = new CustomRingPlot(dataset, String.valueOf(dsNV.size()));
				plot.setSectionPaint("25-35", new Color(144, 238, 144));
				plot.setSectionPaint("35-45", new Color(255, 144, 144));
				plot.setSectionPaint("45-55", new Color(68, 138, 255));
				plot.setSimpleLabels(true);
				plot.setInsets(new RectangleInsets(0, 5, 5, 5));
				plot.setSectionDepth(0.50);
				plot.setBackgroundPaint(Color.WHITE);
				plot.setShadowPaint(null);
				plot.setOutlineVisible(false);
				plot.setLabelGenerator(null);

				JFreeChart chart = new JFreeChart("Tỉ lệ nhân viên theo độ tuổi", JFreeChart.DEFAULT_TITLE_FONT, plot,
						true);

				// Hiển thị phần trăm
				LegendTitle legend = chart.getLegend();
				legend.setPosition(RectangleEdge.BOTTOM);

				chart.setBackgroundPaint(Color.WHITE);

				return chart;
			}
			// set dữ liệu 3 độ tuổi theo từng năm
			private DefaultCategoryDataset createDatasetTuoi2() {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				int count25to35;
				int count35to45;
				int count45to55;
				for (int j = 2018; j < 2024; j++) {
					count25to35 = 0;
					count35to45 = 0;
					count45to55 = 0;
					// Lấy danh sách nhân viên vào làm trước năm nam
					ArrayList<Integer> listConLam = new ArrayList<>();
					for (int i = 0; i < dsNV.size(); i++) {
						if (dsNV.get(i).getNgayVaoLam().getYear() < j) {
							listConLam.add(i);
						}
						
					}
					// duyệt danh sách listConLam
					for (int i = 0; i < listConLam.size(); i++) {
						if (dsNV.get(listConLam.get(i)).getNgaySinh().until(LocalDate.now()).getYears() >= 25
								&& dsNV.get(listConLam.get(i)).getNgaySinh().until(LocalDate.now()).getYears() < 35) {
							count25to35++;
						} else if (dsNV.get(listConLam.get(i)).getNgaySinh().until(LocalDate.now()).getYears() >= 35
								&& dsNV.get(listConLam.get(i)).getNgaySinh().until(LocalDate.now()).getYears() < 45) {
							count35to45++;
						} else if (dsNV.get(listConLam.get(i)).getNgaySinh().until(LocalDate.now()).getYears() >= 45
								&& dsNV.get(listConLam.get(i)).getNgaySinh().until(LocalDate.now()).getYears() < 55) {
							count45to55++;
						}
					}
					dataset.addValue(count25to35, "25-35", String.valueOf(j));
					dataset.addValue(count35to45, "35-45", String.valueOf(j));
					dataset.addValue(count45to55, "45-55", String.valueOf(j));
				}
				return dataset;
			}
			// Vẽ biểu đồ đường
			private JFreeChart createChartTuoi2(CategoryDataset dataset) {
				JFreeChart chart = ChartFactory.createLineChart("Số nhân viên theo độ tuổi qua từng năm", // chart
																												// title
						"Năm", // domain axis label
						"Số lượng", // range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						true, // include legend
						true, // tooltips
						false // urls
				);
				chart.setBackgroundPaint(Color.WHITE);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setBackgroundPaint(Color.WHITE);
				plot.setRangeGridlinePaint(Color.BLACK);
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
				renderer.setSeriesStroke(0, new BasicStroke(3.0f));
				renderer.setSeriesStroke(1, new BasicStroke(3.0f));
				renderer.setSeriesStroke(2, new BasicStroke(3.0f));
				renderer.setSeriesPaint(0, new Color(144, 238, 144));
				renderer.setSeriesPaint(1, new Color(255, 144, 144));
				renderer.setSeriesPaint(2, new Color(68, 138, 255));
				LegendTitle legend = chart.getLegend();
				legend.setPosition(RectangleEdge.RIGHT);
				return chart;
			}

		});
		btnVTr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DefaultPieDataset dataset = createDatasetVTr1();
                JFreeChart chart = createChartVTr(dataset);
                chart.setBackgroundPaint(Color.WHITE);
                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(310, 280));
                chartPanel.setBackground(Color.WHITE);
                chartPanel.setBorder(null);
                pbd.removeAll();
                pbd.add(chartPanel);
                pbd.revalidate();
                pbd.repaint();
                
                DefaultCategoryDataset dataset2 = createDatasetVTr2();
                JFreeChart chart2 = createChartVTr2(dataset2);
                chart2.setBackgroundPaint(Color.WHITE);
                ChartPanel chartPanel2 = new ChartPanel(chart2);
                chartPanel2.setPreferredSize(new Dimension(396, 280));
                chartPanel2.setBackground(Color.WHITE);
                chartPanel2.setBorder(null);
                pbdduong.removeAll();
                pbdduong.add(chartPanel2);
                pbdduong.revalidate();
                pbdduong.repaint();
            }
            //Lấy dữ liệu cho vị trí
            private DefaultPieDataset createDatasetVTr1() {
                DefaultPieDataset dataset = new DefaultPieDataset();
                int countTT = 0;
                int countPV = 0;
                int countBV = 0;
                int countB = 0;
                for (int i = 0; i < dsNVCL.size(); i++) {
                    if (dsNVCL.get(i).getViTri().equals("Nhân viên tiếp tân")) {
                        countTT++;
                    } else if (dsNVCL.get(i).getViTri().equals("Nhân viên phục vụ")) {
                        countPV++;
                    } else if (dsNVCL.get(i).getViTri().equals("Nhân viên bảo vệ")) {
                        countBV++;
                    } else if (dsNVCL.get(i).getViTri().equals("Nhân viên bếp")) {
                        countB++;
                    }
                }
                dataset.setValue("Nhân viên tiếp tân", countTT);
                dataset.setValue("Nhân viên phục vụ", countPV);
                dataset.setValue("Nhân viên bảo vệ", countBV);
                dataset.setValue("Nhân viên bếp", countB);
                return dataset;
            }
            // Vẽ biểu đồ tròn
			private JFreeChart createChartVTr(PieDataset dataset) {
				CustomRingPlot plot = new CustomRingPlot(dataset, String.valueOf(dsNVCL.size()));
				plot.setSectionPaint("Nhân viên tiếp tân", new Color(144, 238, 144));
				plot.setSectionPaint("Nhân viên phục vụ", new Color(255, 144, 144));
				plot.setSectionPaint("Nhân viên bảo vệ", new Color(68, 138, 255));
				plot.setSectionPaint("Nhân viên bếp", new Color(255, 215, 0));
				plot.setSimpleLabels(true);
				plot.setInsets(new RectangleInsets(0, 5, 5, 5));
				plot.setSectionDepth(0.50);
				plot.setBackgroundPaint(Color.WHITE);
				plot.setShadowPaint(null);
				plot.setOutlineVisible(false);
				plot.setLabelGenerator(null);

				JFreeChart chart = new JFreeChart("Tỉ lệ nhân viên theo vị trí", JFreeChart.DEFAULT_TITLE_FONT, plot,
						true);

				// Hiển thị phần trăm
				LegendTitle legend = chart.getLegend();
				legend.setPosition(RectangleEdge.BOTTOM);

				chart.setBackgroundPaint(Color.WHITE);

				return chart;
			}
			// set dữ liệu 4 vị trí theo từng năm
			private DefaultCategoryDataset createDatasetVTr2() {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				int countTT;
				int countPV;
				int countBV;
				int countB;
				for (int j = 2018; j < 2024; j++) {
					countTT = 0;
					countPV = 0;
					countBV = 0;
					countB = 0;
					// Lấy danh sách nhân viên vào làm trước năm nam
					ArrayList<Integer> listConLam = new ArrayList<>();
					for (int i = 0; i < dsNV.size(); i++) {
						if (dsNV.get(i).getNgayVaoLam().getYear() < j) {
							listConLam.add(i);
						}

					}
					// duyệt danh sách listConLam
					for (int i = 0; i < listConLam.size(); i++) {
						if (dsNV.get(listConLam.get(i)).getViTri().equals("Nhân viên tiếp tân")) {
							countTT++;
						} else if (dsNV.get(listConLam.get(i)).getViTri().equals("Nhân viên phục vụ")) {
							countPV++;
						} else if (dsNV.get(listConLam.get(i)).getViTri().equals("Nhân viên bảo vệ")) {
							countBV++;
						} else if (dsNV.get(listConLam.get(i)).getViTri().equals("Nhân viên bếp")) {
							countB++;
						}
					}
					dataset.addValue(countTT, "Nhân viên tiếp tân", String.valueOf(j));
					dataset.addValue(countPV, "Nhân viên phục vụ", String.valueOf(j));
					dataset.addValue(countBV, "Nhân viên bảo vệ", String.valueOf(j));
					dataset.addValue(countB, "Nhân viên bếp", String.valueOf(j));
				}
				return dataset;
			}
			// Vẽ biểu đồ đường
			private JFreeChart createChartVTr2(CategoryDataset dataset) {
				JFreeChart chart = ChartFactory.createLineChart("Số nhân nhân viên theo vị trí qua từng năm", // chart
						// title
						"Năm", // domain axis label
						"Số lượng", // range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						true, // include legend
						true, // tooltips
						false // urls
				);
				chart.setBackgroundPaint(Color.WHITE);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setBackgroundPaint(Color.WHITE);
				plot.setRangeGridlinePaint(Color.BLACK);
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
				renderer.setSeriesStroke(0, new BasicStroke(3.0f));
				renderer.setSeriesStroke(1, new BasicStroke(3.0f));
				renderer.setSeriesStroke(2, new BasicStroke(3.0f));
				renderer.setSeriesStroke(3, new BasicStroke(3.0f));
				renderer.setSeriesPaint(0, new Color(144, 238, 144));
				renderer.setSeriesPaint(1, new Color(255, 144, 144));
				renderer.setSeriesPaint(2, new Color(68, 138, 255));
				renderer.setSeriesPaint(3, new Color(255, 215, 0));
				LegendTitle legend = chart.getLegend();
				legend.setPosition(RectangleEdge.RIGHT);
				return chart;
			}
         });
		btnLngTheoV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DefaultPieDataset dataset = createDatasetLuongTheoVT1();
                JFreeChart chart = createChartLuongTheoVT(dataset);
                chart.setBackgroundPaint(Color.WHITE);
                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(310, 280));
                chartPanel.setBackground(Color.WHITE);
                chartPanel.setBorder(null);
                pbdd.removeAll();
                pbdd.add(chartPanel);
                pbdd.revalidate();
                pbdd.repaint();
                // Set khoảng cách
                JPanel panelkc = new JPanel();
                panelkc.setPreferredSize(new Dimension(30, 280));
                panelkc.setBackground(Color.WHITE);
                pbdd.add(panelkc);
                DefaultCategoryDataset dataset2 = createDatasetLuongTheoVT2();
                JFreeChart chart2 = createChartLuongTheoVT2(dataset2);
                chart2.setBackgroundPaint(Color.WHITE);
                ChartPanel chartPanel2 = new ChartPanel(chart2);
                chartPanel2.setPreferredSize(new Dimension(396, 280));
                chartPanel2.setBackground(Color.WHITE);
                chartPanel2.setBorder(null);
                pbdd.add(chartPanel2);
                pbdd.revalidate();
                pbdd.repaint();
                
                
                
            }
            //Lấy dữ liệu cho lương theo vị trí
            private DefaultPieDataset createDatasetLuongTheoVT1() {
                DefaultPieDataset dataset = new DefaultPieDataset();
                float countTT = 0;
                float countPV = 0;
                float countBV = 0;
                float countB = 0;
                String tt = "Nhân viên tiếp tân";
                String pv = "Nhân viên phục vụ";
                String bv = "Nhân viên bảo vệ";
                String b = "Nhân viên bếp";
				for (int i = 0; i < dsNVCL.size(); i++) {
					if (dsNVCL.get(i).getViTri().equals(tt)) {
						//Tính lương nhân viên tiếp tân
						if (dsNVCL.get(i).getNgayVaoLam().getYear() < LocalDate.now().getYear()) {
							countTT += dsNVCL.get(i).getTongLuong() * 12;
						} else {
							// Đếm số tháng nhân viên đã làm trong năm hiện tại
							int soThangLam = 12 - dsNVCL.get(i).getNgayVaoLam().getMonthValue();
							countTT += dsNVCL.get(i).getTongLuong() * soThangLam;
						}
					} else if (dsNVCL.get(i).getViTri().equals(pv)) {
						countPV++;
						//Tính lương nhân viên phục vụ
						if (dsNVCL.get(i).getNgayVaoLam().getYear() < LocalDate.now().getYear()) {
							countPV += dsNVCL.get(i).getTongLuong() * 12;
						} else {
							// Đếm số tháng nhân viên đã làm trong năm hiện tại
							int soThangLam = 12 - dsNVCL.get(i).getNgayVaoLam().getMonthValue();
							countPV += dsNVCL.get(i).getTongLuong() * soThangLam;
						}
					} else if (dsNVCL.get(i).getViTri().equals(bv)) {
						countBV++;
						//Tính lương nhân viên bảo vệ
						if (dsNVCL.get(i).getNgayVaoLam().getYear() < LocalDate.now().getYear()) {
							countBV += dsNVCL.get(i).getTongLuong() * 12;
						} else {
							// Đếm số tháng nhân viên đã làm trong năm hiện tại
							int soThangLam = 12 - dsNVCL.get(i).getNgayVaoLam().getMonthValue();
							countBV += dsNVCL.get(i).getTongLuong() * soThangLam;
						}
					} else if (dsNVCL.get(i).getViTri().equals(b)) {
						countB++;
						//Tính lương nhân viên bếp
						if (dsNVCL.get(i).getNgayVaoLam().getYear() < LocalDate.now().getYear()) {
							countB += dsNVCL.get(i).getTongLuong() * 12;
						} else {
							// Đếm số tháng nhân viên đã làm trong năm hiện tại
							int soThangLam = 12 - dsNVCL.get(i).getNgayVaoLam().getMonthValue();
							countB += dsNVCL.get(i).getTongLuong() * soThangLam;
						}
					}
				}
                
                dataset.setValue("Nhân viên tiếp tân", countTT);
                dataset.setValue("Nhân viên phục vụ", countPV);
                dataset.setValue("Nhân viên bảo vệ", countBV);
                dataset.setValue("Nhân viên bếp", countB);
                return dataset;
            }
            // Vẽ biểu đồ tròn
			private JFreeChart createChartLuongTheoVT(PieDataset dataset) {
				// tính tổng lương tất cả nhân viên trong năm nay
				float count = 0;
				for (int i = 0; i < dsNVCL.size(); i++) {
					if (dsNVCL.get(i).getNgayVaoLam().getYear() < LocalDate.now().getYear()) {
						count += dsNVCL.get(i).getTongLuong() * 12;
					} else {
						// Đếm số tháng nhân viên đã làm trong năm hiện tại
						int soThangLam = 12 - dsNVCL.get(i).getNgayVaoLam().getMonthValue();
						count += dsNVCL.get(i).getTongLuong() * soThangLam;
					}
				}
				// Làm tròn thành tỉ
				count = Math.round(count / 1000000000);
				
				// Làm tròn tới số thập phân thứ 2
				count = count / 10;
				
				CustomRingPlot plot = new CustomRingPlot(dataset, String.valueOf(count + "tỉ"));
				plot.setSectionPaint("Nhân viên tiếp tân", new Color(144, 238, 144));
				plot.setSectionPaint("Nhân viên phục vụ", new Color(255, 144, 144));
				plot.setSectionPaint("Nhân viên bảo vệ", new Color(68, 138, 255));
				plot.setSectionPaint("Nhân viên bếp", new Color(255, 215, 0));
				plot.setSimpleLabels(true);
				plot.setInsets(new RectangleInsets(0, 5, 5, 5));
				plot.setSectionDepth(0.50);
				plot.setBackgroundPaint(Color.WHITE);
				plot.setShadowPaint(null);
				plot.setOutlineVisible(false);
				plot.setLabelGenerator(null);

				JFreeChart chart = new JFreeChart("Tỉ lệ lương theo vị trí", JFreeChart.DEFAULT_TITLE_FONT, plot, true);

				// Hiển thị phần trăm
				LegendTitle legend = chart.getLegend();
				legend.setPosition(RectangleEdge.BOTTOM);

				chart.setBackgroundPaint(Color.WHITE);

				return chart;
			}
			//lấy dữ liệu lương theo vị trí theo từng năm
			private DefaultCategoryDataset createDatasetLuongTheoVT2() {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                float countTT;
                float countPV;
                float countBV;
                float countB;
                for (int j = 2019; j < 2024; j++) {
                    countTT = 0;
                    countPV = 0;
                    countBV = 0;
                    countB = 0;
                    // Lấy danh sách nhân viên vào làm trước năm j
                    ArrayList<Integer> listConLam = new ArrayList<>();
                    for (int i = 0; i < dsNV.size(); i++) {
                        if (dsNV.get(i).getNgayVaoLam().getYear() < j) {
                            listConLam.add(i);
                        }
                    }
                    // duyệt danh sách listConLam
                    for (int i = 0; i < listConLam.size(); i++) {
                        if (dsNV.get(listConLam.get(i)).getViTri().equals("Nhân viên tiếp tân")) {
                            //Tính lương nhân viên tiếp tân
                            if (dsNV.get(listConLam.get(i)).getNgayVaoLam().getYear() < j) {
                                countTT += dsNV.get(listConLam.get(i)).getTongLuong() * 12;
                            } else {
                                // Đếm số tháng nhân viên đã làm trong năm hiện tại
                                int soThangLam = 12 - dsNV.get(listConLam.get(i)).getNgayVaoLam().getMonthValue();
                                countTT += dsNV.get(listConLam.get(i)).getTongLuong() * soThangLam;
                            }
                        } else if (dsNV.get(listConLam.get(i)).getViTri().equals("Nhân viên phục vụ")) {
                            countPV++;
                            //Tính lương nhân viên phục vụ
                            if (dsNV.get(listConLam.get(i)).getNgayVaoLam().getYear() < j) {
                                countPV += dsNV.get(listConLam.get(i)).getTongLuong() * 12;
                            } else {
                            // Đếm số tháng nhân viên đã làm trong năm hiện tại
                                int soThangLam = 12 - dsNV.get(listConLam.get(i)).getNgayVaoLam().getMonthValue();
                                countPV += dsNV.get(listConLam.get(i)).getTongLuong() * soThangLam;
                            }
                        } else if (dsNV.get(listConLam.get(i)).getViTri().equals("Nhân viên bảo vệ")) {
                        	                            countBV++;
                            //Tính lương nhân viên bảo vệ
                            if (dsNV.get(listConLam.get(i)).getNgayVaoLam().getYear() < j) {
                                countBV += dsNV.get(listConLam.get(i)).getTongLuong() * 12;
                            } else {
                            // Đếm số tháng nhân viên đã làm trong năm hiện tại
                                int soThangLam = 12 - dsNV.get(listConLam.get(i)).getNgayVaoLam().getMonthValue();
                                countBV += dsNV.get(listConLam.get(i)).getTongLuong() * soThangLam;
                            }
                        } else if (dsNV.get(listConLam.get(i)).getViTri().equals("Nhân viên bếp")) {
                            countB++;
                            //Tính lương nhân viên bếp
                            if (dsNV.get(listConLam.get(i)).getNgayVaoLam().getYear() < j) {
                                countB += dsNV.get(listConLam.get(i)).getTongLuong() * 12;
                            } else {
                            // Đếm số tháng nhân viên đã làm trong năm hiện tại
                                int soThangLam = 12 - dsNV.get(listConLam.get(i)).getNgayVaoLam().getMonthValue();
                                countB += dsNV.get(listConLam.get(i)).getTongLuong() * soThangLam;
                            }
                        }
                        	  
                    }
                    // Làm tròn thành tỉ
                    countTT = countTT / 1_000_000_000;
                    countPV = countPV / 1_000_000_000;
                    countBV = countBV / 1_000_000_000;
                    countB = countB / 1_000_000_000;
                   
                    dataset.addValue(countTT, "Nhân viên tiếp tân", String.valueOf(j));
                    dataset.addValue(countPV, "Nhân viên phục vụ", String.valueOf(j));
                    dataset.addValue(countBV, "Nhân viên bảo vệ", String.valueOf(j));
                    dataset.addValue(countB, "Nhân viên bếp", String.valueOf(j)); 
                }
                return dataset;
			}
			//Vẽ biểu đồ đường
			private JFreeChart createChartLuongTheoVT2(CategoryDataset dataset) {
				JFreeChart chart = ChartFactory.createLineChart("Lương theo vị trí qua từng năm", // chart title
						"Năm", // domain axis label
						"Lương", // range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						true, // include legend
						true, // tooltips
						false // urls
				);
				chart.setBackgroundPaint(Color.WHITE);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setBackgroundPaint(Color.WHITE);
				plot.setRangeGridlinePaint(Color.BLACK);
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
				renderer.setSeriesStroke(0, new BasicStroke(3.0f));
				renderer.setSeriesStroke(1, new BasicStroke(3.0f));
				renderer.setSeriesStroke(2, new BasicStroke(3.0f));
				renderer.setSeriesStroke(3, new BasicStroke(3.0f));
				renderer.setSeriesPaint(0, new Color(144, 238, 144));
				renderer.setSeriesPaint(1, new Color(255, 144, 144));
				renderer.setSeriesPaint(2, new Color(68, 138, 255));
				renderer.setSeriesPaint(3, new Color(255, 215, 0));
				LegendTitle legend = chart.getLegend();
				legend.setPosition(RectangleEdge.RIGHT);
				return chart;
			}    
         });
		btnLngTheoNam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultCategoryDataset dataset = createDatasetLuongTheoNam();
				JFreeChart chart = createChartLuongTheoNam(dataset);
				chart.setBackgroundPaint(Color.WHITE);
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(706, 280));
				chartPanel.setBackground(Color.WHITE);
				chartPanel.setBorder(null);
				pbdd.removeAll();
				pbdd.add(chartPanel);
				pbdd.revalidate();
				pbdd.repaint();
			}
			//Lấy dữ liệu lương theo năm
			private DefaultCategoryDataset createDatasetLuongTheoNam() {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				float countLuong = 0;
				for(int i = 2014; i < 2024; i++) {
                    countLuong = 0;
                    for (int j = 0; j < dsNVCL.size(); j++) {
                        if (dsNVCL.get(j).getNgayVaoLam().getYear() < i) {
                            countLuong += dsNVCL.get(j).getTongLuong() * 12;
                        } else {
                            // Đếm số tháng nhân viên đã làm trong năm hiện tại
                            int soThangLam = 12 - dsNVCL.get(j).getNgayVaoLam().getMonthValue();
                            countLuong += dsNVCL.get(j).getTongLuong() * soThangLam;
                        }
                    }
                    countLuong = countLuong / 1_000_000_000;
                    dataset.addValue(countLuong, "Lương", String.valueOf(i));
                }
				return dataset;
			}
			// Vẽ biểu đồ cột
			private JFreeChart createChartLuongTheoNam(CategoryDataset dataset) {
				JFreeChart chart = ChartFactory.createBarChart("Tổng lương nhân viên qua các năm", // chart title
						"Năm", // domain axis label
						"Lương (tỉ)", // range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						true, // include legend
						true, // tooltips
						false // urls
				);
				chart.setBackgroundPaint(Color.WHITE);
				CategoryPlot plot = chart.getCategoryPlot();
				plot.setBackgroundPaint(Color.WHITE);
				plot.setRangeGridlinePaint(Color.BLACK);
				BarRenderer renderer = (BarRenderer) plot.getRenderer();
				renderer.setSeriesPaint(0, new Color(144, 238, 144));
				renderer.setDrawBarOutline(false);
				renderer.setItemMargin(0.1);
				renderer.setShadowVisible(false);
				LegendTitle legend = chart.getLegend();
				legend.setPosition(RectangleEdge.RIGHT);
				return chart;
			}
			
			
			
		});
		
		
		
		
		
		
		
		
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
				}if(clickedButton == btnKhchHng) {
                    GUI_ThongKeKhachHang tkkh = new GUI_ThongKeKhachHang(nhanvien);
                    tkkh.setVisible(true);
                    dispose();
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
                btnKhchHng.addActionListener(actionListener);
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
        yearComboBox.removeAllItems(); // Xóa các mục hiện tại trong combobox

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
	public void setDuLieuSoLuong() {
		
		// Cập nhật thông tin nhân viên
		// Lấy số nhân viên nghỉ việc
		int cnvnv = new NhanVien_DAO().demSoNhanVienNghiViec();
		int cnvn = new NhanVien_DAO().demSoNhanVienNu();
		txtNu.setText(String.valueOf(cnvn));
		txtNam.setText(String.valueOf(dsNV.size() - cnvn));
		txtTNV.setText(String.valueOf(dsNV.size() -  cnvnv));
		txtNL.setText(String.valueOf(cnvnv));
		
		Integer countNV = dsNV.size();
		txtTNV.setText(countNV.toString());
		
		// Lấy danh sách tuổi của nhân viên còn làm
		ArrayList<LocalDate> dsT = new ArrayList<>();
		for (int i = 0; i < dsNV.size(); i++) {
			if (dsNV.get(i).getNgayNghiLam() == null) {
				dsT.add(dsNV.get(i).getNgaySinh());
			}
		}
		// set Tuổi cao nhất
		Integer maxT = findMaxAge(dsT);
		txtTCN.setText(maxT.toString());
		// set Tuổi trung bình
		Integer avg = findAverageAge(dsT);
		txtTBT.setText(avg.toString());
		// set Tuổi thấp nhất	
		Integer minT = findMinAge(dsT);
		txtTTN.setText("0");
		// set nhân viên thâm niên
		int countNVTN = 0;
		for (int i = 0; i < dsNV.size(); i++) {
			if (dsNV.get(i).getNgayVaoLam().until(LocalDate.now()).getYears() >= 5) {
				countNVTN++;
			}
		}
		txtSNVTN.setText(countNVTN + "");
	}
	//Tìm 5 nhân sự lương cao nhất trong dsNVCL
	public void ht5NhanSuLuongCaoNhat() {
		// Sắp xếp dsNVCL theo lương giảm dần
		Collections.sort(dsNVCL, new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien nv1, NhanVien nv2) {
				return (int) (nv2.getTongLuong() - nv1.getTongLuong());
			}
		});
		// Hiển thị 10 nhân sự lương cao nhất
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		for (int i = 0; i < 10; i++) {
			model.addRow(
					new Object[] { 
							dsNVCL.get(i).getMaNV(), 
							dsNVCL.get(i).getHoTenNV(), 
							dsNVCL.get(i).getHeSoLuong() ,
							decimalFormat.format(dsNVCL.get(i).getTongLuong()) });
		}
	}
	static class CustomRingPlot extends RingPlot {
	    private String centerText;

	    public CustomRingPlot(PieDataset dataset, String centerText) {
	        super(dataset);
	        this.centerText = centerText;
	    }

	    @Override
	    public void draw(Graphics2D g2, Rectangle2D area, Point2D anchor,
	                     PlotState parentState, PlotRenderingInfo info) {
	        super.draw(g2, area, anchor, parentState, info);

	        // Vẽ tổng số ở trung tâm biểu đồ
	        Font font = new Font("SansSerif", Font.BOLD, 24);
	        g2.setFont(font);
	        g2.setPaint(Color.BLACK);
	        FontMetrics fm = g2.getFontMetrics();
	        int textWidth = fm.stringWidth(centerText);
	        int textHeight = fm.getAscent();
	        double centerX = area.getCenterX();
	        double centerY = area.getCenterY();
	        g2.drawString(centerText, (float) (centerX - textWidth / 2), (float) (centerY + textHeight / 4));
	    }
	}
}

