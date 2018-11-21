package controllers

import java.sql.{ResultSet, Timestamp}
import java.text.SimpleDateFormat
import java.util.Date

import grizzled.slf4j.Logger
import javax.inject.Inject
import org.json.{JSONArray, JSONObject}
import play.api.db.Database
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

import scala.collection.mutable.ListBuffer

class PredictController @Inject()(db: Database, cc: ControllerComponents) extends AbstractController(cc){

  val logger = Logger("PredictController")
  val rangeObj = new RangeController(db, cc)
  val outSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  val resultSdf = new SimpleDateFormat("yyyy-MM-dd");

  def predictData() = Action { implicit request: Request[AnyContent] =>

    val jsonarray = new JSONArray();
    val con = db.getConnection()

    val stamp = new Timestamp(System.currentTimeMillis());
    val today = new Date(stamp.getTime());

    val twelveDaysEarlier = rangeObj.getEarlierDate(today, -12)

    val priceList = new ListBuffer[Double]

    try {

      val resultSet = rangeObj.getResultSet(con, "SELECT * from " + rangeObj.table + " where time between '" + rangeObj.convertDatetoString(twelveDaysEarlier, outSdf) + "' AND '" + rangeObj.convertDatetoString(today, outSdf) + "'")

      while (resultSet.next()) {
        priceList += resultSet.getDouble("price")
        System.out.print(resultSet.getDouble("price") + " ")
      }

    } catch {

      case e: java.text.ParseException => logger.info("Invalid Url: use the {hostname}:{port}/price/lastWeek")
      case ex: Exception => ex.printStackTrace

    } finally {

      con.close()

    }

    for (i <- 1 to 15) {

      val predictNext = predictNextDay(0.5, priceList)
      val day = rangeObj.getEarlierDate(today, i)

      val jsonobj = new JSONObject();
      jsonobj.put("PredictedPrice", predictNext.toString)
      jsonobj.put("date", rangeObj.convertDatetoString(day, resultSdf))

      jsonarray.put(jsonobj)

      for (i <- 11 to 1 by -1) {

        priceList(i) = priceList(i -1)

      }

      priceList(0) = predictNext

/*      for ( i <- 0 to 11 ) {
        System.out.print(priceList(i) + " ")
      }
      System.out.print("\n")*/

  }

    //Ok(predictNextDay(0.5, priceList).toString)
   Ok(jsonarray.toString)

  }

  def predictNextDay(x: Double, priceList: ListBuffer[Double]): Double ={

    val predictedValue = x * priceList(0) + x * (1-x) * priceList(1) + x * (1-x) * (1-x) * priceList(2) + x * (1-x) * (1-x) * (1-x) * priceList(3) + x * (1-x) * (1-x) * (1-x) * (1-x) * priceList(4) + x * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * priceList(5) + x * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * priceList(6) + x * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * priceList(7) + x * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * priceList(8) + x * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * priceList(9) + x * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * priceList(10) + x * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * (1-x) * priceList(11);

    return predictedValue;

  }

}
