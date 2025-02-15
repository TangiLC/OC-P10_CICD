package com.openclassrooms.bobapp.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.Spy;

class JsonReaderTests {

  @Spy
  private JsonReader jsonReader;

  @BeforeEach
  void setUp() {
    jsonReader = spy(JsonReader.getInstance());
  }

  @Test
  void testGetJokes_CalledOnce() {
    jsonReader.getJokes();

    verify(jsonReader, times(1)).getJokes();
  }
}
