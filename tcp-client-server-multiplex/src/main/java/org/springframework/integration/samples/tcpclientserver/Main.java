package org.springframework.integration.samples.tcpclientserver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.config.TcpOutboundChannelAdapterParser;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting server...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring" +
                "/integration" +
                "/tcpClientServerDemo-conversion-context.xml");

        DirectChannel dc= context.getBean("outbound", DirectChannel.class);
        int i = 0;
        while (true) {
            dc.send(new GenericMessage<>("Hello World \r\n" + i++));
            Thread.sleep(10);
        }
    }

    public static void run(String resp) {
        System.out.println("REPLY RECEIVED --- "+resp);
    }
}
