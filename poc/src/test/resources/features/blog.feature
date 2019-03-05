# language: de
@run
Funktionalität: blog

  Szenario: Ich siehe mir den Blog an
    Gegeben sei ich bin auf dem Blog
    Dann möchte ich die neusten Blogeinträge sehen

  Szenario: Ich kann die Blogeinträge nach Kategorie filtern
    Gegeben sei ich bin auf dem Blog
    Wenn ich den Filter "Politik" anwende
    Dann möchte ich Einräge der Kategorie "Politik" sehen
    Und ich möchte keine Einträge außer "Politik" sehen