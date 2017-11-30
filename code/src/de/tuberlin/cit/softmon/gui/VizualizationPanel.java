package de.tuberlin.cit.softmon.gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JButton;

import de.tuberlin.cit.softmon.model.OfDevice;
import de.tuberlin.cit.softmon.model.OfTopology;
import de.tuberlin.cit.softmon.vizualization.TopologyGraph;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.GraphMouseListener;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;


@SuppressWarnings("serial")
public class VizualizationPanel extends JPanel {

	// private static final int DEFAULT_WIDTH = 350;
	// private static final int DEFAULT_HEIGHT = 350;
	public static final String SHOW_BUTTON_TITLE = "Show";
	public static final String RESET_BUTTON_TITLE = "Clear";
	
	private JPanel m_panel;
	private JButton btnShowButton;
	private JButton btnClearButton;
	
	boolean pick;
	
	// jung stuff
	private TopologyGraph m_topoGraph;
	private DefaultModalGraphMouse gm;
	private Layout<Integer, String> layout;
	private VisualizationViewer<Integer, String> vv;
	int i;
	
	/**
	 * Create the panel.
	 */
	public VizualizationPanel() {
		
		btnShowButton = new JButton(SHOW_BUTTON_TITLE);
		add(btnShowButton);
		
		btnClearButton = new JButton(RESET_BUTTON_TITLE);
		add(btnClearButton);
		
		m_panel = new JPanel();
		i = 0;
		add(m_panel);
	}

	public void refreshTopology(OfTopology topology) {

		
	
		m_topoGraph = new TopologyGraph();
		m_topoGraph.setGraph(topology);
		
		setGraph();
	}
	
	 

	@SuppressWarnings("unchecked")
	public void setGraph() {

		
		gm = new DefaultModalGraphMouse();
		gm.setMode(ModalGraphMouse.Mode.PICKING);
		pick = true;
		
		layout = new CircleLayout(m_topoGraph.getGraph());
		layout.setSize(new Dimension(350, 400));
		
		vv = new VisualizationViewer<Integer, String>(layout);
		vv.setPreferredSize(new Dimension(350, 400));
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.setGraphMouse(gm);
		vv.addMouseListener(new MouseListener (){

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3  && e.getClickCount() == 2 ) {
            		if(pick)
            		{	pick = false;
            			gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
            		}
            		else
            		{	pick = true;
            			gm.setMode(ModalGraphMouse.Mode.PICKING);
            		}
            		
                }	
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		if(i == 0)
		{
			m_panel.add(vv);
			i++;
		}
		else{
			m_panel.removeAll();
			m_panel.add(vv);
			System.out.println("soidisfds");
			m_panel.revalidate();
			m_panel.repaint();
		}
		
	}
	
	public void resetWindow(){
		//if(i == 0)
			//m_panel.add(vv);
		//else{
			m_panel.removeAll();
			m_panel.add(vv);
			System.out.println("soidisfds");
			m_panel.revalidate();
			m_panel.repaint();
		//}
	}
	
	public void addGraphMouseListener(GraphMouseListener<Integer> listener) {
		vv.addGraphMouseListener(listener);
	}
	
	public void addVertexListener(ItemListener listener) {
		vv.getPickedVertexState().addItemListener(listener);
	}
	
	public void addEdgeListener(ItemListener listener) {
		vv.getPickedEdgeState().addItemListener(listener);
	}

	public void addButtonListener(ActionListener listener) {
		btnShowButton.addActionListener(listener);
		btnClearButton.addActionListener(listener);
	}
}
