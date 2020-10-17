// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Branimir/Desktop/CodeVibe/Scala 3/PlayApi/conf/routes
// @DATE:Sat Oct 17 14:30:09 CEST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseCarAdvertController CarAdvertController = new controllers.ReverseCarAdvertController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseCarAdvertController CarAdvertController = new controllers.javascript.ReverseCarAdvertController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
