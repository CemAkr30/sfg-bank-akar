package ca.springframework.sfgbankakar.services.springdatajpa;


import static ca.springframework.sfgbankakar.defaults.BaseDefault.checkNull;

import ca.springframework.sfgbankakar.daoNativeQuery.QueryBuilder;
import ca.springframework.sfgbankakar.defaults.genUtils.GenUtilMap;
import ca.springframework.sfgbankakar.dto.BakiyeTransferDTO;
import ca.springframework.sfgbankakar.dto.MusteriDTO;
import ca.springframework.sfgbankakar.enums.Operator;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.model.Musteri;
import ca.springframework.sfgbankakar.model.TransferLog;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import ca.springframework.sfgbankakar.repositories.MusteriRepository;
import ca.springframework.sfgbankakar.repositories.TransferLogRepository;
import ca.springframework.sfgbankakar.services.MusteriService;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ca.springframework.sfgbankakar.enums.JoinType;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class MusteriServiceImpl implements MusteriService {


    @PersistenceContext
    private EntityManager  entityManager;

    /*
     @PersistenceContext -> Persistence Context, entity nesnelerini ve entity lifecycle (yaşam döngüsü) yöneten yapıdır.
     Veritabanı ve uygulama arasındadır. Persistence Context, entity nesnelerinin referanslarını tutar.
    *  entityManager.persist(Musteri.builder().bakiye(1000.0).hesapNo("123456789").ibanNo("TR123456789").build());
        Query query =  entityManager.createQuery("select m from Musteri m where m.bakiye > :paramBakiye");
        query.setParameter("paramBakiye",10060.00);
    * */

    private final MusteriRepository musteriRepository;

    private final KimlikRepository kimlikRepository;

    private final TransferLogRepository  transferLogRepository;

    public MusteriServiceImpl(MusteriRepository musteriRepository, KimlikRepository kimlikRepository, TransferLogRepository transferLogRepository, DirectExchange exchange, RabbitTemplate rabbitTemplate) {
        this.musteriRepository = musteriRepository;
        this.kimlikRepository = kimlikRepository;
        this.transferLogRepository = transferLogRepository;
        this.exchange = exchange;
        this.rabbitTemplate = rabbitTemplate;
    }

    private final DirectExchange exchange;

    private final RabbitTemplate rabbitTemplate;


    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingKey;

    @Value("${spring.rabbitmq.template.default-receive-queue}")
    private String queueName;



    @Override
    public Set<Musteri> findAll() {
        Set<Musteri> musteriSet  = new HashSet<>();
        musteriRepository.findAll().iterator().forEachRemaining(musteriSet::add);
        return musteriSet;
    }

    @Override
    public Musteri findById(Long aLong) {
        return musteriRepository.findById(aLong).orElse(null);
    }

    @Override
    public Musteri save(Musteri object) {
        return musteriRepository.save(object);
    }

    @Override
    public void delete(Musteri object) {
        musteriRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        musteriRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        musteriRepository.deleteAll();
    }

    @Override
    public Musteri findByHesapNo(String hesapNo) {
        return null;
    }

    @Override
    public Musteri findByIbanNo(String ibanNo) {
        return null;
    }

    @Override
    public List<MusteriDTO> getAllMusteri() {
      List<Musteri> musteriList =  new QueryBuilder<>().setEntityManager(entityManager)
                .createQueryFrom(Musteri.class,"t")
                .select("t")
                .join(Kimlik.class,"k","k = t.kimlik", JoinType.INNER_JOIN)
             // .where("t.bakiye", Operator.GRANDER_THAN_OR_EQUAL,10060.00)
                 .whereJpql("t.bakiye >= :paramBakiye")
                 .addExtraParam("paramBakiye",10060.00)
                .getResultClassList(Musteri.class)
                ;
//        List<Musteri> musteriList = musteriRepository.findAll();
        List<MusteriDTO> musteriDTO =  new GenUtilMap<MusteriDTO,Musteri>().pojoToListDto(new MusteriDTO(),musteriList);
        return musteriDTO;
    }

    @Override
    public MusteriDTO getMusteriById(Long id) {
        Optional<Musteri> musteri = musteriRepository.findById(id);
       MusteriDTO musteriDTO =  new GenUtilMap<MusteriDTO,Musteri>().pojoToDto(new MusteriDTO(),musteri.get());
        return musteriDTO;
    }

    @Override
    public MusteriDTO createNewMusteri(Long kimlikId,MusteriDTO musteriDTO) {
        Optional<Kimlik> kimlik = kimlikRepository.findById(kimlikId);
        if(!checkNull(kimlik)){
            musteriDTO.setKimlik(kimlik.get());
        }
        return saveAndReturnDTO(new  GenUtilMap<MusteriDTO,Musteri>().dtoToPojo(musteriDTO,new Musteri()));
    }

    private MusteriDTO saveAndReturnDTO(Musteri musteri) {
        Musteri savedMusteri = musteriRepository.save(musteri);
         MusteriDTO returnDto =new  GenUtilMap<MusteriDTO,Musteri>().pojoToDto(new MusteriDTO(),savedMusteri);
        return returnDto;
    }

    @Override
    public MusteriDTO patchMusteri(Long id, MusteriDTO musteriDTO) {
        return musteriRepository.findById(id)
                .map(musteri -> {
                    if(!checkNull(musteriDTO.getBakiye())){
                        musteri.setBakiye(musteriDTO.getBakiye());
                    }
                    if(!checkNull(musteriDTO.getHesapNo())){
                        musteri.setHesapNo(musteriDTO.getHesapNo());
                    }
                    if(!checkNull(musteriDTO.getIbanNo())){
                        musteri.setIbanNo(musteriDTO.getIbanNo());
                    }
                    if(!checkNull(musteriDTO.getKimlik())){
                        musteri.setKimlik(musteriDTO.getKimlik());
                    }
                        musteriRepository.save(musteri);
                    MusteriDTO musteriDTOreturn = new GenUtilMap<MusteriDTO,Musteri>().pojoToDto(new MusteriDTO(),musteri);
                    return musteriDTOreturn;
                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void transferBakiye(BakiyeTransferDTO bakiyeTransferDTO) {
       rabbitTemplate.convertAndSend(exchange.getName(), routingKey, bakiyeTransferDTO);
        // kuyruğa ekledikten sonra bu service thread kullanıcıya cevap dönecek ama arkada tarafda asenkron olarak
        // işleme devam edecek
    }

    @Transactional
    @RabbitListener(queues = "firstStepQueue")
    public void transferBakiyeMessage(BakiyeTransferDTO bakiyeTransferDTO){
        Optional<Musteri> musteriOptional = Optional.ofNullable(musteriRepository.findByIbanNo(bakiyeTransferDTO.getGonderecekIbanNo().toString()));
        musteriOptional.ifPresentOrElse(musteri -> {
            if(musteri.getBakiye()>bakiyeTransferDTO.getGonderilenBakiye()) {
                musteri.setBakiye(musteri.getBakiye() - bakiyeTransferDTO.getGonderilenBakiye());
                musteriRepository.save(musteri);
                rabbitTemplate.convertAndSend(exchange.getName(), "secondRoute", bakiyeTransferDTO);
                // exchange ve routing key kullanarak kuyruğa gönderiyoruz config dosyasında tanımladığımız
                // exchange sayesinde routing key buluyor ve bulduğu routing keyin kuyruğuna gönderiyor
                // guncelleGonderilenMusteriBakiye method da da gönderdiğimiz routing keye göre kuyruğu alıyoruz
                // asenkron şekilde işleme devam ediyoruz
            }
        }, () -> {
            throw new RuntimeException("Gönderen iban bulunamadı.");
        });
    }

    @RabbitListener(queues = "secondStepQueue")
    public void guncelleGonderilenMusteriBakiye(BakiyeTransferDTO bakiyeTransferDTO){
        Optional<Musteri> gonderilenMusteriOptional = Optional.ofNullable(musteriRepository.findByIbanNo(bakiyeTransferDTO.getGonderilenIbanNo()));
        gonderilenMusteriOptional.ifPresentOrElse(musteri -> {
            musteri.setBakiye(musteri.getBakiye() + bakiyeTransferDTO.getGonderilenBakiye());
            musteriRepository.save(musteri);
            rabbitTemplate.convertAndSend(exchange.getName(), "thirdStepRoute", bakiyeTransferDTO);
        }, () -> {
            System.out.println("Gönderilecek iban bulunamadı." );
            // gönderilecek iban yoksa gönderene geri gönderiyoruz bakiyeyi
            Optional<Musteri> musteriGonderenOptional = Optional.ofNullable(
                    musteriRepository.findByIbanNo(bakiyeTransferDTO.getGonderecekIbanNo())
            );
            musteriGonderenOptional.ifPresent(musteri -> {
                System.out.println("Gönderen ibana bakiye geri gönderiliyor.");
                musteri.setBakiye(musteri.getBakiye() + bakiyeTransferDTO.getGonderilenBakiye());
                musteriRepository.save(musteri);
            });
            throw new RuntimeException("Gönderilecek iban bulunamadı.");
        });
    }


    @RabbitListener(queues = "thirdStepQueue")
    public void transferLog(BakiyeTransferDTO bakiyeTransferDTO){
        Optional<Musteri> gonderenMusteriOptional = Optional.ofNullable(musteriRepository.findByIbanNo(bakiyeTransferDTO.getGonderecekIbanNo()));
        Optional<Musteri> gonderilenMusteriOptional = Optional.ofNullable(musteriRepository.findByIbanNo(bakiyeTransferDTO.getGonderilenIbanNo()));
        if(gonderenMusteriOptional.isPresent() && gonderilenMusteriOptional.isPresent()){
            TransferLog transferLog = new TransferLog();
            transferLog.setGonderenMusteri(gonderenMusteriOptional.get());
            transferLog.setGonderilenMusteri(gonderilenMusteriOptional.get());
            transferLog.setGonderilenBakiye(bakiyeTransferDTO.getGonderilenBakiye());
            transferLogRepository.save(transferLog);
        }
        gonderenMusteriOptional.ifPresent(musteri -> {
            gonderenMusteriOptional.ifPresent(musteri1 -> {
                String gonderenMusteri ="Sayın," + musteri1.getKimlik().getAdiSoyadi() + "\n Güncel Bakiyeniz:" +  musteri1.getBakiye();
                 System.out.println(gonderenMusteri);
            });
        });

        gonderilenMusteriOptional.ifPresent(musteri -> {
            String gonderilenMusteri ="Sayın," + musteri.getKimlik().getAdiSoyadi() + "\n Güncel Bakiyeniz:" +  musteri.getBakiye();
            System.out.println(gonderilenMusteri);
        });
//        rabbitTemplate.containerAckMode(AcknowledgeMode.AUTO);
    }

    @Override
    public void deleteMusteriById(Long id) {
        musteriRepository.deleteById(id);
    }
}
