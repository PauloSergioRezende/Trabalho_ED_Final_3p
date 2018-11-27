package arvore;

import dados.ItemArvoreBin;

public class NoArvoreBin {
	private ItemArvoreBin info;
	private NoArvoreBin esq, dir;

	public NoArvoreBin(ItemArvoreBin info) {
		super();
		this.info = info;
		esq = null;
		dir = null;
	}

	public ItemArvoreBin getInfo() {
		return info;
	}

	public void setInfo(ItemArvoreBin info) {
		this.info = info;
	}

	public NoArvoreBin getEsq() {
		return esq;
	}

	public void setEsq(NoArvoreBin esq) {
		this.esq = esq;
	}

	public NoArvoreBin getDir() {
		return dir;
	}

	public void setDir(NoArvoreBin dir) {
		this.dir = dir;
	}
	
}
