package com.pubnub.mtgox;

import java.util.HashMap;
import com.pubnub.api.*;
import org.json.*;

public class MtGox {

    Pubnub pubnub;
    HashMap<String,MtGoxCallback> map = new HashMap<String,MtGoxCallback>();

    public MtGox() {

    }

    public void subscribe(String tag, MtGoxCallback callback) {
        map.put(tag, callback);

        if (pubnub == null) {
            pubnub = new Pubnub("","sub-c-50d56e1e-2fd9-11e3-a041-02ee2ddab7fe");
            String[] channels = new String[] {
                    "d5f06780-30a8-4a48-a2f8-7ed181b4a13f",
                    "dbf1dee9-4f2e-4a08-8cb7-748919a71b21"
            };
            try {
                pubnub.subscribe(channels, new Callback(){

                    @Override
                    public void successCallback(String channel,
                            Object message) {
                        String channel_name = null;
                        try {
                            channel_name = (String)((JSONObject)message).get("channel_name");
                        } catch (JSONException e) {
                            return;
                        }
                        MtGoxCallback cb = map.get(channel_name);
                        if (cb != null) cb.callback((JSONObject)message);
                    }
                });
            } catch (PubnubException e) {

            }
        }
    }

    public void unsubscribe(String tag) {
        map.remove(tag);
    }
}
