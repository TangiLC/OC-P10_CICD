package com.openclassrooms.bobapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.openclassrooms.bobapp.data.JsonReader;
import com.openclassrooms.bobapp.model.Joke;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class JokeServiceTest {

  @Mock
  private JsonReader jsonReader;

  @InjectMocks
  private JokeService jokeService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetRandomJoke() {
    List<Joke> mockJokes = Arrays.asList(
      new Joke("C'est l'histoire du ptit dej, tu la connais ?", "Pas de bol."),
      new Joke("C'est l'histoire d'une blague vaseuse", "Mets tes bottes."),
      new Joke(
        "Que demande un footballeur à son coiffeur ?",
        "La coupe du monde s’il vous plaît"
      )
    );

    when(jsonReader.getJokes()).thenReturn(mockJokes);

    Joke randomJoke = jokeService.getRandomJoke();

    assertNotNull(randomJoke, "Returned joke is not null");
    assertTrue(mockJokes.contains(randomJoke), "Returned joke belongs to list");

    verify(jsonReader, times(1)).getJokes();
  }

  @Test
  void testGetRandomJokeWithOneJoke() {
    List<Joke> singleJokeList = List.of(
      new Joke(
        "Que fait un geek quand il descend du métro ?",
        "Il libère la RAM"
      )
    );

    when(jsonReader.getJokes()).thenReturn(singleJokeList);

    Joke randomJoke = jokeService.getRandomJoke();

    assertNotNull(randomJoke);
    assertEquals(
      "Que fait un geek quand il descend du métro ?",
      randomJoke.getJoke()
    );
    assertEquals("Il libère la RAM", randomJoke.getResponse());

    verify(jsonReader, times(1)).getJokes();
  }
}
