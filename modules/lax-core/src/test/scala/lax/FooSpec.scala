package lax

import weaver.pure.*
import cats.effect.IO
import fs2.Stream
import weaver.pure.Suite

object FooSpec extends Suite {
  override def suitesStream: Stream[IO,Test] = Stream(
    pureTest("ok") {
      success
    }
  )
}
