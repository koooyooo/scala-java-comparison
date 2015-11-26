package advanced._01.wrap;


/**
 * 引数あり戻り値ありの関数
 * 
 * @author K.Onda
 * @param <R>  戻り値
 * @param <A1> 引数
 */
@FunctionalInterface
public interface FuncWithArgWithReturn<R, A1> {
	public R exec(A1 a1) throws Exception;
}
