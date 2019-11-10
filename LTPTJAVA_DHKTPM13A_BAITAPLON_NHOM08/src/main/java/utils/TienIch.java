package utils;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class TienIch {
	/**
	 * Hàm ẩn hiện các control trên giao diện
	 * 
	 * @param hien:    giá trị boolean; true: cho phép hiện, false: ẩn các control
	 * @param controls
	 */
	public static void hienAnCacControl(boolean hien, Object... controls) {
		for (Object object : controls) {
			if (hien) {
				if (object instanceof JTextField) {
					((JTextField) object).setEditable(true);
				}
				if (object instanceof JFormattedTextField) {
					((JFormattedTextField) object).setEditable(true);
				}
				if (object instanceof JButton) {
					((JButton) object).setEnabled(true);
				}
				if (object instanceof JDateChooser) {
					// ((JTextComponent)
					// ((JDateChooser)object).getDateEditor().getUiComponent()).setEditable(true);
					((JDateChooser) object).getCalendarButton().setEnabled(true);
				}
				if (object instanceof JSpinner) {
					((JSpinner) object).setEnabled(true);
				}
				if (object instanceof JTextPane) {
					((JTextPane) object).setEditable(true);
				}
				if (object instanceof JComboBox) {
					((JComboBox) object).setEnabled(true);

				}
				if (object instanceof JCheckBox) {
					((JCheckBox) object).setEnabled(true);
				}
			} else {
				if (object instanceof JTextField) {
					((JTextField) object).setEditable(false);
				}
				if (object instanceof JFormattedTextField) {
					((JFormattedTextField) object).setEditable(false);
				}
				if (object instanceof JButton) {
					((JButton) object).setEnabled(false);
				}
				if (object instanceof JDateChooser) {

					// ((JTextComponent)
					// ((JDateChooser)object).getDateEditor().getUiComponent()).setEditable(false);
					((JDateChooser) object).getCalendarButton().setEnabled(false);
				}
				if (object instanceof JSpinner) {
					((JSpinner) object).setEnabled(false);
				}
				if (object instanceof JTextPane) {
					((JTextPane) object).setEditable(false);
				}
				if (object instanceof JComboBox) {
					((JComboBox) object).setEnabled(false);
				}
				if (object instanceof JCheckBox) {
					((JCheckBox) object).setEnabled(false);
				}
			}
		}
	}

	/**
	 * Chuyển chuỗi tiếng việt có dấu thành không dấu
	 * 
	 * @param chuoiVN: chuỗi có dấu
	 * @return
	 */
	public static String chuyenChuoiTiengVietThanhChuoiKhongDau(String str) {
		/*
		 * String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		 * Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		 * return pattern.matcher(nfdNormalizedString).replaceAll("");
		 */

		str = str.replaceAll("à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ", "a");
		str = str.replaceAll("è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ", "e");
		str = str.replaceAll("ì|í|ị|ỉ|ĩ", "i");
		str = str.replaceAll("ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ", "o");
		str = str.replaceAll("ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ", "u");
		str = str.replaceAll("ỳ|ý|ỵ|ỷ|ỹ", "y");
		str = str.replaceAll("đ", "d");

		str = str.replaceAll("À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ", "A");
		str = str.replaceAll("È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ", "E");
		str = str.replaceAll("Ì|Í|Ị|Ỉ|Ĩ", "I");
		str = str.replaceAll("Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ", "O");
		str = str.replaceAll("Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ", "U");
		str = str.replaceAll("Ỳ|Ý|Ỵ|Ỷ|Ỹ", "Y");
		str = str.replaceAll("Đ", "D");
		return str;
	}

	/**
	 * Hàm xoá trắng nội dung trong các JTextField
	 * 
	 * @param txts
	 */
	public static void xoaTrangCacJTextField(JTextField... txts) {
		for (JTextField txt : txts) {
			txt.setText("");
		}
	}

	public static void chinhKichThuocTitleTrenBorder(JPanel[] pns, String fontName, int fontStyle, int size) {
		for (JPanel pn : pns) {
			((TitledBorder) pn.getBorder()).setTitleFont(new Font(fontName, fontStyle, size));
			pn.repaint();
		}

	}

}
