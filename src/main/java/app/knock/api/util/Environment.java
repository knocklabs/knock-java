package app.knock.api.util;

public class Environment {

    /***
     * JVM env vars are annoying, writing a wrapper since they can't be easily set at runtime for testing.
     * @param name name of the environment variable to lookup
     * @return environment variable value, or null
     */
    public String getEnvVar(String name) {
        return System.getenv(name);
    }

}
