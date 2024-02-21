package model;

import java.io.Serializable;

public class PostData implements Serializable {
    private String userName; // ユーザー名
    private String place; // 喫煙所名
    private String time; // 滞在時間
    private int id; // ID

    public PostData() {
    }

    public PostData(String userName, String place, String time, int id) {
        this.userName = userName;
        this.place = place;
        this.time = time;
        this.id = id;
    }
    
    public PostData(String userName, String place, String time) {
        this.userName = userName;
        this.place = place;
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
