package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import control.ChiTietChamCongControl;
import control.NhanVienControl;
import control.PhongBanControl;
import entities.ChiTietChamCong;
import entities.NhanVien;
import entities.PhongBan;

import utils.TienIch;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PnlBangChamCong extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<PhongBan> comboBox;
	private JTable tblDSChamCong;
	private DefaultTableModel tblModel;
	private ChiTietChamCongControl chiTietChamCongControl;
	private PhongBanControl phongbanControl;
	private static List<PhongBan> dsPb;
	private DefaultComboBoxModel<PhongBan> modelPhongban;

	private static List<ChiTietChamCong> dsCTChamCong;
	private JDateChooser dtcNgayChamCong;
	private JButton btnCapNhat;

	public PnlBangChamCong() {
		setSize(1080, 720);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBorder(new EmptyBorder(5, 0, 5, 0));
		add(pnlTieuDe, BorderLayout.NORTH);

		JLabel lblTieuDe = new JLabel("BẢNG CHẤM CÔNG NHÂN VIÊN");
		lblTieuDe.setBorder(null);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 30));
		pnlTieuDe.add(lblTieuDe);

		JPanel pnContent = new JPanel();
		add(pnContent, BorderLayout.CENTER);
		pnContent.setLayout(new BorderLayout(0, 0));

		JPanel pnlBangChamCong = new JPanel();
		pnlBangChamCong.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3),
				"B\u1EA3ng th\u00F4ng tin ch\u1EA5m c\u00F4ng c\u1EE7a t\u1EA5t c\u1EA3 nh\u00E2n vi\u00EAn",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pnContent.add(pnlBangChamCong, BorderLayout.CENTER);
		pnlBangChamCong.setLayout(new BorderLayout(0, 0));

		JPanel pnlChucNang = new JPanel();
		pnContent.add(pnlChucNang, BorderLayout.NORTH);
		pnlChucNang.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pnlTimKiem = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlTimKiem.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlChucNang.add(pnlTimKiem);

		modelPhongban = new DefaultComboBoxModel<PhongBan>();
		
		JLabel lblPhongBan = new JLabel("Phòng ban:");
		lblPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTimKiem.add(lblPhongBan);
		comboBox = new JComboBox<PhongBan>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTimKiem.add(comboBox);

		JPanel pnlPhimCN = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlPhimCN.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		pnlChucNang.add(pnlPhimCN);

		JLabel lblNgayLamViec = new JLabel("Ngày làm việc:");
		lblNgayLamViec.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlPhimCN.add(lblNgayLamViec);

		dtcNgayChamCong = new JDateChooser();
		dtcNgayChamCong.setLocale(new Locale("vi", "VN"));
		dtcNgayChamCong.setPreferredSize(new Dimension(200, 35));
		dtcNgayChamCong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dtcNgayChamCong.setDateFormatString("dd/MM/yyyy");
		dtcNgayChamCong.setDate(java.sql.Date.valueOf(LocalDate.now()));
		pnlPhimCN.add(dtcNgayChamCong);

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String[] tieuDe = { "STT", "Mã nhân viên", "Họ và tên", "Phòng ban", "Chức vụ", "Trạng thái" };
		tblModel = new DefaultTableModel(tieuDe, 0);
		tblDSChamCong = new JTable(tblModel) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		pnlBangChamCong.add(new JScrollPane(tblDSChamCong));

		tblDSChamCong.setAutoscrolls(true);
		tblDSChamCong.getTableHeader().setFont(new Font("arial", Font.BOLD, 18));
		tblDSChamCong.setRowHeight(30);
		tblDSChamCong.setFont(new Font("arial", Font.PLAIN, 20));

		JPanel pnlLamMoi = new JPanel();
		FlowLayout fl_pnlLamMoi = (FlowLayout) pnlLamMoi.getLayout();
		fl_pnlLamMoi.setAlignment(FlowLayout.RIGHT);
		pnlBangChamCong.add(pnlLamMoi, BorderLayout.NORTH);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon(PnlBangChamCong.class.getResource("/images/synchronize_32px.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCapNhat.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlLamMoi.add(btnCapNhat);
		dangKySuKien();

		try {
			chiTietChamCongControl = (ChiTietChamCongControl) Naming.lookup("rmi://localhost:1099/chitietchamcong");
			phongbanControl = (PhongBanControl) Naming.lookup("rmi://localhost:1099/phongban");

			dsPb = phongbanControl.laydsPhongBan();
			hienThiCMBPhongBan(dsPb);
			dsCTChamCong = chiTietChamCongControl.layDSCTNhanVienChamTheoNgay(
					((PhongBan) comboBox.getSelectedItem()).getMaPB(),
					new Date(dtcNgayChamCong.getDate().getTime()).toLocalDate());
		} catch (Exception e) {
			e.printStackTrace();
		}

		((JTextComponent) dtcNgayChamCong.getDateEditor().getUiComponent()).setEditable(false);

		comboBox.setSelectedIndex(0);
		TienIch.chinhKichThuocTitleTrenBorder(new JPanel[] { pnlBangChamCong }, "arial", Font.PLAIN, 20);

		hienThiDsChamCong(dsCTChamCong);

	}

	private void dangKySuKien() {
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String ngay = ((JTextComponent) dtcNgayChamCong.getDateEditor().getUiComponent()).getText();
					LocalDate date = LocalDate.parse(ngay, dft);

					String mapb = ((PhongBan) comboBox.getSelectedItem()).getMaPB();
					dsCTChamCong = chiTietChamCongControl.layDSCTNhanVienChamTheoNgay(mapb, date);
					hienThiDsChamCong(dsCTChamCong);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi SERVER: " + e2.getMessage(), "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCapNhat.addActionListener(this);

	}

	private void hienThiDsChamCong(List<ChiTietChamCong> dsCTCC) {
		String chucVu = "";
		String trangthai = "";
		int i = 1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		tblModel.setRowCount(0);
		// System.out.println(dsCTCC);
		for (ChiTietChamCong ctcc : dsCTCC) {
			if (ctcc.getNhanVien().getTaiKhoan().getQuyen() != 3) {
				trangthai = ctcc.isDaChamCong() == true ? "Đã chấm công" : "Chưa chấm công";
				chucVu = ctcc.getNhanVien().getTaiKhoan().getQuyen() == 1 ? "Nhân viên" : "Trưởng phòng";
				tblModel.addRow(new Object[] { i++, ctcc.getNhanVien().getMaNV(), ctcc.getNhanVien().getHoVaTen(),
						ctcc.getNhanVien().getPhongBan(), chucVu, trangthai });
			}
		}

	}

	private void hienThiCMBPhongBan(List<PhongBan> dspb) {
		modelPhongban.removeAllElements();
		for (PhongBan phongBan : dspb) {
			modelPhongban.addElement(phongBan);
		}
		comboBox.setModel(modelPhongban);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnCapNhat)) {
			try {
				dsCTChamCong = chiTietChamCongControl.layDSCTNhanVienChamTheoNgay(
						((PhongBan) comboBox.getSelectedItem()).getMaPB(), LocalDate.now());

				hienThiDsChamCong(dsCTChamCong);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}

}
