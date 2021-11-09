# TOSP_03_Arena


Das TOSP_03_Arena Repository ist ein Übungsprojekt das im Rahmen eines Umschulungskurses für Fachinformatiker im November 2021 erstellt wurde.

Grundsätzlich steht die Mitarbeit allen Interessierten offen, bitte beachtet die Hinweise zum [Workflow im Wiki](https://github.com/ComcaveTeamwork/CTP_01_TableReader/wiki/Workflow) (aktuell verlinkt auf das Wiki des Tablereader Projekts).

Wenn Ihr Euch am Projekt beteiligen wollt oder Fragen habt, könnt Ihr Euch Euch im [Diskussions Modul](https://github.com/TeamOfStudents/TOSP_03_Arena/discussions/1) melden.

## Motivation

Die Grundidee für dieses Projekt entsprang der Suche nach einer Möglichkeit, an einem Übungsprojekt mit mehreren Personen gleichzeitig zu arbeiten, wobei einerseits die Arbeiten der einzelnen Projektteilnehmer Teil eines größeren Projektes sein sollen, andererseits aber die Projektteilnehmer in ihrem jeweiligen Bereich relativ unabhängig arbeiten können.

## Inhalt

In einer mit Java programmierten Umgebung (Arena) fliegen Drohnen umher, müssen in der Arena navigieren und Aufgaben erfüllen. 
In der aktuellen Version (Nov. 2021) müssen die Drohnen nur eine Reihe von Wegpunkten abfliegen, die Visualisierung ist nur rudimentär vorhanden (Punkte bewegen sich auf einer Zeichenfläche).
Enticklungsziele:
- Entwicklung einer GUI, Verbesserung der aktuellen Visualisierung
- Verbesserung der Drohnen KI. Insbesondere diese Aufgabe ist leicht skalierbar, da mehrere Entwickler parallel unterschiedliche Drohnenlogiken entwickeln können. Diese Drohnenlogiken können dann in der Arena gegeneinander getestet werden.
- Weiterentwicklung der zugrunde liegenden Arena Logik, der verfügbaren Aufgaben etc.

## Anleitung

Die ausführbare main Methode befindet sich in der Datei App.java.
Alle Drohnen werden Anfangs automatisch gesteuert.
Es gibt 2 Drohnen die über die Tastatur gesteuert werden können:
- Drohne 1: Taske Q umschalten der automatische Steuerung, Steuerung über WASD
- Drohne 2: "rechts STRG" umschalten der automatische Steuerung, Steuerung über Cursertasten
