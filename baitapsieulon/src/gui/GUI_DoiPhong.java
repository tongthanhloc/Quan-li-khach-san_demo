package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Phong_DAO;
import entity.Phong;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class GUI_DoiPhong extends JFrame implements ItemListener{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTextField txtCCKH;
    private JTextField txtSDTKH;
    private JTextField txtTenKH;
    private JTextField txtTuoiKH;
    private JLabel lblNewLabel_1_4;
	private Container outerPanel;
	private JButton button[];
	String soPhong[];
    String tenKhachHang[] = {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
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
	private JTextField textField_1;
	private JTextField txtNgayN;
	private JTextField txtNgayT;
	private JTextField txtGioi;
	


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
		ArrayList<Phong> dsP = Phong_dao.getalltbPhong();
		soPhong = new String[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			soPhong[i] = dsP.get(i).getMaPhong();
		}
		trangThai = new int[dsP.size()];
		for (int i = 0; i < dsP.size(); i++) {
			if (dsP.get(i).getTrangThai().equals("Đã đặt")) {
				trangThai[i] = 1;
			}
			if (dsP.get(i).getTrangThai().equals("Đã thuê")) {
				trangThai[i] = 2;
			}
			if (dsP.get(i).getTrangThai().equals("Trống")) {
				trangThai[i] = 3;
			}
			if (dsP.get(i).getTrangThai().equals("Bảo trì")) {
				trangThai[i] = 4;
			}
		}
		
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
		txtCCKH.setBounds(313, 37, 350, 26);
		panelKH.add(txtCCKH);
		txtCCKH.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(234, 232, 214));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(696, 37, 96, 26);
		panelKH.add(btnNewButton);
		
		txtSDTKH = new JTextField();
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(313, 86, 350, 26);
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
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(1185, 37, 368, 26);
		txtTenKH.setEditable(false);
		panelKH.add(txtTenKH);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(990, 86, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		txtTuoiKH = new JTextField();
		txtTuoiKH.setColumns(10);
		txtTuoiKH.setBounds(1067, 86, 120, 26);
		txtTuoiKH.setEditable(false);
		panelKH.add(txtTuoiKH);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1243, 86, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		txtGioi = new JTextField();
		txtGioi.setColumns(10);
		txtGioi.setBounds(1354, 86, 199, 26);
		txtGioi.setEditable(false);
		panelKH.add(txtGioi);
		
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
		outerPanel.setBounds(37, 336, 1580, 512);
		Frame.add(outerPanel);
		
		
		

        // Tạo một panel bên trong với layout null và kích thước cố định
		panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(1500, 380));
		
		 JScrollPane scrollPane = new JScrollPane(panel);                      
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Đặt vị trí và kích thước của JScrollPane để trùng với panel bên ngoài
		 scrollPane.setBounds(0, 0, 1580, 512);

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
			
			
			
			maphongs = new String[0];
			tens = new String[0];
			trangTs = new int[0];
			for (int i = 0; i < maphongs.length; i++) {
				maphongs[i] = null;
				tens[i] = null;
				trangTs[i] = 0;
			}
			
			for (int i = 0; i < soPhong.length; i++) {
				if (soPhong[i].contains("A")&& trangThai[i]==3) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = soPhong[i];
					tens = Arrays.copyOf(tens, tens.length + 1);
					tens[tens.length - 1] = tenKhachHang[i];
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[i];
				}
				if (soPhong[i].contains("B")&& trangThai[i]==3) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = soPhong[i];
					tens = Arrays.copyOf(tens, tens.length + 1);
					tens[tens.length - 1] = tenKhachHang[i];
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[i];
				}
				if (soPhong[i].contains("B")&& trangThai[i]==3) {
					maphongs = Arrays.copyOf(maphongs, maphongs.length + 1);
					maphongs[maphongs.length - 1] = soPhong[i];
					tens = Arrays.copyOf(tens, tens.length + 1);
					tens[tens.length - 1] = tenKhachHang[i];
					trangTs = Arrays.copyOf(trangTs, trangTs.length + 1);
					trangTs[trangTs.length - 1] = trangThai[i];
				}}
			
			
			button = createButtons(panel, maphongs, tens, trangTs);
			
			JPanel panelKH_1 = new JPanel();
			panelKH_1.setLayout(null);
			panelKH_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelKH_1.setBounds(0, 139, 1654, 139);
			Frame.add(panelKH_1);
			
			JLabel lblNewLabel_1_5 = new JLabel("Phòng cần đổi:");
			lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_5.setBounds(100, 37, 185, 26);
			panelKH_1.add(lblNewLabel_1_5);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(313, 86, 350, 26);
			panelKH_1.add(textField_1);
			
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
			txtNgayN.setColumns(10);
			txtNgayN.setBounds(1185, 37, 368, 26);
			txtNgayN.setEditable(false);
			panelKH_1.add(txtNgayN);
			
			txtNgayT = new JTextField();
			txtNgayT.setColumns(10);
			txtNgayT.setBounds(1185, 86, 368, 26);
			txtNgayT.setEditable(false);
			panelKH_1.add(txtNgayT);
			
			JComboBox cbxPhong = new JComboBox();
			cbxPhong.setBounds(313, 37, 350, 26);
			panelKH_1.add(cbxPhong);
			
		
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                }};
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

	
}
