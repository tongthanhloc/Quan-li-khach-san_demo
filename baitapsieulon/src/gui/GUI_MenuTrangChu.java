package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class GUI_MenuTrangChu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NhanVien nv;
	
	private ArrayList<NhanVien> ListNV;
	private NhanVien_DAO nv_dao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien nv = new NhanVien("NV0000001");
					GUI_MenuTrangChu frame = new GUI_MenuTrangChu(nv);
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
	public GUI_MenuTrangChu(NhanVien nv) {
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(8, 31, 1904, 150);
		setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		nv_dao = new  NhanVien_DAO();
		ListNV = nv_dao.getalltbNhanVien();
		
		for (NhanVien nhanVien : ListNV) {
			if (nhanVien.getMaNV().equals(nv.getMaNV())) {
				nv = nhanVien;
				break;
			}
		}
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel_top = new Panel();
		panel_top.setLayout(null);
		panel_top.setBackground(Color.LIGHT_GRAY);
		panel_top.setBounds(0, 0, 1904, 150);
		contentPane.add(panel_top);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH)));
		logo.setBounds(0, 0, 250, 150);
		panel_top.add(logo);
		
		
		JButton btnTK = new JButton("<html><div style='text-align: center;'>Trần ngu</div></html>");
		btnTK.setForeground(new Color(244, 244, 244));
		btnTK.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTK.setBackground(new Color(41, 139, 106));
		btnTK.setBounds(1647, 11, 247, 40);
		panel_top.add(btnTK);
		
		btnTK.setText("<html><div style='text-align: center;'>"+nv.getHoTenNV()+"</div></html>");
		
		
		GUI_MenuTK menuTK = new GUI_MenuTK(nv);
		contentPane.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		        // Ẩn btnXTT và btnDX khi click ra ngoài
		        menuTK.setVisible(false);
		        // Hiển thị btnTK
		        btnTK.setVisible(true);
		    }
		});

		ActionListener actionListener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JButton clickedButton = (JButton) e.getSource();
		        boolean isVisible = menuTK.isVisible();
		        if (clickedButton == btnTK && !isVisible) {
		            // Xử lý khi nhấn vào nút btnTK
		            menuTK.setVisible(true);
		        } else if (clickedButton == btnTK && isVisible) {
		            // Xử lý khi nhấn vào nút btnXTT
		            menuTK.setVisible(false);
		        }
		    }
		};

		btnTK.addActionListener(actionListener);
	}
}
