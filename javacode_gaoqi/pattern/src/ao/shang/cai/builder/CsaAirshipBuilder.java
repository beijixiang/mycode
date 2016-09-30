package ao.shang.cai.builder;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class CsaAirshipBuilder implements AirshipBuilder {
    @Override
    public Engine builderEngine() {
        System.out.println("构建发动机");
        return new Engine("尚澳牌发动机");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建逃逸塔");
        return new EscapeTower("尚澳牌逃逸塔");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建轨道舱");
        return new OrbitalModule("尚澳牌轨道舱");
    }
}
