package Services;

public class TavernFactory {
    private TavernFactory() {}

    public static Tavern createTavernService(TavernConfig...cfgs) {
        Tavern tavern = new Tavern();
        for(TavernConfig cfg: cfgs) {
            cfg.setTarvernService(tavern);
        }
        return tavern;
    }
}
