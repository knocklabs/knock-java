# Knock

Knock API access for applications written in Java.

## Documentation

## Installation

Add the dependency to your `build.grandle` file as follows:

```groovy
dependencies {
    implementation 'app.knock.api:knock-client:0.2.10'
}
```

Or to your `maven.xml` file:

```xml
<dependencies>
    <!-- more dependencies here -->
    <dependency>
        <groupId>app.knock.api</groupId>
        <artifactId>knock-client</artifactId>
        <version>0.2.10</version>
    </dependency>
    <!-- more dependencies here -->
</dependencies>
```

## Configuration

Start by creating an instance of KnockClient.
To use the library you must provide a secret API key, provided in the Knock dashboard.

You can use the KnockClientBuilder to create a KnockClient that will pull from
environment variables.

```java
KnockClient client = KnockClient.builder().build();
```

You can set it as an environment variable:

```bash
KNOCK_API_KEY="sk_12345"
```

You can also set the base API URL and API Key directly.

```java
KnockClient client = KnockClient.builder()
        .baseUrl("https://mock-api.knock.app")
        .apiKey("sk_12345")
        .build();
```

## Usage

### Identifying users

```java
UserIdentity userIdentity = UserIdentity.builder()
        .id("jhammond")
        .name("John Hammond")
        .email("jhammond@ingen.com")
        .property("expenses_spared", "none")
        .build()

client.users().identify(userIdentity);
```

### Retrieving users

```elixir
UserIdentity userIdentity = client.users().get("jhammond")
// OR
Optional<UserIdentity> oUserIdentity = client.users().oGet("jhammond")
```

### Sending notifies

```java
WorkflowTrigger workflowTrigger = WorkflowTrigger.builder()
  .key("dinosaurs-loose")
  // user id of who performed the action
  .actor("dnedry")
  // list of user ids for who should receive the notification
  .recipients(List.of(recipientId1, recipientId2))
  // data that can be used in notification templates
  .data("fences_electrified", false)
  .data("breeds", List.of("velociraptors", "trex"))
  .build();

WorkflowTriggerResult result = client.workflows().trigger(workflowTrigger);
```

### User preferences

```java
# Set preference set for user
PreferenceSetRequest request = PreferenceSetRequest.builder()
    .channelTypes(
        new PreferenceSetBuilder()
            .email(true)
            .buildChannelTypes())
    .build();

client.users().setPreferences("jhammond", request);


# Set granular workflow preferences
PreferenceSetRequest request = PreferenceSetRequest.builder()
    .workflow("dinosaurs-loose",
        new PreferenceSetBuilder()
            .email(false)
            .sms(true)
            .condition("recipient.handles_dino_types", "contains", "data.dino_type")
            .build())
    .build();

client.users().setPreferences("jhammond", request);

// NOTE: "default" preference set will be updated unless PreferenceSetRequest.id is provided.

# Retrieve preferences
PreferenceSet defaultPreferences = client.users().getDefaultPreferences("jhammond");
PreferenceSet defaultPreferences = client.users().getPreferencesById("jhammond", "other-preference-set");
```

### Getting and setting channel data

```java
# Set channel data for an APNS
String channelId = "114a928a-5b35-4e1b-9069-ac873ee972d3";
ChannelData channelData = client.users().setChannelData("jhammond", channelId, Map.of("tokens", List.of("some-token")));

# Get channel data for the APNS channel
ChannelData retrievedChannelData = client.users().getUserChannelData("jhammond", channelId)

# Unset (delete) channel data
client.users().unsetUserChannelData(userId, channelId);
```

### Canceling notifies

```java
String cancellationKey = UUID.randomUUID().toString();

WorkflowTrigger workflowTrigger = WorkflowTrigger.builder()
    .key("delayed-workflow")
    .actor(actorId)
    .cancellation_key(cancellationKey)
    .recipients(List.of(recipientId1, recipientId2))
    .build();

client.workflows().trigger(workflowTrigger);

client.workflows().cancel(workflowTrigger);
```

### Handling Exceptions

Calls to resource methods will either succeed, or throw a KnockResourceException. A KnockResourceException
is returned if a response was received with a payload from Knock that is well defined. This is captured in the
exception, and can be used to determine the cause of the exception.

See the following example code from UsersResourceTestsIT.getUser()

```java
try {
    client.users().get("askfjlsejfes");
    fail("there should be no user found");
} catch (KnockClientResourceException e) {
    assertEquals("resource_missing", e.knockErrorResponse.getCode());
    assertEquals("The resource you requested does not exist", e.knockErrorResponse.getMessage());
    assertEquals(404, e.knockErrorResponse.getStatus());
    assertEquals("api_error", e.knockErrorResponse.getType());
}
```

If the resource returns an Optional, KnockResourceExceptions are caught, and an empty Optional is returned.
