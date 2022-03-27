package com.algebra

trait Semigroup {

  type T1
  type T2 <: SemigroupElement

  def builder(x: T1): T2

  val structureId: String

  override def toString: String = structureId

  trait SemigroupElement {

    def multiply(other: T2): T2
    def *(other: T2): T2 = this.multiply(other)

  }
}
