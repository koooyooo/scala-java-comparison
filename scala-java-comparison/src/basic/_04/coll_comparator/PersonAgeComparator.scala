package basic._04.coll_comparator

import java.util.Comparator

/**
 * 年齢で比較する Comparator
 */
class PersonAgeComparator[T <: Person] extends Comparator[T] {
  
  /**
   * 比較を行う
   * 
   * @param p1 比較対象のPerson
   * @param p2 比較対象のPerson
   * @return p1がp2より大きければ正の数、逆であれば負の数、同値であれば0
   */
  def compare(p1: T, p2: T): Int = {
    p1.age - p2.age
  }
  
}