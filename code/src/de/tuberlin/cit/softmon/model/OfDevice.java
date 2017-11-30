package de.tuberlin.cit.softmon.model;

public class OfDevice implements Comparable<OfDevice>{
	
	private String m_ipv4;
	private String m_sdpid;
	private String m_port;
	
	
	public OfDevice(String ipv4, String sdpid, String port) {
		
		setIpv4(ipv4);
		setSdpid(sdpid);
		setPort(port);
	}


	@Override
	public int compareTo(OfDevice o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getIpv4() {
		return m_ipv4;
	}


	public void setIpv4(String ipv4) {
		this.m_ipv4 = ipv4;
	}


	public String getSdpid() {
		return m_sdpid;
	}


	public void setSdpid(String sdpid) {
		this.m_sdpid = sdpid;
	}


	public String getPort() {
		return m_port;
	}


	public void setPort(String m_port) {
		this.m_port = m_port;
	}

}
