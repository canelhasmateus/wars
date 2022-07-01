import Utils.fib

import scala.util.control.Breaks.{break, breakable}
object Euler002 {


  //  By starting with 1 and 2, the first 10 terms will be:
  //  Each new term in the Fibonacci sequence is generated by adding the previous two terms.
  //
  //    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
  //
  //  By considering the terms in the Fibonacci sequence whose values
  //  do not exceed four million, find the sum of the even-valued terms.

  def naive(limit: BigInt): BigInt = {

    var soma = 0

    for (n <- fib().takeWhile(_ <= limit)) {
      if (n % 2 == 0) {
        soma += n
      }
    }

    return soma
  }

  def fast(limit: BigInt): BigInt = {
    val values = BigInt(2) #:: BigInt(8) #:: evenFibo(2, 8)
    return values.takeWhile(_ <= limit).reduceLeftOption(_ + _).getOrElse(0)

  }

  private def evenFibo(a: BigInt, b: BigInt): LazyList[BigInt] = {
    val next = a + 4 * b
    return next #:: evenFibo(b, next)
  }

}
