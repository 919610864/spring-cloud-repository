package com.eumji.stream.config.source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by eumji on 17-5-26.
 */
@EnableBinding(Source.class)
public class SourceModuleDefinition {

    private String format = "yyyy-MM-dd HH:mm:ss";

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "${fixedDelay}",maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource(){
        return () -> new GenericMessage<>(new SimpleDateFormat(this.format).format(new Date()));
    }
}
