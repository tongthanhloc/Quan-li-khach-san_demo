package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.DAO_DichVu;
import dao.DAO_HoaDon;
import dao.DAO_PhieuDatDichVu;
import dao.KhachHang_DAO;
import dao.PhieuDatPhong_DAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;

import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.PhieuDatDichVu;
import entity.PhieuDatPhong;

public class GUI_ChiTietHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Object BgpTop;
	private JTextField textField_4;
	private TitledBorder titledBorder;
	private Border border;
	private MatteBorder borderBottom;
	private String[] cols1;
	private JLabel lblTen;
	private JLabel lblDC;
	private JLabel lblSDT;
	private JLabel lblPhong;
	private JLabel lblNgayDen;
	private JLabel lblNgayDi;
	private JLabel lblSoDem;
	private JLabel lblThuNgan;
	private JLabel lblThanhToan;
	private ArrayList<PhieuDatPhong> dsPDP;
	private DefaultTableModel modelPhong;
	private ArrayList<PhieuDatDichVu> dsPDV;
	private DefaultTableModel modelDichVu;
	private JLabel lblTongTien;
	private JLabel lblThueVAT;
	private JLabel lblTong;
	private JLabel lblkhuyenMai;
	private JLabel lblMaHoaDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUI_ChiTietHoaDon frame = new GUI_ChiTietHoaDon(new ArrayList<PhieuDatPhong>(), new ArrayList<PhieuDatDichVu>());
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
	public GUI_ChiTietHoaDon(ArrayList<PhieuDatPhong> dsPDP, ArrayList<PhieuDatDichVu> dsPDV) {
		this.dsPDP = dsPDP;
		this.dsPDV = dsPDV;
		
		setTitle("phòng");
        setLocationRelativeTo(null);

        // Ngăn người dùng chỉnh sửa kích thước của cửa sổ
        setResizable(false);

        // muốn chương trinh khi chạy nằm ở giữa màn hình
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 0, 1021, 1034);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pTop = new JPanel();
		pTop.setBackground(new Color(255, 255, 255));
		pTop.setBounds(0, 0, 1010, 100);
		contentPane.add(pTop);
		pTop.setLayout(null);
		border = BorderFactory.createLineBorder(Color.BLACK);
	        
		pTop.setBorder(border);
		
		JLabel lblTieuDe = new JLabel("Hóa đơn thanh toán đặt phòng");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(230, 0, 500, 50);
		pTop.add(lblTieuDe);
		
		JLabel lblTGXP = new JLabel("Chủ nhật, 28/4/2024");
		lblTGXP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTGXP.setBounds(10, 70, 220, 25);
		pTop.add(lblTGXP);
		
		lblMaHoaDon = new JLabel("280424PA0104001");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaHoaDon.setBounds(828, 43, 243, 25);
		pTop.add(lblMaHoaDon);
		
		JLabel lblTGXP_1_1 = new JLabel("Mã hóa đơn:");
		lblTGXP_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTGXP_1_1.setBounds(727, 44, 105, 25);
		pTop.add(lblTGXP_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã số thuế:");
		lblNewLabel_2.setBounds(728, 71, 108, 22);
		pTop.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblMaSoThue = new JLabel("");
		lblMaSoThue.setBounds(827, 71, 172, 22);
		pTop.add(lblMaSoThue);
		lblMaSoThue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(255, 255, 255));
		pCenter.setBounds(0, 99, 1010, 163);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		pCenter.setBorder(border);
		
		JLabel lblNewLabel = new JLabel("Tên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(72, 5, 108, 22);
		pCenter.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(72, 35, 108, 22);
		pCenter.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Điện thoại:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(72, 95, 108, 22);
		pCenter.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phòng: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(72, 125, 108, 22);
		pCenter.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Thanh toán:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(653, 125, 108, 22);
		pCenter.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thu ngân:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(653, 95, 108, 22);
		pCenter.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số đêm:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(653, 65, 108, 22);
		pCenter.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày đi:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(653, 35, 108, 22);
		pCenter.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày đến:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(653, 5, 108, 22);
		pCenter.add(lblNewLabel_5);
		
		lblTen = new JLabel("");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTen.setBounds(179, 5, 405, 22);
		pCenter.add(lblTen);
		
		lblDC = new JLabel("");
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDC.setBounds(179, 35, 462, 48);
		pCenter.add(lblDC);
		
		lblSDT = new JLabel("");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSDT.setBounds(179, 95, 405, 22);
		pCenter.add(lblSDT);
		
		lblPhong = new JLabel("");
		lblPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhong.setBounds(179, 125, 405, 22);
		pCenter.add(lblPhong);
		
		lblNgayDen = new JLabel("");
		lblNgayDen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgayDen.setBounds(756, 5, 195, 22);
		pCenter.add(lblNgayDen);
		
		lblNgayDi = new JLabel("");
		lblNgayDi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgayDi.setBounds(756, 35, 195, 22);
		pCenter.add(lblNgayDi);
		
		lblSoDem = new JLabel("");
		lblSoDem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoDem.setBounds(756, 65, 195, 22);
		pCenter.add(lblSoDem);
		
		lblThuNgan = new JLabel("");
		lblThuNgan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThuNgan.setBounds(756, 95, 195, 22);
		pCenter.add(lblThuNgan);
		
		lblThanhToan = new JLabel("");
		lblThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThanhToan.setBounds(756, 125, 195, 22);
		pCenter.add(lblThanhToan);
		
		JPanel pPhong = new JPanel();
		pPhong.setBackground(new Color(255, 255, 255));
		pPhong.setBounds(0, 262, 1010, 272);
		contentPane.add(pPhong);
		pPhong.setLayout(null);

	  
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Phòng");
        
        // Đặt font mới cho TitledBorder
        titledBorder.setTitleFont(new Font("Tahoma", Font.BOLD, 20));
        
        // Đặt TitledBorder cho panel
        pPhong.setBorder(titledBorder);
        cols1 = new String[] {"Phòng", "Số ngày ở", "Đơn giá", "Thành tiền"};
        modelPhong = new DefaultTableModel(cols1, 0);
        JTable tablePhong = new JTable(modelPhong);
        tablePhong.setBounds(0, 0, 1010, 272);
        tablePhong.setRowHeight(30);
        tablePhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tablePhong.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader header = tablePhong.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 15));
        tablePhong.getColumnModel().getColumn(0).setPreferredWidth(100);
        tablePhong.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablePhong.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablePhong.getColumnModel().getColumn(3).setPreferredWidth(100);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane scrollPane = new JScrollPane(tablePhong);
        scrollPane.setBounds(0, 25, 1010, 236);
        pPhong.add(scrollPane);
        // muốn căn giữa dữ liệu trong table
        tablePhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablePhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablePhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablePhong.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
       
        
          
        
	    
	    JPanel pTop_1 = new JPanel();
	    pTop_1.setBackground(new Color(255, 255, 255));
	    pTop_1.setLayout(null);
	    pTop_1.setBorder(border);
	    pTop_1.setBounds(0, 758, 1010, 244);
	    contentPane.add(pTop_1);
	    
	
	    // tôi muốn cái jlabel tự động xuống dòng khi đến cuối dòng khi còn chữ
    
   	
        	
	    
	    
	
	    
        JTextArea textArea = new JTextArea("Lưu ý: khách hàng kiểm tra lại đúng các phòng và dịch vụ mà khách đã đăng kí trước khi ra về xin cảm ơn");
        textArea.setLineWrap(true); // Kích hoạt jalbe tự động
        textArea.setWrapStyleWord(true); // Jalbe theo từ
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textArea.setBounds(10, 130, 468, 48);
        
    
        
	    pTop_1.add(textArea);
	    
	    JLabel lblTngTin = new JLabel("Tổng tiền");
	    lblTngTin.setBounds(671, 27, 108, 22);
	    pTop_1.add(lblTngTin);
	    lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    
	    lblTongTien = new JLabel("000000000000000");
	    lblTongTien.setBounds(806, 27, 176, 22);
	    pTop_1.add(lblTongTien);
	    lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    
	    lblThueVAT = new JLabel("0");
	    lblThueVAT.setBounds(806, 95, 176, 22);
	    pTop_1.add(lblThueVAT);
	    lblThueVAT.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    
	    JLabel lblThu = new JLabel("Thuế VAT :");
	    lblThu.setBounds(671, 95, 160, 22);
	    pTop_1.add(lblThu);
	    lblThu.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    
	    JLabel lblTng = new JLabel("Tổng:");
	    lblTng.setBounds(671, 129, 108, 22);
	    pTop_1.add(lblTng);
	    lblTng.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    
	    lblTong = new JLabel("000000000000000");
	    lblTong.setBounds(806, 129, 176, 22);
	    pTop_1.add(lblTong);
	    lblTong.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    
	    JTextArea txtrMiThcVui = new JTextArea("Mọi thắc vui lòng liên hệ số điện thoại: 0989999921");
	    txtrMiThcVui.setWrapStyleWord(true);
	    txtrMiThcVui.setLineWrap(true);
	    txtrMiThcVui.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtrMiThcVui.setBounds(10, 190, 468, 22);
	    pTop_1.add(txtrMiThcVui);
	    
	    JLabel lblKhuynMi = new JLabel("Khuyến mãi: ");
	    lblKhuynMi.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblKhuynMi.setBounds(671, 61, 108, 22);
	    pTop_1.add(lblKhuynMi);
	    
	    lblkhuyenMai = new JLabel("0");
	    lblkhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblkhuyenMai.setBounds(806, 61, 176, 22);
	    pTop_1.add(lblkhuyenMai);
	    
	    JPanel pDichVu = new JPanel();
	    pDichVu.setBackground(new Color(255, 255, 255));
	    pDichVu.setLayout(null);
	    pDichVu.setBounds(0, 533, 1010, 224);
	    contentPane.add(pDichVu);
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Dịch vụ");
        
        // Đặt font mới cho TitledBorder
        titledBorder1.setTitleFont(new Font("Tahoma", Font.BOLD, 20));
        
        // Đặt TitledBorder cho panel
        pDichVu.setBorder(titledBorder1);
        
	    
        cols1 = new String[] {"Dịch vụ", "Số lượng", "Đơn giá", "Thành tiền"};
        modelDichVu = new DefaultTableModel(cols1, 0);
        JTable tableDichVu = new JTable(modelDichVu);
        tableDichVu.setBounds(0, 0, 1010, 310);
        tableDichVu.setRowHeight(30);
        tableDichVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tableDichVu.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader header1 = tableDichVu.getTableHeader();
        header1.setFont(new Font("Tahoma", Font.BOLD, 15));
        tableDichVu.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableDichVu.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableDichVu.getColumnModel().getColumn(2).setPreferredWidth(100);
        tableDichVu.getColumnModel().getColumn(3).setPreferredWidth(100);
        DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
        centerRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane scrollPane1 = new JScrollPane(tableDichVu);
        scrollPane1.setBounds(0, 25, 1010, 199);
        pDichVu.add(scrollPane1);
        // muốn căn giữa dữ liệu trong table
        tableDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer1);
        tableDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer1);
        tableDichVu.getColumnModel().getColumn(2).setCellRenderer(centerRenderer1);
        tableDichVu.getColumnModel().getColumn(3).setCellRenderer(centerRenderer1);
        
        setDuLieu();
       
        
	}
	public void setDuLieu() {
		for (int i = 0; i < dsPDV.size(); i++) {
			System.out.println(dsPDV.get(i).getDonGia());
		}
		lblTen.setText(dsPDP.get(0).getKhachHang().getHoTen());
		lblDC.setText(dsPDP.get(0).getKhachHang().getDiaChi());
		lblSDT.setText(dsPDP.get(0).getKhachHang().getSoDT());
		StringBuilder phongBuilder = new StringBuilder();
		for (int i = 0; i < dsPDP.size(); i++) {
		    phongBuilder.append(dsPDP.get(i).getPhong().getMaPhong());
		    if (i < dsPDP.size() - 1) {
		        phongBuilder.append(", "); // Thêm dấu phẩy giữa các mã phòng
		    }
		}
		lblPhong.setText(phongBuilder.toString());
		
		// Set số đêm bằng số ngày đi - số ngày đến
		LocalDate ngayDen = dsPDP.get(0).getThoiGianNhan();
		LocalDate ngayDi = dsPDP.get(0).getThoiGianTra();
		    
		lblNgayDen.setText(ngayDen.toString());
		lblNgayDi.setText(ngayDi.toString());
		    
		// Tính số đêm bằng cách sử dụng ChronoUnit.DAYS.between
		long soDem = ChronoUnit.DAYS.between(ngayDen, ngayDi);
		lblSoDem.setText(String.valueOf(soDem));
		lblThuNgan.setText(dsPDP.get(0).getNhanVien().getHoTenNV());
		double thanhtoanPhong = 0;
		double thanhtoanDichVu = 0;
		double thueVATp = 0;
		double thueVATdV = 0;
		double thueVAT = 0;
		double tongTien = 0;
		double tienKMP = 0;
		double tienKMDV = 0;
		// Set Khuyến Mãi
		//Lấy dữ liệu khách hàng
				
				
		KhachHang kh = new KhachHang_DAO().getKhachHangByMaKhachHang(dsPDP.get(0).getKhachHang().getmaKH());
		String hang = kh.getHang();
		double phanTramKM = 0;
		if (hang.equals("Bronze")) {
			 phanTramKM = 0;
		} else if (hang.equals("Silver")) {
			phanTramKM = 5;
		} else if (hang.equals("Gold")) {
			phanTramKM = 10;
		}
		
		for (int i = 0; i < dsPDP.size(); i++) {
			double donGia = dsPDP.get(i).getDonGiaPhieu();
			thanhtoanPhong += donGia;
		}
		// Tính khuyến mãi phòng
		tienKMP = thanhtoanPhong * (phanTramKM / 100);
		thanhtoanPhong = thanhtoanPhong - tienKMP;
		
		lblThanhToan.setText(String.valueOf(thanhtoanPhong));
		for (int i = 0; i < dsPDP.size(); i++) {
			setModelTablePhong(dsPDP.get(i));
		}
		if (dsPDV.size() != 0) {
			for (int i = 0; i < dsPDV.size(); i++) {
				DichVu dv = new DAO_DichVu().getDichVuByMa(dsPDV.get(i).getDichVu().getMaDichVu());
				dsPDV.get(i).setDichVu(dv);
				setModelTableDichVu(dsPDV.get(i));
			}
		}
		
		for (int i = 0; i < dsPDV.size(); i++) {
			double donGia = dsPDV.get(i).getGiaTrcThue();
			System.out.println("Don gia trc thue: " + donGia);
			thanhtoanDichVu += donGia;
		}
		// Tính khuyến mãi dịch vụ
		tienKMDV = thanhtoanDichVu * (phanTramKM / 100);
		thanhtoanDichVu = thanhtoanDichVu - tienKMDV;
		
		System.out.println("Tien KMDV: " + tienKMDV);
		System.out.println("Tien thanh toan DV: " + thanhtoanDichVu);
		
		// Set Thuế VAT
		if (dsPDV.size() != 0) {
			// Tính thuế VAT cho dịch vụ
			thueVATdV = tinhThueVATDichVu();
		}
		System.out.println("Thue VAT DV: " + thueVATdV);
		// Tính thuế VAT
		
		thueVATp = thanhtoanPhong * 0.08;	
		thueVAT = thueVATdV + thueVATp;

		
		
	    // Tính tổng tiền
		
		tongTien = thanhtoanPhong + thanhtoanDichVu;
		tongTien = tongTien + thueVAT;
		

		
		
		
		
		
		// Set Lại điểm cho Khách hàng
		double diem = tongTien / 100000;
		// ép kiểu int cho diem
		int diemInt = (int) diem;
		//Cập nhật điểm trong sql
		new KhachHang_DAO().capNhapDiem(kh.getmaKH(), diemInt);
		// Cập nhật lại hạng cho khách hàng
		int diemKh = new KhachHang_DAO().getDiemKhachHang(kh.getmaKH());
		if (diemKh < 500) {
			new KhachHang_DAO().capNhapHang(kh.getmaKH(), "Bronze");
		} else if (diemKh >= 500 && diemKh < 1000) {
			new KhachHang_DAO().capNhapHang(kh.getmaKH(), "Silver");
		} else {
			new KhachHang_DAO().capNhapHang(kh.getmaKH(), "Gold");
		}
		
		//Set Hoa Don
		LocalDate thoiGianLap = LocalDate.now();
    	String formatter = thoiGianLap.format(DateTimeFormatter.ofPattern("yyMMdd"));
		// Tạo mã phiếu dịch vụ ngẫu nhiên
    	String maHD;
    	ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
    	dsHD = new DAO_HoaDon().getalltbHoaDon();
    	if (dsHD.size() == 0) {
    		maHD = "HD" + formatter + "0001";
    	} else {
    		int count = 1;
    		for (int a = 0; a < dsHD.size(); a++) {
    			if (dsHD.get(a).getMaHoaDon().contains("HD"+formatter)) {
    				count++;
    			}
    		}
    		if (count < 10) {
    			maHD="HD"+formatter + "000" + count;
    		} else if (count < 100) {
    			maHD = "HD" + formatter + "00" + count;
    		} else if (count < 1000) {
    			maHD = "HD" + formatter + "0" + count;
    		} else {
    			maHD = "HD" + formatter + count;
    		}
    		
    	}
  
    	// Tạo hóa đơn
    	String trangThaiHD = "Đã thanh toán";
    	double giaTrcThue = thanhtoanPhong + thanhtoanDichVu;
    	HoaDon hd = new HoaDon(maHD, thoiGianLap, trangThaiHD, giaTrcThue, tongTien);
    	new DAO_HoaDon().insertHoaDon(hd);
    	
    	//Cập nhật mã hóa đơn cho dsPDP và dsPDV
		for (int i = 0; i < dsPDP.size(); i++) {
			
			new PhieuDatPhong_DAO().updateMaHoaDonPhieuDatPhong(dsPDP.get(i), maHD);
		}
		if (dsPDV.size() != 0) {
			for (int i = 0; i < dsPDV.size(); i++) {
				new DAO_PhieuDatDichVu().updateMaHoaDonPhieuDatDichVu(dsPDV.get(i), maHD);
			}
		}
		lblMaHoaDon.setText(maHD);
		lblTongTien.setText(String.valueOf(thanhtoanPhong + thanhtoanDichVu));
		lblThueVAT.setText(String.valueOf(thueVAT));
		lblkhuyenMai.setText(String.valueOf(tienKMP + tienKMDV));
		lblTong.setText(String.valueOf(tongTien + " VND"));
	}

	
	public void setModelTablePhong(PhieuDatPhong pdp) {
		modelPhong.addRow(new Object[] {
				pdp.getPhong().getMaPhong(), 
				// Lấy số ngày ở
				pdp.getThoiGianTra().compareTo(pdp.getThoiGianNhan()),
				pdp.getPhong().getDonGiaTheoNgay(),
				// Tính thành tiền
				pdp.getDonGiaPhieu()
		});
		
	}

	public void setModelTableDichVu(PhieuDatDichVu pdv) {
		
		modelDichVu.addRow(new Object[] { 
				pdv.getDichVu().getTenDichVu(), 
				pdv.getSoLuong(), 
				pdv.getDichVu().getDonGia(),
				pdv.getGiaTrcThue()
				 });

	}

	public float tinhThueVATDichVu() {
        double thueVAT = 0;
        for (int i = 0; i < dsPDV.size(); i++) {
        	// Tính tổng tiền trước thuế = giá trước thuế - % khuyến mãi
            double giaTrcThue = dsPDV.get(i).getGiaTrcThue();
            // Lay thue VAT cua dich vu
            double thueVATDichVu = dsPDV.get(i).getDichVu().getThueVAT();
            // Tính thuế VAT
            thueVAT += giaTrcThue * (thueVATDichVu/100);
        }
        return (float) thueVAT;
    }
}
