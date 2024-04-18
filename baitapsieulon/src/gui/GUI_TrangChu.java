package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


public class GUI_TrangChu extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TrangChu frame = new GUI_TrangChu();
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
	public GUI_TrangChu() {
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/hinhnentrangchu.png")).getImage().getScaledInstance(1654, 859, java.awt.Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(0, 0, 1654, 859);
		Frame.add(lblNewLabel_1);
		
		
		
		
		
		//Sự kiện coi menu tài khoản
//		btnTK.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Hiển thị btnXTT và btnDX
//                btnXTT.setVisible(true);
//                btnDX.setVisible(true);
//            }
//        });
		
		// Thêm sự kiện cho tất cả các nút
        
		
		
		
	}

	

	
}
