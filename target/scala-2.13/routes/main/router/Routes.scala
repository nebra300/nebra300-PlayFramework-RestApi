// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Branimir/Desktop/CodeVibe/Scala 3/PlayApi/conf/routes
// @DATE:Sat Oct 17 14:30:09 CEST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_2: controllers.HomeController,
  // @LINE:9
  CarAdvertController_0: controllers.CarAdvertController,
  // @LINE:21
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_2: controllers.HomeController,
    // @LINE:9
    CarAdvertController_0: controllers.CarAdvertController,
    // @LINE:21
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_2, CarAdvertController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, CarAdvertController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/adverts""", """controllers.CarAdvertController.Create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/adverts""", """controllers.CarAdvertController.Read(sortBy:String ?= "id")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/adverts/""" + "$" + """id<[^/]+>""", """controllers.CarAdvertController.ReadOne(id:Int)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/adverts/""" + "$" + """id<[^/]+>""", """controllers.CarAdvertController.Update(id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/adverts/""" + "$" + """id<[^/]+>""", """controllers.CarAdvertController.Delete(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_CarAdvertController_Create1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/adverts")))
  )
  private[this] lazy val controllers_CarAdvertController_Create1_invoker = createInvoker(
    CarAdvertController_0.Create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarAdvertController",
      "Create",
      Nil,
      "POST",
      this.prefix + """car/adverts""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_CarAdvertController_Read2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/adverts")))
  )
  private[this] lazy val controllers_CarAdvertController_Read2_invoker = createInvoker(
    CarAdvertController_0.Read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarAdvertController",
      "Read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """car/adverts""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_CarAdvertController_ReadOne3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/adverts/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CarAdvertController_ReadOne3_invoker = createInvoker(
    CarAdvertController_0.ReadOne(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarAdvertController",
      "ReadOne",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """car/adverts/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_CarAdvertController_Update4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/adverts/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CarAdvertController_Update4_invoker = createInvoker(
    CarAdvertController_0.Update(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarAdvertController",
      "Update",
      Seq(classOf[Int]),
      "PUT",
      this.prefix + """car/adverts/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_CarAdvertController_Delete5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/adverts/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CarAdvertController_Delete5_invoker = createInvoker(
    CarAdvertController_0.Delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarAdvertController",
      "Delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """car/adverts/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index)
      }
  
    // @LINE:9
    case controllers_CarAdvertController_Create1_route(params@_) =>
      call { 
        controllers_CarAdvertController_Create1_invoker.call(CarAdvertController_0.Create)
      }
  
    // @LINE:11
    case controllers_CarAdvertController_Read2_route(params@_) =>
      call(params.fromQuery[String]("sortBy", Some("id"))) { (sortBy) =>
        controllers_CarAdvertController_Read2_invoker.call(CarAdvertController_0.Read(sortBy))
      }
  
    // @LINE:13
    case controllers_CarAdvertController_ReadOne3_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CarAdvertController_ReadOne3_invoker.call(CarAdvertController_0.ReadOne(id))
      }
  
    // @LINE:15
    case controllers_CarAdvertController_Update4_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CarAdvertController_Update4_invoker.call(CarAdvertController_0.Update(id))
      }
  
    // @LINE:17
    case controllers_CarAdvertController_Delete5_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CarAdvertController_Delete5_invoker.call(CarAdvertController_0.Delete(id))
      }
  
    // @LINE:21
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
