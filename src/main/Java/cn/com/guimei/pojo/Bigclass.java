package cn.com.guimei.pojo;;


public class Bigclass {

  private Long id;
  private String bigName;
  private String bigText;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBigName() {
    return bigName;
  }

  public void setBigName(String bigName) {
    this.bigName = bigName;
  }


  public String getBigText() {
    return bigText;
  }

  public void setBigText(String bigText) {
    this.bigText = bigText;
  }

  @Override
  public String toString() {
    return "Bigclass{" +
            "id=" + id +
            ", bigName='" + bigName + '\'' +
            ", bigText='" + bigText + '\'' +
            '}';
  }
}
