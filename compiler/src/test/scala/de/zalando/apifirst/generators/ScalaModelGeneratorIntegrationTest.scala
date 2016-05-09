package de.zalando.apifirst.generators

import java.io.File

import de.zalando.ExpectedResults
import de.zalando.apifirst.{ScalaName, TypeNormaliser}
import de.zalando.swagger.{ModelConverter, StrictYamlParser}
import org.scalatest.{FunSpec, MustMatchers}

class ScalaModelGeneratorIntegrationTest extends FunSpec with MustMatchers with ExpectedResults {

  override val expectationsFolder = "/expected_results/model/"

  val modelFixtures = new File("compiler/src/test/resources/model").listFiles

  val exampleFixtures = new File("compiler/src/test/resources/examples").listFiles

  val validationFixtures = new File("compiler/src/test/resources/validations").listFiles

  def toTest: File => Boolean = f => f.getName.endsWith(".yaml")

  describe("ScalaModelGenerator should generate model files") {
    (modelFixtures ++ exampleFixtures ++ validationFixtures).filter(toTest).foreach { file =>
      testScalaModelGenerator(file)
    }
  }

  def testScalaModelGenerator(file: File): Unit = {
    it(s"should parse the yaml swagger file ${file.getName} as specification") {
      val (base, model) = StrictYamlParser.parse(file)
      val packageName = ScalaName.scalaPackageName(file.getName)
      val ast         = ModelConverter.fromModel(base, model, Option(file))
      val flatAst     = TypeNormaliser.flatten(ast)
      val scalaModel  = new ScalaGenerator(flatAst).generateModel(file.getName, packageName)
      val expected    = asInFile(file, "scala")
      if (expected.isEmpty)
        dump(scalaModel, file, "scala")
      clean(scalaModel) mustBe clean(expected)
    }
  }

  def clean(str: String): String = str.split("\n").map(_.trim).filter(_.nonEmpty).mkString("\n")
}
