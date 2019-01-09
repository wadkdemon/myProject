package cn.com.guimei.pojo;


public class Goods {

  private Long id;
  private String goodsName;
  private Long goodsSmalId;
  private Double goodsMoney;
  private Long goodsNumber;
  private String goodsImage;
  private Double goodsCarriage;
  private Long goodsType;
  private Long goodsDiscId;


  @Override
  public String toString() {
    return "Goods{" +
            "id=" + id +
            ", goodsName='" + goodsName + '\'' +
            ", goodsSmalId=" + goodsSmalId +
            ", goodsMoney=" + goodsMoney +
            ", goodsNumber=" + goodsNumber +
            ", goodsImage='" + goodsImage + '\'' +
            ", goodsCarriage=" + goodsCarriage +
            ", goodsType=" + goodsType +
            ", goodsDiscId=" + goodsDiscId +
            '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public Long getGoodsSmalId() {
    return goodsSmalId;
  }

  public void setGoodsSmalId(Long goodsSmalId) {
    this.goodsSmalId = goodsSmalId;
  }

  public Double getGoodsMoney() {
    return goodsMoney;
  }

  public void setGoodsMoney(Double goodsMoney) {
    this.goodsMoney = goodsMoney;
  }

  public Long getGoodsNumber() {
    return goodsNumber;
  }

  public void setGoodsNumber(Long goodsNumber) {
    this.goodsNumber = goodsNumber;
  }

  public String getGoodsImage() {
    return goodsImage;
  }

  public void setGoodsImage(String goodsImage) {
    this.goodsImage = goodsImage;
  }

  public Double getGoodsCarriage() {
    return goodsCarriage;
  }

  public void setGoodsCarriage(Double goodsCarriage) {
    this.goodsCarriage = goodsCarriage;
  }

  public Long getGoodsType() {
    return goodsType;
  }

  public void setGoodsType(Long goodsType) {
    this.goodsType = goodsType;
  }

  public Long getGoodsDiscId() {
    return goodsDiscId;
  }

  public void setGoodsDiscId(Long goodsDiscId) {
    this.goodsDiscId = goodsDiscId;
  }
}
