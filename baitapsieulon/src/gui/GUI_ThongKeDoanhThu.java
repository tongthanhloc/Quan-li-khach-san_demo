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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import dao.DAO_DichVu;
import dao.DAO_HoaDon;
import dao.DAO_PhieuDatDichVu;
import entity.DichVu;
import entity.HoaDon;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import gui.GUI_ThongKeNhanVien.CustomRingPlot;
import entity.PhieuDatDichVu;

import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;



public class GUI_ThongKeDoanhThu extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JButton btnTKDMK;
    private JButton btnTKDX;
    private JPanel panelTK;
    private JLabel btnTKHTNV;
    private JLabel btnTKTNV;
    private JLabel btnTKca;
    private JLabel btnmaNV;
    private JTable table;
	private DefaultTableModel modelHD;
	private DefaultTableModel modelDT;
	private JLabel lblNewLabel_7;
	private JLabel lblSoPhieuDatPhong;
	private JComboBox cbPD;
	private JPanel panel_3;
	private JLabel lblNewLabel_13;
	private DefaultTableModel model;
	private JTable tableNV;
	private ArrayList<NhanVien> dsNV;
	private ArrayList<LocalDate> dsT;
	private JTextField txtTThueVAT;
	private JTextField txtDTDV;
	private JTextField txtSauKTr;
	private JTextField txtTongDoanhThu;
	private JTextField txtNamCaoNhat;
	private JTextField txtNamThapNhat;
	private JComboBox cbPH;
	private JComboBox cbDDV;
	private JComboBox cbDoanhThu;
	private JComboBox cbTNV;
	private JComboBox cbTNV_DV;
	private JLabel lblThucThuPDP;
	private JLabel lblPhanTramThucThuPhong;
	private JLabel lblPhanTramPhieuHuy;
	private JLabel lblSoPhieuHuy;
	private JLabel lblThatThu;
	private JLabel lblPhanTramThatThuPhong;
	private JLabel lblSoPhieuDatDichVu;
	private JLabel lblPhanTramSoPhieuDatDV;
	private JLabel lblThucThuDV;
	private JButton btnDoanhThuLoaiPhong;
	private JPanel panel_5;
	private JPanel panel_5_1;
	private JButton btnDoanhThuDV;
	private JPanel panelDTPh;
	private JButton btnDoanhThuTng_2;
	private JPanel panelDTR;
	private JPanel panelDTR_1;
	private ArrayList<HoaDon> dsHD;
	private JLabel lblDoanhThu;
	private JLabel sdf_1;
	
	
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
                	GUI_ThongKeDoanhThu frame = new GUI_ThongKeDoanhThu(nv);
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
	public GUI_ThongKeDoanhThu(NhanVien nv) {

		try {
			ConnectDB.getInstance().connect();
			} catch (Exception e) {
				e.printStackTrace();
		}
		dsNV = new  ArrayList<NhanVien>();
		dsNV = new NhanVien_DAO().getalltbNhanVien();
		dsT = new ArrayList<LocalDate>();
		dsHD = new ArrayList<HoaDon>();
		dsHD = new DAO_HoaDon().getalltbHoaDon();
		for (NhanVien nv1 : dsNV) {
			dsT.add(nv1.getNgaySinh());
		}
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
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnKhchHng.setBackground(new Color(41, 139, 116));
		btnKhchHng.setForeground(new Color(255, 255, 255));
		btnKhchHng.setBounds(494, 25, 200, 100);
		panel_top.add(btnKhchHng);
		
		JButton btnDoanhThu = new JButton("Doanh thu");
		btnDoanhThu.setForeground(new Color(0,0,0));
		btnDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDoanhThu.setBackground(new Color(164, 194, 163));
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
		
		JButton btnDoanhThuTng_1_1_1 = new JButton("Doanh thu DV theo năm");
		btnDoanhThuTng_1_1_1.setBounds(37, 144, 198, 23);
		panelTK.add(btnDoanhThuTng_1_1_1);
		
		JPanel panel_Center_Left = new JPanel();
		panel_Center_Left.setBounds(257, 150, 673, 891);
		panel_Center_Left.setLayout(null);
		
		JPanel panel_Center_Right = new JPanel();
		panel_Center_Right.setBounds(942, 156, 962, 885);
		panel_Center_Right.setLayout(null);
		
		
		Frame.add(panel_Center_Left);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "DOANH S\u1ED0 T\u1EEA THU\u00CA PH\u00D2NG", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_2.setBounds(12, 0, 645, 349);
		panel_Center_Left.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Năm thống kê");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_7.setBounds(24, 35, 134, 16);
		panel_2.add(lblNewLabel_7);
		
		cbTNV = new JComboBox();
		cbTNV.setBounds(192, 32, 114, 25);
		panel_2.add(cbTNV);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 75, 294, 124);
		panel_2.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Số Phiếu Đặt");
		lblNewLabel_9.setBounds(28, 9, 119, 16);
		panel.add(lblNewLabel_9);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBounds(0, 2, 10, 122);
		panel.add(panel_2_1_1);
		panel_2_1_1.setBackground(new Color(222, 220, 203));
		
		lblSoPhieuDatPhong = new JLabel("40");
		lblSoPhieuDatPhong.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSoPhieuDatPhong.setBounds(61, 38, 30, 58);
		panel.add(lblSoPhieuDatPhong);
		cbPD = new JComboBox();
		cbPD.setFont(new Font("Dialog", Font.PLAIN, 12));
		cbPD.setForeground(new Color(0, 0, 0));
		cbPD.setBackground(new Color(255, 255, 255));
		cbPD.setBounds(210, 2, 84, 25);
		cbPD.setUI(new BasicComboBoxUI() {
            protected void installDefaults() {
                super.installDefaults();
                cbPD.setBorder(BorderFactory.createEmptyBorder());
            }
            protected JButton createArrowButton() {
                // Tạo một JButton tùy chỉnh cho dấu mũi tên
                JButton arrowButton = new JButton();
                arrowButton.setPreferredSize(new Dimension(20, cbTNV.getPreferredSize().height));
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
	
		
		
		
		
		
			   
		
				panel.add(cbPD);
				
				JLabel lblPhanTramPDP = new JLabel("0.0%");
				lblPhanTramPDP.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblPhanTramPDP.setForeground(new Color(0, 0, 0));
				lblPhanTramPDP.setBounds(129, 61, 55, 16);
				panel.add(lblPhanTramPDP);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(335, 75, 298, 124);
				panel_2.add(panel_1);
				panel_1.setLayout(null);
				panel_1.setBackground(Color.WHITE);
				
				JLabel lblNewLabel_9_1 = new JLabel("Tổng thu");
				lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_9_1.setBounds(28, 9, 119, 16);
				panel_1.add(lblNewLabel_9_1);
				
				JPanel panel_2_1_1_1 = new JPanel();
				panel_2_1_1_1.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1.setBounds(0, 2, 10, 122);
				panel_1.add(panel_2_1_1_1);
				
				lblThucThuPDP = new JLabel("1.0");
				lblThucThuPDP.setFont(new Font("Dialog", Font.BOLD, 25));
				lblThucThuPDP.setBounds(55, 37, 92, 58);
				panel_1.add(lblThucThuPDP);
				
				lblPhanTramThucThuPhong = new JLabel("0.0%");
				lblPhanTramThucThuPhong.setForeground(new Color(0, 0, 0));
				lblPhanTramThucThuPhong.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblPhanTramThucThuPhong.setBounds(218, 61, 55, 16);
				panel_1.add(lblPhanTramThucThuPhong);
				
				JLabel lbltrmTriu = new JLabel("(Triệu)");
				lbltrmTriu.setForeground(Color.BLACK);
				lbltrmTriu.setFont(new Font("Dialog", Font.ITALIC, 18));
				lbltrmTriu.setBounds(123, 52, 55, 34);
				panel_1.add(lbltrmTriu);
				
				JPanel panel_1_2 = new JPanel();
				panel_1_2.setLayout(null);
				panel_1_2.setBackground(Color.WHITE);
				panel_1_2.setBounds(335, 210, 298, 124);
				panel_2.add(panel_1_2);
				
				JPanel panel_2_1_1_1_2 = new JPanel();
				panel_2_1_1_1_2.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1_2.setBounds(0, 2, 10, 122);
				panel_1_2.add(panel_2_1_1_1_2);
				
				lblThatThu = new JLabel("1.0");
				lblThatThu.setFont(new Font("Dialog", Font.BOLD, 25));
				lblThatThu.setBounds(55, 37, 84, 58);
				panel_1_2.add(lblThatThu);
				
				lblPhanTramThatThuPhong = new JLabel("0.0%");
				lblPhanTramThatThuPhong.setForeground(Color.BLACK);
				lblPhanTramThatThuPhong.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblPhanTramThatThuPhong.setBounds(218, 61, 55, 16);
				panel_1_2.add(lblPhanTramThatThuPhong);
				
				JLabel lblNewLabel_9_1_3 = new JLabel("Thất thu");
				lblNewLabel_9_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_9_1_3.setBounds(28, 9, 85, 16);
				panel_1_2.add(lblNewLabel_9_1_3);
				
				JLabel lbltrmTriu_1 = new JLabel("(Triệu)");
				lbltrmTriu_1.setForeground(Color.BLACK);
				lbltrmTriu_1.setFont(new Font("Dialog", Font.ITALIC, 18));
				lbltrmTriu_1.setBounds(123, 52, 55, 34);
				panel_1_2.add(lbltrmTriu_1);
				
				JPanel panel_6 = new JPanel();
				panel_6.setLayout(null);
				panel_6.setBackground(Color.WHITE);
				panel_6.setBounds(12, 210, 294, 124);
				panel_2.add(panel_6);
				
				JLabel lblNewLabel_9_3 = new JLabel("Số phiếu hủy");
				lblNewLabel_9_3.setBounds(28, 9, 119, 16);
				panel_6.add(lblNewLabel_9_3);
				
				JPanel panel_2_1_1_3 = new JPanel();
				panel_2_1_1_3.setBackground(new Color(222, 220, 203));
				panel_2_1_1_3.setBounds(0, 2, 10, 122);
				panel_6.add(panel_2_1_1_3);
				
				lblSoPhieuHuy = new JLabel("40");
				lblSoPhieuHuy.setFont(new Font("Dialog", Font.BOLD, 25));
				lblSoPhieuHuy.setBounds(61, 38, 30, 58);
				panel_6.add(lblSoPhieuHuy);
				
				cbPH = new JComboBox();
				cbPH.setForeground(Color.BLACK);
				cbPH.setFont(new Font("Dialog", Font.PLAIN, 12));
				cbPH.setBackground(Color.WHITE);
				cbPH.setBounds(210, 2, 84, 25);
				cbPH.setUI(new BasicComboBoxUI() {
		            protected void installDefaults() {
		                super.installDefaults();
		                cbPH.setBorder(BorderFactory.createEmptyBorder());
		            }
		            protected JButton createArrowButton() {
		                // Tạo một JButton tùy chỉnh cho dấu mũi tên
		                JButton arrowButton = new JButton();
		                arrowButton.setPreferredSize(new Dimension(20, cbTNV.getPreferredSize().height));
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
				panel_6.add(cbPH);
				
				lblPhanTramPhieuHuy = new JLabel("0.0%");
				lblPhanTramPhieuHuy.setForeground(Color.BLACK);
				lblPhanTramPhieuHuy.setFont(new Font("Dialog", Font.PLAIN, 18));
				lblPhanTramPhieuHuy.setBounds(129, 61, 55, 16);
				panel_6.add(lblPhanTramPhieuHuy);
				// Lấy danh sách tuổi của nhân viên

				
				panel_3 = new JPanel();
				panel_3.setBorder(new TitledBorder(new CompoundBorder(null, new LineBorder(new Color(99, 130, 191))), "DOANH S\u1ED0 T\u1EEA D\u1ECACH V\u1EE4", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_3.setBounds(12, 355, 645, 355);
				panel_Center_Left.add(panel_3);
				panel_3.setLayout(null);
				
				lblNewLabel_13 = new JLabel("Năm thống kê");
				lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_13.setBounds(30, 31, 131, 16);
				panel_3.add(lblNewLabel_13);
				
				JPanel panel_4 = new JPanel();
				panel_4.setLayout(null);
				panel_4.setBackground(Color.WHITE);
				panel_4.setBounds(10, 66, 294, 124);
				panel_3.add(panel_4);
				
				JLabel lblNewLabel_9_2 = new JLabel("Số Phiếu Đặt  DV");
				lblNewLabel_9_2.setBounds(28, 9, 147, 16);
				panel_4.add(lblNewLabel_9_2);
				
				JPanel panel_2_1_1_2 = new JPanel();
				panel_2_1_1_2.setBackground(new Color(222, 220, 203));
				panel_2_1_1_2.setBounds(0, 2, 10, 122);
				panel_4.add(panel_2_1_1_2);
				
				lblSoPhieuDatDichVu = new JLabel("40");
				lblSoPhieuDatDichVu.setFont(new Font("Dialog", Font.BOLD, 25));
				lblSoPhieuDatDichVu.setBounds(61, 37, 84, 58);
				panel_4.add(lblSoPhieuDatDichVu);
				
				cbDDV = new JComboBox();
				cbDDV.setFont(new Font("Dialog", Font.PLAIN, 12));
				cbDDV.setBackground(new Color(255, 255, 255));
				cbDDV.setBounds(210, 5, 84, 25);
				cbDDV.setUI(new BasicComboBoxUI() {
		            protected void installDefaults() {
		                super.installDefaults();
		                cbDDV.setBorder(BorderFactory.createEmptyBorder());
		            }
		            protected JButton createArrowButton() {
		                // Tạo một JButton tùy chỉnh cho dấu mũi tên
		                JButton arrowButton = new JButton();
		                arrowButton.setPreferredSize(new Dimension(20, cbTNV.getPreferredSize().height));
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
				panel_4.add(cbDDV);
				
				lblPhanTramSoPhieuDatDV = new JLabel("(phiếu)");
				lblPhanTramSoPhieuDatDV.setForeground(Color.BLACK);
				lblPhanTramSoPhieuDatDV.setFont(new Font("Dialog", Font.ITALIC, 18));
				lblPhanTramSoPhieuDatDV.setBounds(129, 57, 70, 25);
				panel_4.add(lblPhanTramSoPhieuDatDV);
				
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setLayout(null);
				panel_1_1.setBackground(Color.WHITE);
				panel_1_1.setBounds(332, 66, 298, 124);
				panel_3.add(panel_1_1);
				
				JLabel lblNewLabel_9_1_1 = new JLabel("Thực thu");
				lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_9_1_1.setBounds(28, 9, 135, 16);
				panel_1_1.add(lblNewLabel_9_1_1);
				
				JPanel panel_2_1_1_1_1 = new JPanel();
				panel_2_1_1_1_1.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1_1.setBounds(0, 2, 10, 122);
				panel_1_1.add(panel_2_1_1_1_1);
				
				lblThucThuDV = new JLabel("1.0");
				lblThucThuDV.setFont(new Font("Dialog", Font.BOLD, 25));
				lblThucThuDV.setBounds(55, 37, 62, 58);
				panel_1_1.add(lblThucThuDV);
				
				JLabel lbldsd = new JLabel("(Triệu)");
				lbldsd.setForeground(Color.BLACK);
				lbldsd.setFont(new Font("Dialog", Font.ITALIC, 18));
				lbldsd.setBounds(123, 57, 55, 24);
				panel_1_1.add(lbldsd);
				
				sdf_1 = new JLabel("VND");
				sdf_1.setForeground(Color.BLACK);
				sdf_1.setFont(new Font("Dialog", Font.PLAIN, 18));
				sdf_1.setBounds(190, 63, 55, 16);
				panel_1_1.add(sdf_1);
				
				String[] colNV = new String[] {"Tên Dịch vụ", "Doanh thu"};
				
		        model = new DefaultTableModel(colNV, 0);
		        
				panel_3.setLayout(null);
				
				cbTNV_DV = new JComboBox();
				cbTNV_DV.setBounds(190, 28, 114, 25);
				panel_3.add(cbTNV_DV);
				
					
				
				tableNV = new JTable(model);
				tableNV.setRowHeight(30);
				DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		        tableNV.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
				JScrollPane paneNV = new JScrollPane(tableNV);
				paneNV.setBounds(10, 222, 300, 114);
				panel_3.add(paneNV);
				
				JLabel lblNewLabel_13_1 = new JLabel("Top 3 Dịch vụ doanh thu cao nhất");
				lblNewLabel_13_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_13_1.setBounds(50, 197, 224, 16);
				panel_3.add(lblNewLabel_13_1);
				
				JLabel lblNewLabel_13_2 = new JLabel("Tổng Thuế VAT");
				lblNewLabel_13_2.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_13_2.setBounds(332, 232, 131, 16);
				panel_3.add(lblNewLabel_13_2);
				
				JLabel lblNewLabel_13_2_1 = new JLabel("Doanh Thu DV");
				lblNewLabel_13_2_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_13_2_1.setBounds(332, 260, 100, 31);
				panel_3.add(lblNewLabel_13_2_1);
				
				JLabel lblNewLabel_13_2_1_1 = new JLabel("Sau Khấu Trừ");
				lblNewLabel_13_2_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
				lblNewLabel_13_2_1_1.setBounds(332, 303, 131, 16);
				panel_3.add(lblNewLabel_13_2_1_1);
				
				txtTThueVAT = new JTextField();
				txtTThueVAT.setBackground(new Color(255, 255, 255));
				txtTThueVAT.setFont(new Font("Dialog", Font.BOLD, 13));
				txtTThueVAT.setEditable(false);
				txtTThueVAT.setColumns(10);
				txtTThueVAT.setBounds(451, 225, 179, 30);
				panel_3.add(txtTThueVAT);
				
				txtDTDV = new JTextField();
				txtDTDV.setBackground(new Color(255, 255, 255));
				txtDTDV.setFont(new Font("Dialog", Font.BOLD, 13));
				txtDTDV.setEditable(false);
				txtDTDV.setColumns(10);
				txtDTDV.setBounds(451, 260, 179, 30);
				panel_3.add(txtDTDV);
				
				txtSauKTr = new JTextField();
				txtSauKTr.setBackground(new Color(255, 255, 255));
				txtSauKTr.setFont(new Font("Dialog", Font.BOLD, 13));
				txtSauKTr.setEditable(false);
				txtSauKTr.setColumns(10);
				txtSauKTr.setBounds(451, 296, 179, 30);
				panel_3.add(txtSauKTr);
				
				JPanel panel_7 = new JPanel();
				panel_7.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "T\u1ED4NG DOANH THU", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
				panel_7.setBounds(12, 715, 645, 164);
				panel_Center_Left.add(panel_7);
				panel_7.setLayout(null);
				
				JLabel lblNewLabel_13_2_2 = new JLabel("Tổng doanh thu");
				lblNewLabel_13_2_2.setFont(new Font("Dialog", Font.BOLD, 15));
				lblNewLabel_13_2_2.setBounds(22, 37, 196, 16);
				panel_7.add(lblNewLabel_13_2_2);
				
				txtTongDoanhThu = new JTextField();
				txtTongDoanhThu.setBackground(new Color(255, 255, 255));
				txtTongDoanhThu.setEditable(false);
				txtTongDoanhThu.setColumns(10);
				txtTongDoanhThu.setBounds(168, 31, 137, 30);
				panel_7.add(txtTongDoanhThu);
				
				JLabel lblNewLabel_13_2_2_1 = new JLabel("");
				lblNewLabel_13_2_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
				lblNewLabel_13_2_2_1.setBounds(22, 71, 196, 16);
				panel_7.add(lblNewLabel_13_2_2_1);
				
				txtNamCaoNhat = new JTextField();
				txtNamCaoNhat.setBackground(new Color(255, 255, 255));
				txtNamCaoNhat.setEditable(false);
				txtNamCaoNhat.setColumns(10);
				txtNamCaoNhat.setBounds(168, 65, 137, 30);
				panel_7.add(txtNamCaoNhat);
				
				JPanel panel_1_1_1 = new JPanel();
				panel_1_1_1.setLayout(null);
				panel_1_1_1.setBackground(Color.WHITE);
				panel_1_1_1.setBounds(335, 24, 298, 124);
				panel_7.add(panel_1_1_1);
				
				JLabel lblNewLabel_9_1_1_1 = new JLabel("Doanh Thu");
				lblNewLabel_9_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_9_1_1_1.setBounds(28, 9, 135, 16);
				panel_1_1_1.add(lblNewLabel_9_1_1_1);
				
				JPanel panel_2_1_1_1_1_1 = new JPanel();
				panel_2_1_1_1_1_1.setBackground(new Color(41, 139, 116));
				panel_2_1_1_1_1_1.setBounds(0, 2, 10, 122);
				panel_1_1_1.add(panel_2_1_1_1_1_1);
				
				lblDoanhThu = new JLabel("1.0");
				lblDoanhThu.setFont(new Font("Dialog", Font.BOLD, 25));
				lblDoanhThu.setBounds(52, 37, 102, 58);
				panel_1_1_1.add(lblDoanhThu);
				
				JLabel sdf = new JLabel("VND");
				sdf.setForeground(Color.BLACK);
				sdf.setFont(new Font("Dialog", Font.PLAIN, 18));
				sdf.setBounds(192, 61, 55, 16);
				panel_1_1_1.add(sdf);
				
				cbDoanhThu = new JComboBox();
				cbDoanhThu.setForeground(new Color(0, 0, 0));
				cbDoanhThu.setFont(new Font("Dialog", Font.PLAIN, 12));
				cbDoanhThu.setBackground(Color.WHITE);
				cbDoanhThu.setBounds(200, 5, 98, 25);
				cbDoanhThu.setUI(new BasicComboBoxUI() {
		            protected void installDefaults() {
		                super.installDefaults();
		                cbDoanhThu.setBorder(BorderFactory.createEmptyBorder());
		            }
		            protected JButton createArrowButton() {
		                // Tạo một JButton tùy chỉnh cho dấu mũi tên
		                JButton arrowButton = new JButton();
		                arrowButton.setPreferredSize(new Dimension(20, cbTNV.getPreferredSize().height));
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
				panel_1_1_1.add(cbDoanhThu);
				
				JLabel lbldsd_1 = new JLabel("(Triệu)");
				lbldsd_1.setForeground(Color.BLACK);
				lbldsd_1.setFont(new Font("Dialog", Font.ITALIC, 18));
				lbldsd_1.setBounds(114, 57, 55, 24);
				panel_1_1_1.add(lbldsd_1);
				
				JLabel lblNewLabel_13_2_2_1_1 = new JLabel("");
				lblNewLabel_13_2_2_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
				lblNewLabel_13_2_2_1_1.setBounds(22, 105, 196, 16);
				panel_7.add(lblNewLabel_13_2_2_1_1);
				
				txtNamThapNhat = new JTextField();
				txtNamThapNhat.setBackground(new Color(255, 255, 255));
				txtNamThapNhat.setEditable(false);
				txtNamThapNhat.setColumns(10);
				txtNamThapNhat.setBounds(168, 98, 137, 30);
				panel_7.add(txtNamThapNhat);
				
				JLabel lblNewLabel_13_2_2_2 = new JLabel("Năm cao nhất");
				lblNewLabel_13_2_2_2.setFont(new Font("Dialog", Font.BOLD, 15));
				lblNewLabel_13_2_2_2.setBounds(22, 71, 196, 16);
				panel_7.add(lblNewLabel_13_2_2_2);
				
				JLabel lblNewLabel_13_2_2_2_1 = new JLabel("Năm thấp nhất");
				lblNewLabel_13_2_2_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
				lblNewLabel_13_2_2_2_1.setBounds(22, 104, 196, 16);
				panel_7.add(lblNewLabel_13_2_2_2_1);
		Frame.add(panel_Center_Right);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setForeground(new Color(255, 255, 255));
		panel_5.setBounds(25, 47, 464, 320);
		panel_Center_Right.add(panel_5);
		
		panel_5_1 = new JPanel();
		panel_5_1.setForeground(Color.WHITE);
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(501, 47, 449, 320);
		panel_Center_Right.add(panel_5_1);
		
		panelDTPh = new JPanel();
		panelDTPh.setForeground(Color.WHITE);
		panelDTPh.setBackground(Color.WHITE);
		panelDTPh.setBounds(263, 414, 687, 412);
		panel_Center_Right.add(panelDTPh);
		
		btnDoanhThuDV = new JButton("Doanh thu từng Loại hình dịch Vụ");
		btnDoanhThuDV.setBackground(new Color(222, 220, 203));
		btnDoanhThuDV.setBounds(263, 12, 226, 23);
		panel_Center_Right.add(btnDoanhThuDV);
		
		btnDoanhThuLoaiPhong = new JButton("Doanh thu từng Loại Phòng");
		btnDoanhThuLoaiPhong.setBackground(new Color(222, 220, 203));
		btnDoanhThuLoaiPhong.setBounds(25, 12, 226, 23);
		panel_Center_Right.add(btnDoanhThuLoaiPhong);
		
		btnDoanhThuTng_2 = new JButton("Tổng Doanh Thu");
		btnDoanhThuTng_2.setBackground(new Color(222, 220, 203));
		btnDoanhThuTng_2.setBounds(25, 379, 226, 23);
		panel_Center_Right.add(btnDoanhThuTng_2);
		
		panelDTR = new JPanel();
		panelDTR.setBackground(new Color(255, 255, 255));
		panelDTR.setBounds(25, 414, 226, 200);
		panel_Center_Right.add(panelDTR);
		panelDTR.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelDTR_1 = new JPanel();
		panelDTR_1.setBackground(Color.WHITE);
		panelDTR_1.setBounds(25, 626, 226, 200);
		panel_Center_Right.add(panelDTR_1);
		panelDTR_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
                
                setCbData();
                updateModelData();
                setDataTongDoanhThu();
                    
                    
                    cbPD.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String nam = cbTNV.getSelectedItem().toString().substring(4);
							//Ep kieu String sang int
							int nam1 = Integer.parseInt(nam);
							String thang = cbPD.getSelectedItem().toString().substring(6);
							// Lấy Phiếu đặt phòng
							ArrayList<PhieuDatPhong> dsPDP = new PhieuDatPhong_DAO().getPhieuDatPhongTheoNam(nam1);
							// Lấy số phiếu đặt phòng theo tháng
							int soPDP = 0;
							double tongTienPDPThang = 0;
							for (PhieuDatPhong pdp : dsPDP) {
								//Lấy tháng của phiếu đặt phòng và trạng thái khác đã hủy
								if (((pdp.getThoiGianDat().getMonthValue() +1 -1) == Integer.parseInt(thang))){
									
										soPDP++;
										tongTienPDPThang += pdp.getDonGiaPhieu();
									
	
								}
							}
							lblSoPhieuDatPhong.setText(String.valueOf(soPDP));
							//Tính phần trăm trên tổng số phiếu
							double phanTramPDP = (double) soPDP / dsPDP.size() * 100;
							lblPhanTramPDP.setText(String.format("%.1f", phanTramPDP) + "%");
							
							// Làm tròn tongTienPDP thành triệu
					
							tongTienPDPThang = Math.round(tongTienPDPThang /  1000000);
			
							lblThucThuPDP.setText(String.valueOf(tongTienPDPThang));
							//Tính phần trăm trên tổng số phiếu
							double tongTienDS = 0;
							for (PhieuDatPhong pdp : dsPDP) {
								
									tongTienDS += pdp.getDonGiaPhieu();
								
							}
							//làm tròn tổng tiền thành triệu
							tongTienDS = Math.round(tongTienDS / 1000000);
					
							double phanTramThucThuPDP = (double) (tongTienPDPThang / tongTienDS) * 100;
							// Làm tròn phần trăm
						
							lblPhanTramThucThuPhong.setText(String.format("%.01f", phanTramThucThuPDP) + "%");
						}
					});
                    cbPH.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // TODO Auto-generated method stub
                            String nam = cbTNV.getSelectedItem().toString().substring(4);
                            //Ep kieu String sang int
                            int nam1 = Integer.parseInt(nam);
                            String thang = cbPH.getSelectedItem().toString().substring(6);
                            // Lấy Phiếu đặt phòng
                            ArrayList<PhieuDatPhong> dsPDP = new PhieuDatPhong_DAO().getPhieuDatPhongTheoNam(nam1);
                            // Lấy số phiếu đặt phòng theo tháng
                            int soPDPH = 0;
                            double tongTienPDPHThang = 0;
                            for (PhieuDatPhong pdp : dsPDP) {
                               
								// Lấy tháng của phiếu đặt phòng và trạng thái đã hủy
								if (((pdp.getThoiGianDat().getMonthValue() + 1 - 1) == Integer.parseInt(thang))) {
									if (pdp.getTrangThai().trim().equals("Đã Hủy")) {
										soPDPH++;
										tongTienPDPHThang += pdp.getDonGiaPhieu();
									}

								}
                            }
                            lblSoPhieuHuy.setText(String.valueOf(soPDPH));
                            //Tính phần trăm trên tổng số phiếu
                            double phanTramPDPH = (double) soPDPH / dsPDP.size() * 100;
                            lblPhanTramPhieuHuy.setText(String.format("%.1f", phanTramPDPH) + "%");
                            
                            // Làm tròn tongTienPDP thành triệu
             
                            tongTienPDPHThang = Math.round(tongTienPDPHThang /  1000000);
                            lblThatThu.setText(String.valueOf(tongTienPDPHThang));
                            //Tính phần trăm trên tổng số phiếu
                            double tongTienDS = 0;
							for (PhieuDatPhong pdp : dsPDP) {
								
									tongTienDS += pdp.getDonGiaPhieu();
								
							}
							//làm tròn tổng tiền thành triệu
							tongTienDS = Math.round(tongTienDS / 1000000);
							double phanTramThatThuPDP = (double) (tongTienPDPHThang / tongTienDS) * 100;
							// Xuat ra phan tram
							lblPhanTramThatThuPhong.setText(String.format("%.01f", phanTramThatThuPDP) + "%");     
                        }
                    });
                    cbDDV.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // TODO Auto-generated method stub
                            String nam = cbTNV_DV.getSelectedItem().toString().substring(4);
                            //Ep kieu String sang int
                            int nam1 = Integer.parseInt(nam);
                            String thang = cbDDV.getSelectedItem().toString().substring(6);
                            // Lấy Phiếu đặt phòng
                            ArrayList<PhieuDatDichVu> dsPDDV = new DAO_PhieuDatDichVu().getDSPhieuDatDichVuTheoNam(nam1);
                            // Lấy số phiếu đặt phòng theo tháng
                            int soPDDV = 0;
                            double tongTienPDDVThang = 0;
                            for (PhieuDatDichVu pddv : dsPDDV) {
                      
                                if (((pddv.getThoiGianDat().getMonthValue() + 1 - 1) == Integer.parseInt(thang))) {
                                    soPDDV++;
                                    tongTienPDDVThang += pddv.getDonGia();
                                }
                            }
                            lblSoPhieuDatDichVu.setText(String.valueOf(soPDDV));                   
                            // Làm tròn tongTienPDP thành triệu
                            tongTienPDDVThang = Math.round(tongTienPDDVThang /  1000000);
                            lblThucThuDV.setText(String.valueOf(tongTienPDDVThang));
                           
                        }
                     });
                    cbDoanhThu.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String nam = cbDoanhThu.getSelectedItem().toString().substring(4);
							//Ep kieu String sang int
							int nam1 = Integer.parseInt(nam);
							// Tìm doanh thu trong hóa đơn
							double tongDoanhThu = 0;
							for (HoaDon hd : dsHD) {
								if (hd.getNgayLap().getYear() == nam1) {
									tongDoanhThu += hd.getThanhTien();
								}
							}
							// Làm tròn tổng tiền thành triệu
							tongDoanhThu = Math.round(tongDoanhThu / 1000000);
							lblDoanhThu.setText(String.valueOf(tongDoanhThu));
							
						}
					});
					btnDoanhThuLoaiPhong.addActionListener(new ActionListener() {
						private ArrayList<PhieuDatPhong> dsPDP;
						private ArrayList<Phong> dsPhong;
						private JPanel panle_ChiTietPDP;
						private JLabel lblDon;
						private JLabel lblDoi;
						private JLabel lblVip;
						private JLabel lblSoDon;
						private JLabel lblSoDoi;
						private JLabel lblSoVip;
						private JPanel panelDon;
						private JPanel panelDoi;
						private JPanel panelVip;
					
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							dsPDP  = new PhieuDatPhong_DAO().getAllTbPhieuDatPhong();
							dsPhong = new Phong_DAO().getalltbPhong();
							//add phòng vào phiếu đặt phòng
							for (PhieuDatPhong pdp : dsPDP) {
								for (Phong p : dsPhong) {
									if (pdp.getPhong().getMaPhong().equals(p.getMaPhong())) {
										pdp.setPhong(p);
									}
								}
							}
							// Tạo biểu đồ tròn
							
							
							 DefaultPieDataset dataset = createDatasetPDP();
				             JFreeChart chart = createChartPDP(dataset);
				             chart.setBackgroundPaint(Color.WHITE);
				             ChartPanel chartPanel = new ChartPanel(chart);
				             chartPanel.setPreferredSize(new Dimension(290, 280));
				             chartPanel.setBackground(Color.WHITE);
				             chartPanel.setBorder(null);
				             //Set txt vào panel
				             panle_ChiTietPDP = new JPanel();
				             panle_ChiTietPDP.setBackground(Color.WHITE);
				             //Set các phần tử nằm dọc
				             panle_ChiTietPDP.setLayout(new BoxLayout(panle_ChiTietPDP, BoxLayout.Y_AXIS));
				             // Tính phần trăm doanh thu tường loại phòng
				             HashMap<String, Double> dsLoaiPhong = new HashMap<String, Double>();
				             double tongDoanhThu = 0;
							for (PhieuDatPhong pdp : dsPDP) {
								String loaiPhong = pdp.getPhong().getLoaiPhong();
								double donGia = pdp.getDonGiaPhieu();
								if (dsLoaiPhong.containsKey(loaiPhong)) {
									double tongTien = dsLoaiPhong.get(loaiPhong) + donGia;
									dsLoaiPhong.put(loaiPhong, tongTien);
								} else {
									dsLoaiPhong.put(loaiPhong, donGia);
								}
								tongDoanhThu += donGia;
							}
				             lblDon = new JLabel();
				             lblDoi = new JLabel();
				             lblVip = new JLabel();
				             lblSoDon = new JLabel();
				             lblSoDoi = new JLabel();
				             lblSoVip = new JLabel();
				             //Set cỡ chữ
				             lblSoDon.setFont(new Font("Dialog", Font.BOLD, 15));
				             lblSoDoi.setFont(new Font("Dialog", Font.BOLD, 15));
				             lblSoVip.setFont(new Font("Dialog", Font.BOLD, 15));
				             lblDon.setFont(new Font("Dialog", Font.PLAIN, 12));
				             lblDoi.setFont(new Font("Dialog", Font.PLAIN, 12));
				             lblVip.setFont(new Font("Dialog", Font.PLAIN, 12));
				             panelDon = new JPanel();
				             panelDoi = new JPanel();
				             panelVip = new JPanel();
							 for (Entry<String, Double> entry : dsLoaiPhong.entrySet()) {
								String loaiPhong = entry.getKey().trim();
								double doanhThu = entry.getValue();
								// Ép kiểu double sang String
								
								double phanTram = (doanhThu / tongDoanhThu) * 100;
								if (loaiPhong.equals("Đơn")) {
									//Làm tròn doanh thu thành triệu
									doanhThu = Math.round(doanhThu / 1000000);
									//Them Doanh thu vào lblSoDon
									lblSoDon.setText(doanhThu + " triệu\n");
									String existingText = lblDon.getText();
									String newText = loaiPhong + ": <b>" + "("+ String.format("%.1f", phanTram) + ")" + "%</b>\n";
									lblDon.setText("<html>" + existingText + newText + "</html>");
									
						
								} else if (loaiPhong.equals("Đôi")) {
									// Làm tròn doanh thu thành triệu
									doanhThu = Math.round(doanhThu / 1000000);
									// Them Doanh thu vào lblSoDoi
									lblSoDoi.setText(doanhThu + " triệu\n");

									String existingText = lblDoi.getText();
									String newText = loaiPhong + ": <b>" + "("+ String.format("%.1f", phanTram) + ")" + "%</b>\n";
									lblDoi.setText("<html>" + existingText + newText + "</html>");

								} else if (loaiPhong.equals("VIP")) {
									// Làm tròn doanh thu thành triệu
									doanhThu = Math.round(doanhThu / 1000000);
									// Them Doanh thu vào lblSoVip
									lblSoVip.setText(doanhThu + " triệu\n");
									String existingText = lblVip.getText();
									String newText = loaiPhong + ": <b>" + "("+ String.format("%.1f", phanTram) + ")" + "%</b>\n";
									lblVip.setText("<html>" + existingText + newText + "</html>");
								}
							}
							
							
							
							// Set màu cho lbl
							lblSoDon.setForeground(new Color(144, 238, 144));
							lblSoDoi.setForeground(new Color(255, 144, 144));
							lblSoVip.setForeground(new Color(68, 138, 255));
							// Add các lbl vào panel
						
							panelDon.add(lblSoDon);
			
							panelDon.add(Box.createRigidArea(new Dimension(0, 20)));
							panelDon.add(lblDon);
							panelDoi.add(lblSoDoi);
							panelDoi.add(Box.createRigidArea(new Dimension(0, 20)));
							panelDoi.add(lblDoi);
							panelVip.add(lblSoVip);
							panelDoi.add(Box.createRigidArea(new Dimension(0, 20)));
							panelVip.add(lblVip);
							// Add panel vào panle_ChiTietPDP
							panelDon.setBackground(Color.WHITE);
							panelDoi.setBackground(Color.WHITE);
							panelVip.setBackground(Color.WHITE);
							panle_ChiTietPDP.add(panelDon);
							//Set khoảng cách
							panle_ChiTietPDP.add(Box.createRigidArea(new Dimension(0, 15)));
							panle_ChiTietPDP.add(panelDoi);
							panle_ChiTietPDP.add(Box.createRigidArea(new Dimension(0, 15)));
							panle_ChiTietPDP.add(panelVip);
							
				             
				     
				             
				             panel_5.removeAll();
				             panel_5.add(chartPanel);
				             //Them panel chi tiet vao bên phải
				             panel_5.add(panle_ChiTietPDP, BorderLayout.EAST);
				             panel_5.revalidate();
				             panel_5.repaint();
				             
				             
				             // Vẽ biểu đồ đường
				             DefaultCategoryDataset datasetDuong = createDatasetDuong();
				             JFreeChart chartDuong = createChartVTr2(datasetDuong);
				             ChartPanel chartPanelDuong = new ChartPanel(chartDuong);
				             chartPanelDuong.setPreferredSize(new Dimension(450, 280));
				             chartPanelDuong.setBackground(Color.WHITE);
				             chartPanelDuong.setBorder(null);
				             panel_5_1.removeAll();
				             panel_5_1.add(chartPanelDuong);
				             panel_5_1.revalidate();
				             panel_5_1.repaint();
							
							
						}
						// Lấy dữ liệu để vẽ biểu đồ tròn cho từng loại phòng
						private DefaultPieDataset createDatasetPDP() {
							DefaultPieDataset dataset = new DefaultPieDataset();
							// Lấy danh sách các loại phòng
							HashMap<String, Double> dsLoaiPhong = new HashMap<String, Double>();
							for (PhieuDatPhong pdp : dsPDP) {
								String loaiPhong = pdp.getPhong().getLoaiPhong();
								double donGia = pdp.getDonGiaPhieu();
								if (dsLoaiPhong.containsKey(loaiPhong)) {
									double tongTien = dsLoaiPhong.get(loaiPhong) + donGia;
									dsLoaiPhong.put(loaiPhong, tongTien);
								} else {
									dsLoaiPhong.put(loaiPhong, donGia);
								}
							}
							// Đổ dữ liệu từ hashMap vào dataset
							for (Entry<String, Double> entry : dsLoaiPhong.entrySet()) {
								String loaiPhong = entry.getKey();
								double doanhThu = entry.getValue();
								dataset.setValue(loaiPhong, doanhThu);
							}
							
							return dataset;
						}
						 // Vẽ biểu đồ tròn
						private JFreeChart createChartPDP(PieDataset dataset) {
							// Tong doanh thu
							double tongDoanhThu = 0;
							for (PhieuDatPhong pdp : dsPDP) {
								tongDoanhThu += pdp.getDonGiaPhieu();
							}
							// Làm tròn tổng doanh thu
							tongDoanhThu = Math.round(tongDoanhThu / 1000000);
							CustomRingPlot plot = new CustomRingPlot(dataset, String.valueOf(tongDoanhThu));
							plot.setSectionPaint("Đơn", new Color(144, 238, 144));
							plot.setSectionPaint("Đôi", new Color(255, 144, 144));
							//Set màu xanh
							plot.setSectionPaint("VIP", new Color(68, 138, 255));
							plot.setInsets(new RectangleInsets(0, 5, 5, 5));
							plot.setSectionDepth(0.50);
							plot.setBackgroundPaint(Color.WHITE);
							plot.setShadowPaint(null);
							plot.setOutlineVisible(false);
							plot.setLabelGenerator(null);
			
							 // Thêm tiêu đề phụ
							// Lấy ngày thánh năm hiện tại
							Calendar cal = Calendar.getInstance();
							// ép kiểu về String
							String date = cal.getTime().toString();
					        TextTitle subtitle = new TextTitle("Tính đến "+ date , new Font("Dialog", Font.PLAIN, 14));
					        subtitle.setPosition(RectangleEdge.TOP);
					        
		
							JFreeChart chart = new JFreeChart("Doanh thu theo loại phòng", JFreeChart.DEFAULT_TITLE_FONT, plot,
									true);
							chart.addSubtitle(subtitle);

						

							return chart;
						}
						//Tạo dữ liệu để vẽ biểu đồ đường
						public DefaultCategoryDataset createDatasetDuong() {
					        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					        // Lấy danh sách các loại phòng qua từng năm
					
							for(int i = 2021; i <= 2024; i++) {
								double doanhThuDon = 0;
								double doanhThuDoi = 0;
								double doanhThuVip = 0;
								for (PhieuDatPhong pdp : dsPDP) {
									if (pdp.getThoiGianDat().getYear() == i) {
										if (pdp.getPhong().getLoaiPhong().equals("Đơn")) {
											doanhThuDon += pdp.getDonGiaPhieu();
										} else if (pdp.getPhong().getLoaiPhong().equals("Đôi")) {
											doanhThuDoi += pdp.getDonGiaPhieu();
										} else if (pdp.getPhong().getLoaiPhong().equals("VIP")) {
											doanhThuVip += pdp.getDonGiaPhieu();
										}
									}
								}
						
								// Đổ dữ liệu vào dataset
								dataset.addValue(doanhThuDon, "Đơn", String.valueOf(i));
								dataset.addValue(doanhThuDoi, "Đôi", String.valueOf(i));
								dataset.addValue(doanhThuVip, "VIP", String.valueOf(i));
							}
							return dataset;
					        
					    }
						// Tạo biểu đồ đường
						private JFreeChart createChartVTr2(CategoryDataset dataset) {
							JFreeChart chart = ChartFactory.createLineChart("Doanh thu thuê phòng qua từng năm", // chart
									// title
									"năm", // domain axis label
									"Doanh thu", // range axis label
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
							Calendar cal = Calendar.getInstance();
							// ép kiểu về String
							String date = cal.getTime().toString();
					        TextTitle subtitle = new TextTitle("Tính đến "+ date , new Font("Dialog", Font.PLAIN, 14));
					        subtitle.setPosition(RectangleEdge.TOP);
					        chart.addSubtitle(subtitle);
							return chart;
						}
					});
					btnDoanhThuDV.addActionListener(new ActionListener() {
						
						private ArrayList<PhieuDatDichVu> dsPDV;
						private ArrayList<DichVu> dsDV;
						private JPanel panle_ChiTietPDP;

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							dsPDV  = new DAO_PhieuDatDichVu().getDSPhieuDatDichVu();
							dsDV = new DAO_DichVu().getAllDichVu();
							//add dv vào phiếu đặt dv
							for (PhieuDatDichVu pdv : dsPDV) {
								for (DichVu dv : dsDV) {
									if (pdv.getDichVu().getMaDichVu().equals(dv.getMaDichVu())) {
										pdv.setDichVu(dv);
									}
								}
							}
							// Tạo biểu đồ tròn
							DefaultPieDataset dataset = createDatasetPDV();
							JFreeChart chart = createChartPDV(dataset);
							chart.setBackgroundPaint(Color.WHITE);
							ChartPanel chartPanel = new ChartPanel(chart);
							chartPanel.setPreferredSize(new Dimension(285, 260));
							chartPanel.setBackground(Color.WHITE);
							chartPanel.setBorder(null);
							
							
							
							// add biểu đồ tròn
							panel_5.removeAll();
							panel_5.add(chartPanel);
							panel_5.revalidate();
							panel_5.repaint();
							// Tạo hashmap tính phần trăm của từng loại hình dịch vụ
							HashMap<String, Double> dsLoaiDV = new HashMap<String, Double>();
							double tongDoanhThu = 0;
							for (PhieuDatDichVu pdv : dsPDV) {
								String loaiDV = pdv.getDichVu().getTenDichVu();
								double donGia = pdv.getDonGia();
								if (dsLoaiDV.containsKey(loaiDV)) {
									double tongTien = dsLoaiDV.get(loaiDV) + donGia;
									dsLoaiDV.put(loaiDV, tongTien);
								} else {
									dsLoaiDV.put(loaiDV, donGia);
								}
								tongDoanhThu += donGia;
							}
							// Tạo panel chi tiết
					        panle_ChiTietPDP = new JPanel();
					        panle_ChiTietPDP.setBackground(Color.WHITE);
					        panle_ChiTietPDP.setLayout(new BoxLayout(panle_ChiTietPDP, BoxLayout.Y_AXIS));
					        panle_ChiTietPDP.add(Box.createRigidArea(new Dimension(0, 40)));
					        // Tính phần trăm và thêm thông tin vào panel chi tiết
					        for (Entry<String, Double> entry : dsLoaiDV.entrySet()) {
					            String loaiDV = entry.getKey();
					            double doanhThu = entry.getValue();
					          
					            double phanTram = (doanhThu / tongDoanhThu) * 100;
					            // Bỏ chữ Dịch vụ trong tên dịch vụ
					            loaiDV = loaiDV.replace("Dịch vụ ", "");
					            // Làm tròn doanh thu thành triệu
					            doanhThu = Math.round(doanhThu / 1000000); 
					          
					            JLabel lbl = new JLabel();
					            lbl.setFont(new Font("Dialog", Font.PLAIN, 12));
					            String existingText = lbl.getText();
					  
								String newText = loaiDV + ": <b>" + "("+ String.format("%.1f", phanTram) + ")" + "%</b>\n";
							
								lbl.setText("<html>" + existingText + newText + "</html>");
								
								
								// Làm tròn doanh thu thành triệu
								JLabel lblDT = new JLabel();
								lblDT.setText(doanhThu + " triệu\n");
								// Tạo màu cho lbl
								if (loaiDV.equals("ăn uống")) {
									lblDT.setForeground(new Color(144, 238, 144));
								} else if (loaiDV.equals("giặc ủi")) {
									lblDT.setForeground(new Color(255, 144, 144));
								} else if (loaiDV.equals("bơi")) {
									lblDT.setForeground(new Color(68, 138, 255));
								} else if (loaiDV.equals("thú cưng")) {
									lblDT.setForeground(new Color(255, 215, 0));
								} else if (loaiDV.equals("chăm sóc sắc đẹp")) {
									lblDT.setForeground(new Color(255, 105, 180));
								}
								
					            //Set khoản cách
			
					            JPanel panelCT = new JPanel();
					            panelCT.setBackground(Color.WHITE);
						        panelCT.setLayout(new BoxLayout(panelCT, BoxLayout.Y_AXIS));
					            panelCT.add(lbl);
					            panelCT.add(lblDT);
					            panle_ChiTietPDP.add(panelCT);
					            panle_ChiTietPDP.add(Box.createRigidArea(new Dimension(0, 10)));
				
					        }

					        // Add panel chi tiết vào giao diện chính bên phải
					        panel_5.add(panle_ChiTietPDP, BorderLayout.EAST);
					        panel_5.revalidate();
					        panel_5.repaint();
					        
					        // Vẽ biểu đồ đường
					        DefaultCategoryDataset datasetDuongDV = createDatasetDuongDV();
					        JFreeChart chartDuongDV = createChartVTr2DV(datasetDuongDV);
					        ChartPanel chartPanelDuongDV = new ChartPanel(chartDuongDV);
					        chartPanelDuongDV.setPreferredSize(new Dimension(450, 280));
					        chartPanelDuongDV.setBackground(Color.WHITE);
					        chartPanelDuongDV.setBorder(null);
					        panel_5_1.removeAll();
					        panel_5_1.add(chartPanelDuongDV);
					        panel_5_1.revalidate();
					        panel_5_1.repaint();
					        
							
							
							
							
							
						}
						//Tạo dữ liệu để vẽ biểu đồ tròn
						private DefaultPieDataset createDatasetPDV() {
							DefaultPieDataset dataset = new DefaultPieDataset();
							// Lấy danh sách các loại dịch vụ
							HashMap<String, Double> dsLoaiDV = new HashMap<String, Double>();
							for (PhieuDatDichVu pdv : dsPDV) {
								String loaiDV = pdv.getDichVu().getTenDichVu();
								double donGia = pdv.getDonGia();
								if (dsLoaiDV.containsKey(loaiDV)) {
									double tongTien = dsLoaiDV.get(loaiDV) + donGia;
									dsLoaiDV.put(loaiDV, tongTien);
								} else {
									dsLoaiDV.put(loaiDV, donGia);
								}
							}
							// Đổ dữ liệu từ hashMap vào dataset
							for (Entry<String, Double> entry : dsLoaiDV.entrySet()) {
								String loaiDV = entry.getKey();
								double doanhThu = entry.getValue();
								dataset.setValue(loaiDV, doanhThu);
							}

							return dataset;
						}
						// Vẽ biểu đồ tròn
						private JFreeChart createChartPDV(PieDataset dataset) {
	                        // Tong doanh thu
	                        double tongDoanhThu = 0;
	                        for (PhieuDatDichVu pdv : dsPDV) {
	                            tongDoanhThu += pdv.getDonGia();
	                        }
	                        // Làm tròn tổng doanh thu
	                        tongDoanhThu = Math.round(tongDoanhThu / 1000000);
	                        CustomRingPlot plot = new CustomRingPlot(dataset, String.valueOf(tongDoanhThu));
	                        // Tạo Chuỗi string gồm các màu tương ứng với số lượng loại dịch vụ
	                        
	                        plot.setSectionPaint("Dịch vụ ăn uống", new Color(144, 238, 144));
	                        
	                        plot.setSectionPaint("Dịch vụ giặc ủi", new Color(255, 144, 144));
	                        plot.setSectionPaint("Dịch vụ bơi", new Color(68, 138, 255));
	                        plot.setSectionPaint("Dịch vụ thú cưng", new Color(255, 215, 0));
	                        plot.setSectionPaint("Dịch vụ chăm sóc sắc đẹp", new Color(255, 105, 180));
	                        
	                
	                   
	                        plot.setInsets(new RectangleInsets(0, 5, 5, 5));
	                        plot.setSectionDepth(0.50);
	                        plot.setBackgroundPaint(Color.WHITE);
	                        plot.setShadowPaint(null);
	                        plot.setOutlineVisible(false);
	                        plot.setLabelGenerator(null);
	                        
	                      
	                        // Thêm tiêu đề phụ
	                       
	                        JFreeChart chart = new JFreeChart("Doanh thu theo loại dịch vụ", JFreeChart.DEFAULT_TITLE_FONT, plot,
	                                false);
	                     // Lấy ngày thánh năm hiện tại
							Calendar cal = Calendar.getInstance();
							// ép kiểu về String
							String date = cal.getTime().toString();
					        TextTitle subtitle = new TextTitle("Tính đến "+ date , new Font("Dialog", Font.PLAIN, 14));
					        subtitle.setPosition(RectangleEdge.TOP);
					        chart.addSubtitle(subtitle);
	                      
	                        return chart;
	                    }
						//Tạo dữ liệu vẽ biểu đồ đường
						public DefaultCategoryDataset createDatasetDuongDV() {
                            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                            // Lấy danh sách các loại dịch vụ qua từng năm
                            for(int i = 2021; i <= 2024; i++) {
                                double doanhThuAnUong = 0;
                                double doanhThuGiatUi = 0;
                                double doanhThuBoi = 0;
                                double doanhThuThuCung = 0;
                                double doanhThuChamSoc = 0;
                                for (PhieuDatDichVu pdv : dsPDV) {
                                    if (pdv.getThoiGianDat().getYear() == i) {
                                        if (pdv.getDichVu().getTenDichVu().equals("Dịch vụ ăn uống")) {
                                            doanhThuAnUong += pdv.getDonGia();
                                        } else if (pdv.getDichVu().getTenDichVu().equals("Dịch vụ giặc ủi")) {
                                            doanhThuGiatUi += pdv.getDonGia();
                                        } else if (pdv.getDichVu().getTenDichVu().equals("Dịch vụ bơi")) {
                                            doanhThuBoi += pdv.getDonGia();
                                        } else if (pdv.getDichVu().getTenDichVu().equals("Dịch vụ thú cưng")) {
                                            doanhThuThuCung += pdv.getDonGia();
                                        } else if (pdv.getDichVu().getTenDichVu().equals("Dịch vụ chăm sóc sắc đẹp")) {
                                            doanhThuChamSoc += pdv.getDonGia();
                                        }
                                    }
                                }
                                // Đổ dữ liệu vào dataset
                                dataset.addValue(doanhThuAnUong, "ăn uống", String.valueOf(i));
                                dataset.addValue(doanhThuGiatUi, "giặc ủi", String.valueOf(i));
                                dataset.addValue(doanhThuBoi, "bơi", String.valueOf(i));
                                dataset.addValue(doanhThuThuCung, "thú cưng", String.valueOf(i));
                                dataset.addValue(doanhThuChamSoc, "chăm sóc sắc đẹp", String.valueOf(i));
                                
						
                            }
						return dataset;   
						}
						// Vẽ biểu đồ đường
						private JFreeChart createChartVTr2DV(CategoryDataset dataset) {
							JFreeChart chart = ChartFactory.createLineChart("Doanh thu dịch vụ qua từng năm", // chart
									// title
									"Năm", // domain axis label
									"Doanh thu", // range axis label
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
							renderer.setSeriesStroke(4, new BasicStroke(3.0f));
							renderer.setSeriesPaint(0, new Color(144, 238, 144));
							LegendTitle legend = chart.getLegend();
							legend.setPosition(RectangleEdge.BOTTOM);
							Calendar cal = Calendar.getInstance();
							// ép kiểu về String
							String date = cal.getTime().toString();
							TextTitle subtitle = new TextTitle("Tính đến " + date, new Font("Dialog", Font.PLAIN, 14));
							subtitle.setPosition(RectangleEdge.TOP);
							chart.addSubtitle(subtitle);
							return chart;
						}
					});
					
					
					
					
					
					
					btnDoanhThuTng_2.addActionListener(new ActionListener() {
						
						private ArrayList<HoaDon> dsHD;
						private ArrayList<PhieuDatPhong> dsPDP;
						private JPanel panle_ChiTiet;
						private ArrayList<PhieuDatDichVu> dsPDV;
						private JLabel lblDTPhong;
						private JLabel lblDTDV;
						private JLabel lblPhong;
						private JLabel lblDichVu;
						private JLabel lblSoPhong;
						private JLabel lblSoDichVu;
						private JPanel panelPhong;
						private JPanel panelDichVu;
			
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							dsHD = new DAO_HoaDon().getalltbHoaDon();
							dsPDP  = new PhieuDatPhong_DAO().getAllTbPhieuDatPhong();
							dsPDV = new DAO_PhieuDatDichVu().getDSPhieuDatDichVu();
							// Tạo StackBar
							DefaultCategoryDataset datasetStackBar = createDatasetStackBar();
							JFreeChart chartStackBar = createChartStackBar(datasetStackBar);
							chartStackBar.setBackgroundPaint(Color.WHITE);
							ChartPanel chartPanelStackBar = new ChartPanel(chartStackBar);
							chartPanelStackBar.setPreferredSize(new Dimension(650, 400));
							chartPanelStackBar.setBackground(Color.WHITE);
							chartPanelStackBar.setBorder(null);
							panelDTPh.removeAll();
							panelDTPh.add(chartPanelStackBar);
							panelDTPh.revalidate();
							panelDTPh.repaint();
							
							//Vẽ biểu đồ tròn
							DefaultPieDataset dataset = createDatasetPDV();
							JFreeChart chart = createChartDTTrc(dataset);
							chart.setBackgroundPaint(Color.WHITE);
							ChartPanel chartPanel = new ChartPanel(chart);
							chartPanel.setPreferredSize(new Dimension(210, 140));
							chartPanel.setBackground(Color.WHITE);
							chartPanel.setBorder(null);
							panelDTR.removeAll();
							panelDTR.add(chartPanel);
							panelDTR.revalidate();
							panelDTR.repaint();
							//Tính phần trăm doanh thu và dich vu
							HashMap<String, Double> dsDT = new HashMap<String, Double>();
							double DoanhThuP = 0;
							double DoanhThuDV = 0;
							double TongDoanhThu = 0;
							for (PhieuDatPhong pdp : dsPDP) {
								
								DoanhThuP += pdp.getDonGiaPhieu();
							}
							for (PhieuDatDichVu pdv : dsPDV) {

								DoanhThuDV += pdv.getDonGia();
							}
							TongDoanhThu = DoanhThuP + DoanhThuDV;
							// thêm vào HashMap
							dsDT.put("Doanh thu PHÒNG", DoanhThuP);
							dsDT.put("Doanh thu DỊCH VỤ", DoanhThuDV);
							lblPhong = new JLabel();
				            lblDichVu = new JLabel();
				            lblSoPhong = new JLabel();
				            lblSoDichVu = new JLabel();
				            panle_ChiTiet = new JPanel();
				            panle_ChiTiet.setBackground(Color.WHITE);
		
				             //Set cỡ chữ
				            lblSoPhong.setFont(new Font("Dialog", Font.BOLD, 13));
				            lblSoDichVu.setFont(new Font("Dialog", Font.BOLD, 13));
				            lblPhong.setFont(new Font("Dialog", Font.PLAIN, 10));
				            lblDichVu.setFont(new Font("Dialog", Font.PLAIN, 10));
				            panelPhong = new JPanel();
				            panelDichVu = new JPanel();
							 for (Entry<String, Double> entry : dsDT.entrySet()) {
								String loaiDT = entry.getKey().trim();
								// Cắt chữ Dịch vụ
								loaiDT = loaiDT.replace("Doanh thu ", "");
								double doanhThu = entry.getValue();
								// Ép kiểu double sang String
								
								double phanTram = (doanhThu / TongDoanhThu) * 100;
								if (loaiDT.equals("PHÒNG")) {
									//Làm tròn doanh thu thành triệu
									doanhThu = Math.round(doanhThu / 1000000);
									//Them Doanh thu vào lblSoDon
									lblSoPhong.setText(doanhThu + " triệu\n");
									String existingText = lblPhong.getText();
									String newText = loaiDT + ": <b>" + "("+ String.format("%.1f", phanTram) + ")" + "%</b>\n";
									lblPhong.setText("<html>" + existingText + newText + "</html>");
									
						
								} else if (loaiDT.equals("DỊCH VỤ")) {
									// Làm tròn doanh thu thành triệu
									doanhThu = Math.round(doanhThu / 1000000);
									// Them Doanh thu vào lblSoDoi
									lblSoDichVu.setText(doanhThu + " triệu\n");

									String existingText = lblDichVu.getText();
									String newText = loaiDT + ": <b>" + "("+ String.format("%.1f", phanTram) + ")" + "%</b>\n";
									lblDichVu.setText("<html>" + existingText + newText + "</html>");

								}
							}
							
							
							
							// Set màu cho lbl
							lblSoPhong.setForeground(new Color(144, 238, 144));
							lblSoDichVu.setForeground(new Color(255, 144, 144));
						
							// Add các lbl vào panel
						
							panelPhong.add(lblSoPhong);
							panelPhong.add(Box.createRigidArea(new Dimension(0, 0)));
							panelPhong.add(lblPhong);
							panelDichVu.add(lblSoDichVu);
							panelDichVu.add(Box.createRigidArea(new Dimension(0, 0)));
							panelDichVu.add(lblDichVu);
						
							// Add panel vào panle_ChiTietPDP
							panelPhong.setBackground(Color.WHITE);
							panelDichVu.setBackground(Color.WHITE);
							// set panel chi tiết thêm Y_AXIS
							panle_ChiTiet.setLayout(new BoxLayout(panle_ChiTiet, BoxLayout.Y_AXIS));
							panle_ChiTiet.add(panelPhong);
							//Set khoảng cách
							panle_ChiTiet.add(Box.createRigidArea(new Dimension(0, -9)));
							panle_ChiTiet.add(panelDichVu);
						
							panelDTR.add(panle_ChiTiet);
							
							panelDTR.revalidate();
							panelDTR.repaint();
							
							//Vẽ biểu đồ thuế
							DefaultCategoryDataset datasetT = createDatasetTienThue();
							JFreeChart chartT = createChartTienThue(datasetT);
							chartT.setBackgroundPaint(Color.WHITE);
							ChartPanel chartPanelT = new ChartPanel(chartT);
							chartPanelT.setPreferredSize(new Dimension(226, 200));
							chartPanelT.setBackground(Color.WHITE);
							chartPanelT.setBorder(null);
							panelDTR_1.removeAll();
							panelDTR_1.add(chartPanelT);
							panelDTR_1.revalidate();
							panelDTR_1.repaint();
							
							
							
							
						}
					
						//Tạo dữ liệu để vẽ StackBar
						private DefaultCategoryDataset createDatasetStackBar() {
							DefaultCategoryDataset dataset = new DefaultCategoryDataset();
							// Lấy danh sách các loại hóa đơn qua từng năm
							for (int i = 2020; i <= 2024; i++) {
								double doanhThu = 0;
								double doanhThuPhong = 0;
								double doanhThuDichVu = 0;
								
								for (PhieuDatPhong pdp : dsPDP) {
									if (pdp.getThoiGianDat().getYear() == i) {
										doanhThuPhong += pdp.getDonGiaPhieu();
									}
								}
								for (PhieuDatDichVu pdv : dsPDV) {
									if (pdv.getThoiGianDat().getYear() == i) {
										doanhThuDichVu += pdv.getDonGia();
									}
								}
								// Làm tròn doanh thu thành triệu
							
								// Đổ dữ liệu vào dataset
								dataset.addValue(doanhThuPhong, "Doanh thu phòng", String.valueOf(i));
								dataset.addValue(doanhThuDichVu, "Doanh thu dịch vụ", String.valueOf(i));
							}
							return dataset;
						}
						// Vẽ biểu đồ StackBar
						private JFreeChart createChartStackBar(CategoryDataset dataset) {
						    JFreeChart chart = ChartFactory.createStackedBarChart(
						            "Doanh thu phòng và dịch vụ qua từng năm", // chart title
						            "Năm", // domain axis label
						            "Doanh thu (triệu VND)", // range axis label
						            dataset, // data
						            PlotOrientation.VERTICAL, // orientation
						            true, // include legend
						            true, // tooltips
						            false // urls
						    );

						    // Set chart background
						    chart.setBackgroundPaint(Color.WHITE);

						    // Customize plot
						    CategoryPlot plot = chart.getCategoryPlot();
						    plot.setBackgroundPaint(Color.WHITE);
						    plot.setRangeGridlinePaint(Color.BLACK);

						    // Customize renderer for the bar chart
						    BarRenderer barRenderer = (BarRenderer) plot.getRenderer();
						    barRenderer.setSeriesPaint(0, new Color(144, 238, 144)); // Light Green
						    barRenderer.setSeriesPaint(1, new Color(255, 144, 144)); // Light Red
						    barRenderer.setShadowVisible(false);

						    // Customize legend
						    LegendTitle legend = chart.getLegend();
						    legend.setPosition(RectangleEdge.BOTTOM);

						    // Add a subtitle with the current date
						    Calendar cal = Calendar.getInstance();
						    String date = cal.getTime().toString();
						    TextTitle subtitle = new TextTitle("Tính đến " + date, new Font("Dialog", Font.PLAIN, 14));
						    subtitle.setPosition(RectangleEdge.TOP);
						    chart.addSubtitle(subtitle);

						    // Create a new dataset for growth rate
						    DefaultCategoryDataset growthDataset = new DefaultCategoryDataset();
						    for (int i = 2020; i <= 2024; i++) {
						        // Lấy doanh thu năm hiện tại và năm trước
						        double doanhThuHienTai = 0;
						        double doanhThuNamTruoc = 0;
						        for (HoaDon hd : dsHD) {
						            if (hd.getNgayLap().getYear() == i) {
						                doanhThuHienTai += hd.getThanhTien();
						            } else if (hd.getNgayLap().getYear() == i - 1) {
						                doanhThuNamTruoc += hd.getThanhTien();
						            }
						        }

						        // Calculate growth rate
						        double growthRate = 0; // Default value when doanhThuNamTruoc is zero
						        if (doanhThuNamTruoc != 0) {
						            growthRate = ((doanhThuHienTai - doanhThuNamTruoc) / doanhThuNamTruoc) * 100;
						        }

						        // Add growth rate to the dataset
						        growthDataset.addValue(growthRate, "Doanh thu tăng trưởng so với cùng kì năm ngoái", String.valueOf(i));
						    }

						    // Create a new renderer for the growth rate line
						    LineAndShapeRenderer lineRenderer = new LineAndShapeRenderer();
						    lineRenderer.setSeriesPaint(0, Color.BLUE);

						    // Add the growth rate dataset and renderer to the plot
						    plot.setDataset(1, growthDataset);
						    plot.setRenderer(1, lineRenderer);

						  
						    
						 // Tạo một NumberAxis mới cho plot thứ hai (biểu đồ đường)
						    NumberAxis growthAxis = new NumberAxis("Tỷ lệ tăng trưởng (%)");
						    plot.setRangeAxis(1, growthAxis);
						    plot.mapDatasetToRangeAxis(1, 1);

						    // Đặt plot thứ hai ở vị trí cao hơn bằng cách thiết lập khoảng cách trên của plot thứ hai
//						    plot.setFixedRangeAxisSpace(new AxisSpace());

						    // Đảm bảo plot thứ nhất không đè lên plot thứ hai
						    plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

						    return chart;
						}

						//Tạo dữ liệu vẽ biểu đồ tròn
						private DefaultPieDataset createDatasetPDV() {
							DefaultPieDataset dataset = new DefaultPieDataset();
							// Lấy doanh thu của phòng
							double doanhThuPhong = 0;
							for (PhieuDatPhong pdp : dsPDP) {
								doanhThuPhong += pdp.getDonGiaPhieu();
							}
							// Lấy doanh thu của dịch vụ
							double doanhThuDichVu = 0;
							for (PhieuDatDichVu pdv : dsPDV) {
								doanhThuDichVu += pdv.getDonGia();
							}
							// Đổ dữ liệu vào dataset biểu đồ tròn
							dataset.setValue("Doanh thu phòng", doanhThuPhong);
							dataset.setValue("Doanh thu dịch vụ", doanhThuDichVu);
							

							return dataset;
						}
						// Vẽ biểu đồ tròn
						private JFreeChart createChartDTTrc(PieDataset dataset) {
	                        //Tính tổng doanh thu bằng tổng cột 2 trong dataset
							double tongDoanhThu = 0;
							for (int i = 0; i < dataset.getItemCount(); i++) {
								tongDoanhThu += dataset.getValue(i).doubleValue();
							}
							// Làm tròn tổng doanh thu
							tongDoanhThu = Math.round(tongDoanhThu / 1000000);
							                            
	                        CustomRingPlot plot = new CustomRingPlot(dataset, String.valueOf(tongDoanhThu));
	                        // Tạo Chuỗi string gồm các màu tương ứng với số lượng loại dịch vụ
	                        
	                        plot.setSectionPaint("Doanh thu phòng", new Color(144, 238, 144));
	                        plot.setSectionPaint("Doanh thu dịch vụ", new Color(255, 144, 144));
	                        
	                
	                 
	                        plot.setInsets(new RectangleInsets(0, 5, 5, 5));
	                        plot.setSectionDepth(0.50);
	                        plot.setBackgroundPaint(Color.WHITE);
	                        plot.setShadowPaint(null);
	                        plot.setOutlineVisible(false);
	                        plot.setLabelGenerator(null);
	                        
	                      
	                        // Thêm tiêu đề phụ
	                       
	                        JFreeChart chart = new JFreeChart("Doanh thu theo loại dịch vụ", JFreeChart.DEFAULT_TITLE_FONT, plot,
	                                false);
	                     // Lấy ngày thánh năm hiện tại
							Calendar cal = Calendar.getInstance();
							// ép kiểu về String
							String date = cal.getTime().toString();
					        TextTitle subtitle = new TextTitle("Tính đến "+ date , new Font("Dialog", Font.PLAIN, 14));
					        subtitle.setPosition(RectangleEdge.TOP);
					        chart.addSubtitle(subtitle);
	                      
	                        return chart;
	                    }
						// Tạo dữ liệu để vẽ biểu đồ cột tiền thuế
						private DefaultCategoryDataset createDatasetTienThue() {
							DefaultCategoryDataset dataset = new DefaultCategoryDataset();
							// Lấy danh sách các loại hóa đơn qua từng tháng
							for (int i = 2020; i <= 2024; i++) {
								double tienThue = 0;
								for (HoaDon hd : dsHD) {
									if (hd.getNgayLap().getYear() == i) {
										tienThue += hd.getThanhTien() - hd.getGiaTrcThue();
									}
								}
								// Đổ dữ liệu vào dataset
								dataset.addValue(tienThue, "Tiền thuế", "" + i);
							}
							return dataset;
						}
						// Vẽ biểu đồ cột tiền thuế
						private JFreeChart createChartTienThue(CategoryDataset dataset) {
							JFreeChart chart = ChartFactory.createBarChart("Tiền thuế qua từng năm", // chart title
									"", // domain axis label
									"", // range axis label
									dataset, // data
									PlotOrientation.VERTICAL, // orientation
									true, // include legend
									true, // tooltips
									false // urls
							);
							chart.setTitle(new TextTitle("Tiền thuế qua từng năm", new Font("SansSerif", Font.PLAIN, 20)));
							chart.setBackgroundPaint(Color.WHITE);
							CategoryPlot plot = chart.getCategoryPlot();
							plot.setBackgroundPaint(Color.WHITE);
							plot.setRangeGridlinePaint(Color.BLACK);
							BarRenderer barRenderer = (BarRenderer) plot.getRenderer();
							// set màu xanh dương
							barRenderer.setSeriesPaint(0, new Color(68, 138, 255));
							LegendTitle legend = chart.getLegend();
							legend.setPosition(RectangleEdge.BOTTOM);
							Calendar cal = Calendar.getInstance();
							String date = cal.getTime().toString();
							
							chart.getCategoryPlot().setOrientation(PlotOrientation.HORIZONTAL);
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
							}
							if(clickedButton == btnKhchHng) {
			                    GUI_ThongKeKhachHang tkkh = new GUI_ThongKeKhachHang(nhanvien);
			                    tkkh.setVisible(true);
			                    dispose();
							}
							if (clickedButton == btnDoanhThu) {
								GUI_ThongKeDoanhThu tkdt = new GUI_ThongKeDoanhThu(nhanvien);
								tkdt.setVisible(true);
								dispose();
							}
							if(clickedButton == btnThngKNhn) {
			                    GUI_ThongKeNhanVien tknv = new GUI_ThongKeNhanVien(nhanvien);
			                    tknv.setVisible(true);
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
			                btnDoanhThu.addActionListener(actionListener);
			                btnThngKNhn.addActionListener(actionListener);
					
					
					                
	}

	
	
	

	
	public void setCbData() {
		// Đẩy 12 tháng vào các combobox
		for (int i = 1; i <= 12; i++) {
			cbPD.addItem("Tháng " + i);
			cbPH.addItem("Tháng " + i);
			cbDDV.addItem("Tháng " + i);
		
		}
		// Đẩy dữ liệu từ năm 2012 đến nay vào combobox
		for (int i = 2012; i <= 2024; i++) {
			cbTNV.addItem("Năm " + i);
			cbTNV_DV.addItem("Năm " + i);
			cbDoanhThu.addItem("Năm " + i);
		}
		
	}
	public void updateModelData() {
		// Xóa dữ liệu cũ
		model.setRowCount(0);
		// Lấy dữ liệu mới
		ArrayList<PhieuDatDichVu> dsPDV = new DAO_PhieuDatDichVu().getDSPhieuDatDichVu();
		ArrayList<DichVu> dsDV = new DAO_DichVu().getAllDichVu();
		// add dịch vụ vào dsPDV theo mã dv
		for (PhieuDatDichVu pdv : dsPDV) {
			for (DichVu dv : dsDV) {
				if (pdv.getDichVu().getMaDichVu().equals(dv.getMaDichVu())) {
					pdv.setDichVu(dv);
				}
			}
		}
		// Tìm số phiếu đặt cho mỗi dịch vụ
		HashMap<String, Double> dsDoanhThu = new HashMap<String, Double>();
		for (PhieuDatDichVu pdv : dsPDV) {
			String tenDV = pdv.getDichVu().getTenDichVu();
			double donGia = pdv.getDonGia();
			if (dsDoanhThu.containsKey(tenDV)) {
				double tongTien = dsDoanhThu.get(tenDV) + donGia;
				dsDoanhThu.put(tenDV, tongTien);
			} else {
				dsDoanhThu.put(tenDV, donGia);
			}
		}
		//add top 3 dich vụ vào model
		int count = 0;
		for (Entry<String, Double> entry : dsDoanhThu.entrySet()) {
			String tenDV = entry.getKey();
			double doanhThu = entry.getValue();
			model.addRow(new Object[] { tenDV, doanhThu + " VND" });
			count++;
			if (count == 3) {
				break;
			}
		}
		// set Các txt
		// Tính tổng thuế VAT thuế VAT = Đơn giá - giá trc thuế
		double tongThueVAT = 0;
		double tongDoanhThu = 0;
		for (PhieuDatDichVu pdv : dsPDV) {
			tongThueVAT += pdv.getDonGia() - pdv.getGiaTrcThue();
			tongDoanhThu += pdv.getDonGia();
		}
		txtTThueVAT.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTThueVAT.setText(String.valueOf(tongThueVAT+ " VND"));
		// Tính tổng doanh thu
		txtDTDV.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDTDV.setText(String.valueOf(tongDoanhThu+ " VND"));
		// Tính sau khấu trừ
		double sauKTr = tongDoanhThu - tongThueVAT;
		txtSauKTr.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSauKTr.setText(String.valueOf(sauKTr+ " VND"));
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
	        Font font = new Font("SansSerif", Font.BOLD, 20);
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
	public void setDataTongDoanhThu() {
		double tongDoanhThu = 0;
		for (HoaDon hd : dsHD) {
			tongDoanhThu += hd.getThanhTien();
		}
		//Làm trong tổng doanh thu
		tongDoanhThu = Math.round(tongDoanhThu / 1000000);
		//Set font cho  txt
		txtTongDoanhThu.setFont(new Font("Dialog", Font.BOLD, 13));
		txtTongDoanhThu.setText(tongDoanhThu + " triệu VND");
		timDTNamCaoNhat(dsHD);
		timDTNamThapNhat(dsHD);
		
		
	}
	public void timDTNamCaoNhat(ArrayList<HoaDon> HoaDon) {
	// Tìm doanh thu năm cao nhất
	double maxDoanhThu = 0;
	int nam = 0;
	//Lấy năm hiện tại (int)
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	//Lấy 5 năm trước
	int year5 = year - 5;
	for (int i = year5; i <= year; i++) {
		double doanhThu = 0;
		for (HoaDon hd : HoaDon) {
			if (hd.getNgayLap().getYear() == i) {
				doanhThu += hd.getThanhTien();
			}
		}
		if (doanhThu > maxDoanhThu) {
			maxDoanhThu = doanhThu;
			nam = i;
		}
	}
	//Làm tròn tổng doanh thu
	maxDoanhThu = Math.round(maxDoanhThu / 1000000);
	//Set font cho  txt
	txtNamCaoNhat.setFont(new Font("Dialog", Font.BOLD, 13));
	txtNamCaoNhat.setText(maxDoanhThu + " triệu VND");
	}
	public void timDTNamThapNhat(ArrayList<HoaDon> HoaDon) {
		// Tìm doanh thu năm thấp nhất
		double minDoanhThu = Double.MAX_VALUE;
		int nam = 0;
		// Lấy năm hiện tại (int)
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		// Lấy 5 năm trước
		int year5 = year - 5;
		for (int i = year5; i <= year; i++) {
			double doanhThu = 0;
			for (HoaDon hd : HoaDon) {
				if (hd.getNgayLap().getYear() == i) {
					doanhThu += hd.getThanhTien();
				}
			}
			if (doanhThu < minDoanhThu) {
				minDoanhThu = doanhThu;
				nam = i;
			}
		}
		// Làm tròn tổng doanh thu
		minDoanhThu = Math.round(minDoanhThu / 1000000);
		// Set font cho  txt
		txtNamThapNhat.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNamThapNhat.setText(minDoanhThu + " triệu VND");
	}
}
