package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.PhieuDatDichVu;
import dao.PhieuDatPhong_DAO;
import dao.DAO_DichVu;
import dao.DAO_PhieuDatDichVu;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.DichVu;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class GUI_DatDichVu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel Frame;
    private JPanel panelKH;
    private JTextField txtmaKH;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtTuoi;
    private JLabel lblGT;
    private JTextField txtGT;
    private JPanel paneDV;
    private JTable tableHD;
    private DefaultTableModel modelHD;
    private JPanel outerPanel;
    private KhachHang_DAO khachHang_DAO;
    private ArrayList<KhachHang> dsKH;
    private ArrayList<DichVu> dsDV;
    private JTextField txtSoLuong;
	private ArrayList<PhieuDatPhong> pdp;
	private KhachHang kh;
	private NhanVien nv;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	NhanVien nv = new NhanVien("NV0000001");
                GUI_DatDichVu frame = new GUI_DatDichVu(nv);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GUI_DatDichVu(NhanVien nv) {

        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       this.nv = nv;
        // Lấy danh sách phiếu đặt phòng từ CSDL
        pdp = new PhieuDatPhong_DAO().timPhieuDatPhongTheoTrangThai();
        System.out.println(pdp.get(0).getMaPhieu());
        setTitle("Quản lý khách sạn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(258, 181, 1654, 859);
        setResizable(false);
        setUndecorated(true);
        Frame = new JPanel();
        Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Frame);
        Frame.setLayout(null);

        panelKH = new JPanel();
        panelKH.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelKH.setBounds(0, 0, 1654, 138);
        Frame.add(panelKH);
        panelKH.setLayout(null);

        JLabel lblCCCD = new JLabel("Căn cước công dân:");
        lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCCCD.setBounds(100, 37, 185, 26);
        panelKH.add(lblCCCD);

        txtmaKH = new JTextField();
        txtmaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtmaKH.setBounds(313, 37, 350, 26);
        panelKH.add(txtmaKH);
        txtmaKH.setColumns(10);

        JButton btnTim = new JButton("Tìm");
        btnTim.setBackground(new Color(234, 232, 214));
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTim.setBounds(696, 37, 96, 26);
        panelKH.add(btnTim);

        txtSDT = new JTextField();
        txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtSDT.setColumns(10);
        txtSDT.setBounds(313, 86, 350, 26);
        txtSDT.setEditable(false);
        panelKH.add(txtSDT);

        JLabel lblSDT = new JLabel("Số điện thoại:");
        lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSDT.setBounds(100, 86, 185, 26);
        panelKH.add(lblSDT);

        JLabel lblTenKH = new JLabel("Tên Khách hàng:");
        lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTenKH.setBounds(990, 37, 185, 26);
        panelKH.add(lblTenKH);

        txtTen = new JTextField();
        txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTen.setBounds(1185, 37, 350, 26);
        txtTen.setColumns(10);
        txtTen.setEditable(false);
        panelKH.add(txtTen);

        JLabel lblTuoi = new JLabel("Tuổi:");
        lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTuoi.setBounds(990, 86, 61, 26);
        panelKH.add(lblTuoi);

        txtTuoi = new JTextField();
        txtTuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTuoi.setColumns(10);
        txtTuoi.setBounds(1067, 86, 120, 26);
        txtTuoi.setEditable(false);
        panelKH.add(txtTuoi);

        lblGT = new JLabel("Giới Tính:");
        lblGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGT.setBounds(1243, 86, 96, 26);
        panelKH.add(lblGT);

        txtGT = new JTextField();
        txtGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtGT.setColumns(10);
        txtGT.setBounds(1370, 86, 166, 26);
        txtGT.setEditable(false);
        panelKH.add(txtGT);

        paneDV = new JPanel();
        paneDV.setBorder(new LineBorder(new Color(0, 0, 0)));
        paneDV.setBounds(0, 138, 1654, 313);
        Frame.add(paneDV);
        paneDV.setLayout(null);

        String[] cols = new String[]{"STT", "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng", "Tổng tiền"};

        modelHD = new DefaultTableModel(cols, 0);

        paneDV.setLayout(null);
        tableHD = new JTable(modelHD);
        JScrollPane paneNV = new JScrollPane(tableHD);
        paneNV.setBounds(96, 15, 1454, 240);

        paneDV.add(paneNV);

        JTableHeader headers = tableHD.getTableHeader();
        Font headerFont = new Font("Tahoma", Font.PLAIN, 20);
        headers.setFont(headerFont);

        tableHD.setFont(new Font("Tahoma", Font.PLAIN, 18));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableHD.setDefaultRenderer(Object.class, centerRenderer);
        tableHD.setRowHeight(30);

        JButton btnDat = new JButton("Đặt dịch vụ");
        btnDat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDat.setBackground(new Color(234, 232, 214));
        btnDat.setBounds(1400, 266, 157, 30);
        paneDV.add(btnDat);

        JButton btHuy = new JButton("Hủy Phiếu");
        btHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btHuy.setBackground(new Color(234, 232, 214));
        btHuy.setBounds(1200, 266, 157, 30);
        paneDV.add(btHuy);

        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSoLuong.setBounds(97, 269, 185, 26);
        paneDV.add(lblSoLuong);

        txtSoLuong = new JTextField();
        txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(196, 268, 350, 26);
        paneDV.add(txtSoLuong);
        txtSoLuong.setText("1");

        outerPanel = new JPanel(null);
        outerPanel.setBounds(37, 485, 1580, 351);
        Frame.add(outerPanel);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXoa.setBackground(new Color(234, 232, 214));
        btnXoa.setBounds(1000, 266, 157, 30);
        paneDV.add(btnXoa);

        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(1500, 380));

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 1580, 351);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        outerPanel.add(scrollPane);

  

        btnTim.addActionListener(e -> {
        	if (txtmaKH.getText().equals("")) {
        		JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng");
        	} else {
        		int flag = 0;
                System.out.println(txtmaKH.getText());
                for (PhieuDatPhong p : pdp) {
                	System.out.println(p.getMaPhieu());
                	if(p.getKhachHang().getmaKH().equals(txtmaKH.getText())) {
                		JOptionPane.showMessageDialog(null, "Tìm thấy khách hàng");
                		createButtons(panel);
    					kh = new KhachHang_DAO().getKhachHangByMaKhachHang(txtmaKH.getText());
    					txtTen.setText(kh.getHoTen());
    					Calendar cal = Calendar.getInstance();
    					txtTuoi.setText(String.valueOf(cal.get(Calendar.YEAR) - kh.getNgaySinh().getYear()));
    					txtSDT.setText(kh.getSoDT());
    					txtGT.setText(kh.getGioiTinh() ? "Nam" : "Nữ");
    					flag = 1;
    					break;
                	}
                }
    			if (flag == 0) {
    				JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
    			}
        	}
            
        });

        btHuy.addActionListener(e -> {
            txtmaKH.setText("");
            txtTen.setText("");
            txtTuoi.setText("");
            txtSDT.setText("");
            txtGT.setText("");
            ((DefaultTableModel) modelHD).setRowCount(0);
            txtSoLuong.setText("1");
        });

        btnXoa.addActionListener(e -> {
            int row = tableHD.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ trên bảng cần xóa");
            } else {
                ((DefaultTableModel) modelHD).removeRow(row);
            }
        });

        btnDat.addActionListener(e -> {
			if (tableHD.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ");
			} else {
				for (int i = 0; i < tableHD.getRowCount(); i++) {
					themPhieuDV(i);
				}
				JOptionPane.showMessageDialog(null, "Đặt dịch vụ thành công");
			}
        });
    }
    public void themPhieuDV(int i) {
    	// Lấy ngày hiện tại rồi chuyển thành chuỗi yyymmdd
    	LocalDate thoiGianDat = LocalDate.now();
    	String formatter = thoiGianDat.format(DateTimeFormatter.ofPattern("yyMMdd"));
		// Tạo mã phiếu dịch vụ ngẫu nhiên
    	String maPhieu;
    	ArrayList<PhieuDatDichVu> dsPDV = new ArrayList<>();
    	dsPDV = new DAO_PhieuDatDichVu().getDSPhieuDatDichVu();
    	if (dsPDV.size() == 0) {
    		maPhieu = "PDV" + formatter + "0001";
    	} else {
    		int count = 1;
    		for (int a = 0; a < dsPDV.size(); a++) {
    			if (dsPDV.get(a).getMaPhieu().contains("PDV"+formatter)) {
    				count++;
    			}
    		}
    		if (count < 10) {
    			maPhieu="PDV"+formatter + "000" + count;
    		} else if (count < 100) {
    			maPhieu = "PDV" + formatter + "00" + count;
    		} else if (count < 1000) {
    			maPhieu = "PDV" + formatter + "0" + count;
    		} else {
    			maPhieu = "PDV" + formatter + count;
    		}
    		
    	}
    	// Lấy thông tin khách hàng
    	String maKH = txtmaKH.getText();
    	KhachHang kh = new KhachHang(txtmaKH.getText());
    	// Lấy thông tin mã dịch vụ từ bảng
    	String maDV = (String) tableHD.getValueAt(i, 1);
    	int soLuong = (int) tableHD.getValueAt(i, 4);
    	
        // Lấy thông tin đơn giá từ bảng
    	String donGiaStr = (String) tableHD.getValueAt(i, 5);

    	// Loại bỏ dấu phẩy khỏi chuỗi
    	donGiaStr = donGiaStr.replace(",", "");

    	// Chuyển đổi chuỗi đã loại bỏ dấu phẩy sang double
    	double donGia = Double.parseDouble(donGiaStr);
		DichVu dv = new DAO_DichVu().getDichVuByMa(maDV);
		// set trạng thái
		String trangThai = "Chưa thanh toán";
		// Tính giá trước thuế
		int thue = dv.getThueVAT();
		// ep kieu thue ve double
		double thue1 = (double) thue;
		double giaTrcThue = donGia / (1 + thue1/100);
		//Lam tron gia trc thue den 2 chu so thap phan
		giaTrcThue = Math.round(giaTrcThue * 100.0) / 100.0;
		PhieuDatDichVu pd = new PhieuDatDichVu(maPhieu, thoiGianDat, donGia, soLuong, dv, kh, nv, trangThai, giaTrcThue);
		// Thêm phiếu đặt dịch vụ vào CSDL
		new DAO_PhieuDatDichVu().insertPhieuDichVu(pd);
		
    }

