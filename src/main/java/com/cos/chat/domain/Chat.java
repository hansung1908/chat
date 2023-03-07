package com.cos.chat.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chat")
public class Chat {

    @Id
    private String id;
    private String msg;
    private String sender;
    private String receiver; // 받는 사람 (귓속말)
    private Integer roomNum; // 채팅방 번호

    private LocalDateTime createdAt;
}
