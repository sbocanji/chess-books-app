package com.project.chessbooksapp.book.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class BookRecommendationConfiguration {
    @Bean
    public RecommendBookChain activePlayerRule(@Qualifier("world")RecommendBookChain chain2) {
        RecommendBookChain chain1 = new ActivePlayerRule();
        chain1.setNext(chain2);
        return  chain1;
    }
   // @Bean
}
