package model;

import java.util.List;

public class PostingLogic {
  public void execute(PostData postData, List<Posting> postingList) {
    postingList.add(0, postData); // 先頭に追加
  }
}