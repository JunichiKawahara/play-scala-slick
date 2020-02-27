package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import scala.concurrent.{ ExecutionContext, Future }

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(repository: PersonRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

    def index() = Action.async { implicit request =>
        repository.list().map { people =>
            Ok(views.html.index(
                "People Data.", people
            ))
        }
    }
}
