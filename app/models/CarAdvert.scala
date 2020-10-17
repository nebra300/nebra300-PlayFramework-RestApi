package models

import play.api.libs.json._
import play.api.libs.functional.syntax._


case class CarAdvert(
    id: Int,
    title: String,
    fuelType: String,
    price: Double,
    isNew: Boolean,
    mileage: Int,
    firstRegistration: String
)

object CarAdvert {
    implicit val carAdvertWrites = new Writes[CarAdvert] {
        def writes(carAdvert: CarAdvert) = Json.obj(
            "id" -> carAdvert.id,
            "title" -> carAdvert.title,
            "fuelType" -> carAdvert.fuelType,
            "price" -> carAdvert.price,
            "isNew" -> carAdvert.isNew,
            "mileage" -> carAdvert.mileage,
            "firstRegistration" -> carAdvert.firstRegistration,
        )
    }

    implicit val carAdvertReads: Reads[CarAdvert] = (
        (JsPath \ "id").read[Int] and
        (JsPath \ "title").read[String] and
        (JsPath \ "fuelType").read[String] and
        (JsPath \ "price").read[Double] and
        (JsPath \ "isNew").read[Boolean] and
        (JsPath \ "mileage").read[Int] and
        (JsPath \ "firstRegistration").read[String]
    )(CarAdvert.apply _)
}

