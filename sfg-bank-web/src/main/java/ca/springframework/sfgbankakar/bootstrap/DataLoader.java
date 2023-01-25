package ca.springframework.sfgbankakar.bootstrap;


import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.AdresService;
import ca.springframework.sfgbankakar.services.IletisimService;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
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

    public DataLoader(KimlikService kimlikService, IletisimService iletisimService, AdresService adresService) {
        this.kimlikService = kimlikService;
        this.iletisimService = iletisimService;
        this.adresService = adresService;
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

        //1- data adres
        adresLoader.setBeyanAdres("Ankara/Yenimahalle Batıkent");
        adresLoader.setEmail("cakar1905@gmail.com");
        //2-data adres
        adresLoaderTwo.setEmail("cakar18@gmail.com");

        //1-data iletisim

        iletisimLoader.setEvTelefonNo("444 00 1412");
        iletisimLoader.setTelefonNo("05380366444");


        iletisimLoader.setKimlik(kimlikLoader);
        adresLoader.setKimlik(kimlikLoader);
        adresLoaderTwo.setKimlik(kimlikLoader);

        adresLoaders.add(adresLoader);
        adresLoaders.add(adresLoaderTwo);

        iletisimLoaders.add(iletisimLoader);

        kimlikLoader.setAdresSet(adresLoaders);
        kimlikLoader.setIletisimSet(iletisimLoaders);


        kimlikService.save(kimlikLoader);
//        kimlikService.flush();

        //

        Kimlik kimlikBo = new Kimlik();
        Set<Adres> adresLoadersTwo = new HashSet<>();
        Set<Iletisim> iletisimLoadersTwo = new HashSet<>();
        Adres adresBo = new Adres();
        Adres adresBoTwo = new Adres();
        Iletisim iletisimBo = new Iletisim();

        kimlikBo.setAdiSoyadi("Berk Öncü");
      //  kimlikBo.setCinsiyet(Cinsiyet.ERKEK);
        kimlikBo.setKimlikNo("13205931832");

        adresBo.setEmail("berkoncu99@gmail.com");
        adresBo.setBeyanAdres("Ankara/Batıkent Kuzu mahallesi");
        adresBo.setKimlik(kimlikBo);

        // bo -> data adres 2

        adresBoTwo.setBeyanAdres("Yaşamkent/Ankara");
        adresBoTwo.setEmail("reusBerk99@gmail.com");
        adresBoTwo.setKimlik(kimlikBo);

        iletisimBo.setTelefonNo("05342431001");
        iletisimBo.setKimlik(kimlikBo);

        adresLoadersTwo.add(adresBo);
        adresLoadersTwo.add(adresBoTwo);

        iletisimLoadersTwo.add(iletisimBo);


        kimlikBo.setAdresSet(adresLoadersTwo);
        kimlikBo.setIletisimSet(iletisimLoadersTwo);

        kimlikService.save(kimlikBo);
    //    kimlikRepository.flush();

//        kimlikService.print();

    }
}
