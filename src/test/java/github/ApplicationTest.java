package github;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ApplicationTest {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    GitHubCommands gitHubCommands = new GitHubCommands();

    @Test
    public void testLoadTemplate() {
        assertThat(restTemplate).isNotNull();
    }

    @Test
    public void testGitHubCommands() {
        assertThat(gitHubCommands).isNotNull();
    }

}