package com.tnm.feed.repository.projection;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


public interface PostWithUserProjection {
     String getPostId();
     String getContent();
     List<String> getTags();
     List<String> getMediaUrl();
     Integer getLikes();
     Integer getShares();
     Integer getComments();
     Date getPostCreated();

    //    USER DATA
     String getUserId();
     String getUsername();
     String getFullName();
//    private List
}
