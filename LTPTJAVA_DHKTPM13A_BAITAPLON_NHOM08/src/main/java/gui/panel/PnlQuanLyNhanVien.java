package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import control.NhanVienControl;
import control.NhanVien_BacLuongControl;
import entities.NhanVien;
import entities.NhanVien_BacLuong;
import entities.TaiKhoan;
import utils.HintTextFieldUI;
import utils.TienIch;
import java.awt.SystemColor;

public class PnlQuanLyNhanVien extends JPanel implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private JTable tblDsNhanVien;
	private DefaultTableModel modelNhanVien;
	private JTextField txtTimKiem;
	private JLabel txtMaNV;
	private JTextField txtTenNV;

	private JTextField txtSoCMND;
	private JLabel txtMaPhongBan;

	private JLabel txtChucVu;
	private JFormattedTextField txtLuongCoBan;
	private JTextField txtEmail;
	private JTextField txtSDT;

	private JButton btnThem, btnSua;
	private JButton btnhuy;
	private JCheckBox ckbGioiTinh;
	private JDateChooser dtcNgSinh;
	private NhanVienControl nhanVienControl;
	private NhanVien_BacLuongControl nhanVien_BacLuong;

	private static List<NhanVien> dsNV;

	private JLabel txtPhongBan;
	private JLabel txtBacLuong;

	private NhanVien nv;
	private JButton btnLuuNV;

	private double luong = 0;

	/**
	 * Create the panel.
	 */
	public PnlQuanLyNhanVien(NhanVien nv) {
		this.nv = nv;
		setLayout(new BorderLayout(0, 0));
		setSize(1280, 720);

		JPanel pnlMain = new JPanel();
		add(pnlMain);
		pnlMain.setLayout(new BorderLayout(0, 0));

		JPanel pnlTieuDe = new JPanel();
		FlowLayout fl_pnlTieuDe = (FlowLayout) pnlTieuDe.getLayout();
		fl_pnlTieuDe.setVgap(15);
		pnlMain.add(pnlTieuDe, BorderLayout.NORTH);

		JLabel lblTieuDe = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 30));
		pnlTieuDe.add(lblTieuDe);

		JPanel pnlChiTietQL = new JPanel();
		pnlMain.add(pnlChiTietQL, BorderLayout.CENTER);
		pnlChiTietQL.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel pnlTTvaChucNangQL = new JPanel();
		pnlChiTietQL.add(pnlTTvaChucNangQL);
		pnlTTvaChucNangQL.setLayout(new BorderLayout(0, 0));

		JPanel pnlChucNang = new JPanel();
		pnlTTvaChucNangQL.add(pnlChucNang, BorderLayout.SOUTH);
		pnlChucNang.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pnlTimKiem = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlTimKiem.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlChucNang.add(pnlTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setPreferredSize(new Dimension(6, 30));
		pnlTimKiem.add(txtTimKiem);
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txtTimKiem.setColumns(20);

		JPanel pnlPhimCN = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlPhimCN.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnlChucNang.add(pnlPhimCN);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(PnlQuanLyNhanVien.class.getResource("/images/plus_32px.png")));
		pnlPhimCN.add(btnThem);
		btnThem.setFont(new Font("Dialog", Font.PLAIN, 17));

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(PnlQuanLyNhanVien.class.getResource("/images/pencil_tip_32px.png")));
		pnlPhimCN.add(btnSua);
		btnSua.setEnabled(false);
		btnSua.setFont(new Font("Dialog", Font.PLAIN, 17));

		btnLuuNV = new JButton("Lưu");
		btnLuuNV.setEnabled(false);
		btnLuuNV.setIcon(new ImageIcon(PnlQuanLyNhanVien.class.getResource("/images/save_32px.png")));
		btnLuuNV.setFont(new Font("Dialog", Font.PLAIN, 17));
		pnlPhimCN.add(btnLuuNV);

		btnhuy = new JButton("Hủy");
		btnhuy.setIcon(new ImageIcon(PnlQuanLyNhanVien.class.getResource("/images/cancel_2_32px.png")));
		pnlPhimCN.add(btnhuy);
		btnhuy.setEnabled(false);
		btnhuy.setFont(new Font("Dialog", Font.PLAIN, 17));

		JPanel pnlThongTinNV = new JPanel();
		pnlThongTinNV
				.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng tin nh\u00E2n vi\u00EAn",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTTvaChucNangQL.add(pnlThongTinNV, BorderLayout.CENTER);
		pnlThongTinNV.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel pnlThongTin_1 = new JPanel();
		pnlThongTinNV.add(pnlThongTin_1);
		pnlThongTin_1.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel pnlMaNV = new JPanel();
		FlowLayout fl_pnlMaNV = (FlowLayout) pnlMaNV.getLayout();
		fl_pnlMaNV.setAlignment(FlowLayout.LEFT);
		pnlThongTin_1.add(pnlMaNV);

		JLabel lblMaNV = new JLabel("Mã nhân viên :");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlMaNV.add(lblMaNV);

		txtMaNV = new JLabel();
		txtMaNV.setBorder(new LineBorder(Color.BLACK));
		txtMaNV.setPreferredSize(new Dimension(150, 30));
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlMaNV.add(txtMaNV);

		JPanel pnlTenNV = new JPanel();
		FlowLayout fl_pnlTenNV = (FlowLayout) pnlTenNV.getLayout();
		fl_pnlTenNV.setAlignment(FlowLayout.LEFT);
		pnlThongTin_1.add(pnlTenNV);

		JLabel lblTenNhanVien = new JLabel("Tên nhân viên  :");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTenNV.add(lblTenNhanVien);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setColumns(15);
		pnlTenNV.add(txtTenNV);

		JPanel pnlNgaySinh = new JPanel();
		FlowLayout fl_pnlNgaySinh = (FlowLayout) pnlNgaySinh.getLayout();
		fl_pnlNgaySinh.setAlignment(FlowLayout.LEFT);
		pnlThongTin_1.add(pnlNgaySinh);

		JLabel lblNgaySinh = new JLabel("Ngày sinh  :");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlNgaySinh.add(lblNgaySinh);

		JPanel pnlThongTin_2 = new JPanel();
		pnlThongTinNV.add(pnlThongTin_2);
		pnlThongTin_2.setLayout(new GridLayout(0, 3, 0, 0));

		dtcNgSinh = new JDateChooser();
		((JTextComponent) dtcNgSinh.getDateEditor().getUiComponent()).setEditable(false);
		dtcNgSinh.setPreferredSize(new Dimension(200, 30));
		dtcNgSinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dtcNgSinh.setDateFormatString("dd/MM/yyyy");
		pnlNgaySinh.add(dtcNgSinh);

		JPanel pnlMaPhongBan = new JPanel();
		FlowLayout fl_pnlMaPhongBan = (FlowLayout) pnlMaPhongBan.getLayout();
		fl_pnlMaPhongBan.setAlignment(FlowLayout.LEFT);
		pnlThongTin_2.add(pnlMaPhongBan);

		JLabel lblMaPhongBan = new JLabel("Mã phòng ban  :");
		lblMaPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlMaPhongBan.add(lblMaPhongBan);

		txtMaPhongBan = new JLabel();
		txtMaPhongBan.setPreferredSize(new Dimension(120, 30));
		txtMaPhongBan.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMaPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlMaPhongBan.add(txtMaPhongBan);

		JPanel pnlPhongBan = new JPanel();
		FlowLayout fl_pnlPhongBan = (FlowLayout) pnlPhongBan.getLayout();
		fl_pnlPhongBan.setAlignment(FlowLayout.LEFT);
		pnlThongTin_2.add(pnlPhongBan);

		JLabel lblTenPhongBan = new JLabel("Phòng ban :");
		lblTenPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlPhongBan.add(lblTenPhongBan);

		txtPhongBan = new JLabel();
		txtPhongBan.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPhongBan.setPreferredSize(new Dimension(200, 30));
		txtPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlPhongBan.add(txtPhongBan);

		JPanel panel_17 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_17.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);

		pnlThongTin_2.add(panel_17);

		JLabel lblSoCMND = new JLabel("Số CMND :");
		lblSoCMND.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_17.add(lblSoCMND);

		txtSoCMND = new JTextField();
		txtSoCMND.setEditable(false);
		txtSoCMND.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoCMND.setColumns(15);
		panel_17.add(txtSoCMND);

		JPanel pnlThongTin_3 = new JPanel();
		pnlThongTinNV.add(pnlThongTin_3);
		pnlThongTin_3.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel pnlChucVu = new JPanel();
		FlowLayout fl_pnlChucVu = (FlowLayout) pnlChucVu.getLayout();
		fl_pnlChucVu.setAlignment(FlowLayout.LEFT);
		pnlThongTin_3.add(pnlChucVu);

		JLabel lblChucVu = new JLabel("Chức vụ  :");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));

		pnlChucVu.add(lblChucVu);

		txtChucVu = new JLabel();
		txtChucVu.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtChucVu.setPreferredSize(new Dimension(150, 30));
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));

		pnlChucVu.add(txtChucVu);

		JPanel pnlBacLuong = new JPanel();
		FlowLayout fl_pnlBacLuong = (FlowLayout) pnlBacLuong.getLayout();
		fl_pnlBacLuong.setAlignment(FlowLayout.LEFT);
		pnlThongTin_3.add(pnlBacLuong);

		JLabel lblBcLng = new JLabel("Hệ số lương  :");
		lblBcLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlBacLuong.add(lblBcLng);

		txtBacLuong = new JLabel();
		txtBacLuong.setPreferredSize(new Dimension(100, 30));
		txtBacLuong.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtBacLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlBacLuong.add(txtBacLuong);

		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_20.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);

		pnlThongTin_3.add(panel_20);

		JLabel lblLuongCoBan = new JLabel("Lương cơ bản :");
		lblLuongCoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_20.add(lblLuongCoBan);

		Format curr = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		txtLuongCoBan = new JFormattedTextField(curr);
		txtLuongCoBan.addPropertyChangeListener("value", this);
		txtLuongCoBan.setValue(luong);
		txtLuongCoBan.setEditable(false);
		txtLuongCoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLuongCoBan.setColumns(15);
		panel_20.add(txtLuongCoBan);

		JPanel pnlThongTin_4 = new JPanel();
		pnlThongTinNV.add(pnlThongTin_4);
		pnlThongTin_4.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel pnlEmail = new JPanel();
		FlowLayout fl_pnlEmail = (FlowLayout) pnlEmail.getLayout();
		fl_pnlEmail.setAlignment(FlowLayout.LEFT);
		pnlThongTin_4.add(pnlEmail);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlEmail.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtEmail.setColumns(15);

		pnlEmail.add(txtEmail);

		JPanel pnlSdt = new JPanel();
		FlowLayout fl_pnlSdt = (FlowLayout) pnlSdt.getLayout();
		fl_pnlSdt.setAlignment(FlowLayout.LEFT);
		pnlThongTin_4.add(pnlSdt);

		JLabel lblSDT = new JLabel("Số điện thoại  :");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlSdt.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(15);
		pnlSdt.add(txtSDT);

		JPanel pnlGioiTinh = new JPanel();
		FlowLayout fl_pnlGioiTinh = (FlowLayout) pnlGioiTinh.getLayout();
		fl_pnlGioiTinh.setAlignment(FlowLayout.LEFT);
		pnlThongTin_4.add(pnlGioiTinh);

		ckbGioiTinh = new JCheckBox("Nam");
		ckbGioiTinh.setEnabled(false);
		ckbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlGioiTinh.add(ckbGioiTinh);

		JPanel pnlDsNV = new JPanel();
		pnlDsNV.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh s\u00E1ch nh\u00E2n vi\u00EAn",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChiTietQL.add(pnlDsNV);
		pnlDsNV.setLayout(new BorderLayout(0, 0));

		JScrollPane scrDsNhanVien = new JScrollPane();
		pnlDsNV.add(scrDsNhanVien);

		String[] header = { "Mã NV", "Họ tên", "Ngày sinh", "Số CMND", "Email", "Số điện thoại", "Phòng ban", "Chức vụ",
				"Lương cơ bản" };
		modelNhanVien = new DefaultTableModel(header, 0);
		tblDsNhanVien = new JTable(modelNhanVien) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};
		tblDsNhanVien.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		tblDsNhanVien.getColumnModel().getColumn(8).setCellRenderer(new MoneyRenderer());
		tblDsNhanVien.setFillsViewportHeight(true);
		tblDsNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDsNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrDsNhanVien.setViewportView(tblDsNhanVien);
		tblDsNhanVien.setRowHeight(25);

		lblMaNV.setPreferredSize(lblMaPhongBan.getPreferredSize());
		lblChucVu.setPreferredSize(lblMaPhongBan.getPreferredSize());
		lblEmail.setPreferredSize(lblMaPhongBan.getPreferredSize());

		lblTenPhongBan.setPreferredSize(lblTenNhanVien.getPreferredSize());
		lblChucVu.setPreferredSize(lblTenNhanVien.getPreferredSize());
		lblSDT.setPreferredSize(lblTenNhanVien.getPreferredSize());

		lblNgaySinh.setPreferredSize(lblLuongCoBan.getPreferredSize());
		lblSoCMND.setPreferredSize(lblLuongCoBan.getPreferredSize());
		lblBcLng.setPreferredSize(lblTenPhongBan.getPreferredSize());

		try {
			nhanVienControl = (NhanVienControl) Naming.lookup("rmi://localhost:1099/nhanvien");
			nhanVien_BacLuong = (NhanVien_BacLuongControl) Naming.lookup("rmi://localhost:1099/chitietluong");
			dsNV = nhanVienControl.layDanhSachNhanVienTheoPhongBan(nv.getPhongBan().getMaPB());
		} catch (Exception e) {
			e.printStackTrace();
		}

		ganSuKien();
		hienThiDsNhanVien(dsNV);

		TienIch.chinhKichThuocTitleTrenBorder(new JPanel[] { pnlThongTinNV, pnlDsNV }, "arial", Font.PLAIN, 20);

		txtTimKiem.setUI(new HintTextFieldUI("Nhập tên nhân viên...", true));

	}

	private void ganSuKien() {
		btnThem.addActionListener(this);
		btnhuy.addActionListener(this);
		btnLuuNV.addActionListener(this);
		tblDsNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tblDsNhanVien.getSelectedRow();
				if (row == -1)
					return;
				String maNV = (String) tblDsNhanVien.getValueAt(row, 0);

				hienThiChiTietThongTinNhanVien(maNV);
				btnThem.setEnabled(false);
				TienIch.hienAnCacControl(true, btnhuy, btnSua);

			}
		});
		btnSua.addActionListener(this);

		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String con = TienIch.chuyenChuoiTiengVietThanhChuoiKhongDau(txtTimKiem.getText().trim().toLowerCase());
				List<NhanVien> dsNVLoc = new ArrayList<NhanVien>();
				dsNV.forEach(x -> {
					String ten = TienIch.chuyenChuoiTiengVietThanhChuoiKhongDau(x.getHoVaTen().trim().toLowerCase());
					if (ten.contains(con)) {
						dsNVLoc.add(x);
					}
				});
				if (dsNVLoc.size() != 0) {
					hienThiDsNhanVien(dsNVLoc);
				} else {
					hienThiDsNhanVien(dsNV);
				}
			}
		});

	}

	/**
	 * Hiện thị chi tiết thông tin nhân viên
	 * 
	 * @param row
	 */
	private void hienThiChiTietThongTinNhanVien(String ma) {
		try {
			NhanVien nv = nhanVienControl.layNhanVienTheoMa(ma);
			txtMaNV.setText(nv.getMaNV());
			txtTenNV.setText(nv.getHoVaTen());
			txtSoCMND.setText(nv.getSoCMND());
			txtChucVu.setText("Nhân viên");

			txtLuongCoBan.setValue(nv.getLuongCoBan());
			txtEmail.setText(nv.getEmail());
			dtcNgSinh.setDate(java.sql.Date.valueOf(nv.getNgaySinh()));
			txtSDT.setText(nv.getSoDienThoai());
			ckbGioiTinh.setSelected(nv.isGioiTinh());
			txtMaPhongBan.setText(nv.getPhongBan().getMaPB().trim());
			txtPhongBan.setText(nv.getPhongBan().getTenPB().trim());

			double heSo = 0.0;
			NhanVien_BacLuong bacLuong = nhanVien_BacLuong.layChiTietLuongTheoIdNV(nv.getId());
			if (bacLuong != null) {
				heSo = bacLuong.getBacLuong().getHeSo();
			}
			txtBacLuong.setText(heSo + "");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hiện danh sách nhân viên theo phòng ban
	 * 
	 * @param dsnv
	 */
	private void hienThiDsNhanVien(List<NhanVien> dsnv) {
		modelNhanVien.setRowCount(0);
		int i = 1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (NhanVien nhanVien : dsnv) {
			if (nhanVien.getTaiKhoan().getQuyen() == 1) {
				modelNhanVien.addRow(new Object[] { nhanVien.getMaNV(), nhanVien.getHoVaTen(),
						nhanVien.getNgaySinh().format(dtf), nhanVien.getSoCMND(), nhanVien.getEmail(),
						nhanVien.getSoDienThoai(), nhanVien.getPhongBan(), "Nhân viên", nhanVien.getLuongCoBan() });
				i++;
			}

		}

		tblDsNhanVien.setModel(modelNhanVien);

	}

	public void actionPerformed(ActionEvent e) {

		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "mypolicy\\policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		// TODO Auto-generated method stub
		Object o = e.getSource();
		// Chuc nang them
		if (o.equals(btnThem)) {
			xoaTrang();
			btnThem.setEnabled(false);
			dtcNgSinh.setEnabled(true);
			ckbGioiTinh.setEnabled(true);
			tblDsNhanVien.setEnabled(false);
			try {
				txtMaNV.setText(nhanVienControl.phatSinhMaNhanVien());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			TienIch.hienAnCacControl(true, txtTenNV, txtSoCMND, txtChucVu, txtSDT, txtEmail, btnLuuNV, btnhuy,
					dtcNgSinh, txtLuongCoBan);
			txtMaPhongBan.setText(nv.getPhongBan().getMaPB().trim());
			txtPhongBan.setText(nv.getPhongBan().getTenPB().trim());

			txtChucVu.setText("Nhân viên");
			dtcNgSinh.setDate(new java.util.Date());
			txtTenNV.requestFocus();

		} else if (o.equals(btnSua)) {
			TienIch.hienAnCacControl(true, txtTenNV, txtLuongCoBan, txtEmail, txtSDT, txtLuongCoBan, dtcNgSinh,
					txtSoCMND, btnLuuNV, btnhuy);
			TienIch.hienAnCacControl(false, btnSua, btnThem);
			txtTenNV.requestFocus();
			tblDsNhanVien.setEnabled(false);
		} else if (o.equals(btnhuy)) {
			xoaTrang();
			TienIch.hienAnCacControl(false, btnSua, btnLuuNV, btnhuy, txtTenNV, txtSoCMND, txtLuongCoBan, txtEmail,
					txtSDT);
			btnThem.setEnabled(true);
			tblDsNhanVien.setEnabled(true);
		} else if (o.equals(btnLuuNV)) {
			if (kiemTraNhapTTNV()) {
				try {

					tblDsNhanVien.setEnabled(true);
					NhanVien nhanvien = new NhanVien();
					nhanvien.setMaNV(txtMaNV.getText());
					nhanvien.setHoVaTen(txtTenNV.getText());
					nhanvien.setSoCMND(txtSoCMND.getText());
					nhanvien.setEmail(txtEmail.getText());
					nhanvien.setSoDienThoai(txtSDT.getText());
					nhanvien.setGioiTinh(ckbGioiTinh.isSelected());
					nhanvien.setNgaySinh(new Date(dtcNgSinh.getDate().getTime()).toLocalDate());

					double tien = ((Number) txtLuongCoBan.getValue()).doubleValue();
					nhanvien.setLuongCoBan(tien);

					nhanvien.setPhongBan(nv.getPhongBan());
					if (!dsNV.contains(nhanvien)) {

						nhanvien.setTaiKhoan(new TaiKhoan("", "", 1));
						NhanVien nvThem = nhanVienControl.themNhanVien(nhanvien);
						if (nvThem != null) {
							hienThiDsNhanVien(
									nhanVienControl.layDanhSachNhanVienTheoPhongBan(nv.getPhongBan().getMaPB()));
							xoaTrang();
						}

					} else {
						int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận cập nhật Nhân viên ?", "Câp nhật",
								JOptionPane.YES_OPTION);
						if (confirm == JOptionPane.YES_OPTION) {
							NhanVien nvCu = dsNV.get(dsNV.indexOf(nhanvien));
							nhanvien.setTaiKhoan(nvCu.getTaiKhoan());
							nhanvien.setId(nvCu.getId());
							NhanVien nvSua = nhanVienControl.suaNhanVien(nhanvien);
							if (nvSua != null) {
								hienThiDsNhanVien(
										nhanVienControl.layDanhSachNhanVienTheoPhongBan(nv.getPhongBan().getMaPB()));
							}
						}

					}

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(this, "Lỗi phía máy chủ: " + e2.getMessage());
				}
				btnLuuNV.setEnabled(false);
				TienIch.hienAnCacControl(false, txtMaNV, txtTenNV, txtSoCMND, txtChucVu, txtSDT, txtEmail, btnhuy,
						dtcNgSinh, txtLuongCoBan, btnSua);
				btnThem.setEnabled(true);
			}

		}

	}

	// Xoá trắng
	public void xoaTrang() {
		TienIch.xoaTrangCacJTextField(txtTenNV, txtSoCMND, txtEmail, txtSDT, txtLuongCoBan);
		txtBacLuong.setText("");
		txtMaNV.setText("");
		txtMaPhongBan.setText("");
		txtBacLuong.setText("");
		txtMaNV.setText("");
		txtPhongBan.setText("");
		txtLuongCoBan.setValue(0);
		dtcNgSinh.setDate(new java.util.Date(System.currentTimeMillis()));
		txtMaNV.requestFocus();
		ckbGioiTinh.setSelected(false);
	}

	public boolean kiemTraNhapTTNV() {
		String maNV = txtMaNV.getText().trim();
		String tenNV = TienIch.chuyenChuoiTiengVietThanhChuoiKhongDau(txtTenNV.getText().trim());
		String luong = txtLuongCoBan.getText().trim();
		String sDT = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		String cMND = txtSoCMND.getText().trim();

		if (maNV.length() == 0 || tenNV.length() == 0 || luong.length() == 0 || sDT.length() == 0 || email.length() == 0
				|| cMND.length() == 0) {
			if (tenNV.length() == 0) {
				JOptionPane.showMessageDialog(this, "Tên nhân viên không được rỗng!");
				txtTenNV.requestFocus();
				txtTenNV.selectAll();
				return false;
			}

			if (cMND.length() == 0) {
				JOptionPane.showMessageDialog(this, "Chứng minh nhân dân không được rỗng!");
				txtSoCMND.requestFocus();
				txtSoCMND.selectAll();
				return false;
			}

			if (luong.length() == 0) {
				JOptionPane.showMessageDialog(this, "Lương không được rỗng!");
				txtLuongCoBan.requestFocus();
				txtLuongCoBan.selectAll();
				return false;
			}
			if (email.length() == 0) {
				JOptionPane.showMessageDialog(this, "Email không được rỗng!");
				txtEmail.requestFocus();
				txtEmail.selectAll();
				return false;
			}
			if (sDT.length() == 0) {
				JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng!");
				txtSDT.requestFocus();
				txtSDT.selectAll();
				return false;
			}

		}

		if (!(tenNV.matches("[A-Za-z ]+"))) {
			JOptionPane.showMessageDialog(this, "Tên nhân viên không chứa ký tự số và ký tự đặc biệt!");
			txtTenNV.requestFocus();
			txtTenNV.selectAll();
			return false;
		}
		if (!(cMND.matches("[0-9]{9}"))) {
			JOptionPane.showMessageDialog(null, "Chứng minh nhân dân bao gồm 9 ký tự số!");
			txtSoCMND.requestFocus();
			txtSoCMND.selectAll();
			return false;
		}

		double tien = ((Number) txtLuongCoBan.getValue()).doubleValue();
		if (tien < 1000000) {
			JOptionPane.showMessageDialog(null, "Lương cơ bản phải lớn hơn 1.000.000 đ!");
			txtLuongCoBan.requestFocus();
			txtLuongCoBan.selectAll();
			return false;
		}

		if (!(email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))) {
			JOptionPane.showMessageDialog(null, "Email phải theo định dạng xxx@xmail.com/vn/net");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}
		if (!(sDT.matches("[0-9]{10,11}"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại gồm 10 đến 11 ký tự số!");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}

		return true;
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		Object o = e.getSource();
		if (o.equals(txtLuongCoBan)) {
			luong = ((Number) txtLuongCoBan.getValue()).doubleValue();
		}

	}

	/**
	 * Lớp định dạng cho bảng
	 * 
	 * @author NMC
	 *
	 */

	private class MoneyRenderer extends DefaultTableCellRenderer {
		public MoneyRenderer() {
			this.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		@Override
		protected void setValue(Object o) {

			DecimalFormat df = new DecimalFormat("#,###");
			o = df.format(o);
			super.setValue(o);
		}

	}

}
