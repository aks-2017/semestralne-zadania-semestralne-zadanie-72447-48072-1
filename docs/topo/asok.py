from mininet.topo import Topo

class MyTopo( Topo ):
    "Topology used in SOFTmon article"
    def __init__( self ):
        "Create sustom topo"
        
        # Initialize topology
        Topo.__init__( self )
        
        # Add host and switches
        asok04 = self.addHost( 'asok04' )
        asok05 = self.addHost( 'asok05' )
        asok06 = self.addHost( 'asok06' )
        asok07 = self.addHost( 'asok07' )
        asok08 = self.addHost( 'asok08' )
        asok13 = self.addHost( 'asok13' )
        asok14 = self.addHost( 'asok14' )
        asok15 = self.addHost( 'asok15' )
        asok16 = self.addHost( 'asok16' )
        nec101 = self.addSwitch( 'nec101' )
        nec301 = self.addSwitch( 'nec301' )
        nec102 = self.addSwitch( 'nec102' )
        nec201 = self.addSwitch( 'nec201' )
        nec302 = self.addSwitch( 'nec302' )
        nec202 = self.addSwitch( 'nec202' )


        # Add links
        self.addLink( nec101, nec301 )
        self.addLink( nec101, nec302 )

        self.addLink( nec102, nec301 )
        self.addLink( nec102, nec302 )

        self.addLink( nec201, nec301 )
        self.addLink( nec201, nec302 )

        self.addLink( nec202, nec301 )
        self.addLink( nec202, nec302 )


        self.addLink( asok04, nec101 )
        self.addLink( asok05, nec101 )
        self.addLink( asok06, nec101 )

        self.addLink( asok07, nec102 )
        self.addLink( asok08, nec102 )

        self.addLink( asok13, nec201 )
        self.addLink( asok14, nec201 )

        self.addLink( asok15, nec202 )
        self.addLink( asok16, nec202 )


topos = { 'mytopo': ( lambda: MyTopo() ) }
