package tratamentoDeErros;
import javax.swing.JOptionPane;

public class Validacoes {
	
	public static boolean validaNome(String nome) {
		if (nome.length() < 3 || nome.substring(0, 3).equals("   ")) {
			JOptionPane.showMessageDialog(null, "Nome Inválido", "Erro!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean validaCpf(String cpf) {
		if(!(cpf.length()==11)) {
			JOptionPane.showMessageDialog(null,"CPF Inválido","Erro!",JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			try {
				Long.valueOf(cpf);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"CPF Inválido","Erro!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public static boolean validaAp(String ap) {
		try {
			ap = String.valueOf(Integer.valueOf(ap));
			if(!(ap.length()==4)||Integer.valueOf(ap)<0) {
				JOptionPane.showMessageDialog(null,"AP Invalido","Erro!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			// Valida numero do prédio
			if(Integer.valueOf(String.valueOf(ap.charAt(0)))>6) {
				JOptionPane.showMessageDialog(null,"Numero do Prédio Invalido","Erro!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			// Valida andar do prédio
			if(Integer.valueOf(ap.substring(1,2))>15) {
				JOptionPane.showMessageDialog(null,"Numero do Andar Invalido","Erro!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			// Valida numero no corredor do prédio
			if(Integer.valueOf(String.valueOf(ap.charAt(3)))>5) {
				JOptionPane.showMessageDialog(null,"Numero no Corredor Invalido","Erro!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"AP Invalido","Erro!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean validaTelefone(String telefone) {
		if(!(telefone.length()==11)&&!(telefone.length()==9)) {
			JOptionPane.showMessageDialog(null,"Telefone Inválido","Erro!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			if(Long.valueOf(telefone)<0) {
				JOptionPane.showMessageDialog(null,"Numero de Telefone Invalido","Erro!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Numero de Telefone Invalido","Erro!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean validaTodos(String nome, String cpf, String ap, String telefone) {
		if(!validaNome(nome)){
			return false;
		}
		if(!validaCpf(cpf)) {
			return false;
		}
		if(!validaAp(ap)) {
			return false;
		}
		if(!validaTelefone(telefone)) {
			return false;
		}
		return true;
	}
	
}
