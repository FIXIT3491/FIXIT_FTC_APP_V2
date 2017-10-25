package org.firstinspires.ftc.robotcontroller.internal;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qualcomm.ftccommon.FtcRobotControllerService;
import com.qualcomm.robotcore.util.ThreadPool;
import com.qualcomm.robotcore.wifi.NetworkConnectionFactory;
import com.qualcomm.robotcore.wifi.NetworkType;

import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;

/**
 * Created by FIXIT on 16-10-25.
 */
public class FtcControllerUtils {

    private final static int STOPPED = 0;
    private final static int INIT = 1;
    private final static int RUN = 2;
    private final static String AUDIBLE_TAG = "AudibleTelemetry";

    private static int opModeStatus = STOPPED;
    private static Queue<String> commands = new ArrayBlockingQueue<>(100);
    private static ExecutorService speakExec;
    private static DatagramSocket speakSocket;
    private static String peerAddr = "";

    public static FtcRobotControllerActivity activity() {
        return (FtcRobotControllerActivity) AppUtil.getInstance().getActivity();
    }

    public static Context context() {
        return AppUtil.getInstance().getActivity();
    }

    public static void addView(final View v, int containerId) {

        final ViewGroup group = (ViewGroup) activity().findViewById(containerId);

        activity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                group.addView(v);
            }
        });

    }//addView

    public static void emptyView(int containerId) {

        final ViewGroup group = (ViewGroup) activity().findViewById(containerId);

        activity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                group.removeAllViews();
            }
        });

    }//emptyView

    public static void speak(String msg) {
        commands.add(msg);
    }//speak

    public static void clearAllSpeakCommands() {
        commands.clear();
    }//clearAllSpeakCommands

    public static boolean isSpeakQueueEmpty() {
        return commands.isEmpty();
    }//isSpeakQueueEmpty

    public static void stopSpeaking() {
        commands.add("stop__speaking__opmode__stopped");
    }//stopSpeaking

    public static boolean isSocketClosed() {

        return speakSocket == null || speakSocket.isClosed();

    }//isSocketClosed

    public static boolean startDriverServiceInteraction() {

        speakExec = ThreadPool.newSingleThreadExecutor("AudibleTelemetry");

        speakExec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.i(AUDIBLE_TAG, "Beginning connection process...");
                    speakSocket = new DatagramSocket(null);
                    speakSocket.setReuseAddress(true);

                    speakSocket.bind(new InetSocketAddress(InetAddress.getByName("192.168.49.1"), 20885));
                    speakSocket.setSendBufferSize(255);

                    final String data = new String(receiveSocketData(speakSocket, 255));

                    Log.i(AUDIBLE_TAG, "Driver Station Address: " + data);

                    speakSocket.connect(InetAddress.getByName(data), 20885);

                    activity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity(), "Driver Station Address: " + data, Toast.LENGTH_LONG).show();
                        }//run
                    });

                    sendSocketData(speakSocket, "beep(700, 2000)");

                    while (true) {
                        String msgStr = commands.poll();
                        if (msgStr != null) {
                            Log.i(AUDIBLE_TAG, msgStr);

                            sendSocketData(speakSocket, msgStr);
                        }//if

                        Thread.sleep(100);
                    }//while

                } catch (IOException e) {
                    endDriverServiceInteraction();
                } catch (InterruptedException e) {
                    Log.e(AUDIBLE_TAG, "Socket thread was interrupted! Continuing...");
                }//catch
            }//run
        });//ExecutorService

        return true;
    }//startDriverServiceInteraction

    public static void endDriverServiceInteraction() {

        if (speakExec != null) {
            speakExec.shutdown();
            speakExec = null;
        }//if

        if (speakSocket != null) {
            speakSocket.close();
            speakSocket = null;
        }//if

    }//endDriverServiceInteraction

    public static byte[] receiveSocketData(DatagramSocket socket, int maxArrayLength) throws IOException {
        byte[] buffer = new byte[maxArrayLength];
        final DatagramPacket pckt = new DatagramPacket(buffer, buffer.length);

        socket.receive(pckt);

        int i;
        for (i = 0; i < buffer.length; i++) {

            if (buffer[i] == 0) {
                break;
            }//if
        }//for

        return Arrays.copyOf(buffer, i);
    }//receiveSocketData

    public static void sendSocketData(DatagramSocket socket, String data) throws IOException {
        byte[] buffer = data.getBytes();
        final DatagramPacket pckt = new DatagramPacket(buffer, buffer.length);

        socket.send(pckt);

    }//receiveSocketData

    public static void reinitializeControllerService(boolean useNetwork) {

        if (!useNetwork) {
            ((FtcRobotControllerActivity) activity()).unbindFromService();

            Intent intent = new Intent(activity(), FtcRobotControllerService.class);
            intent.putExtra(NetworkConnectionFactory.NETWORK_CONNECTION_TYPE, NetworkType.SOFTAP);
            ((FtcRobotControllerActivity) activity()).bindService(intent, ((FtcRobotControllerActivity) activity()).connection, Context.BIND_AUTO_CREATE);
        } else {
            ((FtcRobotControllerActivity) activity()).unbindFromService();
            ((FtcRobotControllerActivity) activity()).bindToService();
        }//else
    }//reinitializeControllerService




}//FtcRobotControllerWrapper
