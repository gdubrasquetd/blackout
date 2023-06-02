package fr.guillaume.BlackOut;

public class Player {

    private CharSequence Name = null;

    private boolean genre = true;

    public Player(CharSequence name) {
        this.Name = name;
    }

    public boolean isGenre() {
        return genre;
    }

    public void setGenre(boolean genre) {
        this.genre = genre;
    }

    public CharSequence getName() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Name == player.Name;
    }

    @Override
    public String toString() {
        return Name.toString();
    }
}
