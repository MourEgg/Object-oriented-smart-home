package Devices;

public class DeviceFactory {
    public Device createComputer(){
        return new Computer();
    }
    public Device createMicrowave(){
        return new Microwave();
    }
    public Device createNotebook(){
        return new Notebook();
    }
    public Device createRadio(){
        return new Radio();
    }
    public Device createTablet(){
        return new Tablet();
    }
    public Device createTV(){
        return new TV();
    }
    public Device createVacuumCleaner(){
        return new VacuumCleaner();
    }
    public Device createLamp(){
        return new Lamp();
    }
}
