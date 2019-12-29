{
   "response_type": "in_channel",
   "replace_original": "true",
   "blocks":[
      {
         "type":"section",
         "block_id": "sectionTitle",
         "text":{
            "type":"mrkdwn",
            "text":"${title}"
         }
      },
      {
         "type":"divider"
      },
      <#-- ZERO -->
      {
         "type":"section",
         "block_id": "sectionVote0",
         "text":{
            "type":"mrkdwn",
            "text":":zero: :blue_heart: *step aside*"
         },
         "accessory":{
            "type":"button",
            "text":{
               "type":"plain_text",
               "emoji":true,
               "text":"Vote"
            },
            "value":"0",
            "action_id":"vote"
         }
      },
      <#if context0.elements?has_content>
      {
         "type":"context",
         "block_id": "contextVote0",
         "elements":[
            <#list context0.elements as element>
            {
               "type":"${element.type}",
               "image_url":"${element.imageUrl}",
               "alt_text":"${element.altText}"
            },
            </#list>
            {
               "type":"plain_text",
               "emoji":true,
               "text":"${context0.elements?size} votes"
            }
         ]
      },
      </#if>
      <#-- ONE -->
      {
         "type":"section",
         "block_id": "sectionVote1",
         "text":{
            "type":"mrkdwn",
            "text":":one: :heart: *full support*"
         },
         "accessory":{
            "type":"button",
            "text":{
               "type":"plain_text",
               "emoji":true,
               "text":"Vote"
            },
            "value":"1",
            "action_id":"vote"
         }
      },
      <#if context1.elements?has_content>
      {
         "type":"context",
         "block_id": "contextVote1",
         "elements":[
            <#list context1.elements as element>
               {
               "type":"${element.type}",
               "image_url":"${element.imageUrl}",
               "alt_text":"${element.altText}"
               },
            </#list>
            {
               "type":"plain_text",
               "emoji":true,
               "text":"${context1.elements?size} votes"
            }
         ]
      },
      </#if>
      <#-- TWO -->
      {
         "type":"section",
         "block_id": "sectionVote2",
         "text":{
            "type":"mrkdwn",
            "text":":two: :green_heart: *slight concerns*"
         },
         "accessory":{
            "type":"button",
            "text":{
               "type":"plain_text",
               "emoji":true,
               "text":"Vote"
            },
            "value":"2",
            "action_id":"vote"
         }
      },
      <#if context2.elements?has_content>
      {
         "type":"context",
         "block_id": "contextVote2",
         "elements":[
            <#list context2.elements as element>
               {
               "type":"${element.type}",
               "image_url":"${element.imageUrl}",
               "alt_text":"${element.altText}"
               },
            </#list>
            {
               "type":"plain_text",
               "emoji":true,
               "text":"${context2.elements?size} votes"
            }
         ]
      },
      </#if>
      <#-- THREE -->
      {
         "type":"section",
         "block_id": "sectionVote3",
         "text":{
            "type":"mrkdwn",
            "text":":three: :yellow_heart: *severe concerns*"
         },
         "accessory":{
            "type":"button",
            "text":{
               "type":"plain_text",
               "emoji":true,
               "text":"Vote"
            },
            "value":"3",
            "action_id":"vote"
         }
      },
      <#if context3.elements?has_content>
      {
         "type":"context",
         "block_id": "contextVote3",
         "elements":[
            <#list context3.elements as element>
               {
               "type":"${element.type}",
               "image_url":"${element.imageUrl}",
               "alt_text":"${element.altText}"
               },
            </#list>
            {
               "type":"plain_text",
               "emoji":true,
               "text":"${context3.elements?size} votes"
            }
         ]
      },
      </#if>
      <#-- FOUR -->
      {
         "type":"section",
         "block_id": "sectionVote4",
         "text":{
            "type":"mrkdwn",
            "text":":four: :walking: *step out*"
         },
         "accessory":{
            "type":"button",
            "text":{
               "type":"plain_text",
               "emoji":true,
               "text":"Vote"
            },
            "value":"4",
            "action_id":"vote"
         }
      },
      <#if context4.elements?has_content>
      {
         "type":"context",
         "block_id": "contextVote4",
         "elements":[
            <#list context4.elements as element>
               {
               "type":"${element.type}",
               "image_url":"${element.imageUrl}",
               "alt_text":"${element.altText}"
               },
            </#list>
            {
               "type":"plain_text",
               "emoji":true,
               "text":"${context4.elements?size} votes"
            }
         ]
      },
      </#if>
      <#-- FIVE -->
      {
         "type":"section",
         "block_id": "sectionVote5",
         "text":{
            "type":"mrkdwn",
            "text":":five: :interrobang: *need to talk*"
         },
         "accessory":{
            "type":"button",
            "text":{
               "type":"plain_text",
               "emoji":true,
               "text":"Vote"
            },
            "value":"5",
            "action_id":"vote"
         }
      },
      <#if context5.elements?has_content>
      {
         "type":"context",
         "block_id": "contextVote5",
         "elements":[
            <#list context5.elements as element>
               {
               "type":"${element.type}",
               "image_url":"${element.imageUrl}",
               "alt_text":"${element.altText}"
               },
            </#list>
            {
               "type":"plain_text",
               "emoji":true,
               "text":"${context5.elements?size} votes"
            }
         ]
      },
      </#if>
      <#-- SIX -->
      {
         "type":"section",
         "block_id": "sectionVote6",
         "text":{
            "type":"mrkdwn",
            "text":":six: :octagonal_sign: *veto*"
         },
         "accessory":{
            "type":"button",
            "text":{
               "type":"plain_text",
               "emoji":true,
               "text":"Vote"
            },
            "value":"6",
            "action_id":"vote"
         }
      }
      <#if context6.elements?has_content>
      ,
      {
         "type":"context",
         "block_id": "contextVote6",
         "elements":[
            <#list context6.elements as element>
               {
               "type":"${element.type}",
               "image_url":"${element.imageUrl}",
               "alt_text":"${element.altText}"
               },
            </#list>
            {
               "type":"plain_text",
               "emoji":true,
               "text":"${context6.elements?size} votes"
            }
         ]
      }
      </#if>
   ]
}