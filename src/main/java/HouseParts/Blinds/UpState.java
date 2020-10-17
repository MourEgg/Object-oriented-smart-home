package HouseParts.Blinds;

public class UpState extends BlindState {

    public UpState(Context context) {
        super(context);
    }

    @Override
    protected void changeToNextState() {
        context.setState(new DownState(context));
    }

}
