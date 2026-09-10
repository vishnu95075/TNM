package com.tnm.feed.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FeedDtoResponse {
//    POST DATA
    private String postId;
    private String content;
    private List<String> tags;
    private List<String> mediaUrls;
    private Integer likes;
    private Integer shares;
    private Integer comments;
    private Date postCreated;

//    USER DATA
    private String userId;
    private String username;
    private String fullName;
//    private List<String> profileType; Its changes in future for base on user type like paid user, public service, leader, actor


}
