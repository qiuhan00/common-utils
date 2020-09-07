package com.cfang.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @description 
 * @author cfang 2020年9月1日2
 */
public class HostIpUtil {

	public static String getHostIP() {
		Enumeration<NetworkInterface> allNetInterfaces = null;
		String resultIP = null;
		try {
	      allNetInterfaces = NetworkInterface.getNetworkInterfaces();
	    } catch (SocketException e) {
	      e.printStackTrace();
	    } 
	    InetAddress ip = null;
	    while (allNetInterfaces.hasMoreElements()) {
	      NetworkInterface netInterface = allNetInterfaces.nextElement();
	      if (!"eth0".equals(netInterface.getName())) continue; 
	      Enumeration<InetAddress> inetAddresses = netInterface.getInetAddresses();
	      while (inetAddresses.hasMoreElements()) {
	        ip = inetAddresses.nextElement();
	        if (ip == null || !(ip instanceof java.net.Inet4Address) || resultIP != null)
	          continue; 
	        resultIP = ip.getHostAddress();
	      } 
	    } 
	    return resultIP;
	}
}
