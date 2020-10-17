package services

import javax.inject._

import scala.concurrent.{ExecutionContext, Future}

import play.api.libs.json.JsObject

import models.CarAdvert
import dal.CarAdvertDao
import play.api.libs.json.Json

//PERFORMS VALIDATIONS AND OTHER OPERATIONS
class CarAdvertService @Inject()(
    carAdvertDao: CarAdvertDao
)( 
    implicit executionContext: ExecutionContext
) {
    
    private def validateCarAdvert(carAdvert: CarAdvert) : Future[Option[List[String]]] = {
      var validationErrors : List[String] = List()
      if(carAdvert.id < 0){
        validationErrors = "id must be a positive number" :: validationErrors
      }
      if(carAdvert.title.length() == 0){
        validationErrors = "name cant be an empty string" :: validationErrors
      }
      if(carAdvert.fuelType.length() == 0){
        validationErrors = "fuelType cant be an empty string" :: validationErrors
      }
      if(carAdvert.price < 0){
        validationErrors = "price cant be a negative number" :: validationErrors
      }
      if(carAdvert.mileage < 0){
        validationErrors = "mileage cant be a negative number" :: validationErrors
      }

      if(validationErrors.length==0) return Future(None)
      else return Future(Some(validationErrors.reverse))  
    }

    private def checkCase(orderBy: String) : String = {
        val carAdvertFields = implicitly[Manifest[CarAdvert]].runtimeClass.getDeclaredFields.map(_.getName);
        for(field <- carAdvertFields){
            if(field.toLowerCase()==orderBy.toLowerCase()) {
                return field
            }
        }
        return orderBy
    }

    def getCarAdverts(orderBy: String) : Future[List[JsObject]] = {
        val orderByCaseFixed = checkCase(orderBy)
        carAdvertDao.getCarAdverts(orderByCaseFixed)
    }

    def getCarAdvert(id: Int) : Future[Option[JsObject]] = {
        carAdvertDao.getCarAdvert(id);
    }

    def insertCarAdvert(carAdvert: CarAdvert) : Future[Boolean] = {
        validateCarAdvert(carAdvert).flatMap{ validation_errors_option =>
            validation_errors_option match {
                case Some(validation_errors) => { 
                    Future.failed(new AssertionError((Json.obj(
                        "validation_errors" -> validation_errors
                    ))))
                }
                case None => {
                    carAdvertDao.getCarAdvert(carAdvert.id).flatMap { carAdvertOption =>
                        carAdvertOption match {
                            case Some(value) => {
                                Future.failed(new AssertionError((Json.obj(
                                    "validation_errors" -> List("Item with that id already exists in database")
                                ))))
                            }
                            case None => {
                                carAdvertDao.insertCarAdvert(carAdvert).flatMap { isWriteSuccess =>
                                    Future.successful(isWriteSuccess) 
                                }
                            }
                        }
                    }
                }
            }
        }
    }
  
    def updateCarAdvert(id: Int, carAdvert: CarAdvert) : Future[Boolean] = {
        validateCarAdvert(carAdvert).flatMap { validation_errors_option =>
            validation_errors_option match {
                case Some(validation_errors) => { 
                    Future.failed(new AssertionError((Json.obj(
                        "validation_errors" -> validation_errors
                    ))))
                }
                case None => {
                    carAdvertDao.getCarAdvert(id).flatMap { carAdvertOption =>
                        carAdvertOption match {
                            case None => {  
                                Future.failed(new Exception("Not Found"))
                            }
                            case Some(value) => { 
                                carAdvertDao.updateCarAdvert(id, carAdvert).flatMap { isUpdateSuccess =>
                                    Future.successful(isUpdateSuccess)
                                }
                            } 
                        }
                    }
                }
            }
        }
    }

    def deleteCarAdvert(id: Int) : Future[Boolean] = carAdvertDao.deleteCarAdvert(id)
}