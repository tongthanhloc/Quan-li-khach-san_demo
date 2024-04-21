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
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLiDatPhong frame = new GUI_QuanLiDatPhong();
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
	public GUI_QuanLiDatPhong() {
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
		khachHang_DAO = new KhachHang_DAO();
		ArrayList<KhachHang> dsKH = khachHang_DAO.getalltbKhachHang();
		
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		ArrayList<PhieuDatPhong> dsPDP = phieuDatPhong_DAO.getAllTbPhieuDatPhong();
		// kiểm tra trạng thái phòng
		for (int i = 0; i < dsPDP.size(); i++) {
			if (dsPDP.get(i).getTrangThai().contains("Đã đặt")&&dsPDP.get(i).getThoiGianNhan().compareTo(LocalDate.now())<0) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				phieuDatPhong_DAO.updateTrangThaiPhieuDatPhong(maPhieu, "Đã Hủy");
			}
			if (dsPDP.get(i).getTrangThai().contains("Đã nhận")
					&& dsPDP.get(i).getThoiGianTra().compareTo(LocalDate.now()) ==-1) {
				String maPhieu = dsPDP.get(i).getMaPhieu();
				JOptionPane.showMessageDialog(null, "Phòng " + dsPDP.get(i).getPhong().getMaPhong() + " đã quá hạn"+(dsPDP.get(i).getThoiGianTra().compareTo(LocalDate.now()))+"ngày");
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
                        && (dsPDP.get(j).getThoiGianTra().compareTo(tghientai) == 0)
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
			} else if (dsP.get(i).getTrangThai().contains("Bảo trì")) {
				trangThai[i] = 4;
				tenKhachHang[i] = "";
			}
		}
		
		
		chckbxdadat = new JCheckBox("Đã đặt");
		chckbxdadat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxdadat.setBounds(35, 23, 97, 43);
		Frame.add(chckbxdadat);
		chckbxdadat.setSelected(true);
		

		
		
		
		
		chckbxThue = new JCheckBox("Đã thuê");
		chckbxThue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxThue.setBounds(134, 23, 112, 43);
		Frame.add(chckbxThue);
		chckbxThue.setSelected(true);
		

		
		chckbxTrong = new JCheckBox("Trống");
		chckbxTrong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxTrong.setBounds(248, 23, 91, 43);
		Frame.add(chckbxTrong);
		chckbxTrong.setSelected(true);
		

		
		chckbxBaotri = new JCheckBox("Bảo trì");
		chckbxBaotri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxBaotri.setBounds(341, 23, 112, 43);
		Frame.add(chckbxBaotri);
		chckbxBaotri.setSelected(true);
		

		
		chckbxPdon = new JCheckBox("Phòng đơn (A)");
		chckbxPdon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdon.setBounds(35, 81, 178, 43);
		Frame.add(chckbxPdon);
		chckbxPdon.setSelected(true);
		

		
		chckbxPdoi = new JCheckBox("Phòng đôi (B)");
		chckbxPdoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPdoi.setBounds(237, 81, 178, 43);
		Frame.add(chckbxPdoi);
		chckbxPdoi.setSelected(true);
		
		
		chckbxPVip = new JCheckBox("Phòng VIP (C)");
		chckbxPVip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPVip.setBounds(447, 81, 178, 43);
		Frame.add(chckbxPVip);
		chckbxPVip.setSelected(true);
		

		
		Panel panel_Center_dadat = new Panel();
		panel_Center_dadat.setBackground(new Color(34, 242, 93));
		panel_Center_dadat.setBounds(53, 142, 145, 43);
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
		panel_Center_dathue.setBounds(229, 142, 145, 43);
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
		panel_Center_trong.setBounds(409, 142, 145, 43);
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
		panel_Center_baotri.setBounds(587, 142, 145, 43);
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
        outerPanel.setBounds(35, 210, 1580, 638); // Đặt vị trí và kích thước của panel bên ngoài
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
//        
        mangHaiChieu = sapXep(mangHaiChieu);
        soPhong = mangHaiChieu[0];
        tenKhachHang = mangHaiChieu[1];
        trangThai = new int[soPhong.length];
        
		for (int i = 0; i < soPhong.length; i++) {
			trangThai[i] = Integer.parseInt(mangHaiChieu[2][i]);
		}
		
        button=createButtons(panel, soPhong, tenKhachHang, trangThai);
        
        
        
        
        
        
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
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                
                    setVisible(false); // Đóng frame hiện tại
                    new GUI_GiaHanPhong().setVisible(true);
                }};
                    
                 
                    
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
	
	
}
