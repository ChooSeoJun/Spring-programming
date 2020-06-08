package kr.hs.dgsw.weblog.Domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본값 == auto, IDENTITY == DB에게 맡김
    private Long id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String title;
    //LOB BLOB CLOB
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) // 1:N 관계 -> 하나의 포스트에 여러가지 그림이 올라감, Entity 변경시 db의 변경을 결정함 == cascade  /EAGER = 미리 값을 다 불러옴
    private List<Attachment> pictures;
    @CreationTimestamp // 최초 시간
    @Column(updatable = false, nullable = false) // 갱신 불가 == updatable = false
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    @UpdateTimestamp // 변경 시간
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modified;

    public Post(Long userId, String title, String content){
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    
}