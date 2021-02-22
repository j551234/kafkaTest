package model;

public class CSVModel {
    private String Year;
    private String Month;
    private String DayofMonth;
    private String DayOfWeek;
    private String DepTime;
    private String CRSDepTime;
    private String ArrTime;
    private String CRSArrTime;
    private String UniqueCarrier;
    private String FlightNum;
    private String TailNum;
    private String ActualElapsedTime;
    private String CRSElapsedTime;
    private String AirTime;
    private String ArrDelay;
    private String DepDelay;
    private String Origin;
    private String Dest;
    private String Distance;
    private String TaxiIn;
    private String TaxiOut;
    private String Cancelled;
    private String CancellationCode;
    private String Diverted;
    private String CarrierDelay;
    private String WeatherDelay;
    private String NASDelay;
    private String SecurityDelay;
    private String LateAircraftDelay;

  public String getYear() {
    return Year;
  }

  public void setYear(String year) {
    Year = year;
  }

  public String getMonth() {
    return Month;
  }

  public void setMonth(String month) {
    Month = month;
  }

  public String getDayofMonth() {
    return DayofMonth;
  }

  public void setDayofMonth(String dayofMonth) {
    DayofMonth = dayofMonth;
  }

  public String getDayOfWeek() {
    return DayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek) {
    DayOfWeek = dayOfWeek;
  }

  public String getDepTime() {
    return DepTime;
  }

  public void setDepTime(String depTime) {
    DepTime = depTime;
  }

  public String getCRSDepTime() {
    return CRSDepTime;
  }

  public void setCRSDepTime(String CRSDepTime) {
    this.CRSDepTime = CRSDepTime;
  }

  public String getArrTime() {
    return ArrTime;
  }

  public void setArrTime(String arrTime) {
    ArrTime = arrTime;
  }

  public String getCRSArrTime() {
    return CRSArrTime;
  }

  public void setCRSArrTime(String CRSArrTime) {
    this.CRSArrTime = CRSArrTime;
  }

  public String getUniqueCarrier() {
    return UniqueCarrier;
  }

  public void setUniqueCarrier(String uniqueCarrier) {
    UniqueCarrier = uniqueCarrier;
  }

  public String getFlightNum() {
    return FlightNum;
  }

  public void setFlightNum(String flightNum) {
    FlightNum = flightNum;
  }

  public String getTailNum() {
    return TailNum;
  }

  public void setTailNum(String tailNum) {
    TailNum = tailNum;
  }

  public String getActualElapsedTime() {
    return ActualElapsedTime;
  }

  public void setActualElapsedTime(String actualElapsedTime) {
    ActualElapsedTime = actualElapsedTime;
  }

  public String getCRSElapsedTime() {
    return CRSElapsedTime;
  }

  public void setCRSElapsedTime(String CRSElapsedTime) {
    this.CRSElapsedTime = CRSElapsedTime;
  }

  public String getAirTime() {
    return AirTime;
  }

  public void setAirTime(String airTime) {
    AirTime = airTime;
  }

  public String getArrDelay() {
    return ArrDelay;
  }

  public void setArrDelay(String arrDelay) {
    ArrDelay = arrDelay;
  }

  public String getDepDelay() {
    return DepDelay;
  }

  public void setDepDelay(String depDelay) {
    DepDelay = depDelay;
  }

  public String getOrigin() {
    return Origin;
  }

  public void setOrigin(String origin) {
    Origin = origin;
  }

  public String getDest() {
    return Dest;
  }

  public void setDest(String dest) {
    Dest = dest;
  }

  public String getDistance() {
    return Distance;
  }

  public void setDistance(String distance) {
    Distance = distance;
  }

  public String getTaxiIn() {
    return TaxiIn;
  }

  public void setTaxiIn(String taxiIn) {
    TaxiIn = taxiIn;
  }

  public String getTaxiOut() {
    return TaxiOut;
  }

  public void setTaxiOut(String taxiOut) {
    TaxiOut = taxiOut;
  }

  public String getCancelled() {
    return Cancelled;
  }

  public void setCancelled(String cancelled) {
    Cancelled = cancelled;
  }

  public String getCancellationCode() {
    return CancellationCode;
  }

  public void setCancellationCode(String cancellationCode) {
    CancellationCode = cancellationCode;
  }

  public String getDiverted() {
    return Diverted;
  }

  public void setDiverted(String diverted) {
    Diverted = diverted;
  }

  public String getCarrierDelay() {
    return CarrierDelay;
  }

  public void setCarrierDelay(String carrierDelay) {
    CarrierDelay = carrierDelay;
  }

  public String getWeatherDelay() {
    return WeatherDelay;
  }

  public void setWeatherDelay(String weatherDelay) {
    WeatherDelay = weatherDelay;
  }

  public String getNASDelay() {
    return NASDelay;
  }

  public void setNASDelay(String NASDelay) {
    this.NASDelay = NASDelay;
  }

  public String getSecurityDelay() {
    return SecurityDelay;
  }

  public void setSecurityDelay(String securityDelay) {
    SecurityDelay = securityDelay;
  }

  public String getLateAircraftDelay() {
    return LateAircraftDelay;
  }

  public void setLateAircraftDelay(String lateAircraftDelay) {
    LateAircraftDelay = lateAircraftDelay;
  }

  public CSVModel(String year, String month, String dayofMonth, String dayOfWeek, String depTime, String CRSDepTime,
                  String arrTime, String CRSArrTime, String uniqueCarrier, String flightNum, String tailNum,
                  String actualElapsedTime, String CRSElapsedTime, String airTime, String arrDelay, String depDelay,
                  String origin, String dest, String distance, String taxiIn, String taxiOut, String cancelled,
                  String cancellationCode, String diverted, String carrierDelay, String weatherDelay, String NASDelay
          , String securityDelay, String lateAircraftDelay) {
    Year = year;
    Month = month;
    DayofMonth = dayofMonth;
    DayOfWeek = dayOfWeek;
    DepTime = depTime;
    this.CRSDepTime = CRSDepTime;
    ArrTime = arrTime;
    this.CRSArrTime = CRSArrTime;
    UniqueCarrier = uniqueCarrier;
    FlightNum = flightNum;
    TailNum = tailNum;
    ActualElapsedTime = actualElapsedTime;
    this.CRSElapsedTime = CRSElapsedTime;
    AirTime = airTime;
    ArrDelay = arrDelay;
    DepDelay = depDelay;
    Origin = origin;
    Dest = dest;
    Distance = distance;
    TaxiIn = taxiIn;
    TaxiOut = taxiOut;
    Cancelled = cancelled;
    CancellationCode = cancellationCode;
    Diverted = diverted;
    CarrierDelay = carrierDelay;
    WeatherDelay = weatherDelay;
    this.NASDelay = NASDelay;
    SecurityDelay = securityDelay;
    LateAircraftDelay = lateAircraftDelay;
  }
}
