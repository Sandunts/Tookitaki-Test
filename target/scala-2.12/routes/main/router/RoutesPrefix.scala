// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sandun/IdeaProjects/TookiTakiTest/conf/routes
// @DATE:Tue Nov 20 23:45:11 AWST 2018


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
