package arvore;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import dados.ItemArvoreBin;

public class ArvoreBinaria {
	private NoArvoreBin raiz;
	private int quantNos;

	public ArvoreBinaria() {
		// TODO Auto-generated constructor stub
		this.quantNos = 0;
		this.raiz = null;
	}

	public boolean eVazia() {
		return (this.raiz == null);
	}

	public NoArvoreBin getRaiz() {
		return this.raiz;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public boolean inserir(ItemArvoreBin elem) {
		if (pesquisar(elem.getAp())) {
			return false;
		} else {
			this.raiz = inserir(elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}

	public NoArvoreBin inserir(ItemArvoreBin elem, NoArvoreBin no) {
		if (no == null) {
			NoArvoreBin novo = new NoArvoreBin(elem);
			return novo;
		} else {
			if (elem.getAp() < no.getInfo().getAp()) {
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			} else {
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}

	public boolean pesquisar(int chave) {
		if (pesquisar(chave, this.raiz) != null) {
			return true;
		} else {
			return false;
		}
	}

	private NoArvoreBin pesquisar(int chave, NoArvoreBin no) {
		if (no != null) {
			if (chave < no.getInfo().getAp()) {
				no = pesquisar(chave, no.getEsq());
			} else {
				if (chave > no.getInfo().getAp()) {
					no = pesquisar(chave, no.getDir());
				}
			}
		}
		return no;
	}

	public boolean remover(int chave) {
		if (pesquisar(chave, this.raiz) != null) {
			this.raiz = removerAP(chave, this.raiz);
			this.quantNos--;
			return true;
		} else {
			return false;
		}
	}

	public NoArvoreBin removerAP(int chave, NoArvoreBin arv) {
		if (chave < arv.getInfo().getAp()) {
			arv.setEsq(removerAP(chave, arv.getEsq()));
		} else {
			if (chave > arv.getInfo().getAp()) {
				arv.setDir(removerAP(chave, arv.getDir()));
			} else {
				if (arv.getDir() == null) {
					return arv.getEsq();
				} else {
					if (arv.getEsq() == null) {
						return arv.getDir();
					} else {
						arv.setEsq(Arrumar(arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}

	private NoArvoreBin Arrumar(NoArvoreBin arv, NoArvoreBin maior) {
		if (maior.getDir() != null) {
			maior.setDir(Arrumar(arv, maior.getDir()));
		} else {
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	
	public ItemArvoreBin[] procurar(boolean ap, boolean nome, boolean email, boolean cpf, boolean telefone,
			int dataAp, String dataNome, String dataEmail, Long dataCpf, Long dataTelefone) {
		Set <ItemArvoreBin> conjunto = new HashSet <ItemArvoreBin>();
		int[] n = new int[1];
		if(ap) {
			n[0] = 0;
			ItemArvoreBin[] vet = new ItemArvoreBin[this.quantNos];
			Collections.addAll(conjunto, FazCamPreFixado(this.raiz, vet, n, dataAp));
		}
		if(nome) {
			n[0]=0;
			ItemArvoreBin[] vet = new ItemArvoreBin[this.quantNos];
			Collections.addAll(conjunto, FazCamPreFixado(this.raiz, vet, n, true, dataNome));
		}
		if(email) {
			n[0]=0;
			ItemArvoreBin[] vet = new ItemArvoreBin[this.quantNos];
			Collections.addAll(conjunto, FazCamPreFixado(this.raiz, vet, n, false, dataEmail));
		}
		if(cpf) {
			n[0]=0;
			ItemArvoreBin[] vet = new ItemArvoreBin[this.quantNos];
			Collections.addAll(conjunto, FazCamPreFixado(this.raiz, vet, n, true, dataCpf));
		}
		if(telefone) {
			n[0]=0;
			ItemArvoreBin[] vet = new ItemArvoreBin[this.quantNos];
			Collections.addAll(conjunto, FazCamPreFixado(this.raiz, vet, n, false, dataTelefone));
		}
		conjunto.remove(null);
		ItemArvoreBin[] result = conjunto.toArray(new ItemArvoreBin[conjunto.size()]);
		return result;
	}
	
	public ItemArvoreBin[] CamPreFixado() {
		int[] n = new int[1];
		n[0] = 0;
		ItemArvoreBin[] vet = new ItemArvoreBin[this.quantNos];
		return (FazCamPreFixado(this.raiz, vet, n));
	}

	private ItemArvoreBin[] FazCamPreFixado(NoArvoreBin arv, ItemArvoreBin[] vet, int[] n) {
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado(arv.getEsq(), vet, n);
			vet = FazCamPreFixado(arv.getDir(), vet, n);
		}
		return vet;
	}

	private ItemArvoreBin[] FazCamPreFixado(NoArvoreBin arv, ItemArvoreBin[] vet, int[] n, int ap) {
		if (arv != null) {
			if (arv.getInfo().getAp() == ap) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
			vet = FazCamPreFixado(arv.getEsq(), vet, n, ap);
			vet = FazCamPreFixado(arv.getDir(), vet, n, ap);
		}
		return vet;
	}

	private ItemArvoreBin[] FazCamPreFixado(NoArvoreBin arv, ItemArvoreBin[] vet, int[] n, boolean cpf, Long value) {
		if (arv != null) {
			if (cpf) {
				if (arv.getInfo().getCpf() == value) {
					vet[n[0]] = arv.getInfo();
					n[0]++;
				}
			} else {
				if (arv.getInfo().getTelefone() == value) {
					vet[n[0]] = arv.getInfo();
					n[0]++;
				}
			}

			vet = FazCamPreFixado(arv.getEsq(), vet, n,cpf, value);
			vet = FazCamPreFixado(arv.getDir(), vet, n,cpf, value);
		}
		return vet;
	}

	private ItemArvoreBin[] FazCamPreFixado(NoArvoreBin arv, ItemArvoreBin[] vet, int[] n, boolean nome, String linha) {
		if (arv != null) {
			if (nome) {
				if (arv.getInfo().getNome().toLowerCase().contains(linha.toLowerCase())) {
					vet[n[0]] = arv.getInfo();
					n[0]++;
				}
			} else {
				if (arv.getInfo().getEmail().toLowerCase().contains(linha.toLowerCase())) {
					vet[n[0]] = arv.getInfo();
					n[0]++;
				}
			}

			vet = FazCamPreFixado(arv.getEsq(), vet, n,nome,linha);
			vet = FazCamPreFixado(arv.getDir(), vet, n,nome,linha);
		}
		return vet;
	}

}
