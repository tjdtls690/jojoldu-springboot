package com.tjdtls690.practice.springboot.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    private PostsRepository postsRepository;
    
    @Test
    void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "tjdtls690@gmail.com";
        
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        
        // when
        List<Posts> postsList = postsRepository.findAll();
        
        // then
        Posts posts = postsList.get(0);
        assertAll(
                () -> assertThat(posts.getTitle()).isEqualTo(title),
                () -> assertThat(posts.getContent()).isEqualTo(content),
                () -> assertThat(posts.getAuthor()).isEqualTo(author)
        );
    }
    
    @AfterEach
    void tearDown() {
        postsRepository.deleteAll();
    }
}