//    public void createButtons(JPanel panel) {
//        DAO_DichVu dv = new DAO_DichVu();
//        dsDV = dv.getAllDichVu();
//        JButton[] buttons = new JButton[dsDV.size()];
//        // nếu trạng thái của dịch vụ là "Đang kinh doanh" thì hiển thị lên button"
//        for (int i = 0; i < dsDV.size(); i++) {
//            buttons[i] = new JButton();
//            StringBuilder htmlText = new StringBuilder("<html><center>");
//            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append(dsDV.get(i).getTenDichVu()).append("</span><br/>");
//            // thêm ảnh vào button có đường dẫn ./anhPhong/Doi_01.jpg
//            htmlText.append("<img src='").append("file:./anhPhong/Doi_01.jpg").append("' width='200' height='200'><br/>");
//            
//            
//            
//         
//            
//            
//		
//            double dongia = dsDV.get(i).getDonGia();
//          	// khi in ra thẻ html giá trị phải chuyển từ 1000 -> 1.000
//            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("Giá: ").append(String.format("%,.0f", dongia)).append("</span><br/>");
//       
//            htmlText.append("</center></html>");
//            buttons[i].setText(htmlText.toString());
//            buttons[i].setBounds(50 + ((i) % 3) * 490, 50 + ((i) / 3) * 290, 450, 250);
//            panel.setPreferredSize(new Dimension(1500, 100 + ((i) / 2) * 390 + 150));
//            panel.add(buttons[i]);
//
//            int index = i;
//            buttons[i].addActionListener(e -> {
//                String maDV = dsDV.get(index).getMaDichVu();
//                String tenDV = dsDV.get(index).getTenDichVu();
//                double gia = dsDV.get(index).getDonGia();
//                int soLuong = Integer.parseInt(txtSoLuong.getText());
//                
//                if (soLuong > 10) {
//                    JOptionPane.showMessageDialog(null, "Số lượng không được quá 10");
//                } else if (soLuong < 1) {
//                    JOptionPane.showMessageDialog(null, "Số lượng không được nhỏ hơn 1");
//                } else {
//                    double tongTien = gia * soLuong;
//                    // giá và tổng tiền  khi in lên bảng phải chuyển từ 1000 -> 1.000
//                    Object[] row = {modelHD.getRowCount() + 1, maDV, tenDV, String.format("%,.0f", gia), soLuong, String.format("%,.0f", tongTien)};
//                    ((DefaultTableModel) modelHD).addRow(row);
//                }
//            });
//        }
//    }
    // tạo hàm createButtons với dsDV.getTrangThai().equals("Đang kinh doanh") thì ta mới hiển thị lên button
	public void createButtons(JPanel panel) {
        DAO_DichVu dv = new DAO_DichVu();
        dsDV = dv.getAllDichVu();
        dsDV.removeIf(dichVu -> !dichVu.getTrangThai().equals("Đang kinh doanh"));
        JButton[] buttons = new JButton[dsDV.size()];
        for (int i = 0; i < dsDV.size(); i++) {
            buttons[i] = new JButton();
            StringBuilder htmlText = new StringBuilder("<html><center>");
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append(dsDV.get(i).getTenDichVu()).append("</span><br/>");
            double dongia = dsDV.get(i).getDonGia();
            htmlText.append("<span style='font-family:Tahoma; font-size:20pt;'>").append("Giá: ").append(String.format("%,.0f", dongia)).append("</span><br/>");
            htmlText.append("</center></html>");
            buttons[i].setText(htmlText.toString());
            buttons[i].setBounds(20 + ((i) % 4) * 390, 50 + ((i) / 4) * 290, 350, 250);
        	panel.setPreferredSize(new Dimension(1500, 100 + ((i) / 2) * 390 + 150));
            panel.add(buttons[i]);
            // chỉnh màu nền cho button hợp với giao diện
             buttons[i].setBackground(new Color(234, 232, 214));
            int index = i;
            buttons[i].addActionListener(e -> {
            	// khi bấm cùng 1 button thì cột số lượng của table +1
				String maDV = dsDV.get(index).getMaDichVu();
				String tenDV = dsDV.get(index).getTenDichVu();
				double gia = dsDV.get(index).getDonGia();
				int thue = dsDV.get(index).getThueVAT();
				int soLuong = Integer.parseInt(txtSoLuong.getText());
				if (soLuong > 10) {
					JOptionPane.showMessageDialog(null, "Số lượng không được quá 10");
				} else if (soLuong < 1) {
					JOptionPane.showMessageDialog(null, "Số lượng không được nhỏ hơn 1");
				} else {
					// Ep kieu thue ve double
					double thue1 = (double) thue;
					double tongTien = soLuong * gia * (1 + thue1/100);
					System.out.println(soLuong);
					System.out.println(thue);
					System.out.println(gia);
					System.out.println(tongTien);
					// if button đã tồn tại trên bảng thì không thêm vào nữa mà chỉ cập nhật số lượng
					boolean isExist = false;
					for (int j = 0; j < tableHD.getRowCount(); j++) {
						if (tableHD.getValueAt(j, 1).equals(maDV)) {
							int sl = (int) tableHD.getValueAt(j, 4) + soLuong;
							double tt = sl * gia * (1 + thue1/100);
							tableHD.setValueAt(sl, j, 4);
							tableHD.setValueAt(String.format("%,.0f", tt), j, 5);
							isExist = true;
							break;
						}
					}
					if (!isExist) {
						Object[] row = { modelHD.getRowCount() + 1, maDV, tenDV, String.format("%,.0f", gia), soLuong,
								String.format("%,.0f", tongTien) };
						((DefaultTableModel) modelHD).addRow(row);
					}
				}
              });
          }
      }
	
}
