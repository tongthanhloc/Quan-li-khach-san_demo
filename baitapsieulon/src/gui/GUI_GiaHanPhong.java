package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Phong_DAO;
import entity.Phong;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
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
    private JTextField textField;
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
    private JButton btntPhng;
    private JButton btnHy;
	private JButton[] button;
	String soPhong[];
    String tenKhachHang[] = {"Chau Tieu Long","","","","","","","","","","","","Nguyen Nhat Tung","","","","Tong Thanh Loc","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int trangThai[];
//    = {1,3,3,3,3,3,3,3,3,3,3,3,2,3,3,4,2,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
	private String[][] mangHaiChieu;
	private String maphongs[]=null;
	private int trangTs[]=null;
	private String tens[]=null;
	private Phong_DAO Phong_dao;
	
	private JPanel panelKH;
	private JTextField txtPTrong;
	private JTextField txtGioi;
	



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
			if (dsP.get(i).getTrangThai().equals("Tr?ng")) {
				trangThai[i] = 3;
			}
			if (dsP.get(i).getTrangThai().equals("Bảo trì")) {
				trangThai[i] = 4;
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
		
		textField = new JTextField();
		textField.setBounds(313, 37, 350, 26);
		panelKH.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(234, 232, 214));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(696, 37, 96, 26);
		panelKH.add(btnNewButton);
		
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
		panelP.add(dateTraP);
		
		btntPhng = new JButton("Gia hạn phòng");
		btntPhng.setBackground(new Color(234, 232, 214));
		btntPhng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btntPhng.setBounds(1204, 133, 173, 26);
		panelP.add(btntPhng);
		
		btnHy = new JButton("Hủy");
		
		btnHy.setBackground(new Color(234, 232, 214));
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBounds(1387, 133, 168, 26);
		panelP.add(btnHy);
		
		txtPTrong = new JTextField();
		txtPTrong.setColumns(10);
		txtPTrong.setBounds(1205, 27, 350, 26);
		txtPTrong.setEditable(false);
		panelP.add(txtPTrong);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(313, 27, 350, 26);
		panelP.add(comboBox);
	     
        
		
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                }};
                    
                 
                    
	}
	

	
}
