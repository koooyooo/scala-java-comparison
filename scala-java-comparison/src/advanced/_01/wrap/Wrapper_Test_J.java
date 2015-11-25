package advanced._01.wrap;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import static advanced._01.wrap.ExWrapper.*;

import org.junit.Test;

/**
 * 関数をラップする機能のテストケース
 * 
 * @author K.Onda
 */
public class Wrapper_Test_J {
	
	/**
	 * 引数なし戻り値なしの処理で、例外が発生しないパターン
	 * 
	 */
	@Test
	public void testNoArgNoReturn() {
		wrap(() -> {
				System.out.println("hello");
			});
	}
	
	/**
	 * 引数なし戻り値なしの処理で、例外が発生するパターン
	 */
	@Test(expected=RuntimeException.class)
	public void testNoArgNoReturnWithException() {
		wrap(() -> {
				System.out.println("hello");
				if (true) throw new Exception("exception");
			});
	}
	
	/**
	 * 引数あり戻り値ありの処理で、例外が発生しないパターン
	 */
	@Test
	public void testWithArgWithReturn() {
		String result = wrap(
				(String arg1) -> "[" + arg1 + "]"
				, "Hello"
		);
		assertThat(result, is("[Hello]"));
	}
	
	/**
	 * 引数あり戻り値ありの処理で、例外が発生するパターン
	 */
	@Test(expected=RuntimeException.class)
	public void testWithArgWithReturnWithException() {
		@SuppressWarnings("unused")
		String result = wrap(
				(String arg1) -> {
					if (true) throw new Exception("exception"); 
					return "[" + arg1 + "]";
				}, "Hello"
		);
	}
	
}


