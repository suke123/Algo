public class ChainHash<K,V> {

	//---ハッシュを構成するノード---//
	class Node<K,V> {
		private K key;
		private V data;
		private Node<K,V> next;

		//---コンストラクタ---//
		Node(K key, V data, Node<K,V> next) {
			this.key = key;
			this.data = data;
			this.next = next;
		}

		//---キー値を返す---//
		K getKey() {
			return key;
		}

		//---データを返す---//
		V getValue() {
			return data;
		}

		//---キーのハッシュ値を返す---//
		public int hashCode() {
			return key.hashCode();
		}
	}

	private int size;
	private Node<K,V>[] table;

	//---コンストラクタ---//
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}

	//---ハッシュ値を求める---//
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}

	//---キー値keyをもつ要素の探索（データを返却）---//
	public V search(K key) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];

		while (p != null) {
			if(p.getKey().equals(key))
				return p.getValue();
			p = p.next;
		}
		return null;
	}

	//---キー値key・データdataをもつ要素の追加---//
	public int add(K key, V data) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];

		while (p != null) {
			if(p.getKey().equals(key))
				return 1;
			p = p.next;
		}
		Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
		table[hash] = temp;
		return 0;
	}

	//---キー値keyをもつ要素の削除---//
	public int remove(K key) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		Node<K,V> pp = null;

		while (p != null) {
			if(p.getKey().equals(key)) {
				if(pp == null)
					table[hash] = p.next;
				else
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next;
		}
		return 1;
	}

	//---ハッシュ表をダンプ---//
	public void dump() {
		for(int i = 0; i < size; i++){
			Node<K,V> p = table[i];
			System.out.printf("%02d ", i);
			while(p != null){
				System.out.printf("→ %s (%s) ", p.getKey(), p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
}
