// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Branimir/Desktop/Scala 3/PlayApi/conf/routes
// @DATE:Sat Oct 17 17:20:53 CEST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:9
  class ReverseCarAdvertController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def Update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "car/adverts/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:9
    def Create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "car/adverts")
    }
  
    // @LINE:13
    def ReadOne(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "car/adverts/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:17
    def Delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "car/adverts/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:11
    def Read(sortBy:String = "id"): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "car/adverts" + play.core.routing.queryString(List(if(sortBy == "id") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("sortBy", sortBy)))))
    }
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:21
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
