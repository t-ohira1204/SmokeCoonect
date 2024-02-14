package model;
import java.io.Serializable;

public class Point implements Serializable {
  private int point; // 所有ポイント数

  public Point() { }
  public Point(int point) {
    this.point = point;
  }
  public int getPoint() { return point; }
}