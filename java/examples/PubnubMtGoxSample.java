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
                    String channel_name = (String)data.get("channel_name");
                    String avg_value = (String)(((JSONObject)((JSONObject)data.get("ticker")).get("avg")).get("value"));
                    System.out.println(channel_name + " : " + avg_value);
                } catch (Exception e) {}

            }});
    }
}

