# language: de
@run
Funktionalität: blog

  Der Fachbereich möchte einen einfachen Blog.
  Auf dem Blog sollen Neuigkeiten publiziert werden können.
  Für Interessierte soll es möglich sein die Artikel auf die Kategorie zu filtern.

  Szenario: Ich siehe mir den Blog an
    Gegeben sei ich bin auf dem Blog
    Dann möchte ich die neusten Blogeinträge sehen

  Szenario: Ich kann die Blogeinträge nach Kategorie filtern
    Gegeben sei ich bin auf dem Blog
    Wenn ich den Filter "Politics" anwende
    Dann möchte ich Einräge der Kategorie "Politics" sehen