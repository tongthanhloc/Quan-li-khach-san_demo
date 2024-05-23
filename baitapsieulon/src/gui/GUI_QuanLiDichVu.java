package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.NhanVien;

public class GUI_QuanLiDichVu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Frame;
	private JPanel panel_Center_Top;
	private JLabel lblMa;
	private JLabel lblThueVat;
	private JTextField txtMaDV;
	private JTextField txtThueVat;
	private JLabel lblTen;
	private JLabel lblGiaNhap;
	private JTextField txtTenDV;
	private JTextField txtGiaNhao;
	private JButton btbXoaTrang;
	private DefaultTableModel modelHD;
	private JTable tableNV;
	private JPanel panel;
	private JLabel lblMaDichVu_Tim;
	private JTextField txtTimMa;
	private JLabel lblTenDichVu_Tim;
	private JTextField txtTenDichVu_Tim;
	private JButton btn_Tim;
	private JLabel lblSoLuong;
	private JTextField txtSoLuong;
	private JLabel lblGiaBan;
	private JTextField txtGiaBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien nv = new NhanVien("QL0000010");
					GUI_QuanLiDichVu frame = new GUI_QuanLiDichVu(nv);
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
	public GUI_QuanLiDichVu(NhanVien nv) {
		setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(258,181,1654, 859);
		setResizable(false);
		setUndecorated(true);
		
		Frame = new JPanel();
		Frame.setBackground(new Color(255, 255, 255));
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		panel_Center_Top = new JPanel();
		panel_Center_Top.setBackground(new Color(255, 255, 255));
		panel_Center_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Center_Top.setBounds(0, 0, 1666, 223);
		Frame.add(panel_Center_Top);
		panel_Center_Top.setLayout(null);
		
		lblMa = new JLabel("Mã dịch vụ");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(140, 25, 200, 35);
		panel_Center_Top.add(lblMa);
		
		lblThueVat = new JLabel("Thuế vặt");
		lblThueVat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThueVat.setBounds(140, 75, 186, 35);
		panel_Center_Top.add(lblThueVat);
		
		txtMaDV = new JTextField();
		txtMaDV.setBackground(new Color(41, 139, 116));
		txtMaDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaDV.setColumns(10);
		txtMaDV.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMaDV);
		
		txtThueVat = new JTextField();
		txtThueVat.setBackground(new Color(41, 139, 116));
		txtThueVat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThueVat.setColumns(10);
		txtThueVat.setBounds(350, 75, 350, 40);
		panel_Center_Top.add(txtThueVat);
		
		lblTen = new JLabel("Tên dịch vụ");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(900, 25, 210, 35);
		panel_Center_Top.add(lblTen);
		
		lblGiaNhap = new JLabel("Gía nhập");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaNhap.setBounds(900, 75, 175, 35);
		panel_Center_Top.add(lblGiaNhap);
		
		txtTenDV = new JTextField();
		txtTenDV.setBackground(new Color(41, 139, 116));
		txtTenDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenDV.setColumns(10);
		txtTenDV.setBounds(1100, 25, 350, 40);
		panel_Center_Top.add(txtTenDV);
		
		txtGiaNhao = new JTextField();
		txtGiaNhao.setBackground(new Color(41, 139, 116));
		txtGiaNhao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaNhao.setColumns(10);
		txtGiaNhao.setBounds(1100, 75, 350, 40);
		panel_Center_Top.add(txtGiaNhao);
		
		btbXoaTrang = new JButton("Xóa trắng");
		btbXoaTrang.setBackground(new Color(234, 232, 214));
		btbXoaTrang.setBounds(1438, 176, 158, 35);
		panel_Center_Top.add(btbXoaTrang);
		btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btn_Sua = new JButton("Sửa");
		btn_Sua.setBackground(new Color(234, 232, 214));
		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Sua.setBounds(1229, 176, 175, 35);
		panel_Center_Top.add(btn_Sua);
		
		JButton btn_Xoa = new JButton("Xóa");
		btn_Xoa.setBackground(new Color(234, 232, 214));
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Xoa.setBounds(1021, 176, 175, 35);
		panel_Center_Top.add(btn_Xoa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(234, 232, 214));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBounds(822, 176, 175, 35);
		panel_Center_Top.add(btnThem);
		
		lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoLuong.setBounds(140, 125, 186, 35);
		panel_Center_Top.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBackground(new Color(41, 139, 116));
		txtSoLuong.setBounds(350, 125, 350, 40);
		panel_Center_Top.add(txtSoLuong);
		
		lblGiaBan = new JLabel("Gía bán");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaBan.setBounds(900, 125, 175, 35);
		panel_Center_Top.add(lblGiaBan);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaBan.setColumns(10);
		txtGiaBan.setBackground(new Color(41, 139, 116));
		txtGiaBan.setBounds(1100, 125, 350, 40);
		panel_Center_Top.add(txtGiaBan);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(18, 234, 1648, 513);

		
		String[] cols = new String[] {"Mã dịch vụ", "Tên dịch vụ", "Thuế vặt",  "Số lượng", "Gía nhập", "Gía bán"};
		modelHD = new DefaultTableModel(cols,0);
		panel_Center_Bot.setLayout(null);
		tableNV = new JTable(modelHD);
		tableNV.setBackground(new Color(128, 255, 0));
		JScrollPane paneNV = new JScrollPane(tableNV);
		paneNV.setBounds(10, 11, 1610, 491);
		paneNV.setPreferredSize(new Dimension(1000,1000));
		panel_Center_Bot.add(paneNV);;
		JTableHeader headers = tableNV.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 15);
        headers.setFont(headerFont);
		Frame.add(panel_Center_Bot);
		
		panel = new JPanel();
		panel.setBounds(28, 721, 1638, 108);
		Frame.add(panel);
		panel.setLayout(null);
		
		lblMaDichVu_Tim = new JLabel("Mã dịch vụ");
		lblMaDichVu_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaDichVu_Tim.setBounds(45, 45, 246, 35);
		panel.add(lblMaDichVu_Tim);
		
		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimMa.setColumns(10);
		txtTimMa.setBackground(new Color(55, 149, 128));
		txtTimMa.setBounds(205, 45, 350, 40);
		panel.add(txtTimMa);
		
		lblTenDichVu_Tim = new JLabel("Tên dịch vụ");
		lblTenDichVu_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenDichVu_Tim.setBounds(700, 45, 210, 35);
		panel.add(lblTenDichVu_Tim);
		
		txtTenDichVu_Tim = new JTextField();
		txtTenDichVu_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenDichVu_Tim.setColumns(10);
		txtTenDichVu_Tim.setBackground(new Color(55, 149, 128));
		txtTenDichVu_Tim.setBounds(900, 41, 350, 40);
		panel.add(txtTenDichVu_Tim);
		
		btn_Tim = new JButton("Tìm");
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Tim.setBounds(1367, 45, 175, 35);
		panel.add(btn_Tim);
		
		
		
		
        
		
		
		
	}

	

	
}
