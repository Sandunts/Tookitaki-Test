// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sandun/IdeaProjects/PlayTest/conf/routes
// @DATE:Mon Nov 12 10:14:41 AWST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseRangeController RangeController = new controllers.ReverseRangeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseRangeController RangeController = new controllers.javascript.ReverseRangeController(RoutesPrefix.byNamePrefix());
  }

}
