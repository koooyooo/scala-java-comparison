package advanced._01.wrap;

/**
 * 例外を受け取り、非チェック例外化してスローする処理
 * 
 * @author K.Onda
 */
public class ExWrapper {
	/**
	 * 引数なし戻り値なしの関数を処理
	 * 
	 * @param func 引数なし戻り値なしの関数
	 */
	public static void wrap(FuncNoArgNoReturn func) {
		try {
			func.exec();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * 引数あり戻り値ありの関数を処理
	 * 
	 * @param func 引数あり戻り値ありの関数
	 * @param a1 関数で使う引数
	 * @return 関数からの戻り値
	 */
	public static <R, A1> R wrap(FuncWithArgWithReturn<R, A1> func, A1 a1) {
		try {
			return func.exec(a1);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
