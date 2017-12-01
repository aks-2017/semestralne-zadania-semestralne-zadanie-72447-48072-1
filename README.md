# A roadmap for traffic engineering in SDN-OpenFlow networks

SOFTmon – Trafc Monitoring for SDN

Autori: Marc Hartung, Marc Körnerb

Abstract:

Softvérovo definované siete (SDN) sú základným nástrojom virtualizácie siete. Poskytujú veľa príležitostí, ale tiež vyžadujú nové riešenia pre známe staršie mechanizmy. Preto zavádzame inovatívny nástroj na monitorovanie siete, ktorý je schopný pracovať s bežne dostupnými regulátormi OpenFlow. Predložený nástroj rozširuje možnosti monitorovania regulátora tým, že poskytuje grafy využitia a štatistiky až po úroveň toku. S cieľom predstaviť súbor funkcií sa zavádza architektúra a implementácia nástrojov. Ďalej je prezentované hodnotenie virtualizovanej siete Mininet pomocou Open vSwitch, ako aj vyhodnotenie nášho výskumného klastra SDN s typickou topológiou dátového centra topografického stromu zloženého z prepínačov NEC IP 8800.

>url: http://ezproxy.cptisr.isk:2057//iscience/artcle/pii/S877/7/050o87/1812163 

Pre nainštalovanie základného setupu spustite súbor floodlight_setup.sh v zložke setup_script a zároveň run.sh, ktoré sa spúštajú prostredníctvom bash 

Tieto súbory je nutné premiestniť do domovkého adresára. Spou s topológiami siete, ktoré sa nachádzajú v zložke topo.

V zložke testovania a merania nájdete obrazovky z vykonaných testov rôznych topológii s jednotlivými nastaveniami.

V zložke code/jar sa nachádza spúštajúci súbor pre SOFTmon s názvom floodlight.jar, tento názov sme zvolili z dovodu, ze v aktualnej verzii podporuje iba Floodlight riadiacu jednotku.

V prípade, že by skripty z neidentifikovaných dôvodov nefungovali, prikladáme návod na konfiguráciu potrebných inštancii ako aj spustenie aplikácie, ktorý sa nachádza v zložke: /docs/prototype.md


