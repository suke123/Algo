//Listの実装であるArrayListクラスについて体験する
import java.util.ArrayList;

public class ArrayListSample {

	public static void main(String[] args) {
		//Listの実装であるArrayListクラスのインスタンスの生成、今回は文字列型
		//ジェネリック（相称型）を使っている（復習）
		ArrayList<String> list = new ArrayList<String>();
		list.add("東京");//要素の追加
		list.add("ロンドン");
		list.add("パリ");
		list.add("パリ");//Setの場合と比較しよう

		for(int i = 0; i < list.size(); i++){ //リストの要素を表示
			System.out.println(list.get(i));
		}
		System.out.println("");

		list.remove(1);  //要素の削除

		for(int i = 0; i < list.size(); i++){ //リストの要素を表示
			System.out.println(list.get(i));
		}
		System.out.println("");

		list.add(2, "バンコク");  //2番目に要素を追加

		for(int i = 0; i < list.size(); i++){ //リストの要素を表示
			System.out.println(list.get(i));
		}

	}

}
