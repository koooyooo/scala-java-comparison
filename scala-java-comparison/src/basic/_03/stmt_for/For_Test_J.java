package basic._03.stmt_for;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * Javaの forループは大きく3種類に分かれる。
 * 
 * @author K.Onda
 */
public class For_Test_J {

	/**
	 * for文 (index指定)
	 * 
	 * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
	 * 着眼点： get(i)部分で indexによる指定を行っている。自由度が高い記述法のためバグを生む余地がある。
	 */
	@Test
	public void testForIndex() {
		final StringBuilder sb = new StringBuilder();
		final List<String> countryList = Arrays.asList("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
		for (int i = 0; i < countryList.size(); i++) {
			final String country = countryList.get(i);
			sb.append(country);
			if (i != countryList.size() -1) {
				sb.append(", ");
			}
		}
		assertThat(sb.toString(), is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
	}
	
	/**
	 * for文 (Iterator指定)
	 * 
	 * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
	 * 着眼点： Iteratorを利用する事で、indexの指定を隠蔽化している。
	 */
	@Test
	public void testForInterator() {
		final StringBuilder sb = new StringBuilder();
		final List<String> countryList = Arrays.asList("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
		for (Iterator<String> ite = countryList.iterator(); ite.hasNext(); ) {
			final String country = ite.next();
			sb.append(country);
			if (ite.hasNext()) {
				sb.append(", ");
			}
		}
		assertThat(sb.toString(), is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
	}
	
	/**
	 * for文 (拡張 for文)
	 * 
	 * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
	 * 着眼点： 構文レベルで Iteratorを隠蔽している。 尚、要素の位置は判定出来ない。
	 */
	@Test
	public void testForIterable() {
		final String SEP = ", ";
		final StringBuilder sb = new StringBuilder();
		final List<String> countryList = Arrays.asList("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
		for (String country : countryList) {
			sb.append(country);
			sb.append(SEP);
		}
		// 最後に", "を削る処理が必要
		sb.delete(sb.lastIndexOf(SEP), sb.length());
		assertThat(sb.toString(), is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
	}
	
	/**
	 * for文 (for文と同等の処理を StreamAPIにて実現)
	 * 
	 * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
	 * 着眼点： 構文レベルで Iteratorを隠蔽している。 尚、要素の位置は判定出来ない。
	 */
	@Test
	public void testForStream() {
		final String SEP = ", ";
		final StringBuilder sb = new StringBuilder();
		final List<String> countryList = Arrays.asList("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
		countryList.stream().forEach(country -> sb.append(country).append(SEP));
		// 最後に", "を削る処理が必要
		sb.delete(sb.lastIndexOf(SEP), sb.length());
		assertThat(sb.toString(), is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
	}
	

}
