package com.cos.chat.repository;

import com.cos.chat.domain.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat,String> {

    @Tailable // 커서를 안닫고 계속 유지한다.
    @Query("{sender: ?0, receiver: ?1}")
    Flux<Chat> mFindBySender(String sender, String receiver); // Flux(흐름) reponse를 유지하면서 계속 데이터를 흘려보내기
}