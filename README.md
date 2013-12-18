# PubNub Mt.Gox JSON Streaming API

Wrapper libs for mtgox stream source https://en.bitcoin.it/wiki/MtGox/API/Pubnub

### PubNub Java Class for MtGox JSON API

It's easy to create a ready made Java Class for ingesting the live feed provided by Mt.Gox This is a work-in-progress post to show you how to access the PubNub Data Feed from Mt.Gox as shown in the Dev Console live feed!

### Official Bitcoin Wiki JSON Streaming API
We will be working from the Bitcoin wiki feed instructions provided by Bitcoin official Wiki: https://en.bitcoin.it/wiki/MtGox/API/Pubnub - continue reading below the screenshot to continue.

![PubNub Developer Console][1]

To see the live real-time data feed we will be using, please checkout the following two links:

 1. Live Feed Trade Events (Buy/Sell Feed): https://www.pubnub.com/console?sub=sub-c-50d56e1e-2fd9-11e3-a041-02ee2ddab7fe&pub=demo&channel=dbf1dee9-4f2e-4a08-8cb7-748919a71b21&origin=pubsub.pubnub.com&ssl=true
 2. Live Feed Ticker Updates (Price Changes): https://www.pubnub.com/console?sub=sub-c-50d56e1e-2fd9-11e3-a041-02ee2ddab7fe&pub=demo&channel=d5f06780-30a8-4a48-a2f8-7ed181b4a13f&origin=pubsub.pubnub.com&ssl=true
 3. Trade Lag Example: https://www.mtgox.com/lag.html

## PubNub Java SDK Docs
We will be using the PubNub Java SDK Docs
http://www.pubnub.com/docs/java/javase/overview/data-push.html

Specifically we'll be using the `mtgox.subcribe(...)` instance method to focus our efforts which looks like the following:

> Download JAR or Source: https://github.com/pubnub/mtgox

```java
import org.json.JSONObject;
import com.pubnub.mtgox.MtGox;
import com.pubnub.mtgox.MtGoxCallback;

public class PubnubMtGoxSample {

    public static void main(String[] args) {
        MtGox mtgx = new MtGox();

        mtgx.subscribe("ticker.BTCUSD", new MtGoxCallback(){

            @Override
            public void callback(JSONObject data) {
                try {
                    String channel_name = data.getString("channel_name");
                    String avg_value = data.getJSONObject("ticker").getJSONObject("avg").getString("value");
                    System.out.println(channel_name + " : " + avg_value);
                } catch (Exception e) {}

            }});
    }
}
```
> See Full MtGox Example with Java Source Code - https://github.com/pubnub/mtgox/blob/master/java/examples/PubnubMtGoxSample.java

To compile the example got to https://github.com/pubnub/mtgox/tree/master/java and run

    javac -cp Pubnub-MtGox.jar:libs/json-20090211.jar   examples/PubnubMtGoxSample.java

And then to RUN:

    java -cp .:examples/:Pubnub-MtGox.jar:Pubnub-StandardEdition-3.5.6.jar:libs/json-20090211.jar:libs/bcprov-jdk15on-1.47.jar:libs/slf4j-api-1.7.5.jar:libs/slf4j-nop-1.7.5.jar PubnubMtGoxSample

  [1]: http://i.stack.imgur.com/ZZWZw.png
