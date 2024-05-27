package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;


import javax.swing.border.LineBorder;
import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;





public class GUI_QuanLiDatPhong extends JFrame implements ItemListener{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
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
    String soPhong[];
    String tenKhachHang[] ;
//    		= {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private JPanel panel;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	private JComboBox<String> cbPhongBan;
	private KhachHang_DAO khachHang_DAO;
	private PhieuDatPhong_DAO phieuDatPhong_DAO;
	private int count;
	private JPanel panelTK;
	private JButton btnTK;
	private JButton btnTKDMK;
	private JButton btnTKDX;
	private JLabel btnTKHTNV;
	private JLabel btnTKTNV;
	private JLabel btnTKca;
	private JLabel btnmaNV;
	private JButton btnTrangChu;
	private JButton btnQLP;
	private JButton btnQLHD;
	private JButton btnQLKH;
	private JButton btnQLNV;
	private JButton btnQLDV;
	private JLabel lblNewLabel_2;
	private JButton btnThongKe;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnHT;
	private NhanVien_DAO nv_dao;
	private ArrayList<NhanVien> ListNV;
	private GUI_QuanLiDatPhong qlp;
	private GUI_QuanLiHoaDon qlhd;
	private GUI_QuanLiKhachHang qlkh;
	private GUI_QuanLiDichVu qldv;
	private GUI_ThongKeNhanVien tknv;
	private GUI_DatPhong dp;
	private GUI_NhanPhong np;
	private GUI_TraPhong tp;
	private GUI_DoiPhong dop;
	private GUI_GiaHanPhong ghp;
	private GUI_QuanLiNhanVien qlnv;
	/**
	 * Launch the application.
	 */
	static NhanVien nhanvien;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhanvien = new NhanVien("NV0000003");
					GUI_QuanLiDatPhong frame = new GUI_QuanLiDatPhong(nhanvien);
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
	public GUI_QuanLiDatPhong(NhanVien nv) {
		setIconImage(new ImageIcon(GUI_DangNhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setResizable(false);
		setLocationRelativeTo(null);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		panelTK = new JPanel();
		
		nhanvien = nv;
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Phong_dao  = new Phong_DAO();
		ArrayList<Phong> dsP = Phong_dao.getalltbPhong();
		soPhong = new String[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			soPhong[i] = dsP.get(i).getMaPhong();
		}
		khachHang_DAO = new KhachHang_DAO();
		ArrayList<KhachHang> dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		ArrayList<PhieuDatPhong> dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
		
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nhanvien = nhanVien;
				break;
			}
		}
		
		// kiểm tra trạng thái phòng
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getTrangThai().contains("Đã đặt")&& ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now()) > 0) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
			}
			
			
		}
		LocalDate tghientai = LocalDate.now();
		for (int i = 0; i < dsP.size(); i++) {
			if (!dsP.get(i).getTrangThai().contains("Bảo trì")) {
				Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Trống");
			}
			for(int j = 0; j < dsPDP.size(); j++) {
				
				
				if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
						&& dsPDP.get(j).getTrangThai().contains("Đã đặt")
						&& (dsPDP.get(j).getThoiGianNhan().compareTo(tghientai) == 0)
						) {
					Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Đã đặt");
				}else if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
                        && dsPDP.get(j).getTrangThai().contains("Đã nhận")
                        ) {
					System.out.println(dsP.get(i).getMaPhong());
                    Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Đã thuê");
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		trangThai = new int[dsP.size()];
		// lay thoi gian hien tai
		
		
		tenKhachHang = new String[dsP.size()];
		


		
		for (int i = 0; i < dsP.size(); i++) {
			
			if (dsP.get(i).getTrangThai().contains("Đã đặt")) {
				trangThai[i] = 1;
				for (int j = 0; j < dsPDP.size(); j++) {
					if (dsP.get(i).getMaPhong().equals(dsPDP.get(j).getPhong().getMaPhong())
							&& dsPDP.get(j).getTrangThai().contains("Đã đặt")) {
						for (int k = 0; k < dsKH.size(); k++) {
							if (dsKH.get(k).getmaKH().equals(dsPDP.get(j).getKhachHang().getmaKH())) {
								tenKhachHang[i] = dsKH.get(k).getHoTen();
							}
						}
					}
				}
				
				System.out.println("1"+tenKhachHang[i]);
				
			} else if (dsP.get(i).getTrangThai().contains("Đã thuê")) {
				trangThai[i] = 2;
				for (int j = 0; j < dsPDP.size(); j++) {
					if (dsP.get(i).getMaPhong().contains(dsPDP.get(j).getPhong().getMaPhong())
							&& dsPDP.get(j).getTrangThai().contains("Đã nhận")) {
						for (int k = 0; k < dsKH.size(); k++) {
							if (dsKH.get(k).getmaKH().equals(dsPDP.get(j).getKhachHang().getmaKH())) {
								tenKhachHang[i] = dsKH.get(k).getHoTen();
							} 
							
						}
						
					}
				}
				
				System.out.println("2"+tenKhachHang[i]);
			} else if (dsP.get(i).getTrangThai().contains("Trống")) {
				trangThai[i] = 3;
				tenKhachHang[i] = "";
				System.out.println("3"+tenKhachHang[i]);
			}else {
				trangThai[i] = 4;
				tenKhachHang[i] = "";
				System.out.println("4"+tenKhachHang[i]);
			}
			
		}
		
		
		chckbxdadat = new JCheckBox("Đã đặt");
		chckbxdadat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxdadat.setBounds(289, 166, 97, 43);
		Frame.add(chckbxdadat);
		chckbxdadat.setSelected(true);
		

		
		
		
		
		chckbxThue = new JCheckBox("Đã thuê");
		chckbxThue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxThue.setBounds(388, 166, 112, 43);
		Frame.add(chckbxThue);
		chckbxThue.setSelected(true);
		

		
		chckbxTrong = new JCheckBox("Trống");
		chckbxTrong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxTrong.setBounds(502, 166, 91, 43);
		Frame.add(chckbxTrong);
		chckbxTrong.setSelected(true);
		

		
		chckbxBaotri = new JCheckBox("Bảo trì");
		chckbxBaotri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxBaotri.setBounds(595, 166, 112, 43);
		Frame.add(chckbxBaotri);
		chckbxBaotri.setSelected(true);
		

		
		chckbxPdon = new JCheckBox("Phòng đơn (A)");
		chckbxPdon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdon.setBounds(289, 224, 178, 43);
		Frame.add(chckbxPdon);
		chckbxPdon.setSelected(true);
		

		
		chckbxPdoi = new JCheckBox("Phòng đôi (B)");
		chckbxPdoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdoi.setBounds(491, 224, 178, 43);
		Frame.add(chckbxPdoi);
		chckbxPdoi.setSelected(true);
		
		
		chckbxPVip = new JCheckBox("Phòng VIP (C)");
		chckbxPVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPVip.setBounds(701, 224, 178, 43);
		Frame.add(chckbxPVip);
		chckbxPVip.setSelected(true);
		

		
		Panel panel_Center_dadat = new Panel();
		panel_Center_dadat.setBackground(new Color(34, 242, 93));
		panel_Center_dadat.setBounds(307, 285, 145, 43);
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
		panel_Center_dathue.setBounds(483, 285, 145, 43);
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
		panel_Center_trong.setBounds(663, 285, 145, 43);
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
		panel_Center_baotri.setBounds(841, 285, 145, 43);
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
        outerPanel.setBounds(289, 353, 1580, 638); // Đặt vị trí và kích thước của panel bên ngoài
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
        scrollPane.setBounds(0, 0, 1580, 638);

        // Thêm JScrollPane vào panel bên ngoài
        outerPanel.add(scrollPane);
		
        // Hàm tạo buton
        
        
        

		
        
		
        //xử lý các checkbox
        mangHaiChieu = new String[3][soPhong.length];
        for (int i = 0; i < soPhong.length; i++) {
            mangHaiChieu[0][i] = soPhong[i];
            mangHaiChieu[1][i] = tenKhachHang[i];
            mangHaiChieu[2][i] = String.valueOf(trangThai[i]);
        }
        
        mangHaiChieu = sapXep(mangHaiChieu);
        
        soPhong = mangHaiChieu[0];
        tenKhachHang = mangHaiChieu[1];
        trangThai = new int[soPhong.length];
        
		for (int i = 0; i < soPhong.length; i++) {
			trangThai[i] = Integer.parseInt(mangHaiChieu[2][i]);
		}
		
        button=createButtons(panel, soPhong, tenKhachHang, trangThai);
        for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JButton clickedButton = (JButton) e.getSource();
					//lay ma phong khong lay the html
					//skip text la ma phong
					String maPhong = clickedButton.getText();
					String maphongcustom = extractTextFromHTML(maPhong);
					// Mở GUI_ChiTietPhong và truyền maphongcustom
			          // Đóng cửa sổ hiện tại nếu có
		            GUI_ChiTietPhong.closeCurrentInstance();

		            // Mở GUI_ChiTietPhong1 mới và truyền maphongcustom
		            new GUI_ChiTietPhong(maphongcustom).setVisible(true);
					// khi tắt GUI_ChiTietPhong1 thì load lại GUI_QuanLiDatPhong
					
				}
			});
		}
       for (int i = 0; i < soPhong.length; i++) {
    	   System.out.println(tenKhachHang[i]);
       }
        
        
        
        
        
        count = 0;
        for(int i=0; i<trangThai.length; i++) {
        	
        	if(trangThai[i]==1) {
        		count++;
        	}
        	
        }
        lbldadat.setText(String.valueOf(count));
        count = 0;
		for (int i = 0; i < trangThai.length; i++) {
			
			if (trangThai[i] == 2) {
				count++;
			}
		}
		lbldathue.setText(String.valueOf(count));
		count = 0;
		for (int i = 0; i < trangThai.length; i++) {
			
			if (trangThai[i] == 3) {
				count++;
			}
		}
		lbltrong.setText(String.valueOf(count));
		count = 0;
		for (int i = 0; i < trangThai.length; i++) {
			
			if (trangThai[i] == 4) {
				count++;
			}
		}
		lblbaotri.setText(String.valueOf(count));
		
		
		
        
                
      //add listener cho checkbox
       chckbxdadat.addItemListener(this);
       chckbxThue.addItemListener(this);
       chckbxTrong.addItemListener(this);
       chckbxBaotri.addItemListener(this);
       chckbxPdon.addItemListener(this);
       chckbxPdoi.addItemListener(this);
       chckbxPVip.addItemListener(this);
       
       
		
       
		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
		
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nv = nhanVien;
				break;
			}
		}
		
		
		
		
		
		
		
		
		panelTK.setBounds(1647, 53, 247, 218);
		panelTK.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		getContentPane().add(panelTK);
		
		panelTK.setLayout(null);
		panelTK.setVisible(false);
		
		
		
		
		Panel panel_top = new Panel();
		panel_top.setLayout(null);
		panel_top.setBackground(Color.LIGHT_GRAY);
		panel_top.setBounds(0, 0, 1904, 150);
		getContentPane().add(panel_top);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(new ImageIcon(GUI_DangNhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH)));
		logo.setBounds(0, 0, 250, 150);
		panel_top.add(logo);
		
		
		
		
		btnTK = new JButton("<html><div style='text-align: center;'>Trần ngu</div></html>");
		btnTK.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTK.setForeground(new Color(244, 244, 244));
		btnTK.setBackground(new Color(41, 139, 116));
		btnTK.setBounds(1647, 11, 247, 40);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(GUI_DangNhap.class.getResource("/img/account-icon.png")).getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH)));
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
		btnTrangChu.setForeground(new Color(0, 0, 0));
		btnTrangChu.setBackground(new Color(255, 255, 255));
		btnTrangChu.setBounds(0, 0, 250, 70);
		panel_menu.add(btnTrangChu);
		
		
		btnQLP = new JButton("Quản lí phòng");
		btnQLP.setForeground(new Color(244, 244, 244));
		btnQLP.setBackground(new Color(41, 139, 106));
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
		
		JButton btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setForeground(new Color(244, 244, 244));
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDatPhong.setBackground(new Color(41, 139, 106));
		btnDatPhong.setBounds(250, 25, 250, 99);
		panel_top.add(btnDatPhong);
		
		JButton btnNhanP = new JButton("Nhận phòng");
		btnNhanP.setForeground(new Color(244, 244, 244));
		btnNhanP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNhanP.setBackground(new Color(41, 139, 106));
		btnNhanP.setBounds(525, 25, 250, 99);
		panel_top.add(btnNhanP);
		
		JButton btnTraP = new JButton("Trả Phòng");
		btnTraP.setForeground(new Color(244, 244, 244));
		btnTraP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTraP.setBackground(new Color(41, 139, 106));
		btnTraP.setBounds(800, 25, 250, 99);
		panel_top.add(btnTraP);
		
		JButton btnDoiP = new JButton("Đổi Phòng");
		btnDoiP.setForeground(new Color(244, 244, 244));
		btnDoiP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDoiP.setBackground(new Color(41, 139, 106));
		btnDoiP.setBounds(1075, 25, 250, 99);
		panel_top.add(btnDoiP);
		
		JButton btnGHP = new JButton("Gia hạn phòng");
		btnGHP.setForeground(new Color(244, 244, 244));
		btnGHP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGHP.setBackground(new Color(41, 139, 106));
		btnGHP.setBounds(1350, 25, 250, 99);
		panel_top.add(btnGHP);
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
					dispose();
				}if(clickedButton == btnTK) {
					panelTK.setVisible(!panelTK.isVisible());
				}if(clickedButton == btnTKDX) {
					GUI_DangNhap dn = new GUI_DangNhap();
					dn.setVisible(true);
					dispose();
				}if(clickedButton == btnHT) {
					
				}if(clickedButton == btnTKDMK) {
					GUI_DoiMatKhau dmk = new GUI_DoiMatKhau();
					dmk.txttendangnhap.setText(nhanvien.getMaNV());
					dmk.txttendangnhap.setEditable(false);
					dmk.setVisible(true);
				}if(clickedButton == btnDatPhong) {
					dp = new GUI_DatPhong(nhanvien);
					dp.setVisible(true);
					dispose();
				}if(clickedButton == btnNhanP) {
					np = new GUI_NhanPhong(nhanvien);
					np.setVisible(true);
					
					dispose();
				}if(clickedButton == btnTraP) {
					tp = new GUI_TraPhong(nhanvien);
					tp.setVisible(true);
					dispose();
				}if(clickedButton == btnDoiP) {
					dop = new GUI_DoiPhong(nhanvien);
					dop.setVisible(true);
					dispose();
				}if(clickedButton == btnGHP) {
					ghp = new GUI_GiaHanPhong(nhanvien);
					ghp.setVisible(true);
					dispose();
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
       btnDatPhong.addActionListener(actionListener);
       btnNhanP.addActionListener(actionListener);
       btnTraP.addActionListener(actionListener);
       btnDoiP.addActionListener(actionListener);
       btnGHP.addActionListener(actionListener);
                    
                 
                    
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
			for (int i = 0; i < button.length; i++) {
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JButton clickedButton = (JButton) e.getSource();
						//lay ma phong khong lay the html
						//skip text la ma phong
						String maPhong = clickedButton.getText();
						String maphongcustom = extractTextFromHTML(maPhong);
						// Mở GUI_ChiTietPhong và truyền maphongcustom
				          // Đóng cửa sổ hiện tại nếu có
			            GUI_ChiTietPhong.closeCurrentInstance();

			            // Mở GUI_ChiTietPhong1 mới và truyền maphongcustom
			            new GUI_ChiTietPhong(maphongcustom).setVisible(true);
						// khi tắt GUI_ChiTietPhong1 thì load lại GUI_QuanLiDatPhong
						
					}
				});
			}
			
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
	
	private static String extractTextFromHTML(String html) {
        // Extract the content between the first opening <span> and the corresponding closing </span>
        String startTag = "<span style='font-family:Tahoma; font-size:60pt;'>";
        String endTag = "</span>";
        
        int start = html.indexOf(startTag) + startTag.length();
        int end = html.indexOf(endTag, start);

        return html.substring(start, end).trim();


}
}
