package org.plumdev.serve.test.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.plumdev.serve.config.MvcConfig;
import org.plumdev.serve.config.WebSecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Import({ MvcConfig.class, WebSecurityConfiguration.class })
public abstract class AbstractControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext context;

    @BeforeEach
    public void abstractSetUp() {
        mockMvc =
        MockMvcBuilders.webAppContextSetup(context).apply(SecurityMockMvcConfigurers.springSecurity()).build();
    }
}
