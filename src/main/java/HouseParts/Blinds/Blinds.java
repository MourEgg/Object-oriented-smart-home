package HouseParts.Blinds;


import Api.BlindsApi;

public class Blinds implements Context {

    private BlindState state = new UpState(this);

    public void setState(BlindState state) {
        this.state = state;
    }

    public BlindState getState(){
        return state;
    }

    public void nextState(){
        state.changeToNextState();
    }


}
