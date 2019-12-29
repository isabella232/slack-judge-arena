package de.qaware.qpi.slack.slackjudgearea;

import de.qaware.qpi.slack.slackjudgearea.model.UserProfile;
import de.qaware.qpi.slack.slackjudgearea.model.UserProfileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestService.class);

    private final RestTemplate restTemplate;

    @Value("${slack.api.token}")
    private String apiToken;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void sendActionCallback(String url, String payload) {

        LOGGER.info("Call slack url '{}'", url);

        ResponseEntity<String> response = this.restTemplate.postForEntity(url, payload, String.class);

        LOGGER.info("Status code: {}", response.getStatusCode());
    }

    public UserProfile getUserProfile(String userId) {

        Map<String, String> params = new HashMap<>();
        params.put("token", apiToken);
        params.put("user", userId);

        ResponseEntity<UserProfileResponse> response = this.restTemplate.getForEntity("https://slack.com/api/users.profile.get?token={token}&user={user}", UserProfileResponse.class, params);

        UserProfile userProfile = response.getBody().getProfile();
        LOGGER.info("User profile successfully loaded: '{}'", userProfile);
        return userProfile;
    }
}
