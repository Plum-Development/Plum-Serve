package org.plumdev.serve.test.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.plumdev.serve.entities.MediaItem;
import org.plumdev.serve.services.MediaService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MediaControllerTest extends AbstractControllerTest {

    private static final String BASE_URL = "/media";

    @MockBean
    private MediaService mediaService;

    private MediaItem mediaItem1;
    private MediaItem mediaItem2;
    private List<MediaItem> mediaItems;

    @BeforeEach
    public void setUp() {
        mediaItem1 = new MediaItem("Movie 1", "movie", "url1").setId(1);
        mediaItem2 = new MediaItem("Movie 2", "movie", "url2").setId(2);
        mediaItems = List.of(mediaItem1, mediaItem2);
    }

    @Test
    public void getAllMediaItems() throws Exception {
        when(mediaService.getAll()).thenReturn(mediaItems);

        var json = mockMvc
            .perform(get(BASE_URL))
            .andDo(print())
            .andExpectAll(
                status().isOk(),
                content().contentType("application/json"),
                jsonPath("$").isArray(),
                jsonPath("$[0]").value(mediaItem1),
                jsonPath("$[1]").value(mediaItem2)
            )
            .andReturn()
            .getAsyncResult();

        System.out.println(json);
    }
}
