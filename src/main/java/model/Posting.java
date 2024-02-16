package model;
import java.io.Serializable;

public class Posting implements Serializable {
  private String userName; // ユーザー名
  private String place; // 喫煙所名
  private String time; //滞在時間
  private String nowTime; //現在時刻
  private boolean pushButtan; //レスポンスボタンが押されたかどうか
  private int id; //投稿
  
  public Posting() { }
  public Posting(String userName, String place,String time,String nowTime,int id) {
    this.userName = userName;
    this.place = place;
    this.time = time;
    this.nowTime = nowTime;
    this.id = id;
  }
  
  
  public String getUserName() { return userName; }
  public String getPlace() { return place; }
  public String getTime() { return time; }
  public String getNowTime() {return nowTime;}
  public int getId() {return id;}
  
}