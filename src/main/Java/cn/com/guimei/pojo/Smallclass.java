package cn.com.guimei.pojo;


public class Smallclass {

  private Long id;
  private String smallName;
  private Long smallBigId;
  private String smallText;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSmallName() {
    return smallName;
  }

  public void setSmallName(String smallName) {
    this.smallName = smallName;
  }

  public Long getSmallBigId() {
    return smallBigId;
  }

  public void setSmallBigId(Long smallBigId) {
    this.smallBigId = smallBigId;
  }

  public String getSmallText() {
    return smallText;
  }

  public void setSmallText(String smallText) {
    this.smallText = smallText;
  }

  @Override
  public String toString() {
    return "Smallclass{" +
            "id=" + id +
            ", smallName='" + smallName + '\'' +
            ", smallBigId=" + smallBigId +
            ", smallText='" + smallText + '\'' +
            '}';
  }
}
