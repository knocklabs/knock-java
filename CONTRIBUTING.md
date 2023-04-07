# Contributing

## Getting Started

1. Install [asdf](https://asdf-vm.com)
2. Install the asdf Java plugin

```bash
asdf plugin add java https://github.com/halcyon/asdf-java.git # Visit that repository to see installation prerequisites
```

3. Run `asdf install` to install the version of Java specified in the [.tool-versions](.tool-versions) file

## Running unit tests

`./gradlew test`

## Running integration tests

This requires some initial setup. Go through the project and replace any API keys, channel IDs, etc. with your own. You will need to also create test workflows in your Knock account.

```bash
# The optional `-t` flag will run the tests in watch mode
./gradlew integrationTest -t
```

## Building

`./gradlew build`
