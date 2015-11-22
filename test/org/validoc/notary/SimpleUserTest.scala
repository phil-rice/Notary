package org.validoc.notary

import org.scalatestplus.play.PlaySpec
import model.User
import model.UserInRequest
import model.UserInSession
import play.api.mvc._
import play.api.test.Helpers._
import model.SimpleUser

class SimpleUserSpec extends PlaySpec with Results {

  "The Simple User" must {
    "Return the user name" in {
      val su = SimpleUser("someName")
      implicitly[User[SimpleUser]].userName(su) mustBe "someName"
    }
  }

}