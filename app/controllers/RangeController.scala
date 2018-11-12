package controllers

import java.io.File
import java.sql.ResultSet
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.sql.Timestamp

import com.typesafe.config.ConfigFactory
import play.api.mvc._
import javax.inject._
import play.api.db.Database
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import grizzled.slf4j.Logger

import scala.collection.mutable.ListBuffer

/* @Author Sandun tharaka Siriwardhana
   Programming assignment for Tookitaki company
*/

class RangeController @Inject()(db: Database, cc: ControllerComponents) extends AbstractController(cc){

  val logger = Logger("RangeController")
  logger.info("Starting the application")

  val inSdf = new SimpleDateFormat("yyyyMMdd");
  val outSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  val table = "bitcoin_prices"

  /*val config = readConfFile()
  System.out.print(config.getString("test"))*/

  def getCustomRange(startDate: String, endDate: String) = Action { implicit request: Request[AnyContent] =>

    val jsonarray = new JSONArray();
    val con = db.getConnection()

    try {

      val resultSet = getResultSet(con, "SELECT * from " + table + " where time between '" + convertDateFormat(startDate, inSdf, outSdf) + "' AND '" + convertDateFormat(endDate, inSdf, outSdf) + "'")
      addToJsonArray(jsonarray, resultSet)

    } catch {

      case e: java.text.ParseException => logger.info("Invalid Url: use the {hostname}:{port}/price/range/{startDate}/{endDate} use yyyyddMM for date formats")
      case ex: Exception => ex.printStackTrace

    } finally {

      con.close()

    }

    Ok(jsonarray.toString)
  }

  def getAvgRange(startDate: String, endDate: String) = Action { implicit request: Request[AnyContent] =>

    val jsonarray = new JSONArray();
    val con = db.getConnection()

    try {

      val resultSet = getResultSet(con, "SELECT * from " + table + " where time between '" + convertDateFormat(startDate, inSdf, outSdf) + "' AND '" + convertDateFormat(endDate, inSdf, outSdf) + "'")
      getAvg(jsonarray, resultSet)

    } catch {

      case e: java.text.ParseException => logger.info("Invalid Url: use the {hostname}:{port}/avg/{startDate}/{endDate} use yyyyddMM for date formats")
      case ex: Exception => ex.printStackTrace

    } finally {

      con.close()

    }

    Ok(jsonarray.toString)
  }

  def getLastWeek() = Action { implicit request: Request[AnyContent] =>

    val jsonarray = new JSONArray();
    val con = db.getConnection()

    val stamp = new Timestamp(System.currentTimeMillis());
    val today = new Date(stamp.getTime());

    val oneWeekBefore = getWeekBefore(today)

    try {

      val resultSet = getResultSet(con, "SELECT * from " + table + " where time between '" + convertDatetoString(oneWeekBefore, outSdf) + "' AND '" + convertDatetoString(today, outSdf) + "'")
      addToJsonArray(jsonarray, resultSet)

    } catch {

      case e: java.text.ParseException => logger.info("Invalid Url: use the {hostname}:{port}/price/lastWeek")
      case ex: Exception => ex.printStackTrace

    } finally {

      con.close()

    }

    Ok(jsonarray.toString)
  }

  def getLastMonth() = Action { implicit request: Request[AnyContent] =>

    val jsonarray = new JSONArray();
    val con = db.getConnection()

    val stamp = new Timestamp(System.currentTimeMillis());
    val today = new Date(stamp.getTime());

    val oneMonthBefore = getMonthBefore(today)

    try {

      val resultSet = getResultSet(con, "SELECT * from " + table + " where time between '" + convertDatetoString(oneMonthBefore, outSdf) + "' AND '" + convertDatetoString(today, outSdf) + "'")
      addToJsonArray(jsonarray, resultSet)

    } catch {

      case e: java.text.ParseException => logger.info("Invalid Url: use the {hostname}:{port}/price/lastMonth")
      case ex: Exception => ex.printStackTrace

    } finally {

      con.close()

    }

    Ok(jsonarray.toString)
  }


  def getResultSet(conn: java.sql.Connection, query: String): ResultSet ={

      val stmt = conn.createStatement
      val rs = stmt.executeQuery(query)

      return rs;

  }

  def addToJsonArray(jsonarray: JSONArray, resultSet: ResultSet): Unit ={

    while (resultSet.next()) {

      val jsonobj = new JSONObject();
      jsonobj.put("price", resultSet.getString("price"))
      jsonobj.put("time", resultSet.getString("time"))

      jsonarray.put(jsonobj)

    }

  }

  def getAvg(jsonarray: JSONArray, resultSet: ResultSet): Unit ={

    var list = ListBuffer[BigDecimal]()

    while (resultSet.next()) {

      list += resultSet.getBigDecimal("price")

    }

    val avg = list.reduce(_+_) / list.size

    val jsonobj = new JSONObject();
    jsonobj.put("avg", avg)

    jsonarray.put(jsonobj)

  }

  def convertDateFormat(dateString: String, inSdf: SimpleDateFormat, outSdf: SimpleDateFormat): String = {

    val date = inSdf.parse(dateString);
    val outDateString = outSdf.format(date)

    return outDateString

  }

  def getWeekBefore(date: java.util.Date): java.util.Date ={

    val calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, -7);

    return calendar.getTime

  }

  def getMonthBefore(date: java.util.Date): java.util.Date ={

    val calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.MONTH, -1);

    return calendar.getTime

  }

  def convertDatetoString(date: java.util.Date, sdf: SimpleDateFormat): String ={

    val dateString = sdf.format(date)

    return dateString

  }

  def readConfFile(): com.typesafe.config.Config = {

    val filePath = new File("").getAbsolutePath
    val config = ConfigFactory.parseFile(new File(filePath + "/home/sandun/IdeaProjects/PlayTest/conf/tookitakiTest.conf"))

    if (config.isEmpty) {
      logger.error("Configuration file not found PlayTest/conf/tookitakiTest.conf")
      sys.exit(0)
    } else {
      logger.debug("PlayTest/conf/tookitakiTest.conf added for config")
    }

    config

  }

}