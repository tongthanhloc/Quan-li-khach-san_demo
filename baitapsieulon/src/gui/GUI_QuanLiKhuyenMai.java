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
import com.toedter.calendar.JDateChooser;

public class GUI_QuanLiKhuyenMai extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Frame;
	private JPanel panel_Center_Top;
	private JLabel lblMa;
	private JLabel lblThoiGianBD;
	private JTextField txtMaKM;
	private JLabel lblTenKM;
	private JLabel lblThoiGianKT;
	private JTextField txtTenKM;
	private JButton btbXoaTrang;
	private DefaultTableModel modelHD;
	private JTable tableNV;
	private JTextField txtPTKM;
	private JPanel panel;
	private JLabel lblMKhuynMi;
	private JTextField txtTimMa;
	private JLabel lblTenKM_Tim;
	private JTextField txtTenKM_Tim;
	private JButton btn_Tim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLiKhuyenMai frame = new GUI_QuanLiKhuyenMai();
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
	public GUI_QuanLiKhuyenMai() {
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
		
		lblMa = new JLabel("Mã khuyến mãi");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(140, 25, 200, 35);
		panel_Center_Top.add(lblMa);
		
		lblThoiGianBD = new JLabel("Thời gian bắt đầu");
		lblThoiGianBD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThoiGianBD.setBounds(140, 75, 186, 35);
		panel_Center_Top.add(lblThoiGianBD);
		
		txtMaKM = new JTextField();
		txtMaKM.setBackground(new Color(41, 139, 116));
		txtMaKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKM.setColumns(10);
		txtMaKM.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMaKM);
		
		lblTenKM = new JLabel("Tên khuyến mãi");
		lblTenKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKM.setBounds(900, 25, 210, 35);
		panel_Center_Top.add(lblTenKM);
		
		lblThoiGianKT = new JLabel("Thời gian kết thúc");
		lblThoiGianKT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThoiGianKT.setBounds(900, 75, 175, 35);
		panel_Center_Top.add(lblThoiGianKT);
		
		txtTenKM = new JTextField();
		txtTenKM.setBackground(new Color(41, 139, 116));
		txtTenKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKM.setColumns(10);
		txtTenKM.setBounds(1100, 25, 350, 40);
		panel_Center_Top.add(txtTenKM);
		
		btbXoaTrang = new JButton("Xóa trắng");
		btbXoaTrang.setBackground(new Color(234, 232, 214));
		btbXoaTrang.setBounds(1438, 176, 158, 35);
		panel_Center_Top.add(btbXoaTrang);
		btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPTKM = new JLabel("Phần trăm khuyến mãi");
		lblPTKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPTKM.setBounds(140, 125, 246, 35);
		panel_Center_Top.add(lblPTKM);
		
		txtPTKM = new JTextField();
		txtPTKM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPTKM.setColumns(10);
		txtPTKM.setBackground(new Color(41, 139, 116));
		txtPTKM.setBounds(350, 123, 350, 40);
		panel_Center_Top.add(txtPTKM);
		
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBackground(new Color(41, 139, 116));
		dateChooser.setBounds(350, 75, 350, 35);
		panel_Center_Top.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBackground(new Color(41, 139, 116));
		dateChooser_1.setBounds(1100, 75, 350, 35);
		panel_Center_Top.add(dateChooser_1);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(18, 234, 1648, 513);

		
		String[] cols = new String[] {"Mã nhân viên", "Họ tên", "Giới tính" , "Số căn cước công dân", "Vị trí", "Số điện thoại", "Địa chỉ", "Ngày sinh", "Ngày vào làm", "Ngày nghỉ làm", "Trạng thái", "Trình độ học vấn", "Hệ số lương", "Lương cơ bản", "Tổng lương"};
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
		
		lblMKhuynMi = new JLabel("Mã khuyến mãi");
		lblMKhuynMi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMKhuynMi.setBounds(45, 45, 246, 35);
		panel.add(lblMKhuynMi);
		
		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimMa.setColumns(10);
		txtTimMa.setBackground(new Color(55, 149, 128));
		txtTimMa.setBounds(205, 45, 350, 40);
		panel.add(txtTimMa);
		
		lblTenKM_Tim = new JLabel("Tên khuyến mãi");
		lblTenKM_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKM_Tim.setBounds(700, 45, 210, 35);
		panel.add(lblTenKM_Tim);
		
		txtTenKM_Tim = new JTextField();
		txtTenKM_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKM_Tim.setColumns(10);
		txtTenKM_Tim.setBackground(new Color(55, 149, 128));
		txtTenKM_Tim.setBounds(900, 41, 350, 40);
		panel.add(txtTenKM_Tim);
		
		btn_Tim = new JButton("Tìm");
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Tim.setBounds(1280, 45, 175, 35);
		panel.add(btn_Tim);
		
		
		
		
        
		
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                }};
	}

	
}