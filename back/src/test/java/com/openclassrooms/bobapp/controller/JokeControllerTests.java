package com.openclassrooms.bobapp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.openclassrooms.bobapp.model.Joke;
import com.openclassrooms.bobapp.service.JokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class JokeControllerTest {

  @Mock
  private JokeService jokeService;

  @InjectMocks
  private JokeController jokeController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetRandomJokes_CallsJokeService() {
    Joke mockJoke = new Joke(
      "Que fait un geek quand il descend du métro ?",
      "Il libère la RAM"
    );

    when(jokeService.getRandomJoke()).thenReturn(mockJoke);

    ResponseEntity<?> response = jokeController.getRandomJokes();

    verify(jokeService, times(1)).getRandomJoke();

    assertNotNull(response);
    assertEquals(200, response.getStatusCodeValue());

    assertEquals(mockJoke, response.getBody());
  }
}
