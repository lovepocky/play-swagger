package echo.api.yaml

import org.scalacheck.Gen
import org.scalacheck.Arbitrary
import Arbitrary._

object Generators {
def createNullGenerator = _generate(NullGenerator)

    def createPostNameGenerator = _generate(PostNameGenerator)

    def createStringGenerator = _generate(StringGenerator)

    def NullGenerator = arbitrary[Null]

    def PostNameGenerator = Gen.option(arbitrary[String])

    def StringGenerator = arbitrary[String]

    def createPostResponses200Generator = _generate(PostResponses200Generator)

    def PostResponses200Generator = for {
        name <- PostNameGenerator
        year <- PostNameGenerator
    } yield PostResponses200(name, year)

    def _generate[T](gen: Gen[T]) = (count: Int) => for (i <- 1 to count) yield gen.sample
}
