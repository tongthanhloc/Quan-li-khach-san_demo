package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class GUI_DoiMatKhau extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField txttendangnhap;
	private JPasswordField txtmatkhau;
	private String[] tk;
	private String[] mk;
	private TaiKhoan_DAO taiKhoan_DAO;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DoiMatKhau frame = new GUI_DoiMatKhau();
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
	public GUI_DoiMatKhau() {
		
		setIconImage(new ImageIcon(GUI_DangNhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		
		setBounds(0,0,1080,720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		taiKhoan_DAO = new TaiKhoan_DAO();
		ArrayList<TaiKhoan> dsTK = taiKhoan_DAO.getTaiKhoan();
		tk = new String[dsTK.size()];
		mk = new String[dsTK.size()];
		for (int i = 0; i < dsTK.size(); i++) {
			tk[i] = dsTK.get(i).getNhanVien().getMaNV().toString();
			mk[i] = dsTK.get(i).getMatKhau();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel logo = new JLabel("");
		logo.setBounds(29,128, 397, 400);
		contentPane.add(logo);
		ImageIcon originalIcon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(GUI_DangNhap.class.getResource("/img/logo.png")));
		Image scaledImage = originalIcon.getImage().getScaledInstance(397, 400, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		logo.setIcon(scaledIcon);
		
		JLabel lbldangnhap = new JLabel("Đổi Mật Khẩu");
		lbldangnhap.setHorizontalAlignment(SwingConstants.CENTER);
		lbldangnhap.setFont(new Font("Tahoma", Font.BOLD, 70));
		lbldangnhap.setForeground(new Color(41, 139, 116));
		lbldangnhap.setBounds(461, 149, 559, 76);
		contentPane.add(lbldangnhap);
		
		JLabel lbltendangnhap = new JLabel("Tên đăng nhập:");
		//lbltendangnhap.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH)));
		lbltendangnhap.setForeground(new Color(41, 139, 116));
		lbltendangnhap.setHorizontalAlignment(SwingConstants.LEFT);
		lbltendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbltendangnhap.setBounds(436, 236, 212, 69);
		contentPane.add(lbltendangnhap);
		
		txttendangnhap = new JTextField();
		txttendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txttendangnhap.setBounds(657, 252, 363, 38);
		contentPane.add(txttendangnhap);
		txttendangnhap.setColumns(10);
		
		JLabel lblmatkhau = new JLabel("Mật khẩu:");
		lblmatkhau.setForeground(new Color(41, 139, 116));
		lblmatkhau.setHorizontalAlignment(SwingConstants.LEFT);
		lblmatkhau.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblmatkhau.setBounds(436, 316, 212, 69);
		contentPane.add(lblmatkhau);
		
		txtmatkhau = new JPasswordField();
		txtmatkhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmatkhau.setColumns(10);
		txtmatkhau.setBounds(657, 334, 363, 38);
		contentPane.add(txtmatkhau);
		
		JButton btnNewButton = new JButton("Đổi mật khẩu");
		btnNewButton.addActionListener(new ActionListener() {
			private NhanVien nv = new NhanVien(txttendangnhap.getText());
			NhanVien_DAO nv_dao = new NhanVien_DAO();
			ArrayList<NhanVien> ListNV = nv_dao.getalltbNhanVien();
			public void actionPerformed(ActionEvent e) {
				if (kiemtraDMK(txttendangnhap.getText(), txtmatkhau.getText().toString()) == -1) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp");
				} else if (kiemtraDMK(txttendangnhap.getText(), txtmatkhau.getText()) == -2) {
					JOptionPane.showMessageDialog(null,
							"Mật khẩu phải có ít nhất 6 kí tự, chứa chữ cái, số và kí tự đặc biệt");
				} else if (kiemtraDMK(txttendangnhap.getText(), txtmatkhau.getText()) == 0) {
					JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại");
				} else {
					taiKhoan_DAO.doiMatKhau(txttendangnhap.getText(), txtmatkhau.getText());
					JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
				}
			}
			
			
		});
		
		getRootPane().setDefaultButton(btnNewButton);
		
		btnNewButton.setBackground(new Color(41, 139, 116));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(550, 496, 384, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu:");
		lblNhpLiMt.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhpLiMt.setForeground(new Color(41, 139, 116));
		lblNhpLiMt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNhpLiMt.setBounds(436, 396, 212, 69);
		contentPane.add(lblNhpLiMt);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setColumns(10);
		passwordField.setBounds(657, 414, 363, 38);
		contentPane.add(passwordField);

        
	}

	public int kiemtraDMK(String tenDN, String matKhau) {
		if (!matKhau.equals(passwordField.getText())) {
			System.out.println(matKhau);
			System.out.println(passwordField);
			return  -1;
		}
		//kiem tra mat khau co it nhat 6 ki tu, co chu va so va ki tu dac biet
		if (matKhau.length() < 6||matKhau.length() > 20||!matKhau.matches(".*[a-zA-Z].*")||!matKhau.matches(".*\\d.*")||!matKhau.matches(".*[!@#$%.^&*()-_+=].*")) {
			return -2;
		}
		
		for (int i = 0; i < tk.length; i++) {
			if (tk[i].equals(tenDN)) {
				return 1;
			}
		}
		return 0;
	}
}
