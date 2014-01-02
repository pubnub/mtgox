# PubNub Mt.Gox JavaScript SDK

Use this simple interface to load data from Mt.Gox Live Feed.

```html
<script src="https://pubnub.a.ssl.fastly.net/pubnub.min.js"></script>
<script src="mtgox.js"></script>
<script>(function(){

    // -- MTGOX TICKER DISPLAY ------ //
    PUBNUB.events.bind( 'trade.BTC', function(data) {
        console.log(data);
    } );

    // -- MTGOX TRADES (BUY/SELL) --- //
    PUBNUB.events.bind( 'ticker.BTCUSD', function(data) {
        console.log(data);
    } );

    // -- 24H OF HISTORICAL TRADES -- //
    PUBNUB.events.bind( 'ticker.HISTORY', function(data) {
        console.log(data);
    } );

})();</script>
```


