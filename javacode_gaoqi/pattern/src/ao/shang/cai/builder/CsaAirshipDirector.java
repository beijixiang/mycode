package ao.shang.cai.builder;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class CsaAirshipDirector implements AirshipDirector{

    private AirshipBuilder builder;

    public CsaAirshipDirector(AirshipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Airship directAirship() {
        Engine engine = builder.builderEngine();
        OrbitalModule orbitalModule = builder.builderOrbitalModule();
        EscapeTower escapeTower = builder.builderEscapeTower();

        Airship airship = new Airship();
        airship.setEngine(engine);
        airship.setEscapeTower(escapeTower);
        airship.setOrbitalModule(orbitalModule);

        return airship;
    }
}
