package controllers

import javax.inject._
import scala.concurrent.{ ExecutionContext, Future, ExecutionException }

import play.api._
import play.api.mvc._
import play.api.libs.json._

import models.CarAdvert
import services.CarAdvertService

@Singleton
class CarAdvertController @Inject()(
  components: ControllerComponents,
  carAdvertService: CarAdvertService
  )(  
    implicit ec: ExecutionContext
  ) extends AbstractController(components) {
    
    def Create = Action.async { implicit request: Request[AnyContent] => 
      //GET REQUEST BODY AS JSVAL
      request.body.asJson match {
        case None => Future(BadRequest) //PARSING FAILED
        case Some(jsVal) => {    

          //PARSE CAR ADVERT FROM JS VALUE
          jsVal.validate[CarAdvert] match {
            case e: JsError => Future(BadRequest) //PARSING FAILED
            case JsSuccess(carAdvert, _) => {

              //INSERT CAR ADVERT IN DATABASE
              carAdvertService.insertCarAdvert(carAdvert).map { isInsertSuccess =>
                if(isInsertSuccess) Ok(Json.toJson(carAdvert))
                else InternalServerError
              }.recover {
                case executionException: ExecutionException => {
                  executionException.getCause() match {
                    case assertionError: AssertionError => UnprocessableEntity(Json.parse(assertionError.getMessage()))
                  }
                }
              }
            }
          }
        }
      }
    }

    def Read(sortBy: String) = Action.async { implicit request: Request[AnyContent] =>
      carAdvertService.getCarAdverts(sortBy).map { carAdverts =>
        Ok(play.api.libs.json.JsArray(carAdverts))
      }
    }
    
    def ReadOne(id: Int) = Action.async { implicit request: Request[AnyContent] =>
      carAdvertService.getCarAdvert(id).map { carAdvertOption =>
        carAdvertOption match {
          case None => NotFound
          case Some(carAdvert) => Ok[JsObject](carAdvert)
        }
      }
    }

    def Update(id: Int) = Action.async { implicit request: Request[AnyContent] =>
      //GET REQUEST BODY AS JSVAL
      request.body.asJson match {
        case None => Future(BadRequest)
        case Some(jsVal) => {

          //PARSE CAR ADVERT FROM JS VALUE
          jsVal.validate[CarAdvert] match {
            case e: JsError => Future(BadRequest)
            case JsSuccess(carAdvert, _) => {

              //UPDATE CAR IN DATABASE
              carAdvertService.updateCarAdvert(id, carAdvert).map { isUpdateSuccess =>
                if(isUpdateSuccess) 
                  Ok(Json.toJson(carAdvert))
                else 
                  InternalServerError
              }.recover {
                case executionException: ExecutionException => {
                  executionException.getCause() match {
                    case assertionError: AssertionError => UnprocessableEntity(Json.parse(assertionError.getMessage()))
                  }
                }
                case notFoundException: Exception => NotFound
              }
            }
          }
        } 
      }
    }

    def Delete(id: Int) = Action.async { implicit request: Request[AnyContent] =>
      carAdvertService.getCarAdvert(id).flatMap { carAdvertOption =>
        carAdvertOption match {
          case None => Future(NotFound)
          case Some(car) => {
            carAdvertService.deleteCarAdvert(id).flatMap { isDeleteSuccess =>
              if(isDeleteSuccess==true){
                Future(NoContent)
              }
              else{
                Future(InternalServerError)
              }
            }
          }
        }
      }
    }
  }
