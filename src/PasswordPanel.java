import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordPanel {
	private JPanel panel;
	private JLabel label;
	private JPasswordField pass;
	private String titulo = null;
	private int option;

	public PasswordPanel() {
	}

	//mostra a janela
	public String show(String msg) {
		this.panel = new JPanel();
		this.label = new JLabel(msg);
		this.pass = new JPasswordField(16);
		this.panel.add(label);
		this.panel.add(pass);
		String[] options = new String[] { "OK", "Cancelar" };
		this.option = JOptionPane.showOptionDialog(null, panel, titulo, JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		if (option == 0) // OK button
			return String.valueOf(pass.getPassword());
		if (option == 1) //cancelou
			return "";
		
		return null;
	}
	
	public String show() {
		String[] options = new String[] { "OK", "Cancelar" };
		this.option = JOptionPane.showOptionDialog(null, panel, titulo, JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		if (option == 0) // OK button
			return String.valueOf(pass.getPassword());
		if (option == 1) //cancelou
			return "";
		
		return null;
	}
}
