package gui;

import java.awt.Color;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import connectDB.ConnectDB;
import dao.DAO_PhieuDatDichVu;
import dao.KhachHang_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatDichVu;
import entity.PhieuDatPhong;
import entity.Phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
public class GUI_ChiTietPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Object BgpTop;
	private JTextField txtMaPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtSoTang;
	private JTextField txtDonGia;
	private JTextField textField_4;
	private TitledBorder titledBorder;
	private JTextField txtMaKhachHang;
	private JTextField txtTuoi;
	private JTextField txtHoTen;
	private JTextField txtSdt;
	private JTextField txtGioiTInh;
	private JTextField txtNgayNhanPhong;
	private JTextField txtNgayTraPhong;
	private JTextField txtSoNguoiO;
	private String maphongcustom;
	private Phong_DAO phong;
	private Phong ph;
	private PhieuDatPhong pdp;
	private KhachHang kh;
	private JLabel lblAnh;
	private DAO_PhieuDatDichVu pddv;
	private JComboBox cbDichVu;
	private static GUI_ChiTietPhong currentInstance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ChiTietPhong frame = new GUI_ChiTietPhong("Mã phòng custom");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param maphongcustom 
	 */
	public GUI_ChiTietPhong(String maphongcustom) {
		// kết nối dao
		NhanVien nv = GUI_QuanLiDatPhong.nhanvien;
		this.maphongcustom = maphongcustom;
		try {
			ConnectDB.getInstance().connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		phong = new Phong_DAO();
	    ph  = phong.getPhongTheoMaPhong(maphongcustom);
	    pddv = new DAO_PhieuDatDichVu();
	    


		
		
		
//		pdp.setKhachHang(kh);
//		pdp.setPhong(ph);
		setTitle("phòng");
        
		setBounds(100, 100, 1021, 654);
        // Ngăn người dùng chỉnh sửa kích thước của cửa sổ
        setResizable(false);
        //set giua man hinh
        setLocationRelativeTo(null);
        

        // Khi đóng cửa sổ, chương trình sẽ thoát
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pTop = new JPanel();
		pTop.setBounds(0, 0, 1012, 51);
		contentPane.add(pTop);
		
		JLabel lblTenPhong = new JLabel("TenPhong");
		lblTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 29));
		pTop.add(lblTenPhong);
