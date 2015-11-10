import java.util.Scanner;

// チェイン法によるハッシュの利用

class ChainHashTester {

	static Scanner stdIn = new Scanner(System.in);

	//---データ（会員番号＋氏名）---//
	static class Data{
		static final int NO    = 1; //番号を読み込むか？
		static final int NAME  = 2; //氏名を読み込むか？

		private Integer no;         //会員番号（キー値）
		private String  name;       //氏名

		//---キー値---//
		Integer keyCode(){
			return no;
		}

		//---文字列表現---//
		public String toString(){
			return name;
		}

		//---データ読み込み---//
		void scanData(String guide, int sw){
			System.out.println(guide + "するデータを入力してください。");

			if((sw & NO) == NO){
				System.out.print("番号：");
				no = stdIn.nextInt();
			}
			if((sw & NAME) == NAME){
				System.out.print("名前：");
				name = stdIn.next();
			}
		}
	}

	//---メニュー型列挙---//
	enum Menu{
		ADD(      "データ追加"),
		REMOVE(   "データ削除"),
		SEARCH(   "データ探索"),
		DUMP(     "全データ表示"),
		TERMINATE("終了");

		private final String message;

		static Menu MenuAt(int idx){
			for(Menu m : Menu.values())
				if(m.ordinal() == idx)
					return m;
				return null;
		}
		Menu(String string) {
			message = string;
		}

		String getMessage() {
			return message;
		}
	}

	//---メニュー選択---//
	static Menu SelectMenu() {
		int key;
		do{
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
				if((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print("：");
			key = stdIn.nextInt();
		}while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data temp = new Data();

		ChainHash<Integer, Data> hash = new ChainHash<Integer, Data>(13);

		do {
			switch (menu = SelectMenu()) {
			  case ADD :
				data = new Data();
				data.scanData("追加", Data.NO | Data.NAME);
				hash.add(data.keyCode(), data);
				break;

			  case REMOVE :
				temp.scanData("削除", Data.NO);
				hash.remove(temp.keyCode());
				break;

			  case SEARCH :
				temp.scanData("探索", Data.NO);
				Data t = hash.search(temp.keyCode());
				if(t != null)
					System.out.println("そのキーを持つデータは"+ t + "です。");
				else
					System.out.println("該当するデータはありません。");
				break;

			  case DUMP :
				hash.dump();
				break;
			}
		}while (menu != Menu.TERMINATE);
	}

