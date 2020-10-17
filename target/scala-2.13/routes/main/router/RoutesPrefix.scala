// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Branimir/Desktop/Scala 3/PlayApi/conf/routes
// @DATE:Sat Oct 17 17:20:53 CEST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
