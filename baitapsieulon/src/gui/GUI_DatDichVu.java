package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import entity.PhieuDatDichVu;
import dao.PhieuDatPhong_DAO;
import dao.DAO_DichVu;
import dao.DAO_PhieuDatDichVu;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.DichVu;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class GUI_DatDichVu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel Frame;
    private JPanel panelKH;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblGT;
    private JTextField txtGT;
    private JPanel paneDV;
    private JTable tableHD;
    private DefaultTableModel modelHD;
    private JPanel outerPanel;
    private KhachHang_DAO khachHang_DAO;
    private ArrayList<KhachHang> dsKH;
    private ArrayList<DichVu> dsDV;
    private JTextField txtSoLuong;
	private ArrayList<PhieuDatPhong> pdp;
	private KhachHang kh;
	private NhanVien nv;
	
	
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

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	NhanVien nv = new NhanVien("NV0000001");
                GUI_DatDichVu frame = new GUI_DatDichVu(nv);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GUI_DatDichVu(NhanVien nv) {

        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       this.nv = nv;
       	nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
       for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
		}
        // Lấy danh sách phiếu đặt phòng từ CSDL
        pdp = new PhieuDatPhong_DAO().timPhieuDatPhongTheoTrangThai();
        System.out.println(pdp.get(0).getMaPhieu());
        setTitle("Quản lý khách sạn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,1920,1080);
        setResizable(false);
        
        Frame = new JPanel();
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
		btnTrangChu.setBackground(new Color(255,255,255));
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
		btnQLDV.setBackground(new Color(41, 139, 116));
		btnQLDV.setForeground(new Color(255, 255, 255));
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
		
		JButton btntDchV = new JButton("Đặt dịch vụ");
		btntDchV.setForeground(new Color(0, 0, 0));
		btntDchV.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btntDchV.setBackground(new Color(164, 194, 163));
		btntDchV.setBounds(260, 26, 200, 99);
		panel_top.add(btntDchV);
		
		
		
		btntDchV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_DatDichVu dv = new GUI_DatDichVu(nhanvien);
				dv.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		btnmaNV.setText("<html><div style='text-align: center;'>" +"Mã Nhân viên: "+ nhanvien.getMaNV() + "</div></html>");
		btnTKHTNV.setText("<html><div style='text-align: center;'>" + "Họ tên: "+nhanvien.getHoTenNV() + "</div></html>");
		int tuoi = (int) ChronoUnit.YEARS.between(nhanvien.getNgaySinh(), java.time.LocalDate.now());
		btnTKTNV.setText("<html><div style='text-align: center;'>" + "Tuổi: "+tuoi + "</div></html>");
		
		
		
		
		if(!nhanvien.getMaNV().contains("QL")) {
			btnQLNV.setVisible(false);
			btnThongKe.setVisible(false);
			
			btnHT.setBounds(0, 350, 250, 70);
		}
        
        
        
        
        
        
        
        
        
        

        panelKH = new JPanel();
        panelKH.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelKH.setBounds(250, 205, 1654, 138);
        Frame.add(panelKH);
        panelKH.setLayout(null);

        JLabel lblCCCD = new JLabel("Căn cước công dân:");
        lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCCCD.setBounds(100, 37, 185, 26);
        panelKH.add(lblCCCD);

        txtmaKH = new JTextField();
        txtmaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtmaKH.setBounds(313, 37, 350, 26);
        panelKH.add(txtmaKH);
        txtmaKH.setColumns(10);

        JButton btnTim = new JButton("Tìm");
        btnTim.setBackground(new Color(234, 232, 214));
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTim.setBounds(696, 37, 96, 26);
        panelKH.add(btnTim);

        txtSDT = new JTextField();
        txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtSDT.setColumns(10);
        txtSDT.setBounds(313, 86, 350, 26);
        txtSDT.setEditable(false);
        panelKH.add(txtSDT);

        JLabel lblSDT = new JLabel("Số điện thoại:");
        lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSDT.setBounds(100, 86, 185, 26);
        panelKH.add(lblSDT);

        JLabel lblTenKH = new JLabel("Tên Khách hàng:");
        lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTenKH.setBounds(990, 37, 185, 26);
        panelKH.add(lblTenKH);

        txtTen = new JTextField();
        txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTen.setBounds(1185, 37, 350, 26);
        txtTen.setColumns(10);
        txtTen.setEditable(false);
        panelKH.add(txtTen);

        JLabel lblTuoi = new JLabel("Tuổi:");
        lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTuoi.setBounds(990, 86, 61, 26);
        panelKH.add(lblTuoi);

        txtTuoi = new JTextField();
        txtTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTuoi.setColumns(10);
        txtTuoi.setBounds(1067, 86, 120, 26);
        txtTuoi.setEditable(false);
        panelKH.add(txtTuoi);

        lblGT = new JLabel("Giới Tính:");
        lblGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGT.setBounds(1243, 86, 96, 26);
        panelKH.add(lblGT);

        txtGT = new JTextField();
        txtGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtGT.setColumns(10);
        txtGT.setBounds(1370, 86, 166, 26);
        txtGT.setEditable(false);
        panelKH.add(txtGT);

        paneDV = new JPanel();
        paneDV.setBorder(new LineBorder(new Color(0, 0, 0)));
        paneDV.setBounds(250, 343, 1654, 313);
        Frame.add(paneDV);
        paneDV.setLayout(null);

        String[] cols = new String[]{"STT", "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng", "Tổng tiền"};

        modelHD = new DefaultTableModel(cols, 0);

        paneDV.setLayout(null);
        tableHD = new JTable(modelHD);
        JScrollPane paneNV = new JScrollPane(tableHD);
        paneNV.setBounds(96, 15, 1454, 240);

        paneDV.add(paneNV);

        JTableHeader headers = tableHD.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 20);
        headers.setFont(headerFont);

        tableHD.setFont(new Font("Tahoma", Font.PLAIN, 18));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableHD.setDefaultRenderer(Object.class, centerRenderer);
        tableHD.setRowHeight(30);

        JButton btnDat = new JButton("Đặt dịch vụ");
        btnDat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDat.setBackground(new Color(234, 232, 214));
        btnDat.setBounds(1400, 266, 157, 30);
        paneDV.add(btnDat);

        JButton btHuy = new JButton("Hủy Phiếu");
        btHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btHuy.setBackground(new Color(234, 232, 214));
        btHuy.setBounds(1200, 266, 157, 30);
        paneDV.add(btHuy);

        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSoLuong.setBounds(97, 269, 185, 26);
        paneDV.add(lblSoLuong);

        txtSoLuong = new JTextField();
        txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(196, 268, 350, 26);
        paneDV.add(txtSoLuong);
        txtSoLuong.setText("1");

        outerPanel = new JPanel(null);
        outerPanel.setBounds(287, 690, 1580, 351);
        Frame.add(outerPanel);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXoa.setBackground(new Color(234, 232, 214));
        btnXoa.setBounds(1000, 266, 157, 30);
        paneDV.add(btnXoa);

        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(1500, 380));

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 1580, 351);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        outerPanel.add(scrollPane);

  

        btnTim.addActionListener(e -> {
        	if (txtmaKH.getText().equals("")) {
        		JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng");
        	} else {
        		int flag = 0;
                System.out.println(txtmaKH.getText());
                for (PhieuDatPhong p : pdp) {
                	System.out.println(p.getMaPhieu());
                	if(p.getKhachHang().getmaKH().equals(txtmaKH.getText())) {
                		JOptionPane.showMessageDialog(null, "Tìm thấy khách hàng");
                		createButtons(panel);
    					kh = new KhachHang_DAO().getKhachHangByMaKhachHang(txtmaKH.getText());
    					txtTen.setText(kh.getHoTen());
    					Calendar cal = Calendar.getInstance();
    					txtTuoi.setText(String.valueOf(cal.get(Calendar.YEAR) - kh.getNgaySinh().getYear()));
    					txtSDT.setText(kh.getSoDT());
    					txtGT.setText(kh.getGioiTinh() ? "Nam" : "Nữ");
    					flag = 1;
    					break;
                	}
                }
    			if (flag == 0) {
    				JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
    			}
        	}
            
        });

        btHuy.addActionListener(e -> {
            txtmaKH.setText("");
            txtTen.setText("");
            txtTuoi.setText("");
            txtSDT.setText("");
            txtGT.setText("");
            ((DefaultTableModel) modelHD).setRowCount(0);
            txtSoLuong.setText("1");
        });

        btnXoa.addActionListener(e -> {
            int row = tableHD.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ trên bảng cần xóa");
            } else {
                ((DefaultTableModel) modelHD).removeRow(row);
            }
        });

        btnDat.addActionListener(e -> {
			if (tableHD.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ");
			} else {
				for (int i = 0; i < tableHD.getRowCount(); i++) {
					themPhieuDV(i);
				}
				JOptionPane.showMessageDialog(null, "Đặt dịch vụ thành công");
			}
        });
        
        
        
        
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
    }
    public void themPhieuDV(int i) {
    	// Lấy ngày hiện tại rồi chuyển thành chuỗi yyymmdd
    	LocalDate thoiGianDat = LocalDate.now();
    	String formatter = thoiGianDat.format(DateTimeFormatter.ofPattern("yyMMdd"));
		// Tạo mã phiếu dịch vụ ngẫu nhiên
    	String maPhieu;
    	ArrayList<PhieuDatDichVu> dsPDV = new ArrayList<>();
    	dsPDV = new DAO_PhieuDatDichVu().getDSPhieuDatDichVu();
    	if (dsPDV.size() == 0) {
    		maPhieu = "PDV" + formatter + "0001";
    	} else {
    		int count = 1;
    		for (int a = 0; a < dsPDV.size(); a++) {
    			if (dsPDV.get(a).getMaPhieu().contains("PDV"+formatter)) {
    				count++;
    			}
    		}
    		if (count < 10) {
    			maPhieu="PDV"+formatter + "000" + count;
    		} else if (count < 100) {
    			maPhieu = "PDV" + formatter + "00" + count;
    		} else if (count < 1000) {
    			maPhieu = "PDV" + formatter + "0" + count;
    		} else {
    			maPhieu = "PDV" + formatter + count;
    		}
    		
    	}
    	// Lấy thông tin khách hàng
    	String maKH = txtmaKH.getText();
    	KhachHang kh = new KhachHang(txtmaKH.getText());
    	// Lấy thông tin mã dịch vụ từ bảng
    	String maDV = (String) tableHD.getValueAt(i, 1);
    	int soLuong = (int) tableHD.getValueAt(i, 4);
    	
        // Lấy thông tin đơn giá từ bảng
    	String donGiaStr = (String) tableHD.getValueAt(i, 5);

    	// Loại bỏ dấu phẩy khỏi chuỗi
    	donGiaStr = donGiaStr.replace(",", "");

    	// Chuyển đổi chuỗi đã loại bỏ dấu phẩy sang double
    	double donGia = Double.parseDouble(donGiaStr);
		DichVu dv = new DAO_DichVu().getDichVuByMa(maDV);
		// set trạng thái
		String trangThai = "Chưa thanh toán";
		// Tính giá trước thuế
		int thue = dv.getThueVAT();
		// ep kieu thue ve double
		double thue1 = (double) thue;
		double giaTrcThue = donGia / (1 + thue1/100);
		//Lam tron gia trc thue den 2 chu so thap phan
		giaTrcThue = Math.round(giaTrcThue * 100.0) / 100.0;
		PhieuDatDichVu pd = new PhieuDatDichVu(maPhieu, thoiGianDat, donGia, soLuong, dv, kh, nv, trangThai, giaTrcThue);
		// Thêm phiếu đặt dịch vụ vào CSDL
		new DAO_PhieuDatDichVu().insertPhieuDichVu(pd);
		
		
		
		// Giảm số lượng dịch vụ trong CSDL
		int soLuongConLai = dv.getSoLuong() - soLuong;
		new DAO_DichVu().giamSoLuongDichVu(dv);
		
    }

