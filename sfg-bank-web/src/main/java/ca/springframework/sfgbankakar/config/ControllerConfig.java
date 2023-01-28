package ca.springframework.sfgbankakar.config;


import ca.springframework.sfgbankakar.dataSource.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

//TODO II.ADIM CONTEXT EKLEME


//@PropertySource("classpath:datasource.properties") // -> proje derlenirken bu classpath git env. verdiğim verileri tut @Value ile çek
//@PropertySource("classpath:datasource.properties")  belirtmez isek default appliaction göre env. çeker veya -dev -qa olarak oluşturulan yml veya propertiesleri
// ana applaction.properties file tarafında profile.active olarak = qa dersek bu file ile beraber qa da çalışır.
@Configuration
public class ControllerConfig {

    //Örnek olarak -> sterotypeler verilmez ise @restController, @Controller context instiance ekleyemez fakat
    //Bütün package içerisinde ki service,repo,controller'ları tek bir config altında toplayarak manuel olarak @Bean anotation sayesinde
    // ekleme yapabiliriz. @Bean anotation da tıp ki diğer @sterotypler gibi context instiance ekler.

    //-> proje derlenirken bu classpath git env. verdiğim verileri tut @Value ile çek
    @Bean
    FakeDataSource fakeDataSource(@Value("${ca.dbUserName}") String dbUserName,
                                  @Value("${ca.dbPassword}") String dbPassword,
                                  @Value("${ca.dbUrl}") String dbUrl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setDbUserName(dbUserName);
        fakeDataSource.setDbPassword(dbPassword);
        fakeDataSource.setDbUrl(dbUrl);

        System.out.println("Db Username = " + fakeDataSource.getDbUserName());
        System.out.println("Db Password = " + fakeDataSource.getDbPassword());
        System.out.println("Db Url = " + fakeDataSource.getDbUrl());

        return fakeDataSource;
    }


//    @Bean
//    KimlikService kimlikService(KimlikRepository kimlikRepository){
//        return new KimlikSDService(kimlikRepository);
//    }


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
