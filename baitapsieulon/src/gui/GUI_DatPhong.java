package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.DichVuTienIch;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class GUI_DatPhong extends JFrame implements ItemListener{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblNewLabel_1_4;
    private JTextField txtGT;
    private JPanel panelP;
    private JLabel lblNewLabel_7;
    private JTextField txtMaP;
    private JLabel lblNewLabel_8;
    private JTextField txtSoN;
    private JLabel lblNewLabel_9;
    private JTextField txtDV;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JButton btndatPhng;
    private JButton btnHy;
	private Container outerPanel;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[];
    int trangThai[];
	private String[][] mangHaiChieu;
	private JPanel panel;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	private JComboBox<String> cbPhongBan;
	private JCheckBox chckbxPdon;
	private JCheckBox chckbxPdoi;
	private JCheckBox chckbxPVip;
	private JPanel panelKH;
	private KhachHang_DAO khachHang_DAO;
	private PhieuDatPhong_DAO phieuDatPhong_DAO;
	private JDateChooser dateNhanP;
	private JDateChooser dateTraP;
	private String maNV;
	private String tenNV;
	private ArrayList<PhieuDatPhong> dsPDP;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<Phong> dsP;
	private NhanVien_DAO nv_dao;
	private ArrayList<NhanVien> ListNV;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DatPhong frame = new GUI_DatPhong();
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
	public GUI_DatPhong() {
		
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(258,181,1654, 859);
		
		setResizable(false);
		setUndecorated(true);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);

		
		
		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getNhanVienTiepTan();
		
		Phong_dao  = new Phong_DAO();
		dsP = Phong_dao.getalltbPhong();
		
		khachHang_DAO = new KhachHang_DAO();
		dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getTrangThai().equals("Đã đặt    ")&&dsPDP.get(i).getThoiGianNhan().compareTo(LocalDate.now())<0) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
			}
		}
		
		
		
		soPhong = new String[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			soPhong[i] = dsP.get(i).getMaPhong();
		}
		trangThai = new int[dsP.size()];
		// lay thoi gian hien tai
		LocalDate tghientai = LocalDate.now();
		
		tenKhachHang = new String[dsP.size()];


		for (int i = 0; i < dsP.size(); i++) {
			trangThai[i] = 3;
			for(int j = 0; j < dsPDP.size(); j++) {
				if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
						&& dsPDP.get(j).getTrangThai().equals("Đã đặt    ")
						&& (dsPDP.get(j).getThoiGianNhan().compareTo(tghientai) == 1)) {
					trangThai[i] = 1;
					for (int k = 0; k < dsKH.size(); k++) {
						if (dsKH.get(k).getmaKH().equals(dsPDP.get(j).getKhachHang().getmaKH())) {
							tenKhachHang[i] = dsKH.get(k).getHoTen();
						}
					}
				}
				if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
						&& dsPDP.get(j).getTrangThai().equals("Đã thuê   ")) {
					trangThai[i] = 2;
					for (int k = 0; k < dsKH.size(); k++) {
						if (dsKH.get(k).getmaKH().equals(dsPDP.get(j).getKhachHang().getmaKH())) {
							tenKhachHang[i] = dsKH.get(k).getHoTen();
						}
					}
				}
				if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
						&& dsPDP.get(j).getTrangThai().equals("Đã thanh toán")
						&& (dsPDP.get(j).getThoiGianTra().compareTo(tghientai) == 1)) {
					trangThai[i] = 4;
					tenKhachHang[i] = "";
				}
				if (trangThai[i] != 1 && trangThai[i] != 2 && trangThai[i] != 4) {
					trangThai[i] = 3;
					tenKhachHang[i] = "";
				}
			}
		}
		
		maNV = "NV0000001";
		tenNV="Nguyễn Văn A";
		
		panelKH = new JPanel();
		panelKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelKH.setBounds(0, 0, 1654, 138);
		Frame.add(panelKH);
		panelKH.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Căn cước công dân:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(100, 37, 185, 26);
		panelKH.add(lblNewLabel_1);
		
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(100, 86, 185, 26);
		panelKH.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Khách hàng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(990, 37, 185, 26);
		panelKH.add(lblNewLabel_1_2);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTen.setColumns(10);
		txtTen.setBounds(1185, 37, 350, 26);
		txtTen.setEditable(false);
		panelKH.add(txtTen);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(990, 86, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		txtTuoi = new JTextField();
		txtTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(1067, 86, 120, 26);
		txtTuoi.setEditable(false);
		panelKH.add(txtTuoi);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1243, 86, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		txtGT = new JTextField();
		txtGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGT.setColumns(10);
		txtGT.setBounds(1370, 86, 166, 26);
		txtGT.setEditable(false);
		panelKH.add(txtGT);
		
		panelP = new JPanel();
		panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelP.setBounds(0, 138, 1654, 208);
		Frame.add(panelP);
		panelP.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Mã Phòng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(100, 27, 185, 26);
		panelP.add(lblNewLabel_7);
		
		txtMaP = new JTextField();
		txtMaP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaP.setColumns(10);
		txtMaP.setBounds(313, 27, 350, 26);
		panelP.add(txtMaP);
		
		lblNewLabel_8 = new JLabel("Số người");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(100, 75, 185, 26);
		panelP.add(lblNewLabel_8);
		
		txtSoN = new JTextField();
		txtSoN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoN.setColumns(10);
		txtSoN.setBounds(313, 75, 350, 26);
		panelP.add(txtSoN);
		
		lblNewLabel_9 = new JLabel("Dịch vụ:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(100, 120, 185, 26);
		panelP.add(lblNewLabel_9);
		
		txtDV = new JTextField();
		txtDV.setBackground(new Color(255, 255, 255));
		txtDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDV.setColumns(10);
		txtDV.setBounds(313, 120, 350, 26);
		txtDV.setEditable(false);
		panelP.add(txtDV);
		
		lblNewLabel_10 = new JLabel("Ngày trả Phòng:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(992, 75, 185, 26);
		panelP.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(992, 27, 185, 26);
		panelP.add(lblNewLabel_11);
		
		btndatPhng = new JButton("Đặt phòng");
		btndatPhng.setBackground(new Color(234, 232, 214));
		btndatPhng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btndatPhng.setBounds(1205, 166, 153, 26);
		
		panelP.add(btndatPhng);
		
		btnHy = new JButton("Hủy");
		btnHy.setBackground(new Color(234, 232, 214));
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBounds(1378, 166, 153, 26);
		panelP.add(btnHy);
		
		dateNhanP = new JDateChooser();
		dateNhanP.setDateFormatString("dd/MM/yyyy");
		dateNhanP.setBounds(1205, 27, 350, 26);
		dateNhanP.setFont(new Font("Tahoma", Font.PLAIN, 20));

		dateNhanP.setDate(new java.util.Date());
		panelP.add(dateNhanP);
		
		dateTraP = new JDateChooser();
		dateTraP.setDateFormatString("dd/MM/yyyy");
		dateTraP.setBounds(1205, 75, 350, 26);
		dateTraP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//set date ngày mai
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		dateTraP.setDate(cal.getTime());
		panelP.add(dateTraP);
		
		JButton btnDatDichVu = new JButton("Thêm dịch vụ");
		btnDatDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatDichVu.setBounds(674, 120, 175, 26);
		panelP.add(btnDatDichVu);
		//in ngày đã chọn của dateTraP
		
		
		chckbxPdon = new JCheckBox("Phòng đơn (A)");
		chckbxPdon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdon.setBounds(37, 350, 178, 43);
		Frame.add(chckbxPdon);
		
		

		
		chckbxPdoi = new JCheckBox("Phòng đôi (B)");
		chckbxPdoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdoi.setBounds(327, 353, 178, 43);
		Frame.add(chckbxPdoi);
		
		

		
		chckbxPVip = new JCheckBox("Phòng VIP (C)");
		chckbxPVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPVip.setBounds(613, 353, 178, 43);
		Frame.add(chckbxPVip);
		
		
		outerPanel = new JPanel(null);
		outerPanel.setBounds(37, 400, 1580, 453);
		Frame.add(outerPanel);
		
		

        // Tạo một panel bên trong với layout null và kích thước cố định
		panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(1500, 380));
		
		 JScrollPane scrollPane = new JScrollPane(panel);                      
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
		 scrollPane.setBounds(0, 0, 1580, 453);

	        // Thêm JScrollPane vào panel bên ngoài
	     outerPanel.add(scrollPane);
//	     mangHaiChieu = new String[3][soPhong.length];
//	        for (int i = 0; i < soPhong.length; i++) {
//	            mangHaiChieu[0][i] = soPhong[i];
//	            mangHaiChieu[1][i] = tenKhachHang[i];
//	            mangHaiChieu[2][i] = String.valueOf(trangThai[i]);
//	        }
////	        
//	        
//	        mangHaiChieu = sapXep(mangHaiChieu);
//	        
//	        soPhong = mangHaiChieu[0];
//	        tenKhachHang = mangHaiChieu[1];
//	        trangThai = new int[soPhong.length];
//	        
//			for (int i = 0; i < soPhong.length; i++) {
//				trangThai[i] = Integer.parseInt(mangHaiChieu[2][i]);
//			}
//			
////	        button=createButtons(panel, soPhong, tenKhachHang, trangThai);
//		
//			maphongs = new String[0];
//			tens = new String[0];
//			trangTs = new int[0];
//			
//			for (int i = 0; i < maphongs.length; i++) {
//				maphongs[i] = null;
//				tens[i] = null;
//				trangTs[i] = 0;
//			}
//			for (int i = 0; i < soPhong.length; i++) {
//				if (soPhong[i].contains("A")&& trangThai[i]==3) {
//					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
//					maphongs[maphongs.length - 1] = soPhong[i];
//					tens = Arrays.copyOf(tens, tens.length + 1);
//					tens[tens.length - 1] = tenKhachHang[i];
//					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
//					trangTs[trangTs.length - 1] = trangThai[i];
//				}
//				if (soPhong[i].contains("B")&& trangThai[i]==3) {
//					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
//					maphongs[maphongs.length - 1] = soPhong[i];
//					tens = Arrays.copyOf(tens, tens.length + 1);
//					tens[tens.length - 1] = tenKhachHang[i];
//					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
//					trangTs[trangTs.length - 1] = trangThai[i];
//				}
//				if (soPhong[i].contains("B")&& trangThai[i]==3) {
//					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
//					maphongs[maphongs.length - 1] = soPhong[i];
//					tens = Arrays.copyOf(tens, tens.length + 1);
//					tens[tens.length - 1] = tenKhachHang[i];
//					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
//					trangTs[trangTs.length - 1] = trangThai[i];
//				}}
//			
//			
//			
//			
//			button = createButtons(panel, maphongs, tens, trangTs);
//			for (int i = 0; i < button.length; i++) {
//				button[i].addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						JButton clickedButton = (JButton) e.getSource();
//						String txtmaPhong = txtMaP.getText();
//						for (int j = 0; j < button.length; j++) {
//							if (clickedButton == button[j]) {
//								
//								
//								if(txtmaPhong.equals("")) {
//                                    txtMaP.setText(maphongs[j]);
//                                }else if(txtmaPhong.contains(maphongs[j]+" , ")) {
//                                    //xóa phòng đã chọn
//                                	txtMaP.setText(txtmaPhong.replace(maphongs[j]+" , ", ""));
//                                }else if(txtmaPhong.contains(" , "+maphongs[j])) {
//                                    //xóa phòng đã chọn
//                                	txtMaP.setText(txtmaPhong.replace(" , "+maphongs[j], ""));
//                                }else if(txtmaPhong.contains(maphongs[j])) {
//                                    //xóa phòng đã chọn
//                                	txtMaP.setText(txtmaPhong.replace(maphongs[j], ""));
//                                }else {
//								txtMaP.setText(txtmaPhong + " , "+ maphongs[j] );
//							}}
//						}
//					}
//				});
//			}
//		
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                 if (clickedButton == btnTim) {
                	                    // Xử lý khi nhấn vào nút btnHT
            	   KhachHang khs = new KhachHang(txtmaKH.getText());
            	   if(dsKH.contains(khs)) {
            		   KhachHang kh = dsKH.get(dsKH.indexOf(khs));
            		   JOptionPane.showMessageDialog(null,"Tìm thấy khách hàng");
            		   
            		   String maKH = txtmaKH.getText();
            		   // lay nam hien tai
            		   Calendar cal = Calendar.getInstance();
            		   txtTen.setText(kh.getHoTen());
            		   //tuoi la nam hien tai - ngay sinh
            		   txtTuoi.setText(String.valueOf(cal.get(Calendar.YEAR) - kh.getNgaySinh().getYear()));
            		   txtSDT.setText(kh.getSoDT());
            		   if(kh.getGioiTinh()==true) {
            			   txtGT.setText("Nam");
						} else {
							txtGT.setText("Nữ");
						}
                		
                	}
            	   else {
            	   		JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng");
            	   	}
                	}else if (clickedButton == btnHy) {
                        // Xử lý khi nhấn vào nút btnHT
                    	txtmaKH.setText("");
                    	txtTen.setText("");
                    	txtTuoi.setText("");
                    	txtGT.setText("");
                     	txtSDT.setText("");
                     	txtMaP.setText("");
                     	txtSoN.setText("");
                     	txtDV.setText("");
                     	dateNhanP.setDate(new java.util.Date());
                     	dateTraP.setDate(cal.getTime());
                    }else if (clickedButton == btndatPhng) {
                    	String[] maPhongs = txtMaP.getText().split(" , ");
                    	if(ktraChinhQuy(maPhongs)==1) {
						for (int i = 0; i < maPhongs.length; i++) {
							ThemPhong(maPhongs[i]);
						}
                    		JOptionPane.showMessageDialog(null,"Đặt phòng thành công");
                    	}
                    	
                    	
                    	
                    	
                    	
                    }
                }};
                    btnTim.addActionListener(actionListener);
                    btnHy.addActionListener(actionListener);
                    btndatPhng.addActionListener(actionListener);
                    chckbxPdon.addItemListener(this);
                    chckbxPdoi.addItemListener(this);
                    chckbxPVip.addItemListener(this);
					
                    
                 
                    
	}
	public void itemStateChanged(ItemEvent e) {
		maphongs = new String[0];
		tens = new String[0];
		trangTs = new int[0];
		for (int i = 0; i < maphongs.length; i++) {
			maphongs[i] = null;
			tens[i] = null;
			trangTs[i] = 0;
		}
		
		
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
				if (soPhong[i].contains("C") && trangThai[i]==3) {
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
					String txtmaPhong = txtMaP.getText();
					for (int j = 0; j < button.length; j++) {
						if (clickedButton == button[j]) {
							
							
							if(txtmaPhong.equals("")) {
                                txtMaP.setText(maphongs[j]);
                            }else if(txtmaPhong.contains(maphongs[j]+" , ")) {
                                //xóa phòng đã chọn
                            	txtMaP.setText(txtmaPhong.replace(maphongs[j]+" , ", ""));
                            }else if(txtmaPhong.contains(" , "+maphongs[j])) {
                                //xóa phòng đã chọn
                            	txtMaP.setText(txtmaPhong.replace(" , "+maphongs[j], ""));
                            }else if(txtmaPhong.contains(maphongs[j])) {
                                //xóa phòng đã chọn
                            	txtMaP.setText(txtmaPhong.replace(maphongs[j], ""));
                            }else {
							txtMaP.setText(txtmaPhong + " , "+ maphongs[j] );
						}}
					}
				}
			});
		}
	}

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

	public int kiemtraTrong(String maphongktra) {
		
	
		LocalDate thoiGianNhan = dateNhanP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate thoiGianTra = dateTraP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int hieuNgayN = thoiGianNhan.compareTo(LocalDate.now());
		int hieuNgayT = thoiGianTra.compareTo(thoiGianNhan);
		if (txtmaKH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng");
			return-1;
		}
		else if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập và kiểm tra mã khách hàng");
			return-1;
		}
		else if (txtMaP.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng");
			return-1;
		}
		else if (txtSoN.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số người");
			return-1;
		}
		else if (dateNhanP.getDate() == null|| hieuNgayN < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày nhận phòng lại");
			return-1;
		}
		else if (dateTraP.getDate() == null || hieuNgayT < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày trả phòng lại");
			return-1;}
		else if(kiemTraPhong(maphongktra) == -1) {
			JOptionPane.showMessageDialog(null, "Phòng không tồn tại");
			return-1;
		} else if (kiemTraThoiGianDat(maphongktra, thoiGianNhan, thoiGianTra) == -1) {
			return -2;
		} else {
			return 1;
		}
	}
	
	
	public void ThemPhong(String maphongktra) {
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		LocalDate thoiGianNhan = dateNhanP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate thoiGianTra = dateTraP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate thoiGianDat = LocalDate.now();
		Double DonGia = 0.0;
		if (maphongktra.contains("A")) {
			DonGia = 1500000.0;
		}else if (maphongktra.contains("B")) {
			DonGia = 2000000.0;
		}else {
			DonGia = 3000000.0;
		}
		KhachHang maKH = new KhachHang(txtmaKH.getText());
		Phong maPhong = new Phong(maphongktra);
		NhanVien maNhanVien = new NhanVien(maNV);
		String formatter = thoiGianDat.format(DateTimeFormatter.ofPattern("yyMMdd"));
		int count = 1;
		for (int a = 0; a < dsPDP.size(); a++) {
			if (dsPDP.get(a).getMaPhieu().contains("PD"+formatter)) {
				count++;
			}
		}
		String maPhieu;
		if (count < 10) {
			maPhieu="PD"+formatter + "000" + count;
		} else if (count < 100) {
			maPhieu = "PD" + formatter + "00" + count;
		} else if (count < 1000) {
			maPhieu = "PD" + formatter + "0" + count;
		} else {
			maPhieu = "PD" + formatter + count;
		}
		String trangThai;
		if(LocalDate.now().isBefore(dateNhanP.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
			trangThai = "Đã đặt    ";
		} else {
			trangThai = "Đã thuê   ";
		}
		String soPhong = txtSoN.getText();
		DichVuTienIch dichVu = new DichVuTienIch();
		if (txtDV.getText().equals("")) {
			dichVu = new DichVuTienIch(null);
		}else{
			dichVu = new DichVuTienIch(txtDV.getText());
		}
		
		PhieuDatPhong pdp = new PhieuDatPhong(maPhieu, thoiGianDat, thoiGianNhan, thoiGianTra, DonGia, maPhong, maKH,maNhanVien,trangThai,soPhong,dichVu);
		ArrayList<PhieuDatPhong> danhSachPhieuDatPhong = new ArrayList<>();
		danhSachPhieuDatPhong.add(pdp);
		phieuDatPhong_DAO.insertPhieuDatPhong(danhSachPhieuDatPhong);
	}
			
		
		
		
	

	public int kiemTraPhong(String maPhong) {
		for (int i = 0; i < soPhong.length; i++) {
			if (soPhong[i].equals(maPhong)) {
				return 1;
			}
		}
		return -1;
	}

	public int kiemTraThoiGianDat(String maPhong, LocalDate thoiGianNhan, LocalDate thoiGianTra) {
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getPhong().getMaPhong().equals(maPhong)) {
				if ((dsPDP.get(i).getThoiGianNhan().isBefore(thoiGianNhan) 
						&& dsPDP.get(i).getThoiGianTra().isAfter(thoiGianNhan))
						||(dsPDP.get(i).getThoiGianNhan().isAfter(thoiGianNhan)
						&& dsPDP.get(i).getThoiGianNhan().isBefore(thoiGianTra))) {
                    return -1;
                }
			}
		}
		return 1;
	}

	public int ktraChinhQuy(String[] maPhongs) {
		int count = 0;
		for (int i = 0; i < maPhongs.length; i++) {
    		if(kiemtraTrong(maPhongs[i])==-1) {
    			return -1;
           	}else if(kiemtraTrong(maPhongs[i])==-2){
           		JOptionPane.showMessageDialog(null, "Phòng "+maPhongs[i]+" đã có người đặt");
           		count++;
           	}
       	}
		if (count > 0) {
			return -1;
		}
		return 1;
	}
	
}
