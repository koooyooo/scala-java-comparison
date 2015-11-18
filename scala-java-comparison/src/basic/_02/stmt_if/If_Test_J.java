package basic._02.stmt_if;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

public class If_Test_J {
	
	/**
	 * 標準的な if文
	 * 
	 * シナリオ： Bool値を確認し、真なら"T", 偽なら"F"を返す
	 * 着眼点： Javaの if文は "式"ではなく "文"なので結果を戻せず、 中間値 "value"の値の変化を管理する必要がある。
	 */
	@Test
	public void testIf() {
		String value = null;
		final boolean isTrue = true;
		if (isTrue) {
			value = "T";
		} else {
			value = "F";
		}
		assertThat(value, is("T"));
	}

}
