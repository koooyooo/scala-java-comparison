package basic._02.stmt_if

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.core.Is._

class If_Test_S {
  
  
  /**
   * 標準的な if文 (Java的な記述)
   * 
   * シナリオ： Bool値を確認し、真なら"T", 偽なら"F"を返す
   * 着眼点： Scalaの ifを "文"として記述した場合。 記述の差異はあれど本質的にJavaと同質。
   */
  @Test
  def testIf_1_LikeJava(): Unit = {
    var value: String = null;
    val isTrue = true;
    if (isTrue) {
      value = "T";
    } else {
      value = "F";
    }
    assertThat(value, is("T"));
  }
  
  /**
   * 標準的な if文[if式] (Scala的な記述)
   * 
   * シナリオ： Bool値を確認し、真なら"T", 偽なら"F"を返す
   * 着眼点： Scalaの ifを "式"として記述した場合。Javaと異なり結果を返せるため、"value"値が変化せず安定化。
   */
  @Test
  def testIf_2_LikeScala(): Unit = {
    val isTrue = true
    val value = if (isTrue) {"T"} else {"F"}
    assertThat(value, is("T"));
  }
}