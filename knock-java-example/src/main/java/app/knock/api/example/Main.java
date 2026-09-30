package app.knock.api.example;

import app.knock.api.client.KnockClient;
import app.knock.api.client.okhttp.KnockOkHttpClient;
import app.knock.api.core.JsonValue;
import app.knock.api.lib.Grant;
import app.knock.api.lib.SignUserTokenOptions;
import app.knock.api.lib.TokenEntity;
import app.knock.api.lib.UserTokens;
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListParams;
import app.knock.api.models.workflows.WorkflowTriggerParams;
import app.knock.api.models.workflows.WorkflowTriggerResponse;
import java.util.List;

/**
 * Triggers a workflow in sandbox mode, lists its recent runs, and signs a user token.
 *
 * <p>Requires `KNOCK_API_KEY`, plus `KNOCK_SIGNING_KEY` for the token. Pass the workflow key and
 * the recipient's user ID as arguments.
 */
public final class Main {

    public static void main(String[] args) {
        String workflowKey = args.length > 0 ? args[0] : "new-comment";
        String userId = args.length > 1 ? args[1] : "dnedry";

        KnockClient client = KnockOkHttpClient.fromEnv();

        WorkflowTriggerResponse response = client.workflows()
                .trigger(WorkflowTriggerParams.builder()
                        .key(workflowKey)
                        .addRecipient(userId)
                        .data(WorkflowTriggerParams.Data.builder()
                                .putAdditionalProperty("dinosaur", JsonValue.from("triceratops"))
                                .build())
                        .settings(WorkflowTriggerParams.Settings.builder()
                                .sandboxMode(true)
                                .build())
                        .build());
        System.out.println("Triggered workflow run " + response.workflowRunId());

        client
                .workflowRecipientRuns()
                .list(WorkflowRecipientRunListParams.builder()
                        .workflow(workflowKey)
                        .pageSize(10L)
                        .build())
                .autoPager()
                .stream()
                .limit(10)
                .forEach(run -> System.out.println(run.id() + " " + run.status()));

        if (System.getenv("KNOCK_SIGNING_KEY") != null) {
            String token = UserTokens.signUserToken(
                    userId,
                    SignUserTokenOptions.builder()
                            .addGrant(UserTokens.buildUserTokenGrant(
                                    TokenEntity.ofUser(userId), List.of(Grant.USER_FEED_READ)))
                            .build());
            System.out.println("Signed user token for " + userId + " (" + token.length() + " chars)");
        }
    }
}
