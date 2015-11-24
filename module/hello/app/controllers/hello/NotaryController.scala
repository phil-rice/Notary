package controllers.hello

import play.api._
import play.api.mvc._

object NotaryController extends Controller{
  def index = Action {Ok("Hello World") }
}

import play.api.http.LazyHttpErrorHandler
object HelloAssets extends controllers.AssetsBuilder(LazyHttpErrorHandler)