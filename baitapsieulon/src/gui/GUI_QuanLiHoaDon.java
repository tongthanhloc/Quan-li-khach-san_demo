package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.toedter.calendar.JDateChooser;



public class GUI_QuanLiHoaDon extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel Frame;
    private JPanel panel_Center_Top;
    private JLabel lblMahoaDon;
    private JLabel lblMaNhanVien;
    private JLabel lblNgNhanPhong;
    private JTextField txtMahoaDon;
    private JTextField txtMaNhanVien;
    private JTextField txtNgNhanPhong;
    private JLabel lblKhachHang;
    private JLabel lblNgDatPhong;
    private JLabel lblNgTraPhong;
    private JTextField txtMaKhachHang;
    private JButton btbXoaTrang;
    private JTable table;
	private DefaultTableModel modelHD;
	private JTable tableHD;
	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_QuanLiHoaDon frame = new GUI_QuanLiHoaDon();
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Phóng to cửa sổ JFrame
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
	public GUI_QuanLiHoaDon() {
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
		panel_Center_Top.setBounds(0, 0, 1653, 223);
		Frame.add(panel_Center_Top);
		panel_Center_Top.setLayout(null);
		
		lblMahoaDon = new JLabel("Mã hóa đơn");
		lblMahoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMahoaDon.setBounds(140, 25, 126, 35);
		panel_Center_Top.add(lblMahoaDon);
		
		lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNhanVien.setBounds(140, 75, 126, 35);
		panel_Center_Top.add(lblMaNhanVien);
		
		lblNgNhanPhong = new JLabel("Ngày nhận phòng");
		lblNgNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgNhanPhong.setBounds(140, 125, 186, 35);
		panel_Center_Top.add(lblNgNhanPhong);
		
		txtMahoaDon = new JTextField();
		txtMahoaDon.setBackground(new Color(41, 139, 116));
		txtMahoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMahoaDon.setBounds(350, 25, 350, 40);
		panel_Center_Top.add(txtMahoaDon);
		txtMahoaDon.setColumns(10);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBackground(new Color(41, 139, 116));
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(350, 73, 350, 40);
		panel_Center_Top.add(txtMaNhanVien);
		
		txtNgNhanPhong = new JTextField();
		txtNgNhanPhong.setBackground(new Color(41, 139, 116));
		txtNgNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgNhanPhong.setColumns(10);
		txtNgNhanPhong.setBounds(350, 125, 350, 40);
		panel_Center_Top.add(txtNgNhanPhong);
		
		lblKhachHang = new JLabel("Mã khách hàng");
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKhachHang.setBounds(900, 25, 210, 35);
		panel_Center_Top.add(lblKhachHang);
		
		lblNgDatPhong = new JLabel("Ngày đặt phòng");
		lblNgDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgDatPhong.setBounds(900, 75, 175, 35);
		panel_Center_Top.add(lblNgDatPhong);
		
		lblNgTraPhong = new JLabel("Ngày trả phòng");
		lblNgTraPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgTraPhong.setBounds(900, 125, 198, 35);
		panel_Center_Top.add(lblNgTraPhong);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBackground(new Color(41, 139, 116));
		txtMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(1100, 25, 350, 40);
		panel_Center_Top.add(txtMaKhachHang);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(234, 232, 214));
		btnTim.setBounds(1160, 176, 175, 35);
		panel_Center_Top.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btbXoaTrang = new JButton("Xóa trắng");
		btbXoaTrang.setBackground(new Color(234, 232, 214));
		btbXoaTrang.setBounds(1389, 176, 175, 35);
		panel_Center_Top.add(btbXoaTrang);
		btbXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(1100, 75, 350, 35);
		panel_Center_Top.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(1100, 125, 350, 35);
		panel_Center_Top.add(dateChooser_1);
		
		JPanel panel_Center_Bot = new JPanel();
		panel_Center_Bot.setBackground(new Color(255, 255, 255));
		panel_Center_Bot.setBounds(5, 225, 1648, 576);

		
		String[] cols = new String[] {"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã Khuyến mãi ", "Ngày lập hóa đơn", "Tổng tiền thanh toán" ,"Tiền khách đưa" , "Tiền thối", "Trang thái"};
		modelHD = new DefaultTableModel(cols,0);
		panel_Center_Bot.setLayout(null);
		tableHD = new JTable(modelHD);
		tableHD.setBackground(new Color(128, 255, 0));
		JScrollPane paneNV = new JScrollPane(tableHD);
		paneNV.setBounds(10, 27, 1610, 538);
		paneNV.setPreferredSize(new Dimension(1000,1000));
		panel_Center_Bot.add(paneNV);;
		JTableHeader headers = tableHD.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 15);
        headers.setFont(headerFont);
		Frame.add(panel_Center_Bot);
		
		
		
		
        
		
		
		
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                // Xử lý sự kiện cho mỗi nút ở đây
                }};
	}

	

	
}