//		BgpTop =  new Color(0, 153, 255);
//		pTop.setBackground(new Color(5, 207, 251));
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(234, 232, 214));
		pCenter.setBounds(0, 47, 1012, 357);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		
		JPanel pBot = new JPanel();
		pBot.setBackground(new Color(234, 232, 214));
		pBot.setBounds(0, 403, 1012, 212);
		contentPane.add(pBot);
		pBot.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã phòng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(21, 27, 97, 33);
		pCenter.add(lblNewLabel);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setEditable(false);
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaPhong.setBounds(141, 26, 140, 34);
		pCenter.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		txtMaPhong.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblLoiphong = new JLabel("Loại phòng:");
		lblLoiphong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoiphong.setBounds(304, 28, 97, 33);
		pCenter.add(lblLoiphong);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(454, 26, 140, 34);
		pCenter.add(txtLoaiPhong);
		txtLoaiPhong.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSTng = new JLabel("Số tầng:");
		lblSTng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTng.setBounds(21, 72, 97, 33);
		pCenter.add(lblSTng);
		
		txtSoTang = new JTextField();
		txtSoTang.setEditable(false);
		txtSoTang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoTang.setColumns(10);
		txtSoTang.setBounds(141, 71, 140, 34);
		pCenter.add(txtSoTang);
		txtSoTang.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPhongCch = new JLabel("Đơn giá theo ngày:");
		lblPhongCch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhongCch.setBounds(304, 72, 140, 33);
		pCenter.add(lblPhongCch);
		
		txtDonGia = new JTextField();
		txtDonGia.setEditable(false);
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(454, 71, 140, 34);
		pCenter.add(txtDonGia);
		txtDonGia.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pAnh = new JPanel();
		pAnh.setBounds(604, 27, 385, 304);
		pCenter.add(pAnh);
		
		JLabel lblSTng_1 = new JLabel("Phong Cách:");
		lblSTng_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTng_1.setBounds(21, 116, 97, 32);
		pCenter.add(lblSTng_1);
		
		JTextArea txtPhongCach = new JTextArea();
		txtPhongCach.setEditable(false);
		txtPhongCach.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtPhongCach.setLineWrap(true); // Thiết lập tự động xuống hàng
        txtPhongCach.setWrapStyleWord(true); // Thiết lập tự động xuống hàng
        txtPhongCach.setBounds(141, 115, 453, 30);
        pCenter.add(txtPhongCach);
        
        JTextArea txtMota = new JTextArea();
        txtMota.setEditable(false);
        txtMota.setWrapStyleWord(true);
        txtMota.setLineWrap(true);
        txtMota.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtMota.setBounds(141, 151, 453, 140);
        pCenter.add(txtMota);
        // tooi muon txtMota hụt đầu dòng khi setText và căn đều
        txtMota.setMargin(new java.awt.Insets(5, 5, 5, 5));
        // thêm thanh trượt xuống cho txtMota
        JScrollPane scrollPane = new JScrollPane(txtMota);
        scrollPane.setBounds(141, 151, 453, 140);
        pCenter.add(scrollPane);
        
        
        
        JLabel lblSTng_1_1 = new JLabel("Mô tả");
        lblSTng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSTng_1_1.setBounds(21, 151, 97, 33);
        pCenter.add(lblSTng_1_1);
      
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Phòng");
        
        // Đặt font mới cho TitledBorder
        titledBorder.setTitleFont(new Font("Tahoma", Font.BOLD, 20));
        
        // Đặt TitledBorder cho panel
        pCenter.setBorder(titledBorder);
        
        lblSTng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSTng_1_1.setBounds(21, 191, 97, 33);
        pCenter.add(lblSTng_1_1);
        
        JLabel lblSTng_1_1_1 = new JLabel("Trạng thái");
        lblSTng_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSTng_1_1_1.setBounds(21, 298, 97, 33);
        pCenter.add(lblSTng_1_1_1);
        
        JButton btnNhan = new JButton("Đã nhận");
        btnNhan.setBackground(new Color(242, 128, 116));
        btnNhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNhan.setBounds(260, 297, 97, 41);
        pCenter.add(btnNhan);
        
        JButton btnDat = new JButton("Đã đặt");
        btnDat.setBackground(new Color(34, 242, 93));
        btnDat.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDat.setBounds(141, 297, 97, 41);
        pCenter.add(btnDat);
        
        JButton btnBaoTri = new JButton("Bảo trì");
        btnBaoTri.setBackground(new Color(251, 193, 146));
        btnBaoTri.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBaoTri.setBounds(497, 297, 97, 41);
        
        pCenter.add(btnBaoTri);
        
        JButton btnTrong = new JButton("Trống");
        btnTrong.setBackground(new Color(5, 207, 251));
        btnTrong.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnTrong.setBounds(379, 297, 97, 41);
		btnTrong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// nếu là trạng thái phòng là bảo trì thì set lại trạng thái phòng trống
				if (ph.getTrangThai().equals("Bảo trì")) {
					pTop.setBackground(new Color(5, 207, 251));
					ph = new Phong_DAO().getPhongTheoMaPhong(maphongcustom);
					new Phong_DAO().updateTrangThaiPhong(maphongcustom, "Trống");
					// Đóng cửa sổ hiện tại
					new GUI_QuanLiDatPhong(nv).setVisible(false);
					// Mở GUI_QuanLiDatPhong mới
					new GUI_QuanLiDatPhong(nv).setVisible(true);
					// TÔI MUỐN LOADE LẠI GUI_CHITIETPHONG1
					closeCurrentInstance();
					new GUI_ChiTietPhong(maphongcustom).setVisible(true);
				}
				else JOptionPane.showMessageDialog(null, "Phòng không ở trạng thái bảo trì", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnBaoTri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// nếu là trạng thái phòng là trống thì set lại trạng thái phòng bảo trì
				if (ph.getTrangThai().equals("Trống")) {
					pTop.setBackground(new Color(251, 193, 146));
					ph = new Phong_DAO().getPhongTheoMaPhong(maphongcustom);
					new Phong_DAO().updateTrangThaiPhong(maphongcustom, "Bảo trì");
					// Đóng cửa sổ hiện tại
					new GUI_QuanLiDatPhong(nv).setVisible(false);
					// Mở GUI_QuanLiDatPhong mới
					new GUI_QuanLiDatPhong(nv).setVisible(true);
					// TÔI MUỐN LOADE LẠI GUI_CHITIETPHONG1
					closeCurrentInstance();
					new GUI_ChiTietPhong(maphongcustom).setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "Phòng không ở trạng thái trống", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
        pCenter.add(btnTrong);
      
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Khách hàng");
        
        // Đặt font mới cho TitledBorder
        titledBorder1.setTitleFont(new Font("Tahoma", Font.BOLD, 20));
        
        // Đặt TitledBorder cho panel
        pBot.setBorder(titledBorder1);
        
        JLabel lblMKhchHng = new JLabel("Mã khách hàng:");
        lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMKhchHng.setBounds(10, 23, 121, 33);
        pBot.add(lblMKhchHng);
        
        txtMaKhachHang = new JTextField();
        txtMaKhachHang.setEditable(false);
        txtMaKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        txtMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtMaKhachHang.setColumns(10);
        txtMaKhachHang.setBounds(141, 22, 303, 34);
        pBot.add(txtMaKhachHang);
        
        JLabel lblTui = new JLabel("Tuổi:");
        lblTui.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTui.setBounds(10, 113, 121, 33);
        pBot.add(lblTui);
        
        txtTuoi = new JTextField();
        txtTuoi.setEditable(false);
        txtTuoi.setHorizontalAlignment(SwingConstants.CENTER);
        txtTuoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtTuoi.setColumns(10);
        txtTuoi.setBounds(141, 112, 121, 34);
        pBot.add(txtTuoi);
        
        JLabel lblHVTn = new JLabel("Họ và tên:");
        lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHVTn.setBounds(10, 69, 121, 33);
        pBot.add(lblHVTn);
        
        txtHoTen = new JTextField();
        txtHoTen.setEditable(false);
        txtHoTen.setHorizontalAlignment(SwingConstants.CENTER);
        txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtHoTen.setColumns(10);
        txtHoTen.setBounds(141, 67, 303, 34);
        pBot.add(txtHoTen);
        
        JLabel lblSin = new JLabel("Số điên thoại:");
        lblSin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSin.setBounds(10, 157, 121, 33);
        pBot.add(lblSin);
        
        txtSdt = new JTextField();
        txtSdt.setEditable(false);
        txtSdt.setHorizontalAlignment(SwingConstants.CENTER);
        txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtSdt.setColumns(10);
        txtSdt.setBounds(141, 156, 303, 34);
        pBot.add(txtSdt);
        
        JLabel lblGiiTnh = new JLabel("Giới tính:");
        lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGiiTnh.setBounds(272, 113, 121, 33);
        pBot.add(lblGiiTnh);
        
        txtGioiTInh = new JTextField();
        txtGioiTInh.setEditable(false);
        txtGioiTInh.setHorizontalAlignment(SwingConstants.CENTER);
        txtGioiTInh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtGioiTInh.setColumns(10);
        txtGioiTInh.setBounds(352, 112, 92, 34);
        pBot.add(txtGioiTInh);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.setBounds(508, 11, 1, 190);
        pBot.add(panel);
        
        JLabel lblNgyNhnPhng = new JLabel("Ngày nhận phòng:");
        lblNgyNhnPhng.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNgyNhnPhng.setBounds(519, 23, 139, 33);
        pBot.add(lblNgyNhnPhng);
        
        txtNgayNhanPhong = new JTextField();
        txtNgayNhanPhong.setEditable(false);
        txtNgayNhanPhong.setHorizontalAlignment(SwingConstants.CENTER);
        txtNgayNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtNgayNhanPhong.setColumns(10);
        txtNgayNhanPhong.setBounds(662, 23, 303, 34);
        pBot.add(txtNgayNhanPhong);
        
        JLabel lblMKhchHng_1_1 = new JLabel("Ngày trả phòng:");
        lblMKhchHng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMKhchHng_1_1.setBounds(519, 69, 121, 33);
        pBot.add(lblMKhchHng_1_1);
        
        txtNgayTraPhong = new JTextField();
        txtNgayTraPhong.setEditable(false);
        txtNgayTraPhong.setHorizontalAlignment(SwingConstants.CENTER);
        txtNgayTraPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtNgayTraPhong.setColumns(10);
        txtNgayTraPhong.setBounds(662, 69, 303, 34);
        pBot.add(txtNgayTraPhong);
        
        JLabel lblMKhchHng_1_1_1 = new JLabel("Số người ở:");
        lblMKhchHng_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMKhchHng_1_1_1.setBounds(519, 113, 121, 33);
        pBot.add(lblMKhchHng_1_1_1);
        
        txtSoNguoiO = new JTextField();
        txtSoNguoiO.setEditable(false);
        txtSoNguoiO.setHorizontalAlignment(SwingConstants.CENTER);
        txtSoNguoiO.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtSoNguoiO.setColumns(10);
        txtSoNguoiO.setBounds(662, 112, 303, 34);
        pBot.add(txtSoNguoiO);
        
        JLabel lblMKhchHng_1_1_1_1 = new JLabel("Dịch vụ:");
        lblMKhchHng_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMKhchHng_1_1_1_1.setBounds(519, 157, 121, 33);
        pBot.add(lblMKhchHng_1_1_1_1);
        
        cbDichVu = new JComboBox();
        cbDichVu.setBounds(662, 156, 303, 34);
        pBot.add(cbDichVu);
        cbDichVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        
        // set tấc cả txt về màu xám
        txtMaKhachHang.setBackground(new Color(217, 217, 217));
        txtTuoi.setBackground(new Color(217, 217, 217));
        txtHoTen.setBackground(new Color(217, 217, 217));
        txtSdt.setBackground(new Color(217, 217, 217));
        txtGioiTInh.setBackground(new Color(217, 217, 217));
        txtNgayNhanPhong.setBackground(new Color(217, 217, 217));
        txtNgayTraPhong.setBackground(new Color(217, 217, 217));
        txtSoNguoiO.setBackground(new Color(217, 217, 217));
        txtMaPhong.setBackground(new Color(217, 217, 217));
        txtLoaiPhong.setBackground(new Color(217, 217, 217));
        txtSoTang.setBackground(new Color(217, 217, 217));
        txtDonGia.setBackground(new Color(217, 217, 217));
        txtPhongCach.setBackground(new Color(217, 217, 217));
        txtMota.setBackground(new Color(217, 217, 217));
        // set tất cả txt border 1 có bóng
        txtMaKhachHang.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtTuoi.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtHoTen.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtSdt.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtGioiTInh.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtNgayNhanPhong.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtNgayTraPhong.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtSoNguoiO.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtMaPhong.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtLoaiPhong.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtSoTang.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtDonGia.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        txtPhongCach.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        //txtPhongCach chữ căn giữa do nó là kiễu textArea
        txtPhongCach.setAlignmentX(CENTER_ALIGNMENT);
        txtMota.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        // tôi muốn txtmota phải hụt vào trong 5px cả 4 phía và căn đều
  
        
        
        
        
        
        Phong_DAO phong_DAO = new Phong_DAO();
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        
       
      
        
        // Sử dụng maphongcustom ở đây
        lblTenPhong.setText(maphongcustom);
        txtMaPhong.setText(maphongcustom);
        int donGia = 0;
        txtPhongCach.setText(ph.getPhongCach());
        txtMota.setText(ph.getMoTa());
		if (maphongcustom.charAt(0) == 'A') {
			txtLoaiPhong.setText("Phòng đơn");
			donGia= 1500000;
	        DecimalFormat formatter = new DecimalFormat("#,###");
	        String formattedDonGia = formatter.format(donGia);
	        txtDonGia.setText(formattedDonGia);
	       
	        
	        
		}
		if (maphongcustom.charAt(0) == 'B') {
			txtLoaiPhong.setText("Phòng đôi");
			donGia= 2500000;
	        DecimalFormat formatter = new DecimalFormat("#,###");
	        String formattedDonGia = formatter.format(donGia);
	        txtDonGia.setText(formattedDonGia);
			
			
		}
		if (maphongcustom.charAt(0) == 'C') {
			txtLoaiPhong.setText("Phòng VIP");
			donGia= 4500000;
	        DecimalFormat formatter = new DecimalFormat("#,###");
	        String formattedDonGia = formatter.format(donGia);
	        txtDonGia.setText(formattedDonGia);
		}
		// Lấy ra phần giữa của mã phòng
        String soTang = maphongcustom.substring(1, 3);
        txtSoTang.setText(soTang);
		if (ph.getTrangThai().equals("Trống")) {
			pTop.setBackground(new Color(5, 207, 251));
		}
		if (ph.getTrangThai().equals("Đã thuê")) {
			pTop.setBackground(new Color(242, 128, 116));
		}
		if (ph.getTrangThai().equals("Đã đặt")) {
			pTop.setBackground(new Color(34, 242, 93));
		}
		if (ph.getTrangThai().equals("Bảo trì")) {
			pTop.setBackground(new Color(251, 193, 146));
		}
		setThongtin();

		byte[] imageData = ph.getHinhAnh();
		 // Tạo hình ảnh từ mảng byte
       ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
       Image image = null;
		try {
			image = ImageIO.read(bis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // Chỉnh kích thước hình ảnh nếu cần thiết
       Image scaledImage = image.getScaledInstance(385, 304, Image.SCALE_SMOOTH);
       // Tạo một lớp JPanel tạm thời để vẽ hình ảnh
       
       lblAnh = new JLabel(new ImageIcon(scaledImage));
       // Đặt kích thước cho JPanel chứa hình ảnh

       // Thêm JPanel chứa hình ảnh vào JPanel chính
       
       // để hình ảnh full panel
       	lblAnh.setBounds(0, 0, 385, 304);
       	// set boder cho pAnh

       	pAnh.add(lblAnh);
       	// txtPhongCach set cho chữ căn giữa vì nó là kiểu textArea
       	txtPhongCach.setAlignmentX(CENTER_ALIGNMENT);
        
		  currentInstance = this;
	}
	public static void closeCurrentInstance() {
        if (currentInstance != null) {
            currentInstance.dispose();
            currentInstance = null;
        }
    }
	 public void setThongtin() {
		 // set trạng thái của phòng nếu đã thuê và đẵ đặt thì set txt
			if (ph.getTrangThai().equals("Đã thuê") || ph.getTrangThai().equals("Đã đặt")) {
				pdp = new PhieuDatPhong_DAO().getPhieuDatPhongTheoMaPhong(maphongcustom);
				String ma = pdp.getKhachHang().getmaKH();
		        kh = new KhachHang_DAO().getKhachHangByMaKhachHang(ma);
				txtMaKhachHang.setText(kh.getmaKH());
				txtHoTen.setText(kh.getHoTen());
				// tuổi = năm hiện tại - năm sinh
				int tuoi = 2021 - kh.getNgaySinh().getYear();
				txtTuoi.setText(String.valueOf(tuoi));
				txtSdt.setText(kh.getSoDT());
				txtGioiTInh.setText(kh.getGioiTinh() == true ? "Nam" : "Nữ");
				txtNgayNhanPhong.setText(pdp.getThoiGianNhan().toString());
				txtNgayTraPhong.setText(pdp.getThoiGianTra().toString());
				txtSoNguoiO.setText(pdp.getSoNguoi());
				List<PhieuDatDichVu> dsDichVu = pddv.getDSPhieuDatChuaThanhToan(kh.getmaKH());
				for (PhieuDatDichVu dv : dsDichVu) {
					cbDichVu.addItem(dv.getDichVu().getMaDichVu());
				}
				
			}
	 }
	

}
