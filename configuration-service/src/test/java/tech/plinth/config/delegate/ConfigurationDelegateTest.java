package tech.plinth.config.delegate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;
import tech.plinth.config.database.model.Base;
import tech.plinth.config.database.model.Configuration;
import tech.plinth.config.database.repository.BaseRepository;
import tech.plinth.config.database.repository.ConfigurationRepository;
import tech.plinth.config.interceptor.model.RequestContext;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@EnableAutoConfiguration(exclude = FlywayAutoConfiguration.class)
@SpringBootTest
public class ConfigurationDelegateTest {

    @Mock
    private ConfigurationRepository configurationRepository;

    @Mock
    private BaseRepository baseRepository;

    @Mock
    private RequestContext requestContext;

    @InjectMocks
    private ConfigurationDelegate configurationDelegate;

    private Long baseVersion;
    private JsonNode baseJsonNode;

    private String configurationPlatform;
    private Long configurationVersion;
    private JsonNode configurationJsonNode;

    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        baseVersion = 1L;
        configurationPlatform = "configuration.plinth.com";
        configurationVersion = 40L;
        mapper = new ObjectMapper();

        when(requestContext.getPlatformId()).thenReturn(configurationPlatform);

    }

    @Test
    public void getVersionWithNullTest() throws JsonPatchException {

    }

