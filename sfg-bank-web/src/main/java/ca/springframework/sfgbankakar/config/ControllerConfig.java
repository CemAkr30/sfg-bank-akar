package ca.springframework.sfgbankakar.config;


import ca.springframework.sfgbankakar.controllers.AdresController;
import ca.springframework.sfgbankakar.controllers.IletisimController;
import ca.springframework.sfgbankakar.controllers.KimlikController;
import ca.springframework.sfgbankakar.model.Iletisim;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
