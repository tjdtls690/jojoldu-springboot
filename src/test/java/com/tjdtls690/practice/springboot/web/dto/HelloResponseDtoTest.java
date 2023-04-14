package com.tjdtls690.practice.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HelloResponseDtoTest {
    @Test
    void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;
        
        // when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);
        
        // then
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
    }
}