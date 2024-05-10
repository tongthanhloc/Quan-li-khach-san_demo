package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;



public class GUI_GiaHanPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblNewLabel_1_4;
    private JPanel panelP;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JTextField txtNgayN;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JTextField textField_8;
    private JTextField textField_9;
    private JButton btnGHP;
    private JButton btnHuy;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[]; //= {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private String maphongs[]=null;
	private String maPhieuDatPhong[]=null;
	private long ngay;
	
	
	
	private Phong_DAO Phong_dao;
	
	private JPanel panelKH;
	private JTextField txtPTrong;
	private JTextField txtGioi;
	private KhachHang_DAO khachHang_DAO;
	private PhieuDatPhong_DAO phieuDatPhong_DAO;
	private ArrayList<PhieuDatPhong> dsPDP;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_GiaHanPhong frame = new GUI_GiaHanPhong();
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
	public GUI_GiaHanPhong() {
		
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
		maphongs = new String[0];
		maPhieuDatPhong = new String[0];
		

		
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
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		// kiểm tra trạng thái phòng
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getTrangThai().contains("Đã đặt")&&dsPDP.get(i).getThoiGianNhan().compareTo(LocalDate.now())<0) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
			}
			if (dsPDP.get(i).getTrangThai().contains("Đã nhận")
					&& dsPDP.get(i).getThoiGianTra().compareTo(LocalDate.now()) ==-1) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
