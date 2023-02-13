package ca.springframework.sfgbankakar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
        /** Entegrasyonlu api görevini görür connection vs ayarlar
         Spring projelerimizde HTTP isteklerini yapıp yönetebileceğimiz
       Spring Boot Web kütüphanesinin içerisinde yer alan bir yapıdır. Bu sayede bir client olarak bir servisten veri çekebiliriz.

         getForObject
        getForEntity
        postForEntity
        postForObject
         **/
    }

    /**
     Rest-template (blocking client), thread-per-request modeline dayanan  J
     ava Servlet API’sini kullanır. Bu,  client yanıtı alana kadar thread’in
     blocklanacağı anlamına gelir. Uygulamada çok sayıda istek atılıyor ise bununla
     orantılı olarak çok sayıda thread kullanılacak ve connection oluşacaktır.
     Sonuç olarak, uygulama, thread havuzunu tüketecek veya tüm kullanılabilir belleği işgal
     edecek birçok thread oluşturacaktır . Sık sık CPU bağlamı (thread) geçişi nedeniyle
     performans düşüşü yaşanacaktır..

     WebClient , Spring WebFlux kütüphanesinin bir parçasıdır.  WebClient,
     spring reactive framework tarafından asynchronous,non-blocking işlemleri
     destekleyen reactive bir HTTP client’dır. Reactive işlemlerin yanısıra
     senkron ve blocking istekleri de destekler.
     **/

}
