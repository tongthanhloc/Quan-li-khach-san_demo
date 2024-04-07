package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class GUI_ManHinhCho {
    public static void main(String[] args) {
        // Tạo một JFrame
        JFrame frame = new JFrame();
        frame.setSize(564, 781);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setIconImage(new ImageIcon(GUI_ManHinhCho.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 564, 781);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Quản lí khách sạn LLPT");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(0, 68, 564, 68);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("CHAU TIỂU LONG");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(0, 138, 564, 35);
        panel.add(lblNewLabel_1_1);
        
        
        
        JLabel lblNewLabel_1_1_1 = new JLabel("TỐNG THÀNH LỘC");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(0, 178, 564, 35);
        panel.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("NGÔ HỒNG PHƯƠNG");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_2.setBounds(0, 218, 564, 35);
        panel.add(lblNewLabel_1_1_2);
        
        JLabel lblNewLabel_1_1_3 = new JLabel("NGUYỄN NHẬT TÙNG");
        lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_3.setBounds(0, 258, 564, 35);
        panel.add(lblNewLabel_1_1_3);
        
        
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/logoiuh.png")).getImage().getScaledInstance(76, 76, java.awt.Image.SCALE_SMOOTH)));
        lblNewLabel_2.setBounds(0, 0, 76, 76);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(76, 60, java.awt.Image.SCALE_SMOOTH)));
        lblNewLabel_2_1.setBounds(488, 0, 76, 76);
        panel.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(GUI_ManHinhCho.class.getResource("/img/manhinhcho.jpg")));
        lblNewLabel.setBounds(0, 0, 564, 781);
        panel.add(lblNewLabel);
        
        

        // Sử dụng javax.swing.Timer để lên lịch cho việc hiển thị cửa sổ sau 1 phút
        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị cửa sổ khi thời gian đã đến
                frame.dispose();
                new dangnhap().setVisible(true);
            }
        });
        timer.setRepeats(false); // Không lặp lại

        // Bắt đầu đếm thời gian
        timer.start();

        // Hiển thị JFrame
        frame.setVisible(true);
    }

	private static void setIconImage(Image scaledInstance) {
		// TODO Auto-generated method stub
		
	}
}