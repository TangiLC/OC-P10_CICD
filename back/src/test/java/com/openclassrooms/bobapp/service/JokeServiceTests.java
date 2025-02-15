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
  private JsonReader jsonReader; // Mock de JsonReader

  @InjectMocks
  private JokeService jokeService; // Injecte le mock dans JokeService

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this); // Initialise les mocks avant chaque test
  }

  @Test
  void testGetRandomJoke() {
    // Création d'une liste de blagues simulée
    List<Joke> mockJokes = Arrays.asList(
      new Joke("C'est l'histoire du ptit dej, tu la connais ?", "Pas de bol."),
      new Joke("C'est l'histoire d'une blague vaseuse", "Mets tes bottes."),
      new Joke(
        "Que demande un footballeur à son coiffeur ?",
        "La coupe du monde s’il vous plaît"
      )
    );

    // Simulation du comportement de jsonReader.getJokes()
    when(jsonReader.getJokes()).thenReturn(mockJokes);

    // Exécution du service
    Joke randomJoke = jokeService.getRandomJoke();

    // Vérifications
    assertNotNull(randomJoke, "La blague retournée ne doit pas être null");
    assertTrue(
      mockJokes.contains(randomJoke),
      "La blague doit être issue de la liste simulée"
    );

    // Vérifie que getJokes() a été appelé une seule fois
    verify(jsonReader, times(1)).getJokes();
  }

  @Test
  void testGetRandomJokeWithOneJoke() {
    // Simule une liste contenant une seule blague
    List<Joke> singleJokeList = List.of(
      new Joke(
        "Pourquoi les plongeurs plongent-ils toujours en arrière ?",
        "Parce que sinon, ils tombent dans le bateau."
      )
    );

    when(jsonReader.getJokes()).thenReturn(singleJokeList);

    Joke randomJoke = jokeService.getRandomJoke();

    assertNotNull(randomJoke);
    assertEquals(
      "Pourquoi les plongeurs plongent-ils toujours en arrière ?",
      randomJoke.getJoke()
    );
    assertEquals(
      "Parce que sinon, ils tombent dans le bateau.",
      randomJoke.getResponse()
    );

    verify(jsonReader, times(1)).getJokes();
  }
}
