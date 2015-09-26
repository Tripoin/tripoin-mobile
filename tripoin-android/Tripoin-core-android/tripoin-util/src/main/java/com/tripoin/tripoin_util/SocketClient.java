package com.tripoin.tripoin_util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created by Achmad Fauzi on 6/11/2015 : 11:34 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SocketClient implements Runnable{

    private String host = "180.250.80.72";
    private int port = 2222;
    private Socket socket;
    private SocketClientResult socketClientResult = null;

    private Handler handler;
    private IPostSocketClient iPostSocketClient;

    public SocketClient(Handler handler, IPostSocketClient iPostSocketClient) {
        this.handler = handler;
        this.iPostSocketClient = iPostSocketClient;
    }

    @Override
    public void run() {
        socketClientResult = new SocketClientResult();
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            try {
                Date startDate = new Date();
                socket = new Socket(inetAddress,port);
                Date endDate = new Date();
                socket.close();
                socketClientResult.setStartDate(startDate.toString());
                socketClientResult.setEndDate(endDate.toString());
                socketClientResult.setResult(
                        endDate.getTime() -
                        startDate.getTime()
                );

                //iPostSocketClient.onPostSocketClient(socketClientResult);
                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putParcelable("message", socketClientResult);
                msg.setData(bundle);
                handler.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
