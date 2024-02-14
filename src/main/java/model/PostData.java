package model;
import java.io.Serializable;

public class PostData implements Serializable {
  private String place; // ユーザー名
  private String time; // パスワード
  private String nowTime;//投稿時刻

  public PostData() { }
  public PostData(String place, String time,String nowTime) {
    this.place = place;
    this.time = time;
    this.nowTime = nowTime;
  }
  public String getPlace() { return place; }
  public String getTime() { return time; }
  public String getNowTime() {return nowTime;}
}