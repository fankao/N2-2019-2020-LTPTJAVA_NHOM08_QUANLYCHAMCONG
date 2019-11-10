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
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JMonthChooser;

import control.ChiTietChamCongControl;
import control.NhanVienControl;
import control.NhanVien_BacLuongControl;
import entities.NhanVien;
import entities.NhanVien_BacLuong;
import utils.HintTextFieldUI;
import utils.TienIch;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class PnlQuanLyBangLuong extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTimTen;
	private JTable tblBangLuong;
	private DefaultTableModel modelBangluong;
	private ChiTietChamCongControl chiTietChamCongControl;
	private NhanVienControl nvControl;

	private JMonthChooser mtcChonThang;

	private static List<NhanVien> dsNhanVien;
	private JButton btnTim;

	public PnlQuanLyBangLuong() {
		setSize(1318, 720);
		setLayout(new BorderLayout(0, 0));

		JPanel pnTieuDe = new JPanel();
		add(pnTieuDe, BorderLayout.NORTH);

		JLabel lblTieuDe = new JLabel("BẢNG LƯƠNG");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 30));

		GroupLayout gl_pnTieuDe = new GroupLayout(pnTieuDe);
		gl_pnTieuDe.setHorizontalGroup(
			gl_pnTieuDe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTieuDe.createSequentialGroup()
					.addGap(555)
					.addComponent(lblTieuDe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(554))
		);
		gl_pnTieuDe.setVerticalGroup(
			gl_pnTieuDe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTieuDe.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTieuDe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnTieuDe.setLayout(new BorderLayout(0, 0));
		pnTieuDe.setLayout(gl_pnTieuDe);

		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BorderLayout(0, 0));

		JPanel pnlChucNang = new JPanel();
		pnCenter.add(pnlChucNang, BorderLayout.NORTH);
		pnlChucNang.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel pnTimKiemNhanVien = new JPanel();
		pnlChucNang.add(pnTimKiemNhanVien);

		txtTimTen = new JTextField();
		txtTimTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimTen.setColumns(20);

		JPanel pnlTimKiemTheoThang = new JPanel();
		pnlChucNang.add(pnlTimKiemTheoThang);

		JLabel lblThang = new JLabel("Chọn tháng:");
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));

		mtcChonThang = new JMonthChooser();
		mtcChonThang.getSpinner().setPreferredSize(new Dimension(200, 20));
		mtcChonThang.getComboBox().setPreferredSize(new Dimension(150, 40));
		mtcChonThang.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 20));
		mtcChonThang.setLocale(new Locale("vi"));

		JLabel lblNgayHienTai = new JLabel("");
		lblNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GroupLayout gl_pnlTimKiemTheoThang = new GroupLayout(pnlTimKiemTheoThang);
		gl_pnlTimKiemTheoThang.setHorizontalGroup(gl_pnlTimKiemTheoThang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlTimKiemTheoThang.createSequentialGroup().addContainerGap().addComponent(lblNgayHienTai)
						.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE).addComponent(lblThang)
						.addGap(18).addComponent(mtcChonThang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_pnlTimKiemTheoThang.setVerticalGroup(gl_pnlTimKiemTheoThang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTimKiemTheoThang.createSequentialGroup().addGap(12)
						.addGroup(gl_pnlTimKiemTheoThang.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlTimKiemTheoThang.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblThang, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNgayHienTai))
								.addComponent(mtcChonThang, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(14, Short.MAX_VALUE)));
		pnlTimKiemTheoThang.setLayout(gl_pnlTimKiemTheoThang);

		JPanel pnlBangLuong = new JPanel();
		pnlBangLuong.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3),
				"B\u1EA3ng th\u00F4ng tin l\u01B0\u01A1ng nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		pnCenter.add(pnlBangLuong, BorderLayout.CENTER);
		pnlBangLuong.setLayout(new BorderLayout(0, 0));

		JScrollPane scrBangLuong = new JScrollPane();
		pnlBangLuong.add(scrBangLuong, BorderLayout.CENTER);

		String[] headers = new String[] { "STT", "Mã nhân viên", "H\u1ECC V\u00C0 T\u00CAN", "CH\u1EE8C V\u1EE4",
				"PH\u00D2NG BAN", "S\u1ED0 NG\u00C0Y CH\u1EA4M C\u00D4NG", "S\u1ED0 NG\u00C0Y NGH\u1EC8",
				"B\u1EACC L\u01AF\u01A0NG", "L\u01AF\u01A0NG C\u01A0 B\u1EA2N", "T\u1ED4NG TI\u1EC0N L\u01AF\u01A0NG" };
		modelBangluong = new DefaultTableModel(headers, 0);
		tblBangLuong = new JTable(modelBangluong) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};
		tblBangLuong.setFillsViewportHeight(true);
		tblBangLuong.setRowHeight(25);
		tblBangLuong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblBangLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrBangLuong.setViewportView(tblBangLuong);

		tblBangLuong.getColumnModel().getColumn(0).setPreferredWidth(48);
		tblBangLuong.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblBangLuong.getColumnModel().getColumn(2).setPreferredWidth(95);
		tblBangLuong.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblBangLuong.getColumnModel().getColumn(4).setPreferredWidth(122);
		tblBangLuong.getColumnModel().getColumn(5).setPreferredWidth(90);
		tblBangLuong.getColumnModel().getColumn(7).setPreferredWidth(110);
		tblBangLuong.getColumnModel().getColumn(9).setPreferredWidth(120);

		tblBangLuong.getColumnModel().getColumn(8).setCellRenderer(new MoneyRenderer());
		tblBangLuong.getColumnModel().getColumn(9).setCellRenderer(new MoneyRenderer());

		JPanel pnlCN = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlCN.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		pnlBangLuong.add(pnlCN, BorderLayout.NORTH);

		btnTim = new JButton("Lọc theo tháng");

		btnTim.setIcon(new ImageIcon(PnlQuanLyBangLuong.class.getResource("/images/filter_32px.png")));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlCN.add(btnTim);

		try {

			chiTietChamCongControl = (ChiTietChamCongControl) Naming.lookup("rmi://localhost:1099/chitietchamcong");
			nvControl = (NhanVienControl) Naming.lookup("rmi://localhost:1099/nhanvien");
			dsNhanVien = nvControl.layDanhSachNhanVien();

		} catch (Exception e) {
			e.printStackTrace();
		}

		txtTimTen.setUI(new HintTextFieldUI("Nhập tên nhân viên cần tìm"));
		GroupLayout gl_pnTimKiemNhanVien = new GroupLayout(pnTimKiemNhanVien);
		gl_pnTimKiemNhanVien.setHorizontalGroup(gl_pnTimKiemNhanVien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTimKiemNhanVien
						.createSequentialGroup().addGap(5).addComponent(txtTimTen, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(189, Short.MAX_VALUE)));
		gl_pnTimKiemNhanVien.setVerticalGroup(gl_pnTimKiemNhanVien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTimKiemNhanVien.createSequentialGroup().addContainerGap()
						.addComponent(txtTimTen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnTimKiemNhanVien.setLayout(gl_pnTimKiemNhanVien);

		if (LocalDate.now().getDayOfMonth() == 26) {
			hienThiDanhSachNhanVien(dsNhanVien, mtcChonThang.getMonth() + 1);
		} else {
			JLabel lblNo = new JLabel("Hiện chưa đến ngày tính lương");
			lblNo.setFont(new Font("arial", Font.PLAIN, 25));

		}

		/*
		 * Xử lý sự kiện tìm kiếm
		 */
		txtTimTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String con = TienIch.chuyenChuoiTiengVietThanhChuoiKhongDau(txtTimTen.getText().trim().toLowerCase());
				List<NhanVien> dsNVLoc = new ArrayList<NhanVien>();
				dsNhanVien.forEach(x -> {
					String ten = TienIch.chuyenChuoiTiengVietThanhChuoiKhongDau(x.getHoVaTen().trim().toLowerCase());
					if (ten.contains(con)) {
						dsNVLoc.add(x);
					}
				});
				if (dsNVLoc.size() != 0) {
					hienThiDanhSachNhanVien(dsNVLoc, mtcChonThang.getMonth() + 1);
				} else {
					hienThiDanhSachNhanVien(dsNhanVien, mtcChonThang.getMonth() + 1);
				}
			}
		});

		TienIch.chinhKichThuocTitleTrenBorder(new JPanel[] { pnlBangLuong }, "arial", Font.PLAIN, 20);

		lblNgayHienTai.setText("Ngày thứ: " + LocalDate.now().getDayOfMonth() + " /26");
		hienThiDanhSachNhanVien(dsNhanVien, LocalDate.now().getMonthValue());

		btnTim.addActionListener(this);
	}

	private void hienThiDanhSachNhanVien(List<NhanVien> dsctcc, int thang) {
		modelBangluong.setRowCount(0);
		int i = 1;
		String cv = "";
		try {
			NhanVien_BacLuongControl nvbcControl = (NhanVien_BacLuongControl) Naming
					.lookup("rmi://localhost:1099/chitietluong");
			for (NhanVien nv : dsctcc) {
				if (nv.getTaiKhoan().getQuyen() != 3) {
					NhanVien_BacLuong nhanVien_BacLuong = nvbcControl.layChiTietLuongTheoIdNV(nv.getId());
					double heSo = 0.0;
					if (nhanVien_BacLuong != null) {
						heSo = nhanVien_BacLuong.getBacLuong().getHeSo();
					}
					cv = nv.getTaiKhoan().getQuyen() == 1 ? "Nhân Viên" : "Trưởng phòng";
					int soNgayChamCong = chiTietChamCongControl.tinhNgayDaChamCongTheoThang(nv, thang);
					int soNgayNghi = chiTietChamCongControl.tinhNgayNghiTheoThang(nv, thang);
					double luong = nv.getLuongCoBan() / 26 * soNgayChamCong;

					modelBangluong.addRow(new Object[] { i++,nv.getMaNV(), nv.getHoVaTen(), cv, nv.getPhongBan(), soNgayChamCong,
							soNgayNghi, heSo, nv.getLuongCoBan(), luong });

				}
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			try {
				dsNhanVien = nvControl.layDanhSachNhanVien();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			hienThiDanhSachNhanVien(dsNhanVien, mtcChonThang.getMonth() + 1);
			txtTimTen.setEditable(true);

		}

	}

	/**
	 * Lớp định dạng cho bảng
	 * 
	 * @author NMC
	 *
	 */

	private class MoneyRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;

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
