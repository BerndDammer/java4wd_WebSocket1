package test;

import java.net.URI;
import java.net.URISyntaxException;

public class TestApp {

    public static void main(String[] args) {
    	try {
            final URI uri = new URI("ws://192.168.178.61:8765");
            // open websocket
            //final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("wss://real.okcoin.cn:10440/websocket/okcoinapi"));
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(uri );

            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println(message);
                }
            });

            // send message to websocket
            clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");

            // wait 5 seconds for messages from websocket
            Thread.sleep(500000);

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }
}
