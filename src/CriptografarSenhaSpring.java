
/*
 * Autor: Douglas Almeida de Oliveira
 * Uso: Criptografa senha usando framework Spring para ser inserida no sistema de gestão de contratos da CTB
 * Data: 27/04/2018
 */

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import sun.misc.BASE64Encoder;


@SuppressWarnings("restriction")
public class CriptografarSenhaSpring {

	@SuppressWarnings("unused")
	private static Scanner teclado;
	private static String senha;

	public static void main(String[] args) {
		try {
			senha = null;
			String confirmacao = null;
			teclado = new Scanner(System.in);
			PasswordPanel dialogo = new PasswordPanel();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

			do {
				senha = dialogo.show("Insira a senha");
				if (!senha.equals("")) {// se a pessoa cancelou a inserção da
										// senha, não pede a confirmação e sai
										// do programa
					confirmacao = dialogo.show("Confirme a senha");
					if (!confirmacao.equals("") && senha.equals(confirmacao)) {
						String senhaCripto = criptografa(senha);
						System.out.println(senhaCripto);
						StringSelection selection = new StringSelection(senhaCripto);
						clipboard.setContents(selection, null);
						JOptionPane.showMessageDialog(null, "Senha registrada");
					} else if (!senha.equals(confirmacao)) {
						JOptionPane.showMessageDialog(null, "Senhas não conferem");
					}
				}
			} while (!senha.equals("") || !confirmacao.equals("") || !senha.equals(confirmacao)); // Pede
		} catch (Exception e) {}

	}
	
	public static String criptografa(String senha){
//		classe usada para criptografar as senhas
		try{
		 MessageDigest digest = MessageDigest.getInstance("SHA-256");
		               digest.update(senha.getBytes());
		 BASE64Encoder encoder = new BASE64Encoder();
		        return encoder.encode(digest.digest());
		}catch(NoSuchAlgorithmException ns){
			ns.printStackTrace();
		}
		return senha;
	}
}
