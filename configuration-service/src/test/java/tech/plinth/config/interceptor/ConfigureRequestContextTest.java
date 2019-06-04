package tech.plinth.config.interceptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tech.plinth.config.interceptor.model.RequestContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static tech.plinth.config.interceptor.ConfigureRequestContext.HEADER_PLATFORM_ID;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = FlywayAutoConfiguration.class)
@SpringBootTest
public class ConfigureRequestContextTest {

    @Mock
    RequestContext requestContext;

    @Mock
    MockHttpServletRequest request;

    @Mock
    MockHttpServletResponse response;

    @InjectMocks
    private ConfigureRequestContext configureRequestContext;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void preHandleNullPlatformIdTest() throws Exception {
        when(request.getHeader(HEADER_PLATFORM_ID)).thenReturn(null);
        assertFalse(configureRequestContext.preHandle(request, response, null));
    }

    @Test
    public void preHandleTest() throws Exception {
        when(request.getHeader(HEADER_PLATFORM_ID)).thenReturn("google.com");
        assertTrue(configureRequestContext.preHandle(request, response, null));
    }
}
