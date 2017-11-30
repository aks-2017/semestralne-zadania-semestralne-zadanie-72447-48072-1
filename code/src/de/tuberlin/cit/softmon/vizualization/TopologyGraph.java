package de.tuberlin.cit.softmon.vizualization;

import java.util.Map;

import de.tuberlin.cit.softmon.model.OfDevice;
import de.tuberlin.cit.softmon.model.OfLink;
import de.tuberlin.cit.softmon.model.OfSwitch;
import de.tuberlin.cit.softmon.model.OfTopology;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class TopologyGraph {

	private final Graph<String, String> graph;
	
	public TopologyGraph(){
		
        graph = new SparseMultigraph<String, String>();
	}

	public void setGraph(OfTopology topology) {
		
		
		for (Map.Entry<String, OfSwitch> switchEntry : topology.getSwitchMap().entrySet()) {
			String dpid = switchEntry.getKey();

//			System.out.println("device: " + ipv4 + " => " + device.getSdpid());
			graph.addVertex(dpid);
			
		}
		
		for (Map.Entry<String, OfLink> linkEntry : topology.getLinkMap().entrySet()) {
			OfLink link = linkEntry.getValue();
				
//			System.out.println("device: " + ipv4 + " => " + device.getSdpid());
			//graph.containsVertex(arg0)
			
			
			if(!graph.containsEdge("s"+link.getSrcDpid().substring(21) + "-d" + link.getDstPort() + "-s" + link.getSrcPort()) || !graph.containsEdge("s"+link.getSrcDpid().substring(21) + "-d" + link.getSrcPort() + "-s" + link.getDstPort()))
				// example:  [00:00:...:01] -- s01-d1-s2 -- [00:00:...:02] 
				graph.addEdge("s"+link.getSrcDpid().substring(21) + "-d" + link.getDstPort() + "-s" + link.getSrcPort(), link.getSrcDpid(), link.getDstDpid());
			
		}
		
		for (Map.Entry<String, OfDevice> deviceEntry : topology.getDeviceMap().entrySet()) {
			String ipv4 = deviceEntry.getKey();
			OfDevice device = deviceEntry.getValue();
//			System.out.println("device: " + ipv4 + " => " + device.getSdpid());
			graph.addVertex(ipv4);
			
			
			graph.addEdge("s"+device.getSdpid().substring(21)+"-eth"+device.getPort(), device.getSdpid(), device.getIpv4(), EdgeType.UNDIRECTED);
			System.out.println();
			
		}
		
		
		
	}
	
	public Graph<String, String> getGraph() {
		return graph;
	}
	
	public void updateGraph() {
		
	}
	
	
	
}