//    public void createButtons(JPanel panel) {
//        DAO_DichVu dv = new DAO_DichVu();
//        dsDV = dv.getAllDichVu();
//        JButton[] buttons = new JButton[dsDV.size()];
//        // nếu trạng thái của dịch vụ là "Đang kinh doanh" thì hiển thị lên button"
//        for (int i = 0; i < dsDV.size(); i++) {
//            buttons[i] = new JButton();
//            StringBuilder htmlText = new StringBuilder("<html><center>");
//            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append(dsDV.get(i).getTenDichVu()).append("</span><br/>");
//            // thêm ảnh vào button có đường dẫn ./anhPhong/Doi_01.jpg
//            htmlText.append("<img src='").append("file:./anhPhong/Doi_01.jpg").append("' width='200' height='200'><br/>");
//            
//            
//            
//         
//            
//            
//		
//            double dongia = dsDV.get(i).getDonGia();
//          	// khi in ra thẻ html giá trị phải chuyển từ 1000 -> 1.000
//            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("Giá: ").append(String.format("%,.0f", dongia)).append("</span><br/>");
//       
//            htmlText.append("</center></html>");
//            buttons[i].setText(htmlText.toString());
//            buttons[i].setBounds(50 + ((i) % 3) * 490, 50 + ((i) / 3) * 290, 450, 250);
//            panel.setPreferredSize(new Dimension(1500, 100 + ((i) / 2) * 390 + 150));
//            panel.add(buttons[i]);
//
//            int index = i;
//            buttons[i].addActionListener(e -> {
//                String maDV = dsDV.get(index).getMaDichVu();
//                String tenDV = dsDV.get(index).getTenDichVu();
//                double gia = dsDV.get(index).getDonGia();
//                int soLuong = Integer.parseInt(txtSoLuong.getText());
//                
//                if (soLuong > 10) {
//                    JOptionPane.showMessageDialog(null, "Số lượng không được quá 10");
//                } else if (soLuong < 1) {
//                    JOptionPane.showMessageDialog(null, "Số lượng không được nhỏ hơn 1");
//                } else {
//                    double tongTien = gia * soLuong;
//                    // giá và tổng tiền  khi in lên bảng phải chuyển từ 1000 -> 1.000
//                    Object[] row = {modelHD.getRowCount() + 1, maDV, tenDV, String.format("%,.0f", gia), soLuong, String.format("%,.0f", tongTien)};
//                    ((DefaultTableModel) modelHD).addRow(row);
//                }
//            });
//        }
//    }
    // tạo hàm createButtons với dsDV.getTrangThai().equals("Đang kinh doanh") thì ta mới hiển thị lên button
	public void createButtons(JPanel panel) {
        DAO_DichVu dv = new DAO_DichVu();
        dsDV = dv.getAllDichVu();
        dsDV.removeIf(dichVu -> !dichVu.getTrangThai().equals("Đang kinh doanh"));
        JButton[] buttons = new JButton[dsDV.size()];
        for (int i = 0; i < dsDV.size(); i++) {
            buttons[i] = new JButton();
            StringBuilder htmlText = new StringBuilder("<html><center>");
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append(dsDV.get(i).getTenDichVu()).append("</span><br/>");
            double dongia = dsDV.get(i).getDonGia();
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("Giá: ").append(String.format("%,.0f", dongia)).append("</span><br/>");
            htmlText.append("</center></html>");
            buttons[i].setText(htmlText.toString());
            buttons[i].setBounds(20 + ((i) % 4) * 390, 50 + ((i) / 4) * 290, 350, 250);
        	panel.setPreferredSize(new Dimension(1500, 100 + ((i) / 2) * 390 + 150));
            panel.add(buttons[i]);
            // chỉnh màu nền cho button hợp với giao diện
             buttons[i].setBackground(new Color(234, 232, 214));
            int index = i;
            buttons[i].addActionListener(e -> {
            	// khi bấm cùng 1 button thì cột số lượng của table +1
				String maDV = dsDV.get(index).getMaDichVu();
				String tenDV = dsDV.get(index).getTenDichVu();
				double gia = dsDV.get(index).getDonGia();
				int thue = dsDV.get(index).getThueVAT();
				int soLuong = Integer.parseInt(txtSoLuong.getText());
				if (soLuong > 10) {
					JOptionPane.showMessageDialog(null, "Số lượng không được quá 10");
				} else if (soLuong < 1) {
					JOptionPane.showMessageDialog(null, "Số lượng không được nhỏ hơn 1");
				} else {
					// Ep kieu thue ve double
					double thue1 = (double) thue;
					double tongTien = soLuong * gia * (1 + thue1/100);
					System.out.println(soLuong);
					System.out.println(thue);
					System.out.println(gia);
					System.out.println(tongTien);
					// if button đã tồn tại trên bảng thì không thêm vào nữa mà chỉ cập nhật số lượng
					boolean isExist = false;
					for (int j = 0; j < tableHD.getRowCount(); j++) {
						if (tableHD.getValueAt(j, 1).equals(maDV)) {
							int sl = (int) tableHD.getValueAt(j, 4) + soLuong;
							double tt = sl * gia * (1 + thue1/100);
							tableHD.setValueAt(sl, j, 4);
							tableHD.setValueAt(String.format("%,.0f", tt), j, 5);
							isExist = true;
							break;
						}
					}
					if (!isExist) {
						Object[] row = { modelHD.getRowCount() + 1, maDV, tenDV, String.format("%,.0f", gia), soLuong,
								String.format("%,.0f", tongTien) };
						((DefaultTableModel) modelHD).addRow(row);
					}
				}
              });
          }
      }
}
