package pizzamake;

import pizzamake.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    DeliveryRepository deliveryRepository;

//    @StreamListener(KafkaProcessor.INPUT)
//    public void onStringEventListener(@Payload String eventString){
//
//    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMade_Delivery(@Payload Made made){

        System.out.println("##### listener Delivery 1 : " + made.toJson());

        if(made.isMe()){
            System.out.println("##### listener Delivery 2 : " + made.toJson());
            Delivery delivery = new Delivery();
            delivery.setOrderId(made.getOrderId());
            delivery.setPizzaname(made.getPizzaname());
            delivery.setStatus(made.getStatus());
            deliveryRepository.save(delivery);
        }

    }



}
