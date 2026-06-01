package com.tns.post.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User who created the post
    private Long userId;

    private String content;

    // Image/Video stored in S3, Cloudinary, etc.
    private String mediaUrl;

    private String mediaType; // IMAGE, VIDEO

    // Status expires after 24 hours
    private LocalDateTime expiresAt;

    // Number of views
    private Long viewCount;

    // Number of likes
    private Long likeCount;

    // Audit fields
    private String createdBy;

    private String updatedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}