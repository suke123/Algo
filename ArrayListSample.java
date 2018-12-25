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





ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
# ファイル生成＆マイグレーション
ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
以下処理アカウントごとに３回ずつ
　　1. ファイル名生成＆取得
        ・テストコード○
        ・コーディング△
　　2. ファイル生成
        ・テストコード×
        ・コーディング○
　　3. コピー
        ・テストコード×
        ・コーディング×

その他
各処理失敗
    旧ファイルに失敗フラグ追加×

処理最後まで成功
    旧ファイルに成功フラグ追加×


ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
# マイグレーション後の処理
ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
ファイル参照
    旧設定の値を参照し、どっちを更新するかを決める×
    true ：参照：新、更新：新旧×
    false：参照：旧、更新：旧×
      ・テストコード×
      ・コーディング×
          ・インタフェース作成×
          ・クラス3つ作成×
