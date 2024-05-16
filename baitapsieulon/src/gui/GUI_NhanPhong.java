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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;



public class GUI_NhanPhong extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblNewLabel_1_4;
    private JPanel panelP;
    private JLabel lblNewLabel_7;
    static JTextField txtmaP;
    private JLabel lblNewLabel_8;
    static JTextField txtNguoi;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JTextField textField_8;
    private JTextField textField_9;
    private JButton bntNhanP;
    private JButton btnHy;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[] ;//= {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	
	private JPanel panelKH;
	private JTextField txtGT;
	private JButton btnTim;
	private ArrayList<Phong> dsP;
	private KhachHang_DAO khachHang_DAO;
	private ArrayList<KhachHang> dsKH;
	private PhieuDatPhong_DAO phieuDatPhong_DAO;
	private ArrayList<PhieuDatPhong> dsPDP;
	static JTextField txtDV;
	private JButton btnThemDV;
	private JPanel outerPanel;
	private JPanel panel;
	private static ArrayList<PhieuDatPhong> dsPDPKH;
	private static String[][] roomNumbers;
	private static String[] checkOutDates;
	static JDateChooser dateNhanP;
	static JDateChooser dateTraP;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_NhanPhong frame = new GUI_NhanPhong();
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
	public GUI_NhanPhong() {
		
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
		Frame.setVisible(true);

		
		
		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Phong_DAO Phong_dao  = new Phong_DAO();
		ArrayList<Phong> dsP = Phong_dao.getalltbPhong();
		
		khachHang_DAO = new KhachHang_DAO();
		dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getTrangThai().contains("Đã đặt")&&dsPDP.get(i).getThoiGianNhan().compareTo(LocalDate.now())<0) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
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
		txtmaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmaKH.setBounds(313, 37, 350, 26);
		panelKH.add(txtmaKH);
		txtmaKH.setColumns(10);
		
		btnTim = new JButton("Tìm");
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
		txtTen.setBounds(1205, 41, 350, 26);
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
		txtGT.setBounds(1370, 86, 185, 26);
		txtGT.setEditable(false);
		panelKH.add(txtGT);
		
		panelP = new JPanel();
		panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelP.setBounds(0, 138, 1654, 260);
		Frame.add(panelP);
		panelP.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Mã Phòng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(100, 27, 185, 26);
		panelP.add(lblNewLabel_7);
		
		txtmaP = new JTextField();
		txtmaP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmaP.setColumns(10);
		txtmaP.setBounds(313, 27, 350, 26);
		panelP.add(txtmaP);
		
		lblNewLabel_8 = new JLabel("Số người");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(100, 75, 185, 26);
		panelP.add(lblNewLabel_8);
		
		txtNguoi = new JTextField();
		txtNguoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNguoi.setColumns(10);
		txtNguoi.setBounds(313, 75, 350, 26);
		panelP.add(txtNguoi);
		
		lblNewLabel_9 = new JLabel("Dịch vụ:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(100, 120, 185, 26);
		panelP.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Ngày trả Phòng:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(992, 75, 185, 26);
		panelP.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(992, 27, 185, 26);
		panelP.add(lblNewLabel_11);
		
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
		
		bntNhanP = new JButton("Nhận Phòng");
		bntNhanP.setBackground(new Color(234, 232, 214));
		bntNhanP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bntNhanP.setBounds(1205, 223, 153, 26);
		panelP.add(bntNhanP);
		
		btnHy = new JButton("Hủy");
		btnHy.setBackground(new Color(234, 232, 214));
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBounds(1380, 223, 153, 26);
		panelP.add(btnHy);
		
		JLabel lblNewLabel_12 = new JLabel("Phòng đơn:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(100, 166, 101, 24);
		panelP.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("Phòng đơn:");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12_1.setBounds(254, 167, 101, 24);
		panelP.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_12_2 = new JLabel("Phòng đơn:");
		lblNewLabel_12_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12_2.setBounds(413, 167, 101, 24);
		panelP.add(lblNewLabel_12_2);
		
		JLabel lblsoPhongDon = new JLabel("10");
		lblsoPhongDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongDon.setBounds(211, 166, 33, 24);
		panelP.add(lblsoPhongDon);
		
		JLabel lblsoPhongDoi = new JLabel("10");
		lblsoPhongDoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongDoi.setBounds(365, 167, 59, 24);
		panelP.add(lblsoPhongDoi);
		
		JLabel lblsoPhongVip = new JLabel("10");
		lblsoPhongVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsoPhongVip.setBounds(524, 167, 59, 24);
		panelP.add(lblsoPhongVip);
		
		txtDV = new JTextField();
		txtDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDV.setBackground(new Color(255, 255, 255));
		txtDV.setColumns(10);
		txtDV.setBounds(313, 120, 350, 26);
		txtDV.setEditable(false);
		panelP.add(txtDV);
		
		btnThemDV = new JButton("Thêm dịch vụ");
		btnThemDV.setBackground(new Color(234, 232, 214));
		btnThemDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThemDV.setBounds(699, 120, 168, 26);
		panelP.add(btnThemDV);
		
		

		outerPanel = new JPanel(null);
		outerPanel.setBounds(37, 430, 1580, 423);
		Frame.add(outerPanel);
		
		

        // Tạo một panel bên trong với layout null và kích thước cố định
		panel = new JPanel(null);
		panel.setVisible(true);
        panel.setPreferredSize(new Dimension(1500, 380));
		
		JScrollPane scrollPane = new JScrollPane(panel);                      
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
		scrollPane.setBounds(0, 0, 1580, 423);

	        // Thêm JScrollPane vào panel bên ngoài
	    outerPanel.add(scrollPane);
	    scrollPane.setVisible(true);
	    outerPanel.setVisible(true);
	    
	    //lay maphong, ngay tra phong, ngay nhan phong tu button len cac textfield
	    
		
	    
        //tao su kien cho bien button
	    
	    
		
		
		
		ActionListener actionListener = new ActionListener() {
            

			public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                if (clickedButton == bntNhanP) {
                    // Xử lý khi nhấn vào nút btnHT
                	//lay ma phieu dat phong
                	String[] maPhongs = txtmaP.getText().split(" , ");
                	for (int i = 0; i < maPhongs.length; i++) {
                		System.out.println(maPhongs[i]);
						for (int j = 0; j < dsPDPKH.size(); j++) {
							if (dsPDPKH.get(j).getPhong().getMaPhong().equals(maPhongs[i])) {
								String maPhieu = dsPDPKH.get(j).getMaPhieu();
								phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã thuê");
							}
						}
					}
                    
                }else if (clickedButton == btnTim) {
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
              		   // lay danh sach phieu dat phong cua khach hang
              		   dsPDPKH = new ArrayList<PhieuDatPhong>();
              		   for (int i = 0; i < dsPDP.size(); i++) {
              			   	
							if (dsPDP.get(i).getKhachHang().getMaKH().equals(maKH)&&dsPDP.get(i).getTrangThai().contains("Đã đặt")&&dsPDP.get(i).getThoiGianNhan().compareTo(LocalDate.now())==0) {
								dsPDPKH.add(dsPDP.get(i));
								
							}
              		   }
              		   if (dsPDPKH.size()>0) {
              			   button = createButtons(panel);
							
              			   
              		   }else {
              			   JOptionPane.showMessageDialog(null,"Khách hàng chưa đặt phòng");
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
                	txtSDT.setText("");
                	txtGT.setText("");
                	txtmaP.setText("");
                	txtNguoi.setText("");
                	txtDV.setText("");
                	dateNhanP.setDate(new java.util.Date());
                	dateTraP.setDate(cal.getTime());
                	panel.removeAll();
                	panel.repaint();
                	panel.revalidate();
                }
                }};
                    btnHy.addActionListener(actionListener);
                    bntNhanP.addActionListener(actionListener);
                    btnTim.addActionListener(actionListener);
					
					
                    
					
                    
                    
                 
                    
	}
	public static JButton createButtons1(int i,JPanel panel, String[] roomNumbers, String checkInDates, String checkOutDates) {
        JButton buttons = new JButton();
        
        
            buttons = new JButton();
            StringBuilder htmlText = new StringBuilder("<html><center>");
            htmlText.append("<span style='font-family:Tahoma; font-size:25pt;'>");
            htmlText.append(roomNumbers[0]);
			for (int j = 1; j < roomNumbers.length; j++) {
				htmlText.append(" , ");
				htmlText.append(roomNumbers[j]);
			}
			//set kieu date cho checkInDates, checkOutDates
			String[] temp = checkInDates.split("-");
			checkInDates = temp[2]+"/"+temp[1]+"/"+temp[0];
			temp = checkOutDates.split("-");
			checkOutDates = temp[2]+"/"+temp[1]+"/"+temp[0];
			
            htmlText.append("</span><br/>");
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("Ngày nhận phòng: ").append(checkInDates).append("</span><br/>");
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("Ngày trả phòng: ").append(checkOutDates).append("</span>");
            htmlText.append("</center></html>");
            buttons.setText(htmlText.toString());
            buttons.setBounds(70 +((i)%3)*490, 50+((i)/3)*240 , 420, 200);
            panel.setPreferredSize(new Dimension(1500, 100+((i)/3)*20+150));
            buttons.setText(buttons.getText().replaceAll("na", ""));
            buttons.setBackground(new Color(5, 207, 251));
            buttons.setVisible(true);
            
        
		return buttons;
    }
	//create buttons
	public static JButton[] createButtons(JPanel panel) {
	    // Assuming dsPDPKH is a list of some custom object

	    // Initialize arrays
	    int size = dsPDPKH.size();
	    roomNumbers = new String[size][0];
	    checkOutDates = new String[size];
	    // Populate arrays
	    for (int i = 0; i < size; i++) {
	        checkOutDates[i] = dsPDPKH.get(i).getThoiGianTra().toString();
	        System.out.println(checkOutDates[i]);
	    }
	    String[] checkOutDates1 = countDuplicates(checkOutDates, checkOutDates[0]);
	    for (int i = 0; i < size; i++) {
        	for (int j = 0; j < checkOutDates1.length; j++) {
				if (dsPDPKH.get(i).getThoiGianTra().toString().equals(checkOutDates1[j])) {
					//them so phong vao mang
                    roomNumbers[j] = Arrays.copyOf(roomNumbers[j], roomNumbers[j].length + 1);
                    roomNumbers[j][roomNumbers[j].length - 1] = dsPDPKH.get(i).getPhong().getMaPhong();
					
				}
        	}
//        	roomNumbers[i] = temp;
	    }
	    
	    
	    // Create buttons
	    JButton[] buttons = new JButton[checkOutDates1.length];
	    panel.removeAll();
		panel.repaint();
		panel.revalidate();
	    for (int i = 0; i < checkOutDates1.length; i++) {
	    	System.out.println(roomNumbers[i]);
	        buttons[i] = createButtons1(i, panel, roomNumbers[i], dsPDPKH.get(i).getThoiGianNhan().toString(), checkOutDates1[i]);
	        buttons[i].setVisible(true);
	        panel.add(buttons[i]);
	    }
	    for (int i = 0; i < buttons.length; i++) {
			   buttons[i].addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       JButton clickedButton = (JButton) e.getSource();
                       for (int j = 0; j < buttons.length; j++) {
                           if (clickedButton == buttons[j]) {
                               StringBuilder htmlText = new StringBuilder("");
								// Xử lý khi nhấn vào nút btnHT
                        	   //thay doi txtmaP, txtNguoi, txtDV,txtNhanP, txtTraP
                        	   	htmlText.append(roomNumbers[j][0].toString());
                   				for (int k = 1;  k< roomNumbers[j].length; k++) {
                   					htmlText.append(" , ");
                   					htmlText.append(roomNumbers[j][k].toString());
                   				}
                   				
                   				txtmaP.setText(htmlText.toString());
                   				
                        	   
                        	                          	   
                        	   //set kieu date cho txtNhanP, txtTraP 
                   			   for (int k = 0; k < dsPDPKH.size(); k++) {
                   				   if (dsPDPKH.get(k).getPhong().getMaPhong().equals(roomNumbers[j][0])) {
                   					   dateNhanP.setDate(java.sql.Date.valueOf(dsPDPKH.get(k).getThoiGianNhan()));
                   					   dateTraP.setDate(java.sql.Date.valueOf(dsPDPKH.get(k).getThoiGianTra()));
                   					   txtNguoi.setText(String.valueOf(dsPDPKH.get(k).getSoNguoi()));
                   					  
                   					   break;
                   				   }
                   			   }
                        	   
                        	   
                        	   
                               
                           }
                       }
                   }
            });
	    }
			           
	    return buttons;
	}

	
	//ham dem co bao nhieu phan tu khong trung nhau
	public static String[] countDuplicates(String[] arr, String value) {
		String[] temp = new String[1];
		temp[0] = value;
		for (String s : arr) {
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].equals(s)) {
					break;
				}
				else if (i == temp.length - 1) {
					temp = Arrays.copyOf(temp, temp.length + 1);
					temp[temp.length - 1] = s;
				}
			}
		}
		return temp;
	}

	
	
	

	

	
}
