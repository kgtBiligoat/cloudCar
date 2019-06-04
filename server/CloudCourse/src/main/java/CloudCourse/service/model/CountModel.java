package CloudCourse.service.model;

public class CountModel {

  private String eid = "";

  private Long time = 0L;

  private Integer placeId = 0;

  private String address = "";

  private Double longitude = (double) 0;

  private Double latitude = (double) 0;

  public String getEid() {
    return eid;
  }

  public void setEid(String eid) {
    this.eid = eid;
  }

  public Long getTime() {
    return time;
  }

  public void setTime(Long time) {
    this.time = time;
  }

  public Integer getPlaceId() {
    return placeId;
  }

  public void setPlaceId(Integer placeId) {
    this.placeId = placeId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }
}
