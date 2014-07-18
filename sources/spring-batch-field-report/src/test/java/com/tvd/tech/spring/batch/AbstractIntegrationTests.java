package com.tvd.tech.spring.batch;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:/META-INF/spring/batch/webapp-config-test.xml",
"classpath:/META-INF/spring/batch/jobs/*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractIntegrationTests {

}
