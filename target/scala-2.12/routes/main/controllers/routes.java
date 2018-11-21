// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sandun/IdeaProjects/TookiTakiTest/conf/routes
// @DATE:Tue Nov 20 23:45:11 AWST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReversePredictController PredictController = new controllers.ReversePredictController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseRangeController RangeController = new controllers.ReverseRangeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReversePredictController PredictController = new controllers.javascript.ReversePredictController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseRangeController RangeController = new controllers.javascript.ReverseRangeController(RoutesPrefix.byNamePrefix());
  }

}
