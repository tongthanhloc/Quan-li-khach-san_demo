package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_HoaDon;
import dao.DAO_PhieuDatDichVu;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatDichVu;
import entity.PhieuDatPhong;
import entity.Phong;



public class GUI_QuanLiHoaDon extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JPanel panel_Center_Top;
    private JLabel lblMahoaDon;
    private JTextField txtMahoaDon;
    private JLabel lblNgDatPhong;
    private JButton btnXoaTrang;
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
	private JTextField txtmaKH;
	private JTextField txtmaNhanVien;
	private JDateChooser dateNgaylap;
	private DAO_HoaDon hd_dao;
	private ArrayList<HoaDon> listtHD;
	private PhieuDatPhong_DAO pdp_dao;
	private ArrayList<PhieuDatPhong> listpdp;
	private DAO_PhieuDatDichVu pddv_dao;
	private ArrayList<PhieuDatDichVu> listpddv;
	private KhachHang_DAO kh_dao;
	private ArrayList<KhachHang> listKH;
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
		hd_dao = new DAO_HoaDon();
		listtHD = hd_dao.getalltbHoaDon();
		pdp_dao = new PhieuDatPhong_DAO();
		listpdp = pdp_dao.getAllTbPhieuDatPhong();
		pddv_dao = new DAO_PhieuDatDichVu();
		listpddv = pddv_dao.getDSPhieuDatDichVu();
		kh_dao = new KhachHang_DAO();
		listKH = kh_dao.getalltbKhachHang();
		
		
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
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setBounds(0, 0, 250, 70);
		panel_menu.add(btnTrangChu);
		
		
		btnQLP = new JButton("Quản lí phòng");
		btnQLP.setBackground(new Color(255, 255, 255));
		btnQLP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnQLP.setBounds(0, 70, 250, 70);
		panel_menu.add(btnQLP);
		
		
		btnQLHD = new JButton("Quản lí hóa đơn");
		btnQLHD.setBackground(new Color(41, 139, 106));
		btnQLHD.setForeground(new Color(255, 255, 255));
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
		panel_Center_Top.setBounds(250, 150, 1653, 218);
		Frame.add(panel_Center_Top);
		panel_Center_Top.setLayout(null);
		
		lblMahoaDon = new JLabel("Mã hóa đơn");
		lblMahoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMahoaDon.setBounds(140, 25, 126, 35);
		panel_Center_Top.add(lblMahoaDon);
		
		txtMahoaDon = new JTextField();
		txtMahoaDon.setBackground(new Color(41, 139, 116));
		txtMahoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMahoaDon.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMahoaDon);
		txtMahoaDon.setColumns(10);
		
		lblNgDatPhong = new JLabel("Ngày lập hóa đơn");
		lblNgDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgDatPhong.setBounds(888, 25, 175, 35);
		panel_Center_Top.add(lblNgDatPhong);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setBounds(1159, 156, 175, 35);
		panel_Center_Top.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBackground(new Color(234, 232, 214));
		btnXoaTrang.setBounds(1388, 156, 175, 35);
		panel_Center_Top.add(btnXoaTrang);
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		dateNgaylap = new JDateChooser();
		dateNgaylap.getCalendarButton().setBackground(new Color(41, 139, 116));
		dateNgaylap.setDateFormatString("dd-MM-yyyy");
		dateNgaylap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		dateNgaylap.setBounds(1104, 25, 350, 35);
		panel_Center_Top.add(dateNgaylap);
		
		JButton btnXemChiTit = new JButton("Xem chi tiết");
		btnXemChiTit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXemChiTit.setBackground(new Color(234, 232, 214));
		btnXemChiTit.setBounds(925, 156, 175, 35);
		panel_Center_Top.add(btnXemChiTit);
		
		JLabel lblMHan = new JLabel("Mã Khách Hàng");
		lblMHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMHan.setBounds(140, 88, 200, 35);
		panel_Center_Top.add(lblMHan);
		
		txtmaKH = new JTextField();
		txtmaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmaKH.setColumns(10);
		txtmaKH.setBackground(new Color(41, 139, 116));
		txtmaKH.setBounds(350, 88, 350, 40);
		panel_Center_Top.add(txtmaKH);
		
		JLabel lblNgyLpHa = new JLabel("Mã nhân viên");
		lblNgyLpHa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgyLpHa.setBounds(888, 88, 175, 35);
		panel_Center_Top.add(lblNgyLpHa);
		
		txtmaNhanVien = new JTextField();
		txtmaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmaNhanVien.setColumns(10);
		txtmaNhanVien.setBackground(new Color(41, 139, 116));
		txtmaNhanVien.setBounds(1104, 83, 350, 40);
		panel_Center_Top.add(txtmaNhanVien);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(256, 400, 1648, 615);

		
		String[] cols = new String[] {"Mã hóa đơn", "Ngày lập", "Mã nhân viên", "Mã khách hàng", "Tổng tiền"};
		modelHD = new DefaultTableModel(cols,0);
		panel_Center_Bot.setLayout(null);
		tableHD = new JTable(modelHD);
		tableHD.setBackground(new Color(234, 232, 214));
		tableHD.setRowHeight(30);
		JScrollPane paneNV = new JScrollPane(tableHD);
		paneNV.setBounds(10, 27, 1610, 632);
		paneNV.setPreferredSize(new Dimension(1000,1000));
		panel_Center_Bot.add(paneNV);;
		JTableHeader headers = tableHD.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 25);
        headers.setFont(headerFont);
        tableHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Frame.add(panel_Center_Bot);
		
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tim();
			}
		});
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMahoaDon.setText("");
				txtmaKH.setText("");
				txtmaNhanVien.setText("");
				dateNgaylap.setDate(null);
			}
		});
		btnXemChiTit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableHD.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xem");
				} else {
					String maHD = (String) tableHD.getValueAt(row, 0);
					HoaDon hd = hd_dao.timHoaDonTheoMa(maHD);
					for (NhanVien nv : ListNV) {
						if (hd.getNhanVien().getMaNV().equals(nv.getMaNV())) {
							hd.setNhanVien(nv);
						}
					}
					ArrayList<PhieuDatPhong> listPDP = new ArrayList<PhieuDatPhong>();
					ArrayList<PhieuDatDichVu> listPDDV = new ArrayList<PhieuDatDichVu>();
				    Phong_DAO dao_p = new Phong_DAO();
					ArrayList<Phong> listp = dao_p.getalltbPhong();
					for (PhieuDatPhong pdp : listpdp) {
						if (pdp.getHoaDon().getMaHoaDon()== null) {
							continue;
						}
						if (pdp.getHoaDon().getMaHoaDon().equals(maHD)) {
							for (KhachHang kh : listKH) {
								if (pdp.getKhachHang().getmaKH().equals(kh.getmaKH())) {
									pdp.setKhachHang(kh);
								}
							}
							
							listPDP.add(pdp);
							
						}
						
					}
					for (PhieuDatDichVu pddv : listpddv) {
						if (pddv.getHoaDon().getMaHoaDon().equals(maHD)) {
							listPDDV.add(pddv);
						}
					}
					//add phong
					for (PhieuDatPhong pdp : listPDP) {
						for (Phong p : listp) {
							if (pdp.getPhong().getMaPhong().equals(p.getMaPhong())) {
								pdp.setPhong(p);
							}
						}
					}
					
					GUI_ChiTietHoaDon ctHD = new GUI_ChiTietHoaDon(listPDP, listPDDV);
					ctHD.setmoiDuLieu(hd);
					ctHD.setVisible(true);
					
				}
			}
		});
		
		
		
	}
		//tim kiem hoa don
		public void tim() {
			String maHD = txtMahoaDon.getText();
			String maKH = txtmaKH.getText();
			String maNV = txtmaNhanVien.getText();
			LocalDate ngayLap = null;
//			LocalDate ngayLap = dateNgaylap.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			//kiem tra dateChoser co null khong
			if (dateNgaylap.getDate() != null) {
				ngayLap = dateNgaylap.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
			
			
			modelHD.setRowCount(0);
			
			ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
			dshd=timKiemHoaDon(new HoaDon(maHD, ngayLap, "", 0, 0, new NhanVien(maNV), new KhachHang(maKH)));
			if (dshd.size() == 0) {
				for (HoaDon hd : listtHD) {
					System.out.println(hd.getKhachHang().getmaKH().trim());
					String[] row = { hd.getMaHoaDon(), hd.getNgayLap().toString(), hd.getNhanVien().getMaNV().trim(),
							hd.getKhachHang().getmaKH().trim(), String.valueOf(hd.getThanhTien()) };
					modelHD.addRow(row);
				}
			} else {
				for (HoaDon hd : dshd) {
					String[] row = { hd.getMaHoaDon(), hd.getNgayLap().toString(), hd.getNhanVien().getMaNV(),
							hd.getKhachHang().getmaKH(), String.valueOf(hd.getThanhTien()) };
					modelHD.addRow(row);
				}
			}
		}
		
		//tim kiem hoa don
		public ArrayList<HoaDon> timKiemHoaDon(HoaDon hd) {
            ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
            ArrayList<HoaDon> dshdTimKiem = new ArrayList<HoaDon>();
            dshd = new DAO_HoaDon().getalltbHoaDon();
            for (HoaDon hoaDon : dshd) {
            	if (hd.getMaHoaDon() != null && !hd.getMaHoaDon().isEmpty() && !hd.getMaHoaDon().equals(hoaDon.getMaHoaDon())) {
            		continue;
            	}
            	if (hd.getNgayLap() != null && !hd.getNgayLap().equals(hoaDon.getNgayLap())) {
            		continue;
            	}
            	if (hd.getNhanVien() != null && !hd.getNhanVien().getMaNV().isEmpty() && !hd.getNhanVien().getMaNV().equals(hoaDon.getNhanVien().getMaNV())) {
            		continue;
            	}
            	if (hd.getKhachHang() != null && !hd.getKhachHang().getmaKH().isEmpty() && !hd.getKhachHang().getmaKH().equals(hoaDon.getKhachHang().getmaKH())) {
            		continue;
            	}
            	
            	dshdTimKiem.add(hoaDon);
            }
            return dshdTimKiem;
		}
		
        
		
		
		
		
	
}