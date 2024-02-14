package model;

import java.util.List;

public class PostingLogic {
  public void execute(Posting posting, List<Posting> postingList) {
    postingList.add(0, posting); // 先頭に追加
  }
}