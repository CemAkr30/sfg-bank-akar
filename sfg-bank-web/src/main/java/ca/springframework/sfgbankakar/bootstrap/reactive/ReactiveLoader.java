//package ca.springframework.sfgbankakar.bootstrap.reactive;
//
//import ca.springframework.sfgbankakar.model.reactive.Book;
//import ca.springframework.sfgbankakar.repositories.reactive.BookRepository;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
///*
//* Publisher — Subscriberlar’dan gelen taleplere göre publish gerçekleştirir. Bir producer
// birden fazla subscriber’a (aboneye) hizmet verebilir.
//*
//Subscriber — Producer tarafından yayınlanan eventları(olay/mesaj) yakalar. Subscriber’ın
// alınan eventlarla başa çıkmak için dört metodu vardır: onSubscribe, onNext, onError ve onComplete
//*
//Subscription — Subscriber ve publisher arasındaki ilişkiyi temsil eder. veri için talepte
// bulunmak adına request(long n) metoduna ve eventleri iptal etmek için cancel metoduna sahiptir.
//*
//Processor — Nadir kullanılan, hem subscriber hem de publisher olabilen yapıdır.
//*/
//
//
////Reactive progaming de ana amaç asenkron bir şekilde çalışmaktır. Bu ne demek;
////Bir istek geldiği zaman o thread bir yerde db den sorgu çekerken vs beklerken beklemede kalır, dao tarafında beklemede kaldığı zaman
////Başka servisleri kullanamıyoruz o thread bitmeden fakat reactive programming sayesinde, bir istek atılır thread gider eğer block edecek
////bir olay var ise, beklemez başka servislere o thread üzerinden gidilir. Ve dao tarafından gelen isteğe göre tekrar şekillenir.
////Subscribe sayesinde ise client hızlı bir cevap döner başarılı oldu veya olmadı vs.
//
//@Component
//public class ReactiveLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//    private final BookRepository bookRepository;
//
//    public ReactiveLoader(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        getLoaderData();
//        System.out.println("Loading Bootstrap Data");
//    }
//
//    private void getLoaderData() {
//        Set<Book> bookSet = new HashSet<>();
//        Book bookCa = Book.builder().
//                author("Cem Akar")
//                .title("Yzlm Müh.")
//                .build();
//        Book bookBo = Book.builder().
//                author("Berk Öncü")
//                .title("Yzlm Müh.")
//                .build();
//
//        bookSet.add(bookCa);
//        bookSet.add(bookBo);
//
//        bookRepository.saveAll(bookSet);
//    }
//}