package com.algebra

trait FiniteGroup extends Group {

  import scala.annotation.tailrec

  type T1
  type T2 <: FiniteGroupElement

  def builder(x: T1): T2

  val elements: Set[T2]

  def elementsOrdered: List[T2] = one :: (elements - one).toList

  val cardinal: Int = elements.size

  def commutator(g: T2, h: T2): T2 = {
    g.multiply(h.multiply(g.inverse.multiply(h.inverse)))
  }

  def generatedSet(generators: Set[T2]): Set[T2] = {
    @tailrec
    def loop(previousSet: Set[T2], generators: Set[T2]): Set[T2] = {
      val newSet =
        for {
          g <- previousSet
          s <- generators
        } yield g.multiply(s)
      if (previousSet != newSet) {
        loop(newSet ++ previousSet, generators)
      } else {
        previousSet
      }
    }

    val initialSet = generators + one
    val finalSet = loop(initialSet, generators)
    finalSet
  }

  def isAbelian: Boolean = {
    val producto =
      for (i <- elements; j <- elements) yield i.multiply(j) == j.multiply(i)
    !producto.contains(false)
  }

  def cayleyTable(): Unit = {
    val list1: List[Int] = (1 to cardinal).toList
    val translator: Map[Int, T2] = (list1 zip elementsOrdered).toMap
    val inverseTranslator: Map[T2, Int] = (list1 zip elementsOrdered).toMap.map(_.swap)
    println()
    println("Cayley table of " + this.structureId + ":")
    println()
    for (i <- 1 to cardinal) {
      for (j <- 1 to cardinal) {
        print(inverseTranslator(translator(i).multiply(translator(j))).toString + " ")
      }
      println()
    }
    println()
  }

  trait FiniteGroupElement extends GroupElement
}
