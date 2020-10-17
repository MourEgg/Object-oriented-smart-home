package HouseParts.Blinds;


public abstract class BlindState {

    protected Context context;

    public BlindState(Context context){
        this.context = context;
    }

    abstract protected void changeToNextState();
}
