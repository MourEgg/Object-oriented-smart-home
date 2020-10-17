package HouseParts.Blinds;

public class DownState extends BlindState {

    public DownState(Context context){
        super(context);
    }

    @Override
    protected void changeToNextState() {
        context.setState(new UpState(context));
    }
}
