package de.qaware.qpi.slack.slackjudgearea;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.qaware.qpi.slack.slackjudgearea.model.Payload;
import de.qaware.qpi.slack.slackjudgearea.model.Voting;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SlackJudgeAreaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlackJudgeAreaController.class);

    @Value("${slack.token}")
    private String desiredToken;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FreeMarkerConfigurer freemarker;

    @Autowired
    private JudgeAreaService judgeAreaService;

    @Autowired
    private RestService restService;

    @RequestMapping(value = "/arena", produces = "application/json")
    public String renderJudgeArea(
            Model model,
            @ModelAttribute("token") String token,
            @ModelAttribute("team_id") String teamId,
            @ModelAttribute("team_domain") String teamDomain,
            @ModelAttribute("channel_id") String channelId,
            @ModelAttribute("channel_name") String channelName,
            @ModelAttribute("user_id") String userId,
            @ModelAttribute("user_name") String userName,
            @ModelAttribute("command") String command,
            @ModelAttribute("text") String text,
            @ModelAttribute("response_url") String responseUrl) {

        if(!desiredToken.equals(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
        }

        Voting voting = this.judgeAreaService.createNewVoting(userName, text);

        model.addAttribute("title", voting.getTitle());
        model.addAttribute("context0", voting.getAnswer0());
        model.addAttribute("context1", voting.getAnswer1());
        model.addAttribute("context2", voting.getAnswer2());
        model.addAttribute("context3", voting.getAnswer3());
        model.addAttribute("context4", voting.getAnswer4());
        model.addAttribute("context5", voting.getAnswer5());
        model.addAttribute("context6", voting.getAnswer6());

        return "area";
    }

    @PostMapping("/vote")
    public ResponseEntity vote(@RequestParam Map<String, String> body) throws IOException, TemplateException {

        if (!body.containsKey("payload")) {
            LOGGER.error("'payload' expected");
            throw new IllegalArgumentException("'payload' expected");
        }

        Payload payload = objectMapper.readValue(body.get("payload"), Payload.class);

        Voting voting = this.judgeAreaService.vote(payload);

        Map<String, Object> model = new HashMap<>();

        // put title into template model
        model.put("title", voting.getTitle());
        model.put("context0", voting.getAnswer0());
        model.put("context1", voting.getAnswer1());
        model.put("context2", voting.getAnswer2());
        model.put("context3", voting.getAnswer3());
        model.put("context4", voting.getAnswer4());
        model.put("context5", voting.getAnswer5());
        model.put("context6", voting.getAnswer6());

        // render template an send new voting result to Slack API
        StringWriter writer = new StringWriter();
        freemarker.getConfiguration().getTemplate("area.ftl").process(model, writer);
        restService.sendActionCallback(payload.getResponseUrl(), writer.getBuffer().toString());

        // everything was ok, return 200
        return new ResponseEntity(HttpStatus.OK);
    }
}
