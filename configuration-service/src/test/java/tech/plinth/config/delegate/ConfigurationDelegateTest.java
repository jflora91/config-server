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
import tech.plinth.config.database.repository.BaseRepository;
import tech.plinth.config.database.repository.ConfigurationRepository;
import tech.plinth.config.interceptor.model.RequestContext;

import static org.mockito.Mockito.when;

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
}
//todo tests
//    @Test
//    public void getVersionWithNullTest() throws JsonPatchException {
//
//    }

