package com.thesun4sky.springblog.controller;

import com.thesun4sky.springblog.dto.ApiResponseDto;
import com.thesun4sky.springblog.dto.SignRequestDto;
import com.thesun4sky.springblog.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto> signUp(@RequestBody @Valid SignRequestDto requestDto) {

        userService.signup(requestDto);

        return ResponseEntity.status(201).body(new ApiResponseDto("회원가입 성공", 200));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto> login(@RequestBody @Valid SignRequestDto requestDto, HttpServletResponse res) {

        userService.login(requestDto, res);

        return ResponseEntity.status(200).body(new ApiResponseDto("로그인 성공", 200));
    }

}
