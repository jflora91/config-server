package tech.plinth.config.interceptor;

import org.apache.struts.mock.MockHttpServletRequest;
import org.apache.struts.mock.MockHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tech.plinth.config.interceptor.model.RequestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static tech.plinth.config.interceptor.ConfigureRequestContext.HEADER_PLATFORM_ID;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = FlywayAutoConfiguration.class)
@SpringBootTest
public class ConfigureRequestContextTest {

    private MockHttpServletRequest request = new MockHttpServletRequest();
    private MockHttpServletResponse response = new MockHttpServletResponse();

    @Mock
    RequestContext requestContext;

    @InjectMocks
    private ConfigureRequestContext configureRequestContext;

    @BeforeEach
    public void setUp() {
//        when(request.getHeader(HEADER_PLATFORM_ID)).thenReturn(null);
    }

    @Test
    public void preHandleTest() {

        assertEquals(requestContext.getPlatformId(), null);
    }
}
