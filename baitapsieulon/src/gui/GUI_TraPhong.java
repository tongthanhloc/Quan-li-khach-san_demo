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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;



public class GUI_TraPhong extends JFrame implements ItemListener{

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
    String tenKhachHang[] ;//= {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private JPanel panel;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	private PhieuDatPhong_DAO pdp;

	private JCheckBox chckbxPdon;
	private JCheckBox chckbxPdoi;
	private JCheckBox chckbxPVip;
	private JPanel panelKH;
	static JTextField txtNgayN;
	private JLabel lblNewLabel_1_1_3;
	static JTextField txtPhongs;
	private JLabel lblNewLabel_1_1_4;
	static JTextField txtSoNguoi;
	private JButton btnXutHan;
	private JButton btnHy;
	static JTextField txtGT;
	static JTextField txtNgayT;
	static ArrayList<PhieuDatPhong> dsPDP;
	private KhachHang_DAO kh;
	static ArrayList<Phong> dsP;
	static ArrayList<KhachHang> dsKH;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TraPhong frame = new GUI_TraPhong();
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
	public GUI_TraPhong() {
		
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(258,181,1654, 859);
		setUndecorated(true);
		setResizable(false);
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
		
		pdp = new PhieuDatPhong_DAO();
		dsPDP = pdp.getAllTbPhieuDatPhong();
		
		kh =new KhachHang_DAO();
		dsKH = kh.getalltbKhachHang();
		
		
		
		
		
		
		
		
		soPhong = new String[0];
		trangThai = new int[0];
		tenKhachHang = new String[0];
		
		
		for (int i = 0; i < dsPDP.size(); i++) {
			
			if (dsPDP.get(i).getTrangThai().contains("Đã nhận")) {
				soPhong = Arrays.copyOf(soPhong, soPhong.length + 1);
				soPhong[soPhong.length - 1] = dsPDP.get(i).getPhong().getMaPhong();
				trangThai = Arrays.copyOf(trangThai, trangThai.length + 1);
				trangThai[trangThai.length - 1] = 2;
				tenKhachHang = Arrays.copyOf(tenKhachHang, tenKhachHang.length + 1);
				for (int j = 0; j < dsKH.size(); j++) {
					if (dsKH.get(j).getMaKH().equals(dsPDP.get(i).getKhachHang().getMaKH())) {
						tenKhachHang[tenKhachHang.length - 1] = dsKH.get(j).getHoTen();
					}
				}
				
			}
		}
		
		
		panelKH = new JPanel();
		panelKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelKH.setBounds(0, 0, 1654, 279);
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
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(234, 232, 214));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(696, 37, 96, 26);
		panelKH.add(btnNewButton);
		
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(100, 132, 185, 26);
		panelKH.add(lblNewLabel_1_1_1);
		
		txtNgayN = new JTextField();
		txtNgayN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayN.setColumns(10);
		txtNgayN.setBounds(313, 132, 350, 26);
		txtNgayN.setEditable(false);
		panelKH.add(txtNgayN);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ngày trả phòng:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(990, 132, 185, 26);
		panelKH.add(lblNewLabel_1_1_2);
		
