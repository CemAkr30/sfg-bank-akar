package ca.springframework.sfgbankakar.config;


import ca.springframework.sfgbankakar.controllers.AdresController;
import ca.springframework.sfgbankakar.controllers.IletisimController;
import ca.springframework.sfgbankakar.controllers.KimlikController;
import ca.springframework.sfgbankakar.model.Iletisim;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//TODO II.ADIM CONTEXT EKLEME

//@Configuration
public class ControllerConfig {


    //Örnek olarak -> sterotypeler verilmez ise @restController, @Controller context instiance ekleyemez fakat
    //Bütün package içerisinde ki service,repo,controller'ları tek bir config altında toplayarak manuel olarak @Bean anotation sayesinde
    // ekleme yapabiliriz. @Bean anotation da tıp ki diğer @sterotypler gibi context instiance ekler.


//    @Bean
//    AdresController adresController(){
//        return new AdresController();
//    }
//
//    @Bean
//    KimlikController kimlikController(){
//        return new KimlikController();
//    }
//
//
//    @Bean
//    IletisimController iletisimController(){
//        return new IletisimController();
//    }
//
    //TODO örnek olarak profile mantığı -> üst sınıftan türeyen iki alt sınıfı, env.
    // tarafından girilen profile göre injection çalışacaktır. @Primary ile tekilleştiriz -> injection yaparken 3 alt sınıf varsa
    // ve profile,qualifer verilmediyse -> @primary'si varsa default bunu çalıştırır.
//    @Profile({"TR","default"})
//    @Bean("i18nService")
//    I18NTrService i18NTrService(){
//        return I18NTrService();
//    }

    //@Profile({"ES"})
//    @Bean()
//    I18NEsService i18NEsService(){
//        return I18NEsService();
//    }



//
}
