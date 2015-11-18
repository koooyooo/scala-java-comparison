package basic._03.stmt_for

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.core.Is._

/**
 * Scalaの for文は、以下の処理機構を持っている。
 * - フィルタ処理
 * - 変換処理 (変数への束縛)
 * - リスト変換
 */
class For_Test_S {
  
  /**
   * [Javaとの対比]
   * for文 (index指定)
   * 
   * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
   * 着眼点： get(i)部分で indexによる指定を行っている。自由度が高い記述法のためバグを生む余地がある。
   */
  @Test
  def testForIndex(): Unit = {
    val sb = new StringBuilder();
    val countryList = List("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
    for (i <- 0 until countryList.size) {
      val country = countryList(i);
      sb.append(country);
      if (i != countryList.size -1) {
        sb.append(", ");
      }
    }
    assertThat(sb.toString(), is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
  }
  
  /**
   * [Javaとの対比]
   * for文 (Iterator指定-whileにて代替)
   * 
   * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
   * 着眼点： forループ内にJavaのそれの様な(定義；判定；後処理)の区画が無い為、Iteratorを上手く利用することが出来ない。
   */
  @Test
  def testForInterator(): Unit = {
    val sb = new StringBuilder();
    val countryList = List("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
    val ite = countryList.iterator
    // for文での記述は不可のため while文を利用
    while (ite.hasNext) {
      val country = ite.next();
      sb.append(country);
      if (ite.hasNext) {
        sb.append(", ");
      }
    }
    assertThat(sb.toString(), is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
  }
  
  /**
   * [Javaとの対比]
   * for文 (拡張 for文)
   * 
   * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
   * 着眼点： 構文レベルで Iteratorを隠蔽している。 尚、要素の位置は判定出来ない。
   */
  @Test
  def testForIterable(): Unit = {
    val SEP = ", ";
    val sb = new StringBuilder();
    val countryList = List("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
    for (country <- countryList) {
      sb.append(country);
      sb.append(SEP);
    }
    // 最後に", "を削る処理が必要
    sb.delete(sb.lastIndexOf(SEP), sb.length());
    assertThat(sb.toString(), is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
  }
  
  /**
   * [Javaとの対比]
   * for文 (for文と同等の処理を 関数にて実現)
   * 
   * シナリオ： 国名が複数格納された Listを CSV形式の文字列に変換する。
   * 着眼点： 構文レベルで Iteratorを隠蔽している。 尚、要素の位置は判定出来ない。
   */
  @Test
  def testForStream(): Unit = {
    val SEP = ", ";
    val sb = new StringBuilder();
    val countryList = List("Japan", "UnitedStates", "UnitedKingdom", "France", "China", "Geraman");
    countryList.foreach(country => sb.append(country).append(SEP));
    // 最後に", "を削る処理が必要
    sb.delete(sb.lastIndexOf(SEP), sb.length());
    assertThat(sb.toString(), is("Japan, UnitedStates, UnitedKingdom, France, China, Geraman"));
  }
}