		lblNewLabel_1_1_3 = new JLabel("Phòng:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setBounds(100, 179, 185, 26);
		panelKH.add(lblNewLabel_1_1_3);
		
		txtPhongs = new JTextField();
		txtPhongs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhongs.setColumns(10);
		txtPhongs.setBounds(313, 179, 350, 26);
		txtPhongs.setEditable(false);
		panelKH.add(txtPhongs);
		
		lblNewLabel_1_1_4 = new JLabel("Số Người:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_4.setBounds(990, 179, 185, 26);
		panelKH.add(lblNewLabel_1_1_4);
		
		txtSoNguoi = new JTextField();
		txtSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoNguoi.setColumns(10);
		txtSoNguoi.setBounds(1185, 179, 368, 26);
		txtSoNguoi.setEditable(false);
		panelKH.add(txtSoNguoi);
		
		btnXutHan = new JButton("Xuất Hóa đơn");
		btnXutHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXutHan.setBackground(new Color(234, 232, 214));
		btnXutHan.setBounds(1203, 238, 166, 26);
		panelKH.add(btnXutHan);
		
		btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBackground(new Color(234, 232, 214));
		btnHy.setBounds(1387, 238, 166, 26);
		panelKH.add(btnHy);
		
		txtGT = new JTextField();
		txtGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGT.setColumns(10);
		txtGT.setBounds(1349, 86, 204, 26);
		txtGT.setEditable(false);
		panelKH.add(txtGT);
		
		txtNgayT = new JTextField();
		txtNgayT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayT.setColumns(10);
		txtNgayT.setBounds(1185, 132, 368, 26);
		txtNgayT.setEditable(false);
		panelKH.add(txtNgayT);
		
		chckbxPdon = new JCheckBox("Phòng đơn (A)");
		chckbxPdon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdon.setBounds(37, 286, 178, 43);
		Frame.add(chckbxPdon);
		chckbxPdon.setSelected(true);
		

		
		chckbxPdoi = new JCheckBox("Phòng đôi (B)");
		chckbxPdoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdoi.setBounds(327, 289, 178, 43);
		Frame.add(chckbxPdoi);
		chckbxPdoi.setSelected(true);
		

		
		chckbxPVip = new JCheckBox("Phòng VIP (C)");
		chckbxPVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPVip.setBounds(613, 289, 178, 43);
		Frame.add(chckbxPVip);
		chckbxPVip.setSelected(true);
		
		outerPanel = new JPanel(null);
		outerPanel.setBounds(37, 336, 1580, 464);
		Frame.add(outerPanel);
		
		
		

        // Tạo một panel bên trong với layout null và kích thước cố định
		panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(1500, 380));
		
		 JScrollPane scrollPane = new JScrollPane(panel);                      
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
		 scrollPane.setBounds(0, 0, 1580, 464);

	        // Thêm JScrollPane vào panel bên ngoài
	     outerPanel.add(scrollPane);
	     mangHaiChieu = new String[3][soPhong.length];
	        for (int i = 0; i < soPhong.length; i++) {
	            mangHaiChieu[0][i] = soPhong[i];
	            mangHaiChieu[1][i] = tenKhachHang[i];
	            mangHaiChieu[2][i] = String.valueOf(trangThai[i]);
	        }
//	        
	        mangHaiChieu = sapXep(mangHaiChieu);
	        soPhong = mangHaiChieu[0];
	        tenKhachHang = mangHaiChieu[1];
	        trangThai = new int[soPhong.length];
	        
			for (int i = 0; i < soPhong.length; i++) {
				trangThai[i] = Integer.parseInt(mangHaiChieu[2][i]);
			}
			
//	        button=createButtons(panel, soPhong, tenKhachHang, trangThai);
			
//			soPhong = Arrays.copyOf(soPhong, soPhong.length + 1);
//			soPhong[soPhong.length - 1] = "A11";
//			tenKhachHang = Arrays.copyOf(tenKhachHang, tenKhachHang.length + 1);
//			tenKhachHang[tenKhachHang.length - 1] = "Khongbie";
//			trangThai = Arrays.copyOf(trangThai, trangThai.length + 1);
//			trangThai[trangThai.length - 1] = 2;
			
			
			
			
			
			
			button = createButtons(panel, soPhong, tenKhachHang, trangThai);
			
		
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                if (clickedButton == btnXutHan) {
                	
				} else if (clickedButton == btnHy) {
					txtCCKH.setText("");
					txtSDTKH.setText("");
					txtTenKH.setText("");
					txtTuoiKH.setText("");
					txtGT.setText("");
					txtNgayN.setText("");
					txtNgayT.setText("");
					txtPhongs.setText("");
					txtSoNguoi.setText("");
					txtCCKH.requestFocus();
				}
                
                
            }};
                    btnXutHan.addActionListener(actionListener);
                    btnHy.addActionListener(actionListener);
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
				if (soPhong[i].contains("C") && trangThai[i]==2) {
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
    							txtPhongs.setText(roomNumbers[i]);
    							txtTenKH.setText(customerNames[i]);
    							for (int j = 0; j < dsPDP.size(); j++) {
    								if (dsPDP.get(i).getPhong().getMaPhong().equals(roomNumbers[i])) {
    									txtCCKH.setText(dsPDP.get(i).getKhachHang().getMaKH());
    									
    									for (int k = 0; k < dsKH.size(); k++) {
    										if (dsKH.get(k).getMaKH().equals(dsPDP.get(i).getKhachHang().getMaKH())) {
    											if (dsKH.get(k).getGioiTinh() == true) {
                                                    txtGT.setText("Nam");
                                                } else {
                                                	txtGT.setText("Nữ");
                                                }
    											txtTenKH.setText(dsKH.get(k).getHoTen());
    											txtTuoiKH.setText(""+LocalDate.now().compareTo(dsKH.get(k).getNgaySinh()));
    											txtSDTKH.setText(dsKH.get(k).getSoDT());
    										}
    									}
    								}
    							}
    							txtNgayN.setText(dsPDP.get(i).getThoiGianNhan().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
    							//lay thoi gian hien tai
    							LocalDate now = LocalDate.now();
    							
    							//set dang dd/MM/yyyy
    							
    							txtNgayT.setText(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
    							txtSoNguoi.setText(""+dsPDP.get(i).getSoNguoi());
    							
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

	
}
