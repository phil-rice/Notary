package org.validoc.notary

import org.scalatestplus.play.PlaySpec
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import controllers.hello.NotaryController

class HelloWorldSpec extends PlaySpec with Results {

  val controller =  NotaryController

  "The HelloWorld Application" should {
    "respond to the index Action" in {
      val result = controller.index()(FakeRequest())

      status(result) mustEqual OK
      contentType(result) mustBe Some("text/plain")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) mustBe "Hello World" 
    }
  }
}