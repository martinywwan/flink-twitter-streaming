## flink-twitter-streaming
Near real-time Twitter data streaming using Apache Flink.<br/>
<br/>
# Synopsis
<br/>
SpringBoot application that runs in your local environment.<br/>
Flink is used to stream data from Twitter. The Twitter data received by Flink is in JSON format which is parsed and persisted to a H2 database.<br/>
<br/>
# Prerequisite
<br/>
Lombok: In your IDEA (e.g. Intellij), open the Settings panel and search for "Plugins", then search for "Lombok" in the plugins. Find the plugin and install it<br/>
# Executing locally<br/>
In the application.yml, set your consumerKey, consumerSecret, token and tokenSecret value.<br/>
Change the datasource properties in the application.yml (default is to H2 database).<br/>
Good to go, you can now just run Application.class<br/>
<br/>
