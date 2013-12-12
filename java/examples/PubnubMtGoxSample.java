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

