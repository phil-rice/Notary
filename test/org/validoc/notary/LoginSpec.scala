package org.validoc.notary

import play.api.mvc._
import play.api.test._
import scala.concurrent.Future
import controllers.NotaryController
import org.scalatestplus.play.PlaySpec
import play.api.test.Helpers._
import model.SimpleUserInRequest
import model.UserInSession
import model.UserInRequest
import model.User
import play.api.libs.json.Json
import model.SimpleUser
import controllers.LoginController

class UserInSessionForTest extends UserInSession {
  var name: Option[String] = None
  def userName(implicit request: RequestHeader) = { name }
  def addUserName(result: Result, userName: String)(
    implicit request: RequestHeader): Result = {
    name = Some(userName)
    result
  }
  def clear(result: Result)(implicit request: RequestHeader): Result = {
    name = None
    result
  }
}

class LoginSpec extends PlaySpec with Results {
  val controller = new LoginController[SimpleUser] with Controller {
    implicit val userLike: User[SimpleUser] = implicitly[User[SimpleUser]]
    val userInSession: UserInSessionForTest = new UserInSessionForTest
    val userInRequest: UserInRequest = SimpleUserInRequest
  }

  def checkResult(result: Future[Result]) = {
    status(result) mustEqual OK
    contentType(result) mustEqual Some("text/plain")
    charset(result) mustEqual Some("utf-8")
  }

  "The LoginController" should {
    "should respond to 'login' with message and username in session" in {
      val request = FakeRequest(POST, "/").withJsonBody(Json.parse(s"""{ "user": "someName", "password": "somePassword" }"""))
      val result = controller.login()(request)

      checkResult(result)
      contentAsString(result) mustEqual ("Logged in as someName")
      controller.userInSession.name mustEqual Some("someName")
    }

    "should respond to 'who' with username" in {
      controller.userInSession.name = Some("someName")
      val result = controller.who()(FakeRequest())

      checkResult(result)
      contentAsString(result) mustEqual ("You are logged in as Some(someName)")
      controller.userInSession.name mustEqual Some("someName")
    }

    "should respond to 'who' with username and username removed from session" in {
      controller.userInSession.name = Some("someName")
      val result = controller.logout()(FakeRequest())

      checkResult(result)
      contentAsString(result) mustEqual "Logged Out"
      controller.userInSession.name mustEqual None
    }
  }
}
