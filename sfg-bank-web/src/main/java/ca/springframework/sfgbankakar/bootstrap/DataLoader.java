package ca.springframework.sfgbankakar.bootstrap;


import ca.springframework.sfgbankakar.enums.Cinsiyet;
import ca.springframework.sfgbankakar.enums.Role;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.services.AdresService;
import ca.springframework.sfgbankakar.services.IletisimService;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


//@Slf4j -> Desteklemediğinden kullanılmadı
@Component                                 //CommandLineRunner da kullanılabilir
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final KimlikService kimlikService;
    private final IletisimService iletisimService;
    private final AdresService adresService;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(KimlikService kimlikService, IletisimService iletisimService, AdresService adresService, PasswordEncoder passwordEncoder) {
        this.kimlikService = kimlikService;
        this.iletisimService = iletisimService;
        this.adresService = adresService;
        this.passwordEncoder = passwordEncoder;
    }

//    public DataLoader() {
//       this.iletisimService = new IletisimMapService();
//       this.kimlikService = new KimlikMapService();
//       this.adresService = new AdresMapService();  // alt sınıfı manuel injection yaptık
//    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        iletisimService.deleteAll();
        kimlikService.deleteAll();
        adresService.deleteAll();
        getLoaderData();
        System.out.println("Loading Bootstrap Data");
    }

    private void getLoaderData() {
        Kimlik kimlikLoader = new Kimlik();
        Set<Adres> adresLoaders = new HashSet<>();
        Set<Iletisim> iletisimLoaders = new HashSet<>();
        Adres adresLoader = new Adres();
        Adres adresLoaderTwo = new Adres();
        Iletisim iletisimLoader = new Iletisim();
        kimlikLoader.setAdiSoyadi("Cem Akar");
      //  kimlikLoader.setCinsiyet(Cinsiyet.ERKEK);
        kimlikLoader.setKimlikNo("13195012392");
        kimlikLoader.setCinsiyet(Cinsiyet.ERKEK);

        //1- data adres
        adresLoader.setBeyanAdres("Ankara/Yenimahalle Batıkent");
        adresLoader.setEmail("byrankon18@gmail.com");
        //2-data adres
        adresLoaderTwo.setEmail("springtestmailtest@gmail.com");

        //1-data iletisim

        iletisimLoader.setEvTelefonNo("444 00 1412");
        iletisimLoader.setTelefonNo("05380366444");


        iletisimLoader.setKimlik(kimlikLoader);
        adresLoader.setKimlik(kimlikLoader);
        adresLoaderTwo.setKimlik(kimlikLoader);

        KullaniciGiris kullaniciGirisCa = KullaniciGiris.builder()
                .kimlik(kimlikLoader)
                .username("13184028391")
                .password(passwordEncoder.encode("1905"))
                .role(Role.ADMIN)
                .build();

        kimlikLoader.setKullaniciGiris(kullaniciGirisCa);
        kimlikLoader.addAdresSet(adresLoader);
        kimlikLoader.addAdresSet(adresLoaderTwo);
        kimlikLoader.addIletisimSet(iletisimLoader);


        kimlikService.save(kimlikLoader);


        //**

        Kimlik kimlikBo = new Kimlik();
        Set<Adres> adresLoadersTwo = new HashSet<>();
        Set<Iletisim> iletisimLoadersTwo = new HashSet<>();
        Adres adresBo = new Adres();
        Adres adresBoTwo = new Adres();
        Iletisim iletisimBo = new Iletisim();

        kimlikBo.setAdiSoyadi("Berk Öncü");
      //  kimlikBo.setCinsiyet(Cinsiyet.ERKEK);
        kimlikBo.setKimlikNo("13205931832");
        kimlikBo.setCinsiyet(Cinsiyet.ERKEK);

        adresBo.setEmail("berkoncu99@gmail.com");
        adresBo.setBeyanAdres("Ankara/Batıkent Kuzu mahallesi");
        adresBo.setKimlik(kimlikBo);

        // bo -> data adres 2

        adresBoTwo.setBeyanAdres("Yaşamkent/Ankara");
        adresBoTwo.setEmail("reusBerk99@gmail.com");
        adresBoTwo.setKimlik(kimlikBo);

        iletisimBo.setTelefonNo("05342431001");
        iletisimBo.setKimlik(kimlikBo);

        kimlikBo.addAdresSet(adresBo);
        kimlikBo.addAdresSet(adresBoTwo);
        kimlikBo.addIletisimSet(iletisimBo);


        Adres adresBoThree = new Adres();
        adresBoThree.setKimlik(kimlikBo);
        adresBoThree.setEmail("bboncu99@gmail.com");
        adresBoThree.setBeyanAdres("deneme adres test");

        kimlikBo.addAdresSet(adresBoThree);

        KullaniciGiris kullaniciGirisBo = KullaniciGiris.builder()
                .kimlik(kimlikBo)
                .username("148295018281")
                .password(passwordEncoder.encode("1903"))
                .role(Role.USER)
                .build();

        kimlikBo.setKullaniciGiris(kullaniciGirisBo);
        kimlikService.save(kimlikBo);

        //*****

        Kimlik kimlikSt = new Kimlik();
        Adres adresSt = new Adres();
        Adres adresBoSt = new Adres();
        Iletisim iletisimSt = new Iletisim();

        kimlikSt.setAdiSoyadi("St");
        kimlikSt.setKimlikNo("13948528104");
        kimlikSt.setCinsiyet(Cinsiyet.KADIN);

        adresSt.setBeyanAdres("Ankara/Yenimahalle");
        adresSt.setEmail("");
        adresSt.setKimlik(kimlikSt);

        iletisimSt.setKimlik(kimlikSt);
        iletisimSt.setTelefonNo("05812492121");


        KullaniciGiris kullaniciGirisSt = KullaniciGiris.builder()
                .kimlik(kimlikSt)
                .username("14859281058")
                .password(passwordEncoder.encode("1907"))
                .role(Role.USER)
                .build();

        kimlikSt.setKullaniciGiris(kullaniciGirisSt);
        kimlikSt.addAdresSet(adresSt);
        kimlikSt.addIletisimSet(iletisimSt);

        kimlikService.save(kimlikSt);

    }
}
