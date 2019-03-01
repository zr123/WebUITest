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

  Szenariogrundriss: Ein Benutzer loggt sich ein
    Gegeben sei ich bin auf der Loginseite
    Wenn ein Benutzer seinen <Name> und sein <Passwort> eingibt
    Dann soll er eingeloggt werden wenn es <Stimmt>
    Und er soll nicht eingeloggt werden wenn es nicht <Stimmt>

    Beispiele:
      | Name        | Passwort        | Stimmt  |
      | John        | 123456          | Ja      |
      | Eve         | password        | Ja      |
      | John        | 12345           | Nein    |
