// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sandun/IdeaProjects/TookiTakiTest/conf/routes
// @DATE:Tue Nov 20 23:45:11 AWST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:9
  class ReversePredictController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def predictData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PredictController.predictData",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "predict"})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseRangeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getAvgRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RangeController.getAvgRange",
      """
        function(startDate0,endDate1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "avg/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("startDate", startDate0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("endDate", endDate1))})
        }
      """
    )
  
    // @LINE:5
    def getLastMonth: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RangeController.getLastMonth",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "price/lastMonth"})
        }
      """
    )
  
    // @LINE:3
    def getLastWeek: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RangeController.getLastWeek",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "price/lastWeek"})
        }
      """
    )
  
    // @LINE:1
    def getCustomRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RangeController.getCustomRange",
      """
        function(startDate0,endDate1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "price/range/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("startDate", startDate0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("endDate", endDate1))})
        }
      """
    )
  
  }


}
