package com.bardo91.productivitydodecahedron;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.net.IpSecManager;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class ConnectionManager  extends Thread {
    private BluetoothSocket mmSocket = null;
    private BluetoothDevice mmDevice = null;


    private static final UUID PRODUCTIVITY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // Create a UUID variable that will be used afterwards

    private InputStream iStream = null; // Input and Output stream variables of the connection. This variables are the ones that we will use for reading and writing information.
    private OutputStream oStream = null;

    private TextView display = null;
    Activity activity = null;

    public ConnectionManager(BluetoothDevice device, TextView _display, Activity _activity){
        display = _display;
        activity = _activity;
        // Use a temporary object that is later assigned to mmSocket
        // because mmSocket is final.
        BluetoothSocket tmp = null;
        mmDevice = device;

        try {
            // Get a BluetoothSocket to connect with the given BluetoothDevice.
            // MY_UUID is the app's UUID string, also used in the server code.
            tmp = device.createRfcommSocketToServiceRecord(PRODUCTIVITY_UUID);
        } catch (IOException e) {
            Log.e("Productivity", "Socket's create() method failed", e);
        }
        mmSocket = tmp;
    }

    public void run() {
        try {
            // Connect to the remote device through the socket. This call blocks
            // until it succeeds or throws an exception.
            mmSocket.connect();
        } catch (IOException connectException) {
            // Unable to connect; close the socket and return.
            try {
                mmSocket.close();
            } catch (IOException closeException) {
                Log.e("Productivity", "Could not close the client socket", closeException);
            }
            return;
        }

        // The connection attempt succeeded. Perform work associated with
        // the connection in a separate thread.

        try {
            iStream = mmSocket.getInputStream(); // If the connection is made, instanciate input and output streams into declarated variables to read and write
            oStream = mmSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            while(mmSocket.isConnected()){
                oStream.write(1);
                int nBytes = iStream.read(buffer);
                final String command = new String(buffer, 0, nBytes);
                Log.d("Productivity", command);

                activity.runOnUiThread(new Runnable() {
                    private final String cmd = command;
                    @Override
                    public void run() {
                        display.setText(cmd);
                    }
                });

                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Closes the connect socket and causes the thread to finish.
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) {
            Log.e("Productivity", "Could not close the client socket", e);
        }

    }
}

