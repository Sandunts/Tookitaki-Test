// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sandun/IdeaProjects/PlayTest/conf/routes
// @DATE:Mon Nov 12 10:14:41 AWST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  RangeController_0: controllers.RangeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    RangeController_0: controllers.RangeController
  ) = this(errorHandler, RangeController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, RangeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """price/range/""" + "$" + """startDate<[^/]+>/""" + "$" + """endDate<[^/]+>""", """controllers.RangeController.getCustomRange(startDate:String, endDate:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """price/lastWeek""", """controllers.RangeController.getLastWeek"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """price/lastMonth""", """controllers.RangeController.getLastMonth"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """avg/""" + "$" + """startDate<[^/]+>/""" + "$" + """endDate<[^/]+>""", """controllers.RangeController.getAvgRange(startDate:String, endDate:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_RangeController_getCustomRange0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("price/range/"), DynamicPart("startDate", """[^/]+""",true), StaticPart("/"), DynamicPart("endDate", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RangeController_getCustomRange0_invoker = createInvoker(
    RangeController_0.getCustomRange(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RangeController",
      "getCustomRange",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """price/range/""" + "$" + """startDate<[^/]+>/""" + "$" + """endDate<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_RangeController_getLastWeek1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("price/lastWeek")))
  )
  private[this] lazy val controllers_RangeController_getLastWeek1_invoker = createInvoker(
    RangeController_0.getLastWeek,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RangeController",
      "getLastWeek",
      Nil,
      "GET",
      this.prefix + """price/lastWeek""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_RangeController_getLastMonth2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("price/lastMonth")))
  )
  private[this] lazy val controllers_RangeController_getLastMonth2_invoker = createInvoker(
    RangeController_0.getLastMonth,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RangeController",
      "getLastMonth",
      Nil,
      "GET",
      this.prefix + """price/lastMonth""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_RangeController_getAvgRange3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("avg/"), DynamicPart("startDate", """[^/]+""",true), StaticPart("/"), DynamicPart("endDate", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RangeController_getAvgRange3_invoker = createInvoker(
    RangeController_0.getAvgRange(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RangeController",
      "getAvgRange",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """avg/""" + "$" + """startDate<[^/]+>/""" + "$" + """endDate<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_RangeController_getCustomRange0_route(params@_) =>
      call(params.fromPath[String]("startDate", None), params.fromPath[String]("endDate", None)) { (startDate, endDate) =>
        controllers_RangeController_getCustomRange0_invoker.call(RangeController_0.getCustomRange(startDate, endDate))
      }
  
    // @LINE:3
    case controllers_RangeController_getLastWeek1_route(params@_) =>
      call { 
        controllers_RangeController_getLastWeek1_invoker.call(RangeController_0.getLastWeek)
      }
  
    // @LINE:5
    case controllers_RangeController_getLastMonth2_route(params@_) =>
      call { 
        controllers_RangeController_getLastMonth2_invoker.call(RangeController_0.getLastMonth)
      }
  
    // @LINE:7
    case controllers_RangeController_getAvgRange3_route(params@_) =>
      call(params.fromPath[String]("startDate", None), params.fromPath[String]("endDate", None)) { (startDate, endDate) =>
        controllers_RangeController_getAvgRange3_invoker.call(RangeController_0.getAvgRange(startDate, endDate))
      }
  }
}
