package cn.com.guimei.pojo;


public class Superuser {

  private Long id;
  private String userName;
  private String userPassword;
  private String userImage;
  private Long userStatus;
  private String userId;
  private String userLoginName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserImage() {
    return userImage;
  }

  public void setUserImage(String userImage) {
    this.userImage = userImage;
  }

  public Long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Long userStatus) {
    this.userStatus = userStatus;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserLoginName() {
    return userLoginName;
  }

  public void setUserLoginName(String userLoginName) {
    this.userLoginName = userLoginName;
  }

  @Override
  public String toString() {
    return "Superuser{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userImage='" + userImage + '\'' +
            ", userStatus=" + userStatus +
            ", userId='" + userId + '\'' +
            ", userLoginName='" + userLoginName + '\'' +
            '}';
  }
}
