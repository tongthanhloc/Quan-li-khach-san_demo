package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class dangnhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txttendangnhap;
	private JPasswordField txtmatkhau;
	private String tk="NV12";
	private String mk="0123";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhap frame = new dangnhap();
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
	public dangnhap() {
		
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1080,720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(29,128, 397, 400);
		contentPane.add(logo);
		ImageIcon originalIcon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(dangnhap.class.getResource("/img/logo.png")));
		Image scaledImage = originalIcon.getImage().getScaledInstance(397, 400, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		logo.setIcon(scaledIcon);
		
		JLabel lbldangnhap = new JLabel("Đăng nhập");
		lbldangnhap.setHorizontalAlignment(SwingConstants.CENTER);
		lbldangnhap.setFont(new Font("Tahoma", Font.BOLD, 70));
		lbldangnhap.setForeground(new Color(41, 139, 116));
		lbldangnhap.setBounds(493, 149, 500, 76);
		contentPane.add(lbldangnhap);
		
		JLabel lbltendangnhap = new JLabel("Tên đăng nhập:");
		//lbltendangnhap.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH)));
		lbltendangnhap.setForeground(new Color(41, 139, 116));
		lbltendangnhap.setHorizontalAlignment(SwingConstants.LEFT);
		lbltendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbltendangnhap.setBounds(461, 257, 187, 69);
		contentPane.add(lbltendangnhap);
		
		txttendangnhap = new JTextField();
		txttendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txttendangnhap.setBounds(657, 273, 363, 38);
		contentPane.add(txttendangnhap);
		txttendangnhap.setColumns(10);
		
		JLabel lblmatkhau = new JLabel("Mật khẩu:");
		lblmatkhau.setForeground(new Color(41, 139, 116));
		lblmatkhau.setHorizontalAlignment(SwingConstants.LEFT);
		lblmatkhau.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblmatkhau.setBounds(461, 327, 132, 69);
		contentPane.add(lblmatkhau);
		
		txtmatkhau = new JPasswordField();
		txtmatkhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmatkhau.setColumns(10);
		txtmatkhau.setBounds(657, 345, 363, 38);
		contentPane.add(txtmatkhau);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (txttendangnhap.getText().equals(tk) && txtmatkhau.getText().equals(mk)) { 
				// Kiểm tra tài khoản và mật khẩu
				setVisible(false); // Ẩn frame đăng nhập
                new GUI_TrangChu().setVisible(true); // Hiển thị trang chủ
			}
			else {
				
				JOptionPane.showMessageDialog(null,"Sai mật khẩu");;	
			}
			}
			
			
		});
		
		getRootPane().setDefaultButton(btnNewButton);
		
		btnNewButton.setBackground(new Color(41, 139, 116));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(552, 418, 384, 43);
		contentPane.add(btnNewButton);
		
		JButton btnQMK = new JButton("Quên mật khẩu");
		btnQMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQMK.setBackground(new Color(240, 240, 240));
		btnQMK.setForeground(new Color(41, 139, 116));
		btnQMK.setFont(new Font("Tahoma",Font.ITALIC ,20));
		btnQMK.setBorder(null);
		btnQMK.setBounds(657, 482, 177, 31);
		contentPane.add(btnQMK);
		btnQMK.setText("<html><u><i>Quên mật khẩu?</i></u></html>");

        
	}
}
