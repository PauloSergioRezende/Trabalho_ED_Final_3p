package arvore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;

import dados.ItemArvoreBin;
import tratamentoDeErros.Validacoes;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class Application implements ActionListener, ListSelectionListener {

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel panel_Inserir;
	private JLabel lblNewLabel;
	private JTextField tftNome;
	private JLabel lblNewLabel2;
	private JTextField tftCPF;
	private JLabel lblNewLabel3;
	private JTextField tftAp;
	private JLabel lblNewLabel4;
	private JTextField tftTell;
	private JLabel lblNewLabel5;
	private JTextField tftEmail;
	private JPanel panel_opcoes;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTable table;
	private JButton btnRemover;
	private JButton btnPesquisar;
	private JButton btnExibir;
	private JButton btnInserir;
	private ArvoreBinaria arvore = new ArvoreBinaria();
	private JToggleButton tglbtnNome;
	private JToggleButton tglbtnCPF;
	private JToggleButton tglbtnAp;
	private JToggleButton tglbtnTelefone;
	private JToggleButton tglbtnEmail;
	private JScrollPane scrollPane;
	private JButton btnSlctAterar;
	private int linhaSel;
	private JButton btnPrimeiro;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	private JButton btnAlterar;
	private ItemArvoreBin alterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param btnNewButton
	 */
	private void initialize() {
		
		//parte grafica e inicialização de variaveis
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 780);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);

		panel_Inserir = new JPanel();
		panel_Inserir.setBorder(
				new TitledBorder(null, "Alteração e Inserção", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Inserir.setBounds(12, 13, 304, 275);
		mainPanel.add(panel_Inserir);
		GridBagLayout gbl_panel_Inserir = new GridBagLayout();
		gbl_panel_Inserir.columnWidths = new int[] { 95, 225 };
		gbl_panel_Inserir.rowHeights = new int[] { 50, 50, 50, 50, 50 };
		gbl_panel_Inserir.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel_Inserir.rowWeights = new double[] { Double.MIN_VALUE };
		panel_Inserir.setLayout(gbl_panel_Inserir);

		lblNewLabel = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_Inserir.add(lblNewLabel, gbc_lblNewLabel);

		tftNome = new JTextField();
		GridBagConstraints gbc_tftNome = new GridBagConstraints();
		gbc_tftNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftNome.insets = new Insets(0, 0, 5, 0);
		gbc_tftNome.gridx = 1;
		gbc_tftNome.gridy = 0;
		panel_Inserir.add(tftNome, gbc_tftNome);
		tftNome.setColumns(10);

		lblNewLabel2 = new JLabel("CPF:");
		GridBagConstraints gbc_lblNewLabel2 = new GridBagConstraints();
		gbc_lblNewLabel2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel2.gridx = 0;
		gbc_lblNewLabel2.gridy = 1;
		panel_Inserir.add(lblNewLabel2, gbc_lblNewLabel2);

		tftCPF = new JTextField();
		GridBagConstraints gbc_tftCPF = new GridBagConstraints();
		gbc_tftCPF.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftCPF.insets = new Insets(0, 0, 5, 0);
		gbc_tftCPF.gridx = 1;
		gbc_tftCPF.gridy = 1;
		panel_Inserir.add(tftCPF, gbc_tftCPF);
		tftNome.setColumns(10);

		lblNewLabel3 = new JLabel("AP:");
		GridBagConstraints gbc_lblNewLabel3 = new GridBagConstraints();
		gbc_lblNewLabel3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel3.gridx = 0;
		gbc_lblNewLabel3.gridy = 2;
		panel_Inserir.add(lblNewLabel3, gbc_lblNewLabel3);

		tftAp = new JTextField();
		GridBagConstraints gbc_tftAp = new GridBagConstraints();
		gbc_tftAp.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftAp.insets = new Insets(0, 0, 5, 0);
		gbc_tftAp.gridx = 1;
		gbc_tftAp.gridy = 2;
		panel_Inserir.add(tftAp, gbc_tftAp);
		tftNome.setColumns(10);

		lblNewLabel4 = new JLabel("Telefone:");
		GridBagConstraints gbc_lblNewLabel4 = new GridBagConstraints();
		gbc_lblNewLabel4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel4.gridx = 0;
		gbc_lblNewLabel4.gridy = 3;
		panel_Inserir.add(lblNewLabel4, gbc_lblNewLabel4);

		tftTell = new JTextField();
		GridBagConstraints gbc_tftTell = new GridBagConstraints();
		gbc_tftTell.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftTell.insets = new Insets(0, 0, 5, 0);
		gbc_tftTell.gridx = 1;
		gbc_tftTell.gridy = 3;
		panel_Inserir.add(tftTell, gbc_tftTell);
		tftNome.setColumns(10);

		lblNewLabel5 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel5 = new GridBagConstraints();
		gbc_lblNewLabel5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel5.gridx = 0;
		gbc_lblNewLabel5.gridy = 4;
		panel_Inserir.add(lblNewLabel5, gbc_lblNewLabel5);

		tftEmail = new JTextField();
		GridBagConstraints gbc_tftEmail = new GridBagConstraints();
		gbc_tftEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftEmail.insets = new Insets(0, 0, 5, 0);
		gbc_tftEmail.gridx = 1;
		gbc_tftEmail.gridy = 4;
		panel_Inserir.add(tftEmail, gbc_tftEmail);
		tftNome.setColumns(10);

		panel_opcoes = new JPanel();
		panel_opcoes.setBorder(new TitledBorder(null, "Opções", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_opcoes.setBounds(328, 13, 302, 275);
		mainPanel.add(panel_opcoes);
		panel_opcoes.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(""));
		panel_1.setBounds(12, 24, 99, 156);
		panel_opcoes.add(panel_1);
		panel_1.setLayout(null);

		btnInserir = new JButton("Inserir");
		btnInserir.setBounds(0, 0, 97, 25);
		panel_1.add(btnInserir);
		btnInserir.addActionListener(this);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(0, 24, 97, 25);
		panel_1.add(btnRemover);
		btnRemover.addActionListener(this);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(0, 52, 97, 25);
		panel_1.add(btnPesquisar);
		btnPesquisar.addActionListener(this);

		btnExibir = new JButton("Exibir");
		btnExibir.setBounds(0, 77, 97, 25);
		panel_1.add(btnExibir);
		btnExibir.addActionListener(this);

		btnSlctAterar = new JButton("Slct Alterar");
		btnSlctAterar.setBounds(0, 104, 97, 25);
		panel_1.add(btnSlctAterar);
		btnSlctAterar.addActionListener(this);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(0, 131, 97, 25);
		panel_1.add(btnAlterar);
		btnAlterar.addActionListener(this);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(""));
		panel_2.setBounds(123, 24, 167, 156);
		panel_opcoes.add(panel_2);
		panel_2.setLayout(null);

		tglbtnNome = new JToggleButton("Nome");
		tglbtnNome.setBounds(0, 13, 78, 25);
		panel_2.add(tglbtnNome);
//		tglbtnNome.addActionListener(this);

		tglbtnCPF = new JToggleButton("CPF");
		tglbtnCPF.setBounds(89, 13, 78, 25);
		panel_2.add(tglbtnCPF);
//		tglbtnCPF.addActionListener(this);

		tglbtnAp = new JToggleButton("AP");
		tglbtnAp.setBounds(0, 51, 78, 25);
		panel_2.add(tglbtnAp);
//		tglbtnAp.addActionListener(this);

		tglbtnTelefone = new JToggleButton("Telefone");
		tglbtnTelefone.setBounds(89, 51, 78, 25);
		panel_2.add(tglbtnTelefone);
//		tglbtnTelefone.addActionListener(this);

		tglbtnEmail = new JToggleButton("Email");
		tglbtnEmail.setBounds(0, 89, 78, 25);
		panel_2.add(tglbtnEmail);
//		tglbtnEmail.addActionListener(this);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(""));
		panel_3.setBounds(12, 189, 278, 73);
		panel_opcoes.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnPrimeiro = new JButton("|<");
		panel_3.add(btnPrimeiro);
		btnPrimeiro.addActionListener(this);

		btnAnterior = new JButton("<<");
		panel_3.add(btnAnterior);
		btnAnterior.addActionListener(this);

		btnProximo = new JButton(">>");
		panel_3.add(btnProximo);
		btnProximo.addActionListener(this);

		btnUltimo = new JButton(">>");
		panel_3.add(btnUltimo);
		btnUltimo.addActionListener(this);

		table = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 301, 618, 419);
		mainPanel.add(scrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Identifica Botões apertados
		if (e.getSource() == btnPrimeiro) {
			linhaSel = 0;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnUltimo) {
			linhaSel = table.getRowCount() - 1;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnProximo) {
			linhaSel++;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnAnterior) {
			linhaSel--;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnPesquisar) {
			pesquisar();
//			exibir();
		}
		if (e.getSource() == btnExibir) {
			exibir();
		}
		if (e.getSource() == btnInserir) {
			inserir();
			exibir();
		}
		if (e.getSource() == btnRemover) {
			remover();
			exibir();
		}
		if (e.getSource() == btnSlctAterar) {
			slctAlterar();
		}
		if (e.getSource() == btnAlterar) {
			alterar();
			exibir();
		}

	}

	private void slctAlterar() {
		//Seleciona item para ser editado
		boolean a,b,c,d,e;
		a = tglbtnAp.isSelected();
		b= tglbtnCPF.isSelected();
		c =tglbtnEmail.isSelected();
		d = tglbtnNome.isSelected();
		e = tglbtnTelefone.isSelected();
		
		tglbtnAp.setSelected(true);
		tglbtnCPF.setSelected(true);
		tglbtnEmail.setSelected(true);
		tglbtnNome.setSelected(true);
		tglbtnTelefone.setSelected(true);
		
		alterar = buscarMaisProximo(procuraItem());
		
		tglbtnAp.setSelected(a);
		tglbtnCPF.setSelected(b);
		tglbtnEmail.setSelected(c);
		tglbtnNome.setSelected(d);
		tglbtnTelefone.setSelected(e);
		
		if (alterar == null) {
			JOptionPane.showMessageDialog(null, "Item para Alteração não encontrado", "", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			JOptionPane.showMessageDialog(null, "Item para Alteração Selecionado com Sucesso", "",
					JOptionPane.INFORMATION_MESSAGE);
			tftAp.setText(String.valueOf(alterar.getAp()));
			tftCPF.setText(String.valueOf(alterar.getCpf()));
			tftEmail.setText(alterar.getEmail());
			tftNome.setText(alterar.getNome());
			tftTell.setText(String.valueOf(alterar.getTelefone()));
		}
	}

	private void alterar() {
		//efetivamente altera o item selecionado pelo metodo slctAlterar();
		if (alterar == null) {
			JOptionPane.showMessageDialog(null, "Não exite item para alteração selecionado", "",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if (!tglbtnAp.isSelected() && !tglbtnCPF.isSelected() && !tglbtnEmail.isSelected() && !tglbtnNome.isSelected()
				&& !tglbtnTelefone.isSelected()) {
			tglbtnCPF.setSelected(true);
			tglbtnEmail.setSelected(true);
			tglbtnNome.setSelected(true);
			tglbtnTelefone.setSelected(true);
		}

		if (tglbtnAp.isSelected()) {
			int aux = JOptionPane.showConfirmDialog(null,
					"Ao se alterar o campo Ap o item Selecionado para alteração séra removido e um novo inserido na arvore! "
							+ "\nGostaria de Continuar mesmo assim?",
					"", JOptionPane.YES_NO_CANCEL_OPTION);
			if (aux == JOptionPane.YES_OPTION) {
				if (Validacoes.validaTodos(tftNome.getText(), tftCPF.getText(), tftAp.getText(), tftTell.getText())) {
					excluir(alterar);
					inserir();
				}
				return;
			} else {
				tglbtnAp.setSelected(false);
			}
		}

		if (tglbtnCPF.isSelected()) {
			if (!Validacoes.validaCpf(tftCPF.getText())) {
				return;
			}
		}
		if (tglbtnNome.isSelected()) {
			if (!Validacoes.validaNome(tftNome.getText())) {
				return;
			}
		}
		if (tglbtnTelefone.isSelected()) {
			if (!Validacoes.validaTelefone(tftTell.getText())) {
				return;
			}
		}

		if (tglbtnCPF.isSelected()) {
			alterar.setCpf(Long.valueOf(tftCPF.getText()));
		}
		if (tglbtnNome.isSelected()) {
			alterar.setNome(tftNome.getText());
		}
		if (tglbtnEmail.isSelected()) {
			alterar.setEmail(tftEmail.getText());
		}
		if (tglbtnTelefone.isSelected()) {
			alterar.setTelefone(Long.valueOf(tftCPF.getText()));
		}

		JOptionPane.showMessageDialog(null, "Campos substituidos com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
	}

	private void pesquisar() {
		ItemArvoreBin[] resultado = procuraItem();
		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Item não encontrado", "", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		ItemArvoreBin result = buscarMaisProximo(resultado);

		tftAp.setText(String.valueOf(result.getAp()));
		tftCPF.setText(String.valueOf(result.getCpf()));
		tftEmail.setText(result.getEmail());
		tftNome.setText(result.getNome());
		tftTell.setText(String.valueOf(result.getTelefone()));

		mostrar(resultado);
	}

	private ItemArvoreBin buscarMaisProximo(ItemArvoreBin[] result) {
		ItemArvoreBin resposta = null;
		for (ItemArvoreBin aux : result) {
			if (aux != null) {
				if (tglbtnAp.isSelected()) {
					if (aux.getAp() != Integer.valueOf(tftAp.getText())) {
						continue;
					}
				}
				if (tglbtnNome.isSelected()) {
					if (!aux.getNome().toLowerCase().contains(tftNome.getText().toLowerCase())) {
						continue;
					}
				}
				if (tglbtnEmail.isSelected()) {
					if (!aux.getEmail().toLowerCase().contains(tftEmail.getText().toLowerCase())) {
						continue;
					}
				}
				if (tglbtnCPF.isSelected()) {
					if (!aux.getCpf().equals(Long.valueOf(tftCPF.getText()))) {
						continue;
					}
				}
				if (tglbtnTelefone.isSelected()) {
					if (!aux.getTelefone().equals(Long.valueOf(tftTell.getText()))) {
						continue;
					}
				}
				resposta = aux;
				break;
			}
		}
		return resposta;
	}

	private ItemArvoreBin[] procuraItem() {
		String nome, email;
		Long cpf, telefone;
		int ap;

		if (!tglbtnAp.isSelected() && !tglbtnCPF.isSelected() && !tglbtnEmail.isSelected() && !tglbtnNome.isSelected()
				&& !tglbtnTelefone.isSelected()) {
			tglbtnAp.setSelected(true);
		}
		// Valida AP
		if (tglbtnAp.isSelected()) {
			if (Validacoes.validaAp(tftAp.getText())) {
				ap = Integer.valueOf(tftAp.getText());
			} else {
				return null;
			}
		} else {
			ap = 0;
		}
		// Valida CPF
		if (tglbtnCPF.isSelected()) {
			if (Validacoes.validaCpf(tftCPF.getText())) {
				cpf = Long.valueOf(tftCPF.getText());
			} else {
				return null;
			}
		} else {
			cpf = 0L;
		}
		// Valida Telefone
		if (tglbtnTelefone.isSelected()) {
			if (Validacoes.validaTelefone(tftTell.getText())) {
				telefone = Long.valueOf(tftTell.getText());
			} else {
				return null;
			}
		} else {
			telefone = 0L;
		}

		nome = tftNome.getText();
		email = tftEmail.getText();

		ItemArvoreBin[] result = arvore.procurar(tglbtnAp.isSelected(), tglbtnNome.isSelected(),
				tglbtnEmail.isSelected(), tglbtnCPF.isSelected(), tglbtnTelefone.isSelected(), ap, nome, email, cpf,
				telefone);
		return result;
	}

	private void exibir() {
		ItemArvoreBin[] aux = arvore.CamPreFixado();
		mostrar(aux);
	}

	private void mostrar(ItemArvoreBin[] aux) {
		Object[][] data = new String[aux.length][5];
		String[] colunas = { "AP", "Nome", "CPF", "Telefone", "Email" };

		int i = 0;
		for (ItemArvoreBin Item : aux) {
			data[i] = new String[5];
			data[i][0] = String.valueOf(Item.getAp());
			data[i][1] = Item.getNome();
			data[i][2] = String.valueOf(Item.getCpf());
			data[i][3] = String.valueOf(Item.getTelefone());
			data[i][4] = Item.getEmail();
			i++;
		}
		table = new JTable(data, colunas);

		if (aux.length != 0) {
			linhaSel = 0;
			table.setRowSelectionInterval(0, 0);
			table.getSelectionModel().addListSelectionListener(this);
		}
		scrollPane.setViewportView(table);
	}

	private void remover() {
		ItemArvoreBin Item = buscarMaisProximo(procuraItem());
		excluir(Item);
	}

	private void excluir(ItemArvoreBin item) {
		if (item == null) {
			JOptionPane.showMessageDialog(null, "item não encontrado", "Erro!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			int resposta = JOptionPane.showConfirmDialog(null,
					"Você realmente deseja remover o item: \nNome: " + item.getNome() + "\nCPF: "
							+ String.valueOf(item.getCpf()) + "\nAP: " + String.valueOf(item.getAp()) + "\nTelefone: "
							+ String.valueOf(item.getTelefone()) + "\nEmail: " + item.getEmail(),
					"", JOptionPane.YES_NO_OPTION);
			if (resposta == JOptionPane.YES_OPTION) {
				arvore.remover(item.getAp());
			}
		}
	}

	private void inserir() {
		String nome = tftNome.getText();
		String cpf = tftCPF.getText();
		String ap = tftAp.getText();
		String telefone = tftTell.getText();
		String email = tftEmail.getText();
		// Valida Campos preenchidos
		if (nome.equals("") || cpf.equals("") || ap.equals("") || telefone.equals("") || email.equals("")) {
			JOptionPane.showMessageDialog(null, "Campos Não Preenchidos", "Erro!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// Valida nome
		if (!Validacoes.validaNome(nome)) {
			return;
		}
		// Valida CPF
		if (!Validacoes.validaCpf(cpf)) {
			return;
		}
		// Valida Numero Do Apartamento
		if (!Validacoes.validaAp(ap)) {
			return;
		}
		if (arvore.pesquisar(Integer.valueOf(ap))) {
			JOptionPane.showMessageDialog(null, "AP ja está ocupado", "Erro!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// Valida Telefone
		if (!Validacoes.validaTelefone(telefone)) {
			return;
		}
		if (telefone.length() == 9) {
			telefone = "27" + telefone;
		}
		// Valida email

		// Insere Item
		ItemArvoreBin novo = new ItemArvoreBin(nome, Long.valueOf(cpf), Integer.valueOf(ap), Long.valueOf(telefone),
				email);
		arvore.inserir(novo);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		String[] rData = new String[5];
		for (int i = 0; i < 5; i++) {
			rData[i] = (String) table.getValueAt(table.getSelectedRow(), i);
		}
		System.out.println("\nvalueChanged(): " + rData[0] + ", " + rData[1] + ", " + rData[2] + ", " + rData[3] + ", "
				+ rData[4]);

		tftNome.setText(rData[1]);
		tftCPF.setText(rData[2]);
		tftAp.setText(rData[0]);
		tftTell.setText(rData[3]);
		tftEmail.setText(rData[4]);
		// habilita seleção
		linhaSel = table.getSelectedRow();
		habilitaSelecao();

	}

	private void habilitaSelecao() {
		if (linhaSel == 0) {
			btnPrimeiro.setEnabled(false);
			btnAnterior.setEnabled(false);
			btnProximo.setEnabled(true);
			btnUltimo.setEnabled(true);
		} else if (linhaSel == table.getRowCount() - 1) {
			btnPrimeiro.setEnabled(true);
			btnAnterior.setEnabled(true);
			btnProximo.setEnabled(false);
			btnUltimo.setEnabled(false);
		} else {
			btnPrimeiro.setEnabled(true);
			btnAnterior.setEnabled(true);
			btnProximo.setEnabled(true);
			btnUltimo.setEnabled(true);
		}
	}
}
