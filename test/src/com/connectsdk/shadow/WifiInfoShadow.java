package com.connectsdk.shadow;

import android.net.wifi.WifiInfo;

import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowWifiInfo;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Implements(WifiInfo.class)
public class WifiInfoShadow extends ShadowWifiInfo {

    public int getIpAddress() {
        try {
            byte[] addr = InetAddress.getLocalHost().getAddress();
            return addr[0] + (addr[1] << 8) + (addr[2] << 16) + (addr[3] << 24);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
