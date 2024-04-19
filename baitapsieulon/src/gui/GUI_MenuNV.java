package gui;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.NhanVien;

public class GUI_MenuNV extends JFrame {

	private JPanel Frame;
    private JButton btnTrangChu;
    private JButton btnQLP;
    private JButton btnQLHD;
    private JButton btnQLKH;
    private JButton btnQLKM;
    private JButton btnQLDV;
    private JButton btnHT;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JButton btnQLPD;
	/**

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien nv = new NhanVien("NV0000001");
					GUI_MenuNV frame = new GUI_MenuNV(nv);
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
	public GUI_MenuNV(NhanVien nv) {
		
			setIconImage(new ImageIcon(dangnhap.class.getResource("/img/logo.png")).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
			setTitle("Quản lý khách sạn");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(8,181,250,869);
			setUndecorated(true);
			setResizable(false);
			
			
			
			Frame = new JPanel();
			Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(Frame);
			Frame.setLayout(null);
			
			

			
			Panel panel_menu = new Panel();
			panel_menu.setLayout(null);
			panel_menu.setBackground(Color.LIGHT_GRAY);
			panel_menu.setBounds(0, 0, 250, 861);
			Frame.add(panel_menu);
			
			
			btnTrangChu = new JButton("Trang chủ");
			btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnTrangChu.setForeground(new Color(244, 244, 244));
			btnTrangChu.setBackground(new Color(41, 139, 106));
			btnTrangChu.setBounds(0, 0, 250, 70);
			panel_menu.add(btnTrangChu);
			
			
			btnQLP = new JButton("Quản lí phòng");
			btnQLP.setBackground(new Color(255, 255, 255));
			btnQLP.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnQLP.setBounds(0, 68, 250, 68);
			panel_menu.add(btnQLP);
			
			
			btnQLHD = new JButton("Quản lí hóa đơn");
			btnQLHD.setBackground(new Color(255, 255, 255));
			btnQLHD.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnQLHD.setBounds(0, 133, 250, 68);
			panel_menu.add(btnQLHD);
			
			
			btnQLKH = new JButton("Quản lí Khách hàng");
			btnQLKH.setBackground(new Color(255, 255, 255));
			btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 23));
			btnQLKH.setBounds(0, 198, 250, 68);
			panel_menu.add(btnQLKH);
			
			btnQLKM = new JButton("Quản lí khuyến mãi");
			btnQLKM.setBackground(new Color(255, 255, 255));
			btnQLKM.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnQLKM.setBounds(0, 264, 250, 68);
			panel_menu.add(btnQLKM);
			
			btnQLDV = new JButton("Quản lí dịch vụ");
			btnQLDV.setBackground(new Color(255, 255, 255));
			btnQLDV.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnQLDV.setBounds(0, 329, 250, 68);
			panel_menu.add(btnQLDV);
			
			btnHT = new JButton("Hỗ trợ");
			btnHT.setBackground(new Color(255, 255, 255));
			btnHT.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnHT.setBounds(0, 461, 250, 68);
			panel_menu.add(btnHT);
			
			lblNewLabel_2 = new JLabel("__________________________________________");
			lblNewLabel_2.setForeground(new Color(41, 111, 106));
			lblNewLabel_2.setBounds(0, 706, 260, 19);
			panel_menu.add(lblNewLabel_2);
			
			lblNewLabel_3 = new JLabel("Thông tin khách sạn");
			lblNewLabel_3.setForeground(new Color(41, 111, 106));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(0, 731, 250, 30);
			panel_menu.add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel("Hotline: 0387272513");
			lblNewLabel_4.setForeground(new Color(41, 111, 106));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_4.setBounds(0, 780, 250, 30);
			panel_menu.add(lblNewLabel_4);
			
			lblNewLabel_5 = new JLabel("Địa chỉ: 416/39 Dương Quảng Hàm");
			lblNewLabel_5.setForeground(new Color(41, 111, 106));
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(0, 812, 250, 30);
			panel_menu.add(lblNewLabel_5);
			
			lblNewLabel_6 = new JLabel("Phường 5, Gò Vấp, TP.HCM");
			lblNewLabel_6.setForeground(new Color(41, 111, 106));
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(0, 831, 250, 30);
			panel_menu.add(lblNewLabel_6);
			
			btnQLPD = new JButton("Quản lí Phiếu đặt");
			btnQLPD.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnQLPD.setBackground(Color.WHITE);
			btnQLPD.setBounds(0, 395, 250, 68);
			panel_menu.add(btnQLPD);
			
			GUI_TrangChu trangchu = new GUI_TrangChu();
			GUI_QuanLiDatPhong qlp = new GUI_QuanLiDatPhong();
			GUI_QuanLiHoaDon qlhd = new GUI_QuanLiHoaDon();
			GUI_QuanLiKhachHang qlkh = new GUI_QuanLiKhachHang();
			GUI_QuanLiKhuyenMai qlkm = new GUI_QuanLiKhuyenMai();
			GUI_QuanLiDichVu qldv = new GUI_QuanLiDichVu();
			GUI_MenuTK menuTK = new GUI_MenuTK(nv);
			GUI_MenuTrangChu menuTrangChu = new GUI_MenuTrangChu(nv);
			GUI_MenuQLDP menuqldp = new GUI_MenuQLDP(nv);
			
			
			
			
			
			ActionListener actionListener = new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	boolean isVisibleTChu = trangchu.isVisible();
			    	boolean isVisibleQLP = qlp.isVisible();
			    	boolean isVisibleQLHD = qlhd.isVisible();
			    	boolean isVisibleQLKH = qlkh.isVisible();
			    	boolean isVisibleQLKM = qlkm.isVisible();
			    	boolean isVisibleQLDV = qldv.isVisible();
			    	
			    	
			        JButton clickedButton = (JButton) e.getSource();
					
					if (clickedButton == btnTrangChu && !isVisibleTChu) {
			            // Xử lý khi nhấn vào nút btnTK
			            trangchu.setVisible(true);
			            menuTK.setVisible(false);
			            menuTrangChu.setVisible(true);
			            qlp.setVisible(false);
			            qlhd.setVisible(false);
			            qlkh.setVisible(false);
			            qlkm.setVisible(false);
			            qldv.setVisible(false);
			            menuqldp.setVisible(false);
			            
			            btnTrangChu.setForeground(Color.WHITE);
			            btnTrangChu.setBackground(new Color(41, 139, 106));
			            btnQLP.setBackground(new Color(255, 255, 255));
			            btnQLP.setForeground(Color.BLACK);
			            btnQLHD.setBackground(new Color(255, 255, 255));
			            btnQLHD.setForeground(Color.BLACK);
			            btnQLKH.setBackground(new Color(255, 255, 255));
			            btnQLKH.setForeground(Color.BLACK);
			            btnQLKM.setBackground(new Color(255, 255, 255));
			            btnQLKM.setForeground(Color.BLACK);
			            btnQLDV.setBackground(new Color(255, 255, 255));
			            btnQLDV.setForeground(Color.BLACK);
			            btnHT.setBackground(new Color(255, 255, 255));
			            btnHT.setForeground(Color.BLACK);
			            btnQLPD.setBackground(new Color(255, 255, 255));
			            btnQLPD.setForeground(Color.BLACK);
			            
			            
			           
			        } else if (clickedButton == btnTrangChu && isVisibleTChu) {
			            // Xử lý khi nhấn vào nút btnXTT
						
			        	menuTK.setVisible(false);
						
			        	
			        }else if (clickedButton == btnQLP && !isVisibleQLP) {
                    	//tat het cac panel
			        	qldv.setVisible(false);
                    	trangchu.setVisible(false);
                    	qlhd.setVisible(false);
                    	qlkh.setVisible(false);
                    	qlkm.setVisible(false);
                    	menuTK.setVisible(false);
                    	menuTrangChu.setVisible(false);
                    	//bat qldp
                    	menuqldp.setVisible(true);
                    	qlp.setVisible(true);
                    	
                    	//doi mau button
                    	btnQLP.setForeground(Color.WHITE);
                    	btnQLP.setBackground(new Color(41, 139, 106));
                    	btnTrangChu.setBackground(Color.WHITE);
                    	btnTrangChu.setForeground(Color.BLACK);
                    	btnQLHD.setBackground(Color.WHITE);
                    	btnQLHD.setForeground(Color.BLACK);
                    	btnQLKH.setBackground(Color.WHITE);
                    	btnQLKH.setForeground(Color.BLACK);
                    	btnQLKM.setBackground(Color.WHITE);
                    	btnQLKM.setForeground(Color.BLACK);
                    	btnQLDV.setBackground(Color.WHITE);
                    	btnQLDV.setForeground(Color.BLACK);
                    	btnHT.setBackground(Color.WHITE);
                    	btnHT.setForeground(Color.BLACK);
                    	btnQLPD.setBackground(Color.WHITE);
                    	btnQLPD.setForeground(Color.BLACK);
                    	
                    	
			        }else if (clickedButton == btnQLP && isVisibleQLP) {
                    	//tat het cac panel
                    	menuTK.setVisible(false);
			        }
					
			    }
			};
			btnTrangChu.addActionListener(actionListener);
			btnQLP.addActionListener(actionListener);
			btnQLHD.addActionListener(actionListener);
			btnQLKH.addActionListener(actionListener);
			btnQLKM.addActionListener(actionListener);
			btnQLDV.addActionListener(actionListener);
			btnHT.addActionListener(actionListener);
			btnQLPD.addActionListener(actionListener);
			
			
	}

}
