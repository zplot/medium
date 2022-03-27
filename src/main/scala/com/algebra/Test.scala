package com.algebra

object Test extends App {

  import scala.annotation.tailrec

  object Z extends Ring {

    type T1 = Int
    type T2 = ZInteger

    def builder(x: T1): T2 = ZInteger(x)

    val structureId: String = "Z"
    val zero: ZInteger = builder(0)
    val one: ZInteger = builder(1)

    case class ZInteger(k: T1) extends RingElement {

      val isZero: Boolean = k == 0

      def add(other: T2): T2 = ZInteger(k + other.k)
      def negate: T2 = ZInteger(-k)
      def multiply(other: T2): T2 = ZInteger(k * other.k)
      override def toString: String = k.toString

      final override def equals(other: Any): Boolean = {
        val that = other.asInstanceOf[ZInteger]
        if (that == null) false
        else this.k == that.k
      }
    }
  }

  val two = Z.ZInteger(2)
  val three = Z.ZInteger(3)
  val sum = two + three
  val product = two * three
  println(sum) // 5
  println(product) // 6x

}


