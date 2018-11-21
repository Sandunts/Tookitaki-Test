// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sandun/IdeaProjects/PlayTest/conf/routes
// @DATE:Mon Nov 12 10:14:41 AWST 2018


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
