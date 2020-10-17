package dal

import javax.inject._

import scala.concurrent.{ExecutionContext, Future}

import play.modules.reactivemongo._
import play.api.libs.json._

import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.api.commands.WriteResult
import reactivemongo.play.json._, collection._

import models.CarAdvert


class CarAdvertDao @Inject()(
  reactiveMongoApi: ReactiveMongoApi
)(
  implicit executionContext: ExecutionContext
) {
    
  //CAR ADVERT COLLECTION
  def carAdvertsCollection: Future[JSONCollection] = {
    reactiveMongoApi.database.map {_.collection[JSONCollection]("Cars")}
  }


  //READ METHODS

  def getCarAdverts(orderBy: String) : Future[List[JsObject]] = {
    val queryObj = Json.obj()
    val selectorObj = Json.obj("_id" -> 0)
    val sortObj = Json.obj(orderBy -> 1)

    carAdvertsCollection.flatMap{
      _.find(queryObj, selectorObj)
      .sort(sortObj)
      .cursor[JsObject](ReadPreference.primary)
      .collect[List](-1, Cursor.FailOnError[List[JsObject]]())
    }
  }

  def getCarAdvert(id: Int): Future[Option[JsObject]] = {
    val queryObj = Json.obj("id" -> id)
    val selectorObj = Json.obj("_id" -> 0)

    carAdvertsCollection.flatMap(
      _.find(queryObj, selectorObj)
        .one[JsObject])
  }


  //WRITE METHODS
  
  def insertCarAdvert(carAdvert: CarAdvert) : Future[Boolean] = {
    carAdvertsCollection.flatMap(
      _.insert(ordered = false)
      .one(Json.toJson(carAdvert).as[JsObject])
      .map(_.ok))
  }

  def updateCarAdvert(id: Int, carAdvert: CarAdvert) : Future[Boolean] = {
    val queryObj = Json.obj("id" -> id)
    val modifierObj = Json.toJson(carAdvert).as[JsObject]
      
    carAdvertsCollection.flatMap(
      _.update(queryObj, modifierObj)
      .map(_.ok)
    )
  }

  def deleteCarAdvert(id: Int) : Future[Boolean] = {
    val selectorObj = Json.obj("id" -> id)

    carAdvertsCollection.flatMap(
      _.delete.one(selectorObj))
      .map(_.ok)
  }
}