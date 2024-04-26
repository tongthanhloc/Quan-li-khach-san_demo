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

public class GUI_MenuQLDP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static NhanVien nv;
	
	private ArrayList<NhanVien> ListNV;
	private NhanVien_DAO nv_dao;
	static JButton btnGUI_datPhong;
	static JButton btnGUI_nhanPhong;
	static JButton btnGUI_TraPhong;
	static JButton btnGUI_doiPhong;
	static JButton btnGUI_GiahanPhong;
	static GUI_GiaHanPhong giaHanPhong;
	static GUI_DoiPhong doiPhong;
	static GUI_TraPhong tp;
	static GUI_NhanPhong np;
	static GUI_DatPhong dp;
	static GUI_QuanLiDatPhong qldp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien nv = new NhanVien("NV0000001");
					GUI_MenuQLDP frame = new GUI_MenuQLDP(nv);
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
	public GUI_MenuQLDP(NhanVien nv) {
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
		ListNV = nv_dao.getNhanVienTiepTan();
		
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
		
		btnGUI_datPhong = new JButton("Đặt phòng");
		btnGUI_datPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_datPhong.setForeground(Color.WHITE);
		btnGUI_datPhong.setBackground(new Color(41, 139, 116));
		btnGUI_datPhong.setBounds(290, 25, 200, 100);
		panel_top.add(btnGUI_datPhong);
		
		btnGUI_nhanPhong = new JButton("Nhận Phòng");
		btnGUI_nhanPhong.setForeground(Color.WHITE);
		btnGUI_nhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_nhanPhong.setBackground(new Color(41, 139, 116));
		btnGUI_nhanPhong.setBounds(520, 26, 200, 100);
		panel_top.add(btnGUI_nhanPhong);
		
		btnGUI_TraPhong = new JButton("Trả Phòng");
//		btnGUI_TraPhong.setForeground(new Color(0, 0, 0));
		btnGUI_TraPhong.setForeground(Color.WHITE);
		btnGUI_TraPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
//		btnGUI_TraPhong.setBackground(new Color(164, 194, 163));
		btnGUI_TraPhong.setBackground(new Color(41, 139, 116));
		btnGUI_TraPhong.setBounds(750, 26, 200, 100);
		panel_top.add(btnGUI_TraPhong);
		
		btnGUI_doiPhong = new JButton("Đổi Phòng");
		btnGUI_doiPhong.setForeground(Color.WHITE);
		btnGUI_doiPhong.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGUI_doiPhong.setBackground(new Color(41, 139, 116));
		btnGUI_doiPhong.setBounds(980, 26, 200, 100);
		panel_top.add(btnGUI_doiPhong);
		
		btnGUI_GiahanPhong = new JButton("Gia hạn phòng");
		btnGUI_GiahanPhong.setForeground(Color.WHITE);
		btnGUI_GiahanPhong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGUI_GiahanPhong.setBackground(new Color(41, 139, 116));
		btnGUI_GiahanPhong.setBounds(1210, 26, 200, 100);
		panel_top.add(btnGUI_GiahanPhong);
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
		qldp = new GUI_QuanLiDatPhong();
		dp = new GUI_DatPhong(nv);
		np = new GUI_NhanPhong();
		tp = new GUI_TraPhong();
		doiPhong = new GUI_DoiPhong();
		giaHanPhong = new GUI_GiaHanPhong();
		ActionListener actionListener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JButton clickedButton = (JButton) e.getSource();
		        boolean isVisibleqldp = qldp.isVisible();
		        boolean isVisible = menuTK.isVisible();
		        boolean isVisibleDP = dp.isVisible();
		        boolean isVisibleNP = np.isVisible();
		        boolean isVisibleTP = tp.isVisible();
		        boolean isVisibleDPH = doiPhong.isVisible();
		        boolean isVisibleGHP = giaHanPhong.isVisible();
		        
		        if (clickedButton == btnTK && !isVisible) {
                    // Xử lý khi nhấn vào nút btnTK
                    menuTK.setVisible(true);
                } else if (clickedButton == btnTK && isVisible) {
                    // Xử lý khi nhấn vào nút btnXTT
                    menuTK.setVisible(false);
                }else if (clickedButton == btnGUI_datPhong && !isVisibleDP) {
                	menuTK.setVisible(false);
                	dp.setVisible(true);
                	np.setVisible(false);
                	tp.setVisible(false);
                	doiPhong.setVisible(false);
                	giaHanPhong.setVisible(false);
					if(GUI_MenuQL.qlp != null) {
						GUI_MenuQL.qlp.setVisible(false);
					} else if (GUI_MenuNV.qlp != null) {
						GUI_MenuNV.qlp.setVisible(false);
					}
					
                	
                	
                	btnGUI_datPhong.setForeground(new Color(0, 0, 0));
                	btnGUI_nhanPhong.setForeground(Color.WHITE);
                	btnGUI_TraPhong.setForeground(Color.WHITE);
                	btnGUI_doiPhong.setForeground(Color.WHITE);
                	btnGUI_GiahanPhong.setForeground(Color.WHITE);
                	btnGUI_datPhong.setBackground(new Color(164, 194, 163));
                	btnGUI_nhanPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_TraPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_doiPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_GiahanPhong.setBackground(new Color(41, 139, 116));
                }else if (clickedButton == btnGUI_datPhong && isVisibleDP) {
                	menuTK.setVisible(false);
                }else if (clickedButton == btnGUI_nhanPhong && !isVisibleNP) {
                	menuTK.setVisible(false);
                	np.setVisible(true);
                	dp.setVisible(false);
                	tp.setVisible(false);
                	doiPhong.setVisible(false);
                	giaHanPhong.setVisible(false);
                	if(GUI_MenuQL.qlp != null) {
						GUI_MenuQL.qlp.setVisible(false);
					} else if (GUI_MenuNV.qlp != null) {
						GUI_MenuNV.qlp.setVisible(false);
					}
                	
                	btnGUI_datPhong.setForeground(Color.WHITE);
                	btnGUI_nhanPhong.setForeground(new Color(0, 0, 0));
                	btnGUI_TraPhong.setForeground(Color.WHITE);
                	btnGUI_doiPhong.setForeground(Color.WHITE);
                	btnGUI_GiahanPhong.setForeground(Color.WHITE);
                	btnGUI_datPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_nhanPhong.setBackground(new Color(164, 194, 163));
                	btnGUI_TraPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_doiPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_GiahanPhong.setBackground(new Color(41, 139, 116));
                }else if (clickedButton == btnGUI_nhanPhong && isVisibleNP) {
                	menuTK.setVisible(false);
                }else if (clickedButton == btnGUI_TraPhong && !isVisibleTP) {
                	menuTK.setVisible(false);
                	tp.setVisible(true);
                	np.setVisible(false);
                	dp.setVisible(false);
                	doiPhong.setVisible(false);
                	giaHanPhong.setVisible(false);
                	if(GUI_MenuQL.qlp != null) {
						GUI_MenuQL.qlp.setVisible(false);
					} else if (GUI_MenuNV.qlp != null) {
						GUI_MenuNV.qlp.setVisible(false);
					}
                	
                	btnGUI_datPhong.setForeground(Color.WHITE);
                	btnGUI_nhanPhong.setForeground(Color.WHITE);
                	btnGUI_TraPhong.setForeground(new Color(0, 0, 0));
                	btnGUI_doiPhong.setForeground(Color.WHITE);
                	btnGUI_GiahanPhong.setForeground(Color.WHITE);
                	btnGUI_datPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_nhanPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_TraPhong.setBackground(new Color(164, 194, 163));
                	btnGUI_doiPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_GiahanPhong.setBackground(new Color(41, 139, 116));
                }else if (clickedButton == btnGUI_TraPhong && isVisibleTP) {
                	menuTK.setVisible(false);
                }else if (clickedButton == btnGUI_doiPhong && !isVisibleDPH) {
                	menuTK.setVisible(false);
                	doiPhong.setVisible(true);
                	np.setVisible(false);
                	tp.setVisible(false);
                	dp.setVisible(false);
                	giaHanPhong.setVisible(false);
                	if(GUI_MenuQL.qlp != null) {
						GUI_MenuQL.qlp.setVisible(false);
					} else if (GUI_MenuNV.qlp != null) {
						GUI_MenuNV.qlp.setVisible(false);
					}
                	
                	btnGUI_datPhong.setForeground(Color.WHITE);
                	btnGUI_nhanPhong.setForeground(Color.WHITE);
                	btnGUI_TraPhong.setForeground(Color.WHITE);
                	btnGUI_doiPhong.setForeground(new Color(0, 0, 0));
                	btnGUI_GiahanPhong.setForeground(Color.WHITE);
                	btnGUI_datPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_nhanPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_TraPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_doiPhong.setBackground(new Color(164, 194, 163));
                	btnGUI_GiahanPhong.setBackground(new Color(41, 139, 116));
                }else if (clickedButton == btnGUI_doiPhong && isVisibleDPH) {
                	menuTK.setVisible(false);
                }else if (clickedButton == btnGUI_GiahanPhong && !isVisibleGHP) {
                	menuTK.setVisible(false);
                	giaHanPhong.setVisible(true);
                	np.setVisible(false);
                	tp.setVisible(false);
                	doiPhong.setVisible(false);
                	dp.setVisible(false);
                	if(GUI_MenuQL.qlp != null) {
						GUI_MenuQL.qlp.setVisible(false);
					} else if (GUI_MenuNV.qlp != null) {
						GUI_MenuNV.qlp.setVisible(false);
					}
                	
                	btnGUI_datPhong.setForeground(Color.WHITE);
                	btnGUI_nhanPhong.setForeground(Color.WHITE);
                	btnGUI_TraPhong.setForeground(Color.WHITE);
                	btnGUI_doiPhong.setForeground(Color.WHITE);
                	btnGUI_GiahanPhong.setForeground(new Color(0, 0, 0));
                	btnGUI_datPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_nhanPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_TraPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_doiPhong.setBackground(new Color(41, 139, 116));
                	btnGUI_GiahanPhong.setBackground(new Color(164, 194, 163));
				} else if (clickedButton == btnGUI_GiahanPhong && isVisibleGHP) {
					menuTK.setVisible(false);
				}
		        
  
		    }
		};

		btnTK.addActionListener(actionListener);
		btnGUI_datPhong.addActionListener(actionListener);
		btnGUI_nhanPhong.addActionListener(actionListener);
		btnGUI_TraPhong.addActionListener(actionListener);
		btnGUI_doiPhong.addActionListener(actionListener);
		btnGUI_GiahanPhong.addActionListener(actionListener);
		
	}
}
