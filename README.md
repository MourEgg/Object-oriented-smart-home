# Object oriented smart home - školní projekt

## Zadání
Vytvořit aplikaci pro virtuální simulaci inteligentního domu, kde simulujeme chod domácnosti,
používáme jednotlivá zařízení domu a vyhodnocujeme využití, spotřebu, volný a pracovní
čas jednotlivých osob.
### Funkční požadavky

F1. Entity se kterými pracujeme je dům, okno (+ venkovní žaluzie), patro v domu, senzor,
zařízení (=spotřebič), osoba, auto, kolo, domácí zvíře jiného než hospodářského
typu, plus libovolné další entity

F2. Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit
pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení.
Vybraná zařízení mohou mít i obsah - lednice má jídlo, CD přehrávač má CD.

F3. Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu

F4. Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data
jako spotřeba elektřiny, plynu, vody a funkčnost (klesá lineárně s časem)

F5. Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na
zařízení nebo jinou osobu. Např. Plynovy_kotel_1[oteverny_plyn] +
Otec.zavritPlyn(plynovy_kotel_1) -> Plynovy_kotel_1[zavreny_plyn].

F6. Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti (pokud
nesportují) a náhodně generují eventy (eventem může být důležitá informace a nebo
alert)

F7. Eventy jsou přebírány a odbavovány vhodnou osobou (osobami) nebo zařízením
(zařízeními).

F8. Vygenerování reportů:
- HouseConfigurationReport: veškerá konfigurační data domu zachovávající
hieararchii - dům -> patro -> místnost -> okno -> žaluzie atd. Plus jací jsou
obyvatelé domu.
- EventReport: report eventů, kde grupujeme eventy podle typu, zdroje eventů
a jejich cíle (jaká entita event odbavila)
- ActivityAndUsageReport: Report akcí (aktivit) jednotlivých osob a zvířat,
kolikrát které osoby použily které zařízení.
- ConsumptionReport: Kolik jednotlivé spotřebiče spotřebovaly elektřiny, plynu,
vody. Včetně finančního vyčíslení.

F9. Při rozbití zařízení musí obyvatel domu prozkoumat dokumentaci k zařízení - najít
záruční list, projít manuál na opravu a provést nápravnou akcí (např. Oprava
svépomocí, koupě nového atd.). Manuály zabírají mnoho místa a trvá dlouho než je
najdete. Hint: Modelujte jako jednoduché akce ...dokumentace je přístupná jako
proměnná přímo v zařízení, nicméně se dotahuje až, když je potřeba.
F10. Rodina je aktivní a volný čas tráví zhruba v poměru (50% používání spotřebičů v
domě a 50% sport kdy používá sportovní náčiní kolo nebo lyže). Když není volné
zařízení nebo sportovní náčiní, tak osoba čeká.

### Vhodné design patterny
- State machine
- Iterator
- Factory/Factory method
- Decorator/Composite
- Singleton
- Visitor/Observer/Listener
- Chain of responsibility
- Partially persistent data structure
- Object Pool
- Lazy Initialization
