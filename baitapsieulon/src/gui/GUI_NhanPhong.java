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



public class GUI_NhanPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblNewLabel_1_4;
    private JPanel panelP;
    private JLabel lblNewLabel_7;
    private JTextField txtmaP;
    private JLabel lblNewLabel_8;
    private JTextField txtNguoi;
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
	private JTextField txtDV;
	private JButton btnThemDV;
	



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
		
		btnTim = new JButton("Tìm");
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
		lblNewLabel_1_2.setBounds(990, 37, 185, 26);
		panelKH.add(lblNewLabel_1_2);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(1205, 41, 350, 26);
		txtTen.setEditable(false);
		panelKH.add(txtTen);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tuổi:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(990, 86, 61, 26);
		panelKH.add(lblNewLabel_1_3);
		
		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(1067, 86, 120, 26);
		txtTuoi.setEditable(false);
		panelKH.add(txtTuoi);
		
		lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(1243, 86, 96, 26);
		panelKH.add(lblNewLabel_1_4);
		
		txtGT = new JTextField();
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
		txtmaP.setColumns(10);
		txtmaP.setBounds(313, 27, 350, 26);
		panelP.add(txtmaP);
		
		lblNewLabel_8 = new JLabel("Số người");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(100, 75, 185, 26);
		panelP.add(lblNewLabel_8);
		
		txtNguoi = new JTextField();
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
		
		JDateChooser dateNhanP = new JDateChooser();
		dateNhanP.setDateFormatString("dd/MM/yyyy");
		dateNhanP.setBounds(1205, 27, 350, 26);
		dateNhanP.setFont(new Font("Tahoma", Font.PLAIN, 20));

		dateNhanP.setDate(new java.util.Date());
		panelP.add(dateNhanP);
		
		JDateChooser dateTraP = new JDateChooser();
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
	     
        
		
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                if (clickedButton == bntNhanP) {
                    // Xử lý khi nhấn vào nút btnHT
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
              		   
                  		
                  	}
              	   else {
              	   		JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng");
              	   	}
                }else if (clickedButton == btnHy) {
                    // Xử lý khi nhấn vào nút btnHT
                }
                }};
                    btnHy.addActionListener(actionListener);
                    bntNhanP.addActionListener(actionListener);
                    btnTim.addActionListener(actionListener);
                    
                    
                 
                    
	}
	

	
}
