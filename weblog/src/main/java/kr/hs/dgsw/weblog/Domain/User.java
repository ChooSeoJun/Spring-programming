package kr.hs.dgsw.weblog.Domain;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity // db와 테이블 매핑
@Data // getter, setter ... 자동 생성
@NoArgsConstructor // 기본 생성자
public class User {
    @Id // primary key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    private long id;
    @Column(nullable = false, unique = true, length = 20) // 중복 되지 않는 id 생성
    private String account;
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 쓰기 전용
    private String password;

    public void setPassword(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512"); // 암호화 방식 지정
            md.update(password.getBytes(),0,password.getBytes().length); // 암호화
            this.password = new BigInteger(1,md.digest()).toString(16); // 패스워드 암호화 적용
            
        }catch(NoSuchAlgorithmException e){
            Logger logger = LoggerFactory.getLogger(User.class);
            logger.warn(e.getMessage());
        }   
    }

    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String profilePath;
    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime created;
    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime modified;

    public User(String account, String password, String name, String email, String phone, String profilePath){
        this.account = account;
        setPassword(password);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.profilePath = profilePath;
    }
}