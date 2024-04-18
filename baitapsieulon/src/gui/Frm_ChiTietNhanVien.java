package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class Frm_ChiTietNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmaNV;
	private JTextField txthoTen;
	private JTextField txtviTri;
	private JTextField txtTuoi;
	private JDateChooser dateNgaySinh;
	private JTextField txtTrinhDo;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JTextField txtHeSoLuong;
	private JTextField txtLuongCoBan;
	private JTextField txtTongLuong;
	private NhanVien nv;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JComboBox comboBoxTT;
	private JPanel pnAnh;
	private JButton btnChonAnh;
	private JPanel imagePanel;
	private JLabel lblAnh;
	private JButton btnKhoiPhuc;
	private JButton btnXaTrng;
	private JButton btnThem;
	private JTextField txtCCCD;
	private JDateChooser dateNgayVaoLam;
	private JDateChooser dateNgayNghiLam;
	private JButton btnCpNht;
	static ArrayList list;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frm_ChiTietNhanVien frame = new Frm_ChiTietNhanVien();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public Frm_ChiTietNhanVien(String maNV) {
		try {
			ConnectDB.getInstance().connect();
			} catch (Exception e) {
				e.printStackTrace();
		}
		nv = new NhanVien_DAO().getNhanVienTheoMaNV(maNV);
		System.out.println(nv);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 591, 709);
		setLocationRelativeTo(null);
		setTitle("Chi tiết nhân viên");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(29, 79, 521, 247);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân Viên");
		lblNewLabel.setBounds(12, 24, 106, 16);
		panel.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setBounds(12, 53, 106, 16);
		panel.add(lblHTn);
		
		JLabel lblVTr = new JLabel("Vị Trí");
		lblVTr.setBounds(12, 111, 106, 16);
		panel.add(lblVTr);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setBounds(12, 140, 106, 16);
		panel.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh");
		lblNgySinh.setBounds(12, 169, 66, 16);
		panel.add(lblNgySinh);
		dateNgaySinh = new JDateChooser();
		dateNgaySinh.setBounds(119, 166, 230, 22);
		dateNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//set date ngày mai
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		dateNgaySinh.setDate(cal.getTime());
		panel.add(dateNgaySinh);
		
		txtmaNV = new JTextField();
		txtmaNV.setBounds(119, 21, 230, 22);
		panel.add(txtmaNV);
		txtmaNV.setColumns(10);
		
		txthoTen = new JTextField();
		txthoTen.setBounds(119, 50, 230, 22);
		txthoTen.setColumns(10);
		panel.add(txthoTen);
		
		txtviTri = new JTextField();
		txtviTri.setBounds(119, 108, 230, 22);
		txtviTri.setColumns(10);
		panel.add(txtviTri);
		
		rdNam = new JRadioButton("Nam");
		rdNam.setBounds(126, 136, 51, 25);
		panel.add(rdNam);
		
		rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(180, 136, 43, 25);
		panel.add(rdNu);
		ButtonGroup group = new ButtonGroup();
		group.add(rdNam);
		group.add(rdNu);
		
		JLabel lblTui = new JLabel("Tuổi");
		lblTui.setBounds(231, 140, 38, 16);
		panel.add(lblTui);
		
		txtTuoi = new JTextField();
		txtTuoi.setBounds(264, 137, 85, 22);
		txtTuoi.setColumns(10);
		txtTuoi.setEditable(false);
		panel.add(txtTuoi);
		
		JLabel lblTrnhHc = new JLabel("Trình Độ học vấn");
		lblTrnhHc.setBounds(12, 198, 106, 16);
		panel.add(lblTrnhHc);
		
		txtTrinhDo = new JTextField();
		txtTrinhDo.setBounds(119, 195, 230, 22);
		txtTrinhDo.setColumns(10);
		panel.add(txtTrinhDo);
		
		pnAnh = new JPanel();
		pnAnh.setBounds(371, 21, 127, 161);
		panel.add(pnAnh);
		
		btnChonAnh = new JButton("Chọn Ảnh");
		btnChonAnh.setBounds(371, 192, 127, 23);
		panel.add(btnChonAnh);
		
		JLabel lblNewLabel_1 = new JLabel("CCCD");
		lblNewLabel_1.setBounds(12, 82, 56, 16);
		panel.add(lblNewLabel_1);
		
		txtCCCD = new JTextField();
		txtCCCD.setBounds(119, 79, 230, 22);
		panel.add(txtCCCD);
		txtCCCD.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "T\u00ECnh tr\u1EA1ng l\u00E0m vi\u1EC7c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(29, 456, 258, 149);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNgyVoLm = new JLabel("Ngày vào làm");
		lblNgyVoLm.setBounds(24, 57, 80, 16);
		panel_1.add(lblNgyVoLm);
		
		JLabel lblNgyNghLm = new JLabel("Ngày nghỉ làm");
		lblNgyNghLm.setBounds(24, 87, 106, 16);
		panel_1.add(lblNgyNghLm);
		
		JLabel lblTnhTrng = new JLabel("Tình trạng");
		lblTnhTrng.setBounds(24, 29, 80, 16);
		panel_1.add(lblTnhTrng);
		
		comboBoxTT = new JComboBox();
		comboBoxTT.addItem("Còn Làm");
		comboBoxTT.setBounds(111, 26, 135, 24);
		panel_1.add(comboBoxTT);
		
		dateNgayVaoLam = new JDateChooser();
		dateNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateNgayVaoLam.setDateFormatString("dd/MM/yyyy");
		dateNgayVaoLam.setBounds(110, 57, 136, 22);
		panel_1.add(dateNgayVaoLam);
		
		dateNgayNghiLam = new JDateChooser();
		dateNgayNghiLam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateNgayNghiLam.setDateFormatString("dd/MM/yyyy");
		dateNgayNghiLam.setBounds(110, 90, 136, 22);
		panel_1.add(dateNgayNghiLam);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin li\u00EAn lac", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(29, 324, 521, 131);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(22, 26, 79, 16);
		panel_2.add(lblSinThoi);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(118, 23, 232, 22);
		txtSDT.setColumns(10);
		panel_2.add(txtSDT);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 58, 79, 16);
		panel_2.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(118, 55, 364, 22);
		panel_2.add(txtEmail);
		
		JLabel lblSinThoi_1_1 = new JLabel("Địa chỉ");
		lblSinThoi_1_1.setBounds(22, 90, 79, 16);
		panel_2.add(lblSinThoi_1_1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(118, 87, 364, 22);
		panel_2.add(txtDiaChi);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(285, 456, 265, 149);
		contentPane.add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "L\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);
		
		JLabel lblSinThoi_1 = new JLabel("Hệ số lương");
		lblSinThoi_1.setBounds(12, 29, 79, 16);
		panel_3.add(lblSinThoi_1);
		
		txtHeSoLuong = new JTextField();
		txtHeSoLuong.setColumns(10);
		txtHeSoLuong.setBounds(108, 26, 138, 22);
		panel_3.add(txtHeSoLuong);
		
		txtLuongCoBan = new JTextField();
		txtLuongCoBan.setBounds(108, 57, 138, 22);
		panel_3.add(txtLuongCoBan);
		txtLuongCoBan.setColumns(10);
		
		txtTongLuong = new JTextField();
		txtTongLuong.setBounds(108, 90, 138, 22);
		txtTongLuong.setEditable(false);
		panel_3.add(txtTongLuong);
		txtTongLuong.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Lương cơ bản");
		lblNewLabel_2.setBounds(12, 57, 90, 16);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng lương");
		lblNewLabel_3.setBounds(12, 87, 79, 16);
		panel_3.add(lblNewLabel_3);
		
		btnThem = new JButton("Thêm mới");
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(55, 149, 128));
		btnThem.setBounds(31, 618, 122, 45);
		contentPane.add(btnThem);
		
		btnCpNht = new JButton("Cập Nhật");
		btnCpNht.setForeground(new Color(255, 255, 255));
		btnCpNht.setBackground(new Color(55, 149, 128));
		btnCpNht.setBounds(165, 618, 122, 45);
		contentPane.add(btnCpNht);
		
		btnXaTrng = new JButton("Xóa trắng");
		btnXaTrng.setForeground(new Color(255, 255, 255));
		btnXaTrng.setBackground(new Color(55, 149, 128));
		btnXaTrng.setBounds(295, 618, 122, 45);
		contentPane.add(btnXaTrng);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(164, 194, 163));
		panel_5.setBounds(29, 11, 521, 57);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Thông tin Nhân Viên");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(164, 194, 163));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 521, 57);
		panel_5.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		btnKhoiPhuc = new JButton("Khôi Phục");
		btnKhoiPhuc.setForeground(Color.WHITE);
		btnKhoiPhuc.setBackground(new Color(55, 149, 128));
		btnKhoiPhuc.setBounds(428, 618, 122, 45);
		contentPane.add(btnKhoiPhuc);
		hienThiDuLieu();
		
		btnXaTrng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmaNV.setText("");
				txthoTen.setText("");
				txtCCCD.setText("");
				txtviTri.setText("");
				txtTuoi.setText("");
				txtHeSoLuong.setText("");
				txtLuongCoBan.setText("");
				txtTongLuong.setText("");
				txtSDT.setText("");
				txtEmail.setText("");
				txtDiaChi.setText("");
				txtTrinhDo.setText("");
                dateNgaySinh.setDate(null);
                dateNgayVaoLam.setDate(null);
                dateNgayNghiLam.setDate(null);
				lblAnh.setIcon(null);
			}
		});
		btnChonAnh.addActionListener(new ActionListener() {
			
			private String duongDan;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 JFileChooser fileChooser = new JFileChooser();
	                fileChooser.setDialogTitle("Chọn Ảnh");
	                
	                // Thiết lập bộ lọc chỉ cho phép chọn các tệp ảnh
	                FileNameExtensionFilter filter = new FileNameExtensionFilter("Hình ảnh", "jpg", "jpeg", "png", "gif");
	                fileChooser.setFileFilter(filter);

	                int result = fileChooser.showOpenDialog(Frm_ChiTietNhanVien.this);

	                // Kiểm tra xem người dùng đã chọn một tệp hay không
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File selectedFile = fileChooser.getSelectedFile();
	                    String duongDan = selectedFile.getAbsolutePath();
	                    // Hiển thị hình ảnh trên JPanel
	                    hienThiHinhAnh(duongDan);
	                }
				
				
			}
		});
		btnKhoiPhuc.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        hienThiDuLieu();
		        byte[] imageData = nv.getAnhDaiDien();
		        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
		        Image image = null;
		        try {
		            image = ImageIO.read(bis);
		        } catch (IOException ee) {
		            ee.printStackTrace();
		        }
		        Image scaledImage = image.getScaledInstance(127, 161, Image.SCALE_SMOOTH);
		        lblAnh.setIcon(new ImageIcon(scaledImage));
		        pnAnh.removeAll(); // Xóa tất cả các thành phần hiện có trên JPanel
		        pnAnh.add(lblAnh); // Thêm JLabel vào JPanel
		        pnAnh.revalidate(); // Cập nhật giao diện của JPanel
		        pnAnh.repaint(); // Vẽ lại JPanel
		    }
		});
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vailData()) {
					NhanVien nv = getData();
					GUI_QuanLiNhanVien.ListNV = new NhanVien_DAO().getNhanVienTiepTan();
					if (GUI_QuanLiNhanVien.ListNV.contains(nv)) {
						JOptionPane.showMessageDialog(null, "Nhân viên đã tồn tại");
					} else {	
						try {
							new NhanVien_DAO().themNhanVien(nv);
							GUI_QuanLiNhanVien.ListNV.add(nv);
							JOptionPane.showMessageDialog(null, "Thêm thành công");
						} catch (Exception e2) {
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "Thêm thất bại");
						}
							
						
					}
				}
				
			}
		});
		btnCpNht.addActionListener(new ActionListener() {

			

			@Override
			public void actionPerformed(ActionEvent e) {
				if (vailData()) {
					NhanVien nv = getData();
					if (GUI_QuanLiNhanVien.ListNV.contains(nv)) {
						JOptionPane.showMessageDialog(null, "Nhân viên đã tồn tại");
					} else {
						try {
							new NhanVien_DAO().capNhatNhanVien(nv);
							GUI_QuanLiNhanVien.model.setRowCount(0);
							
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							GUI_QuanLiNhanVien.ListNV = new NhanVien_DAO().getNhanVienTiepTan();
							GUI_QuanLiNhanVien.dsnv = timKiemNhanVien(GUI_QuanLiNhanVien.dsnv);
							GUI_QuanLiNhanVien.updateModel(GUI_QuanLiNhanVien.dsnv);
						} catch (Exception e2) {
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
						}

					}
				}

			}
		});
	}
	
	private void hienThiHinhAnh(String duongDan) {
	    try {
	        // Tạo hình ảnh từ đường dẫn
	        ImageIcon icon = new ImageIcon(duongDan);
	        Image image = icon.getImage();
	        // Chỉnh kích thước hình ảnh
	        Image scaledImage = image.getScaledInstance(127, 161, Image.SCALE_SMOOTH);
	        // Tạo ImageIcon mới từ hình ảnh đã chỉnh kích thước
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);
	        // Đặt hình ảnh vào JLabel
	        lblAnh.setIcon(scaledIcon);
	        pnAnh.add(lblAnh);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	public NhanVien getData() {
	    String maNV = txtmaNV.getText();
	    String hoTen = txthoTen.getText();
	    boolean gioiTinh = rdNam.isSelected();
	    String viTri = txtviTri.getText();
	    String sdt = txtSDT.getText();
	    String email = txtEmail.getText();
	    String diaChi = txtDiaChi.getText();
	    String cccd = txtCCCD.getText();
	    LocalDate ngaySinh = getDateFromJDateChooser(dateNgaySinh);
	    LocalDate ngayVaoLam = getDateFromJDateChooser(dateNgayVaoLam);
	    LocalDate ngayNghiLam = null;
	    if (dateNgayNghiLam.getDate() != null) {
	        ngayNghiLam = getDateFromJDateChooser(dateNgayNghiLam);
	    }

	    if (rdNam.isSelected()) {
	        gioiTinh = true;
	    } else {
	        gioiTinh = false;
	    }
	    String trinhDo = txtTrinhDo.getText();

	    String trangThai = comboBoxTT.getSelectedItem().toString();
	    double heSoLuong = Double.parseDouble(txtHeSoLuong.getText());
	    double luongCoBan = Double.parseDouble(txtLuongCoBan.getText());
	    byte[] anh = getImageBytes(lblAnh);
	    NhanVien nv = new NhanVien(maNV, hoTen, gioiTinh, viTri, sdt, email, diaChi, cccd, ngaySinh, ngayVaoLam, ngayNghiLam, trangThai, trinhDo, anh, heSoLuong, luongCoBan);
	    return nv;
	}

	private LocalDate getDateFromJDateChooser(JDateChooser chooser) {
	    java.sql.Date date = new java.sql.Date(chooser.getDate().getTime());
	    return date.toLocalDate();
	}





	private byte[] getImageBytes(JLabel label) {
        byte[] imageData = null;
        try {
            // Lấy biểu tượng từ JLabel
            ImageIcon icon = (ImageIcon) label.getIcon();
            // Chuyển đổi biểu tượng thành hình ảnh
            Image image = icon.getImage();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // Vẽ hình ảnh vào bufferedImage
            bufferedImage.getGraphics().drawImage(image, 0, 0, null);
            // Tạo một luồng đầu ra để lưu trữ hình ảnh
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // Ghi hình ảnh vào luồng đầu ra dưới dạng JPEG
            ImageIO.write(bufferedImage, "jpg", baos);
            // Chuyển đổi luồng đầu ra thành mảng byte
            imageData = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageData;
    }
	public boolean vailData() {
		String maNV = txtmaNV.getText();
		String hoTen = txthoTen.getText();
		String viTri = txtviTri.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String trinhDo = txtTrinhDo.getText();
		String ngayVaoLam = dateNgayVaoLam.getDate().toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate().toString();
		String heSoLuong = txtHeSoLuong.getText();
		String luongCoBan = txtLuongCoBan.getText();
		LocalDate ngaySinh = dateNgaySinh.getDate().toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();
		if (!(maNV.length() > 0 && maNV.matches("^NV\\d{7}$"))){
			JOptionPane.showMessageDialog(null, "Mã nhân viên không hợp lệ");
            txtmaNV.requestFocus();
            return false;
		}
		if (!(hoTen.length() > 0 && hoTen.matches("[\\p{L}\\p{M}']{1,16}( [\\p{L}\\p{M}']{1,16})*$"))) {
			JOptionPane.showMessageDialog(null, "Họ tên không hợp lệ");
			txthoTen.requestFocus();
			return false;
		}
		if (!(viTri.length() > 0 && viTri.matches("^[\\p{Lu}\\p{Lt}][\\p{Ll}\\p{M}'\\s]*(\\s+[\\p{Lu}\\p{Lt}][\\p{Ll}\\p{M}'\\s]*)*$"))) {
			JOptionPane.showMessageDialog(null, "Vị trí không hợp lệ");
			txtviTri.requestFocus();
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			txtSDT.requestFocus();
			return false;
		}
		if (!(email.length() > 0 && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
			JOptionPane.showMessageDialog(null, "Email không hợp lệ");
			txtEmail.requestFocus();
			return false;
		}
		if (!(diaChi.length() > 0 && diaChi.matches("[\\p{L}\\p{M}']{1,16}( [\\p{L}\\p{M}']{1,16})*$"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ");
			txtDiaChi.requestFocus();
			return false;
		}
		if (!(trinhDo.length() > 0 && trinhDo.matches("^[\\p{Lu}\\p{Lt}][\\p{Ll}\\p{M}'\\s]*(\\s+[\\p{Lu}\\p{Lt}][\\p{Ll}\\p{M}'\\s]*)*$"))) {
			JOptionPane.showMessageDialog(null, "Trình độ không hợp lệ");
			txtTrinhDo.requestFocus();
			return false;
		}
		if(!(ngayVaoLam.length() > 0)) {
			try {
				LocalDate.parse(ngayVaoLam);
				LocalDate ngayHT = LocalDate.now();
				if (ngayHT.isBefore(LocalDate.parse(ngayVaoLam))) {
					JOptionPane.showMessageDialog(null, "Ngày vào làm không hợp lệ");
					dateNgayVaoLam.setDate(null);
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Chọn ngày vào làm");
				dateNgayVaoLam.setDate(null);
				return false;
			}
		}
		if (!(heSoLuong.length() > 0)) {
			try {
				double heso = Double.parseDouble(heSoLuong);
				if(heso < 0 && heso > 3) {
                    JOptionPane.showMessageDialog(null, "Hệ số phải từ 0 đến 3");
                    txtHeSoLuong.requestFocus();
                    return false;
                }
			} catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Hệ số không hợp lệ");
                txtHeSoLuong.requestFocus();
                return false;
            }
		}
		if (!(luongCoBan.length() > 0)) {
			try {
				double luong = Double.parseDouble(luongCoBan);
				if (luong < 0) {
					JOptionPane.showMessageDialog(null, "Lương cơ bản phải lớn hơn 0");
					txtLuongCoBan.requestFocus();
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lương cơ bản không hợp lệ");
				txtLuongCoBan.requestFocus();
				return false;
			}
		}
		if (!(ngaySinh != null)) {
			try {
				LocalDate ngayHT = LocalDate.now();
				LocalDate ngaySinh18namTrc = ngayHT.minusYears(18);
				if(ngaySinh18namTrc.isBefore(ngaySinh)) {
                    JOptionPane.showMessageDialog(null, "Nhân viên phải đủ 18 tuổi");
                    dateNgaySinh.setDate(null);
                    return false;
				}
            } catch (Exception e) {
            	JOptionPane.showMessageDialog(null, "Phải chọn ngày sinh");
                dateNgaySinh.setDate(null);
                return false;
                }
			}
		return true;
	}
	public void hienThiDuLieu() {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		txtmaNV.setText(nv.getMaNV());
		txtCCCD.setText(nv.getCanCuoc());
		txthoTen.setText(nv.getHoTenNV());
		txtviTri.setText(nv.getViTri());
		txtTuoi.setText(String.valueOf(LocalDate.now().getYear() - nv.getNgaySinh().getYear()));
		if (nv.isGioiTinh()) {
			rdNam.setSelected(true);
		} else {
			rdNu.setSelected(true);
		}
		txtTrinhDo.setText(nv.getTrinhDoHocVan());
		txtSDT.setText(nv.getSoDT());
		txtEmail.setText(nv.getEmail());
		txtDiaChi.setText(nv.getDiaChi());
		txtHeSoLuong.setText(String.valueOf(nv.getHeSoLuong()));
		txtLuongCoBan.setText(String.valueOf(nv.getLuongCoBan()));
		txtTongLuong.setText(String.valueOf(decimalFormat.format(nv.getTongLuong())));
		dateNgaySinh.setDate(Date.valueOf(nv.getNgaySinh()));
		dateNgayVaoLam.setDate(Date.valueOf(nv.getNgayVaoLam()));
		if (nv.getNgayNghiLam() != null) {
			dateNgayNghiLam.setDate(Date.valueOf(nv.getNgayNghiLam()));
		}
		comboBoxTT.setSelectedItem(nv.getTrangThai());
		byte[] imageData = nv.getAnhDaiDien();
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
        Image scaledImage = image.getScaledInstance(127, 161, Image.SCALE_SMOOTH);
        // Tạo một lớp JPanel tạm thời để vẽ hình ảnh
        lblAnh = new JLabel(new ImageIcon(scaledImage));
        // Đặt kích thước cho JPanel chứa hình ảnh

        // Thêm JPanel chứa hình ảnh vào JPanel chính
        pnAnh.add(lblAnh);
       
		
	}
	public ArrayList<NhanVien> timKiemNhanVien(ArrayList<NhanVien> dsnv) {
	    // Create a new list to store the search results
		ArrayList<NhanVien> ListNV = new NhanVien_DAO().getNhanVienTiepTan();
		ArrayList<NhanVien> searchResults = new ArrayList<>();
		// Get the search term from the search text field
		
		// For each employee in the list
		for (int i = 0; i < ListNV.size(); i++) {
			// If the search term is contained in the employee's ID
			for (int j = 0; j < dsnv.size(); j++) {
				if (ListNV.get(i).getMaNV().contains(dsnv.get(j).getMaNV())) {
					// Add this employee to the search results
					searchResults.add(ListNV.get(i));
				}
			}
		}
		return searchResults;
	}
}