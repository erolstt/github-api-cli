package github;

import github.pojo.Repositories;
import github.pojo.Tag;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@ShellComponent
public class GitHubCommands {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @ShellMethod("Search Github for repositories that match the given search string and check the tag is latest or not")
    public String search(String searchWord, String tagName) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://api.github.com"));
        Repositories item = restTemplate.
                getForObject( EndPoints.SEARCH + EndPoints.REPOSITORIES + "?q={searchWord}&sort=stars&order=desc&page=1&per_page=1",
                        Repositories.class, searchWord);

        RestTemplate tags = new RestTemplate();
        Tag[] tag = tags.getForObject(item.getTagsUrl(), Tag[].class);

        String tagOnlyNumbers = tag[0].getName().replaceAll("[^0-9\\.]","");

        if (tagName.equals(tagOnlyNumbers)) {
            return item.toString() + ".  You provided latest release tag: " + tagOnlyNumbers;

        }
        else {
            return item.toString() + ".  You provided older release tag. Latest release is " + tagOnlyNumbers;
        }

    }
}