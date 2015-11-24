package org.validoc.integration

import org.scalatest._
import play.api.test._
import play.api.test.Helpers._
import org.scalatestplus.play._

class HelloWorldIntegrationTest extends PlaySpec  with OneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {

  "The index page" must {
    "display Hello World" in {
       go to (s"http://localhost:$port/")
       pageSource mustBe "Hello World"
    }

  }
}