// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sandun/IdeaProjects/TookiTakiTest/conf/routes
// @DATE:Tue Nov 20 23:45:11 AWST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:9
  class ReversePredictController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def predictData(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "predict")
    }
  
  }

  // @LINE:1
  class ReverseRangeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getAvgRange(startDate:String, endDate:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "avg/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("startDate", startDate)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("endDate", endDate)))
    }
  
    // @LINE:5
    def getLastMonth(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "price/lastMonth")
    }
  
    // @LINE:3
    def getLastWeek(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "price/lastWeek")
    }
  
    // @LINE:1
    def getCustomRange(startDate:String, endDate:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "price/range/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("startDate", startDate)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("endDate", endDate)))
    }
  
  }


}
