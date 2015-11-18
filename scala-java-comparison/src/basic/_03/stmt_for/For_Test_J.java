package basic._03.stmt_for;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Javaの forループは大きく3種類に分かれる。
 * 
 * @author K.Onda
 */
public class For_Test_J {

	/**
	 * [API 4以下]
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
	 * [API 4以下]
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
	 * [API 5以上]
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
	 * [API 8以上]
	 * for文 (for文と同等の処理を Java8(JoinAPI)にて実現)
	 * 
	 * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
	 * 着眼点：  用途に適合したライブラリの利用により最適化
	 */
	@Test
	public void testForStream() {
		final List<String> countryList = Arrays.asList("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
		final String countryCSV = String.join(", ", countryList);
		assertThat(countryCSV, is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
	}
	
	/**
	 * [API 7以下]
	 * フィルタリング処理
	 * 
	 * シナリオ： 国名が複数格納された Listを元に、Uから始まる国名のリストを生成する。
	 * 着眼点：  意味論に近いAPIを用意出来ず、処理を前面に出してしまっている。
	 */
	@Test
	public void testForFilterOld() {
		final List<String> countryStartWithU = new ArrayList<String>();
		final List<String> countryList = Arrays.asList("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
		for (String country: countryList) {
			if (!country.startsWith("U")) {
				continue;
			}
			countryStartWithU.add(country);
		}
		assertThat(countryStartWithU, is(Arrays.asList("UnitedStates", "UnitedKingdom")));
	}
	
	/**
	 * [API 8以上]
	 * フィルタリング処理 (for文からの脱却)
	 * 
	 * シナリオ： 国名が複数格納された Listを元に、Uから始まる国名のリストを生成する。
	 * 着眼点：  StreamAPIを利用することで、表現したい意味に近いコードとなっている。
	 * 			Scalaと異なり、開始と終了に stream()宣言、collect(xx)処理が入る。
	 */
	@Test
	public void testForFilterFrom8() {
		final List<String> countryList = Arrays.asList("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
		final List<String> countryStartWithU = countryList.stream().filter(x -> x.startsWith("U")).collect(Collectors.toList());
		assertThat(countryStartWithU, is(Arrays.asList("UnitedStates", "UnitedKingdom")));		
	}
	

}
