package HouseParts;

import HouseParts.Blinds.Blinds;

public class Window {

    Blinds blind;

    public Window(){
        blind = new Blinds();
    }

    public Blinds getBlind() {
        return blind;
    }
}
