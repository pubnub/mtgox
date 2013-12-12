package com.pubnub.mtgox;

import org.json.JSONObject;

public abstract class MtGoxCallback {
	public abstract void callback(JSONObject data);
}
