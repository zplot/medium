package com.algebra


trait Structure1 {

  type T1
  type T2 <: Structure1Element

  def builder(x: T1): T2

  trait Structure1Element {
    def function1(other: T2): T2
  }
}

trait Structure2 {

  type T1
  type T2 <: Structure2Element

  def builder(x: T1): T2

  trait Structure2Element {
    def function2(other: T2): T2
  }
}

object Example extends Structure1 with Structure2 {

  type T1 = Int
  type T2 = ExampleElement

  def builder(x: T1): T2 = ExampleElement(x: Int)

  case class ExampleElement(x: Int) extends Structure1Element with Structure2Element {

    def function1(other: T2): T2 = ExampleElement(x + other.x)
    def function2(other: T2): T2 = ExampleElement(x + other.x)
  }
}

