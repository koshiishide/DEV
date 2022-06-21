package Servlet;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

	public class LooseHostnameVerifier implements HostnameVerifier {
	    public boolean verify(String hostname, SSLSession session) {
	        return true;
	    }
	}