//				JOptionPane.showMessageDialog(null, "Phòng " + dsPDP.get(i).getPhong().getMaPhong() + " đã quá hạn"+(dsPDP.get(i).getThoiGianTra().compareTo(LocalDate.now()))+"ngày");
			}
		}
		LocalDate tghientai = LocalDate.now();
		for (int i = 0; i < dsP.size(); i++) {
			for(int j = 0; j < dsPDP.size(); j++) {
			
				if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
						&& dsPDP.get(j).getTrangThai().contains("Đã đặt")
						&& (dsPDP.get(j).getThoiGianNhan().compareTo(tghientai) == 0)
						) {
					Phong_dao.updateTrangThaiPhong(dsP.get(i).getMaPhong(), "Đã đặt");
				}else if (dsPDP.get(j).getPhong().getMaPhong().equals(dsP.get(i).getMaPhong())
                        && dsPDP.get(j).getTrangThai().contains("Đã nhận")
                        ) {
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
		txtmaKH.setBounds(313, 37, 350, 26);
		panelKH.add(txtmaKH);
		txtmaKH.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim.setBounds(696, 37, 96, 26);
		panelKH.add(btnTim);
		
		txtSDT = new JTextField();
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
		lblNewLabel_1_2.setBounds(938, 37, 185, 26);
		panelKH.add(lblNewLabel_1_2);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(1205, 41, 350, 26);
		txtTen.setEditable(false);
		panelKH.add(txtTen);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(938, 82, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(1045, 86, 150, 26);
		txtTuoi.setEditable(false);
		panelKH.add(txtTuoi);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1237, 82, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		txtGioi = new JTextField();
		txtGioi.setColumns(10);
		txtGioi.setBounds(1362, 86, 193, 26);
		txtGioi.setEditable(false);
		panelKH.add(txtGioi);
		
		panelP = new JPanel();
		panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelP.setBounds(0, 138, 1654, 190);
		Frame.add(panelP);
		panelP.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Số Phòng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(100, 27, 185, 26);
		panelP.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(100, 75, 185, 26);
		panelP.add(lblNewLabel_8);
		
		txtNgayN = new JTextField();
		txtNgayN.setColumns(10);
		txtNgayN.setBounds(313, 75, 350, 26);
		txtNgayN.setEditable(false);
		panelP.add(txtNgayN);
		
		lblNewLabel_10 = new JLabel("Ngày trả Phòng:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(937, 75, 185, 26);
		panelP.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Phòng còn trống tới ngày:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(937, 27, 258, 26);
		panelP.add(lblNewLabel_11);
		
		JDateChooser dateTraP = new JDateChooser();
		dateTraP.setDateFormatString("dd/MM/yyyy");
		dateTraP.setBounds(1205, 75, 350, 26);
		dateTraP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//set date ngày mai
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		dateTraP.setDate(cal.getTime());
		//tat chuc nang sua text
		dateTraP.getDateEditor().setEnabled(false);
		panelP.add(dateTraP);
		
		btnGHP = new JButton("Gia hạn phòng");
		btnGHP.setBackground(new Color(234, 232, 214));
		btnGHP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGHP.setBounds(1204, 133, 173, 26);
		panelP.add(btnGHP);
		
		btnHuy = new JButton("Hủy");
		
		btnHuy.setBackground(new Color(234, 232, 214));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuy.setBounds(1387, 133, 168, 26);
		panelP.add(btnHuy);
		
		txtPTrong = new JTextField();
		txtPTrong.setColumns(10);
		txtPTrong.setBounds(1205, 27, 350, 26);
		txtPTrong.setEditable(false);
		panelP.add(txtPTrong);
		
		JComboBox cbxPhong = new JComboBox();
		cbxPhong.setBounds(313, 27, 350, 26);
		panelP.add(cbxPhong);
	     
        
		
		
		
		
		           
                 
		 ActionListener actionListener = new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                JButton clickedButton = (JButton) e.getSource();
	                // Xử lý sự kiện cho mỗi nút ở đây
	                if (clickedButton==btnTim) {
	                	
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
	             			   txtGioi.setText("Nam");
	 						} else {
	 							txtGioi.setText("Nữ");
	 						}
	             		   
	             		   cbxPhong.removeAllItems();
	                 		for (int i = 0; i < dsPDP.size(); i++) {
								if (dsPDP.get(i).getKhachHang().getmaKH().equals(maKH)&&(dsPDP.get(i).getTrangThai().contains("Đã nhận")||dsPDP.get(i).getTrangThai().contains("Đã đặt")) ){
									cbxPhong.addItem(dsPDP.get(i).getPhong().getMaPhong());
									//tao bien lay ma phong va ma phieu
									maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
		        					maphongs[maphongs.length - 1] = soPhong[i];
		        					maPhieuDatPhong = Arrays.copyOf(maPhieuDatPhong, maPhieuDatPhong.length + 1);
		        					maPhieuDatPhong[maPhieuDatPhong.length - 1] = dsPDP.get(i).getMaPhieu();
								}
	                 		}
	                 		cbxPhong.addActionListener(new ActionListener() {
	    	    				

								public void actionPerformed(ActionEvent e) {
	    	    					
	    	    					if(cbxPhong.getSelectedItem() != null) {
	    	    						txtPTrong.setText("");
	    	    						for (int i = 0; i < dsPDP.size(); i++) {
	    	    							if (cbxPhong.getSelectedItem().equals(dsPDP.get(i).getPhong().getMaPhong())) {
	    	    								txtNgayN.setText(dsPDP.get(i).getThoiGianDat().toString());
	    	    								
	    	    							}
	    	    						}
	    	    						int	count = 0;
	    	    						int kiemtra=0;
	    	    						//lay thoi gian phong con trong
	    	    						for (int i = 0; i < dsPDP.size(); i++) {
	    	    							//lay so thu tu cua cbxPhong
	    	    							int so = cbxPhong.getSelectedIndex();
	    	    							
	    	    								if (dsPDP.get(i).getMaPhieu().equals(maPhieuDatPhong[so])) {
	    	    									continue;
	    	    								}
	    	    							int dem = 0;
	    	    							if (cbxPhong.getSelectedItem().toString().equals(dsPDP.get(i).getPhong().getMaPhong().toString())) {

	    	    								if (ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now()) < 0 &&dsPDP.get(i).getTrangThai().contains("Đã đặt")) {
//	    	    									JOptionPane.showMessageDialog(null, "Phòng còn trống tới ngày " + dsPDP.get(i).getThoiGianNhan());
													if (dem == 0) {
														ngay=-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now());
														txtPTrong.setText(-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now())+" ngày");
														LocalDate tra = dsPDP.get(i).getThoiGianNhan().plusDays(-1);
														dateTraP.setDate(java.sql.Date.valueOf(tra));
														dem++;
													}else {
														if(-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now())<Integer.parseInt(txtPTrong.getText().substring(0, txtPTrong.getText().indexOf(" ")))) {
                                                            ngay=-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now());
															txtPTrong.setText(-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now())+" ngày");
															LocalDate tra = dsPDP.get(i).getThoiGianNhan().plusDays(-1);
															dateTraP.setDate(java.sql.Date.valueOf(tra));
														}
													}
//	    	    									txtPTrong.setText(-ChronoUnit.DAYS.between(dsPDP.get(i).getThoiGianNhan(), LocalDate.now())+" ngày");
//	    	    									System.out.println("phong "+dsPDP.get(i).getPhong().getMaPhong());
	    	    									count++;
	    	    								}
	    	    								
	    	    							}
	    	    							
	    	    						}
	    	    						if (count == 0) {
	    	    							txtPTrong.setText("Không có đặt trước");
	    	    						}
	    	    					}
	    	    	                
	    	    			}
	    	    		});
	                 	}
	             	   else {
	             	   		JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng");
	             	   	
	             	 }
	                }else if(clickedButton==btnGHP) {
                    	
                    	if (cbxPhong.getSelectedItem() == null) {
                    		JOptionPane.showMessageDialog(null, "Chưa chọn phòng");
                    		return;
                    	} else if (dateTraP.getDate() == null) {
							JOptionPane.showMessageDialog(null, "Chưa chọn ngày trả phòng");
							return;
                    	} else if (txtmaKH.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa nhập mã khách hàng");
							return;
						}  //kiem tra ngay tra phong
                    	else if(!txtPTrong.getText().equals("Không có đặt trước")) {
                    		if (ChronoUnit.DAYS.between(LocalDate.now(), dateTraP.getDate().toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate()) < 0) {
                        		JOptionPane.showMessageDialog(null, "Ngày trả phòng không hợp lệ");
                        		return;
                    		} else if (ChronoUnit.DAYS.between(LocalDate.now(), dateTraP.getDate().toInstant()
    								.atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate()) 
    								> ngay) {
    							JOptionPane.showMessageDialog(null, "Ngày trả phòng không hợp lệ");
    							return;
                    		}
                    	}
                    	//update ngay tra
                    	String maPhieu = maPhieuDatPhong[cbxPhong.getSelectedIndex()];
                    	LocalDate ngayTra = dateTraP.getDate().toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();
                    	phieuDatPhong_DAO.updateNgayTraPhieuDatPhong(maPhieu, ngayTra);
                    	JOptionPane.showMessageDialog(null, "Gia hạn thành công");
						dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
//                    	for (int i = 0; i < dsPDP.size(); i++) {
//							if (dsPDP.get(i).getMaPhieu().equals(maPhieu)) {
//								JOptionPane.showMessageDialog(null, "Phòng " + dsPDP.get(i).getPhong().getMaPhong() + " đã được gia hạn tới ngày " + ngayTra);
//							}
//						}
                    	
                    		
                    	
	                
	                
	                
	                }else if(clickedButton==btnHuy) {
                    	txtmaKH.setText("");
                    	txtSDT.setText("");
                    	txtTen.setText("");
                    	txtTuoi.setText("");
                    	txtGioi.setText("");
                    	txtNgayN.setText("");
                    	txtPTrong.setText("");
                    	cbxPhong.removeAllItems();
                    	dateTraP.setDate(null);
                    	maPhieuDatPhong = new String[0];
                    	maphongs = new String[0];
                    	
	                }
	                }};
	                btnTim.addActionListener(actionListener);
	                btnGHP.addActionListener(actionListener);
	                btnHuy.addActionListener(actionListener);
	                
	                          
	
	

	
}}
