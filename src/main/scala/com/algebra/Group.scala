package com.algebra

trait Group extends Monoid {

  type T1
  type T2 <: GroupElement

  def builder(x: T1): T2

  val structureId: String

  override def toString: String = structureId

  trait GroupElement extends MonoidElement {

    def inverse: T2

  }
}
