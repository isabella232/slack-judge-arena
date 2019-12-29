package de.qaware.qpi.slack.slackjudgearea;

import de.qaware.qpi.slack.slackjudgearea.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JudgeAreaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JudgeAreaService.class);

    @Autowired
    private RestService restService;


    public Voting createNewVoting(String userName, String question) {

        return new Voting("*" + question + "* Poll by @" + userName,
                Context.EMPTY, Context.EMPTY, Context.EMPTY, Context.EMPTY, Context.EMPTY, Context.EMPTY, Context.EMPTY);
    }

    public Voting vote(Payload payload) {
        Action action = payload.getActions()[0];

        LOGGER.info("Action '{}' with value '{}' received", action.getActionId(), action.getValue());

        // load user profile
        UserProfile userProfile = this.restService.getUserProfile(payload.getUser().getId());

        // prepare work objects
        List<Block> blocks = Arrays.asList(payload.getMessage().getBlocks());
        //Map<String, Object> values = new HashMap<>();

        // iterate all possible
        Context[] votings = new Context[7];
        for (int i = 0; i <= 6; i++) {
            Context context = new Context();

            Block ctxBlock = findBlock(blocks, "contextVote" + i);
            if (ctxBlock != null) {
                LOGGER.debug("Context block '{}' found", ctxBlock.getBlockId());
                for (Element element : ctxBlock.getElements()) {
                    // add old voting results (only if type image and not an old vote of current user)
                    if (element.getType().equals("image") && !element.getAltText().equals(userProfile.getDisplayName())) {
                        context.addElement(new Element("image", element.getImageUrl(), element.getAltText()));
                    }
                }
            }

            // add user's current vote to result
            if (Integer.parseInt(action.getValue()) == i) {
                context.addElement(new Element("image", userProfile.getImage(), userProfile.getDisplayName()));
            }
            votings[i] = context;
        }

        return new Voting(getTitle(blocks), votings[0], votings[1], votings[2], votings[3], votings[4],
                votings[5], votings[6]);
    }

    static Block findBlock(List<Block> blocks, String id) {
        LOGGER.debug("Lookup block with id '{}'", id);
        for (Block block : blocks) {
            LOGGER.debug("Check block with id '{}'.", block.getBlockId());
            if (block.getBlockId().equals(id)) {
                return block;
            }
        }
        return null;
    }

    static String getTitle(List<Block> blocks) {
        Block title = findBlock(blocks, "sectionTitle");
        return title != null ? title.getText().getText() : null;
    }
}
