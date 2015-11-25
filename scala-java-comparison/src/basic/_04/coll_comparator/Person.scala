package basic._04.coll_comparator

/**
 * 人物を表現するクラス
 * 
 * @param name 名前
 * @param age 年齢
 */
case class Person (val name: String, val age:Int) {
  
  /**
   * 年齢が上であるかを判定する。
   * 
   * @param other 比較対象の Person
   * @return 自身の年齢が上であれば true
   */
  def isOlderThan(other: Person): Int = {
    this.age - other.age
  }  
}

/**
 * 人物を表現するクラスの コンパニオンオブジェクト(Javaの staticに近い責務を負う Object)
 * 
 */
object Person {
  def isOlderThanStatic(one: Person, other: Person): Int = {
    one.age - other.age
  }  
}