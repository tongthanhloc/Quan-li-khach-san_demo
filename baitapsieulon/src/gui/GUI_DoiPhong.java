package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class GUI_DoiPhong extends JFrame implements ItemListener{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
	static JTextField txtCCKH;
	static JTextField txtSDTKH;
	static JTextField txtTenKH;
	static JTextField txtTuoiKH;
    private JLabel lblNewLabel_1_4;
	private Container outerPanel;
	private JButton button[];
	String soPhong[];
    String tenKhachHang[];
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private JPanel panel;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;

	private JCheckBox chckbxPdon;
	private JCheckBox chckbxPdoi;
	private JCheckBox chckbxPVip;
	private JPanel panelKH;
	private LocalDate tgNhan;
	private LocalDate tgTra;
	static JTextField txtPhong;
	static JTextField txtNgayN;
	static JTextField txtNgayT;
	static JTextField txtGioi;
	static KhachHang_DAO khachHang_DAO;
	static PhieuDatPhong_DAO phieuDatPhong_DAO;
	static ArrayList<Phong> dsP;
	static ArrayList<KhachHang> dsKH;
	static ArrayList<PhieuDatPhong> dsPDP;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DoiPhong frame = new GUI_DoiPhong();
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
	public GUI_DoiPhong() {
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
		Phong_dao  = new Phong_DAO();
		dsP = Phong_dao.getalltbPhong();
		
		khachHang_DAO = new KhachHang_DAO();
		dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		
		
		
		soPhong = new String[0];
		tenKhachHang = new String[0];
		trangThai = new int[0];
		

//		soPhong = new String[dsP.size()];
//		for (int i = 0; i < dsP.size(); i++) {
//			soPhong[i] = dsP.get(i).getMaPhong();
//		}
//		
//		for (int i = 0; i < dsP.size(); i++) {
//			
//			if (dsP.get(i).getTrangThai().contains("Đã đặt")) {
//				trangThai[i] = 1;
//				for (int j = 0; j < dsPDP.size(); j++) {
//					if (dsP.get(i).getMaPhong().equals(dsPDP.get(j).getPhong().getMaPhong())
//							&& dsPDP.get(j).getTrangThai().contains("Đã đặt")) {
//						for (int k = 0; k < dsKH.size(); k++) {
//							if (dsKH.get(k).getmaKH().equals(dsPDP.get(j).getKhachHang().getmaKH())) {
//								tenKhachHang[i] = dsKH.get(k).getHoTen();
//								
//							}
//						}
//					}
//				}
//			} else if (dsP.get(i).getTrangThai().contains("Đã thuê")) {
//				trangThai[i] = 2;
//				for (int j = 0; j < dsPDP.size(); j++) {
//					if (dsP.get(i).getMaPhong().contains(dsPDP.get(j).getPhong().getMaPhong())
//							&& dsPDP.get(j).getTrangThai().contains("Đã nhận")) {
//						
//						for (int k = 0; k < dsKH.size(); k++) {
//							if (dsKH.get(k).getmaKH().equals(dsPDP.get(j).getKhachHang().getmaKH())) {
//								tenKhachHang[i] = dsKH.get(k).getHoTen();
//								
//							}
//						}
//					}
//				}
//			} else if (dsP.get(i).getTrangThai().contains("Trống")) {
//				trangThai[i] = 3;
//				tenKhachHang[i] = "";
//				
//			}else {
//				trangThai[i] = 4;
//				tenKhachHang[i] = "";
//				
//			}
//			
//		}
//		
//				 mangHaiChieu = new String[3][soPhong.length];
//			        for (int k = 0; k < soPhong.length; k++) {
//			            mangHaiChieu[0][k] = soPhong[k];
//			            mangHaiChieu[1][k] = tenKhachHang[k];
//			            mangHaiChieu[2][k] = String.valueOf(trangThai[k]);
//			        }
//		     
//			        mangHaiChieu = sapXep(mangHaiChieu);
//			        soPhong = mangHaiChieu[0];
//			        tenKhachHang = mangHaiChieu[1];
//			        trangThai = new int[soPhong.length];
//			        
//					for (int k = 0; k < soPhong.length; k++) {
//						trangThai[k] = Integer.parseInt(mangHaiChieu[2][k]);
//					}
//					
//
//					
//					
//					
//					maphongs = new String[0];
//					tens = new String[0];
//					trangTs = new int[0];
//					for (int k = 0; k < maphongs.length; k++) {
//						maphongs[k] = null;
//						tens[k] = null;
//						trangTs[k] = 0;
//					}
//					
//					for (int k = 0; k < soPhong.length; k++) {
//						if (soPhong[k].contains("A")&& trangThai[k]==3) {
//							maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
//							maphongs[maphongs.length - 1] = soPhong[k];
//							tens = Arrays.copyOf(tens, tens.length + 1);
//							tens[tens.length - 1] = tenKhachHang[k];
//							trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
//							trangTs[trangTs.length - 1] = trangThai[k];
//						}
//						if (soPhong[k].contains("B")&& trangThai[k]==3) {
//							maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
//							maphongs[maphongs.length - 1] = soPhong[k];
//							tens = Arrays.copyOf(tens, tens.length + 1);
//							tens[tens.length - 1] = tenKhachHang[k];
//							trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
//							trangTs[trangTs.length - 1] = trangThai[k];
//						}
//						if (soPhong[k].contains("B")&& trangThai[k]==3) {
//							maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
//							maphongs[maphongs.length - 1] = soPhong[k];
//							tens = Arrays.copyOf(tens, tens.length + 1);
//							tens[tens.length - 1] = tenKhachHang[k];
//							trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
//							trangTs[trangTs.length - 1] = trangThai[k];
//						}}
//					
//					
//					button = createButtons(panel, maphongs, tens, trangTs);
//			}
//		});
	
		
		panelKH = new JPanel();
		panelKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelKH.setBounds(0, 0, 1654, 139);
		Frame.add(panelKH);
		panelKH.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Căn cước công dân:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(100, 37, 185, 26);
		panelKH.add(lblNewLabel_1);
		
		txtCCKH = new JTextField();
		txtCCKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCCKH.setBounds(313, 37, 350, 26);
		panelKH.add(txtCCKH);
		txtCCKH.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim.setBounds(696, 37, 96, 26);
		panelKH.add(btnTim);
		
		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(313, 86, 350, 26);
		txtSDTKH.setEditable(false);
		panelKH.add(txtSDTKH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(100, 86, 185, 26);
		panelKH.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Khách hàng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(990, 37, 185, 26);
		panelKH.add(lblNewLabel_1_2);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(1185, 37, 368, 26);
		txtTenKH.setEditable(false);
		panelKH.add(txtTenKH);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(990, 86, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		txtTuoiKH = new JTextField();
		txtTuoiKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTuoiKH.setColumns(10);
		txtTuoiKH.setBounds(1067, 86, 120, 26);
		txtTuoiKH.setEditable(false);
		panelKH.add(txtTuoiKH);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1243, 86, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		txtGioi = new JTextField();
		txtGioi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGioi.setColumns(10);
		txtGioi.setBounds(1354, 86, 199, 26);
		txtGioi.setEditable(false);
		panelKH.add(txtGioi);
		
		chckbxPdon = new JCheckBox("Phòng đơn (A)");
		chckbxPdon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdon.setBounds(36, 332, 178, 43);
		Frame.add(chckbxPdon);
		chckbxPdon.setSelected(true);
		

		
		chckbxPdoi = new JCheckBox("Phòng đôi (B)");
		chckbxPdoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdoi.setBounds(326, 335, 178, 43);
		Frame.add(chckbxPdoi);
		chckbxPdoi.setSelected(true);
		

		
		chckbxPVip = new JCheckBox("Phòng VIP (C)");
		chckbxPVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPVip.setBounds(612, 335, 178, 43);
		Frame.add(chckbxPVip);
		chckbxPVip.setSelected(true);
		
		outerPanel = new JPanel(null);
		outerPanel.setBounds(36, 382, 1580, 460);
		Frame.add(outerPanel);
		
		
		

        // Tạo một panel bên trong với layout null và kích thước cố định
		panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(1500, 380));
		
		 JScrollPane scrollPane = new JScrollPane(panel);                      
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
		 scrollPane.setBounds(0, 0, 1580, 460);

	        // Thêm JScrollPane vào panel bên ngoài
	     outerPanel.add(scrollPane);
	    
			
			JPanel panelKH_1 = new JPanel();
			panelKH_1.setLayout(null);
			panelKH_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelKH_1.setBounds(0, 139, 1654, 186);
			Frame.add(panelKH_1);
			
			JLabel lblNewLabel_1_5 = new JLabel("Phòng cần đổi:");
			lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_5.setBounds(100, 37, 185, 26);
			panelKH_1.add(lblNewLabel_1_5);
			
			txtPhong = new JTextField();
			txtPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtPhong.setColumns(10);
			txtPhong.setBounds(313, 86, 350, 26);
			txtPhong.setEditable(false);
			panelKH_1.add(txtPhong);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Đổi sang Phòng:");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_1_1.setBounds(100, 86, 185, 26);
			panelKH_1.add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_2_1 = new JLabel("Ngày đặt phòng:");
			lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_2_1.setBounds(990, 37, 185, 26);
			panelKH_1.add(lblNewLabel_1_2_1);
			
			JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày trả Phòng");
			lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_2_1_1.setBounds(990, 86, 185, 26);
			panelKH_1.add(lblNewLabel_1_2_1_1);
			
			txtNgayN = new JTextField();
			txtNgayN.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtNgayN.setColumns(10);
			txtNgayN.setBounds(1185, 37, 368, 26);
			txtNgayN.setEditable(false);
			panelKH_1.add(txtNgayN);
			
			txtNgayT = new JTextField();
			txtNgayT.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtNgayT.setColumns(10);
			txtNgayT.setBounds(1185, 86, 368, 26);
			txtNgayT.setEditable(false);
			panelKH_1.add(txtNgayT);
			
			JComboBox cbxPhong = new JComboBox();
			cbxPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
			cbxPhong.setBounds(313, 37, 350, 26);
			panelKH_1.add(cbxPhong);
			
			JButton btnHuy = new JButton("Xóa trắng");
			btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnHuy.setBounds(1333, 143, 220, 32);
			panelKH_1.add(btnHuy);
			
			JButton btnDoiPhong = new JButton("Đổi Phòng");
			btnDoiPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnDoiPhong.setBounds(1082, 143, 220, 32);
			panelKH_1.add(btnDoiPhong);
			
			
			
		
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                if (clickedButton==btnTim) {
                	
                	KhachHang khs = new KhachHang(txtCCKH.getText());
             	   if(dsKH.contains(khs)) {
             		   KhachHang kh = dsKH.get(dsKH.indexOf(khs));
             		   JOptionPane.showMessageDialog(null,"Tìm thấy khách hàng");
             		   
             		   String maKH = txtCCKH.getText();
             		   // lay nam hien tai
             		   Calendar cal = Calendar.getInstance();
             		   txtTenKH.setText(kh.getHoTen());
             		   //tuoi la nam hien tai - ngay sinh
             		   txtTuoiKH.setText(String.valueOf(cal.get(Calendar.YEAR) - kh.getNgaySinh().getYear()));
             		   txtSDTKH.setText(kh.getSoDT());
             		   if(kh.getGioiTinh()==true) {
             			   txtGioi.setText("Nam");
 						} else {
 							txtGioi.setText("Nữ");
 						}
             		   cbxPhong.removeAllItems();
                 		for (int i = 0; i < dsPDP.size(); i++) {
							if (dsPDP.get(i).getKhachHang().getmaKH().equals(maKH)&&(dsPDP.get(i).getTrangThai().contains("Đã đặt")||dsPDP.get(i).getTrangThai().contains("Đã nhận"))) {
								cbxPhong.addItem(dsPDP.get(i).getPhong().getMaPhong());
							}
                 		}
                 		
                 	}
             	   else {
             	   		JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng");
             	 }}else if(clickedButton==btnHuy) {
             		 txtCCKH.setText("");
             		 txtSDTKH.setText("");
             		 txtTenKH.setText("");
             		 txtTuoiKH.setText("");
             		 txtGioi.setText("");
             		 txtNgayN.setText("");
             		 txtNgayT.setText("");
             		 txtPhong.setText("");
             		 cbxPhong.removeAllItems();
             		 
             	 }else if(clickedButton==btnDoiPhong) {
             		if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đổi phòng không?","Đổi phòng",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
             			
             			
             			for (int i = 0; i < dsPDP.size(); i++) {
             				if (dsPDP.get(i).getPhong().getMaPhong().equals(cbxPhong.getSelectedItem().toString())
             						&& dsPDP.get(i).getKhachHang().getmaKH().equals(txtCCKH.getText())
             						&& dsPDP.get(i).getThoiGianNhan().toString().equals(txtNgayN.getText())
             						&& (dsPDP.get(i).getTrangThai().contains("Đã đặt")||dsPDP.get(i).getTrangThai().contains("Đã nhận"))) {
             					phieuDatPhong_DAO.updatePhongPhieuDatPhong(dsPDP.get(i).getMaPhieu(), txtPhong.getText());
             					JOptionPane.showMessageDialog(null,"Đổi phòng thành công");
             					//load lai het du lieu
             					updateData();
             					String thaydoitrangthai = "";
             					for (int j = 0; j < dsP.size(); j++) {
             						if (dsP.get(j).getMaPhong().equals(cbxPhong.getSelectedItem().toString())) {
             							thaydoitrangthai = dsP.get(j).getTrangThai();
             							Phong_dao.updateTrangThaiPhong(cbxPhong.getSelectedItem().toString(), "Trống");
             							break;
             						}
             					}
             					Phong_dao.updateTrangThaiPhong(txtPhong.getText(), thaydoitrangthai);
             					txtCCKH.setText("");
             					txtSDTKH.setText("");
             					txtTenKH.setText("");
             					txtTuoiKH.setText("");
             					txtGioi.setText("");
             					txtNgayN.setText("");
             					txtNgayT.setText("");
             					txtPhong.setText("");
             					cbxPhong.removeAllItems();
             					panel.removeAll();
             					panel.repaint();
             					panel.revalidate();
             					break;
             				}
             			}
             		}
             	 }
                }};
                btnTim.addActionListener(actionListener);
                btnHuy.addActionListener(actionListener);
                btnDoiPhong.addActionListener(actionListener);
                chckbxPdon.addItemListener(this);
                chckbxPdoi.addItemListener(this);
                chckbxPVip.addItemListener(this);
                
                
                
                tgNhan = null;
				tgTra = null ;
                cbxPhong.addActionListener(new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
    					
    					if(cbxPhong.getSelectedItem() != null) {
    						String maPhong = cbxPhong.getSelectedItem().toString();
    						for (int i = 0; i < dsPDP.size(); i++) {
    							if (dsPDP.get(i).getPhong().getMaPhong().equals(maPhong)&& dsPDP.get(i).getKhachHang().getmaKH().equals(txtCCKH.getText())&& (dsPDP.get(i).getTrangThai().contains("Đã đặt")||dsPDP.get(i).getTrangThai().contains("Đã nhận"))) {
    								txtNgayN.setText(dsPDP.get(i).getThoiGianNhan().toString());
    								tgNhan = dsPDP.get(i).getThoiGianNhan();
    								txtNgayT.setText(dsPDP.get(i).getThoiGianTra().toString());
    								tgTra = dsPDP.get(i).getThoiGianTra();
    								break;
    							}
    						}}
    					soPhong = new String[0];
    					tenKhachHang = new String[0];
    					trangThai = new int[0];
    					panel.removeAll();
    					panel.repaint();
    					panel.revalidate();
    					//kiem tra nhung phong co the doi
    					for (int j = 0; j < dsP.size(); j++) {
    						int count=0;
    						int skips=1;
    						
    						if(dsP.get(j).getTrangThai().contains("Đã đặt")||dsP.get(j).getTrangThai().contains("Đã thuê")||dsP.get(j).getTrangThai().contains("Bảo trì")) {
    							continue;
    						}
							for(int i = 0; i < cbxPhong.getItemCount(); i++) {
								if (dsP.get(j).getMaPhong().equals(cbxPhong.getItemAt(i).toString())) {
									skips=0;
								}
							}
							if(skips==0) {
								continue;
							}
    						for(int i = 0; i < dsPDP.size(); i++) {
    							if (dsP.get(j).getMaPhong().equals(dsPDP.get(i).getPhong().getMaPhong())
        						&& (dsPDP.get(i).getThoiGianNhan().compareTo(tgTra) > 0
        						|| dsPDP.get(i).getThoiGianTra().compareTo(tgNhan) < 0)
        						&& (dsPDP.get(i).getTrangThai().contains("Đã đặt")||dsPDP.get(i).getTrangThai().contains("Đã nhận"))) {
    								soPhong = Arrays.copyOf(soPhong, soPhong.length + 1);
        							soPhong[soPhong.length - 1] = dsPDP.get(i).getPhong().getMaPhong();
        							tenKhachHang = Arrays.copyOf(tenKhachHang, tenKhachHang.length + 1);
        							tenKhachHang[tenKhachHang.length - 1] = "";
        							trangThai = Arrays.copyOf(trangThai, trangThai.length + 1);
        							trangThai[trangThai.length - 1] = 3;
        							count=1;
        							break;
    							}
    						}if(count==0) {
    							soPhong = Arrays.copyOf(soPhong, soPhong.length + 1);
    							soPhong[soPhong.length - 1] = dsP.get(j).getMaPhong();
    							tenKhachHang = Arrays.copyOf(tenKhachHang, tenKhachHang.length + 1);
    							tenKhachHang[tenKhachHang.length - 1] = "";
    							trangThai = Arrays.copyOf(trangThai, trangThai.length + 1);
    							trangThai[trangThai.length - 1] = 3;
    						}
    						}
    						
    							
    							
    							
    							
    							
    							

			
						
						
						//tao mang 2 chieu
						mangHaiChieu = new String[3][soPhong.length];
						
				        for (int k = 0; k < soPhong.length; k++) {
				            mangHaiChieu[0][k] = soPhong[k];
				            mangHaiChieu[1][k] = tenKhachHang[k];
				            mangHaiChieu[2][k] = String.valueOf(trangThai[k]);
				        }
			     
				        mangHaiChieu = sapXep(mangHaiChieu);
				        soPhong = mangHaiChieu[0];
				        tenKhachHang = mangHaiChieu[1];
				        trangThai = new int[soPhong.length];
				        
						for (int k = 0; k < soPhong.length; k++) {
							trangThai[k] = Integer.parseInt(mangHaiChieu[2][k]);
						}
						
	
						
						
						
						maphongs = new String[0];
						tens = new String[0];
						trangTs = new int[0];
						for (int k = 0; k < maphongs.length; k++) {
							maphongs[k] = null;
							tens[k] = null;
							trangTs[k] = 0;
						}
						
						for (int k = 0; k < soPhong.length; k++) {
							if (trangThai[k]==3) {
								maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
								maphongs[maphongs.length - 1] = soPhong[k];
								tens = Arrays.copyOf(tens, tens.length + 1);
								tens[tens.length - 1] = tenKhachHang[k];
								trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
								trangTs[trangTs.length - 1] = trangThai[k];
							}
							}
						
						
						button = createButtons(panel, maphongs, tens, trangTs);
				}
			});
    					
    					
    					
    					
						
						
						
    						
    					

                    
                 
                    
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
            buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton clickedButton = (JButton) e.getSource();
					for (int i = 0; i < buttons.length; i++) {
						if (clickedButton == buttons[i]) {
							txtPhong.setText(roomNumbers[i]);
						}
					}
				}
			});

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
	
	//update lại dữ liệu
	public void updateData() {
		Phong_dao  = new Phong_DAO();
		dsP = Phong_dao.getalltbPhong();
		soPhong = new String[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			soPhong[i] = dsP.get(i).getMaPhong();
		}
		khachHang_DAO = new KhachHang_DAO();
		dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		
		
		tenKhachHang = new String[dsP.size()];
		trangThai = new int[dsP.size()];
		

		
		
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
			} else if (dsP.get(i).getTrangThai().contains("Trống")) {
				trangThai[i] = 3;
				tenKhachHang[i] = "";
				
			}else {
				trangThai[i] = 4;
				tenKhachHang[i] = "";
				
			}
			
		}
	}
	//kiem tra doi tuong
	public boolean checkObject() {
		if(txtCCKH.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã khách hàng");
            return true;
        }
		if (txtPhong.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng cần đổi");
			return true;
		}
		if (txtTenKH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng");
			return true;
		}
		
		return false;
	}
	//ham set trang thai va ten khach hang va so phong co ngay dat va ngay tra khong trong khong khoang thoi gian truyen vao
	
	
	
	
	
	
		
	
	
	
}
